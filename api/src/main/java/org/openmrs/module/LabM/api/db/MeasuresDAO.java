package org.openmrs.module.LabM.api.db;

import org.openmrs.module.LabM.Measures;

import java.util.List;

/**
 * Created by obiero on 6/3/2015.
 */
public interface MeasuresDAO {
    List<Measures> getAllMeasures();
    Measures getMeasure(Integer measureId);
    Measures saveMeasure(Measures measures);
    void purgeMeasure(Measures measures);
    Measures updateMeasure(Measures measures);
}
