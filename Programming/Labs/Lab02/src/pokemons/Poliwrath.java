package pokemons;

import attacks.statusAttacks.Confide;


public class Poliwrath extends Poliwhirl {
    public Poliwrath(String name, int level) {
        super(name, level);

        this.setStats(90, 95, 95, 70, 90, 70);

        this.addMove(new Confide());

    }
}
