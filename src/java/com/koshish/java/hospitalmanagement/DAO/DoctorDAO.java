/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.DAO;

import com.koshish.java.hospitalmanagement.Entity.Bill;
import com.koshish.java.hospitalmanagement.Entity.Doctor;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface DoctorDAO {
    public List<Doctor> getAll();
    public Doctor getByID(int id);
    public int insert(Doctor  doctor);
    public int delete(int id);
    //for update bill with id is required
    public int update(Doctor doctor);
    
}
