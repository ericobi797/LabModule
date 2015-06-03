package org.openmrs.module.LabM.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.LabM.LabSection;
import org.openmrs.module.LabM.api.db.LabSectionDAO;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
public class HibernateLabSectionDAO implements LabSectionDAO {

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
    public List<LabSection> getAllLabSection() {
        return sessionFactory.getCurrentSession().createCriteria(LabSection.class).list();
    }

    @Override
    public LabSection getLabSection(Integer sectionId) {
        return (LabSection) sessionFactory.getCurrentSession().get(LabSection.class, sectionId);
    }

    @Override
    public LabSection saveLabSection(LabSection labSection) {
        sessionFactory.getCurrentSession().save(labSection);
        return labSection;
    }

    @Override
    public void purgeLabSection(LabSection labSection) {
        sessionFactory.getCurrentSession().delete(labSection);
    }

    @Override
    public LabSection updateLabSection(LabSection labSection) {
        sessionFactory.getCurrentSession().update(labSection);
        return labSection;
    }
}
