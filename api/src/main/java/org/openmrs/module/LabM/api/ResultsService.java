package org.openmrs.module.LabM.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.LabM.Results;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by obiero on 6/9/2015.
 */
@Transactional
public interface ResultsService extends OpenmrsService {
    @Transactional(readOnly = true)
    List<Results> getAllResults();

    @Transactional(readOnly = true)
    Results getResult(Integer resultId);

    Results saveResults(Results results);

    void purgeResult(Results results);

    Results updateResult(Results results);
}

