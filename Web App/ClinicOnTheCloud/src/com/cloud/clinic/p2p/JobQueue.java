package com.cloud.clinic.p2p;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class JobQueue {
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "jobqueue", cascade = CascadeType.ALL)
	ArrayList<Job> jobs;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key id;
	
	public JobQueue() {
		jobs = new ArrayList<Job>();
	}
	
	public void addJob(Job j){
		if(j != null){
			if(jobs == null)
				jobs = new ArrayList<Job>();
			jobs.add(j);
		}
	}
	
	public void cleanQueue(){
		for(int i = jobs.size()-1; i >= 0; i--){
			if(jobs.get(i).checkDeadline()){
				jobs.remove(i);
			}
		}
	}
	
	public Job claimJob(int jobID){
		for(int i = jobs.size()-1; i >= 0; i--){
			if(jobs.get(i).getJob_id() == jobID){
				return jobs.remove(i);
			}
		}
		return null;
	}

	public ArrayList<Job> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}
	
	
}