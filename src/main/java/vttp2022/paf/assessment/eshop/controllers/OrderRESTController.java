package vttp2022.paf.assessment.eshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.paf.assessment.eshop.services.WarehouseService;

@RestController
@RequestMapping()
public class OrderRESTController {
    
    @Autowired
    private WarehouseService warehouseService;

    public static String dispatch() {
        return null;
    }
    
}