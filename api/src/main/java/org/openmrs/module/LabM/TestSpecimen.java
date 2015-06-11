package org.openmrs.module.LabM;

import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

/**
 * Created by obiero on 6/3/2015.
 */
public class TestSpecimen extends BaseOpenmrsObject implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer tid;
    private Integer sid;
    private LabTest labTest;
    private Specimen specimen;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }
}
