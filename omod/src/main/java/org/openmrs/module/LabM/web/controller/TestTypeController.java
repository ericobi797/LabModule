package org.openmrs.module.LabM.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.LabM.LabSection;
import org.openmrs.module.LabM.Specimen;
import org.openmrs.module.LabM.api.LabSectionService;
import org.openmrs.module.LabM.api.SpecimenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by obiero on 6/9/2015.
 */
@Controller
public class TestTypeController {
    @RequestMapping(value = "/module/LabM/test_type", method = RequestMethod.GET)
    public void labSection(ModelMap model) {
        LabSectionService labSectionService = Context.getService(LabSectionService.class);
        List<LabSection> listSection = labSectionService.getAllLabSection();
        SpecimenService specimenService = Context.getService(SpecimenService.class);
        List<Specimen> specimenList = specimenService.getAllSpecimen();
        model.addAttribute("section", listSection);
        model.addAttribute("specimen", specimenList);
    }

    @RequestMapping(value ="/module/LabM/savetype", method=RequestMethod.POST)
    public String saveTestType(HttpSession httpSession, final HttpServletRequest request){
        int im = 0;
        String tname = request.getParameter("tname");
        String lsname = request.getParameter("lsname");
        String description = request.getParameter("description");
        String measure = request.getParameter("measure");
        String cost = request.getParameter("cost");
        if(measure == "option1"){
            String min = request.getParameter("min");
            String max = request.getParameter("max");
            im = 1;
        }else{
            String high = request.getParameter("high");
            String low = request.getParameter("low");
            String normal = request.getParameter("normal");
        }
        String sp = request.getParameter("splist");
        String[] spList = sp.split(",");
        return "redirect:lab_section.form";
    }
}
