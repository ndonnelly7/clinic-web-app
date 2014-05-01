package project.beta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class TestBattery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testBatteryID", unique = true, nullable = false)
	int testBatteryID;

	@Transient
	protected Object[] jdoDetachedState;
	
	public TestBattery() {
		
	}
}
