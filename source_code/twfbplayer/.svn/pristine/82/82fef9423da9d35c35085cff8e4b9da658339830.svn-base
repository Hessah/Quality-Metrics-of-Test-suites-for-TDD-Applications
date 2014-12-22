package de.outstare.fortbattleplayer.model;

/**
 * WeaponData holds data about weapons. It can be used to determine additional
 * information to a weapon from the fortbattle log.
 * 
 * @author daniel
 */
public interface WeaponData {

	/**
	 * @param weapon
	 * @return the amount of additional damage a golden gun gives to it's sector
	 */
	int getSectorDamageBonus(Weapon weapon);

	/**
	 * @param weapon
	 * @return the amount of shooting bonus a golden gun gives to it's sector
	 */
	int getSectorAttBonus(Weapon weapon);

	/**
	 * @param weapon
	 * @return the amount of dodging bonus a golden gun gives to it's sector
	 */
	int getSectorDeffBonus(Weapon weapon);

	/**
	 * @param weapon
	 * @return the additional damage per character level the given weapon
	 *         supplies
	 */
	double getDmgPerCharLevel(final Weapon weapon);

	/**
	 * @param combatant
	 * @param weapon
	 * @return <code>true</code> if the the given weapon has a bajonett (does
	 *         more damage than normal)
	 */
	boolean hasBayonet(final Combatant combatant, Weapon weapon);

	/**
	 * @param combatant
	 * @param weapon
	 * @return <code>true</code> if the the given weapon has graphit lubricant
	 *         (does more damage than normal)
	 */
	boolean hasGraphitLubricant(final Combatant combatant, Weapon weapon);

	boolean hasFettesWeaponOil(final Combatant combatant, Weapon weapon);

	boolean hasSchmierendesWeaponOil(final Combatant combatant, Weapon weapon);

	boolean hasShinyWeaponOil(final Combatant combatant, Weapon weapon);

	boolean hasLoadingchamberOrEnhancedPatrons(final Combatant combatant, Weapon weapon);

	boolean hasHipFlask(final Combatant combatant, Weapon w);

	boolean has4ShotMunition(final Combatant combatant, Weapon weapon);
}
