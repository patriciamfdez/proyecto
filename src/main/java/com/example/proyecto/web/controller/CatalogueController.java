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

    /* Procedimientos almacenados:
                - Alta catálogo
                - Borrado lógico
                - Restaurado lógico
     */

    @GetMapping("/catalogue/alta")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String alta(){
        this.service.ActualizarCatalogo();
        return "redirect:/catalogue";
    }
    @GetMapping("/catalogue/borradologico/{id}/{servicio}")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String borradologico(@PathVariable("id") Integer id,@PathVariable("servicio") String serv ){
        this.service.BorradoLogicoCatalogo(id,serv);
        return "redirect:/catalogue";
    }
    @GetMapping("/catalogue/restauradologico/{id}/{servicio}")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String restauradologico(@PathVariable("id") Integer id,@PathVariable("servicio") String serv ){
        this.service.RestauradoLogicoCatalogo(id,serv);
        return "redirect:/catalogue";
    }


}
