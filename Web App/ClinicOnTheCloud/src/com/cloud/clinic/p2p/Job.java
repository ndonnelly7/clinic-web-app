package com.cloud.clinic.p2p;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.google.appengine.api.datastore.Key;

@Entity
public class Job  implements java.io.Serializable{

	@Transient
	private static final long serialVersionUID = 1L;
	
	int job_id;
	String requestorName;
	String job;
	long timestamp;
	ArrayList<String> requestedPeers;
	
	@ManyToOne(fetch = FetchType.EAGER)
	JobQueue jobqueue;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key id;
	
	public Job(String requestor, String job, int job_id){
		this.requestorName = requestor;
		this.job = job;
		Calendar c = new GregorianCalendar();
		timestamp = c.getTimeInMillis();
		requestedPeers = new ArrayList<String>();
		this.job_id = job_id;
	}

	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public JobQueue getJobqueue() {
		return jobqueue;
	}

	public void setJobqueue(JobQueue jobqueue) {
		this.jobqueue = jobqueue;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public ArrayList<String> getRequestedPeers() {
		return requestedPeers;
	}

	public void setRequestedPeers(ArrayList<String> requestedPeers) {
		this.requestedPeers = requestedPeers;
	}
	
	public boolean checkDeadline(){
		Calendar c = new GregorianCalendar();
		long newTime = c.getTimeInMillis();
		return (newTime > timestamp + 30000);
	}
	
	public void addPeer(String peerName){
		requestedPeers.add(peerName);
	}
}
