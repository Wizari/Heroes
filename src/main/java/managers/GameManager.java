package managers;

import entyty.Fraction;
import entyty.OffHand;
import entyty.WeaponClass;
import utils.Helper;

import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    private int distance;
    private boolean showMustGoOn = true;

    public void run() {
        HeroManager hero1 = new HeroManager(
                "ДевочкаВолшебница", Fraction.CHAOS, WeaponClass.LONGBOW, OffHand.NOTHING);
        HeroManager hero2 = new HeroManager(
                "Ультрамарин", Fraction.IMPERIUM, WeaponClass.HEAVY, OffHand.SHIELD);
        distance = Helper.getRandom(7, 10);
        ActionManager actionManager = new ActionManager(hero1, hero2, distance);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (showMustGoOn == true) {
                    showMustGoOn = actionManager.update();
                } else {
                    timer.cancel();
                }
            }
        }, 0, 1000);

    }
}
