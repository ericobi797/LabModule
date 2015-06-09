package org.openmrs.module.LabM.api.db;

import org.openmrs.module.LabM.Results;

import java.util.List;

/**
 * Created by obiero on 6/9/2015.
 */
public interface ResultsDAO {
    List<Results> getAllResults();
    Results getResult(Integer resultId);
    Results saveResults(Results results);
    void purgeResult(Results results);
    Results updateResult(Results results);
}
