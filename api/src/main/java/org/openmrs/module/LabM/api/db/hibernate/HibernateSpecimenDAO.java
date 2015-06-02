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
package org.openmrs.module.LabM.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.LabM.Specimen;
import org.openmrs.module.LabM.api.db.SpecimenDAO;

import java.util.List;

/**
 * It is a default implementation of  {@link SpecimenDAO}.
 */
public class HibernateSpecimenDAO implements SpecimenDAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }

	@Override
	public List<Specimen> getAllSpecimen(){
		return sessionFactory.getCurrentSession().createCriteria(Specimen.class).list();
	}

	@Override
	public Specimen getSpecimen(Integer specimenId){
		return (Specimen) sessionFactory.getCurrentSession().get(Specimen.class, specimenId);
	}

	@Override
	public Specimen saveSpecimen(Specimen specimen) {
		sessionFactory.getCurrentSession().save(specimen);
		return specimen;
	}

	@Override
	public void purgeSpecimen(Specimen specimen){
		sessionFactory.getCurrentSession().delete(specimen);
	}

	@Override
	public Specimen updateSpecimen(Specimen specimen) {
		sessionFactory.getCurrentSession().update(specimen);
		return specimen;
	}
}