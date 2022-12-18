package pokemons;

import attacks.physicalAttacks.AerialAce;
import attacks.specialAttacks.Flamethrower;
import attacks.specialAttacks.NightDaze;
import attacks.specialAttacks.Snarl;
import attacks.statusAttacks.*;


public class Zoroark extends Zorua {
    public Zoroark(String name, int level) {
        super(name, level);

        this.setStats(60, 105, 60, 120, 60, 105);

        this.addMove(new NightDaze());
        this.addMove(new AerialAce());
        this.addMove(new Snarl());
        this.addMove(new Flamethrower());
    }

}
