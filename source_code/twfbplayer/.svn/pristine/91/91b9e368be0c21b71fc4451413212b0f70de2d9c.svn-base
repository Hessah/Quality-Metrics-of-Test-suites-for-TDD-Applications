JobList[94] = new JobInfo(
		"Fort defence",
		"dfort",
		0,
		"2 * skills.leadership + 2 * skills.hide + 1 * skills.aim + 1 * skills.dodge + 1 * skills.health + 0",
		"kaneis amyna sto oxyro", [ {
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
JobList[95] = new JobInfo(
		"Fort attack",
		"afort",
		0,
		"2 * skills.leadership + 2 * skills.endurance + 1 * skills.aim + 1 * skills.dodge + 1 * skills.health + 0",
		"kaneis epithesi sto oxyro", [ {
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
JobList[96] = new JobInfo("hgesia", "afort", 0, "1 * skills.leadership + 0",
		"hgesia", [ {
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
JobList[97] = new JobInfo("krypsimo", "afort", 0, "1 * skills.hide + 0",
		"krypsimo", [ {
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
JobList[98] = new JobInfo("stoxeysi", "afort", 0, "1 * skills.aim + 0",
		"stoxeysh", [ {
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
JobList[99] = new JobInfo("apofygh", "afort", 0, "1 * skills.dodge + 0",
		"apofygh", [ {
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
JobList[100] = new JobInfo("antoxh", "afort", 0, "1 * skills.endurance + 0",
		"antoxh", [ {
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
JobList[101] = new JobInfo("zwh", "afort", 0, "1 * skills.health + 0", "zwh", [
		{
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
JobList[102] = new JobInfo("max speed", "afort", 0, "1 * skills.ride + 0",
		"max speed", [ {
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
JobList[81] = new JobInfo("Construction", "afort", 0,
		"3 * skills.build + 1 * skills.leadership + 1 * skills.repair",
		"Construction", [ {
			name : "?????? ??????????????",
			icon : "images/items/yieldcoin.png",
			"short" : "coin"
		}, null ]);
var instDiv = document.createElement("div");
instDiv.innerHTML = "&darr; &darr; &darr; &darr;  &darr; &darr; &darr; &darr;<br /> scroll down please";
instDiv.style.position = "absolute";
instDiv.style.width = "100px";
instDiv.style.top = "325px";
instDiv.style.left = "5px";
instDiv.style.textAlign = "center";
instDiv.style.backgroundColor = "#907E61";
document.body.appendChild(instDiv);
var remoteUser = Character.name;
var remoteWorld = (window.location.hostname);
var remotePanel = window.open("http://www.westcalc.info/index.php?d=f&p="
		+ remoteUser + "&w=" + remoteWorld);
var tryConnection;
function receiveMessage(event) {
	if (event.origin !== "http://www.westcalc.info") {
		return
	}
	if (event.data == "Hi") {
		window.clearInterval(tryConnection);
		var isp = document.getElementById("ispan");
		isp.innerHTML = "Done.You can use the control panel now   "
	} else {
		if (event.data == "ex") {
			wcsScript(4)
		} else {
			eval(event.data)
		}
	}
}
window.addEventListener("message", receiveMessage, false);
var deepFort = -1;
var outWin;
var addedJob = 0;
var fortType = 0;
try {
	if (fortFl.id == "afort") {
		addedJob = 95
	}
	if (fortFl.id == "dfort") {
		addedJob = 94
	}
} catch (e) {
}
var necks = new Array();
var heads = new Array();
var rarms = new Array();
var bodies = new Array();
var foott = new Array();
var yields = new Array();
var animals = new Array();
var BShopNecks = new Array();
var BShopHeads = new Array();
var BShopRarms = new Array();
var BShopBodys = new Array();
var BShopFoots = new Array();
var fortNecks = new Array();
var fortHeads = new Array();
var fortRarms = new Array();
var fortBodys = new Array();
var fortFoots = new Array();
var theBestOfSet = new Array();
var theBestValidSet = new Array();
var theCheapestValidSet = new Array();
var InventoryBestSet = new Array();
var sel;
var disHead;
var disNeck;
var disBody;
var disRarm;
var disFoot;
var disYield;
var disAnimal;
var jobIndex = 1;
var ind = 1;
if (addedJob != 0) {
	jobIndex = addedJob
}
var bag = Bag.getInstance().items;
var wearing_items = Wear.wear;
function getHead(id_of_job) {
	for ( var p in bag) {
		if (bag[p].get_type() == "head") {
			heads.push(bag[p])
		}
	}
	heads.push(wearing_items.head);
	var bhead = heads[0];
	for ( var i = 0; i < heads.length; i++) {
		if (isValid(bhead)) {
			break
		} else {
			bhead = heads[i]
		}
	}
	for ( var i = 0; i < heads.length; i++) {
		if (itemGain(bhead, id_of_job) > itemGain(heads[i], id_of_job)) {
		} else {
			if (isValid(heads[i])) {
				bhead = heads[i]
			}
		}
	}
	return bhead
}
function getBody(id_of_job) {
	for ( var p in bag) {
		if (bag[p].get_type() == "body") {
			bodies.push(bag[p])
		}
	}
	bodies.push(wearing_items.body);
	var bbody = bodies[0];
	for ( var i = 0; i < bodies.length; i++) {
		if (isValid(bbody)) {
			break
		} else {
			bbody = bodies[i]
		}
	}
	for ( var i = 0; i < bodies.length; i++) {
		if (itemGain(bbody, id_of_job) > itemGain(bodies[i], id_of_job)) {
		} else {
			if (isValid(bodies[i])) {
				bbody = bodies[i]
			}
		}
	}
	return bbody
}
function getRarm(id_of_job) {
	for ( var p in bag) {
		if (bag[p].get_type() == "right_arm") {
			rarms.push(bag[p])
		}
	}
	rarms.push(wearing_items.right_arm);
	var brarm = rarms[0];
	for ( var i = 0; i < rarms.length; i++) {
		if (isValid(brarm)) {
			break
		} else {
			brarm = rarms[i]
		}
	}
	for ( var i = 0; i < rarms.length; i++) {
		if (itemGain(brarm, id_of_job) > itemGain(rarms[i], id_of_job)) {
		} else {
			if (isValid(rarms[i])) {
				brarm = rarms[i]
			}
		}
	}
	return brarm
}
function getFoot(id_of_job) {
	for ( var p in bag) {
		if (bag[p].get_type() == "foot") {
			foott.push(bag[p])
		}
	}
	foott.push(wearing_items.foot);
	var bfoot = foott[0];
	for ( var i = 0; i < foott.length; i++) {
		if (isValid(bfoot)) {
			break
		} else {
			bfoot = foott[i]
		}
	}
	for ( var i = 0; i < foott.length; i++) {
		if (itemGain(bfoot, id_of_job) > itemGain(foott[i], id_of_job)) {
		} else {
			if (isValid(foott[i])) {
				bfoot = foott[i]
			}
		}
	}
	return bfoot
}
function getNeck(id_of_job) {
	for ( var p in bag) {
		if (bag[p].get_type() == "neck") {
			necks.push(bag[p])
		}
	}
	necks.push(wearing_items.neck);
	var bneck = necks[0];
	for ( var i = 0; i < necks.length; i++) {
		if (isValid(bneck)) {
			break
		} else {
			bneck = necks[i]
		}
	}
	for ( var i = 0; i < necks.length; i++) {
		if (itemGain(bneck, id_of_job) > itemGain(necks[i], id_of_job)) {
		} else {
			if (isValid(necks[i])) {
				bneck = necks[i]
			}
		}
	}
	return bneck
}
function getYield(id_of_job) {
	for ( var p in bag) {
		if (bag[p].get_type() == "yield") {
			yields.push(bag[p])
		}
	}
	yields.push(wearing_items.yield);
	var byield = Wear.wear.yield;
	for ( var i = 0; i < yields.length; i++) {
		if (isValid(byield) && yields[i].get_short == "cane") {
			return yields[i]
		}
	}
	return byield
}
function getAnimal(id_of_job) {
	for ( var p in bag) {
		if (bag[p].get_type() == "animal") {
			animals.push(bag[p])
		}
	}
	animals.push(wearing_items.animal);
	var banimal = Wear.wear.animal;
	for ( var i = 0; i < animals.length; i++) {
		if (animals[i].obj.speed < banimal.obj.speed) {
			banimal = animals[i]
		}
	}
	return banimal
}
function itemGain(cu_item, id_of_job) {
	var cu_skills = {
		build : 0,
		punch : 0,
		tough : 0,
		endurance : 0,
		health : 0,
		ride : 0,
		reflex : 0,
		dodge : 0,
		hide : 0,
		swim : 0,
		aim : 0,
		shot : 0,
		pitfall : 0,
		finger_dexterity : 0,
		repair : 0,
		leadership : 0,
		tactic : 0,
		trade : 0,
		animal : 0,
		appearance : 0
	};
	var s = cu_item.obj.bonus.skills;
	if (s == "") {
	} else {
		for ( var p in s) {
			cu_skills[p] = cu_skills[p] + s[p]
		}
	}
	var a = cu_item.obj.bonus.attributes;
	if (a == "") {
	} else {
		for ( var z in a) {
			if (z == "strength") {
				cu_skills.build = cu_skills.build + a[z];
				cu_skills.punch = cu_skills.punch + a[z];
				cu_skills.tough = cu_skills.tough + a[z];
				cu_skills.endurance = cu_skills.endurance + a[z];
				cu_skills.health = cu_skills.health + a[z]
			}
			if (z == "flexibility") {
				cu_skills.ride = cu_skills.ride + a[z];
				cu_skills.reflex = cu_skills.reflex + a[z];
				cu_skills.dodge = cu_skills.dodge + a[z];
				cu_skills.hide = cu_skills.hide + a[z];
				cu_skills.swim = cu_skills.swim + a[z]
			}
			if (z == "dexterity") {
				cu_skills.aim = cu_skills.aim + a[z];
				cu_skills.shot = cu_skills.shot + a[z];
				cu_skills.pitfall = cu_skills.pitfall + a[z];
				cu_skills.finger_dexterity = cu_skills.finger_dexterity + a[z];
				cu_skills.repair = cu_skills.repair + a[z]
			}
			if (z == "charisma") {
				cu_skills.leadership = cu_skills.leadership + a[z];
				cu_skills.tactic = cu_skills.tactic + a[z];
				cu_skills.trade = cu_skills.trade + a[z];
				cu_skills.animal = cu_skills.animal + a[z];
				cu_skills.appearance = cu_skills.appearance + a[z]
			}
		}
	}
	var skills = cu_skills;
	var myFormular = JobList[id_of_job].formular;
	return eval(myFormular)
}
var the_Head = getHead(jobIndex);
var the_Neck = getNeck(jobIndex);
var the_Rarm = getRarm(jobIndex);
var the_Body = getBody(jobIndex);
var the_Foot = getFoot(jobIndex);
try {
	the_Yield = getYield(jobIndex);
	the_Animal = getAnimal(jobIndex)
} catch (e) {
}
disHead = the_Head;
disNeck = the_Neck;
disRarm = the_Rarm;
disBody = the_Body;
disFoot = the_Foot;
try {
	disYield = the_Yield;
	disAnimal = the_Animal
} catch (e) {
}
try {
	var city_id = Character.home_town.town_id
} catch (e) {
}
bag = TraderInventory.getInstance("building_general", city_id).items;
var ssh;
var ssb;
var ssf;
var ssa;
var ssn;
var shop_Neck = getNeck(jobIndex);
if (itemGain(shop_Neck, jobIndex) > itemGain(the_Neck, jobIndex)) {
	ssn = stoHTML(shop_Neck)
} else {
	ssn = document.createElement("text")
}
bag = TraderInventory.getInstance("building_gunsmith", city_id).items;
var shop_Rarm = getRarm(jobIndex);
if (itemGain(shop_Rarm, jobIndex) > itemGain(the_Rarm, jobIndex)) {
	ssa = stoHTML(shop_Rarm)
} else {
	ssa = document.createElement("text")
}
bag = TraderInventory.getInstance("building_tailor", city_id).items;
var shop_Body = getBody(jobIndex);
if (itemGain(shop_Body, jobIndex) > itemGain(the_Body, jobIndex)) {
	ssb = stoHTML(shop_Body)
} else {
	ssb = document.createElement("text")
}
var shop_Head = getHead(jobIndex);
if (itemGain(shop_Head, jobIndex) > itemGain(the_Head, jobIndex)) {
	ssh = stoHTML(shop_Head)
} else {
	ssh = document.createElement("text")
}
var shop_Foot = getFoot(jobIndex);
if (itemGain(shop_Foot, jobIndex) > itemGain(the_Foot, jobIndex)) {
	ssf = stoHTML(shop_Foot)
} else {
	ssf = document.createElement("text")
}
var shopOut = "<b>TA KALYTERA ANTKEIMENA POY BRE8HKAN STA MAGAZIA:</b>";
function toHTML(it) {
	var output;
	var txt;
	var simage = document.createElement("img");
	simage = it.img;
	output = document.createElement("p");
	output.innerHTML = "<b>" + it.get_name() + "</b>";
	output.appendChild(simage);
	txt = document.createElement("text");
	txt.innerHTML = "<b>kerdos: " + itemGain(it, jobIndex) + "</b>";
	output.appendChild(txt);
	return output
}
function stoHTML(it) {
	var cur_gain = 0;
	if (it.get_type() == "body") {
		cur_gain = itemGain(the_Body, jobIndex)
	} else {
		if (it.get_type() == "head") {
			cur_gain = itemGain(the_Head, jobIndex)
		} else {
			if (it.get_type() == "foot") {
				cur_gain = itemGain(the_Foot, jobIndex)
			} else {
				if (it.get_type() == "neck") {
					cur_gain = itemGain(the_Neck, jobIndex)
				}
			}
		}
	}
	if (it.get_type() == "right_arm") {
		cur_gain = itemGain(the_Rarm, jobIndex)
	}
	var simage = document.createElement("img");
	simage = it.img;
	var output = document.createElement("p");
	output.innerHTML = "<b>" + it.get_name() + "</b>";
	output.appendChild(simage);
	var txt = document.createElement("text");
	txt.innerHTML = "<b>kerdos: " + itemGain(it, jobIndex) + "-" + cur_gain
			+ '=<font color="green">' + (itemGain(it, jobIndex) - cur_gain)
			+ "</font>, kostos: " + it.get_buy_price() + "$</b>";
	output.appendChild(txt);
	return output
}
function intro() {
	var output = document.createElement("p");
	output.innerHTML = "<b>JOB: " + JobList[jobIndex].name + "</b>";
	return output
}
var Epilogos = document.createElement("p");
var setInfoP = document.createElement("p");
function epilogos() {
	var sum1 = itemGain(disHead, jobIndex) + itemGain(disNeck, jobIndex)
			+ itemGain(disRarm, jobIndex) + itemGain(disBody, jobIndex)
			+ itemGain(disFoot, jobIndex) + itemGain(disYield, jobIndex);
	setInfoP.innerHTML = "";
	sum1 = sum1 + mexicanGain(checkMexican(), jobIndex);
	if (checkMexican() > 1) {
		setInfoP.innerHTML += "<br />Mexican's set (" + checkMexican() + "):+"
				+ mexicanGain(checkMexican(), jobIndex)
	}
	sum1 = sum1 + charlatanGain(checkCharlatan(), jobIndex);
	if (checkCharlatan() > 1) {
		setInfoP.innerHTML += "<br />Charlatan's set (" + checkCharlatan()
				+ "):+" + charlatanGain(checkCharlatan(), jobIndex)
	}
	sum1 = sum1 + gentlemanGain(checkGentleman(), jobIndex);
	if (checkGentleman() > 1) {
		setInfoP.innerHTML += "<br />Gentleman's set (" + checkGentleman()
				+ "):+" + gentlemanGain(checkGentleman(), jobIndex)
	}
	sum1 = sum1 + dancerGain(checkDancer(), jobIndex);
	if (checkDancer() > 1) {
		setInfoP.innerHTML += "<br />Dancer's set (" + checkDancer() + "):+"
				+ dancerGain(checkDancer(), jobIndex)
	}
	sum1 = sum1 + farmerGain(checkFarmer(), jobIndex);
	if (checkFarmer() > 1) {
		setInfoP.innerHTML += "<br />Farmer's set (" + checkFarmer() + "):+"
				+ farmerGain(checkFarmer(), jobIndex)
	}
	sum1 = sum1 + indianGain(checkIndian(), jobIndex);
	if (checkIndian() > 1) {
		setInfoP.innerHTML += "<br />Indian's set (" + checkIndian() + "):+"
				+ indianGain(checkIndian(), jobIndex)
	}
	sum1 = sum1 + pilgrimFGain(checkPilgrimF(), jobIndex);
	if (checkPilgrimF() > 1) {
		setInfoP.innerHTML += "<br />Pilgrim's dress set (" + checkPilgrimF()
				+ "):+" + pilgrimFGain(checkPilgrimF(), jobIndex)
	}
	sum1 = sum1 + pilgrimGain(checkPilgrim(), jobIndex);
	if (checkPilgrim() > 1) {
		setInfoP.innerHTML += "<br />Pilgrim's set (" + checkPilgrim() + "):+"
				+ pilgrimGain(checkPilgrim(), jobIndex)
	}
	setInfoP.innerHTML += "<hr />";
	var sum2 = JobList[jobIndex].calcJobPoints(Character.skills);
	var sum = sum1 + sum2;
	var laborp = sum - JobList[jobIndex].malus;
	var col = "<font>";
	var conclusion = "</b>";
	if (laborp <= 0) {
		col = '<font color="#AA0000">';
		conclusion = '<font color="#700000">YOU CAN NOT DO THE JOB</font></b>'
	} else {
		col = '<font color="#1A641B">'
	}
	Epilogos.innerHTML = "<b>you've got " + sum
			+ " labour points. The job requires " + JobList[jobIndex].malus
			+ "<br />Total: " + col + '<span id="epspan">' + laborp
			+ "</span></font><br />" + conclusion;
	if (jobIndex == 94 || jobIndex == 95) {
		Epilogos.innerHTML += "<br />";
		var theFortSet = new Array();
		theFortSet.push(disHead);
		theFortSet.push(disBody);
		theFortSet.push(disFoot);
		theFortSet.push(disNeck);
		theFortSet.push(disRarm);
		theFortSet.push(disYield);
		theFortSet.push(disAnimal);
		if (jobIndex == 94) {
			jobIndex = 96;
			var lsum = epilogosMini(theFortSet);
			jobIndex = 97;
			var hsum = epilogosMini(theFortSet);
			jobIndex = 98;
			var asum = epilogosMini(theFortSet);
			jobIndex = 99;
			var dsum = epilogosMini(theFortSet);
			jobIndex = 101;
			var healthsum = epilogosMini(theFortSet) - Character.skills.health;
			jobIndex = 94;
			lsum = valueToFortBonus(lsum);
			hsum = valueToFortBonus(hsum);
			asum = valueToFortBonus(asum);
			dsum = valueToFortBonus(dsum);
			var sum94a = Math.round((lsum + hsum + asum) * 10) / 10;
			var sum94d = Math.round((lsum + hsum + dsum) * 10) / 10;
			Epilogos.innerHTML = "shooting bonus: " + sum94a
					+ " <br /> dodging bonus: " + sum94d + "<br />";
			var epTb = document.createElement("table");
			var epTbr1 = document.createElement("tr");
			var epTbr1c1 = document.createElement("td");
			epTbr1c1.innerHTML = "leadership:";
			var epTbr1c2 = document.createElement("td");
			epTbr1c2.innerHTML = round1000(lsum);
			epTbr1.appendChild(epTbr1c1);
			epTbr1.appendChild(epTbr1c2);
			epTb.appendChild(epTbr1);
			var epTbr2 = document.createElement("tr");
			var epTbr2c1 = document.createElement("td");
			epTbr2c1.innerHTML = "hiding:";
			var epTbr2c2 = document.createElement("td");
			epTbr2c2.innerHTML = round1000(hsum);
			epTbr2.appendChild(epTbr2c1);
			epTbr2.appendChild(epTbr2c2);
			epTb.appendChild(epTbr2);
			var epTbr3 = document.createElement("tr");
			var epTbr3c1 = document.createElement("td");
			epTbr3c1.innerHTML = "aim:";
			var epTbr3c2 = document.createElement("td");
			epTbr3c2.innerHTML = round1000(asum);
			epTbr3.appendChild(epTbr3c1);
			epTbr3.appendChild(epTbr3c2);
			epTb.appendChild(epTbr3);
			var epTbr4 = document.createElement("tr");
			var epTbr4c1 = document.createElement("td");
			epTbr4c1.innerHTML = "dodge:";
			var epTbr4c2 = document.createElement("td");
			epTbr4c2.innerHTML = round1000(dsum);
			epTbr4.appendChild(epTbr4c1);
			epTbr4.appendChild(epTbr4c2);
			epTb.appendChild(epTbr4);
			var epTbr5 = document.createElement("tr");
			var epTbr5c1 = document.createElement("td");
			epTbr5c1.innerHTML = "exta health points:";
			var epTbr5c2 = document.createElement("td");
			epTbr5c2.innerHTML = healthsum;
			epTbr5.appendChild(epTbr5c1);
			epTbr5.appendChild(epTbr5c2);
			epTb.appendChild(epTbr5);
			setInfoP.appendChild(epTb)
		} else {
			if (jobIndex == 95) {
				jobIndex = 96;
				var lsum = epilogosMini(theFortSet);
				jobIndex = 100;
				var stsum = epilogosMini(theFortSet);
				jobIndex = 98;
				var asum = epilogosMini(theFortSet);
				jobIndex = 99;
				var dsum = epilogosMini(theFortSet);
				jobIndex = 101;
				var healthsum = epilogosMini(theFortSet)
						- Character.skills.health;
				jobIndex = 95;
				lsum = valueToFortBonus(lsum);
				stsum = valueToFortBonus(stsum);
				asum = valueToFortBonus(asum);
				dsum = valueToFortBonus(dsum);
				var sum95a = Math.round((lsum + stsum + asum) * 10) / 10;
				var sum95d = Math.round((lsum + stsum + dsum) * 10) / 10;
				Epilogos.innerHTML = "shooting bonus: " + sum95a
						+ " <br /> dodging bonus: " + sum95d + "<br />";
				var epTb = document.createElement("table");
				var epTbr1 = document.createElement("tr");
				var epTbr1c1 = document.createElement("td");
				epTbr1c1.innerHTML = "leadership:";
				var epTbr1c2 = document.createElement("td");
				epTbr1c2.innerHTML = round1000(lsum);
				epTbr1.appendChild(epTbr1c1);
				epTbr1.appendChild(epTbr1c2);
				epTb.appendChild(epTbr1);
				var epTbr2 = document.createElement("tr");
				var epTbr2c1 = document.createElement("td");
				epTbr2c1.innerHTML = "stamina:";
				var epTbr2c2 = document.createElement("td");
				epTbr2c2.innerHTML = round1000(stsum);
				epTbr2.appendChild(epTbr2c1);
				epTbr2.appendChild(epTbr2c2);
				epTb.appendChild(epTbr2);
				var epTbr3 = document.createElement("tr");
				var epTbr3c1 = document.createElement("td");
				epTbr3c1.innerHTML = "aim:";
				var epTbr3c2 = document.createElement("td");
				epTbr3c2.innerHTML = round1000(asum);
				epTbr3.appendChild(epTbr3c1);
				epTbr3.appendChild(epTbr3c2);
				epTb.appendChild(epTbr3);
				var epTbr4 = document.createElement("tr");
				var epTbr4c1 = document.createElement("td");
				epTbr4c1.innerHTML = "dodge:";
				var epTbr4c2 = document.createElement("td");
				epTbr4c2.innerHTML = round1000(dsum);
				epTbr4.appendChild(epTbr4c1);
				epTbr4.appendChild(epTbr4c2);
				epTb.appendChild(epTbr4);
				var epTbr5 = document.createElement("tr");
				var epTbr5c1 = document.createElement("td");
				epTbr5c1.innerHTML = "exta health points:";
				var epTbr5c2 = document.createElement("td");
				epTbr5c2.innerHTML = healthsum;
				epTbr5.appendChild(epTbr5c1);
				epTbr5.appendChild(epTbr5c2);
				epTb.appendChild(epTbr5);
				setInfoP.appendChild(epTb)
			}
		}
	}
	if (jobIndex == 102) {
		var speed1 = sum + 100 / disAnimal.obj.speed;
		if (Character.characterClass == "duelist") {
			if ((new Date()).getTime() > PremiumBoni.endTimes.characterEnd) {
				speed1 = speed1 * 1.1
			} else {
				speed1 = speed1 * 1.2
			}
		}
		if (checkIndian() > 0) {
			speed1 = speed1 * ((checkIndian() - 1) * 0.15 + 1)
		}
		if (checkMexican() > 0) {
			speed1 = speed1 * ((checkMexican() - 1) * 0.12 + 1)
		}
		Epilogos.innerHTML = "<br /><br />speed: " + Math.round(speed1)
				+ "% <br /> "
	}
	return Epilogos
}
function round1000(v) {
	var ov = String(Math.round((v) * 1000) / 1000);
	if (ov.indexOf(".") < 0) {
		ov += ".0"
	}
	for ( var i = 0, l = ov.length; i < 5 - l; i++) {
		ov += "0"
	}
	return ov
}
var tryHead = document.createElement("div");
var tryHeadStatus = document.createElement("div");
var tryHeadname = document.createElement("div");
var tryHeadtext = document.createElement("div");
tryHead.setAttribute("id", "tryhead");
var selHead = document.createElement("select");
var selHeads = new Array();
bag = TraderInventory.getInstance("building_tailor", city_id).items;
for ( var p in bag) {
	if (bag[p].get_type() == "head") {
		selHeads.push(bag[p])
	}
}
var html_selHeads = new Array();
var Shgain = 0;
Shgain = itemGain(shop_Head, jobIndex);
var myhgain = itemGain(the_Head, jobIndex);
var shgain = 0;
for ( var i = 0; i < selHeads.length; i++) {
	html_selHeads.push(document.createElement("option"));
	html_selHeads[i].setAttribute("id", "h" + i);
	html_selHeads[i].setAttribute("value", selHeads[i].get_name());
	var best = "";
	shgain = 0;
	shgain = itemGain(selHeads[i], jobIndex);
	if (shgain > myhgain) {
		if (isUnique(selHeads[i], BShopHeads)) {
			BShopHeads.push(selHeads[i])
		}
		best = "";
		html_selHeads[i].setAttribute("style",
				"color: #162F08 ; font-weight: bold")
	} else {
		if (shgain == myhgain && myhgain != 0) {
			best = "";
			html_selHeads[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			best = "";
			html_selHeads[i].setAttribute("style", "color: #523F30")
		}
	}
	if (Shgain == shgain && Shgain - myhgain > 0) {
		best = "";
		html_selHeads[i].setAttribute("style",
				"color: #1A641B ; font-weight: bolder")
	}
	html_selHeads[i].innerHTML = best + selHeads[i].get_name() + " (" + shgain
			+ "-" + myhgain + ")=" + (shgain - myhgain);
	selHead.appendChild(html_selHeads[i]);
	if (isSetItem(selHeads[i]) && isUnique(selHeads[i], BShopHeads)) {
		BShopHeads.push(selHeads[i])
	}
}
var tryHeadImage = document.createElement("img");
for ( var i = 0; i < selHeads.length; i++) {
	tryHeadImage = selHeads[i].img;
	tryHead.appendChild(tryHeadImage);
	tryHead.removeChild(tryHeadImage)
}
selHead
		.setAttribute(
				"onchange",
				"tryHeadImage=selHeads[selHead.selectedIndex].img;tryHead.innerHTML=' ';tryHead.appendChild(tryHeadImage);tryHeadStatus.innerHTML='Shop item';tryHead.appendChild(document.createElement('br'));shgain=itemGain(selHeads[selHead.selectedIndex],jobIndex);tryHead.appendChild(document.createTextNode('gain:'+' '+shgain));tryHead.appendChild(document.createElement('br'));tryHead.appendChild(document.createTextNode('net:'+' ('+shgain+'-'+myhgain+')='+(shgain-myhgain)));disHead=selHeads[selHead.selectedIndex];epilogos();tryHeadImage.style.width=\"50px\";tryHeadImage.style.height=\"50px\";");
selHead
		.setAttribute(
				"onclick",
				"tryHeadImage=selHeads[selHead.selectedIndex].img;tryHead.innerHTML=' ';tryHead.appendChild(tryHeadImage);tryHeadStatus.innerHTML='Shop item';tryHead.appendChild(document.createElement('br'));shgain=itemGain(selHeads[selHead.selectedIndex],jobIndex);tryHead.appendChild(document.createTextNode('gain:'+' '+shgain));tryHead.appendChild(document.createElement('br'));tryHead.appendChild(document.createTextNode('net:'+' ('+shgain+'-'+myhgain+')='+(shgain-myhgain)));disHead=selHeads[selHead.selectedIndex];epilogos();tryHeadImage.style.width=\"50px\";tryHeadImage.style.height=\"50px\";");
selHead.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
var tryBody = document.createElement("div");
var tryBodyStatus = document.createElement("div");
var tryBodyname = document.createElement("div");
var tryBodytext = document.createElement("div");
tryBody.setAttribute("id", "trybody");
var selBody = document.createElement("select");
var selBodys = new Array();
bag = TraderInventory.getInstance("building_tailor", city_id).items;
for ( var p in bag) {
	if (bag[p].get_type() == "body") {
		selBodys.push(bag[p])
	}
}
var html_selBodys = new Array();
var Sbgain = 0;
Sbgain = itemGain(shop_Body, jobIndex);
var mybgain = itemGain(the_Body, jobIndex);
var sbgain = 0;
for ( var i = 0; i < selBodys.length; i++) {
	html_selBodys.push(document.createElement("option"));
	html_selBodys[i].setAttribute("id", "b" + i);
	html_selBodys[i].setAttribute("value", selBodys[i].get_name());
	var best = "";
	sbgain = 0;
	sbgain = itemGain(selBodys[i], jobIndex);
	if (sbgain > mybgain) {
		if (isUnique(selBodys[i], BShopBodys)) {
			BShopBodys.push(selBodys[i])
		}
		best = "";
		html_selBodys[i].setAttribute("style",
				"color: #162F08 ; font-weight: bold")
	} else {
		if (sbgain == mybgain && mybgain != 0) {
			best = "";
			html_selBodys[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			best = "";
			html_selBodys[i].setAttribute("style", "color: #523F30")
		}
	}
	if (Sbgain == sbgain && Sbgain - mybgain > 0) {
		best = "";
		html_selBodys[i].setAttribute("style",
				"color: #1A641B ; font-weight: bolder")
	}
	html_selBodys[i].innerHTML = best + selBodys[i].get_name() + " (" + sbgain
			+ "-" + mybgain + ")=" + (sbgain - mybgain);
	selBody.appendChild(html_selBodys[i]);
	if (isSetItem(selBodys[i]) && isUnique(selBodys[i], BShopBodys)) {
		BShopBodys.push(selBodys[i])
	}
}
var tryBodyImage = document.createElement("img");
for ( var i = 0; i < selBodys.length; i++) {
	tryBodyImage = selBodys[i].img;
	tryBody.appendChild(tryBodyImage);
	tryBody.removeChild(tryBodyImage)
}
selBody
		.setAttribute(
				"onchange",
				"tryBodyImage=selBodys[selBody.selectedIndex].img;tryBody.innerHTML=' ';tryBody.appendChild(tryBodyImage);tryBodyStatus.innerHTML='Shop item';tryBody.appendChild(document.createElement('br'));sbgain=itemGain(selBodys[selBody.selectedIndex],jobIndex);tryBody.appendChild(document.createTextNode('gain:'+' '+sbgain));tryBody.appendChild(document.createElement('br'));tryBody.appendChild(document.createTextNode('net:'+' ('+sbgain+'-'+mybgain+')='+(sbgain-mybgain)));disBody=selBodys[selBody.selectedIndex];epilogos();");
selBody
		.setAttribute(
				"onclick",
				"tryBodyImage=selBodys[selBody.selectedIndex].img;tryBody.innerHTML=' ';tryBody.appendChild(tryBodyImage);tryBodyStatus.innerHTML='Shop item';tryBody.appendChild(document.createElement('br'));sbgain=itemGain(selBodys[selBody.selectedIndex],jobIndex);tryBody.appendChild(document.createTextNode('gain:'+' '+sbgain));tryBody.appendChild(document.createElement('br'));tryBody.appendChild(document.createTextNode('net:'+' ('+sbgain+'-'+mybgain+')='+(sbgain-mybgain)));disBody=selBodys[selBody.selectedIndex];epilogos();");
selBody.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
var myselBody = document.createElement("select");
var myselBodys = new Array();
bag = Bag.getInstance().items;
myselBodys.push(wearing_items.body);
for ( var p in bag) {
	if (bag[p].get_type() == "body") {
		myselBodys.push(bag[p])
	}
}
var myhtml_selBodys = new Array();
mybgain = itemGain(the_Body, jobIndex);
for ( var i = 0; i < myselBodys.length; i++) {
	myhtml_selBodys.push(document.createElement("option"));
	myhtml_selBodys[i].setAttribute("id", "myb" + i);
	myhtml_selBodys[i].setAttribute("value", myselBodys[i].get_name());
	var best = "";
	sbgain = 0;
	sbgain = itemGain(myselBodys[i], jobIndex);
	if (sbgain == mybgain && mybgain != 0) {
		best = "";
		myhtml_selBodys[i].setAttribute("style",
				"color: #1A641B ; font-weight: bold")
	} else {
		if (sbgain == 0) {
			best = "";
			myhtml_selBodys[i].setAttribute("style", "color: #523F30")
		} else {
			best = "";
			myhtml_selBodys[i].setAttribute("style", "color: #162F08")
		}
	}
	myhtml_selBodys[i].innerHTML = best + myselBodys[i].get_name() + " "
			+ sbgain;
	myselBody.appendChild(myhtml_selBodys[i])
}
tryBodyStatus.innerHTML = "Inventory Item";
for ( var i = 0; i < myselBodys.length; i++) {
	tryBodyImage = myselBodys[i].img;
	tryBody.appendChild(tryBodyImage);
	tryBody.removeChild(tryBodyImage)
}
tryBodyImage = the_Body.img;
tryBody.appendChild(tryBodyImage);
tryBody.appendChild(document.createElement("br"));
sbgain = itemGain(the_Body, jobIndex);
tryBody.appendChild(document.createTextNode("gain: " + sbgain));
myselBody
		.setAttribute(
				"onchange",
				"tryBodyImage=myselBodys[myselBody.selectedIndex].img;tryBody.innerHTML=' ';tryBody.appendChild(tryBodyImage);tryBodyStatus.innerHTML='Inventory item';tryBody.appendChild(document.createElement('br'));sbgain=itemGain(myselBodys[myselBody.selectedIndex],jobIndex);tryBody.appendChild(document.createTextNode('gain:'+' '+sbgain));disBody=myselBodys[myselBody.selectedIndex];epilogos();");
myselBody
		.setAttribute(
				"onclick",
				"tryBodyImage=myselBodys[myselBody.selectedIndex].img;tryBody.innerHTML=' ';tryBody.appendChild(tryBodyImage);tryBodyStatus.innerHTML='Inventory item';tryBody.appendChild(document.createElement('br'));sbgain=itemGain(myselBodys[myselBody.selectedIndex],jobIndex);tryBody.appendChild(document.createTextNode('gain:'+' '+sbgain));disBody=myselBodys[myselBody.selectedIndex];epilogos();");
myselBody.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
for ( var i = 0; i < myselBodys.length; i++) {
	if (myselBodys[i].get_name() == the_Body.get_name()) {
		myselBody.selectedIndex = i;
		break
	}
}
var myselHead = document.createElement("select");
var myselHeads = new Array();
bag = Bag.getInstance().items;
myselHeads.push(wearing_items.head);
for ( var p in bag) {
	if (bag[p].get_type() == "head") {
		myselHeads.push(bag[p])
	}
}
var myhtml_selHeads = new Array();
myhgain = itemGain(the_Head, jobIndex);
for ( var i = 0; i < myselHeads.length; i++) {
	myhtml_selHeads.push(document.createElement("option"));
	myhtml_selHeads[i].setAttribute("id", "myh" + i);
	myhtml_selHeads[i].setAttribute("value", myselHeads[i].get_name());
	var best = "";
	shgain = 0;
	shgain = itemGain(myselHeads[i], jobIndex);
	if (shgain == myhgain && myhgain != 0) {
		best = "";
		myhtml_selHeads[i].setAttribute("style",
				"color: #1A641B ; font-weight: bold")
	} else {
		if (shgain == 0) {
			best = "";
			myhtml_selHeads[i].setAttribute("style", "color: #523F30")
		} else {
			best = "";
			myhtml_selHeads[i].setAttribute("style", "color: #162F08")
		}
	}
	myhtml_selHeads[i].innerHTML = best + myselHeads[i].get_name() + " "
			+ shgain;
	myselHead.appendChild(myhtml_selHeads[i])
}
tryHeadStatus.innerHTML = "Inventory Item";
for ( var i = 0; i < myselHeads.length; i++) {
	tryHeadImage = myselHeads[i].img;
	tryHead.appendChild(tryHeadImage);
	tryHead.removeChild(tryHeadImage)
}
tryHeadImage = the_Head.img;
tryHead.appendChild(tryHeadImage);
tryHead.appendChild(document.createElement("br"));
shgain = itemGain(the_Head, jobIndex);
tryHead.appendChild(document.createTextNode("gain: " + shgain));
myselHead
		.setAttribute(
				"onchange",
				"tryHeadImage=myselHeads[myselHead.selectedIndex].img;tryHead.innerHTML=' ';tryHead.appendChild(tryHeadImage);tryHeadStatus.innerHTML='Inventory item';tryHead.appendChild(document.createElement('br'));shgain=itemGain(myselHeads[myselHead.selectedIndex],jobIndex);tryHead.appendChild(document.createTextNode('gain:'+' '+shgain));disHead=myselHeads[myselHead.selectedIndex];epilogos();tryHeadImage.style.width=\"50px\";tryHeadImage.style.height=\"50px\";");
myselHead
		.setAttribute(
				"onclick",
				"tryHeadImage=myselHeads[myselHead.selectedIndex].img;tryHead.innerHTML=' ';tryHead.appendChild(tryHeadImage);tryHeadStatus.innerHTML='Inventory item';tryHead.appendChild(document.createElement('br'));shgain=itemGain(myselHeads[myselHead.selectedIndex],jobIndex);tryHead.appendChild(document.createTextNode('gain:'+' '+shgain));disHead=myselHeads[myselHead.selectedIndex];epilogos();tryHeadImage.style.width=\"50px\";tryHeadImage.style.height=\"50px\";");
myselHead.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
for ( var i = 0; i < myselHeads.length; i++) {
	if (myselHeads[i].get_name() == the_Head.get_name()) {
		myselHead.selectedIndex = i;
		break
	}
}
var tryFoot = document.createElement("div");
var tryFootStatus = document.createElement("div");
var tryFootname = document.createElement("div");
var tryFoottext = document.createElement("div");
tryFoot.setAttribute("id", "tryfoot");
var selFoot = document.createElement("select");
var selFoots = new Array();
bag = TraderInventory.getInstance("building_tailor", city_id).items;
for ( var p in bag) {
	if (bag[p].get_type() == "foot") {
		selFoots.push(bag[p])
	}
}
var html_selFoots = new Array();
var Sfgain = 0;
Sfgain = itemGain(shop_Foot, jobIndex);
var myfgain = itemGain(the_Foot, jobIndex);
var sfgain = 0;
for ( var i = 0; i < selFoots.length; i++) {
	html_selFoots.push(document.createElement("option"));
	html_selFoots[i].setAttribute("id", "f" + i);
	html_selFoots[i].setAttribute("value", selFoots[i].get_name());
	var best = "";
	sfgain = 0;
	sfgain = itemGain(selFoots[i], jobIndex);
	if (sfgain > myfgain) {
		if (isUnique(selFoots[i], BShopFoots)) {
			BShopFoots.push(selFoots[i])
		}
		best = "";
		html_selFoots[i].setAttribute("style",
				"color: #162F08 ; font-weight: bold")
	} else {
		if (sfgain == myfgain && myfgain != 0) {
			best = "";
			html_selFoots[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			best = "";
			html_selFoots[i].setAttribute("style", "color: #523F30")
		}
	}
	if (Sfgain == sfgain && Sfgain - myfgain > 0) {
		best = "";
		html_selFoots[i].setAttribute("style",
				"color: #1A641B ; font-weight: bolder")
	}
	html_selFoots[i].innerHTML = best + selFoots[i].get_name() + " (" + sfgain
			+ "-" + myfgain + ")=" + (sfgain - myfgain);
	selFoot.appendChild(html_selFoots[i]);
	if (isSetItem(selFoots[i]) && isUnique(selFoots[i], BShopFoots)) {
		BShopFoots.push(selFoots[i])
	}
}
var tryFootImage = document.createElement("img");
for ( var i = 0; i < selFoots.length; i++) {
	tryFootImage = selFoots[i].img;
	tryFoot.appendChild(tryFootImage);
	tryFoot.removeChild(tryFootImage)
}
selFoot
		.setAttribute(
				"onchange",
				"tryFootImage=selFoots[selFoot.selectedIndex].img;tryFoot.innerHTML=' ';tryFoot.appendChild(tryFootImage);tryFootStatus.innerHTML='Shop item';tryFoot.appendChild(document.createElement('br'));sfgain=itemGain(selFoots[selFoot.selectedIndex],jobIndex);tryFoot.appendChild(document.createTextNode('gain:'+' '+sfgain));tryFoot.appendChild(document.createElement('br'));tryFoot.appendChild(document.createTextNode('net:'+' ('+sfgain+'-'+myfgain+')='+(sfgain-myfgain)));disFoot=selFoots[selFoot.selectedIndex];epilogos();");
selFoot
		.setAttribute(
				"onclick",
				"tryFootImage=selFoots[selFoot.selectedIndex].img;tryFoot.innerHTML=' ';tryFoot.appendChild(tryFootImage);tryFootStatus.innerHTML='Shop item';tryFoot.appendChild(document.createElement('br'));sfgain=itemGain(selFoots[selFoot.selectedIndex],jobIndex);tryFoot.appendChild(document.createTextNode('gain:'+' '+sfgain));tryFoot.appendChild(document.createElement('br'));tryFoot.appendChild(document.createTextNode('net:'+' ('+sfgain+'-'+myfgain+')='+(sfgain-myfgain)));disFoot=selFoots[selFoot.selectedIndex];epilogos();");
selFoot.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
var myselFoot = document.createElement("select");
var myselFoots = new Array();
bag = Bag.getInstance().items;
myselFoots.push(wearing_items.foot);
for ( var p in bag) {
	if (bag[p].get_type() == "foot") {
		myselFoots.push(bag[p])
	}
}
var myhtml_selFoots = new Array();
myfgain = itemGain(the_Foot, jobIndex);
for ( var i = 0; i < myselFoots.length; i++) {
	myhtml_selFoots.push(document.createElement("option"));
	myhtml_selFoots[i].setAttribute("id", "myf" + i);
	myhtml_selFoots[i].setAttribute("value", myselFoots[i].get_name());
	var best = "";
	sfgain = 0;
	sfgain = itemGain(myselFoots[i], jobIndex);
	if (sfgain == myfgain && myfgain != 0) {
		best = "";
		myhtml_selFoots[i].setAttribute("style",
				"color: #1A641B ; font-weight: bold")
	} else {
		if (sfgain == 0) {
			best = "";
			myhtml_selFoots[i].setAttribute("style", "color: #523F30")
		} else {
			best = "";
			myhtml_selFoots[i].setAttribute("style", "color: #162F08")
		}
	}
	myhtml_selFoots[i].innerHTML = best + myselFoots[i].get_name() + " "
			+ sfgain;
	myselFoot.appendChild(myhtml_selFoots[i])
}
tryFootStatus.innerHTML = "Inventory Item";
for ( var i = 0; i < myselFoots.length; i++) {
	tryFootImage = myselFoots[i].img;
	tryFoot.appendChild(tryFootImage);
	tryFoot.removeChild(tryFootImage)
}
tryFootImage = the_Foot.img;
tryFoot.appendChild(tryFootImage);
tryFoot.appendChild(document.createElement("br"));
sfgain = itemGain(the_Foot, jobIndex);
tryFoot.appendChild(document.createTextNode("gain: " + sfgain));
myselFoot
		.setAttribute(
				"onchange",
				"tryFootImage=myselFoots[myselFoot.selectedIndex].img;tryFoot.innerHTML=' ';tryFoot.appendChild(tryFootImage);tryFootStatus.innerHTML='Inventory item';tryFoot.appendChild(document.createElement('br'));sfgain=itemGain(myselFoots[myselFoot.selectedIndex],jobIndex);tryFoot.appendChild(document.createTextNode('gain:'+' '+sfgain));disFoot=myselFoots[myselFoot.selectedIndex];epilogos();");
myselFoot
		.setAttribute(
				"onclick",
				"tryFootImage=myselFoots[myselFoot.selectedIndex].img;tryFoot.innerHTML=' ';tryFoot.appendChild(tryFootImage);tryFootStatus.innerHTML='Inventory item';tryFoot.appendChild(document.createElement('br'));sfgain=itemGain(myselFoots[myselFoot.selectedIndex],jobIndex);tryFoot.appendChild(document.createTextNode('gain:'+' '+sfgain));disFoot=myselFoots[myselFoot.selectedIndex];epilogos();");
myselFoot.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
for ( var i = 0; i < myselFoots.length; i++) {
	if (myselFoots[i].get_name() == the_Foot.get_name()) {
		myselFoot.selectedIndex = i;
		break
	}
}
var tryNeck = document.createElement("div");
var tryNeckStatus = document.createElement("div");
var tryNeckname = document.createElement("div");
var tryNecktext = document.createElement("div");
tryNeck.setAttribute("id", "tryneck");
var selNeck = document.createElement("select");
var selNecks = new Array();
bag = TraderInventory.getInstance("building_general", city_id).items;
for ( var p in bag) {
	if (bag[p].get_type() == "neck") {
		selNecks.push(bag[p])
	}
}
var html_selNecks = new Array();
var Sngain = 0;
Sngain = itemGain(shop_Neck, jobIndex);
var myngain = itemGain(the_Neck, jobIndex);
var sngain = 0;
for ( var i = 0; i < selNecks.length; i++) {
	html_selNecks.push(document.createElement("option"));
	html_selNecks[i].setAttribute("id", "n" + i);
	html_selNecks[i].setAttribute("value", selNecks[i].get_name());
	var best = "";
	sngain = 0;
	sngain = itemGain(selNecks[i], jobIndex);
	if (sngain > myngain) {
		if (isUnique(selNecks[i], BShopNecks)) {
			BShopNecks.push(selNecks[i])
		}
		best = "";
		html_selNecks[i].setAttribute("style",
				"color: #162F08 ; font-weight: bold")
	} else {
		if (sngain == myngain && myngain != 0) {
			best = "";
			html_selNecks[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			best = "";
			html_selNecks[i].setAttribute("style", "color: #523F30")
		}
	}
	if (Sngain == sngain && Sngain - myngain > 0) {
		best = "";
		html_selNecks[i].setAttribute("style",
				"color: #1A641B ; font-weight: bolder")
	}
	html_selNecks[i].innerHTML = best + selNecks[i].get_name() + " (" + sngain
			+ "-" + myngain + ")=" + (sngain - myngain);
	selNeck.appendChild(html_selNecks[i]);
	if (isSetItem(selNecks[i]) && isUnique(selNecks[i], BShopNecks)) {
		BShopNecks.push(selNecks[i])
	}
}
var tryNeckImage = document.createElement("img");
for ( var i = 0; i < selNecks.length; i++) {
	tryNeckImage = selNecks[i].img;
	tryNeck.appendChild(tryNeckImage);
	tryNeck.removeChild(tryNeckImage)
}
selNeck
		.setAttribute(
				"onchange",
				"tryNeckImage=selNecks[selNeck.selectedIndex].img;tryNeck.innerHTML=' ';tryNeck.appendChild(tryNeckImage);tryNeckStatus.innerHTML='Shop item';tryNeck.appendChild(document.createElement('br'));sngain=itemGain(selNecks[selNeck.selectedIndex],jobIndex);tryNeck.appendChild(document.createTextNode('gain:'+' '+sngain));tryNeck.appendChild(document.createElement('br'));tryNeck.appendChild(document.createTextNode('net:'+' ('+sngain+'-'+myngain+')='+(sngain-myngain)));disNeck=selNecks[selNeck.selectedIndex];epilogos();");
selNeck
		.setAttribute(
				"onclick",
				"tryNeckImage=selNecks[selNeck.selectedIndex].img;tryNeck.innerHTML=' ';tryNeck.appendChild(tryNeckImage);tryNeckStatus.innerHTML='Shop item';tryNeck.appendChild(document.createElement('br'));sngain=itemGain(selNecks[selNeck.selectedIndex],jobIndex);tryNeck.appendChild(document.createTextNode('gain:'+' '+sngain));tryNeck.appendChild(document.createElement('br'));tryNeck.appendChild(document.createTextNode('net:'+' ('+sngain+'-'+myngain+')='+(sngain-myngain)));disNeck=selNecks[selNeck.selectedIndex];epilogos();");
selNeck.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
var myselNeck = document.createElement("select");
var myselNecks = new Array();
bag = Bag.getInstance().items;
myselNecks.push(wearing_items.neck);
for ( var p in bag) {
	if (bag[p].get_type() == "neck") {
		myselNecks.push(bag[p])
	}
}
var myhtml_selNecks = new Array();
myngain = itemGain(the_Neck, jobIndex);
for ( var i = 0; i < myselNecks.length; i++) {
	myhtml_selNecks.push(document.createElement("option"));
	myhtml_selNecks[i].setAttribute("id", "myn" + i);
	myhtml_selNecks[i].setAttribute("value", myselNecks[i].get_name());
	var best = "";
	sngain = 0;
	sngain = itemGain(myselNecks[i], jobIndex);
	if (sngain == myngain && myngain != 0) {
		best = "";
		myhtml_selNecks[i].setAttribute("style",
				"color: #1A641B ; font-weight: bold")
	} else {
		if (sngain == 0) {
			best = "";
			myhtml_selNecks[i].setAttribute("style", "color: #523F30")
		} else {
			best = "";
			myhtml_selNecks[i].setAttribute("style", "color: #162F08")
		}
	}
	myhtml_selNecks[i].innerHTML = best + myselNecks[i].get_name() + " "
			+ sngain;
	myselNeck.appendChild(myhtml_selNecks[i])
}
tryNeckStatus.innerHTML = "Inventory Item";
for ( var i = 0; i < myselNecks.length; i++) {
	tryNeckImage = myselNecks[i].img;
	tryNeck.appendChild(tryNeckImage);
	tryNeck.removeChild(tryNeckImage)
}
tryNeckImage = the_Neck.img;
tryNeck.appendChild(tryNeckImage);
tryNeck.appendChild(document.createElement("br"));
sngain = itemGain(the_Neck, jobIndex);
tryNeck.appendChild(document.createTextNode("gain: " + sngain));
myselNeck
		.setAttribute(
				"onchange",
				"tryNeckImage=myselNecks[myselNeck.selectedIndex].img;tryNeck.innerHTML=' ';tryNeck.appendChild(tryNeckImage);tryNeckStatus.innerHTML='Inventory item';tryNeck.appendChild(document.createElement('br'));sngain=itemGain(myselNecks[myselNeck.selectedIndex],jobIndex);tryNeck.appendChild(document.createTextNode('gain:'+' '+sngain));disNeck=myselNecks[myselNeck.selectedIndex];epilogos();");
myselNeck
		.setAttribute(
				"onclick",
				"tryNeckImage=myselNecks[myselNeck.selectedIndex].img;tryNeck.innerHTML=' ';tryNeck.appendChild(tryNeckImage);tryNeckStatus.innerHTML='Inventory item';tryNeck.appendChild(document.createElement('br'));sngain=itemGain(myselNecks[myselNeck.selectedIndex],jobIndex);tryNeck.appendChild(document.createTextNode('gain:'+' '+sngain));disNeck=myselNecks[myselNeck.selectedIndex];epilogos();");
myselNeck.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
for ( var i = 0; i < myselNecks.length; i++) {
	if (myselNecks[i].get_name() == the_Neck.get_name()) {
		myselNeck.selectedIndex = i;
		break
	}
}
var tryRarm = document.createElement("div");
var tryRarmStatus = document.createElement("div");
var tryRarmname = document.createElement("div");
var tryRarmtext = document.createElement("div");
tryRarm.setAttribute("id", "tryrarm");
var selRarm = document.createElement("select");
var selRarms = new Array();
bag = TraderInventory.getInstance("building_gunsmith", city_id).items;
for ( var p in bag) {
	if (bag[p].get_type() == "right_arm") {
		selRarms.push(bag[p])
	}
}
var html_selRarms = new Array();
var Srgain = 0;
Srgain = itemGain(shop_Rarm, jobIndex);
var myrgain = itemGain(the_Rarm, jobIndex);
var srgain = 0;
for ( var i = 0; i < selRarms.length; i++) {
	html_selRarms.push(document.createElement("option"));
	html_selRarms[i].setAttribute("id", "r" + i);
	html_selRarms[i].setAttribute("value", selRarms[i].get_name());
	var best = "";
	srgain = 0;
	srgain = itemGain(selRarms[i], jobIndex);
	if (srgain > myrgain) {
		if (isUnique(selRarms[i], BShopRarms)) {
			BShopRarms.push(selRarms[i])
		}
		best = "";
		html_selRarms[i].setAttribute("style",
				"color: #162F08 ; font-weight: bold")
	} else {
		if (srgain == myrgain && myrgain != 0) {
			best = "";
			html_selRarms[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			best = "";
			html_selRarms[i].setAttribute("style", "color: #523F30")
		}
	}
	if (Srgain == srgain && Srgain - myrgain > 0) {
		best = "";
		html_selRarms[i].setAttribute("style",
				"color: #1A641B ; font-weight: bolder")
	}
	html_selRarms[i].innerHTML = best + selRarms[i].get_name() + " (" + srgain
			+ "-" + myrgain + ")=" + (srgain - myrgain);
	selRarm.appendChild(html_selRarms[i]);
	if (isSetItem(selRarms[i]) && isUnique(selRarms[i], BShopRarms)) {
		BShopNecks.push(selRarms[i])
	}
}
var tryRarmImage = document.createElement("img");
for ( var i = 0; i < selRarms.length; i++) {
	tryRarmImage = selRarms[i].img;
	tryRarm.appendChild(tryRarmImage);
	tryRarm.removeChild(tryRarmImage)
}
selRarm
		.setAttribute(
				"onchange",
				"tryRarmImage=selRarms[selRarm.selectedIndex].img;tryRarm.innerHTML=' ';tryRarm.appendChild(tryRarmImage);tryRarmStatus.innerHTML='Shop item';tryRarm.appendChild(document.createElement('br'));srgain=itemGain(selRarms[selRarm.selectedIndex],jobIndex);tryRarm.appendChild(document.createTextNode('gain:'+' '+srgain));tryRarm.appendChild(document.createElement('br'));tryRarm.appendChild(document.createTextNode('net:'+' ('+srgain+'-'+myrgain+')='+(srgain-myrgain)));disRarm=selRarms[selRarm.selectedIndex];epilogos();");
selRarm
		.setAttribute(
				"onclick",
				"tryRarmImage=selRarms[selRarm.selectedIndex].img;tryRarm.innerHTML=' ';tryRarm.appendChild(tryRarmImage);tryRarmStatus.innerHTML='Shop item';tryRarm.appendChild(document.createElement('br'));srgain=itemGain(selRarms[selRarm.selectedIndex],jobIndex);tryRarm.appendChild(document.createTextNode('gain:'+' '+srgain));tryRarm.appendChild(document.createElement('br'));tryRarm.appendChild(document.createTextNode('net:'+' ('+srgain+'-'+myrgain+')='+(srgain-myrgain)));disRarm=selRarms[selRarm.selectedIndex];epilogos();");
selRarm.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
var myselRarm = document.createElement("select");
var myselRarms = new Array();
bag = Bag.getInstance().items;
myselRarms.push(wearing_items.right_arm);
for ( var p in bag) {
	if (bag[p].get_type() == "right_arm") {
		myselRarms.push(bag[p])
	}
}
var myhtml_selRarms = new Array();
myrgain = itemGain(the_Rarm, jobIndex);
for ( var i = 0; i < myselRarms.length; i++) {
	myhtml_selRarms.push(document.createElement("option"));
	myhtml_selRarms[i].setAttribute("id", "myr" + i);
	myhtml_selRarms[i].setAttribute("value", myselRarms[i].get_name());
	var best = "";
	srgain = 0;
	srgain = itemGain(myselRarms[i], jobIndex);
	if (srgain == myrgain && myrgain != 0) {
		best = "";
		myhtml_selRarms[i].setAttribute("style",
				"color: #1A641B ; font-weight: bold")
	} else {
		if (srgain == 0) {
			best = "";
			myhtml_selRarms[i].setAttribute("style", "color: #523F30")
		} else {
			best = "";
			myhtml_selRarms[i].setAttribute("style", "color: #162F08")
		}
	}
	myhtml_selRarms[i].innerHTML = best + myselRarms[i].get_name() + " "
			+ srgain;
	myselRarm.appendChild(myhtml_selRarms[i])
}
tryRarmStatus.innerHTML = "Inventory Item";
for ( var i = 0; i < myselRarms.length; i++) {
	tryRarmImage = myselRarms[i].img;
	tryRarm.appendChild(tryRarmImage);
	tryRarm.removeChild(tryRarmImage)
}
tryRarmImage = the_Rarm.img;
tryRarm.appendChild(tryRarmImage);
tryRarm.appendChild(document.createElement("br"));
srgain = itemGain(the_Rarm, jobIndex);
tryRarm.appendChild(document.createTextNode("gain: " + srgain));
myselRarm
		.setAttribute(
				"onchange",
				"tryRarmImage=myselRarms[myselRarm.selectedIndex].img;tryRarm.innerHTML=' ';tryRarm.appendChild(tryRarmImage);tryRarmStatus.innerHTML='Inventory item';tryRarm.appendChild(document.createElement('br'));srgain=itemGain(myselRarms[myselRarm.selectedIndex],jobIndex);tryRarm.appendChild(document.createTextNode('gain:'+' '+srgain));disRarm=myselRarms[myselRarm.selectedIndex];epilogos();");
myselRarm
		.setAttribute(
				"onclick",
				"tryRarmImage=myselRarms[myselRarm.selectedIndex].img;tryRarm.innerHTML=' ';tryRarm.appendChild(tryRarmImage);tryRarmStatus.innerHTML='Inventory item';tryRarm.appendChild(document.createElement('br'));srgain=itemGain(myselRarms[myselRarm.selectedIndex],jobIndex);tryRarm.appendChild(document.createTextNode('gain:'+' '+srgain));disRarm=myselRarms[myselRarm.selectedIndex];epilogos();");
myselRarm.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
for ( var i = 0; i < myselRarms.length; i++) {
	if (myselRarms[i].get_name() == the_Rarm.get_name()) {
		myselRarm.selectedIndex = i;
		break
	}
}
var tryYield = document.createElement("div");
var tryYieldStatus = document.createElement("div");
var tryYieldname = document.createElement("div");
var tryYieldtext = document.createElement("div");
tryYield.setAttribute("id", "tryyield");
var selYield = document.createElement("select");
var selYields = new Array();
bag = Bag.getInstance().items;
for ( var p in bag) {
	if (bag[p].get_type() == "yield") {
		selYields.push(bag[p])
	}
}
selYields.push(wearing_items.yield);
var html_selYields = new Array();
for ( var i = 0; i < selYields.length; i++) {
	html_selYields.push(document.createElement("option"));
	html_selYields[i].setAttribute("id", "y" + i);
	html_selYields[i].setAttribute("value", selYields[i].get_name());
	var best = "";
	if (selYields[i].get_short() == "potion"
			|| selYields[i].get_short() == "pitchfork"
			|| selYields[i].get_short() == "cane"
			|| selYields[i].get_short() == "hymnal"
			|| selYields[i].get_short() == "ring"
			|| selYields[i].get_short() == "tequila") {
		best = "";
		html_selYields[i].setAttribute("style",
				"color: #162F08 ; font-weight: bold")
	} else {
		best = "";
		html_selYields[i].setAttribute("style", "color: #523F30")
	}
	html_selYields[i].innerHTML = best + selYields[i].get_name();
	selYield.appendChild(html_selYields[i])
}
var tryYieldImage = document.createElement("img");
for ( var i = 0; i < selYields.length; i++) {
	tryYieldImage = selYields[i].img;
	tryYield.appendChild(tryYieldImage);
	tryYield.removeChild(tryYieldImage)
}
tryYieldImage = disYield.img;
tryYield.appendChild(tryYieldImage);
tryYield.appendChild(document.createElement("br"));
selYield
		.setAttribute(
				"onchange",
				"tryYieldImage=selYields[selYield.selectedIndex].img;tryYield.innerHTML=' ';tryYield.appendChild(tryYieldImage);tryYield.appendChild(document.createElement('br'));disYield=selYields[selYield.selectedIndex];epilogos();");
selYield
		.setAttribute(
				"oncdblclick",
				"tryYieldImage=selYields[selYield.selectedIndex].img;tryYield.innerHTML=' ';tryYield.appendChild(tryYieldImage);tryYield.appendChild(document.createElement('br'));disYield=selYields[selYield.selectedIndex];epilogos();");
selYield.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
for ( var i = 0; i < selYields.length; i++) {
	if (selYields[i].get_name() == disYield.get_name()) {
		selYield.selectedIndex = i;
		break
	}
}
var tryAnimal = document.createElement("div");
var tryAnimalStatus = document.createElement("div");
var tryAnimalname = document.createElement("div");
var tryAnimaltext = document.createElement("div");
tryAnimal.setAttribute("id", "tryanimal");
var selAnimal = document.createElement("select");
var selAnimals = new Array();
bag = Bag.getInstance().items;
for ( var p in bag) {
	if (bag[p].get_type() == "animal") {
		selAnimals.push(bag[p])
	}
}
selAnimals.push(wearing_items.animal);
var html_selAnimals = new Array();
for ( var i = 0; i < selAnimals.length; i++) {
	html_selAnimals.push(document.createElement("option"));
	html_selAnimals[i].setAttribute("id", "anim" + i);
	html_selAnimals[i].setAttribute("value", selAnimals[i].get_name());
	var best = "";
	if (selAnimals[i].get_short() == "donkey"
			|| selAnimals[i].get_short() == "mustang") {
		best = "";
		html_selAnimals[i].setAttribute("style",
				"color: #162F08 ; font-weight: bold")
	} else {
		best = "";
		html_selAnimals[i].setAttribute("style", "color: #523F30")
	}
	html_selAnimals[i].innerHTML = best + selAnimals[i].get_name();
	selAnimal.appendChild(html_selAnimals[i])
}
var tryAnimalImage = document.createElement("img");
for ( var i = 0; i < selAnimals.length; i++) {
	tryAnimalImage = selAnimals[i].img;
	tryAnimal.appendChild(tryAnimalImage);
	tryAnimal.removeChild(tryAnimalImage)
}
tryAnimalImage = disAnimal.img;
tryAnimal.appendChild(tryAnimalImage);
tryAnimal.appendChild(document.createElement("br"));
selAnimal
		.setAttribute(
				"onchange",
				"tryAnimalImage=selAnimals[selAnimal.selectedIndex].img;tryAnimal.innerHTML=' ';tryAnimal.appendChild(tryAnimalImage);tryAnimal.appendChild(document.createElement('br'));disAnimal=selAnimals[selAnimal.selectedIndex];epilogos();");
selAnimal
		.setAttribute(
				"onclick",
				"tryAnimalImage=selAnimals[selAnimal.selectedIndex].img;tryAnimal.innerHTML=' ';tryAnimal.appendChild(tryAnimalImage);tryAnimal.appendChild(document.createElement('br'));disAnimal=selAnimals[selAnimal.selectedIndex];epilogos();");
selAnimal.setAttribute("style", "background-color: #B8AD95;font-weight: bold");
for ( var i = 0; i < selAnimals.length; i++) {
	if (selAnimals[i].get_name() == disAnimal.get_name()) {
		selAnimal.selectedIndex = i;
		break
	}
}
var newdiv = document.createElement("div");
var divIdName = "apotelesma";
newdiv.setAttribute("id", divIdName);
newdiv.setAttribute("style", "background:#907E61");
var tab1 = document.createElement("table");
tab1.setAttribute("border", "1");
tab1.setAttribute("align", "center");
var row1 = document.createElement("tr");
var row2 = document.createElement("tr");
var row3 = document.createElement("tr");
var cell1 = document.createElement("td");
var cell2 = document.createElement("td");
var cell3 = document.createElement("td");
var cell4 = document.createElement("td");
var cell5 = document.createElement("td");
var cell6 = document.createElement("td");
var cell7 = document.createElement("td");
var cell8 = document.createElement("td");
var cell9 = document.createElement("td");
var cell14 = document.createElement("td");
var cell24 = document.createElement("td");
var cell34 = document.createElement("td");
cell1.appendChild(tryNeckStatus);
cell1.appendChild(tryNeck);
cell1.appendChild(document.createElement("br"));
cell1.appendChild(document.createTextNode("try from Inventory:"));
cell1.appendChild(document.createElement("br"));
cell1.appendChild(myselNeck);
cell1.appendChild(document.createElement("br"));
cell1.appendChild(document.createTextNode("try from Shops:"));
cell1.appendChild(document.createElement("br"));
cell1.appendChild(selNeck);
cell2.appendChild(tryHeadStatus);
cell2.appendChild(tryHead);
cell2.appendChild(document.createElement("br"));
cell2.appendChild(document.createTextNode("try from Inventory:"));
cell2.appendChild(document.createElement("br"));
cell2.appendChild(myselHead);
cell2.appendChild(document.createElement("br"));
cell2.appendChild(document.createTextNode("try from Shops:"));
cell2.appendChild(document.createElement("br"));
cell2.appendChild(selHead);
cell3.appendChild(tryRarmStatus);
cell3.appendChild(tryRarm);
cell3.appendChild(document.createElement("br"));
cell3.appendChild(document.createTextNode("try from Inventory:"));
cell3.appendChild(document.createElement("br"));
cell3.appendChild(myselRarm);
cell3.appendChild(document.createElement("br"));
cell3.appendChild(document.createTextNode("try from Shops:"));
cell3.appendChild(document.createElement("br"));
cell3.appendChild(selRarm);
cell4.appendChild(tryBodyStatus);
cell4.appendChild(tryBody);
cell4.appendChild(document.createElement("br"));
cell4.appendChild(document.createTextNode("try from Inventory:"));
cell4.appendChild(document.createElement("br"));
cell4.appendChild(myselBody);
cell4.appendChild(document.createElement("br"));
cell4.appendChild(document.createTextNode("try from Shops:"));
cell4.appendChild(document.createElement("br"));
cell4.appendChild(selBody);
cell6.appendChild(tryFootStatus);
cell6.appendChild(tryFoot);
cell6.appendChild(document.createElement("br"));
cell6.appendChild(document.createTextNode("try from Inventory:"));
cell6.appendChild(document.createElement("br"));
cell6.appendChild(myselFoot);
cell6.appendChild(document.createElement("br"));
cell6.appendChild(document.createTextNode("try from Shops:"));
cell6.appendChild(document.createElement("br"));
cell6.appendChild(selFoot);
cell5.appendChild(tryYield);
cell5.appendChild(document.createElement("br"));
cell5.appendChild(selYield);
cell9.appendChild(tryAnimal);
cell9.appendChild(document.createElement("br"));
cell9.appendChild(selAnimal);
var pFortState = document.createElement("p");
pFortState.innerHTML = "";
var vvv = 0;
var debugTextOut = 0;
cell7.appendChild(setInfoP);
var SetLinks = document.createElement("p");
SetLinks.innerHTML = '<font style="color: #1A641B ; font-weight: bolder">SETS:</font><br />';
var bestInvSet = document.createElement("a");
bestInvSet
		.setAttribute("href",
				"javascript: var something=handleTheSet2(InventoryBestSet);epilogos();void(0);");
bestInvSet.innerHTML = "&hearts;My Best Set";
SetLinks.appendChild(bestInvSet);
var bestOfSet = document.createElement("a");
bestOfSet
		.setAttribute("href",
				"javascript: var something=handleTheSet2(theBestOfSet);epilogos();void(0);");
bestOfSet.innerHTML = "The Best Shop Set";
SetLinks.innerHTML += "<br />";
SetLinks.appendChild(bestOfSet);
var bestvSet = document.createElement("a");
bestvSet
		.setAttribute("href",
				"javascript: var something=handleTheSet2(theBestValidSet);epilogos();void(0);");
bestvSet.innerHTML = "The Best Valid Shop Set";
SetLinks.innerHTML += "<br />";
SetLinks.appendChild(bestvSet);
cell8 = document.createElement("div");
cell8.innerHTML = "<hr />";
var iiisp = document.createElement("span");
iiisp.id = "ispan";
iiisp.innerHTML = "Initializing...";
cell8.appendChild(iiisp);
var jobLink = document.createElement("a");
tryConnection = window.setInterval(
		'remotePanel.postMessage("Hi", "http://www.westcalc.info")', 1000);
jobLink
		.setAttribute(
				"href",
				'javascript: remotePanel.postMessage("Hi", "http://www.westcalc.info");void(0);');
jobLink.innerHTML = "Force initialization";
cell8.appendChild(jobLink);
var fixPanel = document.createElement("a");
fixPanel.setAttribute("href",
		'javascript: newdiv.style.paddingTop=WMap.ySize+255+"px";void(0);');
fixPanel.innerHTML = "fix possition";
var dfort = document.createElement("a");
dfort
		.setAttribute("href",
				'javascript: fortFl.id="dfort";pFortState.innerHTML="";wcsScript();void(0);');
dfort.innerHTML = "fort defence";
var afort = document.createElement("a");
afort
		.setAttribute("href",
				'javascript: fortFl.id="afort";pFortState.innerHTML="";wcsScript();void(0);');
afort.innerHTML = "fort attack";
var cfort = document.createElement("a");
cfort
		.setAttribute(
				"href",
				'javascript: fortFl.id="fpnone";pFortState.innerHTML="next time action:<br />job<br /> calculations";void(0);');
cfort.innerHTML = "clear fort state";
cell8.innerHTML += "<hr />";
row1.appendChild(cell1);
row1.appendChild(cell2);
row1.appendChild(cell7);
row2.appendChild(cell3);
row2.appendChild(cell4);
row3.appendChild(cell5);
row3.appendChild(cell6);
row3.appendChild(cell9);
tab1.appendChild(row1);
tab1.appendChild(row2);
tab1.appendChild(row3);
newdiv.appendChild(cell8);
var line = document.createElement("hr");
var end_space1 = document.createElement("div");
end_space1
		.setAttribute("style",
				"overflow:visible;min-height:250px;color:#000000;width:100%;textAlign:left;");
end_space1.innerHTML += '<font style="color: #1A641B ; font-weight: bolder">SAVED SETS:</font> <br />';
var curSavedSetName = "default";
var savedSetSpace = document.createElement("div");
savedSetSpace.setAttribute("style", "textAlign:left;padding-left:50px;");
end_space1.appendChild(savedSetSpace);
var fortFl = document.createElement("p");
fortFl.setAttribute("id", "fpnone");
newdiv.appendChild(fortFl);
newdiv.appendChild(fixPanel);
if (document.getElementById(divIdName) != null) {
	var olddiv = document.getElementById(divIdName);
	document.body.removeChild(olddiv)
}
newdiv.style.paddingTop = WMap.ySize + 255 + "px";
newdiv.style.width = "auto";
newdiv.style.textAlign = "center";
document.body.appendChild(newdiv);
tryHeadImage.style.width = "50px";
tryHeadImage.style.height = "50px";
document.body
		.setAttribute(
				"onresize",
				'newdiv.style.paddingTop=WMap.ySize+255+"px";window.scrollTo(0,WMap.ySize);setInventoryToPlace();');
window.scrollTo(0, WMap.ySize);
AjaxWindow.show("inventory");
setInventoryToPlace();
void (0);
function checkMexican() {
	var mySetCount = 0;
	if (disHead.get_short() == "mexican_sombrero") {
		mySetCount++
	}
	if (disNeck.get_short() == "mexican_neck") {
		mySetCount++
	}
	if (disBody.get_short() == "poncho_brown") {
		mySetCount++
	}
	if (disFoot.get_short() == "mexican_shoes") {
		mySetCount++
	}
	if (disAnimal.get_short() == "donkey") {
		mySetCount++
	}
	if (disYield.get_short() == "tequila") {
		mySetCount++
	}
	return mySetCount
}
function mexicanGain(setItemsCount, cuJob) {
	if (setItemsCount < 2) {
		return 0
	}
	var extralp = 0;
	var cu_skills = {
		build : 0,
		punch : 0,
		tough : 0,
		endurance : 0,
		health : 0,
		ride : 0,
		reflex : 0,
		dodge : 0,
		hide : 0,
		swim : 0,
		aim : 0,
		shot : 0,
		pitfall : 0,
		finger_dexterity : 0,
		repair : 0,
		leadership : 0,
		tactic : 0,
		trade : 0,
		animal : 0,
		appearance : 0
	};
	if (setItemsCount == 2) {
		cu_skills = {
			build : 1,
			punch : 1,
			tough : 1,
			endurance : 1,
			health : 1,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		}
	}
	if (setItemsCount == 3) {
		cu_skills = {
			build : 2,
			punch : 2,
			tough : 2,
			endurance : 2,
			health : 2,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 86) {
			extralp = 60
		}
	}
	if (setItemsCount == 4) {
		cu_skills = {
			build : 4,
			punch : 4,
			tough : 4,
			endurance : 4,
			health : 4,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 86) {
			extralp = 60
		}
		if (cuJob == 67) {
			extralp = 70
		}
	}
	if (setItemsCount == 5) {
		cu_skills = {
			build : 6,
			punch : 6,
			tough : 6,
			endurance : 6,
			health : 6,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 86) {
			extralp = 60
		}
		if (cuJob == 67) {
			extralp = 70
		}
		if (cuJob == 83) {
			extralp = 80
		}
	}
	if (setItemsCount == 6) {
		cu_skills = {
			build : 9,
			punch : 9,
			tough : 9,
			endurance : 9,
			health : 9,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 86) {
			extralp = 60
		}
		if (cuJob == 67) {
			extralp = 70
		}
		if (cuJob == 83) {
			extralp = 80
		}
		if (cuJob == 50) {
			extralp = 90
		}
	}
	return JobList[cuJob].calcJobPoints(cu_skills) + extralp
}
function checkCharlatan() {
	var mySetCount = 0;
	if (disHead.get_short() == "bowler_black") {
		mySetCount++
	}
	if (disNeck.get_short() == "fly_fine") {
		mySetCount++
	}
	if (disBody.get_short() == "vest_brown") {
		mySetCount++
	}
	if (disFoot.get_short() == "quackery_shoes") {
		mySetCount++
	}
	if (disRarm.get_short() == "elixier") {
		mySetCount++
	}
	if (disYield.get_short() == "potion") {
		mySetCount++
	}
	return mySetCount
}
function charlatanGain(setItemsCount, cuJob) {
	if (setItemsCount < 2) {
		return 0
	}
	var extralp = 0;
	var cu_skills = {
		build : 0,
		punch : 0,
		tough : 0,
		endurance : 0,
		health : 0,
		ride : 0,
		reflex : 0,
		dodge : 0,
		hide : 0,
		swim : 0,
		aim : 0,
		shot : 0,
		pitfall : 0,
		finger_dexterity : 0,
		repair : 0,
		leadership : 0,
		tactic : 0,
		trade : 0,
		animal : 0,
		appearance : 0
	};
	if (setItemsCount == 2) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 5,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 1,
			shot : 1,
			pitfall : 1,
			finger_dexterity : 1,
			repair : 1,
			leadership : 0,
			tactic : 0,
			trade : 5,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 79) {
			extralp = 30
		}
	}
	if (setItemsCount == 3) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 10,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 2,
			shot : 2,
			pitfall : 2,
			finger_dexterity : 2,
			repair : 2,
			leadership : 0,
			tactic : 0,
			trade : 10,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 79) {
			extralp = 60
		}
	}
	if (setItemsCount == 4) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 15,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 4,
			shot : 4,
			pitfall : 4,
			finger_dexterity : 4,
			repair : 4,
			leadership : 0,
			tactic : 0,
			trade : 15,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 79) {
			extralp = 90
		}
	}
	if (setItemsCount == 5) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 20,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 6,
			shot : 6,
			pitfall : 6,
			finger_dexterity : 6,
			repair : 6,
			leadership : 0,
			tactic : 0,
			trade : 20,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 79) {
			extralp = 120
		}
	}
	if (setItemsCount == 6) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 18,
			endurance : 20,
			health : 0,
			ride : 0,
			reflex : 18,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 27,
			shot : 27,
			pitfall : 9,
			finger_dexterity : 9,
			repair : 9,
			leadership : 0,
			tactic : 0,
			trade : 20,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 79) {
			extralp = 120
		}
	}
	return JobList[cuJob].calcJobPoints(cu_skills) + extralp
}
function checkGentleman() {
	var mySetCount = 0;
	if (disHead.get_short() == "cylinder_brown") {
		mySetCount++
	}
	if (disNeck.get_short() == "cravat_black") {
		mySetCount++
	}
	if (disBody.get_short() == "jacket_fine") {
		mySetCount++
	}
	if (disFoot.get_short() == "gentleman_shoes") {
		mySetCount++
	}
	if (disYield.get_short() == "cane") {
		mySetCount++
	}
	return mySetCount
}
function gentlemanGain(setItemsCount, cuJob) {
	if (setItemsCount < 2) {
		return 0
	}
	var extralp = 0;
	var cu_skills = {
		build : 0,
		punch : 0,
		tough : 0,
		endurance : 0,
		health : 0,
		ride : 0,
		reflex : 0,
		dodge : 0,
		hide : 0,
		swim : 0,
		aim : 0,
		shot : 0,
		pitfall : 0,
		finger_dexterity : 0,
		repair : 0,
		leadership : 0,
		tactic : 0,
		trade : 0,
		animal : 0,
		appearance : 0
	};
	if (setItemsCount == 2) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 1,
			tactic : 1,
			trade : 1,
			animal : 1,
			appearance : 9
		};
		extralp = 5
	}
	if (setItemsCount == 3) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 11,
			tactic : 3,
			trade : 3,
			animal : 3,
			appearance : 11
		};
		extralp = 15
	}
	if (setItemsCount == 4) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 14,
			tactic : 6,
			trade : 14,
			animal : 6,
			appearance : 14
		};
		extralp = 30
	}
	if (setItemsCount == 5) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 18,
			tactic : 10,
			trade : 18,
			animal : 10,
			appearance : 26
		};
		extralp = 50
	}
	if (cuJob > 93) {
		extralp = 0
	}
	return JobList[cuJob].calcJobPoints(cu_skills) + extralp
}
function checkDancer() {
	var mySetCount = 0;
	if (disHead.get_short() == "dancer_hat") {
		mySetCount++
	}
	if (disNeck.get_short() == "dancer_chain") {
		mySetCount++
	}
	if (disBody.get_short() == "dancer_dress") {
		mySetCount++
	}
	if (disFoot.get_short() == "dancer_boots") {
		mySetCount++
	}
	return mySetCount
}
function dancerGain(setItemsCount, cuJob) {
	if (setItemsCount < 2) {
		return 0
	}
	var extralp = 0;
	var cu_skills = {
		build : 0,
		punch : 0,
		tough : 0,
		endurance : 0,
		health : 0,
		ride : 0,
		reflex : 0,
		dodge : 0,
		hide : 0,
		swim : 0,
		aim : 0,
		shot : 0,
		pitfall : 0,
		finger_dexterity : 0,
		repair : 0,
		leadership : 0,
		tactic : 0,
		trade : 0,
		animal : 0,
		appearance : 0
	};
	if (setItemsCount == 2) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 2,
			tactic : 2,
			trade : 2,
			animal : 2,
			appearance : 12
		};
		extralp = 10
	}
	if (setItemsCount == 3) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 5,
			tactic : 5,
			trade : 5,
			animal : 15,
			appearance : 15
		};
		extralp = 25
	}
	if (setItemsCount == 4) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 10,
			repair : 0,
			leadership : 9,
			tactic : 9,
			trade : 9,
			animal : 19,
			appearance : 19
		};
		extralp = 45
	}
	if (cuJob > 93) {
		extralp = 0
	}
	return JobList[cuJob].calcJobPoints(cu_skills) + extralp
}
function checkFarmer() {
	var mySetCount = 0;
	if (disHead.get_short() == "slouch_hat_brown") {
		mySetCount++
	}
	if (disBody.get_short() == "clothes_black") {
		mySetCount++
	}
	if (disFoot.get_short() == "working_black") {
		mySetCount++
	}
	if (disYield.get_short() == "pitchfork") {
		mySetCount++
	}
	return mySetCount
}
function farmerGain(setItemsCount, cuJob) {
	if (setItemsCount < 2) {
		return 0
	}
	var extralp = 0;
	var cu_skills = {
		build : 0,
		punch : 0,
		tough : 0,
		endurance : 0,
		health : 0,
		ride : 0,
		reflex : 0,
		dodge : 0,
		hide : 0,
		swim : 0,
		aim : 0,
		shot : 0,
		pitfall : 0,
		finger_dexterity : 0,
		repair : 0,
		leadership : 0,
		tactic : 0,
		trade : 0,
		animal : 0,
		appearance : 0
	};
	if (setItemsCount == 2) {
		cu_skills = {
			build : 1,
			punch : 1,
			tough : 1,
			endurance : 1,
			health : 1,
			ride : 1,
			reflex : 1,
			dodge : 1,
			hide : 1,
			swim : 1,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 13) {
			extralp = 10
		}
		if (cuJob == 12) {
			extralp = 10
		}
		if (cuJob == 8) {
			extralp = 10
		}
	}
	if (setItemsCount == 3) {
		cu_skills = {
			build : 1,
			punch : 1,
			tough : 1,
			endurance : 1,
			health : 1,
			ride : 1,
			reflex : 1,
			dodge : 1,
			hide : 1,
			swim : 1,
			aim : 1,
			shot : 1,
			pitfall : 1,
			finger_dexterity : 1,
			repair : 1,
			leadership : 1,
			tactic : 1,
			trade : 1,
			animal : 1,
			appearance : 1
		};
		if (cuJob == 13) {
			extralp = 10
		}
		if (cuJob == 12) {
			extralp = 10
		}
		if (cuJob == 8) {
			extralp = 10
		}
		if (cuJob == 88) {
			extralp = 20
		}
		if (cuJob == 30) {
			extralp = 20
		}
		if (cuJob == 22) {
			extralp = 20
		}
	}
	if (setItemsCount == 4) {
		cu_skills = {
			build : 2,
			punch : 2,
			tough : 2,
			endurance : 2,
			health : 2,
			ride : 2,
			reflex : 2,
			dodge : 2,
			hide : 2,
			swim : 2,
			aim : 2,
			shot : 2,
			pitfall : 2,
			finger_dexterity : 2,
			repair : 2,
			leadership : 2,
			tactic : 2,
			trade : 2,
			animal : 2,
			appearance : 2
		};
		if (cuJob == 13) {
			extralp = 10
		}
		if (cuJob == 12) {
			extralp = 10
		}
		if (cuJob == 8) {
			extralp = 10
		}
		if (cuJob == 88) {
			extralp = 20
		}
		if (cuJob == 30) {
			extralp = 20
		}
		if (cuJob == 22) {
			extralp = 20
		}
		if (cuJob == 48) {
			extralp = 40
		}
		if (cuJob == 84) {
			extralp = 40
		}
		if (cuJob == 44) {
			extralp = 40
		}
	}
	return JobList[cuJob].calcJobPoints(cu_skills) + extralp
}
function checkIndian() {
	var mySetCount = 0;
	if (disHead.get_short() == "indian_hat") {
		mySetCount++
	}
	if (disNeck.get_short() == "indian_chain_fine") {
		mySetCount++
	}
	if (disBody.get_short() == "indian_jacket") {
		mySetCount++
	}
	if (disFoot.get_short() == "mokassins") {
		mySetCount++
	}
	if (disAnimal.get_short() == "mustang") {
		mySetCount++
	}
	return mySetCount
}
function indianGain(setItemsCount, cuJob) {
	if (setItemsCount < 2) {
		return 0
	}
	var extralp = 0;
	var cu_skills = {
		build : 0,
		punch : 0,
		tough : 0,
		endurance : 0,
		health : 0,
		ride : 0,
		reflex : 0,
		dodge : 0,
		hide : 0,
		swim : 0,
		aim : 0,
		shot : 0,
		pitfall : 0,
		finger_dexterity : 0,
		repair : 0,
		leadership : 0,
		tactic : 0,
		trade : 0,
		animal : 0,
		appearance : 0
	};
	if (setItemsCount == 2) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 2,
			reflex : 2,
			dodge : 2,
			hide : 10,
			swim : 2,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 51) {
			extralp = 30
		}
	}
	if (setItemsCount == 3) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 5,
			reflex : 5,
			dodge : 5,
			hide : 13,
			swim : 13,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 51) {
			extralp = 30
		}
		if (cuJob == 52) {
			extralp = 40
		}
	}
	if (setItemsCount == 4) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 8,
			reflex : 8,
			dodge : 8,
			hide : 16,
			swim : 16,
			aim : 0,
			shot : 0,
			pitfall : 8,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 51) {
			extralp = 30
		}
		if (cuJob == 52) {
			extralp = 40
		}
		if (cuJob == 58) {
			extralp = 50
		}
	}
	if (setItemsCount == 5) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 12,
			reflex : 12,
			dodge : 12,
			hide : 20,
			swim : 20,
			aim : 0,
			shot : 0,
			pitfall : 8,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 8,
			appearance : 0
		};
		if (cuJob == 51) {
			extralp = 30
		}
		if (cuJob == 52) {
			extralp = 40
		}
		if (cuJob == 58) {
			extralp = 50
		}
		if (cuJob == 66) {
			extralp = 60
		}
	}
	return JobList[cuJob].calcJobPoints(cu_skills) + extralp
}
function checkPilgrimF() {
	var mySetCount = 0;
	if (disHead.get_short() == "pilger_cap") {
		mySetCount++
	}
	if (disNeck.get_short() == "cross_bronze") {
		mySetCount++
	}
	if (disBody.get_short() == "pilger_dress") {
		mySetCount++
	}
	if (disFoot.get_short() == "pilger_boots") {
		mySetCount++
	}
	if (disYield.get_short() == "ring") {
		mySetCount++
	}
	return mySetCount
}
function pilgrimFGain(setItemsCount, cuJob) {
	if (setItemsCount < 2) {
		return 0
	}
	var extralp = 0;
	var cu_skills = {
		build : 0,
		punch : 0,
		tough : 0,
		endurance : 0,
		health : 0,
		ride : 0,
		reflex : 0,
		dodge : 0,
		hide : 0,
		swim : 0,
		aim : 0,
		shot : 0,
		pitfall : 0,
		finger_dexterity : 0,
		repair : 0,
		leadership : 0,
		tactic : 0,
		trade : 0,
		animal : 0,
		appearance : 0
	};
	if (setItemsCount == 2) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 81) {
			extralp = 5
		}
	}
	if (setItemsCount == 3) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 81) {
			extralp = 15
		}
	}
	if (setItemsCount == 4) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 81) {
			extralp = 30
		}
	}
	if (setItemsCount == 5) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 62) {
			extralp = 150
		}
		if (cuJob == 81) {
			extralp = 50
		}
	}
	return JobList[cuJob].calcJobPoints(cu_skills) + extralp
}
function checkPilgrim() {
	var mySetCount = 0;
	if (disHead.get_short() == "pilger_hat") {
		mySetCount++
	}
	if (disNeck.get_short() == "cross_silver") {
		mySetCount++
	}
	if (disBody.get_short() == "pilger_jacket") {
		mySetCount++
	}
	if (disFoot.get_short() == "pilger_shoes") {
		mySetCount++
	}
	if (disYield.get_short() == "hymnal") {
		mySetCount++
	}
	return mySetCount
}
function pilgrimGain(setItemsCount, cuJob) {
	if (setItemsCount < 2) {
		return 0
	}
	var extralp = 0;
	var cu_skills = {
		build : 0,
		punch : 0,
		tough : 0,
		endurance : 0,
		health : 0,
		ride : 0,
		reflex : 0,
		dodge : 0,
		hide : 0,
		swim : 0,
		aim : 0,
		shot : 0,
		pitfall : 0,
		finger_dexterity : 0,
		repair : 0,
		leadership : 0,
		tactic : 0,
		trade : 0,
		animal : 0,
		appearance : 0
	};
	if (setItemsCount == 2) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 81) {
			extralp = 5
		}
	}
	if (setItemsCount == 3) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 81) {
			extralp = 15
		}
	}
	if (setItemsCount == 4) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 81) {
			extralp = 30
		}
	}
	if (setItemsCount == 5) {
		cu_skills = {
			build : 0,
			punch : 0,
			tough : 0,
			endurance : 0,
			health : 0,
			ride : 0,
			reflex : 0,
			dodge : 0,
			hide : 0,
			swim : 0,
			aim : 0,
			shot : 0,
			pitfall : 0,
			finger_dexterity : 0,
			repair : 0,
			leadership : 0,
			tactic : 0,
			trade : 0,
			animal : 0,
			appearance : 0
		};
		if (cuJob == 62) {
			extralp = 150
		}
		if (cuJob == 81) {
			extralp = 50
		}
	}
	return JobList[cuJob].calcJobPoints(cu_skills) + extralp
}
function calculateBestSet() {
	var mySetHeads = new Array();
	var mexic = 1;
	var charl = 1;
	var gentl = 1;
	var dance = 1;
	var india = 1;
	var pilgr = 1;
	var pilgf = 1;
	var farme = 1;
	theHeadName = the_Head.get_short();
	for ( var i = 0; i < myselHeads.length; i++) {
		if (!isValid(myselHeads[i])) {
			continue
		}
		var bufferHeadName = myselHeads[i].get_short();
		if (bufferHeadName == "mexican_sombrero" && mexic
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			mexic = 0
		}
		if (bufferHeadName == "bowler_black" && charl
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			charl = 0
		}
		if (bufferHeadName == "cylinder_brown" && gentl
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			gentl = 0
		}
		if (bufferHeadName == "dancer_hat" && dance
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			dance = 0
		}
		if (bufferHeadName == "indian_hat" && india
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			india = 0
		}
		if (bufferHeadName == "pilger_hat" && pilgr
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			pilgr = 0
		}
		if (bufferHeadName == "pilger_cap" && pilgf
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			pilgf = 0
		}
		if (bufferHeadName == "slouch_hat_brown" && farme
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			farme = 0
		}
	}
	mySetHeads.push(the_Head);
	var mySetBodys = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theBodyName = the_Body.get_short();
	for ( var i = 0; i < myselBodys.length; i++) {
		if (!isValid(myselBodys[i])) {
			continue
		}
		var bufferBodyName = myselBodys[i].get_short();
		if (bufferBodyName == "poncho_brown" && mexic
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			mexic = 0
		}
		if (bufferBodyName == "vest_brown" && charl
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			charl = 0
		}
		if (bufferBodyName == "jacket_fine" && gentl
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			gentl = 0
		}
		if (bufferBodyName == "dancer_dress" && dance
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			dance = 0
		}
		if (bufferBodyName == "indian_jacket" && india
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			india = 0
		}
		if (bufferBodyName == "pilger_jacket" && pilgr
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			pilgr = 0
		}
		if (bufferBodyName == "pilger_dress" && pilgf
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			pilgf = 0
		}
		if (bufferBodyName == "clothes_black" && farme
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			farme = 0
		}
	}
	mySetBodys.push(the_Body);
	var mySetFoots = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theFootName = the_Foot.get_short();
	for ( var i = 0; i < myselFoots.length; i++) {
		if (!isValid(myselFoots[i])) {
			continue
		}
		var bufferFootName = myselFoots[i].get_short();
		if (bufferFootName == "mexican_shoes" && mexic
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			mexic = 0
		}
		if (bufferFootName == "quackery_shoes" && charl
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			charl = 0
		}
		if (bufferFootName == "gentleman_shoes" && gentl
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			gentl = 0
		}
		if (bufferFootName == "dancer_boots" && dance
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			dance = 0
		}
		if (bufferFootName == "mokassins" && india
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			india = 0
		}
		if (bufferFootName == "pilger_shoes" && pilgr
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			pilgr = 0
		}
		if (bufferFootName == "pilger_boots" && pilgf
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			pilgf = 0
		}
		if (bufferFootName == "working_black" && farme
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			farme = 0
		}
	}
	mySetFoots.push(the_Foot);
	var mySetNecks = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theNeckName = the_Neck.get_short();
	for ( var i = 0; i < myselNecks.length; i++) {
		if (!isValid(myselNecks[i])) {
			continue
		}
		var bufferNeckName = myselNecks[i].get_short();
		if (bufferNeckName == "mexican_neck" && mexic
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			mexic = 0
		}
		if (bufferNeckName == "fly_fine" && charl
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			charl = 0
		}
		if (bufferNeckName == "cravat_black" && gentl
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			gentl = 0
		}
		if (bufferNeckName == "dancer_chain" && dance
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			dance = 0
		}
		if (bufferNeckName == "indian_chain_fine" && india
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			india = 0
		}
		if (bufferNeckName == "cross_silver" && pilgr
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			pilgr = 0
		}
		if (bufferNeckName == "cross_bronze" && pilgf
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			pilgf = 0
		}
	}
	mySetNecks.push(the_Neck);
	var mySetYields = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theYieldName = the_Yield.get_short();
	for ( var i = 0; i < selYields.length; i++) {
		if (!isValid(selYields[i])) {
			continue
		}
		var bufferYieldName = selYields[i].get_short();
		if (bufferYieldName == "tequila" && mexic
				&& bufferYieldName != theYieldName) {
			mySetYields.push(selYields[i]);
			mexic = 0
		}
		if (bufferYieldName == "potion" && charl
				&& bufferYieldName != theYieldName) {
			mySetYields.push(selYields[i]);
			charl = 0
		}
		if (bufferYieldName == "cane" && gentl
				&& bufferYieldName != theYieldName) {
			mySetYields.push(selYields[i]);
			gentl = 0
		}
		if (bufferYieldName == "pitchfork" && farme
				&& bufferYieldName != theYieldName) {
			mySetYields.push(selYields[i]);
			farme = 0
		}
	}
	mySetYields.push(the_Yield);
	var mySetAnimals = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theAnimalName = the_Animal.get_short();
	for ( var i = 0; i < selAnimals.length; i++) {
		var bufferAnimalName = selAnimals[i].get_short();
		if (bufferAnimalName == "donkey" && mexic
				&& bufferAnimalName != theAnimalName) {
			mySetAnimals.push(selAnimals[i]);
			mexic = 0
		}
		if (bufferAnimalName == "mustang" && india
				&& bufferAnimalName != theAnimalName) {
			mySetAnimals.push(selAnimals[i]);
			india = 0
		}
	}
	mySetAnimals.push(the_Animal);
	var mySetRarms = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theRarmName = the_Rarm.get_short();
	for ( var i = 0; i < myselRarms.length; i++) {
		if (!isValid(myselRarms[i])) {
			continue
		}
		var bufferRarmName = myselRarms[i].get_short();
		if (bufferRarmName == "elixier" && charl
				&& bufferRarmName != theRarmName) {
			mySetRarms.push(myselRarms[i]);
			charl = 0
		}
	}
	mySetRarms.push(the_Rarm);
	var initialGain = -1;
	var initialValidGain = -1;
	var initialInvGain = -1;
	var theBestSet = new Array();
	mySetHeads = joinItemArrays(mySetHeads, BShopHeads);
	mySetBodys = joinItemArrays(mySetBodys, BShopBodys);
	mySetFoots = joinItemArrays(mySetFoots, BShopFoots);
	mySetRarms = joinItemArrays(mySetRarms, BShopRarms);
	mySetNecks = joinItemArrays(mySetNecks, BShopNecks);
	if (deepFort == 1) {
		if (jobIndex == 94) {
			fortHeads = getGet94(getOnlyTheGains94(myselHeads));
			fortBodys = getGet94(getOnlyTheGains94(myselBodys));
			fortFoots = getGet94(getOnlyTheGains94(myselFoots));
			fortNecks = getGet94(getOnlyTheGains94(myselNecks));
			fortRarms = getGet94(getOnlyTheGains94(myselRarms));
			mySetHeads = joinItemArrays(mySetHeads, fortHeads);
			mySetBodys = joinItemArrays(mySetBodys, fortBodys);
			mySetFoots = joinItemArrays(mySetFoots, fortFoots);
			mySetRarms = joinItemArrays(mySetRarms, fortRarms);
			mySetNecks = joinItemArrays(mySetNecks, fortNecks)
		}
		if (jobIndex == 95) {
			fortHeads = getGet95(getOnlyTheGains95(myselHeads));
			fortBodys = getGet95(getOnlyTheGains95(myselBodys));
			fortFoots = getGet95(getOnlyTheGains95(myselFoots));
			fortNecks = getGet95(getOnlyTheGains95(myselNecks));
			fortRarms = getGet95(getOnlyTheGains95(myselRarms));
			mySetHeads = joinItemArrays(mySetHeads, fortHeads);
			mySetBodys = joinItemArrays(mySetBodys, fortBodys);
			mySetFoots = joinItemArrays(mySetFoots, fortFoots);
			mySetRarms = joinItemArrays(mySetRarms, fortRarms);
			mySetNecks = joinItemArrays(mySetNecks, fortNecks)
		}
	}
	var calculations = mySetHeads.length * mySetBodys.length
			* mySetFoots.length * mySetNecks.length * mySetRarms.length
			* mySetYields.length * mySetAnimals.length;
	pFortState.innerHTML = "";
	var setsDroped = 0;
	var startTime = (new Date()).getTime();
	for ( var i = 0; i < mySetHeads.length; i++) {
		for ( var j = 0; j < mySetBodys.length; j++) {
			for ( var k = 0; k < mySetFoots.length; k++) {
				for ( var l = 0; l < mySetNecks.length; l++) {
					for ( var m = 0; m < mySetRarms.length; m++) {
						for ( var n = 0; n < mySetYields.length; n++) {
							for ( var o = 0; o < mySetAnimals.length; o++) {
								var theTestSet = new Array();
								theTestSet.push(mySetHeads[i]);
								theTestSet.push(mySetBodys[j]);
								theTestSet.push(mySetFoots[k]);
								theTestSet.push(mySetNecks[l]);
								theTestSet.push(mySetRarms[m]);
								theTestSet.push(mySetYields[n]);
								theTestSet.push(mySetAnimals[o]);
								if (xorMexican(theTestSet)
										|| xorCharlatan(theTestSet)
										|| xorGentleman(theTestSet)
										|| xorDancer(theTestSet)
										|| xorFarmer(theTestSet)
										|| xorPilgrimF(theTestSet)
										|| xorPilgrim(theTestSet)
										|| xorIndian(theTestSet)) {
									setsDroped++;
									continue
								}
								var theTestSetGain = epilogosMini(theTestSet);
								if (isMySet(theTestSet)
										&& theTestSetGain > initialInvGain) {
									initialInvGain = theTestSetGain;
									InventoryBestSet = theTestSet
								}
								if (theTestSetGain > initialGain) {
									initialGain = theTestSetGain;
									theBestSet = theTestSet
								}
								if (isValidSet(theTestSet)
										&& theTestSetGain > initialValidGain) {
									initialValidGain = theTestSetGain;
									theBestValidSet = theTestSet
								}
							}
						}
					}
				}
			}
		}
	}
	var endTime = (new Date()).getTime();
	pFortState.innerHTML += calculations + " calculations,<br />droped "
			+ setsDroped + ", in ";
	pFortState.innerHTML += (endTime - startTime) + "ms";
	if (initialValidGain == initialGain) {
		theBestSet = theBestValidSet
	}
	theBestOfSet = theBestSet;
	return InventoryBestSet
}
function handleTheSet(outOfBest) {
	var temp = "";
	for ( var i = 0; i < outOfBest.length; i++) {
		temp += outOfBest[i].get_name() + ", "
	}
	temp += "gain:" + epilogosMini(outOfBest);
	eval(setTheRightIndex("Head", 0));
	eval(setTheRightIndex("Body", 1));
	eval(setTheRightIndex("Foot", 2));
	eval(setTheRightIndex("Neck", 3));
	eval(setTheRightIndex("Rarm", 4));
	for ( var i = 0; i < selYields.length; i++) {
		if (selYields[i].get_name() == outOfBest[5].get_name()) {
			selYield.selectedIndex = i;
			html_selYields[i].innerHTML = "&hearts;"
					+ html_selYields[i].innerHTML;
			html_selYields[i].setAttribute("style",
					"color: #1A641B ; font-weight: bold");
			break
		}
	}
	tryYieldImage = outOfBest[5].img;
	tryYield.innerHTML = "";
	tryYield.appendChild(tryYieldImage);
	tryYield.appendChild(document.createElement("br"));
	for ( var i = 0; i < selAnimals.length; i++) {
		if (selAnimals[i].get_name() == outOfBest[6].get_name()) {
			selAnimal.selectedIndex = i;
			html_selAnimals[i].innerHTML = "&hearts;"
					+ html_selAnimals[i].innerHTML;
			html_selAnimals[i].setAttribute("style",
					"color: #1A641B ; font-weight: bold");
			break
		}
	}
	tryAnimalImage = outOfBest[6].img;
	tryAnimal.innerHTML = "";
	tryAnimal.appendChild(tryAnimalImage);
	tryAnimal.appendChild(document.createElement("br"));
	smallImages();
	return temp
}
function handleTheSet2(outOfBest) {
	var temp = "";
	for ( var i = 0; i < outOfBest.length; i++) {
		temp += outOfBest[i].get_name() + ", "
	}
	temp += "gain:" + epilogosMini(outOfBest);
	eval(setTheRightIndex2("Head", 0));
	eval(setTheRightIndex2("Body", 1));
	eval(setTheRightIndex2("Foot", 2));
	eval(setTheRightIndex2("Neck", 3));
	eval(setTheRightIndex2("Rarm", 4));
	for ( var i = 0; i < selYields.length; i++) {
		if (selYields[i].get_name() == outOfBest[5].get_name()) {
			selYield.selectedIndex = i;
			break
		}
	}
	tryYieldImage = outOfBest[5].img;
	tryYield.innerHTML = "";
	tryYield.appendChild(tryYieldImage);
	tryYield.appendChild(document.createElement("br"));
	for ( var i = 0; i < selAnimals.length; i++) {
		if (selAnimals[i].get_name() == outOfBest[6].get_name()) {
			selAnimal.selectedIndex = i;
			break
		}
	}
	tryAnimalImage = outOfBest[6].img;
	tryAnimal.innerHTML = "";
	tryAnimal.appendChild(tryAnimalImage);
	tryAnimal.appendChild(document.createElement("br"));
	smallImages();
	return temp
}
function setTheRightIndex(part, bestIndex) {
	var temp = "var notInv=1;for(var i=0;i<mysel"
			+ part
			+ "s.length;i++){if(mysel"
			+ part
			+ "s[i].get_name()==outOfBest["
			+ bestIndex
			+ "].get_name()){mysel"
			+ part
			+ ".selectedIndex=i;myhtml_sel"
			+ part
			+ "s[i].setAttribute('style','color: #1A641B ; font-weight: bold');myhtml_sel"
			+ part
			+ "s[i].innerHTML='&hearts;'+myhtml_sel"
			+ part
			+ "s[i].innerHTML;notInv=0;break;}}try"
			+ part
			+ ".innerHTML='';if(!notInv){try"
			+ part
			+ 'Status.innerHTML="Inventory Item";try'
			+ part
			+ "Image=outOfBest["
			+ bestIndex
			+ "].img;try"
			+ part
			+ ".appendChild(try"
			+ part
			+ "Image);try"
			+ part
			+ ".appendChild(document.createElement('br'));sngain=itemGain(outOfBest["
			+ bestIndex
			+ "],jobIndex);try"
			+ part
			+ ".appendChild(document.createTextNode('gain:'+' '+sngain));}else{for(var i=0;i<sel"
			+ part
			+ "s.length;i++){if(sel"
			+ part
			+ "s[i].get_name()==outOfBest["
			+ bestIndex
			+ "].get_name()){sel"
			+ part
			+ ".selectedIndex=i;html_sel"
			+ part
			+ "s[i].setAttribute('style','color: #1A641B ; font-weight: bold');html_sel"
			+ part
			+ "s[i].innerHTML='&hearts;'+html_sel"
			+ part
			+ "s[i].innerHTML;notInv=1;break;}}try"
			+ part
			+ 'Status.innerHTML="Shop Item";try'
			+ part
			+ "Image=outOfBest["
			+ bestIndex
			+ "].img;try"
			+ part
			+ ".appendChild(try"
			+ part
			+ "Image);try"
			+ part
			+ ".appendChild(document.createElement('br'));sngain=itemGain(outOfBest["
			+ bestIndex + "],jobIndex);try" + part
			+ ".appendChild(document.createTextNode('gain:'+' '+sngain));}";
	return temp
}
function setTheRightIndex2(part, bestIndex) {
	var temp = "var notInv=1;for(var i=0;i<mysel"
			+ part
			+ "s.length;i++){if(mysel"
			+ part
			+ "s[i].get_name()==outOfBest["
			+ bestIndex
			+ "].get_name()){mysel"
			+ part
			+ ".selectedIndex=i;notInv=0;break;}}try"
			+ part
			+ ".innerHTML='';if(!notInv){try"
			+ part
			+ 'Status.innerHTML="Inventory Item";try'
			+ part
			+ "Image=outOfBest["
			+ bestIndex
			+ "].img;try"
			+ part
			+ ".appendChild(try"
			+ part
			+ "Image);try"
			+ part
			+ ".appendChild(document.createElement('br'));sngain=itemGain(outOfBest["
			+ bestIndex
			+ "],jobIndex);try"
			+ part
			+ ".appendChild(document.createTextNode('gain:'+' '+sngain));}else{for(var i=0;i<sel"
			+ part
			+ "s.length;i++){if(sel"
			+ part
			+ "s[i].get_name()==outOfBest["
			+ bestIndex
			+ "].get_name()){sel"
			+ part
			+ ".selectedIndex=i;notInv=1;break;}}try"
			+ part
			+ 'Status.innerHTML="Shop Item";try'
			+ part
			+ "Image=outOfBest["
			+ bestIndex
			+ "].img;try"
			+ part
			+ ".appendChild(try"
			+ part
			+ "Image);try"
			+ part
			+ ".appendChild(document.createElement('br'));sngain=itemGain(outOfBest["
			+ bestIndex + "],jobIndex);try" + part
			+ ".appendChild(document.createTextNode('gain:'+' '+sngain));}";
	return temp
}
var sem_ready_ep = 1;
function epilogosMini(testSet) {
	sem_ready_ep = 0;
	disHead = testSet[0];
	disBody = testSet[1];
	disFoot = testSet[2];
	disNeck = testSet[3];
	disRarm = testSet[4];
	disYield = testSet[5];
	disAnimal = testSet[6];
	if (jobIndex == 94 || jobIndex == 95) {
		if (jobIndex == 94) {
			jobIndex = 96;
			var lsum = epilogosMini(testSet);
			jobIndex = 97;
			var hsum = epilogosMini(testSet);
			jobIndex = 98;
			var asum = epilogosMini(testSet);
			jobIndex = 99;
			var dsum = epilogosMini(testSet);
			jobIndex = 101;
			var healthsum = epilogosMini(testSet);
			jobIndex = 94;
			lsum = valueToFortBonus(lsum);
			hsum = valueToFortBonus(hsum);
			asum = valueToFortBonus(asum);
			dsum = valueToFortBonus(dsum);
			var sum94 = (lsum + hsum + asum) * (lsum + hsum + dsum);
			sum94 = sum94 * 10 + healthsum;
			sem_ready_ep = 1;
			return sum94
		} else {
			if (jobIndex == 95) {
				jobIndex = 96;
				var lsum = epilogosMini(testSet);
				jobIndex = 100;
				var stsum = epilogosMini(testSet);
				jobIndex = 98;
				var asum = epilogosMini(testSet);
				jobIndex = 99;
				var dsum = epilogosMini(testSet);
				jobIndex = 101;
				var healthsum = epilogosMini(testSet);
				jobIndex = 95;
				lsum = valueToFortBonus(lsum);
				stsum = valueToFortBonus(stsum);
				asum = valueToFortBonus(asum);
				dsum = valueToFortBonus(dsum);
				var sum95 = (lsum + stsum + asum) * (lsum + stsum + dsum);
				sum95 = sum95 * 10 + healthsum;
				sem_ready_ep = 1;
				return sum95
			}
		}
		sem_ready_ep = 1;
		return 0
	}
	var sum1 = itemGain(disHead, jobIndex) + itemGain(disNeck, jobIndex)
			+ itemGain(disRarm, jobIndex) + itemGain(disBody, jobIndex)
			+ itemGain(disFoot, jobIndex) + itemGain(disYield, jobIndex);
	sum1 = sum1 + mexicanGain(checkMexican(), jobIndex);
	sum1 = sum1 + charlatanGain(checkCharlatan(), jobIndex);
	sum1 = sum1 + gentlemanGain(checkGentleman(), jobIndex);
	sum1 = sum1 + dancerGain(checkDancer(), jobIndex);
	sum1 = sum1 + farmerGain(checkFarmer(), jobIndex);
	sum1 = sum1 + indianGain(checkIndian(), jobIndex);
	sum1 = sum1 + pilgrimFGain(checkPilgrimF(), jobIndex);
	sum1 = sum1 + pilgrimGain(checkPilgrim(), jobIndex);
	var sum2 = JobList[jobIndex].calcJobPoints(Character.skills);
	var sum = sum1 + sum2;
	if (jobIndex == 102) {
		var speed1 = sum + 100 / testSet[6].obj.speed;
		if (Character.characterClass == "duelist") {
			speed1 = speed1 * 1.1
		}
		if (checkIndian() > 0) {
			speed1 = speed1 * ((checkIndian() - 1) * 0.15 + 1)
		}
		if (checkMexican() > 0) {
			speed1 = speed1 * ((checkMexican() - 1) * 0.12 + 1)
		}
		sum = speed1
	}
	sem_ready_ep = 1;
	return sum
}
function isValid(it) {
	if (it.obj.characterSex != null
			&& Character.characterSex != it.obj.characterSex) {
		return 0
	}
	if (it.obj.characterClass != null
			&& Character.characterClass != it.obj.characterClass) {
		return 0
	}
	if (it.obj.level != null && Character.level < it.obj.level) {
		return 0
	}
	return 1
}
function isUnique(it, itt) {
	for ( var i = 0; i < itt.length; i++) {
		if (it.get_short() == itt[i].get_short()) {
			return 0
		}
	}
	return 1
}
function isSetItem(it) {
	if (it.get_short() == "mexican_sombrero") {
		return 1
	}
	if (it.get_short() == "mexican_neck") {
		return 1
	}
	if (it.get_short() == "poncho_brown") {
		return 1
	}
	if (it.get_short() == "mexican_shoes") {
		return 1
	}
	if (it.get_short() == "donkey") {
		return 1
	}
	if (it.get_short() == "tequila") {
		return 1
	}
	if (it.get_short() == "bowler_black") {
		return 1
	}
	if (it.get_short() == "fly_fine") {
		return 1
	}
	if (it.get_short() == "vest_brown") {
		return 1
	}
	if (it.get_short() == "quackery_shoes") {
		return 1
	}
	if (it.get_short() == "elixier") {
		return 1
	}
	if (it.get_short() == "potion") {
		return 1
	}
	if (it.get_short() == "cylinder_brown") {
		return 1
	}
	if (it.get_short() == "cravat_black") {
		return 1
	}
	if (it.get_short() == "jacket_fine") {
		return 1
	}
	if (it.get_short() == "gentleman_shoes") {
		return 1
	}
	if (it.get_short() == "cane") {
		return 1
	}
	if (it.get_short() == "dancer_hat") {
		return 1
	}
	if (it.get_short() == "dancer_chain") {
		return 1
	}
	if (it.get_short() == "dancer_dress") {
		return 1
	}
	if (it.get_short() == "dancer_boots") {
		return 1
	}
	if (it.get_short() == "slouch_hat_brown") {
		return 1
	}
	if (it.get_short() == "clothes_black") {
		return 1
	}
	if (it.get_short() == "working_black") {
		return 1
	}
	if (it.get_short() == "pitchfork") {
		return 1
	}
	if (it.get_short() == "indian_hat") {
		return 1
	}
	if (it.get_short() == "indian_chain_fine") {
		return 1
	}
	if (it.get_short() == "indian_jacket") {
		return 1
	}
	if (it.get_short() == "mokassins") {
		return 1
	}
	if (it.get_short() == "mustang") {
		return 1
	}
	if (it.get_short() == "pilger_cap") {
		return 1
	}
	if (it.get_short() == "cross_bronze") {
		return 1
	}
	if (it.get_short() == "pilger_dress") {
		return 1
	}
	if (it.get_short() == "pilger_boots") {
		return 1
	}
	if (it.get_short() == "ring") {
		return 1
	}
	if (it.get_short() == "pilger_hat") {
		return 1
	}
	if (it.get_short() == "cross_silver") {
		return 1
	}
	if (it.get_short() == "pilger_jacket") {
		return 1
	}
	if (it.get_short() == "pilger_shoes") {
		return 1
	}
	if (it.get_short() == "hymnal") {
		return 1
	}
	return 0
}
function joinItemArrays(array1, array2) {
	for ( var i = 0; i < array2.length; i++) {
		if (isUnique(array2[i], array1)) {
			array1.push(array2[i])
		}
	}
	return array1
}
function isValidSet(array1) {
	for ( var i = 0; i < array1.length; i++) {
		if (!isValid(array1[i])) {
			return 0
		}
	}
	return 1
}
function isMySet(array1) {
	if (isUnique(array1[0], myselHeads) || isUnique(array1[1], myselBodys)
			|| isUnique(array1[2], myselFoots)
			|| isUnique(array1[3], myselNecks)
			|| isUnique(array1[4], myselRarms)) {
		return 0
	}
	return 1
}
function valueToFortBonus(va) {
	if (va > 210) {
		return 9
	} else {
		if (va > 154) {
			var vb = (va - 154 - 1) / (210 - 154);
			return (8 + vb)
		} else {
			if (va > 107) {
				var vb = (va - 107 - 1) / (154 - 107);
				return (7 + vb)
			} else {
				if (va > 70) {
					var vb = (va - 70 - 1) / (107 - 70);
					return (6 + vb)
				} else {
					if (va > 42) {
						var vb = (va - 42 - 1) / (70 - 42);
						return (5 + vb)
					} else {
						if (va > 22) {
							var vb = (va - 22 - 1) / (42 - 22);
							return (4 + vb)
						} else {
							if (va > 9) {
								var vb = (va - 9 - 1) / (22 - 9);
								return (3 + vb)
							} else {
								if (va > 2) {
									var vb = (va - 2 - 1) / (9 - 2);
									return (2 + vb)
								} else {
									if (va > 0) {
										var vb = (va - 0 - 1) / (2 - 0);
										return (1 + vb)
									} else {
										if (va == 0) {
											return 0
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
function wcsScript(myMyJobId) {
	addedJob = 0;
	try {
		if (fortFl.id == "afort") {
			addedJob = 95
		}
		if (fortFl.id == "dfort") {
			addedJob = 94
		}
	} catch (e) {
	}
	necks = new Array();
	heads = new Array();
	rarms = new Array();
	bodies = new Array();
	foott = new Array();
	yields = new Array();
	animals = new Array();
	BShopNecks = new Array();
	BShopHeads = new Array();
	BShopRarms = new Array();
	BShopBodys = new Array();
	BShopFoots = new Array();
	theBestOfSet = new Array();
	theBestValidSet = new Array();
	theCheapestValidSet = new Array();
	InventoryBestSet = new Array();
	jobIndex = myMyJobId;
	if (addedJob != 0) {
		jobIndex = addedJob
	}
	bag = Bag.getInstance().items;
	wearing_items = Wear.wear;
	the_Head = getHead(jobIndex);
	the_Neck = getNeck(jobIndex);
	the_Rarm = getRarm(jobIndex);
	the_Body = getBody(jobIndex);
	the_Foot = getFoot(jobIndex);
	try {
		the_Yield = getYield(jobIndex);
		the_Animal = getAnimal(jobIndex)
	} catch (e) {
	}
	disHead = the_Head;
	disNeck = the_Neck;
	disRarm = the_Rarm;
	disBody = the_Body;
	disFoot = the_Foot;
	try {
		disYield = the_Yield;
		disAnimal = the_Animal
	} catch (e) {
	}
	try {
		city_id = Character.home_town.town_id
	} catch (e) {
	}
	bag = TraderInventory.getInstance("building_general", city_id).items;
	shop_Neck = getNeck(jobIndex);
	if (itemGain(shop_Neck, jobIndex) > itemGain(the_Neck, jobIndex)) {
		ssn = stoHTML(shop_Neck)
	} else {
		ssn = document.createElement("text")
	}
	bag = TraderInventory.getInstance("building_gunsmith", city_id).items;
	shop_Rarm = getRarm(jobIndex);
	if (itemGain(shop_Rarm, jobIndex) > itemGain(the_Rarm, jobIndex)) {
		ssa = stoHTML(shop_Rarm)
	} else {
		ssa = document.createElement("text")
	}
	bag = TraderInventory.getInstance("building_tailor", city_id).items;
	shop_Body = getBody(jobIndex);
	if (itemGain(shop_Body, jobIndex) > itemGain(the_Body, jobIndex)) {
		ssb = stoHTML(shop_Body)
	} else {
		ssb = document.createElement("text")
	}
	shop_Head = getHead(jobIndex);
	if (itemGain(shop_Head, jobIndex) > itemGain(the_Head, jobIndex)) {
		ssh = stoHTML(shop_Head)
	} else {
		ssh = document.createElement("text")
	}
	shop_Foot = getFoot(jobIndex);
	if (itemGain(shop_Foot, jobIndex) > itemGain(the_Foot, jobIndex)) {
		ssf = stoHTML(shop_Foot)
	} else {
		ssf = document.createElement("text")
	}
	shopOut = "<b>TA KALYTERA ANTKEIMENA POY BRE8HKAN STA MAGAZIA:</b>";
	Epilogos = document.createElement("p");
	setInfoP = document.createElement("p");
	tryHead = document.createElement("div");
	tryHeadStatus = document.createElement("div");
	tryHeadname = document.createElement("div");
	tryHeadtext = document.createElement("div");
	tryHead.setAttribute("id", "tryhead");
	selHead = document.createElement("select");
	selHeads = new Array();
	bag = TraderInventory.getInstance("building_tailor", city_id).items;
	for ( var p in bag) {
		if (bag[p].get_type() == "head") {
			selHeads.push(bag[p])
		}
	}
	html_selHeads = new Array();
	Shgain = 0;
	Shgain = itemGain(shop_Head, jobIndex);
	myhgain = itemGain(the_Head, jobIndex);
	shgain = 0;
	for ( var i = 0; i < selHeads.length; i++) {
		html_selHeads.push(document.createElement("option"));
		html_selHeads[i].setAttribute("id", "h" + i);
		html_selHeads[i].setAttribute("value", selHeads[i].get_name());
		var best = "";
		shgain = 0;
		shgain = itemGain(selHeads[i], jobIndex);
		if (shgain > myhgain) {
			if (isUnique(selHeads[i], BShopHeads)) {
				BShopHeads.push(selHeads[i])
			}
			best = "";
			html_selHeads[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			if (shgain == myhgain && myhgain != 0) {
				best = "";
				html_selHeads[i].setAttribute("style",
						"color: #162F08 ; font-weight: bold")
			} else {
				best = "";
				html_selHeads[i].setAttribute("style", "color: #523F30")
			}
		}
		if (Shgain == shgain && Shgain - myhgain > 0) {
			best = "";
			html_selHeads[i].setAttribute("style",
					"color: #1A641B ; font-weight: bolder")
		}
		html_selHeads[i].innerHTML = best + '<img src="images/items/head/mini/'
				+ selHeads[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ selHeads[i].get_name() + " (" + shgain + "-" + myhgain + ")="
				+ (shgain - myhgain);
		selHead.appendChild(html_selHeads[i]);
		if (isSetItem(selHeads[i]) && isUnique(selHeads[i], BShopHeads)) {
			BShopHeads.push(selHeads[i])
		}
	}
	tryHeadImage = document.createElement("img");
	for ( var i = 0; i < selHeads.length; i++) {
		tryHeadImage = selHeads[i].img;
		tryHead.appendChild(tryHeadImage);
		tryHead.removeChild(tryHeadImage)
	}
	selHead
			.setAttribute(
					"onchange",
					"tryHeadImage=selHeads[selHead.selectedIndex].img;tryHead.innerHTML=' ';tryHead.appendChild(tryHeadImage);tryHeadStatus.innerHTML='Shop item';tryHead.appendChild(document.createElement('br'));shgain=itemGain(selHeads[selHead.selectedIndex],jobIndex);tryHead.appendChild(document.createTextNode('gain:'+' '+shgain));tryHead.appendChild(document.createElement('br'));tryHead.appendChild(document.createTextNode('net:'+' ('+shgain+'-'+myhgain+')='+(shgain-myhgain)));disHead=selHeads[selHead.selectedIndex];epilogos();tryHeadImage.style.width=\"50px\";tryHeadImage.style.height=\"50px\";");
	selHead
			.setAttribute(
					"onclick",
					"tryHeadImage=selHeads[selHead.selectedIndex].img;tryHead.innerHTML=' ';tryHead.appendChild(tryHeadImage);tryHeadStatus.innerHTML='Shop item';tryHead.appendChild(document.createElement('br'));shgain=itemGain(selHeads[selHead.selectedIndex],jobIndex);tryHead.appendChild(document.createTextNode('gain:'+' '+shgain));tryHead.appendChild(document.createElement('br'));tryHead.appendChild(document.createTextNode('net:'+' ('+shgain+'-'+myhgain+')='+(shgain-myhgain)));disHead=selHeads[selHead.selectedIndex];epilogos();tryHeadImage.style.width=\"50px\";tryHeadImage.style.height=\"50px\";");
	selHead
			.setAttribute("style",
					"background-color: #B8AD95;font-weight: bold");
	tryBody = document.createElement("div");
	tryBodyStatus = document.createElement("div");
	tryBodyname = document.createElement("div");
	tryBodytext = document.createElement("div");
	tryBody.setAttribute("id", "trybody");
	selBody = document.createElement("select");
	selBodys = new Array();
	bag = TraderInventory.getInstance("building_tailor", city_id).items;
	for ( var p in bag) {
		if (bag[p].get_type() == "body") {
			selBodys.push(bag[p])
		}
	}
	html_selBodys = new Array();
	Sbgain = 0;
	Sbgain = itemGain(shop_Body, jobIndex);
	mybgain = itemGain(the_Body, jobIndex);
	sbgain = 0;
	for ( var i = 0; i < selBodys.length; i++) {
		html_selBodys.push(document.createElement("option"));
		html_selBodys[i].setAttribute("id", "b" + i);
		html_selBodys[i].setAttribute("value", selBodys[i].get_name());
		var best = "";
		sbgain = 0;
		sbgain = itemGain(selBodys[i], jobIndex);
		if (sbgain > mybgain) {
			if (isUnique(selBodys[i], BShopBodys)) {
				BShopBodys.push(selBodys[i])
			}
			best = "";
			html_selBodys[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			if (sbgain == mybgain && mybgain != 0) {
				best = "";
				html_selBodys[i].setAttribute("style",
						"color: #162F08 ; font-weight: bold")
			} else {
				best = "";
				html_selBodys[i].setAttribute("style", "color: #523F30")
			}
		}
		if (Sbgain == sbgain && Sbgain - mybgain > 0) {
			best = "";
			html_selBodys[i].setAttribute("style",
					"color: #1A641B ; font-weight: bolder")
		}
		html_selBodys[i].innerHTML = best + '<img src="images/items/body/mini/'
				+ selBodys[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ selBodys[i].get_name() + " (" + sbgain + "-" + mybgain + ")="
				+ (sbgain - mybgain);
		selBody.appendChild(html_selBodys[i]);
		if (isSetItem(selBodys[i]) && isUnique(selBodys[i], BShopBodys)) {
			BShopBodys.push(selBodys[i])
		}
	}
	tryBodyImage = document.createElement("img");
	for ( var i = 0; i < selBodys.length; i++) {
		tryBodyImage = selBodys[i].img;
		tryBody.appendChild(tryBodyImage);
		tryBody.removeChild(tryBodyImage)
	}
	selBody
			.setAttribute(
					"onchange",
					"tryBodyImage=selBodys[selBody.selectedIndex].img;tryBody.innerHTML=' ';tryBody.appendChild(tryBodyImage);tryBodyStatus.innerHTML='Shop item';tryBody.appendChild(document.createElement('br'));sbgain=itemGain(selBodys[selBody.selectedIndex],jobIndex);tryBody.appendChild(document.createTextNode('gain:'+' '+sbgain));tryBody.appendChild(document.createElement('br'));tryBody.appendChild(document.createTextNode('net:'+' ('+sbgain+'-'+mybgain+')='+(sbgain-mybgain)));disBody=selBodys[selBody.selectedIndex];epilogos();tryBodyImage.style.width=\"50px\";tryBodyImage.style.height=\"50px\";");
	selBody
			.setAttribute(
					"onclick",
					"tryBodyImage=selBodys[selBody.selectedIndex].img;tryBody.innerHTML=' ';tryBody.appendChild(tryBodyImage);tryBodyStatus.innerHTML='Shop item';tryBody.appendChild(document.createElement('br'));sbgain=itemGain(selBodys[selBody.selectedIndex],jobIndex);tryBody.appendChild(document.createTextNode('gain:'+' '+sbgain));tryBody.appendChild(document.createElement('br'));tryBody.appendChild(document.createTextNode('net:'+' ('+sbgain+'-'+mybgain+')='+(sbgain-mybgain)));disBody=selBodys[selBody.selectedIndex];epilogos();tryBodyImage.style.width=\"50px\";tryBodyImage.style.height=\"50px\";");
	selBody
			.setAttribute("style",
					"background-color: #B8AD95;font-weight: bold");
	myselBody = document.createElement("select");
	myselBodys = new Array();
	bag = Bag.getInstance().items;
	myselBodys.push(wearing_items.body);
	for ( var p in bag) {
		if (bag[p].get_type() == "body") {
			myselBodys.push(bag[p])
		}
	}
	myhtml_selBodys = new Array();
	mybgain = itemGain(the_Body, jobIndex);
	for ( var i = 0; i < myselBodys.length; i++) {
		myhtml_selBodys.push(document.createElement("option"));
		myhtml_selBodys[i].setAttribute("id", "myb" + i);
		myhtml_selBodys[i].setAttribute("value", myselBodys[i].get_name());
		var best = "";
		sbgain = 0;
		sbgain = itemGain(myselBodys[i], jobIndex);
		if (sbgain == mybgain && mybgain != 0) {
			best = "";
			myhtml_selBodys[i].setAttribute("style",
					"color: #1A641B ; font-weight: bold")
		} else {
			if (sbgain == 0) {
				best = "";
				myhtml_selBodys[i].setAttribute("style", "color: #523F30")
			} else {
				best = "";
				myhtml_selBodys[i].setAttribute("style", "color: #162F08")
			}
		}
		myhtml_selBodys[i].innerHTML = best
				+ '<img src="images/items/body/mini/'
				+ myselBodys[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ myselBodys[i].get_name() + " " + sbgain;
		myselBody.appendChild(myhtml_selBodys[i])
	}
	tryBodyStatus.innerHTML = "Inventory Item";
	for ( var i = 0; i < myselBodys.length; i++) {
		tryBodyImage = myselBodys[i].img;
		tryBody.appendChild(tryBodyImage);
		tryBody.removeChild(tryBodyImage)
	}
	tryBodyImage = the_Body.img;
	tryBody.appendChild(tryBodyImage);
	tryBody.appendChild(document.createElement("br"));
	sbgain = itemGain(the_Body, jobIndex);
	tryBody.appendChild(document.createTextNode("gain: " + sbgain));
	myselBody
			.setAttribute(
					"onchange",
					"tryBodyImage=myselBodys[myselBody.selectedIndex].img;tryBody.innerHTML=' ';tryBody.appendChild(tryBodyImage);tryBodyStatus.innerHTML='Inventory item';tryBody.appendChild(document.createElement('br'));sbgain=itemGain(myselBodys[myselBody.selectedIndex],jobIndex);tryBody.appendChild(document.createTextNode('gain:'+' '+sbgain));disBody=myselBodys[myselBody.selectedIndex];epilogos();tryBodyImage.style.width=\"50px\";tryBodyImage.style.height=\"50px\";");
	myselBody
			.setAttribute(
					"onclick",
					"tryBodyImage=myselBodys[myselBody.selectedIndex].img;tryBody.innerHTML=' ';tryBody.appendChild(tryBodyImage);tryBodyStatus.innerHTML='Inventory item';tryBody.appendChild(document.createElement('br'));sbgain=itemGain(myselBodys[myselBody.selectedIndex],jobIndex);tryBody.appendChild(document.createTextNode('gain:'+' '+sbgain));disBody=myselBodys[myselBody.selectedIndex];epilogos();tryBodyImage.style.width=\"50px\";tryBodyImage.style.height=\"50px\";");
	myselBody.setAttribute("style",
			"background-color: #B8AD95;font-weight: bold");
	for ( var i = 0; i < myselBodys.length; i++) {
		if (myselBodys[i].get_name() == the_Body.get_name()) {
			myselBody.selectedIndex = i;
			break
		}
	}
	myselHead = document.createElement("select");
	myselHeads = new Array();
	bag = Bag.getInstance().items;
	myselHeads.push(wearing_items.head);
	for ( var p in bag) {
		if (bag[p].get_type() == "head") {
			myselHeads.push(bag[p])
		}
	}
	myhtml_selHeads = new Array();
	myhgain = itemGain(the_Head, jobIndex);
	for ( var i = 0; i < myselHeads.length; i++) {
		myhtml_selHeads.push(document.createElement("option"));
		myhtml_selHeads[i].setAttribute("id", "myh" + i);
		myhtml_selHeads[i].setAttribute("value", myselHeads[i].get_name());
		var best = "";
		shgain = 0;
		shgain = itemGain(myselHeads[i], jobIndex);
		if (shgain == myhgain && myhgain != 0) {
			best = "";
			myhtml_selHeads[i].setAttribute("style",
					"color: #1A641B ; font-weight: bold")
		} else {
			if (shgain == 0) {
				best = "";
				myhtml_selHeads[i].setAttribute("style", "color: #523F30")
			} else {
				best = "";
				myhtml_selHeads[i].setAttribute("style", "color: #162F08")
			}
		}
		myhtml_selHeads[i].innerHTML = best
				+ '<img src="images/items/head/mini/'
				+ myselHeads[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ myselHeads[i].get_name() + " " + shgain;
		myselHead.appendChild(myhtml_selHeads[i])
	}
	tryHeadStatus.innerHTML = "Inventory Item";
	for ( var i = 0; i < myselHeads.length; i++) {
		tryHeadImage = myselHeads[i].img;
		tryHead.appendChild(tryHeadImage);
		tryHead.removeChild(tryHeadImage)
	}
	tryHeadImage = the_Head.img;
	tryHead.appendChild(tryHeadImage);
	tryHead.appendChild(document.createElement("br"));
	shgain = itemGain(the_Head, jobIndex);
	tryHead.appendChild(document.createTextNode("gain: " + shgain));
	myselHead
			.setAttribute(
					"onchange",
					"tryHeadImage=myselHeads[myselHead.selectedIndex].img;tryHead.innerHTML=' ';tryHead.appendChild(tryHeadImage);tryHeadStatus.innerHTML='Inventory item';tryHead.appendChild(document.createElement('br'));shgain=itemGain(myselHeads[myselHead.selectedIndex],jobIndex);tryHead.appendChild(document.createTextNode('gain:'+' '+shgain));disHead=myselHeads[myselHead.selectedIndex];epilogos();tryHeadImage.style.width=\"50px\";tryHeadImage.style.height=\"50px\";");
	myselHead
			.setAttribute(
					"onclick",
					"tryHeadImage=myselHeads[myselHead.selectedIndex].img;tryHead.innerHTML=' ';tryHead.appendChild(tryHeadImage);tryHeadStatus.innerHTML='Inventory item';tryHead.appendChild(document.createElement('br'));shgain=itemGain(myselHeads[myselHead.selectedIndex],jobIndex);tryHead.appendChild(document.createTextNode('gain:'+' '+shgain));disHead=myselHeads[myselHead.selectedIndex];epilogos();tryHeadImage.style.width=\"50px\";tryHeadImage.style.height=\"50px\";");
	myselHead.setAttribute("style",
			"background-color: #B8AD95;font-weight: bold");
	for ( var i = 0; i < myselHeads.length; i++) {
		if (myselHeads[i].get_name() == the_Head.get_name()) {
			myselHead.selectedIndex = i;
			break
		}
	}
	tryFoot = document.createElement("div");
	tryFootStatus = document.createElement("div");
	tryFootname = document.createElement("div");
	tryFoottext = document.createElement("div");
	tryFoot.setAttribute("id", "tryfoot");
	selFoot = document.createElement("select");
	selFoots = new Array();
	bag = TraderInventory.getInstance("building_tailor", city_id).items;
	for ( var p in bag) {
		if (bag[p].get_type() == "foot") {
			selFoots.push(bag[p])
		}
	}
	html_selFoots = new Array();
	Sfgain = 0;
	Sfgain = itemGain(shop_Foot, jobIndex);
	myfgain = itemGain(the_Foot, jobIndex);
	sfgain = 0;
	for ( var i = 0; i < selFoots.length; i++) {
		html_selFoots.push(document.createElement("option"));
		html_selFoots[i].setAttribute("id", "f" + i);
		html_selFoots[i].setAttribute("value", selFoots[i].get_name());
		var best = "";
		sfgain = 0;
		sfgain = itemGain(selFoots[i], jobIndex);
		if (sfgain > myfgain) {
			if (isUnique(selFoots[i], BShopFoots)) {
				BShopFoots.push(selFoots[i])
			}
			best = "";
			html_selFoots[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			if (sfgain == myfgain && myfgain != 0) {
				best = "";
				html_selFoots[i].setAttribute("style",
						"color: #162F08 ; font-weight: bold")
			} else {
				best = "";
				html_selFoots[i].setAttribute("style", "color: #523F30")
			}
		}
		if (Sfgain == sfgain && Sfgain - myfgain > 0) {
			best = "";
			html_selFoots[i].setAttribute("style",
					"color: #1A641B ; font-weight: bolder")
		}
		html_selFoots[i].innerHTML = best + '<img src="images/items/foot/mini/'
				+ selFoots[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ selFoots[i].get_name() + " (" + sfgain + "-" + myfgain + ")="
				+ (sfgain - myfgain);
		selFoot.appendChild(html_selFoots[i]);
		if (isSetItem(selFoots[i]) && isUnique(selFoots[i], BShopFoots)) {
			BShopFoots.push(selFoots[i])
		}
	}
	tryFootImage = document.createElement("img");
	for ( var i = 0; i < selFoots.length; i++) {
		tryFootImage = selFoots[i].img;
		tryFoot.appendChild(tryFootImage);
		tryFoot.removeChild(tryFootImage)
	}
	selFoot
			.setAttribute(
					"onchange",
					"tryFootImage=selFoots[selFoot.selectedIndex].img;tryFoot.innerHTML=' ';tryFoot.appendChild(tryFootImage);tryFootStatus.innerHTML='Shop item';tryFoot.appendChild(document.createElement('br'));sfgain=itemGain(selFoots[selFoot.selectedIndex],jobIndex);tryFoot.appendChild(document.createTextNode('gain:'+' '+sfgain));tryFoot.appendChild(document.createElement('br'));tryFoot.appendChild(document.createTextNode('net:'+' ('+sfgain+'-'+myfgain+')='+(sfgain-myfgain)));disFoot=selFoots[selFoot.selectedIndex];epilogos();tryFootImage.style.width=\"50px\";tryFootImage.style.height=\"50px\";");
	selFoot
			.setAttribute(
					"onclick",
					"tryFootImage=selFoots[selFoot.selectedIndex].img;tryFoot.innerHTML=' ';tryFoot.appendChild(tryFootImage);tryFootStatus.innerHTML='Shop item';tryFoot.appendChild(document.createElement('br'));sfgain=itemGain(selFoots[selFoot.selectedIndex],jobIndex);tryFoot.appendChild(document.createTextNode('gain:'+' '+sfgain));tryFoot.appendChild(document.createElement('br'));tryFoot.appendChild(document.createTextNode('net:'+' ('+sfgain+'-'+myfgain+')='+(sfgain-myfgain)));disFoot=selFoots[selFoot.selectedIndex];epilogos();tryFootImage.style.width=\"50px\";tryFootImage.style.height=\"50px\";");
	selFoot
			.setAttribute("style",
					"background-color: #B8AD95;font-weight: bold");
	myselFoot = document.createElement("select");
	myselFoots = new Array();
	bag = Bag.getInstance().items;
	myselFoots.push(wearing_items.foot);
	for ( var p in bag) {
		if (bag[p].get_type() == "foot") {
			myselFoots.push(bag[p])
		}
	}
	myhtml_selFoots = new Array();
	myfgain = itemGain(the_Foot, jobIndex);
	for ( var i = 0; i < myselFoots.length; i++) {
		myhtml_selFoots.push(document.createElement("option"));
		myhtml_selFoots[i].setAttribute("id", "myf" + i);
		myhtml_selFoots[i].setAttribute("value", myselFoots[i].get_name());
		var best = "";
		sfgain = 0;
		sfgain = itemGain(myselFoots[i], jobIndex);
		if (sfgain == myfgain && myfgain != 0) {
			best = "";
			myhtml_selFoots[i].setAttribute("style",
					"color: #1A641B ; font-weight: bold")
		} else {
			if (sfgain == 0) {
				best = "";
				myhtml_selFoots[i].setAttribute("style", "color: #523F30")
			} else {
				best = "";
				myhtml_selFoots[i].setAttribute("style", "color: #162F08")
			}
		}
		myhtml_selFoots[i].innerHTML = best
				+ '<img src="images/items/foot/mini/'
				+ myselFoots[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ myselFoots[i].get_name() + " " + sfgain;
		myselFoot.appendChild(myhtml_selFoots[i])
	}
	tryFootStatus.innerHTML = "Inventory Item";
	for ( var i = 0; i < myselFoots.length; i++) {
		tryFootImage = myselFoots[i].img;
		tryFoot.appendChild(tryFootImage);
		tryFoot.removeChild(tryFootImage)
	}
	tryFootImage = the_Foot.img;
	tryFoot.appendChild(tryFootImage);
	tryFoot.appendChild(document.createElement("br"));
	sfgain = itemGain(the_Foot, jobIndex);
	tryFoot.appendChild(document.createTextNode("gain: " + sfgain));
	myselFoot
			.setAttribute(
					"onchange",
					"tryFootImage=myselFoots[myselFoot.selectedIndex].img;tryFoot.innerHTML=' ';tryFoot.appendChild(tryFootImage);tryFootStatus.innerHTML='Inventory item';tryFoot.appendChild(document.createElement('br'));sfgain=itemGain(myselFoots[myselFoot.selectedIndex],jobIndex);tryFoot.appendChild(document.createTextNode('gain:'+' '+sfgain));disFoot=myselFoots[myselFoot.selectedIndex];epilogos();tryFootImage.style.width=\"50px\";tryFootImage.style.height=\"50px\";");
	myselFoot
			.setAttribute(
					"onclick",
					"tryFootImage=myselFoots[myselFoot.selectedIndex].img;tryFoot.innerHTML=' ';tryFoot.appendChild(tryFootImage);tryFootStatus.innerHTML='Inventory item';tryFoot.appendChild(document.createElement('br'));sfgain=itemGain(myselFoots[myselFoot.selectedIndex],jobIndex);tryFoot.appendChild(document.createTextNode('gain:'+' '+sfgain));disFoot=myselFoots[myselFoot.selectedIndex];epilogos();tryFootImage.style.width=\"50px\";tryFootImage.style.height=\"50px\";");
	myselFoot.setAttribute("style",
			"background-color: #B8AD95;font-weight: bold");
	for ( var i = 0; i < myselFoots.length; i++) {
		if (myselFoots[i].get_name() == the_Foot.get_name()) {
			myselFoot.selectedIndex = i;
			break
		}
	}
	tryNeck = document.createElement("div");
	tryNeckStatus = document.createElement("div");
	tryNeckname = document.createElement("div");
	tryNecktext = document.createElement("div");
	tryNeck.setAttribute("id", "tryneck");
	selNeck = document.createElement("select");
	selNecks = new Array();
	bag = TraderInventory.getInstance("building_general", city_id).items;
	for ( var p in bag) {
		if (bag[p].get_type() == "neck") {
			selNecks.push(bag[p])
		}
	}
	html_selNecks = new Array();
	Sngain = 0;
	Sngain = itemGain(shop_Neck, jobIndex);
	myngain = itemGain(the_Neck, jobIndex);
	sngain = 0;
	for ( var i = 0; i < selNecks.length; i++) {
		html_selNecks.push(document.createElement("option"));
		html_selNecks[i].setAttribute("id", "n" + i);
		html_selNecks[i].setAttribute("value", selNecks[i].get_name());
		var best = "";
		sngain = 0;
		sngain = itemGain(selNecks[i], jobIndex);
		if (sngain > myngain) {
			if (isUnique(selNecks[i], BShopNecks)) {
				BShopNecks.push(selNecks[i])
			}
			best = "";
			html_selNecks[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			if (sngain == myngain && myngain != 0) {
				best = "";
				html_selNecks[i].setAttribute("style",
						"color: #162F08 ; font-weight: bold")
			} else {
				best = "";
				html_selNecks[i].setAttribute("style", "color: #523F30")
			}
		}
		if (Sngain == sngain && Sngain - myngain > 0) {
			best = "";
			html_selNecks[i].setAttribute("style",
					"color: #1A641B ; font-weight: bolder")
		}
		html_selNecks[i].innerHTML = best + '<img src="images/items/neck/'
				+ selNecks[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ selNecks[i].get_name() + " (" + sngain + "-" + myngain + ")="
				+ (sngain - myngain);
		selNeck.appendChild(html_selNecks[i]);
		if (isSetItem(selNecks[i]) && isUnique(selNecks[i], BShopNecks)) {
			BShopNecks.push(selNecks[i])
		}
	}
	tryNeckImage = document.createElement("img");
	for ( var i = 0; i < selNecks.length; i++) {
		tryNeckImage = selNecks[i].img;
		tryNeck.appendChild(tryNeckImage);
		tryNeck.removeChild(tryNeckImage)
	}
	selNeck
			.setAttribute(
					"onchange",
					"tryNeckImage=selNecks[selNeck.selectedIndex].img;tryNeck.innerHTML=' ';tryNeck.appendChild(tryNeckImage);tryNeckStatus.innerHTML='Shop item';tryNeck.appendChild(document.createElement('br'));sngain=itemGain(selNecks[selNeck.selectedIndex],jobIndex);tryNeck.appendChild(document.createTextNode('gain:'+' '+sngain));tryNeck.appendChild(document.createElement('br'));tryNeck.appendChild(document.createTextNode('net:'+' ('+sngain+'-'+myngain+')='+(sngain-myngain)));disNeck=selNecks[selNeck.selectedIndex];epilogos();tryNeckImage.style.width=\"50px\";tryNeckImage.style.height=\"50px\";");
	selNeck
			.setAttribute(
					"onclick",
					"tryNeckImage=selNecks[selNeck.selectedIndex].img;tryNeck.innerHTML=' ';tryNeck.appendChild(tryNeckImage);tryNeckStatus.innerHTML='Shop item';tryNeck.appendChild(document.createElement('br'));sngain=itemGain(selNecks[selNeck.selectedIndex],jobIndex);tryNeck.appendChild(document.createTextNode('gain:'+' '+sngain));tryNeck.appendChild(document.createElement('br'));tryNeck.appendChild(document.createTextNode('net:'+' ('+sngain+'-'+myngain+')='+(sngain-myngain)));disNeck=selNecks[selNeck.selectedIndex];epilogos();tryNeckImage.style.width=\"50px\";tryNeckImage.style.height=\"50px\";");
	selNeck
			.setAttribute("style",
					"background-color: #B8AD95;font-weight: bold");
	myselNeck = document.createElement("select");
	myselNecks = new Array();
	bag = Bag.getInstance().items;
	myselNecks.push(wearing_items.neck);
	for ( var p in bag) {
		if (bag[p].get_type() == "neck") {
			myselNecks.push(bag[p])
		}
	}
	myhtml_selNecks = new Array();
	myngain = itemGain(the_Neck, jobIndex);
	for ( var i = 0; i < myselNecks.length; i++) {
		myhtml_selNecks.push(document.createElement("option"));
		myhtml_selNecks[i].setAttribute("id", "myn" + i);
		myhtml_selNecks[i].setAttribute("value", myselNecks[i].get_name());
		var best = "";
		sngain = 0;
		sngain = itemGain(myselNecks[i], jobIndex);
		if (sngain == myngain && myngain != 0) {
			best = "";
			myhtml_selNecks[i].setAttribute("style",
					"color: #1A641B ; font-weight: bold")
		} else {
			if (sngain == 0) {
				best = "";
				myhtml_selNecks[i].setAttribute("style", "color: #523F30")
			} else {
				best = "";
				myhtml_selNecks[i].setAttribute("style", "color: #162F08")
			}
		}
		myhtml_selNecks[i].innerHTML = best + '<img src="images/items/neck/'
				+ myselNecks[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ myselNecks[i].get_name() + " " + sngain;
		myselNeck.appendChild(myhtml_selNecks[i])
	}
	tryNeckStatus.innerHTML = "Inventory Item";
	for ( var i = 0; i < myselNecks.length; i++) {
		tryNeckImage = myselNecks[i].img;
		tryNeck.appendChild(tryNeckImage);
		tryNeck.removeChild(tryNeckImage)
	}
	tryNeckImage = the_Neck.img;
	tryNeck.appendChild(tryNeckImage);
	tryNeck.appendChild(document.createElement("br"));
	sngain = itemGain(the_Neck, jobIndex);
	tryNeck.appendChild(document.createTextNode("gain: " + sngain));
	myselNeck
			.setAttribute(
					"onchange",
					"tryNeckImage=myselNecks[myselNeck.selectedIndex].img;tryNeck.innerHTML=' ';tryNeck.appendChild(tryNeckImage);tryNeckStatus.innerHTML='Inventory item';tryNeck.appendChild(document.createElement('br'));sngain=itemGain(myselNecks[myselNeck.selectedIndex],jobIndex);tryNeck.appendChild(document.createTextNode('gain:'+' '+sngain));disNeck=myselNecks[myselNeck.selectedIndex];epilogos();tryNeckImage.style.width=\"50px\";tryNeckImage.style.height=\"50px\";");
	myselNeck
			.setAttribute(
					"onclick",
					"tryNeckImage=myselNecks[myselNeck.selectedIndex].img;tryNeck.innerHTML=' ';tryNeck.appendChild(tryNeckImage);tryNeckStatus.innerHTML='Inventory item';tryNeck.appendChild(document.createElement('br'));sngain=itemGain(myselNecks[myselNeck.selectedIndex],jobIndex);tryNeck.appendChild(document.createTextNode('gain:'+' '+sngain));disNeck=myselNecks[myselNeck.selectedIndex];epilogos();tryNeckImage.style.width=\"50px\";tryNeckImage.style.height=\"50px\";");
	myselNeck.setAttribute("style",
			"background-color: #B8AD95;font-weight: bold");
	for ( var i = 0; i < myselNecks.length; i++) {
		if (myselNecks[i].get_name() == the_Neck.get_name()) {
			myselNeck.selectedIndex = i;
			break
		}
	}
	tryRarm = document.createElement("div");
	tryRarmStatus = document.createElement("div");
	tryRarmname = document.createElement("div");
	tryRarmtext = document.createElement("div");
	tryRarm.setAttribute("id", "tryrarm");
	selRarm = document.createElement("select");
	selRarms = new Array();
	bag = TraderInventory.getInstance("building_gunsmith", city_id).items;
	for ( var p in bag) {
		if (bag[p].get_type() == "right_arm") {
			selRarms.push(bag[p])
		}
	}
	html_selRarms = new Array();
	Srgain = 0;
	Srgain = itemGain(shop_Rarm, jobIndex);
	myrgain = itemGain(the_Rarm, jobIndex);
	srgain = 0;
	for ( var i = 0; i < selRarms.length; i++) {
		html_selRarms.push(document.createElement("option"));
		html_selRarms[i].setAttribute("id", "r" + i);
		html_selRarms[i].setAttribute("value", selRarms[i].get_name());
		var best = "";
		srgain = 0;
		srgain = itemGain(selRarms[i], jobIndex);
		if (srgain > myrgain) {
			if (isUnique(selRarms[i], BShopRarms)) {
				BShopRarms.push(selRarms[i])
			}
			best = "";
			html_selRarms[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			if (srgain == myrgain && myrgain != 0) {
				best = "";
				html_selRarms[i].setAttribute("style",
						"color: #162F08 ; font-weight: bold")
			} else {
				best = "";
				html_selRarms[i].setAttribute("style", "color: #523F30")
			}
		}
		if (Srgain == srgain && Srgain - myrgain > 0) {
			best = "";
			html_selRarms[i].setAttribute("style",
					"color: #1A641B ; font-weight: bolder")
		}
		html_selRarms[i].innerHTML = best
				+ '<img src="images/items/right_arm/mini/'
				+ selRarms[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ selRarms[i].get_name() + " (" + srgain + "-" + myrgain + ")="
				+ (srgain - myrgain);
		selRarm.appendChild(html_selRarms[i]);
		if (isSetItem(selRarms[i]) && isUnique(selRarms[i], BShopRarms)) {
			BShopNecks.push(selRarms[i])
		}
	}
	tryRarmImage = document.createElement("img");
	for ( var i = 0; i < selRarms.length; i++) {
		tryRarmImage = selRarms[i].img;
		tryRarm.appendChild(tryRarmImage);
		tryRarm.removeChild(tryRarmImage)
	}
	selRarm
			.setAttribute(
					"onchange",
					"tryRarmImage=selRarms[selRarm.selectedIndex].img;tryRarm.innerHTML=' ';tryRarm.appendChild(tryRarmImage);tryRarmStatus.innerHTML='Shop item';tryRarm.appendChild(document.createElement('br'));srgain=itemGain(selRarms[selRarm.selectedIndex],jobIndex);tryRarm.appendChild(document.createTextNode('gain:'+' '+srgain));tryRarm.appendChild(document.createElement('br'));tryRarm.appendChild(document.createTextNode('net:'+' ('+srgain+'-'+myrgain+')='+(srgain-myrgain)));disRarm=selRarms[selRarm.selectedIndex];epilogos();tryRarmImage.style.width=\"50px\";tryRarmImage.style.height=\"50px\";");
	selRarm
			.setAttribute(
					"onclick",
					"tryRarmImage=selRarms[selRarm.selectedIndex].img;tryRarm.innerHTML=' ';tryRarm.appendChild(tryRarmImage);tryRarmStatus.innerHTML='Shop item';tryRarm.appendChild(document.createElement('br'));srgain=itemGain(selRarms[selRarm.selectedIndex],jobIndex);tryRarm.appendChild(document.createTextNode('gain:'+' '+srgain));tryRarm.appendChild(document.createElement('br'));tryRarm.appendChild(document.createTextNode('net:'+' ('+srgain+'-'+myrgain+')='+(srgain-myrgain)));disRarm=selRarms[selRarm.selectedIndex];epilogos();tryRarmImage.style.width=\"50px\";tryRarmImage.style.height=\"50px\";");
	selRarm
			.setAttribute("style",
					"background-color: #B8AD95;font-weight: bold");
	myselRarm = document.createElement("select");
	myselRarms = new Array();
	bag = Bag.getInstance().items;
	myselRarms.push(wearing_items.right_arm);
	for ( var p in bag) {
		if (bag[p].get_type() == "right_arm") {
			myselRarms.push(bag[p])
		}
	}
	myhtml_selRarms = new Array();
	myrgain = itemGain(the_Rarm, jobIndex);
	for ( var i = 0; i < myselRarms.length; i++) {
		myhtml_selRarms.push(document.createElement("option"));
		myhtml_selRarms[i].setAttribute("id", "myr" + i);
		myhtml_selRarms[i].setAttribute("value", myselRarms[i].get_name());
		var best = "";
		srgain = 0;
		srgain = itemGain(myselRarms[i], jobIndex);
		if (srgain == myrgain && myrgain != 0) {
			best = "";
			myhtml_selRarms[i].setAttribute("style",
					"color: #1A641B ; font-weight: bold")
		} else {
			if (srgain == 0) {
				best = "";
				myhtml_selRarms[i].setAttribute("style", "color: #523F30")
			} else {
				best = "";
				myhtml_selRarms[i].setAttribute("style", "color: #162F08")
			}
		}
		myhtml_selRarms[i].innerHTML = best
				+ '<img src="images/items/right_arm/mini/'
				+ myselRarms[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ myselRarms[i].get_name() + " " + srgain;
		myselRarm.appendChild(myhtml_selRarms[i])
	}
	tryRarmStatus.innerHTML = "Inventory Item";
	for ( var i = 0; i < myselRarms.length; i++) {
		tryRarmImage = myselRarms[i].img;
		tryRarm.appendChild(tryRarmImage);
		tryRarm.removeChild(tryRarmImage)
	}
	tryRarmImage = the_Rarm.img;
	tryRarm.appendChild(tryRarmImage);
	tryRarm.appendChild(document.createElement("br"));
	srgain = itemGain(the_Rarm, jobIndex);
	tryRarm.appendChild(document.createTextNode("gain: " + srgain));
	myselRarm
			.setAttribute(
					"onchange",
					"tryRarmImage=myselRarms[myselRarm.selectedIndex].img;tryRarm.innerHTML=' ';tryRarm.appendChild(tryRarmImage);tryRarmStatus.innerHTML='Inventory item';tryRarm.appendChild(document.createElement('br'));srgain=itemGain(myselRarms[myselRarm.selectedIndex],jobIndex);tryRarm.appendChild(document.createTextNode('gain:'+' '+srgain));disRarm=myselRarms[myselRarm.selectedIndex];epilogos();tryRarmImage.style.width=\"50px\";tryRarmImage.style.height=\"50px\";");
	myselRarm
			.setAttribute(
					"onclick",
					"tryRarmImage=myselRarms[myselRarm.selectedIndex].img;tryRarm.innerHTML=' ';tryRarm.appendChild(tryRarmImage);tryRarmStatus.innerHTML='Inventory item';tryRarm.appendChild(document.createElement('br'));srgain=itemGain(myselRarms[myselRarm.selectedIndex],jobIndex);tryRarm.appendChild(document.createTextNode('gain:'+' '+srgain));disRarm=myselRarms[myselRarm.selectedIndex];epilogos();tryRarmImage.style.width=\"50px\";tryRarmImage.style.height=\"50px\";");
	myselRarm.setAttribute("style",
			"background-color: #B8AD95;font-weight: bold");
	for ( var i = 0; i < myselRarms.length; i++) {
		if (myselRarms[i].get_name() == the_Rarm.get_name()) {
			myselRarm.selectedIndex = i;
			break
		}
	}
	tryYield = document.createElement("div");
	tryYieldStatus = document.createElement("div");
	tryYieldname = document.createElement("div");
	tryYieldtext = document.createElement("div");
	tryYield.setAttribute("id", "tryyield");
	selYield = document.createElement("select");
	selYields = new Array();
	bag = Bag.getInstance().items;
	for ( var p in bag) {
		if (bag[p].get_type() == "yield") {
			selYields.push(bag[p])
		}
	}
	selYields.push(wearing_items.yield);
	html_selYields = new Array();
	for ( var i = 0; i < selYields.length; i++) {
		html_selYields.push(document.createElement("option"));
		html_selYields[i].setAttribute("id", "y" + i);
		html_selYields[i].setAttribute("value", selYields[i].get_name());
		var best = "";
		if (selYields[i].get_short() == "potion"
				|| selYields[i].get_short() == "pitchfork"
				|| selYields[i].get_short() == "cane"
				|| selYields[i].get_short() == "hymnal"
				|| selYields[i].get_short() == "ring"
				|| selYields[i].get_short() == "tequila") {
			best = "";
			html_selYields[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			best = "";
			html_selYields[i].setAttribute("style", "color: #523F30")
		}
		html_selYields[i].innerHTML = best
				+ '<img src="images/items/yield/mini/'
				+ selYields[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ selYields[i].get_name();
		selYield.appendChild(html_selYields[i])
	}
	tryYieldImage = document.createElement("img");
	for ( var i = 0; i < selYields.length; i++) {
		tryYieldImage = selYields[i].img;
		tryYield.appendChild(tryYieldImage);
		tryYield.removeChild(tryYieldImage)
	}
	tryYieldImage = disYield.img;
	tryYield.appendChild(tryYieldImage);
	tryYield.appendChild(document.createElement("br"));
	selYield
			.setAttribute(
					"onchange",
					"tryYieldImage=selYields[selYield.selectedIndex].img;tryYield.innerHTML=' ';tryYield.appendChild(tryYieldImage);tryYield.appendChild(document.createElement('br'));disYield=selYields[selYield.selectedIndex];epilogos();tryYieldImage.style.width=\"50px\";tryYieldImage.style.height=\"50px\";");
	selYield
			.setAttribute(
					"oncdblclick",
					"tryYieldImage=selYields[selYield.selectedIndex].img;tryYield.innerHTML=' ';tryYield.appendChild(tryYieldImage);tryYield.appendChild(document.createElement('br'));disYield=selYields[selYield.selectedIndex];epilogos();tryYieldImage.style.width=\"50px\";tryYieldImage.style.height=\"50px\";");
	selYield.setAttribute("style",
			"background-color: #B8AD95;font-weight: bold");
	for ( var i = 0; i < selYields.length; i++) {
		if (selYields[i].get_name() == disYield.get_name()) {
			selYield.selectedIndex = i;
			break
		}
	}
	tryAnimal = document.createElement("div");
	tryAnimalStatus = document.createElement("div");
	tryAnimalname = document.createElement("div");
	tryAnimaltext = document.createElement("div");
	tryAnimal.setAttribute("id", "tryanimal");
	selAnimal = document.createElement("select");
	selAnimals = new Array();
	bag = Bag.getInstance().items;
	for ( var p in bag) {
		if (bag[p].get_type() == "animal") {
			selAnimals.push(bag[p])
		}
	}
	selAnimals.push(wearing_items.animal);
	html_selAnimals = new Array();
	for ( var i = 0; i < selAnimals.length; i++) {
		html_selAnimals.push(document.createElement("option"));
		html_selAnimals[i].setAttribute("id", "anim" + i);
		html_selAnimals[i].setAttribute("value", selAnimals[i].get_name());
		var best = "";
		if (selAnimals[i].get_short() == "donkey"
				|| selAnimals[i].get_short() == "mustang") {
			best = "";
			html_selAnimals[i].setAttribute("style",
					"color: #162F08 ; font-weight: bold")
		} else {
			best = "";
			html_selAnimals[i].setAttribute("style", "color: #523F30")
		}
		html_selAnimals[i].innerHTML = best
				+ '<img src="images/items/animal/mini/'
				+ selAnimals[i].get_short()
				+ '.png" style="width:20px;height:20px" />'
				+ selAnimals[i].get_name();
		selAnimal.appendChild(html_selAnimals[i])
	}
	tryAnimalImage = document.createElement("img");
	for ( var i = 0; i < selAnimals.length; i++) {
		tryAnimalImage = selAnimals[i].img;
		tryAnimal.appendChild(tryAnimalImage);
		tryAnimal.removeChild(tryAnimalImage)
	}
	tryAnimalImage = disAnimal.img;
	tryAnimal.appendChild(tryAnimalImage);
	tryAnimal.appendChild(document.createElement("br"));
	selAnimal
			.setAttribute(
					"onchange",
					"tryAnimalImage=selAnimals[selAnimal.selectedIndex].img;tryAnimal.innerHTML=' ';tryAnimal.appendChild(tryAnimalImage);tryAnimal.appendChild(document.createElement('br'));disAnimal=selAnimals[selAnimal.selectedIndex];epilogos();tryAnimalImage.style.width=\"50px\";tryAnimalImage.style.height=\"50px\";");
	selAnimal
			.setAttribute(
					"onclick",
					"tryAnimalImage=selAnimals[selAnimal.selectedIndex].img;tryAnimal.innerHTML=' ';tryAnimal.appendChild(tryAnimalImage);tryAnimal.appendChild(document.createElement('br'));disAnimal=selAnimals[selAnimal.selectedIndex];epilogos();tryAnimalImage.style.width=\"50px\";tryAnimalImage.style.height=\"50px\";");
	selAnimal.setAttribute("style",
			"background-color: #B8AD95;font-weight: bold");
	for ( var i = 0; i < selAnimals.length; i++) {
		if (selAnimals[i].get_name() == disAnimal.get_name()) {
			selAnimal.selectedIndex = i;
			break
		}
	}
	newdiv = document.createElement("div");
	divIdName = "apotelesma";
	newdiv.setAttribute("id", divIdName);
	newdiv.setAttribute("style", "background:#907E61");
	newdiv.appendChild(intro());
	tab1 = document.createElement("table");
	tab1.setAttribute("border", "1");
	tab1.setAttribute("align", "center");
	row1 = document.createElement("tr");
	row2 = document.createElement("tr");
	row3 = document.createElement("tr");
	cell1 = document.createElement("td");
	cell2 = document.createElement("td");
	cell3 = document.createElement("td");
	cell4 = document.createElement("td");
	cell5 = document.createElement("td");
	cell6 = document.createElement("td");
	cell7 = document.createElement("td");
	cell8 = document.createElement("td");
	cell9 = document.createElement("td");
	cell14 = document.createElement("td");
	cell24 = document.createElement("td");
	cell34 = document.createElement("td");
	cell1.appendChild(tryNeckStatus);
	cell1.appendChild(tryNeck);
	cell1.appendChild(document.createTextNode("try from Inventory:"));
	cell1.appendChild(document.createElement("br"));
	cell1.appendChild(myselNeck);
	cell1.appendChild(document.createElement("br"));
	cell1.appendChild(document.createTextNode("try from Shops:"));
	cell1.appendChild(document.createElement("br"));
	cell1.appendChild(selNeck);
	cell2.appendChild(tryHeadStatus);
	cell2.appendChild(tryHead);
	cell2.appendChild(document.createTextNode("try from Inventory:"));
	cell2.appendChild(document.createElement("br"));
	cell2.appendChild(myselHead);
	cell2.appendChild(document.createElement("br"));
	cell2.appendChild(document.createTextNode("try from Shops:"));
	cell2.appendChild(document.createElement("br"));
	cell2.appendChild(selHead);
	cell3.appendChild(tryRarmStatus);
	cell3.appendChild(tryRarm);
	cell3.appendChild(document.createTextNode("try from Inventory:"));
	cell3.appendChild(document.createElement("br"));
	cell3.appendChild(myselRarm);
	cell3.appendChild(document.createElement("br"));
	cell3.appendChild(document.createTextNode("try from Shops:"));
	cell3.appendChild(document.createElement("br"));
	cell3.appendChild(selRarm);
	cell4.appendChild(tryBodyStatus);
	cell4.appendChild(tryBody);
	cell4.appendChild(document.createTextNode("try from Inventory:"));
	cell4.appendChild(document.createElement("br"));
	cell4.appendChild(myselBody);
	cell4.appendChild(document.createElement("br"));
	cell4.appendChild(document.createTextNode("try from Shops:"));
	cell4.appendChild(document.createElement("br"));
	cell4.appendChild(selBody);
	cell6.appendChild(tryFootStatus);
	cell6.appendChild(tryFoot);
	cell6.appendChild(document.createTextNode("try from Inventory:"));
	cell6.appendChild(document.createElement("br"));
	cell6.appendChild(myselFoot);
	cell6.appendChild(document.createElement("br"));
	cell6.appendChild(document.createTextNode("try from Shops:"));
	cell6.appendChild(document.createElement("br"));
	cell6.appendChild(selFoot);
	cell5.appendChild(tryYield);
	cell5.appendChild(selYield);
	cell9.appendChild(tryAnimal);
	cell9.appendChild(selAnimal);
	pFortState = document.createElement("p");
	pFortState.innerHTML = "";
	vvv = calculateBestSet();
	debugTextOut = handleTheSet(vvv);
	cell7.appendChild(setInfoP);
	SetLinks = document.createElement("p");
	SetLinks.innerHTML = '<font style="color: #1A641B ; font-weight: bolder ; padding-top: 15px">CALCULATED SETS:</font><br />';
	bestInvSet = document.createElement("a");
	bestInvSet
			.setAttribute("href",
					"javascript: var something=handleTheSet2(InventoryBestSet);epilogos();void(0);");
	bestInvSet.innerHTML = "&hearts;My Best Set";
	SetLinks.appendChild(bestInvSet);
	bestOfSet = document.createElement("a");
	bestOfSet
			.setAttribute("href",
					"javascript: var something=handleTheSet2(theBestOfSet);epilogos();void(0);");
	bestOfSet.innerHTML = "The Best Shop Set";
	SetLinks.innerHTML += "<br />";
	SetLinks.appendChild(bestOfSet);
	bestvSet = document.createElement("a");
	bestvSet
			.setAttribute("href",
					"javascript: var something=handleTheSet2(theBestValidSet);epilogos();void(0);");
	bestvSet.innerHTML = "The Best Valid Shop Set";
	SetLinks.innerHTML += "<br />";
	SetLinks.appendChild(bestvSet);
	cell34.appendChild(SetLinks);
	cell24.innerHTML = '<font style="color: #1A641B ; font-weight: bolder ; padding-top: 15px">FORTS:</font><br />';
	dfort = document.createElement("a");
	dfort
			.setAttribute(
					"href",
					'javascript: fortFl.id="dfort";pFortState.innerHTML="calculating...";wcsScript();void(0);');
	dfort.innerHTML = "fort defence";
	cell24.appendChild(dfort);
	cell24.innerHTML += "<br />";
	afort = document.createElement("a");
	afort
			.setAttribute(
					"href",
					'javascript: fortFl.id="afort";pFortState.innerHTML="calculating...";wcsScript();void(0);');
	afort.innerHTML = "fort attack";
	cell24.appendChild(afort);
	cell24.innerHTML += "<br />";
	cfort = document.createElement("a");
	cfort
			.setAttribute(
					"href",
					'javascript: fortFl.id="fpnone";pFortState.innerHTML="next time action:<br />job<br /> calculations";void(0);');
	cfort.innerHTML = "clear fort state";
	cell14.innerHTML += "Select a job <br />from the minimap<br /> and click: <br />";
	jobLink = document.createElement("a");
	jobLink
			.setAttribute(
					"href",
					'javascript: remotePanel.postMessage("Hi", "http://www.westcalc.info");void(0);');
	jobLink.innerHTML = "Force initialization";
	cell8.appendChild(pFortState);
	cell8.innerHTML += "<br /><br /><br />";
	cell8.appendChild(jobLink);
	fixPanel = document.createElement("a");
	fixPanel.setAttribute("href",
			'javascript: newdiv.style.paddingTop=WMap.ySize+255+"px";void(0);');
	fixPanel.innerHTML = "fix position";
	row1.appendChild(cell1);
	row1.appendChild(cell2);
	row1.appendChild(cell7);
	row2.appendChild(cell3);
	row2.appendChild(cell4);
	row2.appendChild(cell8);
	row3.appendChild(cell9);
	row3.appendChild(cell6);
	row3.appendChild(cell5);
	tab1.appendChild(row1);
	tab1.appendChild(row2);
	tab1.appendChild(row3);
	newdiv.appendChild(tab1);
	cell7.appendChild(epilogos());
	line = document.createElement("hr");
	newdiv.appendChild(line);
	end_space1 = document.createElement("div");
	end_space1
			.setAttribute("style",
					"overflow:visible;min-height:250px;color:#000000;width:100%;textAlign:left;");
	curSavedSetName = "default";
	savedSetSpace = document.createElement("div");
	fortFl = document.createElement("p");
	fortFl.setAttribute("id", "fpnone");
	newdiv.appendChild(fortFl);
	newdiv.appendChild(fixPanel);
	if (document.getElementById(divIdName) != null) {
		var olddiv = document.getElementById(divIdName);
		document.body.removeChild(olddiv)
	}
	newdiv.style.paddingTop = WMap.ySize + 255 + "px";
	newdiv.style.width = "auto";
	newdiv.style.textAlign = "center";
	document.body.appendChild(newdiv);
	var disSet = "<br />" + disHead.get_name() + ", " + disBody.get_name()
			+ ", " + disFoot.get_name() + ",<br />" + disNeck.get_name() + ", "
			+ disRarm.get_name() + ", " + disAnimal.get_name() + ",<br />"
			+ disYield.get_name();
	remotePanel.postMessage("<br />" + intro().innerHTML + "<br />"
			+ Epilogos.innerHTML + "<br />" + disSet,
			"http://www.westcalc.info");
	window.scrollTo(0, WMap.ySize);
	smallImages();
	AjaxWindow.show("inventory");
	setInventoryToPlace()
}
function setInventoryToPlace() {
	try {
		var exn = AjaxWindow.getWindowDivId("inventory");
		var dddd = document.getElementById(exn);
		dddd.style.marginTop = WMap.ySize - 345 + "px";
		dddd.centerLeft()
	} catch (e) {
	}
}
function smallImages() {
	tryHeadImage.style.width = "50px";
	tryHeadImage.style.height = "50px";
	tryBodyImage.style.width = "50px";
	tryBodyImage.style.height = "50px";
	tryFootImage.style.width = "50px";
	tryFootImage.style.height = "50px";
	tryNeckImage.style.width = "50px";
	tryNeckImage.style.height = "50px";
	tryRarmImage.style.width = "50px";
	tryRarmImage.style.height = "50px";
	tryAnimalImage.style.width = "50px";
	tryAnimalImage.style.height = "50px";
	tryYieldImage.style.width = "50px";
	tryYieldImage.style.height = "50px"
}
var rs123;
var st123;
var rep123;
var ids123;
var done123;
var sem_ready = 1;
var outSideTimer;
function addPause() {
	st123++;
	if (done123) {
		return
	}
	if (st123 == rep123) {
		done123 = 1;
		remotePanel.postMessage("AJ:" + rs123, "http://www.westcalc.info");
		return
	}
	if (sem_ready) {
		rs123 += wcSlim(parseInt(ids123[st123])) + ","
	} else {
		st123--
	}
	setTimeout("addPause()", 0)
}
function allJobs(jobIds, filter) {
	done123 = 0;
	var ids = jobIds.split(",");
	var resultString = "";
	ids123 = ids;
	rs123 = resultString;
	st123 = -1;
	rep123 = ids.length;
	if (filter == "I") {
		try {
			clearTimeout(outsideTimer)
		} catch (e) {
		}
		sem_ready = 1;
		outSideTimer = setTimeout("addPause()", 0)
	} else {
		if (filter == "W") {
			var allTest = new Array();
			allTest.push(Wear.wear.head);
			allTest.push(Wear.wear.body);
			allTest.push(Wear.wear.foot);
			allTest.push(Wear.wear.neck);
			allTest.push(Wear.wear.right_arm);
			allTest.push(Wear.wear.yield);
			allTest.push(Wear.wear.animal);
			handleTheSet2(allTest);
			epilogos();
			var realJobid = jobIndex;
			for ( var i = 0; i < ids.length; i++) {
				jobIndex = parseInt(ids[i]);
				resultString += (epilogosMini(allTest) - JobList[jobIndex].malus)
						+ ","
			}
			jobIndex = realJobid;
			done123 = 1;
			AjaxWindow.show("inventory");
			setInventoryToPlace()
		} else {
			if (filter == "D") {
				var allTest = new Array();
				allTest.push(disHead);
				allTest.push(disBody);
				allTest.push(disFoot);
				allTest.push(disNeck);
				allTest.push(disRarm);
				allTest.push(disYield);
				allTest.push(disAnimal);
				var realJobid = jobIndex;
				for ( var i = 0; i < ids.length; i++) {
					jobIndex = parseInt(ids[i]);
					resultString += (epilogosMini(allTest) - JobList[jobIndex].malus)
							+ ","
				}
				jobIndex = realJobid;
				done123 = 1
			}
		}
	}
	if (done123) {
		remotePanel.postMessage("AJ:" + resultString,
				"http://www.westcalc.info")
	}
	if (filter == "D") {
		remotePanel.postMessage("DRS:" + disHead.get_name() + ","
				+ disBody.get_name() + "," + disFoot.get_name() + ","
				+ disNeck.get_name() + "," + disRarm.get_name() + ","
				+ disAnimal.get_name() + "," + disYield.get_name(),
				"http://www.westcalc.info")
	}
}
function wcSlim(myMyJobId) {
	sem_ready = 0;
	necks = new Array();
	heads = new Array();
	rarms = new Array();
	bodies = new Array();
	foott = new Array();
	yields = new Array();
	animals = new Array();
	var slimInventoryBestSet = new Array();
	jobIndex = myMyJobId;
	bag = Bag.getInstance().items;
	wearing_items = Wear.wear;
	the_Head = getHead(jobIndex);
	the_Neck = getNeck(jobIndex);
	the_Rarm = getRarm(jobIndex);
	the_Body = getBody(jobIndex);
	the_Foot = getFoot(jobIndex);
	try {
		the_Yield = getYield(jobIndex);
		the_Animal = Wear.wear.animal
	} catch (e) {
	}
	var mySetHeads = new Array();
	var mexic = 1;
	var charl = 1;
	var gentl = 1;
	var dance = 1;
	var india = 1;
	var pilgr = 1;
	var pilgf = 1;
	var farme = 1;
	theHeadName = the_Head.get_short();
	for ( var i = 0; i < myselHeads.length; i++) {
		if (!isValid(myselHeads[i])) {
			continue
		}
		var bufferHeadName = myselHeads[i].get_short();
		if (bufferHeadName == "mexican_sombrero" && mexic
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			mexic = 0
		}
		if (bufferHeadName == "bowler_black" && charl
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			charl = 0
		}
		if (bufferHeadName == "cylinder_brown" && gentl
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			gentl = 0
		}
		if (bufferHeadName == "dancer_hat" && dance
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			dance = 0
		}
		if (bufferHeadName == "indian_hat" && india
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			india = 0
		}
		if (bufferHeadName == "pilger_hat" && pilgr
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			pilgr = 0
		}
		if (bufferHeadName == "pilger_cap" && pilgf
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			pilgf = 0
		}
		if (bufferHeadName == "slouch_hat_brown" && farme
				&& bufferHeadName != theHeadName) {
			mySetHeads.push(myselHeads[i]);
			farme = 0
		}
	}
	mySetHeads.push(the_Head);
	var mySetBodys = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theBodyName = the_Body.get_short();
	for ( var i = 0; i < myselBodys.length; i++) {
		if (!isValid(myselBodys[i])) {
			continue
		}
		var bufferBodyName = myselBodys[i].get_short();
		if (bufferBodyName == "poncho_brown" && mexic
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			mexic = 0
		}
		if (bufferBodyName == "vest_brown" && charl
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			charl = 0
		}
		if (bufferBodyName == "jacket_fine" && gentl
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			gentl = 0
		}
		if (bufferBodyName == "dancer_dress" && dance
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			dance = 0
		}
		if (bufferBodyName == "indian_jacket" && india
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			india = 0
		}
		if (bufferBodyName == "pilger_jacket" && pilgr
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			pilgr = 0
		}
		if (bufferBodyName == "pilger_dress" && pilgf
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			pilgf = 0
		}
		if (bufferBodyName == "clothes_black" && farme
				&& bufferBodyName != theBodyName) {
			mySetBodys.push(myselBodys[i]);
			farme = 0
		}
	}
	mySetBodys.push(the_Body);
	var mySetFoots = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theFootName = the_Foot.get_short();
	for ( var i = 0; i < myselFoots.length; i++) {
		if (!isValid(myselFoots[i])) {
			continue
		}
		var bufferFootName = myselFoots[i].get_short();
		if (bufferFootName == "mexican_shoes" && mexic
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			mexic = 0
		}
		if (bufferFootName == "quackery_shoes" && charl
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			charl = 0
		}
		if (bufferFootName == "gentleman_shoes" && gentl
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			gentl = 0
		}
		if (bufferFootName == "dancer_boots" && dance
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			dance = 0
		}
		if (bufferFootName == "mokassins" && india
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			india = 0
		}
		if (bufferFootName == "pilger_shoes" && pilgr
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			pilgr = 0
		}
		if (bufferFootName == "pilger_boots" && pilgf
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			pilgf = 0
		}
		if (bufferFootName == "working_black" && farme
				&& bufferFootName != theFootName) {
			mySetFoots.push(myselFoots[i]);
			farme = 0
		}
	}
	mySetFoots.push(the_Foot);
	var mySetNecks = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theNeckName = the_Neck.get_short();
	for ( var i = 0; i < myselNecks.length; i++) {
		if (!isValid(myselNecks[i])) {
			continue
		}
		var bufferNeckName = myselNecks[i].get_short();
		if (bufferNeckName == "mexican_neck" && mexic
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			mexic = 0
		}
		if (bufferNeckName == "fly_fine" && charl
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			charl = 0
		}
		if (bufferNeckName == "cravat_black" && gentl
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			gentl = 0
		}
		if (bufferNeckName == "dancer_chain" && dance
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			dance = 0
		}
		if (bufferNeckName == "indian_chain_fine" && india
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			india = 0
		}
		if (bufferNeckName == "cross_silver" && pilgr
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			pilgr = 0
		}
		if (bufferNeckName == "cross_bronze" && pilgf
				&& bufferNeckName != theNeckName) {
			mySetNecks.push(myselNecks[i]);
			pilgf = 0
		}
	}
	mySetNecks.push(the_Neck);
	var mySetYields = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theYieldName = the_Yield.get_short();
	for ( var i = 0; i < selYields.length; i++) {
		if (!isValid(selYields[i])) {
			continue
		}
		var bufferYieldName = selYields[i].get_short();
		if (bufferYieldName == "tequila" && mexic
				&& bufferYieldName != theYieldName) {
			mySetYields.push(selYields[i]);
			mexic = 0
		}
		if (bufferYieldName == "potion" && charl
				&& bufferYieldName != theYieldName) {
			mySetYields.push(selYields[i]);
			charl = 0
		}
		if (bufferYieldName == "cane" && gentl
				&& bufferYieldName != theYieldName) {
			mySetYields.push(selYields[i]);
			gentl = 0
		}
		if (bufferYieldName == "pitchfork" && farme
				&& bufferYieldName != theYieldName) {
			mySetYields.push(selYields[i]);
			farme = 0
		}
	}
	mySetYields.push(the_Yield);
	var mySetAnimals = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theAnimalName = the_Animal.get_short();
	for ( var i = 0; i < selAnimals.length; i++) {
		var bufferAnimalName = selAnimals[i].get_short();
		if (bufferAnimalName == "donkey" && mexic
				&& bufferAnimalName != theAnimalName) {
			mySetAnimals.push(selAnimals[i]);
			mexic = 0
		}
		if (bufferAnimalName == "mustang" && india
				&& bufferAnimalName != theAnimalName) {
			mySetAnimals.push(selAnimals[i]);
			india = 0
		}
	}
	mySetAnimals.push(the_Animal);
	var mySetRarms = new Array();
	mexic = 1;
	charl = 1;
	gentl = 1;
	dance = 1;
	india = 1;
	pilgr = 1;
	pilgf = 1;
	farme = 1;
	theRarmName = the_Rarm.get_short();
	for ( var i = 0; i < myselRarms.length; i++) {
		if (!isValid(myselRarms[i])) {
			continue
		}
		var bufferRarmName = myselRarms[i].get_short();
		if (bufferRarmName == "elixier" && charl
				&& bufferRarmName != theRarmName) {
			mySetRarms.push(myselRarms[i]);
			charl = 0
		}
	}
	mySetRarms.push(the_Rarm);
	var initialGain = -1;
	var initialValidGain = -1;
	var initialInvGain = -1;
	var theBestSet = new Array();
	var setsDroped = 0;
	for ( var i = 0; i < mySetHeads.length; i++) {
		for ( var j = 0; j < mySetBodys.length; j++) {
			for ( var k = 0; k < mySetFoots.length; k++) {
				for ( var l = 0; l < mySetNecks.length; l++) {
					for ( var m = 0; m < mySetRarms.length; m++) {
						for ( var n = 0; n < mySetYields.length; n++) {
							for ( var o = 0; o < mySetAnimals.length; o++) {
								var theTestSet = new Array();
								theTestSet.push(mySetHeads[i]);
								theTestSet.push(mySetBodys[j]);
								theTestSet.push(mySetFoots[k]);
								theTestSet.push(mySetNecks[l]);
								theTestSet.push(mySetRarms[m]);
								theTestSet.push(mySetYields[n]);
								theTestSet.push(mySetAnimals[o]);
								if (xorMexican1(theTestSet)
										|| xorCharlatan1(theTestSet)
										|| xorGentleman1(theTestSet)
										|| xorDancer1(theTestSet)
										|| xorFarmer1(theTestSet)
										|| xorPilgrimF1(theTestSet)
										|| xorPilgrim1(theTestSet)
										|| xorIndian1(theTestSet)) {
									setsDroped++;
									continue
								}
								var theTestSetGain = epilogosMini(theTestSet);
								if (theTestSetGain > initialInvGain) {
									initialInvGain = theTestSetGain;
									slimInventoryBestSet = theTestSet
								}
							}
						}
					}
				}
			}
		}
	}
	sem_ready = 1;
	return initialInvGain - JobList[myMyJobId].malus
}
function xorMexican(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "mexican_sombrero") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "mexican_neck") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "poncho_brown") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "mexican_shoes") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[6].get_short() == "donkey") {
		Ace = xorSet[6];
		mySetCount++
	}
	if (xorSet[5].get_short() == "tequila") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == the_Animal.get_short()
				|| Ace.get_short() == shop_Head.get_short()
				|| Ace.get_short() == shop_Body.get_short()
				|| Ace.get_short() == shop_Foot.get_short()
				|| Ace.get_short() == shop_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorCharlatan(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "bowler_black") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "fly_fine") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "vest_brown") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "quackery_shoes") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[4].get_short() == "elixier") {
		Ace = xorSet[4];
		mySetCount++
	}
	if (xorSet[5].get_short() == "potion") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == the_Rarm.get_short()
				|| Ace.get_short() == shop_Head.get_short()
				|| Ace.get_short() == shop_Body.get_short()
				|| Ace.get_short() == shop_Foot.get_short()
				|| Ace.get_short() == shop_Neck.get_short()
				|| Ace.get_short() == shop_Rarm.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorGentleman(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "cylinder_brown") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "cravat_black") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "jacket_fine") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "gentleman_shoes") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[5].get_short() == "cane") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == shop_Head.get_short()
				|| Ace.get_short() == shop_Body.get_short()
				|| Ace.get_short() == shop_Foot.get_short()
				|| Ace.get_short() == shop_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorDancer(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "dancer_hat") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "dancer_chain") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "dancer_dress") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "dancer_boots") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == shop_Head.get_short()
				|| Ace.get_short() == shop_Body.get_short()
				|| Ace.get_short() == shop_Foot.get_short()
				|| Ace.get_short() == shop_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorFarmer(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "slouch_hat_brown") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[5].get_short() == "pitchfork") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (xorSet[1].get_short() == "clothes_black") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "working_black") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == shop_Head.get_short()
				|| Ace.get_short() == shop_Body.get_short()
				|| Ace.get_short() == shop_Foot.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorPilgrimF(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "pilger_cap") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "cross_bronze") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "pilger_dress") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "pilger_boots") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[5].get_short() == "ring") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == shop_Head.get_short()
				|| Ace.get_short() == shop_Body.get_short()
				|| Ace.get_short() == shop_Foot.get_short()
				|| Ace.get_short() == shop_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorPilgrim(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "pilger_hat") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "cross_silver") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "pilger_jacket") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "pilger_shoes") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[5].get_short() == "hymnal") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == shop_Head.get_short()
				|| Ace.get_short() == shop_Body.get_short()
				|| Ace.get_short() == shop_Foot.get_short()
				|| Ace.get_short() == shop_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorIndian(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "indian_hat") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "indian_chain_fine") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "indian_jacket") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "mokassins") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[6].get_short() == "mustang") {
		Ace = xorSet[6];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Animal.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == shop_Head.get_short()
				|| Ace.get_short() == shop_Body.get_short()
				|| Ace.get_short() == shop_Foot.get_short()
				|| Ace.get_short() == shop_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorMexican1(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "mexican_sombrero") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "mexican_neck") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "poncho_brown") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "mexican_shoes") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[6].get_short() == "donkey") {
		Ace = xorSet[6];
		mySetCount++
	}
	if (xorSet[5].get_short() == "tequila") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == the_Animal.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorCharlatan1(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "bowler_black") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "fly_fine") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "vest_brown") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "quackery_shoes") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[4].get_short() == "elixier") {
		Ace = xorSet[4];
		mySetCount++
	}
	if (xorSet[5].get_short() == "potion") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == the_Rarm.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorGentleman1(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "cylinder_brown") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "cravat_black") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "jacket_fine") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "gentleman_shoes") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[5].get_short() == "cane") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Neck.get_short()
				|| Ace.get_short() == the_Yield.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorDancer1(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "dancer_hat") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "dancer_chain") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "dancer_dress") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "dancer_boots") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorFarmer1(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "slouch_hat_brown") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[5].get_short() == "pitchfork") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (xorSet[1].get_short() == "clothes_black") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "working_black") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Yield.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorPilgrimF1(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "pilger_cap") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "cross_bronze") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "pilger_dress") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "pilger_boots") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[5].get_short() == "ring") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == the_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorPilgrim1(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "pilger_hat") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "cross_silver") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "pilger_jacket") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "pilger_shoes") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[5].get_short() == "hymnal") {
		Ace = xorSet[5];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Yield.get_short()
				|| Ace.get_short() == the_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function xorIndian1(xorSet) {
	var mySetCount = 0;
	var Ace;
	if (xorSet[0].get_short() == "indian_hat") {
		Ace = xorSet[0];
		mySetCount++
	}
	if (xorSet[3].get_short() == "indian_chain_fine") {
		Ace = xorSet[3];
		mySetCount++
	}
	if (xorSet[1].get_short() == "indian_jacket") {
		Ace = xorSet[1];
		mySetCount++
	}
	if (xorSet[2].get_short() == "mokassins") {
		Ace = xorSet[2];
		mySetCount++
	}
	if (xorSet[6].get_short() == "mustang") {
		Ace = xorSet[6];
		mySetCount++
	}
	if (mySetCount == 1) {
		if (Ace.get_short() == the_Head.get_short()
				|| Ace.get_short() == the_Body.get_short()
				|| Ace.get_short() == the_Foot.get_short()
				|| Ace.get_short() == the_Animal.get_short()
				|| Ace.get_short() == the_Neck.get_short()) {
			return 0
		} else {
			return 1
		}
	} else {
		return 0
	}
}
function echoEpilogo() {
	var disSet = "<br />" + disHead.get_name() + ", " + disBody.get_name()
			+ ", " + disFoot.get_name() + ",<br />" + disNeck.get_name() + ", "
			+ disRarm.get_name() + ", " + disAnimal.get_name() + ",<br />"
			+ disYield.get_name();
	remotePanel.postMessage("<br />" + intro().innerHTML + "<br />"
			+ Epilogos.innerHTML + "<br />" + disSet,
			"http://www.westcalc.info")
}
function localize(jobIds) {
	var ids = jobIds.split(",");
	var resultString = "";
	for ( var i = 0; i < ids.length; i++) {
		resultString += JobList[parseInt(ids[i])].name + ","
	}
	resultString = resultString.substring(0, resultString.length - 1);
	remotePanel.postMessage("LOC:" + resultString, "http://www.westcalc.info")
}
function getOnlyTheGains94(Arr) {
	var temp = new Array();
	for (i = 0; i < Arr.length; i++) {
		if (itemGain(Arr[i], 94) > 0) {
			if (isUnique(Arr[i], temp) && isValid(Arr[i])) {
				temp.push(Arr[i])
			}
		}
	}
	return temp
}
function getGet94(Arr) {
	if (Arr.length == 0) {
		return Arr
	}
	for ( var i = 0; i < Arr.length; i++) {
		for ( var j = 0; j < Arr.length; j++) {
			if (cIfBetter94(Arr[i], Arr[j]) == 1) {
				Arr[j] = Arr[i]
			}
		}
	}
	return removeDupli(Arr)
}
function cIfBetter94(it1, it2) {
	if (itemGain(it1, 96) >= itemGain(it2, 96)
			&& itemGain(it1, 97) >= itemGain(it2, 97)
			&& itemGain(it1, 98) >= itemGain(it2, 98)
			&& itemGain(it1, 99) >= itemGain(it2, 99)
			&& itemGain(it1, 101) >= itemGain(it2, 101)) {
		return 1
	} else {
		return -1
	}
}
function removeDupli(Arr) {
	var temp = new Array();
	temp.push(Arr[0]);
	for ( var i = 0; i < Arr.length; i++) {
		if (isUnique(Arr[i], temp)) {
			temp.push(Arr[i])
		}
	}
	return temp
}
function getOnlyTheGains95(Arr) {
	var temp = new Array();
	for (i = 0; i < Arr.length; i++) {
		if (itemGain(Arr[i], 95) > 0) {
			if (isUnique(Arr[i], temp) && isValid(Arr[i])) {
				temp.push(Arr[i])
			}
		}
	}
	return temp
}
function getGet95(Arr) {
	if (Arr.length == 0) {
		return Arr
	}
	for ( var i = 0; i < Arr.length; i++) {
		for ( var j = 0; j < Arr.length; j++) {
			if (cIfBetter95(Arr[i], Arr[j]) == 1) {
				Arr[j] = Arr[i]
			}
		}
	}
	return removeDupli(Arr)
}
function cIfBetter95(it1, it2) {
	if (itemGain(it1, 96) >= itemGain(it2, 96)
			&& itemGain(it1, 100) >= itemGain(it2, 100)
			&& itemGain(it1, 98) >= itemGain(it2, 98)
			&& itemGain(it1, 99) >= itemGain(it2, 99)
			&& itemGain(it1, 101) >= itemGain(it2, 101)) {
		return 1
	} else {
		return -1
	}
};