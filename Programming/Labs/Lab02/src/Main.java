import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Battle;
import pokemons.*;


public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();

        Pokemon p1 = new Mawile("Ельцин", 1);
        Pokemon p2 = new Zorua("Путин", 1);
        Pokemon p3 = new Zoroark("Горбачёв", 1);

        Pokemon p4 = new Poliwag("Хрущёв", 1);
        Pokemon p5 = new Poliwhirl("Сталин", 1);
        Pokemon p6 = new Poliwrath("Брежнев", 1);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);

        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
