package pokemons;

import attacks.specialAttacks.Flamethrower;
import attacks.statusAttacks.Confide;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import attacks.specialAttacks.SludgeBomb;
import attacks.specialAttacks.AncientPower;

public class Mawile extends Pokemon {

    public Mawile(String name, int level) {
        super(name, level);
        this.setStats(50, 85, 85, 55, 55, 50);
        this.setType(Type.STEEL);
        this.setType(Type.FAIRY);

        this.addMove(new SludgeBomb());
        this.addMove(new AncientPower());
        this.addMove(new Flamethrower());
        this.addMove(new Confide());
    }

    public static void main(String[] args) {
        Mawile maw = new Mawile("Mawile", 1);
    }
}
