package attacks.specialAttacks;

import ru.ifmo.se.pokemon.*;
import java.util.Random;


public class SludgeBomb extends SpecialMove {
    public static final float poisonChance = 0.3F;

    public SludgeBomb() {
        super(Type.POISON, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Random rnd = new Random();
        if (rnd.nextFloat() <= poisonChance) {
            Effect.poison(p);
        }
    }

    @Override
    protected String describe() {
        return "использует Sludge Bomb";
    }
}
