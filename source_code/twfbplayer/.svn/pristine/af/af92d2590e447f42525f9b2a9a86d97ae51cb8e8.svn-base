package de.outstare.fortbattleplayer.model.impl;

import de.outstare.fortbattleplayer.model.SectorBonus.BonusType;
import de.outstare.fortbattleplayer.model.Weapon;
import de.outstare.fortbattleplayer.model.WeaponModification;

/**
 * A SimpleWeapon just holds the values for a {@link Weapon}
 * 
 * @author daniel
 */
public class SimpleWeapon implements Weapon {
	private final int _id;
	private final String _name;
	private final int _minDamage;
	private final int _maxDamage;
	private final WeaponModification _modification;

	/**
	 * @param id
	 *            the unique ingame ID of this weapon
	 * @param name
	 *            not <code>null</code>
	 * @param minDamage
	 *            >= 0
	 * @param maxDamage
	 *            >= <code>minDamage</code>
	 */
	public SimpleWeapon(final int id, final String name, final int minDamage, final int maxDamage) {
		super();
		if (name == null || minDamage < 0 || maxDamage < 0 || minDamage > maxDamage) {
			throw new IllegalArgumentException("invalid parameters: " + name + ", " + minDamage + "," + maxDamage);
		}
		_id = id;
		_name = name;
		_minDamage = minDamage;
		_maxDamage = maxDamage;
		// TODO
		_modification = null;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.Weapon#getId()
	 */
	public int getId() {
		return _id;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.Weapon#name()
	 */
	public String name() {
		assert _name != null : "Nachbedingung nicht erfüllt: _name != null";
		return _name;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.Weapon#minDamage()
	 */
	public int minDamage() {
		assert _minDamage >= 0 : "Nachbedingung nicht erfüllt: _minDamage >= 0";
		return _minDamage;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.Weapon#maxDamage()
	 */
	public int maxDamage() {
		assert _maxDamage >= _minDamage : "Nachbedingung nicht erfüllt: _maxDamage >= _minDamage";
		return _maxDamage;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.Weapon#damagePerCharLevel()
	 */
	public double damagePerCharLevel() {
		return new JSWeaponData().getDmgPerCharLevel(this);
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.Weapon#getSectorBonus(BonusType)
	 */
	public int getSectorBonus(final BonusType type) {
		switch (type) {
		case ATTACK:
			return getSectorBonusAttack();
		case DEFENSE:
			return getSectorBonusDefend();
		case DAMAGE:
			return getSectorBonusDamage();
		default:
			return 0;
		}
	}

	/**
	 * @return
	 */
	protected int getSectorBonusDamage() {
		return new JSWeaponData().getSectorDamageBonus(this);
	}

	/**
	 * @return
	 */
	protected int getSectorBonusAttack() {
		return new JSWeaponData().getSectorAttBonus(this);
	}

	/**
	 * @return
	 */
	protected int getSectorBonusDefend() {
		return new JSWeaponData().getSectorDeffBonus(this);
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.Weapon#averageDamage()
	 */
	public int averageDamage() {
		return (minDamage() + maxDamage()) / 2;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.Weapon#getModification()
	 */
	public WeaponModification getModification() {
		return _modification;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Weapon " + _name + ", min dmg: " + _minDamage + ", max dmg: " + _maxDamage;
	}
}
