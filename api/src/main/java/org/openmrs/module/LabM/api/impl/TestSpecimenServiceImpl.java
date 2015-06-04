package org.openmrs.module.LabM.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.LabM.TestSpecimen;
import org.openmrs.module.LabM.api.TestSpecimenService;
import org.openmrs.module.LabM.api.db.TestSpecimenDAO;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
public class TestSpecimenServiceImpl extends BaseOpenmrsService implements TestSpecimenService {
    protected final Log log = LogFactory.getLog(this.getClass());



    private TestSpecimenDAO dao;

    public TestSpecimenDAO getDao() {
        return dao;
    }

    public void setDao(TestSpecimenDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<TestSpecimen> getAllTestSpecimen() {
        return dao.getAllTestSpecimen();
    }

    @Override
    public TestSpecimen getTestSpecimen(Integer testSpecimenId) {
        return dao.getTestSpecimen(testSpecimenId);
    }

    @Override
    public TestSpecimen saveTestSpecimen(TestSpecimen testSpecimen) {
        return dao.saveTestSpecimen(testSpecimen);
    }

    @Override
    public void purgeTestSpecimen(TestSpecimen testSpecimen) {
        dao.purgeTestSpecimen(testSpecimen);
    }
}
