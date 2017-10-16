/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.Controller;

import com.koshish.java.hospitalmanagement.DAO.DiseaseDAO;
import com.koshish.java.hospitalmanagement.Entity.Disease;
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
@RequestMapping(value="/disease")
public class DiseaseController {
    @Autowired
    private DiseaseDAO diseaseDAO;
      
    @RequestMapping(method=RequestMethod.GET)   
    public String landingPage(Model model){
        model.addAttribute("diseaseList", diseaseDAO.getAll());
        return "disease";
    }
    @RequestMapping(value="/insert",method=RequestMethod.POST)
    @ResponseBody
    public String insert(@ModelAttribute("disease")Disease disease){
        diseaseDAO.insert(disease);
        return "inserted";
    }
     @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public String update(@ModelAttribute("disease") Disease disease){
        diseaseDAO.update(disease);
        return "updated in the database";
    }
    @RequestMapping(value="/delete/{diseaseId}",method=RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("diseaseId") int diseaseId ){
        diseaseDAO.delete(diseaseId);
        return "deleted";
    }
    
}
