package org.openmrs.module.LabM.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.LabM.TestSpecimen;
import org.openmrs.module.LabM.api.db.TestSpecimenDAO;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
public class HibernateTestSpecimenDAO implements TestSpecimenDAO {
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
    public List<TestSpecimen> getAllTestSpecimen() {
        return sessionFactory.getCurrentSession().createCriteria(TestSpecimen.class).list();
    }

    @Override
    public TestSpecimen getTestSpecimen(Integer testSpecimenId) {
        return (TestSpecimen) sessionFactory.getCurrentSession().get(TestSpecimen.class, testSpecimenId);
    }

    @Override
    public TestSpecimen saveTestSpecimen(TestSpecimen testSpecimen) {
        sessionFactory.getCurrentSession().save(testSpecimen);
        return testSpecimen;
    }

    @Override
    public void purgeTestSpecimen(TestSpecimen testSpecimen) {
        sessionFactory.getCurrentSession().delete(testSpecimen);
    }
}
