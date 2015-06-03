package org.openmrs.module.LabM.api.db;

import org.openmrs.module.LabM.LabSection;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
public interface LabSectionDAO {
    List<LabSection> getAllLabSection();
    LabSection getLabSection(Integer sectionId);
    LabSection saveLabSection(LabSection labSection);
    void purgeLabSection(LabSection labSection);
    LabSection updateLabSection(LabSection labSection);
}
