package attacks.specialAttacks;

import ru.ifmo.se.pokemon.*;

public class NightDaze extends SpecialMove {
    public NightDaze() {
        super(Type.DARK, 85, 95);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect effect = new Effect().chance(0.4).stat(Stat.ACCURACY, -1).turns(-1);
        p.addEffect(effect);
    }

    @Override
    protected String describe() {
        return "использует Night Daze";
    }

}
