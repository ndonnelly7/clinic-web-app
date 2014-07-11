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
	
	public JobQueue
}
