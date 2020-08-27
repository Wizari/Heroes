package managers;


import entyty.*;

import java.util.Timer;
import java.util.TimerTask;

public class GameManager {

    private Hero hero1;
    private Hero hero2;
    private Arena arena = new Arena(10);
    private Hero currentHero;

    private final IMoveManager moveManager;
    private final IFightManager fightManager;

    public GameManager() {
        IWeapon longSword = new LongSword();
        IWeapon shortSword = new ShortSword();
        IWeapon bow = new Bow();

        this.hero1 = new WHero("Арагорн", 2, Position.LEFT, bow);
        this.hero2 = new WHero("Баромир", 4, Position.RIGHT, shortSword);
        this.hero1.setX(0);
        this.hero2.setX(arena.getSize());
        moveManager = new MoveManager();
        fightManager = new FightManager(hero1, hero2);
    }

    public void run() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Hero currentHero = getCurrentHero();
                final Hero defHero = currentHero.equals(hero1) ? hero2 : hero1;
                moveManager.move(currentHero, defHero);

                boolean result = fightManager.fight(currentHero);
                if (result){
                    if (defHero.getHealth() <= 0) {
                        timer.cancel();
                        System.out.println("Герой " + currentHero.getName() +  " победил");
                    }
                }
            }
        }, 0, 1000);
    }

    public Hero getCurrentHero() {
        this.currentHero = (this.currentHero != null && this.currentHero.equals(hero1)) ? hero2 : hero1;
        return this.currentHero;
    }

}
