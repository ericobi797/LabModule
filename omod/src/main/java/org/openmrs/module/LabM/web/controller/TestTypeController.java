package org.openmrs.module.LabM.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.LabM.*;
import org.openmrs.module.LabM.api.*;
import org.openmrs.web.WebConstants;
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
        LabTestService labTestService = Context.getService(LabTestService.class);
        List<LabTest> testlist = labTestService.getAllLabTest();
        model.addAttribute("testlist", testlist);
        model.addAttribute("section", listSection);
        model.addAttribute("specimen", specimenList);
    }

    @RequestMapping(value ="/module/LabM/savetype", method=RequestMethod.POST)
    public String saveTestType(HttpSession httpSession, final HttpServletRequest request){
        String values;
        int measureType;
        String tname = request.getParameter("tname");
        int lsname = Integer.parseInt(request.getParameter("lsname"));
        String description = request.getParameter("description");
        String measure = request.getParameter("measure");
        double cost = Double.parseDouble(request.getParameter("cost"));
        int tat = Integer.parseInt(request.getParameter("tat"));
        if(measure.equals("option1")){
            String min = request.getParameter("min");
            String max = request.getParameter("max");
            values = min+","+max;
            measureType = 1;
        }else{
            measureType = 0;
            String high = request.getParameter("high");
            String low = request.getParameter("low");
            String normal = request.getParameter("normal");
            values = high+","+low+","+normal;
        }
        String sp = request.getParameter("splist");
        String[] spList = sp.split(",");
        try{
            LabTest labTest = new LabTest();
            labTest.setTestName(tname);
            labTest.setTestDescription(description);
            labTest.setCost(cost);
            LabSectionService labSectionService = Context.getService(LabSectionService.class);
            LabSection labSection = labSectionService.getLabSection(lsname);
            labTest.setLabSection(labSection);
            labTest.setTat(tat);
            Measures measures = new Measures();
            measures.setType(measureType);
            measures.setValue(values);
            measures.setLabTest(labTest);
            MeasuresService measuresService = Context.getService(MeasuresService.class);
            measuresService.saveMeasure(measures);


            for(String spl: spList){
                TestSpecimen testSpecimen = new TestSpecimen();
                TestSpecimenService testSpecimenService = Context.getService(TestSpecimenService.class);
                SpecimenService specimenService = Context.getService(SpecimenService.class);
                int sid = Integer.parseInt(spl);
                testSpecimen.setLabTest(labTest);
                Specimen specimen = specimenService.getSpecimen(sid);
                testSpecimen.setSpecimen(specimen);
                testSpecimenService.saveTestSpecimen(testSpecimen);
            }
            return "redirect:test_type.form";
        }catch (Exception ex){
            httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, ex.getLocalizedMessage());
            return "redirect:test_type.form";
        }

    }
}
