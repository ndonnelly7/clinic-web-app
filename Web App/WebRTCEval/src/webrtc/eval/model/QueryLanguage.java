package webrtc.eval.model;

import java.util.ArrayList;

import com.google.gson.Gson;

public class QueryLanguage {

	ClientInterface cl = new ClientInterface();
	
	public String ParseQuery(String query, String client){
		String returnString = "";
		String[] queryParts = query.split(" ");
		for(int i = 0; i < queryParts.length; i++){
			System.out.println("queryParts[" + i + "]: " + queryParts[i]);
		}
		if(queryParts[0].equalsIgnoreCase("SELECT")){
			if(queryParts[1].equalsIgnoreCase("Public"))
				return parsePublicSelect(queryParts, client);
			else if(queryParts[1].equalsIgnoreCase("Private"))
				return parsePrivateSelect(queryParts,client);
			else returnString = "ERROR Invalid SELECT option: " + queryParts[1];
		} else if(queryParts[0].equalsIgnoreCase("UPDATE")){
			parseUpdateQuery(query);
		}
		else {
			returnString = "ERROR Invalid Query. Query must begin with 'SELECT'";
		}
		return returnString;
	}
	
	public String parseUpdateQuery(String query){
		String returnString = "";
		
		int setIndex = query.indexOf("SET");
		int whereIndex = query.indexOf("WHERE");
		int ppsnIndex = query.indexOf("PPSN=");
		String ppsn = query.substring(ppsnIndex+5, query.length()-1);
		returnString = ppsn;
		
		return returnString;
	}
	
	public String parsePublicSelect(String[] selectParts, String client){
		String returnString = "Parsing Select";
		int index = 2;
		
		if(selectParts[2].equalsIgnoreCase("FROM")){
			index++;
			if(selectParts[index].equalsIgnoreCase("Global")){
				//Global table chosen
				index++;
				if(selectParts[index].equalsIgnoreCase("WHERE")){
					index+=1;
					if(selectParts[index].equalsIgnoreCase("ppsn")){
						index+=2;
						String ppsn = selectParts[index].substring(1,selectParts[index].length()-1);
						String currentClinic = "";
						ArrayList<String> Clinics = cl.getClinicsList();
						boolean foundPatient = false;
						for(int i = 0; i < Clinics.size() && !foundPatient; i++){
							currentClinic = Clinics.get(i);
							String patient = cl.findPatient(ppsn,currentClinic);
							if(!(patient.equals(""))){
								foundPatient = true;
								returnString = "Single:" + patient;
							}
						}
						if(!foundPatient){
							returnString = "ERROR No patient found with ppsn: " + ppsn;
						}
					} else if(selectParts[index].startsWith("ppsn")){
						String[] ppsnArr = selectParts[index].split("=");
						String ppsn = ppsnArr[ppsnArr.length-1].substring(1,ppsnArr[ppsnArr.length-1].length()-1);
						String currentClinic = "";
						ArrayList<String> Clinics = cl.getClinicsList();
						boolean foundPatient = false;
						for(int i = 0; i < Clinics.size() && !foundPatient; i++){
							currentClinic = Clinics.get(i);
							String patient = cl.findPatient(ppsn,currentClinic);
							if(!(patient.equals(""))){
								foundPatient = true;
								returnString = "Single:" + patient;
							}
						}
						if(!foundPatient){
							returnString = "ERROR No patient found with ppsn: " + ppsn;
						}
					} else {
						boolean selectNotDone = true;
						ArrayList<Patient> currentPatientList = cl.getPatients();
						for(; index < selectParts.length && selectNotDone; index++){
							currentPatientList = applyFilter(selectParts[index], currentPatientList);
							if(index >= selectParts.length-1 || !(selectParts[++index].equalsIgnoreCase("AND"))){
								selectNotDone = false;
							}
						}
						Gson gson = new Gson();
						String pats = gson.toJson(cl.getSimplePatientList(currentPatientList));
						returnString = "Multiple:" + pats;
					}
				}else{
					returnString = "ERROR Incomplete Query, expecting WHERE: " + selectParts[index];
				}
				
				
			} else if(selectParts[index].startsWith("`")){
				//Find the name of the clinic which acts as the table
				String fromString = selectParts[index];
				boolean fromFinished = false;
				index++;
				for(;index < selectParts.length && !fromFinished;index++){
					fromString += (" " + selectParts[index]);
					if(selectParts[index].endsWith("`")){
						fromFinished = true;
					}
				}
				fromString = fromString.substring(1,fromString.length()-1);
				returnString = fromString;
				if(fromFinished){
					//Check that the clinic exists
					if(cl.getClinicsList().contains(fromString)){
						//The clinic provided exists
						//Only looking for ppsn number if a clinic table provided
						if(selectParts[index].equalsIgnoreCase("WHERE")){
							index+=1;
							if(selectParts[index].equalsIgnoreCase("ppsn")){
								index+=2;
								String ppsn = selectParts[index].substring(1,selectParts[index].length()-1);
								returnString = "Single:" + cl.findPatient(ppsn,fromString);
							} else if(selectParts[index].startsWith("ppsn")){
								String[] ppsnArr = selectParts[index].split("=");
								String ppsn = ppsnArr[ppsnArr.length-1].substring(1,ppsnArr[ppsnArr.length-1].length()-1);
								returnString = "Single:" + cl.findPatient(ppsn,fromString);
							} else {
								boolean selectNotDone = true;
								ArrayList<Patient> currentPatientList = applyClinicFilter(fromString, cl.getPatients());
								if(currentPatientList == null || currentPatientList.size() == 0){
									returnString = "ERROR Clinic chosen has no patients: " + fromString;
								} else {
									for(; index < selectParts.length && selectNotDone; index++){
										currentPatientList = applyFilter(selectParts[index], currentPatientList);
										index += 1;
										if(index >= selectParts.length || (!(selectParts[index].equalsIgnoreCase("AND")))){
											selectNotDone = false;
										}
									}
									Gson gson = new Gson();
									String pats = gson.toJson(cl.getSimplePatientList(currentPatientList));
									returnString = "Multiple:" + pats;
								}
							}
						}else{
							returnString = "ERROR Incomplete Query, expecting WHERE: " + selectParts[index];
						}
					} else {
						returnString = "ERROR Table does not exist: " + fromString;
					}							
					
				}else {
					returnString = "ERROR Invalid Table entry, missin '`': " + fromString;
				}
				
			} else {
				returnString = "ERROR Invalid Table in query. Syntax error at :" + selectParts[index];
			}
			
		}else {
			returnString = "ERROR Invalid SELECT query. Syntax error at :" + selectParts[2];
		}
		
		return returnString;
	}
	
