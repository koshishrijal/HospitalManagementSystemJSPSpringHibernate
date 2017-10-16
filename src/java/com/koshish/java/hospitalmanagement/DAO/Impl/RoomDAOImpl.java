/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.DAO.Impl;

import com.koshish.java.hospitalmanagement.DAO.RoomDAO;
import com.koshish.java.hospitalmanagement.Entity.Room;
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
@Repository("roomDAO")
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private List<Room> roomList;

    @Override
    public List<Room> getAll() {
        session = sessionFactory.openSession();
        roomList = session.createQuery("from Room").list();
        session.close();
        return roomList;
    }

    @Override
    public Room getById(int id) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Room room = (Room) session.get(Room.class, id);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public int insert(Room room) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        int result = (int) session.save(room);
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public int delete(int id) {
        Room room = getById(id);
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        session.delete(room);
        transaction.commit();
        session.close();
        return 1;
    }
//for updating room object should be passed along with the id of the object room to be edited
    @Override
    public int update(Room room) {
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        session.update(room);
        transaction.commit();
        session.close();
        return 1;
    }

}
