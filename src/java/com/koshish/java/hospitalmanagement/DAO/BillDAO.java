/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.DAO;

import com.koshish.java.hospitalmanagement.Entity.Bill;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface BillDAO {
    
    public List<Bill> getAll();
    public Bill getById(int id);
    //id not required for inserting
    public int insert(Bill bill);
    public int delete(int id);
    //for update pass bill with id as well
    public int update(Bill bill);
}
