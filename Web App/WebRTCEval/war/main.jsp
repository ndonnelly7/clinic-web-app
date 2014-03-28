<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->


<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>PACE Healthcare</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
	<link rel="stylesheet" href="css/main.css"/>
  </head>

  <body>
    <h1>Inter Clinic Evaluation</h1>
    
    <form id="general_form" class="pure-form pure-form-aligned" method="GET" action="/signout.do">
    <div id="name_div">${username}</div>
    
    <div id="clinic_div">${clinic}</div>
    
    <div id="content" class="main_div">
    <div id="token" style="display:none">${channeltoken}</div>
    
    <div id="patient_info" class="main_div">
    	<input type="button" value="See Patients" onclick="fillPatientInfo()">
    </div>
    
    <div id="patient_add" class="main_div">
    	<input type="button" value="Add Patient" onclick="addPatient()" id="patDetailsButton">
    	<div id="add_patient" style="display:none;background-color:gainsboro">
    		<div class="pure-control-group">
    			<label for="pat_name">Name:</label>
    			<input type="text" id="pat_name" name="pat_name">
    		</div>
    		<div class="pure-control-group">
    			<label for="pat_address">Address:</label>
    			<input type="text" id="pat_address" name="pat_address">
    		</div>
    		<div class="pure-control-group">
    			<label for="pat_ppsn">PPSN:</label>
    			<input type="text" id="pat_ppsn" name="pat_ppsn">
    		</div>
    		<div class="pure-control-group">
    			<label for="pat_number">Number:</label>
    			<input type="text" id="pat_number" name="pat_number">
    		</div>
    		<br>
    		<div class="pure-control-group">
    			<label for="weight">Weight (kg):</label>
    			<input type="text" id="weight" name="weight" style="width:48px;">
    		</div>
    		<div class="pure-control-group">
    			<label for="alcohol_points">Alcohol Points:</label>
    			<input type="text" id="alcohol_points" name="alcohol_points" style="width:48px;">
    		</div>
    		<div class="pure-control-group">
    			<label for="stress_cause">Stress Cause:</label>
    			<select id="stress_cause">
    				<option value="none">None</option>
    				<option value="family">Family</option>
    				<option value="work">Work</option>
    				<option value="loss">Loss</option>
    				<option value="health">Health</option>
    			</select>
    		</div>
    		<div class="pure-control-group">
    			<label for="sleep_hours">Sleep Hours:</label>
    			<input type="text" id="sleep_hours" name="sleep_hours" style="width:48px;">
    		</div>
    		<div class="pure-control-group">
    			<label for="mem_score">Memory Score:</label>
    			<input type="text" id="mem_score" name="mem_score" style="width:48px;">
    		</div>
    		<div class="pure-control-group">
    			<label for="dementia_val">Dementia:</label>
    			<input type="checkbox" id="dementia_val" name="dementia_val">
    		</div>
    		<input type="button" value="Add Patient" onclick="addPatientDetails()" style="margin-left:5%">
    		<br>
    	</div>
    	<br>
    </div>
    
    <div id="patient_get" class="main_div">
    	<div id="retrieve_patient" style="display:none;background-color:gainsboro">
	    	<div class="pure-control-group">
	   		<label for="get_ppsn">PPSN of Patient:</label>
	   		<input type="text" id="get_ppsn" name="get_ppsn">
	   		</div>
	   		<div class="pure-control-group">
	   		<label for="get_clinic">Clinic of Patient:</label>
	   		<input type="text" id="get_clinic" name="get_clinic">
	   		</div>
	   		<input type="button" value="Search for Patient" onclick="retrievePatient()">
   		</div>
   		<input type="button" id="retrievePatButton" value="Find a Patient from Another Clinic" onclick="retrievePatientDiv()">
    </div>
    
    <div id="tenPats" class="main_div">
    	<input type="button" value="Add 10 Patients" onclick="AddMultiPatient(1,10)">
    </div>
    
    <div id="fiftyPats" class="main_div">
    	<input type="button" value="Add 50 Patients" onclick="AddMultiPatient(1,50)">
    </div>
    
    <div id="extras" class="main_div">
    	<input type="button" value="Check Channel" onclick="CheckChannel()">
    </div>
    
    <div id="sql_test" class="main_div">
    	<div id="query_box" style="display:none;background-color:gainsboro">
    		<div class="pure-control-group query_div">
    			<div class="query_title">SELECT </div>
    			<select id="selectSelect">    			
    				<option value="public">Public</option>
    				<option value="private">Private</option>
    			</select>
    		</div>
    		<div class="pure-control-group query_div">
    			<div class="query_title">FROM </div>
    			<select id="selectFrom">
    				<option value="Global">Global</option>
    				<option value="`DCU Clinic`">DCU Clinic</option>
    				<option value="`Mayo Clinic`">Mayo Clinic</option>
    			</select>
    		</div>
    		<div class="pure-control-group query_div">
    			<div class="query_title">WHERE </div>
    			<label for="ppsn_query" id="query_label">PPSN:</label>
    			<input type="text" id="ppsn_query">
    		</div>
    		<div class="pure-control-group query_div">
    			<label for="memory_q">Memory</label>
    			<select id="memory_q" class="sql_style">
    				<option value="irrelevant">Irrelevant</option>
    				<option value="yes">True</option>
    				<option value="no">False</option>
    			</select>
    		</div>
    		<div class="pure-control-group query_div">
    			<label for="memory_s_select">Memory Score</label>
    			<select id="memory_s_select" class="sql_style">
    				<option value="gte">&gt</option>
    				<option value="lte">&lt</option>
    				<option value="eq">=</option>
    			</select>
    			<input type="number" id="memory_s" style="width:48px;" class="sql_style"> 
    		</div>
    		<div class="pure-control-group query_div">
    			<label for="alochol_q">Alcohol</label>
    			<select id="alcohol_q" class="sql_style">
    				<option value="irrelevant">Irrelevant</option>
    				<option value="yes">True</option>
    				<option value="no">False</option>
    			</select>
    		</div>
    		<div class="pure-control-group query_div">
    			<label for="alochol_p_select">Alcohol Points</label>
    			<select id="alcohol_p_select" class="sql_style">
    				<option value="gte">&gt</option>
    				<option value="lte">&lt</option>
    				<option value="eq">=</option>
    			</select>
    			<input type="number" id="alcohol_p" style="width:48px;" class="sql_style"> 
    		</div>
    		<div class="pure-control-group query_div">
    			<label for="diet_q">Diet</label>
    			<select id="diet_q" class="sql_style">
    				<option value="irrelevant">Irrelevant</option>
    				<option value="yes">True</option>
    				<option value="no">False</option>
    			</select>
    		</div>
    		<div class="pure-control-group query_div">
    			<label for="weight_kg_select">Weight</label>
    			<select id="weight_kg_select" class="sql_style">
    				<option value="gte">&gt</option>
    				<option value="lte">&lt</option>
    				<option value="eq">=</option>
    			</select>
    			<input type="number" id="weight_kg" style="width:48px;" class="sql_style">
    		</div>
    		<div class="pure-control-group query_div"> 
    			<label for="sleep_q">Sleep</label>
    			<select id="sleep_q" class="sql_style">
    				<option value="irrelevant">Irrelevant</option>
    				<option value="yes">True</option>
    				<option value="no">False</option>
    			</select> 
    		</div>
    		<div class="pure-control-group query_div"> 
    			<label for="sleep_h_select">Sleep Hours</label>
    			<select id="sleep_h_select" class="sql_style">
    				<option value="gte">&gt</option>
    				<option value="lte">&lt</option>
    				<option value="eq">=</option>
    			</select>
    			<input type="number" id="sleep_h" style="width:48px;" class="sql_style"> 
    		</div>
    		<div class="pure-control-group query_div">
    			<label for="stress_q">Stress</label>
    			<select id="stress_q" class="sql_style">
    				<option value="irrelevant">Irrelevant</option>
    				<option value="yes">True</option>
    				<option value="no">False</option>
    			</select> 
    		</div>
    		<div class="pure-control-group query_div">
    			<label for="stress_c">Stress Cause</label>
    			<select id="stress_c">
    				<option value="none">None</option>
    				<option value="family">Family</option>
    				<option value="work">Work</option>
    				<option value="loss">Loss</option>
    				<option value="health">Health</option>
    			</select> 
    		</div>
    		<div class="pure-control-group query_div">
    			<label for="dementia_q">Dementia</label>
    			<select id="dementia_q" class="sql_style">
    				<option value="irrelevant">Irrelevant</option>
    				<option value="yes">True</option>
    				<option value="no">False</option>
    			</select> 
    		</div>
    		<input type="button" value="Submit Query" onclick="sendQuery()">
    	</div>
    	
    	<div id="patientQueryDisplay">
    		
    	</div>
		
    	<input type="button" value="Open Query" onclick="openQueryBox()">
    </div>
    
    <div id="sign_out_div" class="main_div">
    	<input type="button" value="Sign Out" onclick="SignOut()">
    </div>
    <div id="form_hidden" style="display:none">
    	<input type="text" name="name" value="${username}">
    	<input type="text" name="clinc" value="${clinic}">
    	<input type="text" name="mode" value="form">
    </div>
    <br>
    <div id="restart_div">
    	<input type="button" value="Reset Datastore" onclick="resetDataStore()">
    </div>
    <br>
    <div id="restart_div">
    	<input type="button" value="Clear Local Datastore" onclick="clearObjectStore()">
    </div>
    
    </div>
    
	<div id="infotext"></div> 
	
	<div id="clear"></div>
	</form>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript" src="/_ah/channel/jsapi"></script>
	<script src = "js/IDBShim.js"></script>
	<script src="http://cdn.peerjs.com/0.3/peer.min.js"></script>
	<script src="js/randomGen.js"></script>
	<script src="js/IDB.js"></script>
	<script src="js/main.js"></script>
	<script src="js/P2P.js"></script>
  </body>
</html>