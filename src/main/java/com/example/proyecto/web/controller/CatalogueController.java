package com.example.proyecto.web.controller;

import com.example.proyecto.data.entity.User;
import com.example.proyecto.dto.CatalogueDTO;
import com.example.proyecto.service.CatalogueService;
import com.example.proyecto.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class CatalogueController extends AbstractController<CatalogueDTO>  {
    private final CatalogueService service;
    @Autowired
    protected CatalogueController(MenuService menuService, CatalogueService servicio) {
        super(menuService);
        this.service = servicio;
    }
    @GetMapping("/catalogue")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        Integer userConnected = 0;
        User user  = new User();
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            //No hay usuario conectado
            userConnected = 1;
            user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }

        final Page<CatalogueDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1,
                size.orElse(10)));
        model
                .addAttribute("username", user.getUserName())
                .addAttribute("conectado",userConnected)
                .addAttribute("catalogue", all)
                .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        return "catalogue/list";
    }

    @GetMapping("/catalogue/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("catalogue", this.service.findById(id).get());
        return "catalogue/detail";
    }

    @GetMapping("/catalogue/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("catalogue", this.service.findById(id).get());
        return "catalogue/edit";
    }

    @GetMapping("/catalogue/create")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String create(ModelMap model) {
        final CatalogueDTO dto = new CatalogueDTO();
        model.addAttribute("catalogue", dto);
        return "catalogue/edit";
    }

    @Transactional
    @PostMapping(value = { "/catalogue/{id}/edit", "/catalogue/create" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String save(CatalogueDTO dto) {
        return String.format("redirect:/catalogue/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/catalogue/{id}/delete" })
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "catalogue")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/catalogue");
        }
        status.setComplete();
        return "redirect:/catalogue";
    }

    //Alta catálogo
    /*  DUDAS: seguro que no devuelve nada? Lo que hace el método es comprobar si el id esta ya registrado,
      y si no lo registra. Pero en el caso que vimos con JM, lo hacía con TODOS los nuevos. Si yo quiero que lo haga uno a uno
      (con la idea de poner un botón en cada elemento nuevo), tendré que pasarle los parámetros de servicetyoe y de id_producto.

      OTRA: No devuelve nada la función? Podría retornar a catálogo para ver lo que se ha agregado, o que simplemente el botón se volviera inactivo.
      O que saliese un texto que diga "agregado", pero esto es todo del HTML

      OTRA: qué clase de método es alta? un string o un object? Dado que aquñí no devuelve nada
      SI que devuelve, devuelve la dirección, una url, por eso es tipo String
      Otra opción es que sea un tipo OPBJECT porque puede devolver un error.

     */
//    @PostMapping("/catalogue/alta")
//    @PostAuthorize("hasRole('ROLE_ADMIN') ")
//    public Object alta(){
//        this.service.alta();
//        return "redirect:/catalogue";
//    }
    @Transactional
    @PostMapping("/catalogue/alta")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public Object alta(SessionStatus status) {
        try {
            this.service.alta();
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityName", "catalogue")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/catalogue");
        }
        status.setComplete();
        return "redirect:/catalogue";
    }

}
