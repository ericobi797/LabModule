package org.openmrs.module.LabM.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.LabM.LabTest;
import org.openmrs.module.LabM.api.db.LabTestDAO;

import java.util.List;

/**
 * Created by obiero on 6/2/2015.
 */
public class HibernateLabTestDAO implements LabTestDAO {
    protected final Log log = LogFactory.getLog(this.getClass());

    private SessionFactory sessionFactory;

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public List<LabTest> getAllLabTest() {
        return sessionFactory.getCurrentSession().createCriteria(LabTest.class).list();
    }

    @Override
    public LabTest getLabTest(Integer labTestId) {
        return (LabTest) sessionFactory.getCurrentSession().get(LabTest.class, labTestId);
    }

    @Override
    public LabTest saveLabTest(LabTest labTest) {
        sessionFactory.getCurrentSession().save(labTest);
        return labTest;
    }

    @Override
    public void purgeLabTest(LabTest labTest) {
        sessionFactory.getCurrentSession().delete(labTest);
    }

    @Override
    public LabTest updateLabTest(LabTest labTest) {
        sessionFactory.getCurrentSession().update(labTest);
        return labTest;
    }
}
