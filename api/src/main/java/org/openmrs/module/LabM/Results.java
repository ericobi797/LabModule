package org.openmrs.module.LabM;

import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

/**
 * Created by obiero on 6/9/2015.
 */
public class Results extends BaseOpenmrsObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer patientId;
    private String dateTaken;
    private String result;
    private Integer status;
    private Integer specimenId;
    private Integer test;
    private String resultDate;
    private Specimen specimen;
    private LabTest labTest;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Integer specimenId) {
        this.specimenId = specimenId;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }
}
