package com.example.proyecto.web.controller;

import com.example.proyecto.dto.DaycareDTO;
import com.example.proyecto.dto.DogWalkerDTO;
import com.example.proyecto.service.DaycareService;
import com.example.proyecto.service.DogWalkerService;
import com.example.proyecto.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class DogWalkerController extends AbstractController<DogWalkerDTO>  {
    private final DogWalkerService service;
    @Autowired
    protected DogWalkerController(MenuService menuService, DogWalkerService servicio) {
        super(menuService);
        this.service = servicio;
    }
    @GetMapping("/dogwalker")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        //final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final Page<DogWalkerDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1,
                size.orElse(10)));
        model
                //.addAttribute("username", user.getUserName())
                .addAttribute("dogwalker", all)
                .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        return "dogwalker/list";
    }

    @GetMapping("/dogwalker/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("dogwalker", this.service.findById(id).get());
        return "dogwalker/detail";
    }

    @GetMapping("/dogwalker/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("dogwalker", this.service.findById(id).get());
        return "dogwalker/edit";
    }

    @GetMapping("/dogwalker/create")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String create(ModelMap model) {
        final DogWalkerDTO dto = new DogWalkerDTO();
        model.addAttribute("dogwalker", dto);
        return "dogwalker/edit";
    }

    @Transactional
    @PostMapping(value = { "/dogwalker/{id}/edit", "/dogwalker/create" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String save(DogWalkerDTO dto) {
        return String.format("redirect:/dogwalker/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/dogwalker/{id}/delete" })
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "dogwalker")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/dogwalker");
        }
        status.setComplete();
        return "redirect:/dogwalker";
    }
}
