package managers;

import entyty.Fraction;
import entyty.Mount;
import entyty.OffHand;
import entyty.weapons.WeaponType;
import utils.Helper;

import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    private int distance;
    private boolean showMustGoOn = true;

    public void run() {
        distance = Helper.getRandom(4, 5);
        HeroManager hero1 = new HeroManager(
                "Лучник", Fraction.CHAOS, WeaponType.LONGBOW, OffHand.NOTHING, Mount.LEGS);
        HeroManager hero2 = new HeroManager(
                "Лансер", Fraction.IMPERIUM, WeaponType.LANCE, OffHand.SHIELD, Mount.MOUNT);
        HeroManager hero3 = new HeroManager(
                "Рога", Fraction.IMPERIUM, WeaponType.LIGHT, OffHand.SHIELD, Mount.LEGS);
        HeroManager hero4 = new HeroManager(
                "Ультрамарин", Fraction.IMPERIUM, WeaponType.HEAVY, OffHand.SHIELD, Mount.LEGS);
        Tournament tournament = new Tournament();
        tournament.create(distance,hero1,hero2,hero3,hero4);

//        ActionManager actionManager = new ActionManager(hero1, hero2, distance);


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (showMustGoOn == true) {
//                    showMustGoOn = actionManager.update();
                    tournament.fight();
                    showMustGoOn = tournament.isShowMustGoOn();
                } else {
                    timer.cancel();
                }
            }
        }, 0, 1000);

    }
}
