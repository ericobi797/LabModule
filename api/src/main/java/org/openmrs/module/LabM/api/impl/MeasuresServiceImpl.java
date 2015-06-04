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
        return dao.getAllMeasures();
    }

    @Override
    public Measures getMeasure(Integer measureId) {
        return dao.getMeasure(measureId);
    }

    @Override
    public Measures saveMeasure(Measures measures) {
        return dao.saveMeasure(measures);
    }

    @Override
    public void purgeMeasure(Measures measures) {
        dao.purgeMeasure(measures);
    }

    @Override
    public Measures updateMeasure(Measures measures) {
        return dao.updateMeasure(measures);
    }
}
