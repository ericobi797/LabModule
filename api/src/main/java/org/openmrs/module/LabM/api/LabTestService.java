package org.openmrs.module.LabM.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.LabM.LabTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by obiero on 6/2/2015.
 */
@Transactional
public interface LabTestService extends OpenmrsService {
    @Transactional(readOnly = true)
    List<LabTest> getAllLabTest();

    @Transactional(readOnly = true)
    LabTest getLabTest(Integer labTestId);

    LabTest saveLabTest(LabTest labTest);

    void purgeLabTest(LabTest labTest);

    LabTest updateLabTest(LabTest labTest);
}
