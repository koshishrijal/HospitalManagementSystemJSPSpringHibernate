/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.DAO.Impl;

import com.koshish.java.hospitalmanagement.DAO.DiseaseDAO;
import com.koshish.java.hospitalmanagement.Entity.Disease;
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
@Repository("diseaseDAO")
public class DiseaseDAOImpl implements DiseaseDAO {

    private List<Disease> diseaseList;
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Override
    public List<Disease> getAll() {
        session = sessionFactory.openSession();
        diseaseList = session.createQuery("from Disease").list();
        session.close();
        return diseaseList;
    }

    @Override
    public int insert(Disease disease) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        int result = (int) session.save(disease);
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public int delete(int id) {
        Disease disease = getById(id);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete(disease);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public Disease getById(int id) {
        session = sessionFactory.openSession();

        Disease disease = (Disease) session.get(Disease.class, id);

        session.close();
        return disease;

    }

    @Override
    public int update(Disease disease) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(disease);
        transaction.commit();
        session.close();
        return 1;

    }

}
