package managers;

import entyty.Fraction;
import entyty.Hero;
import entyty.WeaponClass;
import utils.Helper;

import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    private boolean swap = true;
    private int distance;
    private HeroManager temp;
    private boolean firstHit = true;

    public void run() {
        HeroManager hero1 = new HeroManager("ДевочкаВолшебница", Fraction.CHAOS, WeaponClass.LIGHT);
        HeroManager hero2 = new HeroManager("Ультрамарин", Fraction.IMPERIUM, WeaponClass.HEAVY);
        distance = Helper.getRandom(4, 6);
        moveHero(hero1, hero2);
    }

    HeroManager getAnotherHero(HeroManager hero1, HeroManager hero2) {
        if (hero1 != temp) {
            temp = hero1;
            return hero1;
        } else {
            temp = hero2;
            return hero2;
        }
    }

    void moveHero(HeroManager hero1, HeroManager hero2) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                distance--;
                getAnotherHero(hero1, hero2).move(distance);
                if (distance == 1) {
                    timer.cancel();
                    hitting(hero1, hero2);
                }
            }
        }, 0, 1000);
    }

    void hitting(HeroManager hero1, HeroManager hero2) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (firstHit) {
                    temp.hit(getAnotherHero(hero1, hero2));
                    firstHit = false;
                } else {
                    temp.hit(getAnotherHero(hero1, hero2));
                    if (temp.getHp() <= 0) {
                        getAnotherHero(hero1, hero2);
                        temp.winMessage();
                        timer.cancel();
                    }
                }
            }
        }, 0, 1000);
    }
}
