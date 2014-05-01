package project.beta;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beta.model.BeanPopulate;
import project.beta.model.DrugHistory;
import project.beta.model.MedHistory;
import project.beta.model.Patient;
import project.beta.model.PatientDAO;
import project.beta.model.PatientHistory;
import project.beta.model.PsychHistory;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class HistoryServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);
		
		PatientHistory pHistory = new PatientHistory();
		BeanPopulate.populateBean(pHistory, req);
		
		pHistory.setMed_histories(loadMedsList(req, pHistory));
		pHistory.setMed_collat_histories(loadMedsCollatList(req, pHistory));
		
		pHistory.setDrug_histories(loadDrugsList(req, pHistory));
		pHistory.setDrug_collat_histories(loadDrugsCollatList(req, pHistory));
		
		pHistory.setPsych_histories(loadPsychList(req, pHistory));
		pHistory.setPsych_collat_histories(loadPsychCollatList(req, pHistory));
		
		pat.setPatientHistory(pHistory);
		dao.update(pat);

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/jsp/medical.jsp");
		view.forward(req, resp);
	}
	
	
	public ArrayList<MedHistory> loadMedsList(HttpServletRequest req, PatientHistory pH){
		ArrayList<MedHistory> meds = new ArrayList<MedHistory>();
		String[] names = req.getParameterValues("med_histories");
		String[] times = req.getParameterValues("med_time");
		String[] notes = req.getParameterValues("medical_notes");
		for(int i = 0; i < names.length; i++){
			if(!(names[i].equalsIgnoreCase("none_selected"))){
				MedHistory med = new MedHistory();
				med.setCondition(names[i]);
				med.setTime(times[i]);
				med.setNotes(notes[i]);
				med.setpHistory(pH);
				meds.add(med);
			}
		}
		
		return meds;
	}
	
	public ArrayList<DrugHistory> loadDrugsList(HttpServletRequest req, PatientHistory pH){
		ArrayList<DrugHistory> drugs = new ArrayList<DrugHistory>();
		String[] names = req.getParameterValues("drug_histories");
		String[] time = req.getParameterValues("drug_time");
		String[] notes = req.getParameterValues("drug_notes");
		String[] sleeping_drugs = req.getParameterValues("sleeping_drug");
		String[] benzo_drugs = req.getParameterValues("benzo_drug");
		int sleepIndex = 0;
		int benzoIndex = 0;
		
		for(int i = 0; i < names.length; i++){
			if(!(names[i].equalsIgnoreCase("none_selected"))){
				DrugHistory drug = new DrugHistory();
				drug.setDrug(names[i]);
				drug.setTime(time[i]);
				drug.setNotes(notes[i]);
				if(drug.getDrug().equalsIgnoreCase("sleeping")){
					drug.setSleep_med(sleeping_drugs[sleepIndex]);
					sleepIndex++;
				} else if(drug.getDrug().equalsIgnoreCase("benzo")){
					drug.setBenzo_med(benzo_drugs[benzoIndex]);
					benzoIndex++;
				}
				drug.setpHistory(pH);
				drugs.add(drug);
			}
		}		
		return drugs;
	}
	
	public ArrayList<PsychHistory> loadPsychList(HttpServletRequest req, PatientHistory pH){
		ArrayList<PsychHistory> psychs = new ArrayList<PsychHistory>();
		String[] names = req.getParameterValues("psych_histories");
		String[] times = req.getParameterValues("psych_time");
		String[] notes = req.getParameterValues("psych_notes");
		
		for(int i = 0; i < names.length; i++){
			if(!(names[i].equalsIgnoreCase("none_selected"))){
				PsychHistory psych = new PsychHistory();
				psych.setPsych(names[i]);
				psych.setTime(times[i]);
				psych.setNotes(notes[i]);
				psych.setpHistory(pH);
				psychs.add(psych);
			}
		}		
		return psychs;
	}
	
	public ArrayList<MedHistory> loadMedsCollatList(HttpServletRequest req, PatientHistory pH){
		ArrayList<MedHistory> meds = new ArrayList<MedHistory>();
		String[] names = req.getParameterValues("med_collat_histories");
		String[] times = req.getParameterValues("med_collat_time");
		String[] notes = req.getParameterValues("medical_collat_notes");
		for(int i = 0; i < names.length; i++){
			if(!(names[i].equalsIgnoreCase("none_selected"))){
				MedHistory med = new MedHistory();
				med.setCondition(names[i]);
				med.setTime(times[i]);
				med.setNotes(notes[i]);
				med.setpHistory(pH);
				meds.add(med);
			}
		}
		
		return meds;
	}
	
	public ArrayList<DrugHistory> loadDrugsCollatList(HttpServletRequest req, PatientHistory pH){
		ArrayList<DrugHistory> drugs = new ArrayList<DrugHistory>();
		String[] names = req.getParameterValues("drug_collat_histories");
		String[] time = req.getParameterValues("drug_collat_time");
		String[] notes = req.getParameterValues("drug_collat_notes");
		String[] sleeping_drugs = req.getParameterValues("sleeping_collat_drug");
		String[] benzo_drugs = req.getParameterValues("benzo_collat_drug");
		int sleepIndex = 0;
		int benzoIndex = 0;
		
		for(int i = 0; i < names.length; i++){
			if(!(names[i].equalsIgnoreCase("none_selected"))){
				DrugHistory drug = new DrugHistory();
				drug.setDrug(names[i]);
				drug.setTime(time[i]);
				drug.setNotes(notes[i]);
				if(drug.getDrug().equalsIgnoreCase("sleeping")){
					drug.setSleep_med(sleeping_drugs[sleepIndex]);
					sleepIndex++;
				} else if(drug.getDrug().equalsIgnoreCase("benzo")){
					drug.setBenzo_med(benzo_drugs[benzoIndex]);
					benzoIndex++;
				}
				drug.setpHistory(pH);
				drugs.add(drug);
			}
		}		
		return drugs;
	}
	
	public ArrayList<PsychHistory> loadPsychCollatList(HttpServletRequest req, PatientHistory pH){
		ArrayList<PsychHistory> psychs = new ArrayList<PsychHistory>();
		String[] names = req.getParameterValues("psych_collat_histories");
		String[] times = req.getParameterValues("psych_collat_time");
		String[] notes = req.getParameterValues("psych_collat_notes");
		
		for(int i = 0; i < names.length; i++){
			if(!(names[i].equalsIgnoreCase("none_selected"))){
				PsychHistory psych = new PsychHistory();
				psych.setPsych(names[i]);
				psych.setTime(times[i]);
				psych.setNotes(notes[i]);
				psych.setpHistory(pH);
				psychs.add(psych);
			}
		}		
		return psychs;
	}
}
