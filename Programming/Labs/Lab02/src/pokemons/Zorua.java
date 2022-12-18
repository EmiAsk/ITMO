package pokemons;

import attacks.specialAttacks.*;
import attacks.statusAttacks.*;
import attacks.physicalAttacks.*;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;


public class Zorua extends Pokemon {
    public Zorua(String name, int level) {
        super(name, level);

        this.setStats(40, 65, 40, 80, 40, 65);
        this.setType(Type.DARK);

        this.addMove(new NightDaze());
        this.addMove(new AerialAce());
        this.addMove(new Snarl());

    }

}
