package de.outstare.fortbattleplayer.model.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import de.outstare.fortbattleplayer.model.Combatant;
import de.outstare.fortbattleplayer.model.Weapon;
import de.outstare.fortbattleplayer.model.WeaponData;

/**
 * A JSWeaponData uses the data from the JavaScript object "ItemManager".
 * 
 * @author daniel
 */
public class JSWeaponData implements WeaponData {
	private static final transient Logger LOG = Logger.getLogger(JSWeaponData.class.getName());
	private static final String CSV_FILE_WEAPONS = "/weaponData.csv";
	private static final String CSV_DELIMITER = ",";

	/**
	 * maps the id of a weapon to it's stats
	 */
	protected final static Map<Integer, WeaponGameData> data = loadData(CSV_FILE_WEAPONS);

	/**
	 * @param filename
	 * @return
	 */
	private static Map<Integer, WeaponGameData> loadData(final String filename) {
		final Map<Integer, WeaponGameData> result = new HashMap<Integer, WeaponGameData>();
		try {
			final InputStream fileInput = JSWeaponData.class.getResourceAsStream(filename);
			if (fileInput == null) {
				throw new FileNotFoundException(filename);
			}
			final BufferedReader input = new BufferedReader(new InputStreamReader(fileInput));
			try {
				String line;
				while ((line = input.readLine()) != null) {
					if ("".equals(line.trim())) {
						continue;
					}
					final String[] values = line.split(CSV_DELIMITER);
					assert values.length >= 7 : "csv has not at least 7 fields!";
					final int id = Integer.valueOf(values[0]).intValue();
					final int minDmg = Integer.valueOf(values[1]).intValue();
					final int maxDmg = Integer.valueOf(values[2]).intValue();
					final int attBonus = Integer.valueOf(values[3]).intValue();
					final int deffBonus = Integer.valueOf(values[4]).intValue();
					final int dmgBonus = Integer.valueOf(values[5]).intValue();
					final double dmgPerLevel = Double.valueOf(values[6]).doubleValue();
					final String weaponName;
					if (values.length > 7) {
						weaponName = values[7];
					} else {
						weaponName = "";
					}
					final WeaponGameData weapon = new WeaponGameData(id, minDmg, maxDmg, attBonus, deffBonus, dmgBonus,
					        dmgPerLevel, weaponName);
					result.put(Integer.valueOf(id), weapon);
				}
				LOG.fine("successfully read " + result.size() + " weapon data from file " + filename);
			} finally {
				input.close();
				fileInput.close();
			}
		} catch (final FileNotFoundException e) {
			LOG.severe("the CSV file with the bayonet damages was not found: " + filename);
			e.printStackTrace();
		} catch (final IOException e) {
			LOG.severe("failed to load CSV file with bayonet damages: " + e.toString());
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#getSectorDamageBonus(de.outstare.fortbattleplayer.model.Weapon)
	 */
	public int getSectorDamageBonus(final Weapon weapon) {
		final WeaponGameData weaponData = data.get(Integer.valueOf(weapon.getId()));
		if (weaponData == null) {
			return 0;
		}
		return weaponData.bonusDamage;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#getSectorAttBonus()
	 */
	public int getSectorAttBonus(final Weapon weapon) {
		final WeaponGameData weaponData = data.get(Integer.valueOf(weapon.getId()));
		if (weaponData == null) {
			return 0;
		}
		return weaponData.bonusOffense;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#getSectorDeffBonus()
	 */
	public int getSectorDeffBonus(final Weapon weapon) {
		final WeaponGameData weaponData = data.get(Integer.valueOf(weapon.getId()));
		if (weaponData == null) {
			return 0;
		}
		return weaponData.bonusDefense;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#getDmgPerCharLevel(Weapon)
	 */
	public double getDmgPerCharLevel(final Weapon weapon) {
		final WeaponGameData weaponData = data.get(Integer.valueOf(weapon.getId()));
		if (weaponData == null) {
			return 0;
		}
		return weaponData.damagePerCharLevel;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#hasBayonet(de.outstare.fortbattleplayer.model.Weapon)
	 */
	public boolean hasBayonet(final Combatant combatant, final Weapon weapon) {
		return hasBonus(combatant, weapon, 25, 75);
	}

	/**
	 * @param combatant
	 * @param weapon
	 * @param weaponData
	 * @param minDmgBonus
	 * @param maxDmgBonus
	 * @return
	 */
	boolean hasBonus(final Combatant combatant, final Weapon weapon, final int minDmgBonus, final int maxDmgBonus) {
		final WeaponGameData weaponData = data.get(Integer.valueOf(weapon.getId()));
		if (weaponData == null) {
			return false;
		}
		final double bonusDamage = weaponData.damagePerCharLevel * combatant.getCharacterLevel();
		final int expectedMaxDamage = (int) (weaponData.maxDamage + bonusDamage);
		final int expectedMinDamage = (int) (weaponData.minDamage + bonusDamage);
		return weapon.maxDamage() - expectedMaxDamage == maxDmgBonus
		        && weapon.minDamage() - expectedMinDamage == minDmgBonus;
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#hasGraphitLubricant(de.outstare.fortbattleplayer.model.Weapon)
	 */
	public boolean hasGraphitLubricant(final Combatant combatant, final Weapon weapon) {
		return hasBonus(combatant, weapon, 20, 40);
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#hasFettesWeaponOil(de.outstare.fortbattleplayer.model.Weapon)
	 */
	public boolean hasFettesWeaponOil(final Combatant combatant, final Weapon weapon) {
		return hasBonus(combatant, weapon, 50, 50);
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#hasSchmierendesWeaponOil(de.outstare.fortbattleplayer.model.Weapon)
	 */
	public boolean hasSchmierendesWeaponOil(final Combatant combatant, final Weapon weapon) {
		return hasBonus(combatant, weapon, 60, 60);
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#hasShinyWeaponOil(de.outstare.fortbattleplayer.model.Weapon)
	 */
	public boolean hasShinyWeaponOil(final Combatant combatant, final Weapon weapon) {
		return hasBonus(combatant, weapon, 75, 75);
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#has4ShotMunition(de.outstare.fortbattleplayer.model.Weapon)
	 */
	public boolean has4ShotMunition(final Combatant combatant, final Weapon weapon) {
		return hasBonus(combatant, weapon, 100, 100);
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#hasHipFlask(de.outstare.fortbattleplayer.model.Weapon)
	 */
	public boolean hasHipFlask(final Combatant combatant, final Weapon weapon) {
		return hasBonus(combatant, weapon, 40, 40);
	}

	/**
	 * @see de.outstare.fortbattleplayer.model.WeaponData#hasLoadingchamberOrEnhancedPatrons(de.outstare.fortbattleplayer.model.Weapon)
	 */
	public boolean hasLoadingchamberOrEnhancedPatrons(final Combatant combatant, final Weapon weapon) {
		return hasBonus(combatant, weapon, 30, 30);
	}

	/**
	 * Parsed data from file.
	 * 
	 * @author daniel
	 */
	static class WeaponGameData {
		@SuppressWarnings("javadoc")
		final int id;
		@SuppressWarnings("javadoc")
		final int minDamage;
		@SuppressWarnings("javadoc")
		final int maxDamage;
		@SuppressWarnings("javadoc")
		final int bonusOffense;
		@SuppressWarnings("javadoc")
		final int bonusDefense;
		@SuppressWarnings("javadoc")
		final int bonusDamage;
		@SuppressWarnings("javadoc")
		final double damagePerCharLevel;
		@SuppressWarnings("javadoc")
		final String name;

		/**
		 * @param id
		 * @param minDamage
		 * @param maxDamage
		 * @param bonusOffense
		 * @param bonusDefense
		 * @param bonusDamage
		 * @param name
		 */
		WeaponGameData(final int id, final int minDamage, final int maxDamage, final int bonusOffense,
		        final int bonusDefense, final int bonusDamage, final double dmgPerLevel, final String name) {
			this.id = id;
			this.minDamage = minDamage;
			this.maxDamage = maxDamage;
			this.bonusOffense = bonusOffense;
			this.bonusDefense = bonusDefense;
			this.bonusDamage = bonusDamage;
			damagePerCharLevel = dmgPerLevel;
			this.name = name;
		}

		/**
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + bonusDamage;
			result = prime * result + bonusDefense;
			result = prime * result + bonusOffense;
			long temp;
			temp = Double.doubleToLongBits(damagePerCharLevel);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + id;
			result = prime * result + maxDamage;
			result = prime * result + minDamage;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		/**
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof WeaponGameData)) {
				return false;
			}
			final WeaponGameData other = (WeaponGameData) obj;
			if (bonusDamage != other.bonusDamage) {
				return false;
			}
			if (bonusDefense != other.bonusDefense) {
				return false;
			}
			if (bonusOffense != other.bonusOffense) {
				return false;
			}
			if (Double.doubleToLongBits(damagePerCharLevel) != Double.doubleToLongBits(other.damagePerCharLevel)) {
				return false;
			}
			if (id != other.id) {
				return false;
			}
			if (maxDamage != other.maxDamage) {
				return false;
			}
			if (minDamage != other.minDamage) {
				return false;
			}
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			return true;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "WeaponGameData: minDmg=" + minDamage + ", maxDmg=" + maxDamage + ", offBonus=" + bonusOffense
			        + ", deffBonus=" + bonusDefense + ", name=" + name;
		}

	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		System.out.println(data);
	}
}
