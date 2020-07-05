package managers;

import entyty.Hero;

import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    private boolean swap = true;
    private int distance;
    private Hero temp;

    public void run() {
        Hero hero1 = new Hero("ДевочкаВолшебница");
        Hero hero2 = new Hero("Ультрамарин");
        int a = 4; // Начальное значение диапазона - "от"
        int b = 5; // Конечное значение диапазона - "до"
        distance = a + (int) (Math.random() * b);


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                distance--;
                getAnotherHero(hero1, hero2).move(distance);
                if (distance == 1) {
                    temp.hit();
                    timer.cancel();
                }
            }
        }, 0, 1000);

    }

    Hero getAnotherHero(Hero hero1, Hero hero2) {
        if (swap) {
            swap = false;
            temp = hero1;
            return hero1;
        } else {
            swap = true;
            temp = hero2;
            return hero2;
        }
    }
}
