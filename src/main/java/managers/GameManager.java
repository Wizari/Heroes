package managers;

import entyty.Hero;

import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    int distance;
    boolean swap = true;
    int randomNumber;


    public void run() {
        Hero hero1 = new Hero("ДевочкаВолшебница");
        Hero hero2 = new Hero("Ультрамарин");
        int a = 5; // Начальное значение диапазона - "от"
        int b = 10; // Конечное значение диапазона - "до"
        randomNumber = a + (int) (Math.random() * b);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                randomNumber--;
                getAnotherHero(hero1, hero2).move(randomNumber);
                if (randomNumber == 1) {
                    timer.cancel();
                }
            }
        }, 0, 1000);

    }

    Hero getAnotherHero(Hero hero1, Hero hero2) {
        if (swap) {
            swap = false;
            return hero1;
        } else {
            swap = true;
            return hero2;
        }
    }
}
