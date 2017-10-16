/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.DAO;

import com.koshish.java.hospitalmanagement.Entity.Room;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface RoomDAO {
    public List<Room> getAll();
    public Room getById(int id);
    public int insert(Room room);
    public int delete(int id);
    //for updating room id should be passed in the room as well
    public int update(Room room);
}
