package org.openmrs.module.LabM.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.LabM.LabTest;
import org.openmrs.module.LabM.api.LabTestService;
import org.openmrs.module.LabM.api.db.LabTestDAO;

import java.util.List;

/**
 * Created by obiero on 6/2/2015.
 */
public class LabTestServiceImpl extends BaseOpenmrsService implements LabTestService{

    protected final Log log = LogFactory.getLog(this.getClass());

    private LabTestDAO dao;

    /**
     * @param dao the dao to set
     */
    public void setDao(LabTestDAO dao) {
        this.dao = dao;
    }

    /**
     * @return the dao
     */
    public LabTestDAO getDao() {
        return dao;
    }

    @Override
    public List<LabTest> getAllLabTest() {
        return dao.getAllLabTest();
    }

    @Override
    public LabTest getLabTest(Integer labTestId) {
        return dao.getLabTest(labTestId);
    }

    @Override
    public LabTest saveLabTest(LabTest labTest) {
        return dao.saveLabTest(labTest);
    }

    @Override
    public void purgeLabTest(LabTest labTest) {
        dao.purgeLabTest(labTest);
    }

    @Override
    public LabTest updateLabTest(LabTest labTest) {
        return dao.updateLabTest(labTest);
    }
}
