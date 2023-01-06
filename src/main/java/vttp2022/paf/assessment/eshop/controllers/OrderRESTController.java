package vttp2022.paf.assessment.eshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import vttp2022.paf.assessment.eshop.services.WarehouseService;

@RestController
@RequestMapping()
public class OrderRESTController {
    
    @Autowired
    private WarehouseService wSvc;

    @PostMapping(value="http://paf.chuklee.com/dispatch/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public JsonObject dispatch() {
        wSvc.dispatch(null);

        return null;
    }
    
}