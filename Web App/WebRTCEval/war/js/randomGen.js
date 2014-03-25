var firstNames = ["Alex","Amy","Andrew","Alison","Brad","Billy","Brienne","Baxter","Bart","Christine","Charlie","Ciara","Cassandra","David","Deandra","Dexter","Eve","Evelyn","Eimear","Fred","Frank","George","Graham","Gillian","Gabby","Henrietta","Harry","Henry","Iseult","Ian","Janine","Jake","Jerome","Jessica","Jill","Killian","Kevin","Liam","Libby","Lizzy","Madison","Max","Niall","Niamh","Owen","Paul","Patrice","Rachel","Rickie","Richard","Seve","Stephen","Stephanie","Vinny","Victoria","William","Winnie","Xavier","Yvonne"];
var surnames = ["Anderson","Atwell","Banks","Barrett", "Carlton","Campbell","Day","Donnelly","Everett","Etherington","Farrell","Forest","Gannon","Gable","Hamlet","Hanks","Ivy","Iver","Johnson","Jacobs","Keogh","Kinsella","Layton","Lennon","Malaren","Mangan","Nielson","Novak","O'Dowd","O'Reilly","O'Malley","Pale","Pratchett","Quigley","Richards","Riddick","Stevens","Stallone","Tindell","Thompson","Underhill","Vaughn","White","Wesley","Yeates"];
var streets = ["Cherry","Abbey","Main","Lyons","Airview","Chestnut","Hazelnut","Liffey","Shannon","Dawson","Pearse","Connelly","Dawkins","Rowling","Windy","North","South","East","West","Alexander"];
var streetTypes = ["Lane","Street","Park","Road","Stroll","Way","Strasse","Boulevard","Trail","Court","Place","Plaza"];
var letters = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
var stress = ["family","none","work","loss","health"];

function getName(){
	var first = firstNames[Math.floor(Math.random()*firstNames.length)];
	var second = surnames[Math.floor(Math.random()*surnames.length)];
	return first + " " + second;
}

function getAddress(){
	var number = Math.floor(Math.random()*1000);
	var street = streets[Math.floor(Math.random()*streets.length)];
	var type = streetTypes[Math.floor(Math.random()*streetTypes.length)];
	return number + " " + street + " " + type;
}

function getPPSN(){
	var toAppend = "";
	for(var i = 0; i < 8; i++){
		toAppend += Math.floor(Math.random()*9);		
	}
	toAppend += letters[Math.floor(Math.random()*letters.length)];
	return toAppend;
}

function getPhoneNumber(){
	var toAppend = "0";
	for(var i = 0; i < 10; i++){
		toAppend += Math.floor(Math.random()*9);		
	}
	return toAppend;
}

function getWeight() {
	return Math.floor(Math.random()*100)+40;
}

function getAlcoPoints() {
	return Math.floor(Math.random()*20);
}

function getStress() {
	return stress[Math.floor(Math.random()*5)];
}

function getHours() {
	return Math.floor(Math.random()*16);
}

function getMemory() {
	return Math.floor(Math.random()*100);
}

function getDementia() {
	return (Math.floor(Math.random()*2) == 0 ? "on" : "off");
}