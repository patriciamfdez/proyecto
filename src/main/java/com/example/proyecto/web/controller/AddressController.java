package com.example.proyecto.web.controller;

import com.example.proyecto.dto.AddressDTO;
import com.example.proyecto.service.AddressService;
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
public class AddressController extends AbstractController<AddressDTO>  {
    private final AddressService service;
    @Autowired
    protected AddressController(MenuService menuService, AddressService servicio) {
        super(menuService);
        this.service = servicio;
    }
    @GetMapping("/address")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        //final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final Page<AddressDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1,
                            size.orElse(10)));
        model
                //.addAttribute("username", user.getUserName())
                .addAttribute("address", all)
                .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        return "address/list";
    }

    @GetMapping("/address/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("address", this.service.findById(id).get());
        return "address/detail";
    }

    @GetMapping("/address/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("address", this.service.findById(id).get());
        return "address/edit";
    }

    @GetMapping("/address/create")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String create(ModelMap model) {
        final AddressDTO dto = new AddressDTO();
        model.addAttribute("address", dto);
        return "address/edit";
    }

    @Transactional
    @PostMapping(value = { "/address/{id}/edit", "/address/create" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String save(AddressDTO dto) {
        return String.format("redirect:/address/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/address/{id}/delete" })
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "address")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/address");
        }
        status.setComplete();
        return "redirect:/address";
    }
}
