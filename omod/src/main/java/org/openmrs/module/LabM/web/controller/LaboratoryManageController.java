/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.LabM.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.LabM.Specimen;
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
 * The main controller.
 */
@Controller
public class  LaboratoryManageController {
	
	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping(value = "/module/LabM/manage", method = RequestMethod.GET)
	public void manage(ModelMap model) {
		SpecimenService specimenService = Context.getService(SpecimenService.class);
		model.addAttribute("user", Context.getAuthenticatedUser());
		List<Specimen> specimenList = specimenService.getAllSpecimen();
		model.addAttribute("allspecimen", specimenList);
	}
	@RequestMapping("/module/LabM/savespecimen")
	public String save(HttpSession httpSession,
					   @RequestParam(value = "description", required = false) String desc,
					   @RequestParam(value = "sname", required = false) String name
	){
		try {
			SpecimenService specimenService = Context.getService(SpecimenService.class);
			Specimen specimen = new Specimen();
			specimen.setName(name);
			specimen.setDescription(desc);
			specimenService.saveSpecimen(specimen);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Registered Successfully");
			return "redirect:manage.form";
		} catch (Exception ex){
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, ex.getLocalizedMessage());
			return "redirect:manage.form";
		}
	}

	@RequestMapping(value ="/module/LabM/update", method = RequestMethod.GET)
	public String updateform(HttpSession httpSession,
							 @RequestParam(value = "id", required = false) int specimenId,
							 @RequestParam(value = "uname", required = false) String name,
							 @RequestParam(value = "description", required = false) String description) {
		try {
			SpecimenService specimenService = Context.getService(SpecimenService.class);
			Specimen specimen = new Specimen();
			specimen.setId(specimenId);
			specimen.setName(name);
			specimen.setDescription(description);
			specimenService.updateSpecimen(specimen);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Updated Successfully");
			return "redirect:manage.form";
		} catch (Exception ex) {
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, ex.getLocalizedMessage());
			return "redirect:manage.form";
		}
	}

	@RequestMapping(value ="/module/LabM/delete", method = RequestMethod.GET)
	public String deleteform(HttpSession httpSession,
							 @RequestParam(value = "id", required = false) int specimenId) {
		try {
			SpecimenService specimenService = Context.getService(SpecimenService.class);
			Specimen specimen = new Specimen();
			specimen.setId(specimenId);
			specimenService.purgeSpecimen(specimen);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Deleted Successfully");
			return "redirect:manage.form";
		} catch (Exception ex) {
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, ex.getLocalizedMessage());
			return "redirect:manage.form";
		}
	}


}
