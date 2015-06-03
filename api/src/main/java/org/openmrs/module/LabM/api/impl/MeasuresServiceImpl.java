package org.openmrs.module.LabM.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.LabM.Measures;
import org.openmrs.module.LabM.api.MeasuresService;
import org.openmrs.module.LabM.api.db.MeasuresDAO;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
public class MeasuresServiceImpl extends BaseOpenmrsService implements MeasuresService {
    protected final Log log = LogFactory.getLog(this.getClass());



    private MeasuresDAO dao;

    public MeasuresDAO getDao() {
        return dao;
    }

    public void setDao(MeasuresDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Measures> getAllMeasures() {
        return null;
    }

    @Override
    public Measures getMeasure(Integer measureId) {
        return null;
    }

    @Override
    public Measures saveMeasure(Measures measures) {
        return null;
    }

    @Override
    public void purgeMeasure(Measures measures) {

    }

    @Override
    public Measures updateMeasure(Measures measures) {
        return null;
    }
}
