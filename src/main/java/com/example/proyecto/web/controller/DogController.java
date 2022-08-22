package com.example.proyecto.web.controller;

import com.example.proyecto.dto.DogDTO;
import com.example.proyecto.service.DogService;
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
public class DogController extends AbstractController<DogDTO>  {
    private final DogService service;
    @Autowired
    protected DogController(MenuService menuService, DogService servicio) {
        super(menuService);
        this.service = servicio;
    }
    @GetMapping("/dog")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        //final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final Page<DogDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1,
                            size.orElse(10)));
        model
                //.addAttribute("username", user.getUserName())
                .addAttribute("dog", all)
                .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        return "dog/list";
    }

    @GetMapping("/dog/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("dog", this.service.findById(id).get());
        return "dog/detail";
    }

    @GetMapping("/dog/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("dog", this.service.findById(id).get());
        return "dog/edit";
    }

    @GetMapping("/dog/create")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String create(ModelMap model) {
        final DogDTO dto = new DogDTO();
        model.addAttribute("dog", dto);
        return "dog/edit";
    }

    @Transactional
    @PostMapping(value = { "/dog/{id}/edit", "/dog/create" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String save(DogDTO dto) {
        return String.format("redirect:/dog/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/dog/{id}/delete" })
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "dog")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/dog");
        }
        status.setComplete();
        return "redirect:/dog";
    }
}
