package org.openmrs.module.LabM.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.LabM.LabSection;
import org.openmrs.module.LabM.LabTest;
import org.openmrs.module.LabM.Results;
import org.openmrs.module.LabM.Specimen;
import org.openmrs.module.LabM.api.LabSectionService;
import org.openmrs.module.LabM.api.LabTestService;
import org.openmrs.module.LabM.api.ResultsService;
import org.openmrs.module.LabM.api.SpecimenService;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by obiero on 6/10/2015.
 */
@Controller
public class TestController {
    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/LabM/home", method = RequestMethod.GET)
    public void manage(ModelMap model) {
        SpecimenService specimenService = Context.getService(SpecimenService.class);
        List<Specimen> specimenList = specimenService.getAllSpecimen();
        model.addAttribute("allspecimen", specimenList);
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

    @RequestMapping(value = "/module/LabM/tsdelete", method = RequestMethod.GET)
    public String deleteTest(HttpSession httpSession,
                             @RequestParam(value = "id", required = false) int tid){
        try{
            LabTest labTest = new LabTest();
            labTest.setId(tid);
            LabTestService labTestService = Context.getService(LabTestService.class);
            labTestService.purgeLabTest(labTest);
            httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Deleted Successfully");
            return "redirect:test_catalog.form";
        }catch (Exception ex){
            httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, ex.getLocalizedMessage());
            return "redirect:test_catalog.form";
        }
    }

    @RequestMapping(value="/module/LabM/updatetest")
    public String updateTest(HttpSession httpSession, @RequestParam(value = "tname", required = false) String tname,
                             @RequestParam(value = "testid", required = false) int testid,
                             @RequestParam(value="tdescription", required = false) String tdescription,
                             @RequestParam(value = "tcost", required = false) double tcost,
                             @RequestParam(value = "tat", required = false) int tat,
                             @RequestParam(value = "lsname", required = false) int lsname){
        try{
            LabTest labTest = new LabTest();
            labTest.setId(testid);
            labTest.setTestName(tname);
            labTest.setTestDescription(tdescription);
            labTest.setCost(tcost);
            labTest.setTat(tat);
            LabSectionService labSectionService = Context.getService(LabSectionService.class);
            LabSection labSection = labSectionService.getLabSection(lsname);
            labTest.setLabSection(labSection);
            LabTestService labTestService = Context.getService(LabTestService.class);
            labTestService.updateLabTest(labTest);
            httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Deleted Successfully");
            return "redirect:test_catalog.form";
        }catch(Exception ex){
            httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, ex.getLocalizedMessage());
            return "redirect:test_catalog.form";
        }
    }

    @RequestMapping(value="/module/LabM/register", method = RequestMethod.GET)
    public void register(ModelMap model){
        ResultsService resultsService = Context.getService(ResultsService.class);
        List<Results> results = resultsService.getAllResults();
        model.addAttribute("resultlist", results);
    }

    @RequestMapping(value="/module/LabM/results")
    public String result(HttpSession httpSession, @RequestParam(value = "rid", required = false) int rid,
                         @RequestParam(value = "result", required = false) String testResult,
                         @RequestParam(value = "ttid", required = false) int tid,
                         @RequestParam(value = "sid", required = false) int sname,
                         @RequestParam(value = "pid", required = false) int pid,
                         @RequestParam(value = "status", required = false) int status){
        ResultsService resultsService = Context.getService(ResultsService.class);
        Results results = new Results();
        results.setId(rid);
        results.setResult(testResult);
        results.setPatientId(pid);
        results.setStatus(status);
        LabTestService labTestService = Context.getService(LabTestService.class);
        LabTest labTest = labTestService.getLabTest(tid);
        SpecimenService specimenService = Context.getService(SpecimenService.class);
        Specimen specimen = specimenService.getSpecimen(sname);
        results.setLabTest(labTest);
        results.setSpecimen(specimen);
        resultsService.updateResult(results);
        return "redirect:register.form";
    }
}