	public String parsePrivateSelect(String[] selectParts,String client){
		String returnString = "Parsing Select";
		
		int index = 2;
		if(selectParts[index].equalsIgnoreCase("FROM")){
			index++;
			if(selectParts[index].equalsIgnoreCase("Global")){
				//Global table chosen
				index++;
				if(selectParts[index].equalsIgnoreCase("WHERE")){
					index+=1;
					if(selectParts[index].equalsIgnoreCase("ppsn")){
						index+=2;
						String ppsn = selectParts[index].substring(1,selectParts[index].length()-1);
						String currentClinic = "";
						ArrayList<String> Clinics = cl.getClinicsList();
						boolean foundPatient = false;
						for(int i = 0; i < Clinics.size() && !foundPatient; i++){
							currentClinic = Clinics.get(i);
							String patient = cl.retrievePatient(ppsn,currentClinic,client);
							if(!(patient.equals(""))){
								foundPatient = true;
								returnString = patient;
							}
						}
						if(!foundPatient){
							returnString = "ERROR No patient found with ppsn: " + ppsn;
						}
					} else if(selectParts[index].startsWith("ppsn")){
						String[] ppsnArr = selectParts[index].split("=");
						String ppsn = ppsnArr[ppsnArr.length-1].substring(1,ppsnArr[ppsnArr.length-1].length()-1);
						String currentClinic = "";
						ArrayList<String> Clinics = cl.getClinicsList();
						boolean foundPatient = false;
						for(int i = 0; i < Clinics.size() && !foundPatient; i++){
							currentClinic = Clinics.get(i);
							String patient = cl.findPatient(ppsn,currentClinic);
							if(!(patient.equals(""))){
								foundPatient = true;
								returnString = patient;
							}
						}
						if(!foundPatient){
							returnString = "ERROR No patient found with ppsn: " + ppsn;
						}
					} else {
						returnString = "ERROR Expected ppsn for SELECT query from Private table: " + selectParts[index].length();
					}
				}
			} else if(selectParts[index].startsWith("`")){
				//Find the name of the clinic which acts as the table
				String fromString = selectParts[index];
				boolean fromFinished = false;
				index++;
				for(;index < selectParts.length && !fromFinished;index++){
					fromString += (" " + selectParts[index]);
					if(selectParts[index].endsWith("`")){
						fromFinished = true;
					}
				}
				fromString = fromString.substring(1,fromString.length()-1);
				returnString = fromString;
				if(fromFinished){
					//Check that the clinic exists
					if(cl.getClinicsList().contains(fromString)){
						//The clinic provided exists
						//Only looking for ppsn number if a clinic table provided
						if(selectParts[index].equalsIgnoreCase("WHERE")){
							index+=1;
							if(selectParts[index].equalsIgnoreCase("ppsn")){
								index+=2;
								String ppsn = selectParts[index].substring(1,selectParts[index].length()-1);
								returnString = cl.retrievePatient(ppsn,fromString,client);
							} else if(selectParts[index].startsWith("ppsn")){
								String[] ppsnArr = selectParts[index].split("=");
								String ppsn = ppsnArr[ppsnArr.length-1].substring(1,ppsnArr[ppsnArr.length-1].length()-1);
								returnString = cl.retrievePatient(ppsn,fromString,client);
							} else {
								returnString = "ERROR Expected ppsn for SELECT query from Private table: " + selectParts[index].length();
							}
						}else{
							returnString = "ERROR Incomplete Query, expecting WHERE: " + selectParts[index];
						}
					} else {
						returnString = "ERROR Table does not exist: " + fromString;
					}							
					
				}else {
					returnString = "ERROR Invalid Table entry, missin '`': " + fromString;
				}
				
			} else {
				returnString = "ERROR Invalid Table in query. Syntax error at :" + selectParts[index];
			}
		}else {
			returnString = "ERROR Invalid SELECT query";
		}
		
		return returnString;
	}
	
