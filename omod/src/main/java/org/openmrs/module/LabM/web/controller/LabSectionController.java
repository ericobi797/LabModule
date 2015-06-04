package org.openmrs.module.LabM.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.LabM.LabSection;
import org.openmrs.module.LabM.api.LabSectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by obiero on 6/4/2015.
 */
@Controller
public class LabSectionController {
    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/LabM/lab_section", method = RequestMethod.GET)
    public void labSection(ModelMap model) {
        LabSectionService labSectionService = Context.getService(LabSectionService.class);
        List<LabSection> listSection = labSectionService.getAllLabSection();
        model.addAttribute("listsection", listSection);
    }

    @RequestMapping(value ="/module/LabM/savelab", method = RequestMethod.POST)
    public String saveLabSection(HttpSession httpSession, @RequestParam(value = "lname", required = false) String labName,
                                 @RequestParam(value = "ldescription", required = false) String labDescription){
        LabSectionService labSectionService = Context.getService(LabSectionService.class);
        LabSection labSection = new LabSection();
        labSection.setSectionDescription(labDescription);
        labSection.setSectionName(labName);
        labSectionService.saveLabSection(labSection);
        List<LabSection> listSection = labSectionService.getAllLabSection();
        ModelMap model = new ModelMap();
        model.addAttribute("listsection", listSection);
        return "redirect:lab_section.form";
    }
}
