package com.cloud.clinic.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.cloud.clinic.model.PatientHistory;
import com.cloud.clinic.model.PersonalDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * 
 * Retrieves the different pages of the form and returns it in JSON
 * 
 */

@SuppressWarnings("serial")
public class ReviewServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
				
		String page = req.getParameter("page");
		String id = req.getParameter("id");
		String date = req.getParameter("date");
		
		PatientDAO dao = new PatientDAO();
		Patient patient = dao.get(Integer.parseInt(id));
		
		if(patient == null){
			
			if(page.equalsIgnoreCase("SETUP"))
			{
				req.setAttribute("error", "No Patient Found");
				RequestDispatcher view = req.getRequestDispatcher("admin/Error.jsp");
				view.forward(req, resp);
			}
			
			resp.setContentType("text/plain");
			resp.getWriter().println("null_patient");
			return;
		}
		//Builds the object to create JSON objcts
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithModifiers();
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
		
		//Directs to review.jsp and builds date and sends Patient Details
		if(page.equalsIgnoreCase("SETUP")){
			List<Form> forms = patient.getForms();
			List<String> dates = new ArrayList<String>();
			for(int i = 0; i < forms.size(); i++)
			{
				if(forms.get(i) == null || forms.get(i).getTimestamp() == null)
					break;
				dates.add(sdf.format((forms.get(i).getTimestamp().getTime())));
			}
			req.setAttribute("dates", dates);
			req.setAttribute("id", id);
			RequestDispatcher view = req.getRequestDispatcher("admin/PatientReview.jsp");
			view.forward(req, resp);
		}
		
		Form f = null;
		//Try to find a form that matches the date provided
		if(date != null && date != ""){
			List<Form> forms = patient.getForms();
			for(int i = 0; i < forms.size() && f == null; i++)
			{
				Form temp = forms.get(i);
				if(temp == null || temp.getTimestamp() == null)
					break;
				String fDate = (sdf.format((temp.getTimestamp().getTime())));
				if(fDate.equals(date))
					f = temp;
			}
		} 
		
		if(f == null){
			f = dao.getMostRecentForm(patient);
		}
		
		if(f == null){
			resp.setContentType("text/plain");
			resp.getWriter().println("null_form");
			return;
		}
		
		switch(page) {
		case "DETAILS":
			//Gets the object
			PersonalDetails det = f.getPersonalDetails();
			//Specifically define the case number
			String case_num = f.getCase_number();
			String case_str = "\"case_number\":\""+case_num+"\"";
			//Convert the details obejct to JSON
			String details = gson.toJson(det);
			details = details.replaceFirst("\"gender\"", case_str + ",\"gender\"");
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(details);
			break;
		case "HISTORY":
			PatientHistory h = dao.loadHistory(f);
			String history = gson.toJson(h);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(history);
			break;
		case "GP_INFO":
			String info = gson.toJson(f.getGpInfo());
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(info);
			break;
		case "CONCERNS":
			String concerns = gson.toJson(f.getConcerns());
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(concerns);
			break;
		case "NEURO":
			String neuro = gson.toJson(f.getNeuroHistory());
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(neuro);
			break;
		case "EVENTS":
			String events = gson.toJson(dao.loadEventsActivities(f));
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(events);
			break;
		case "LIVING":
			String living = gson.toJson(f.getLivingSit());
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(living);
			break;
		case "LIFESTYLE":
			String lifestyle = gson.toJson(dao.loadLifestyle(f));
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(lifestyle);
			break;
		case "TESTS":
			String tests = gson.toJson(f.getTestBattery());
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(tests);
			break;
		case "ANALYSIS":
			String analysis = gson.toJson(dao.loadAnalysis(f));
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(analysis);
			break;
		default:
			resp.setContentType("text/plain");
			resp.getWriter().println("Invalid page");
			break;
		}
	}

}
