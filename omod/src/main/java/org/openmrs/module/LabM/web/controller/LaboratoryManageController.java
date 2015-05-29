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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String save(@RequestParam(value = "description", required = false) String desc,
					   @RequestParam(value = "sname", required = false) String name
	){
		SpecimenService specimenService = Context.getService(SpecimenService.class);
		Specimen specimen = new Specimen();
		specimen.setName(name);
		specimen.setDescription(desc);
      	specimenService.saveSpecimen(specimen);
		return "redirect:manage.form";
	}
}
