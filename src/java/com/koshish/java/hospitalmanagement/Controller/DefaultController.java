/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Koshish Rijal
 */
@Controller
@RequestMapping(value="/")
public class DefaultController {
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String landingPage(){
       
        return "index";
    }
    @RequestMapping(value="/admin",method=RequestMethod.GET)
    public String adminHome(){       
        return "admin";
    }
    
    
}