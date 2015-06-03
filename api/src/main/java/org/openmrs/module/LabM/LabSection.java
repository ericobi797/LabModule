package org.openmrs.module.LabM;

import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

/**
 * Created by obiero on 6/2/2015.
 */
public class LabSection extends BaseOpenmrsObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String sectionName;

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    private String sectionDescription;
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
