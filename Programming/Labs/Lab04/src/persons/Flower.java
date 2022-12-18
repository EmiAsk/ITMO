package persons;

import interfaces.Readable;

import java.util.Random;


public class Flower extends Person {
    public Flower() {
        super("Цветик");
    }

    public static class Verses {
        private static final String[] VERSES = {"У Лукоморья дуб зелёный, златая цепь на дубе том...",
                "Люблю грозу в начале мая..."};

        public static String get(int index) {
            return VERSES[index];
        };

        public static int getVersesNumber() {
            return VERSES.length;
        }

        public static String get() {
            Random rnd = new Random();
            int rndIndex = rnd.nextInt(getVersesNumber());
            return VERSES[rndIndex];
        }
    }

    public void getPulledFromBarrel() {
        System.out.printf("%s был стащен с бочки", this);
    }

    public void becomeFamous() {
        System.out.println("Именно благодаря этим стихам я прославился! Сейчас я их зачитаю:");
        this.readVerse();
    }

    public void readVerse() {
        System.out.printf("%s зачитал стих: %n %s", this, Flower.Verses.get());
    }
}
