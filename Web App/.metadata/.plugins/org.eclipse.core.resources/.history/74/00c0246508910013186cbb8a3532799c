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
	<title>Welcome</title>
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
    	<div id="add_patient" style="display:none">
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
    		<input type="button" value="Add Patient" onclick="addPatientDetails()">
    	</div>
    </div>
    
    <div id="patient_get" class="main_div">
    	<div id="retrieve_patient" style="display:none">
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
    
    <div id="extras" class="main_div">
    	<input type="button" value="Check Channel" onclick="CheckChannel()">
    </div>
    
    <div id="sign_out_div" class="main_div">
    	<input type="button" value="Sign Out" onclick="SignOut()">
    </div>
    
    <div id="form_hidden" style="display:none">
    	<input type="text" name="name" value="${username}">
    	<input type="text" name="clinc" value="${clinic}">
    	<input type="text" name="mode" value="form">
    </div>
    
    <div id="restart_div">
    	<input type="button" value="Reset Datastore" onclick="resetDataStore()">
    </div>
    
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
	<script src="js/IDB.js"></script>
	<script src="js/main.js"></script>
	<script src="js/P2P.js"></script>
  </body>
</html>
