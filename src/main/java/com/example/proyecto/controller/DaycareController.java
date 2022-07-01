package com.example.proyecto.controller;

import com.example.proyecto.dto.Daycare;
import com.example.proyecto.service.nursery.DaycareService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value= "/doggo/nursery", produces = APPLICATION_JSON_VALUE)
public class DaycareController {

    private final DaycareService service;

    public DaycareController(DaycareService service) {
        this.service = service;
    }

    @GetMapping()
    List<Daycare> listNursery(){
        return service.listNursery();
    }

    @GetMapping(value = "price/max/{priceMax}/min/{priceMin}")
    public List<Daycare> getNurseryPrice(@PathVariable String priceMax, @PathVariable String priceMin){

        return service.filterNurseryByPrice(priceMax, priceMin);
    }

 /*   @GetMapping(value = "/{id}")
    public Nursery getNursery(){

        return service.findById(id);
    }
//Poner el address que me llega por el IRL
    @GetMapping(value = "/{address}")
    public List<Nursery> getNurseryAddress(){

        return service.filterNurseryByAddress(String address);
    }
*/



    @PostMapping(value = "/create")
    public Daycare createNursery(){

        return null;
    }
}
