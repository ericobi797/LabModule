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
package org.openmrs.module.LabM.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.LabM.Specimen;
import org.openmrs.module.LabM.api.SpecimenService;
import org.openmrs.module.LabM.api.db.SpecimenDAO;

import java.util.List;

/**
 * It is a default implementation of {@link SpecimenService}.
 */
public class SpecimenServiceImpl extends BaseOpenmrsService implements SpecimenService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SpecimenDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(SpecimenDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public SpecimenDAO getDao() {
	    return dao;
    }

    @Override
    public List<Specimen> getAllSpecimen(){
        return dao.getAllSpecimen();
    }

    @Override
    public Specimen getSpecimen(Integer specimenId){
        return dao.getSpecimen(specimenId);
    }

    @Override
    public Specimen saveSpecimen(Specimen specimen){
        return dao.saveSpecimen(specimen);
    }

    @Override
    public void purgeSpecimen(Specimen specimen){
        dao.purgeSpecimen(specimen);
    }

    @Override
    public Specimen updateSpecimen(Specimen specimen) {
        return dao.updateSpecimen(specimen);
    }
}