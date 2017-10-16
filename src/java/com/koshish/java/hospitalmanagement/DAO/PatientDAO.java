/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.DAO;

import com.koshish.java.hospitalmanagement.Entity.Patient;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface PatientDAO {
    public List<Patient> getAll();
    public int insert(Patient patient);
    public Patient getById(int id);
    public int delete(int id);
    public int update();
    
}
