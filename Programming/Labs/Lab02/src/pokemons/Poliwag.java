package pokemons;

import attacks.statusAttacks.*;
import attacks.specialAttacks.*;
import attacks.physicalAttacks.*;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Poliwag extends Pokemon {
    public Poliwag(String name, int level) {
        super(name, level);

        this.setType(Type.WATER);
        this.setStats(40, 50, 40, 40, 40, 90);

        this.addMove(new DoubleTeam());
        this.addMove(new Swagger());

    }

}
