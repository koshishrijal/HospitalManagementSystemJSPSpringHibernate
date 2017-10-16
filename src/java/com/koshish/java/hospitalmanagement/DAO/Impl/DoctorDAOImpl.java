/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.DAO.Impl;

import com.koshish.java.hospitalmanagement.DAO.DoctorDAO;
import com.koshish.java.hospitalmanagement.Entity.Bill;
import com.koshish.java.hospitalmanagement.Entity.Doctor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Koshish Rijal
 */
@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private List<Doctor> doctorList;
    private Session session;
    private Transaction transaction;

    @Override
    public List<Doctor> getAll() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        doctorList = session.createQuery(" from Doctor").list();
        transaction.commit();
        session.close();
        return doctorList;
    }

    @Override
    public Doctor getByID(int id) {
        session = sessionFactory.openSession();
        Doctor doctor = (Doctor) session.get(Doctor.class, id);
        session.close();
        return doctor;
    }

    @Override
    public int insert(Doctor doctor) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        int id = (int) session.save(doctor);
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public int delete(int id) {
        Doctor doctor = getByID(id);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete(doctor);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int update(Doctor doctor) {
        session = sessionFactory.openSession();
        transaction=session.beginTransaction();
        session.update(doctor);
        transaction.commit();
        session.close();
        return 1;
    }

}
