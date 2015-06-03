package org.openmrs.module.LabM;

import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

/**
 * Created by obiero on 6/2/2015.
 */
public class LabTest extends BaseOpenmrsObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String testName;
    private String testDescription;
    private Integer measureId;
    private Integer labSection;
    private Double cost;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public Integer getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Integer measureId) {
        this.measureId = measureId;
    }

    public Integer getLabSection() {
        return labSection;
    }

    public void setLabSection(Integer labSection) {
        this.labSection = labSection;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


}
