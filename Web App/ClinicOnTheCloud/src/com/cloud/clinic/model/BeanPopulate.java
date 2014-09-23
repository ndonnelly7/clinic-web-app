package com.cloud.clinic.model;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

/*
 * 
 * Attempts to populate a Java Bean from a Http Request
 * 
 */

public class BeanPopulate {
	public static void populateBean(Object formBean,
				HttpServletRequest request) {
		populateBean(formBean, request.getParameterMap());
	}

	@SuppressWarnings("unchecked")
	private static void populateBean(Object formBean,
			@SuppressWarnings("rawtypes") Map propertyMap) {
		try {
			DateTimeConverter converter = new DateConverter();
			converter.setPattern("dd/MM/yyyy");
			ConvertUtils.register(converter, java.util.Date.class);
			BeanUtils.populate(formBean, propertyMap);
		} catch (Exception e) {
			
		}
		
	}

}
