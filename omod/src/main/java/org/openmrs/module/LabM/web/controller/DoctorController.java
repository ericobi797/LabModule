package org.openmrs.module.LabM.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.LabM.LabTest;
import org.openmrs.module.LabM.Specimen;
import org.openmrs.module.LabM.api.LabTestService;
import org.openmrs.module.LabM.api.SpecimenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by obiero on 6/12/2015.
 */
@Controller
public class DoctorController {
    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/LabM/doctor", method = RequestMethod.GET)
    public void doc(ModelMap model) {
        List<Patient> allPatients = Context.getPatientService().getAllPatients();
        model.addAttribute("patientlist", allPatients);
        SpecimenService specimenService = Context.getService(SpecimenService.class);
        List<Specimen> specimenList = specimenService.getAllSpecimen();
        model.addAttribute("specimenlist", specimenList);
        LabTestService labTestService = Context.getService(LabTestService.class);
        List<LabTest> labList = labTestService.getAllLabTest();
        model.addAttribute("testlist", labList);
    }
}
