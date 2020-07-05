package managers;

import entyty.Fraction;
import entyty.Hero;
import entyty.WeaponClass;
import utils.Helper;

public class HeroManager {
    private Hero hero;
    private double weaponDamage;


    public HeroManager(String name, Fraction fraction, WeaponClass weaponClass) {
        double hp = Helper.getRandom(2, 5);
//        this.weaponClass = weaponClass;
        if (weaponClass == WeaponClass.HEAVY) {
            weaponDamage = 1;
        } else {
            weaponDamage = 1 * 0.60;
        }
        hero = new Hero(name, fraction, hp, weaponClass);

    }

    public void move(int distance) {
        System.out.println(hero.getName() + ": Делаю шаг преред, дистанция до противника " + distance + "м.");
    }

    public void hit(HeroManager heroManager) {
        if (hero.getWeaponClass() == WeaponClass.HEAVY) {
            System.out.println(hero.getName() + ": Наношу " + weaponDamage + " урона.");
            double hp = heroManager.hero.getHp() - weaponDamage;
            heroManager.hero.setHp(hp);
            System.out.println(heroManager.hero.getName() + " осталось: " + heroManager.hero.getHp() + " HP");
        } else {
            for (int i = 0; i < 2; i++) {
                System.out.println(hero.getName() + ": Наношу " + weaponDamage + " урона.");
                double hp = heroManager.hero.getHp() - weaponDamage;
                heroManager.hero.setHp(hp);
                System.out.println(heroManager.hero.getName() + " осталось: " + heroManager.hero.getHp() + " HP");
            }
        }
    }

    public void winMessage() {
        System.out.println("Герой - " + hero.getName() + " Побеждает");
    }


    public double getHp() {
        return hero.getHp();
    }

}