	//Takes the parameter of a filter to be applied to all the patients on the system
	//Parameter takes the form of: `x`=TRUE 
	//No Spaces are permitted, TRUE and FALSE must be capitalized
	//Returns a new array of patients with the filter applied
	public ArrayList<Patient> applyFilter(String filter, ArrayList<Patient> patients){
		ArrayList<Patient> newList = new ArrayList<Patient>();
		if(filter.startsWith("`DEMENTIA`")){
			if(filter.endsWith("TRUE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.dementia)
						newList.add(p);
				}
			} else if(filter.endsWith("FALSE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(!(p.dementia))
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`MEMORY`")){
			if(filter.endsWith("TRUE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.memory)
						newList.add(p);
				}
			} else if(filter.endsWith("FALSE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(!(p.memory))
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`ALCOHOL`")){
			if(filter.endsWith("TRUE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.alcohol)
						newList.add(p);
				}
			} else if(filter.endsWith("FALSE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(!(p.alcohol))
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`STRESS`")){
			if(filter.endsWith("TRUE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.stress)
						newList.add(p);
				}
			} else if(filter.endsWith("FALSE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(!(p.stress))
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`SLEEP`")){
			if(filter.endsWith("TRUE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.sleep)
						newList.add(p);
				}
			} else if(filter.endsWith("FALSE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(!(p.sleep))
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`DIET`")){
			if(filter.endsWith("TRUE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.diet)
						newList.add(p);
				}
			} else if(filter.endsWith("FALSE")){
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(!(p.diet))
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`WEIGHT`")){
			if(filter.contains("=")){
				String sub = filter.substring(filter.indexOf("=")+1);
				int weight = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.weight == weight)
						newList.add(p);
				}
			} else if(filter.contains("<")){
				String sub = filter.substring(filter.indexOf("<")+1);
				int weight = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.weight < weight)
						newList.add(p);
				}
			} else if(filter.contains(">")){
				String sub = filter.substring(filter.indexOf(">")+1);
				int weight = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.weight > weight)
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`POINTS`")){
			if(filter.contains("=")){
				String sub = filter.substring(filter.indexOf("=")+1);
				int points = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.alcoPoints == points)
						newList.add(p);
				}
			} else if(filter.contains("<")){
				String sub = filter.substring(filter.indexOf("<")+1);
				int points = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.alcoPoints < points)
						newList.add(p);
				}
			} else if(filter.contains(">")){
				String sub = filter.substring(filter.indexOf(">")+1);
				int points = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.alcoPoints > points)
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`SCORE`")){
			if(filter.contains("=")){
				String sub = filter.substring(filter.indexOf("=")+1);
				int score = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.mem_score == score)
						newList.add(p);
				}
			} else if(filter.contains("<")){
				String sub = filter.substring(filter.indexOf("<")+1);
				int score = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.mem_score < score)
						newList.add(p);
				}
			} else if(filter.contains(">")){
				String sub = filter.substring(filter.indexOf(">")+1);
				int score = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.mem_score > score)
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`HOURS`")){
			if(filter.contains("=")){
				String sub = filter.substring(filter.indexOf("=")+1);
				int hours = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.sleep_hours == hours)
						newList.add(p);
				}
			} else if(filter.contains("<")){
				String sub = filter.substring(filter.indexOf("<")+1);
				int hours = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.sleep_hours < hours)
						newList.add(p);
				}
			} else if(filter.contains(">")){
				String sub = filter.substring(filter.indexOf(">")+1);
				int hours = Integer.parseInt(sub);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.sleep_hours > hours)
						newList.add(p);
				}
			}
		} else if(filter.startsWith("`CAUSE`")){
			if(filter.contains("=")){
				String sub = filter.substring(filter.indexOf("=")+1);
				for(int i = 0; i < patients.size(); i++){
					Patient p = patients.get(i);
					if(p.stress_cause.equalsIgnoreCase(sub))
						newList.add(p);
				}
			}
		}
		return newList;
	}
	
	public ArrayList<Patient> applyClinicFilter(String clinic, ArrayList<Patient> patients){
		PeerDataAccess pd = new PeerDataAccess();
		Clinic c  = pd.findClinic(clinic);
		if(c==null){
			return null;
		}
		ArrayList<Patient> newList = new ArrayList<Patient>();
		for(int i = 0; i < patients.size(); i++){
			Patient p = patients.get(i);
			if(p.getClinicID().equals(c.getClinicID())){
				newList.add(p);
			}
		}
		
		return newList;
	}
}