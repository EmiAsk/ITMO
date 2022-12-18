package persons;

import interfaces.Droppable;

import java.util.Random;

public class LittleGirls {
    public void runBehind(Object obj) {
        System.out.printf("%s бежали позади %s %n", this, obj);
    }

    public void throwFlowerPetals() {
        class FlowerPetal implements Droppable {
            @Override
            public void drop() {
                System.out.printf("%s делает вжух!", this);
            }

            @Override
            public String toString() {
                return "Лепесток";
            }
        }
        System.out.printf("%s кидали лепестки %n", this);

        Random rnd = new Random();
        int petalsNumber = rnd.nextInt(1, 4);

        for (int i = 0; i < petalsNumber; i++) {
            FlowerPetal flower = new FlowerPetal();
            flower.drop();
        }
    }

    @Override
    public String toString() {
        return "<Малышки>";
    }
}
