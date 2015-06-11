package org.openmrs.module.LabM.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.LabM.LabSection;
import org.openmrs.module.LabM.LabTest;
import org.openmrs.module.LabM.api.LabSectionService;
import org.openmrs.module.LabM.api.LabTestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by obiero on 6/10/2015.
 */
@Controller
public class TestController {
    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/LabM/home", method = RequestMethod.GET)
    public void manage(ModelMap model) {
        String aa = "lala";
        model.addAttribute("allspecimen", aa);
    }

    @RequestMapping(value = "/module/LabM/test_catalog", method = RequestMethod.GET)
    public void testCatalog(ModelMap model){
        LabTestService labTestService = Context.getService(LabTestService.class);
        List<LabTest> labList = labTestService.getAllLabTest();
        LabSectionService labSectionService = Context.getService(LabSectionService.class);
        List<LabSection> sectionList = labSectionService.getAllLabSection();
        model.addAttribute("section", sectionList);
        model.addAttribute("testlist", labList);
    }
}
