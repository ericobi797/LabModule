package org.openmrs.module.LabM.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.LabM.Measures;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
@Transactional
public interface MeasuresService extends OpenmrsService {
    @Transactional(readOnly = true)
    List<Measures> getAllMeasures();

    @Transactional(readOnly = true)
    Measures getMeasure(Integer measureId);

    Measures saveMeasure(Measures measures);

    void purgeMeasure(Measures measures);

    Measures updateMeasure(Measures measures);
}
