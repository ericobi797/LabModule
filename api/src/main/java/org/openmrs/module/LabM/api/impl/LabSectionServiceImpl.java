package org.openmrs.module.LabM.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.LabM.LabSection;
import org.openmrs.module.LabM.api.LabSectionService;
import org.openmrs.module.LabM.api.db.LabSectionDAO;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
public class LabSectionServiceImpl extends BaseOpenmrsService implements LabSectionService {
    protected final Log log = LogFactory.getLog(this.getClass());

    private LabSectionDAO dao;

    /**
     * @param dao the dao to set
     */
    public void setDao(LabSectionDAO dao) {
        this.dao = dao;
    }

    /**
     * @return the dao
     */
    public LabSectionDAO getDao() {
        return dao;
    }

    @Override
    public List<LabSection> getAllLabSection() {
        return dao.getAllLabSection();
    }

    @Override
    public LabSection getLabSection(Integer sectionId) {
        return dao.getLabSection(sectionId);
    }

    @Override
    public LabSection saveLabSection(LabSection labSection) {
        return dao.saveLabSection(labSection);
    }

    @Override
    public void purgeLabSection(LabSection labSection) {
        dao.purgeLabSection(labSection);
    }

    @Override
    public LabSection updateLabSection(LabSection labSection) {
        return dao.updateLabSection(labSection);
    }
}
