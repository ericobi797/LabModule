package org.openmrs.module.LabM.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.LabM.Results;
import org.openmrs.module.LabM.api.db.ResultsDAO;

import java.util.List;

/**
 * Created by obiero on 6/9/2015.
 */
public class HibernateResultsDAO implements ResultsDAO {
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
    public List<Results> getAllResults() {
        return sessionFactory.getCurrentSession().createCriteria(Results.class).list();
    }

    @Override
    public Results getResult(Integer resultId) {
        return (Results) sessionFactory.getCurrentSession().get(Results.class, resultId);
    }

    @Override
    public Results saveResults(Results results) {
        sessionFactory.getCurrentSession().save(results);
        return results;
    }

    @Override
    public void purgeResult(Results results) {
        sessionFactory.getCurrentSession().delete(results);
    }

    @Override
    public Results updateResult(Results results) {
        sessionFactory.getCurrentSession().update(results);
        return results;
    }
}
