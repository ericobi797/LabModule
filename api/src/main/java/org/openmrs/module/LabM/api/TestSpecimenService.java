package org.openmrs.module.LabM.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.LabM.TestSpecimen;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
@Transactional
public interface TestSpecimenService extends OpenmrsService {
    @Transactional(readOnly = true)
    List<TestSpecimen> getAllTestSpecimen();

    @Transactional(readOnly = true)
    TestSpecimen getTestSpecimen(Integer testSpecimenId);

    TestSpecimen saveTestSpecimen(TestSpecimen testSpecimen);

    void purgeTestSpecimen(TestSpecimen testSpecimen);
}
