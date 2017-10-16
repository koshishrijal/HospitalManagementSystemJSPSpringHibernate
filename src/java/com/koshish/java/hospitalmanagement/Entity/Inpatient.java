/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Koshish Rijal
 */
@Entity
@Table(name = "tbl_inpatient", catalog = "hospital_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "Inpatient.findAll", query = "SELECT i FROM Inpatient i")})
public class Inpatient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inpatient_id")
    private Integer inpatientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "advance")
    private int advance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_admission")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfAdmission;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_discharge")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfDischarge;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Patient patient;
    @JoinColumn(name = "lab_report_id", referencedColumnName = "lab_report_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LabReport labReport;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Room room;

    public Inpatient() {
    }

    public Inpatient(Integer inpatientId) {
        this.inpatientId = inpatientId;
    }

    public Inpatient(Integer inpatientId, int advance, Date dateOfAdmission, Date dateOfDischarge) {
        this.inpatientId = inpatientId;
        this.advance = advance;
        this.dateOfAdmission = dateOfAdmission;
        this.dateOfDischarge = dateOfDischarge;
    }

    public Integer getInpatientId() {
        return inpatientId;
    }

    public void setInpatientId(Integer inpatientId) {
        this.inpatientId = inpatientId;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public Date getDateOfDischarge() {
        return dateOfDischarge;
    }

    public void setDateOfDischarge(Date dateOfDischarge) {
        this.dateOfDischarge = dateOfDischarge;
    }

    public Patient getPatientId() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LabReport getLabReport() {
        return labReport;
    }

    public void setLabReport(LabReport labReport) {
        this.labReport = labReport;
    }

    public Room getRoomId() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inpatientId != null ? inpatientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inpatient)) {
            return false;
        }
        Inpatient other = (Inpatient) object;
        if ((this.inpatientId == null && other.inpatientId != null) || (this.inpatientId != null && !this.inpatientId.equals(other.inpatientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.koshish.java.hospitalmanagement.Entity.Inpatient[ inpatientId=" + inpatientId + " ]";
    }
    
}
