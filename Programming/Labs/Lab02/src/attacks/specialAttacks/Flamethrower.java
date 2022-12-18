package attacks.specialAttacks;

import ru.ifmo.se.pokemon.*;
import java.util.Random;

public class Flamethrower extends SpecialMove {
    public Flamethrower() {
        super(Type.FIRE, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Random rnd = new Random();
        if (rnd.nextFloat() <= 0.1) {
            Effect.burn(p);
        }
    }

    @Override
    protected String describe() {
        return "использует Flamethrower";
    }
}
