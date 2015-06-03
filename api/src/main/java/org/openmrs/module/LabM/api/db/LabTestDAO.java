package org.openmrs.module.LabM.api.db;

import org.openmrs.module.LabM.LabTest;

import java.util.List;

/**
 * Created by obiero on 6/2/2015.
 */
public interface LabTestDAO {
    List<LabTest> getAllLabTest();
    LabTest getLabTest(Integer labTestId);
    LabTest saveLabTest(LabTest labTest);
    void purgeLabTest(LabTest labTest);
    LabTest updateLabTest(LabTest labTest);
}
