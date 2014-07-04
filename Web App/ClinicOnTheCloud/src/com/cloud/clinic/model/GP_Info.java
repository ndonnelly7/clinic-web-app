package com.cloud.clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

/*
 * Used to represent the page containing any information from patient's visit to the GP
 */

@Entity
public class GP_Info {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gpInfoID", unique = true, nullable = false)
	int gpInfoID;

	@Transient
	protected Object[] jdoDetachedState;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Form form;

	@Expose
	boolean gp_talked;
	@Expose
	String gp_results, gp_meds, gp_notes, discussed_with_gp;
	@Expose
	float cholest_test, cholest_ldl, cholest_hdl, thyroid, weight_test;
	@Expose
	float systolic, diastolic, b12_test, iron_test, calc_test, sodium_test;
	@Expose
	String cholest_time, ldl_time, hdl_time, thyroid_time, weight_time;
	@Expose
	String systolic_time, diastolic_time, b12_time, iron_time, calc_time, sodium_time;
	@Expose
	String med_test_notes, kin_response, response_time, kin_notes;
	
	public GP_Info()
	{
		
	}

	public int getGpInfoID() {
		return gpInfoID;
	}

	public void setGpInfoID(int gpInfoID) {
		this.gpInfoID = gpInfoID;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getDiscussed_with_gp() {
		return discussed_with_gp;
	}

	public void setDiscussed_with_gp(String discussed_with_gp) {
		this.discussed_with_gp = discussed_with_gp;
	}

	public String getCalc_time() {
		return calc_time;
	}

	public void setCalc_time(String calc_time) {
		this.calc_time = calc_time;
	}

	public boolean isGp_talked() {
		return gp_talked;
	}

	public void setGp_talked(boolean gp_talked) {
		this.gp_talked = gp_talked;
	}

	public String getGp_results() {
		return gp_results;
	}

	public void setGp_results(String gp_results) {
		this.gp_results = gp_results;
	}

	public String getGp_meds() {
		return gp_meds;
	}

	public void setGp_meds(String gp_meds) {
		this.gp_meds = gp_meds;
	}

	public String getGp_notes() {
		return gp_notes;
	}

	public void setGp_notes(String gp_notes) {
		this.gp_notes = gp_notes;
	}

	public float getCholest_test() {
		return cholest_test;
	}

	public void setCholest_test(float cholest_test) {
		this.cholest_test = cholest_test;
	}

	public float getCholest_ldl() {
		return cholest_ldl;
	}

	public void setCholest_ldl(float cholest_ldl) {
		this.cholest_ldl = cholest_ldl;
	}

	public float getCholest_hdl() {
		return cholest_hdl;
	}

	public void setCholest_hdl(float cholest_hdl) {
		this.cholest_hdl = cholest_hdl;
	}

	public float getThyroid() {
		return thyroid;
	}

	public void setThyroid(float thyroid) {
		this.thyroid = thyroid;
	}

	public float getWeight_test() {
		return weight_test;
	}

	public void setWeight_test(float weight_test) {
		this.weight_test = weight_test;
	}

	public float getSystolic() {
		return systolic;
	}

	public void setSystolic(float systolic) {
		this.systolic = systolic;
	}

	public float getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(float diastolic) {
		this.diastolic = diastolic;
	}

	public float getB12_test() {
		return b12_test;
	}

	public void setB12_test(float b12_test) {
		this.b12_test = b12_test;
	}

	public float getIron_test() {
		return iron_test;
	}

	public void setIron_test(float iron_test) {
		this.iron_test = iron_test;
	}

	public float getCalc_test() {
		return calc_test;
	}

	public void setCalc_test(float calc_test) {
		this.calc_test = calc_test;
	}

	public float getSodium_test() {
		return sodium_test;
	}

	public void setSodium_test(float sodium_test) {
		this.sodium_test = sodium_test;
	}

	public String getCholest_time() {
		return cholest_time;
	}

	public void setCholest_time(String cholest_time) {
		this.cholest_time = cholest_time;
	}

	public String getLdl_time() {
		return ldl_time;
	}

	public void setLdl_time(String ldl_time) {
		this.ldl_time = ldl_time;
	}

	public String getHdl_time() {
		return hdl_time;
	}

	public void setHdl_time(String hdl_time) {
		this.hdl_time = hdl_time;
	}

	public String getThyroid_time() {
		return thyroid_time;
	}

	public void setThyroid_time(String thyroid_time) {
		this.thyroid_time = thyroid_time;
	}

	public String getWeight_time() {
		return weight_time;
	}

	public void setWeight_time(String weight_time) {
		this.weight_time = weight_time;
	}

	public String getSystolic_time() {
		return systolic_time;
	}

	public void setSystolic_time(String systolic_time) {
		this.systolic_time = systolic_time;
	}

	public String getDiastolic_time() {
		return diastolic_time;
	}

	public void setDiastolic_time(String diastolic_time) {
		this.diastolic_time = diastolic_time;
	}

	public String getB12_time() {
		return b12_time;
	}

	public void setB12_time(String b12_time) {
		this.b12_time = b12_time;
	}

	public String getIron_time() {
		return iron_time;
	}

	public void setIron_time(String iron_time) {
		this.iron_time = iron_time;
	}

	public String getCal_time() {
		return calc_time;
	}

	public void setCal_time(String cal_time) {
		this.calc_time = cal_time;
	}

	public String getSodium_time() {
		return sodium_time;
	}

	public void setSodium_time(String sodium_time) {
		this.sodium_time = sodium_time;
	}

	public String getMed_test_notes() {
		return med_test_notes;
	}

	public void setMed_test_notes(String med_test_notes) {
		this.med_test_notes = med_test_notes;
	}

	public String getKin_response() {
		return kin_response;
	}

	public void setKin_response(String kin_response) {
		this.kin_response = kin_response;
	}

	public String getResponse_time() {
		return response_time;
	}

	public void setResponse_time(String response_time) {
		this.response_time = response_time;
	}

	public String getKin_notes() {
		return kin_notes;
	}

	public void setKin_notes(String kin_notes) {
		this.kin_notes = kin_notes;
	}
	
}
