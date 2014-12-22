javascript: (function() {
  var orig = FortBattle.makeStats;
  FortBattle.makeStats = function(data, element, fortx, forty, bool) {
    showMessage( [
        "<div>",
        '<textarea cols="40" rows="10" readonly="readonly" onclick="this.select();" />'
            + Json.toString(data) + "</textarea>", "</div>" ]
        .join(""), "Fortkampf Daten", 360, 100, [ [ "ok" ] ], true);
    return orig(data, element, fortx, forty, bool);
  }
})();
void (0);
