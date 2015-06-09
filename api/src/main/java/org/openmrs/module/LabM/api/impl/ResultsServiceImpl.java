package org.openmrs.module.LabM.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.LabM.Results;
import org.openmrs.module.LabM.api.ResultsService;
import org.openmrs.module.LabM.api.db.ResultsDAO;

import java.util.List;

/**
 * Created by obiero on 6/9/2015.
 */
public class ResultsServiceImpl extends BaseOpenmrsService implements ResultsService {
    protected final Log log = LogFactory.getLog(this.getClass());

    private ResultsDAO dao;

    public ResultsDAO getDao() {
        return dao;
    }

    public void setDao(ResultsDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Results> getAllResults() {
        return dao.getAllResults();
    }

    @Override
    public Results getResult(Integer resultId) {
        return dao.getResult(resultId);
    }

    @Override
    public Results saveResults(Results results) {
        return dao.saveResults(results);
    }

    @Override
    public void purgeResult(Results results) {
        dao.purgeResult(results);
    }

    @Override
    public Results updateResult(Results results) {
        return dao.updateResult(results);
    }
}
