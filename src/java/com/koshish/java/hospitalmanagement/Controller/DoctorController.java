/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.Controller;

import com.koshish.java.hospitalmanagement.DAO.DiseaseDAO;
import com.koshish.java.hospitalmanagement.DAO.DoctorDAO;
import com.koshish.java.hospitalmanagement.Entity.Doctor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Koshish Rijal
 */
@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorDAO doctorDAO;
    private List<Doctor> doctorList;
    @Autowired
    private DiseaseDAO diseaseDAO;

    @RequestMapping(method = RequestMethod.GET)
    private String landingPage(Model model) {
        model.addAttribute("doctorList", doctorDAO.getAll());
        model.addAttribute("diseaseList", diseaseDAO.getAll());
        return "doctor";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    private String insert(@ModelAttribute("Doctor") Doctor doctor) {
        doctorDAO.insert(doctor);
        return "successfuly inserted";
    }
    @RequestMapping(value="/delete/{doctorId}",method=RequestMethod.DELETE)
    @ResponseBody
    private String delete(@PathVariable("doctorId") int doctorId){
        doctorDAO.delete(doctorId);
        return "deleted";
    }
    
    //doctor should be passed with id as well
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    private String update(@ModelAttribute("doctor") Doctor doctor){
        doctorDAO.update(doctor);
        return "updated";
    }

}
