package org.openmrs.module.LabM;

import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

/**
 * Created by obiero on 6/3/2015.
 */
public class Measures extends BaseOpenmrsObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer tid;
    private Integer type;
    private String value;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
