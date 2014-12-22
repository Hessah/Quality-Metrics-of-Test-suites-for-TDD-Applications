package de.outstare.fortbattleplayer.statistics;

import de.outstare.fortbattleplayer.model.Combatant;
import de.outstare.fortbattleplayer.model.Weapon;
import de.outstare.fortbattleplayer.model.WeaponData;
import de.outstare.fortbattleplayer.model.impl.JSWeaponData;

abstract class WeaponModCounter {
	static WeaponData data = new JSWeaponData();

	abstract boolean counts(Combatant combatant, Weapon w);

	static class BayonetCounter extends WeaponModCounter {
		/**
		 * @see de.outstare.fortbattleplayer.statistics.WeaponModCounter#counts(Combatant,
		 *      de.outstare.fortbattleplayer.model.Weapon)
		 */
		@Override
		boolean counts(final Combatant combatant, final Weapon w) {
			return data.hasBayonet(combatant, w);
		}
	}

	static class LoadingchamberOrEnhancedPatronsCounter extends WeaponModCounter {
		/**
		 * @see de.outstare.fortbattleplayer.statistics.WeaponModCounter#counts(Combatant,
		 *      de.outstare.fortbattleplayer.model.Weapon)
		 */
		@Override
		boolean counts(final Combatant combatant, final Weapon w) {
			return data.hasLoadingchamberOrEnhancedPatrons(combatant, w);
		}
	}

	static class GraphitLubricantCounter extends WeaponModCounter {
		/**
		 * @see de.outstare.fortbattleplayer.statistics.WeaponModCounter#counts(Combatant,
		 *      de.outstare.fortbattleplayer.model.Weapon)
		 */
		@Override
		boolean counts(final Combatant combatant, final Weapon w) {
			return data.hasGraphitLubricant(combatant, w);
		}
	}

	static class FettesOilCounter extends WeaponModCounter {
		/**
		 * @see de.outstare.fortbattleplayer.statistics.WeaponModCounter#counts(Combatant,
		 *      de.outstare.fortbattleplayer.model.Weapon)
		 */
		@Override
		boolean counts(final Combatant combatant, final Weapon w) {
			return data.hasFettesWeaponOil(combatant, w);
		}
	}

	static class SchmierOilCounter extends WeaponModCounter {
		/**
		 * @see de.outstare.fortbattleplayer.statistics.WeaponModCounter#counts(Combatant,
		 *      de.outstare.fortbattleplayer.model.Weapon)
		 */
		@Override
		boolean counts(final Combatant combatant, final Weapon w) {
			return data.hasSchmierendesWeaponOil(combatant, w);
		}
	}

	static class ShinyOilCounter extends WeaponModCounter {
		/**
		 * @see de.outstare.fortbattleplayer.statistics.WeaponModCounter#counts(Combatant,
		 *      de.outstare.fortbattleplayer.model.Weapon)
		 */
		@Override
		boolean counts(final Combatant combatant, final Weapon w) {
			return data.hasShinyWeaponOil(combatant, w);
		}
	}

	static class FourShotMunitionCounter extends WeaponModCounter {
		/**
		 * @see de.outstare.fortbattleplayer.statistics.WeaponModCounter#counts(Combatant,
		 *      de.outstare.fortbattleplayer.model.Weapon)
		 */
		@Override
		boolean counts(final Combatant combatant, final Weapon w) {
			return data.has4ShotMunition(combatant, w);
		}
	}

	static class HipFlaskCounter extends WeaponModCounter {
		/**
		 * @see de.outstare.fortbattleplayer.statistics.WeaponModCounter#counts(Combatant,
		 *      de.outstare.fortbattleplayer.model.Weapon)
		 */
		@Override
		boolean counts(final Combatant combatant, final Weapon w) {
			return data.hasHipFlask(combatant, w);
		}
	}
}