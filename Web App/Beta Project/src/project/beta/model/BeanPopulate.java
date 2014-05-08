package project.beta.model;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;


public class BeanPopulate {
	public static void populateBean(Object formBean,
				HttpServletRequest request) {
		populateBean(formBean, request.getParameterMap());
	}

	private static void populateBean(Object formBean,
			Map propertyMap) {
		try {
			DateTimeConverter converter = new DateConverter();
			converter.setPattern("dd/MMMM/yyyy");
			ConvertUtils.register(converter, java.util.Date.class);
			BeanUtils.populate(formBean, propertyMap);
		} catch (Exception e) {
			
		}
		
	}

}
