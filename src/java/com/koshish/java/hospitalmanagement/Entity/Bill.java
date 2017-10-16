/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Koshish Rijal
 */
@Entity
@Table(name = "tbl_bill", catalog = "hospital_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b")})
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_id")
    private Integer billId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lab_charge")
    private int labCharge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doctor_charge")
    private int doctorCharge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "advance")
    private int advance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "health_card_discount")
    private int healthCardDiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nursing_charge")
    private int nursingCharge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operation_charge")
    private int operationCharge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "medicine_charge")
    private int medicineCharge;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Room room;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Patient patient;

    public Bill() {
    }

    public Bill(Integer billId) {
        this.billId = billId;
    }

    public Bill(Integer billId, int labCharge, int doctorCharge, int advance, int healthCardDiscount, int nursingCharge, int operationCharge, int medicineCharge) {
        this.billId = billId;
        this.labCharge = labCharge;
        this.doctorCharge = doctorCharge;
        this.advance = advance;
        this.healthCardDiscount = healthCardDiscount;
        this.nursingCharge = nursingCharge;
        this.operationCharge = operationCharge;
        this.medicineCharge = medicineCharge;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public int getLabCharge() {
        return labCharge;
    }

    public void setLabCharge(int labCharge) {
        this.labCharge = labCharge;
    }

    public int getDoctorCharge() {
        return doctorCharge;
    }

    public void setDoctorCharge(int doctorCharge) {
        this.doctorCharge = doctorCharge;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public int getHealthCardDiscount() {
        return healthCardDiscount;
    }

    public void setHealthCardDiscount(int healthCardDiscount) {
        this.healthCardDiscount = healthCardDiscount;
    }

    public int getNursingCharge() {
        return nursingCharge;
    }

    public void setNursingCharge(int nursingCharge) {
        this.nursingCharge = nursingCharge;
    }

    public int getOperationCharge() {
        return operationCharge;
    }

    public void setOperationCharge(int operationCharge) {
        this.operationCharge = operationCharge;
    }

    public int getMedicineCharge() {
        return medicineCharge;
    }

    public void setMedicineCharge(int medicineCharge) {
        this.medicineCharge = medicineCharge;
    }

    public Room getRoomId() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billId != null ? billId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.billId == null && other.billId != null) || (this.billId != null && !this.billId.equals(other.billId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.koshish.java.hospitalmanagement.Entity.Bill[ billId=" + billId + " ]";
    }
    
}
