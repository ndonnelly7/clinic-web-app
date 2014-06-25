package com.cloud.clinic.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.clinic.model.BeanPopulate;
import com.cloud.clinic.model.DrugHistory;
import com.cloud.clinic.model.Form;
import com.cloud.clinic.model.MedHistory;
import com.cloud.clinic.model.Patient;
import com.cloud.clinic.model.PatientDAO;
import com.cloud.clinic.model.PatientHistory;
import com.cloud.clinic.model.PsychHistory;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class HistoryServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		PatientDAO dao = new PatientDAO();
		Integer patientID = Integer.parseInt(req.getParameter("hiddenID"));
		Patient pat = dao.get(patientID);
		
		if(pat == null){
			req.setAttribute("error", "There was no patient associated with the form");
			req.setAttribute("error_message", "Patient was potentially created incorrectly, please ensure the Personal Details form is submitted correctly before proceeding with the test");
			RequestDispatcher view = req.getRequestDispatcher("/admin/Error.jsp");
			view.forward(req, resp);
			return;
		}
		
		Form f = dao.getTodaysForm(pat);
		PatientHistory pHistory = new PatientHistory();
		BeanPopulate.populateBean(pHistory, req);
		
		pHistory.setMed_histories(loadMedsList(req, pHistory));
		pHistory.setMed_collat_histories(loadMedsCollatList(req, pHistory));
		
		pHistory.setDrug_histories(loadDrugsList(req, pHistory));
		pHistory.setDrug_collat_histories(loadDrugsCollatList(req, pHistory));
		
		pHistory.setPsych_histories(loadPsychList(req, pHistory));
		pHistory.setPsych_collat_histories(loadPsychCollatList(req, pHistory));
		
		String cTherCheck = req.getParameter("current_therapy_check");
		String pTherCheck = req.getParameter("past_therapy_check");
		String collat_cTherCheck = req.getParameter("collat_current_therapy_check");
		String collat_pTherCheck = req.getParameter("collat_past_therapy_check");
		if(cTherCheck != null && cTherCheck.equalsIgnoreCase("on")){
			pHistory.setCurrent_therapy_check("true");
		} else {
			pHistory.setCurrent_therapy_check("false");
		}
		if(pTherCheck != null && pTherCheck.equalsIgnoreCase("on")){
			pHistory.setPast_therapy_check("true");
		} else {
			pHistory.setPast_therapy_check("false");
		}
		if(collat_cTherCheck != null && collat_cTherCheck.equalsIgnoreCase("on")){
			pHistory.setCollat_current_therapy_check("true");
		} else {
			pHistory.setCollat_current_therapy_check("false");
		}
		if(collat_pTherCheck != null && collat_pTherCheck.equalsIgnoreCase("on")){
			pHistory.setCollat_past_therapy_check("true");
		} else {
			pHistory.setCollat_past_therapy_check("false");
		}
		
		if(f.isNew()){
			pHistory.setForm(f);
			f.setPatientHistory(pHistory);
			pat.addForm(f);
		} else {
			if(f.getPatientHistory() != null){
				pHistory.setHistoryID(f.getPatientHistory().getHistoryID());
				dao.runQuery("delete from MedHistory where pHistory= " + String.valueOf(pHistory.getHistoryID()));
				dao.runQuery("delete from DrugHistory where pHistory= " + String.valueOf(pHistory.getHistoryID()));
				dao.runQuery("delete from PsychHistory where pHistory= " + String.valueOf(pHistory.getHistoryID()));
				
			}
			pHistory.setForm(f);
			f.setPatientHistory(pHistory);
			List<Form> fList =  pat.getForms();
			for(int i = 0; i < fList.size(); i++){
				if(fList.get(i).getFormID() == f.getFormID())
				{
					fList.set(i, f);
					break;
				}
			}
			pat.setForms(fList);
		}
		dao.update(pat);

		req.setAttribute("id", patientID);
		req.setAttribute("patient", new JSONObject(pat));
		RequestDispatcher view = req.getRequestDispatcher("/patientform/medical.jsp");
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
				med.setCollat(false);
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
				drug.setCollat(false);
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
				psych.setCollat(false);
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
				med.setCollat(true);
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
				drug.setCollat(true);
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
				psych.setCollat(true);
				psych.setNotes(notes[i]);
				psych.setpHistory(pH);
				psychs.add(psych);
			}
		}		
		return psychs;
	}
}
