package org.openmrs.module.LabM.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by obiero on 6/10/2015.
 */
@Controller
public class TestController {
    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/LabM/viewtest", method = RequestMethod.GET)
    public void manage(ModelMap model) {
        String aa = "lala";
        model.addAttribute("allspecimen", aa);
    }
}
