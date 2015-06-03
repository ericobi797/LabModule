package org.openmrs.module.LabM.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.LabM.LabSection;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
@Transactional
public interface LabSectionService extends OpenmrsService{
    @Transactional(readOnly = true)
    List<LabSection> getAllLabSection();

    @Transactional(readOnly = true)
    LabSection getLabSection(Integer sectionId);

    LabSection saveLabSection(LabSection labSection);

    void purgeLabSection(LabSection labSection);

    LabSection updateLabSection(LabSection labSection);

}
