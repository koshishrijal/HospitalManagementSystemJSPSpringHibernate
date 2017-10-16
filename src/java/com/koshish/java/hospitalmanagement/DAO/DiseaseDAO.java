/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.DAO;

import com.koshish.java.hospitalmanagement.Entity.Disease;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface DiseaseDAO {
    public List<Disease> getAll();
    public int insert(Disease disease);
    public int delete(int id);
    public Disease getById(int id);
    //in update object should be passed with its id as well
    public int update(Disease disease);
    
}
