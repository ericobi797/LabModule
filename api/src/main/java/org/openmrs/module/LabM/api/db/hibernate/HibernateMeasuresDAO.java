package org.openmrs.module.LabM.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.LabM.Measures;
import org.openmrs.module.LabM.api.db.MeasuresDAO;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
public class HibernateMeasuresDAO implements MeasuresDAO {
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
    public List<Measures> getAllMeasures() {
        return sessionFactory.getCurrentSession().createCriteria(Measures.class).list();
    }

    @Override
    public Measures getMeasure(Integer measureId) {
        return (Measures) sessionFactory.getCurrentSession().get(Measures.class, measureId);
    }

    @Override
    public Measures saveMeasure(Measures measures) {
        sessionFactory.getCurrentSession().save(measures);
        return measures;
    }

    @Override
    public void purgeMeasure(Measures measures) {
        sessionFactory.getCurrentSession().delete(measures);
    }

    @Override
    public Measures updateMeasure(Measures measures) {
        sessionFactory.getCurrentSession().update(measures);
        return measures;
    }
}
