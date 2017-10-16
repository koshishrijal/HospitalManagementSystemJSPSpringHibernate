/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.Controller;

import com.koshish.java.hospitalmanagement.DAO.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Koshish Rijal
 */
@Controller
@RequestMapping( value="/patient")
public class PatientController {
    @Autowired
    private PatientDAO patientDAO;
    
    @RequestMapping(method=RequestMethod.GET)
    private String landingPage(Model model){
        model.addAttribute("patientList",patientDAO.getAll());
        return "patient";
    }
    
}
