package attacks.physicalAttacks;

import ru.ifmo.se.pokemon.*;

public class WakeUpSlap extends PhysicalMove {

    public WakeUpSlap() {
        super(Type.FIGHTING, 70, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon p, double damage) {
        if (p.getCondition() == Status.SLEEP) {
            damage *= 2;
        }

        super.applyOppDamage(p, damage);

    }

    @Override
    protected String describe() {
        return "использует Aerial Ace";
    }
}
