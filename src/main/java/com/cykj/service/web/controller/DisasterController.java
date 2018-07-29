package com.cykj.service.web.controller;

import com.cykj.service.base.controller.BaseController;
import com.cykj.service.entity.Disasters;
import com.cykj.service.web.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/disaster")
public class DisasterController extends BaseController<Disasters>{

    @Autowired
    private DisasterService disasterService;

    @RequestMapping("/getDisaster")
    private String getDisaster(String address){
        return null;
    }

}
