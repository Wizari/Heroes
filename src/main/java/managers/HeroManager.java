package managers;

import entyty.Fraction;
import entyty.Hero;
import entyty.Mount;
import entyty.OffHand;
import entyty.weapons.*;
import utils.Helper;

public class HeroManager {
    private Hero hero;
    private double weaponDamage;
    private double hp;
    IWeapon weapon;

    public HeroManager(String name, Fraction fraction, WeaponType weaponType, OffHand offHand, Mount mount) {
        double hp = Helper.getRandom(5, 6);
        if (weaponType == WeaponType.HEAVY) {
            weapon = new WeaponHeavySwordImpl();
        }
        if (weaponType == WeaponType.LONGBOW) {
            weapon = new WeaponLongbow();
        }
        if (weaponType == WeaponType.LIGHT) {
            weapon = new WeaponLightSaber();
        }
        if (weaponType == WeaponType.LANCE) {
            weapon = new WeaponLance();
        }
        hero = new Hero(name, fraction, hp, weaponType, offHand, mount);

    }

    public int move(int distance) {
        if (distance >= 0) {
            if (hero.getWeaponType() != WeaponType.LONGBOW) {
                System.out.println(hero.getName() + ": Сокращаю дистанцию" + distance + "м.");
                distance--;
                return distance;
            }
            if (hero.getWeaponType() != WeaponType.LANCE) {
                System.out.println(hero.getName() + ": Сокращаю дистанцию. До цели >" + distance + "м.<");
                distance--;
                distance--;
                return distance;
            }
        }
        return distance;
    }

    public boolean hit(HeroManager antagonistHero, int distance) {
        return weapon.hit(hero, antagonistHero, distance);
    }

    public void refresh() {
        hero.setHp(Helper.getRandom(5, 6));
    }

    public double getHp() {
        return hero.getHp();
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
