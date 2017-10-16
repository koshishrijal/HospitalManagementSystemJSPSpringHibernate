/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hospitalmanagement.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Koshish Rijal
 */
@Entity
@Table(name = "tbl_lab_report", catalog = "hospital_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "LabReport.findAll", query = "SELECT l FROM LabReport l")})
public class LabReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lab_report_id")
    private Integer labReportId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_report")
    private int dateOfReport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Patient patient;
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Doctor doctor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "labReport", fetch = FetchType.LAZY)
    private List<Inpatient> inpatientList;

    public LabReport() {
    }

    public LabReport(Integer labReportId) {
        this.labReportId = labReportId;
    }

    public LabReport(Integer labReportId, int dateOfReport, int amount) {
        this.labReportId = labReportId;
        this.dateOfReport = dateOfReport;
        this.amount = amount;
    }

    public Integer getLabReportId() {
        return labReportId;
    }

    public void setLabReportId(Integer labReportId) {
        this.labReportId = labReportId;
    }

    public int getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(int dateOfReport) {
        this.dateOfReport = dateOfReport;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatientId(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Inpatient> getInpatientList() {
        return inpatientList;
    }

    public void setInpatientList(List<Inpatient> inpatientList) {
        this.inpatientList = inpatientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labReportId != null ? labReportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabReport)) {
            return false;
        }
        LabReport other = (LabReport) object;
        if ((this.labReportId == null && other.labReportId != null) || (this.labReportId != null && !this.labReportId.equals(other.labReportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.koshish.java.hospitalmanagement.Entity.LabReport[ labReportId=" + labReportId + " ]";
    }
    
}
