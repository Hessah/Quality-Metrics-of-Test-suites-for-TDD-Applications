javascript: (function(){
ItemManager.init();
var item;
var exportedWeapons = "", minMaxDmg = "";
for(var i = 0; i<200000; i++) {
	item = ItemManager.get(i);
	if(item && item.type == 'left_arm') {
		minMaxDmg = item.damage.damage_min + ',' + item.damage.damage_max;
		fbBonus = item.bonus.fortbattlesector.offense + ',' + item.bonus.fortbattlesector.defense + ',' + item.bonus.fortbattlesector.damage;
		dmgPerLvl = 0;
		for (var j = 0; j<item.bonus.item.length; j++) {
			var itemBonus = item.bonus.item[j];
			if (itemBonus.type == 'character' && itemBonus.key == 'level' &&
				itemBonus.bonus.type == 'damage') {
				dmgPerLvl = itemBonus.bonus.value;
				break; 
			}
		}
		exportedWeapons = exportedWeapons + item.item_id + ',' + minMaxDmg + ',' + fbBonus + ',' + dmgPerLvl + ',' + item.name + '\n';
	} 
}
alert(exportedWeapons);
})();
void(0);
