package org.openmrs.module.LabM.api.db;

import org.openmrs.module.LabM.TestSpecimen;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
public interface TestSpecimenDAO {
    List<TestSpecimen> getAllTestSpecimen();
    TestSpecimen getTestSpecimen(Integer testSpecimenId);
    TestSpecimen saveTestSpecimen(TestSpecimen testSpecimen);
    void purgeTestSpecimen(TestSpecimen testSpecimen);
}
