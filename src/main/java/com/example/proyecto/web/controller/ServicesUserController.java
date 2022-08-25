package com.example.proyecto.web.controller;

import com.example.proyecto.data.entity.Catalogue;
import com.example.proyecto.dto.CatalogueDTO;
import com.example.proyecto.dto.DaycareDTO;
import com.example.proyecto.dto.ServicesUserDTO;
import com.example.proyecto.service.CatalogueService;
import com.example.proyecto.service.MenuService;
import com.example.proyecto.service.ServicesUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class ServicesUserController extends AbstractController<ServicesUserDTO>  {
    private final ServicesUserService service;
    private final CatalogueService catalogueService;
    @Autowired
    protected ServicesUserController(MenuService menuService, ServicesUserService servicio, CatalogueService catalogueService) {
        super(menuService);
        this.service = servicio;
        this.catalogueService = catalogueService;
    }
    @GetMapping("/servicesuser")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        //final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final Page<ServicesUserDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1,
                            size.orElse(10)));
        model
                //.addAttribute("username", user.getUserName())
                .addAttribute("servicesuser", all)
                .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        return "servicesuser/list";
    }

    @GetMapping("/servicesuser/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("servicesuser", this.service.findById(id).get());
        return "servicesuser/detail";
    }

    @GetMapping("/servicesuser/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("servicesuser", this.service.findById(id).get());
        return "servicesuser/edit";
    }

    @GetMapping("/servicesuser/createresidencias")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String createresidencias(ModelMap model,@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        final ServicesUserDTO dto = new ServicesUserDTO();
        final Page<CatalogueDTO> catalog = this.catalogueService.findByServiceType("daycare",PageRequest.of(page.orElse(1) - 1, size.orElse(10)));
        model
                .addAttribute("servicesuser", dto)
                .addAttribute("catalogue", catalog);
        return "servicesuser/edit";
    }

    @GetMapping("/servicesuser/createpaseadores")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String createpaseadores(ModelMap model,@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        final ServicesUserDTO dto = new ServicesUserDTO();
        // Enviar el catálogo como atributo para seleccionar un elemento
        final Page<CatalogueDTO> catalog = this.catalogueService.findByServiceType("dogwalker", PageRequest.of(page.orElse(1) - 1, size.orElse(10)));
        model.addAttribute("servicesuser", dto);
        model.addAttribute("catalogue", catalog);
        return "servicesuser/edit";
    }

    @Transactional
    @PostMapping(value = { "/servicesuser/{id}/edit", "/servicesuser/createresidencias", "/servicesuser/createpaseadores" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String save(ServicesUserDTO dto) {
        return String.format("redirect:/servicesuser/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/servicesuser/{id}/delete" })
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "servicesuser")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/servicesuser");
        }
        status.setComplete();
        return "redirect:/servicesuser";
    }
}
