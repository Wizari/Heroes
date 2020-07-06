package entyty.weapons;

import entyty.Hero;
import managers.HeroManager;

public interface IWeapon {

//    double createWeapon(WeaponType weaponType);

    boolean hit(Hero hero, HeroManager antagonistHero, double distance);

    abstract void winMessage(Hero hero);

    abstract double damageCalculation(double weaponDamage, HeroManager antagonistHero);

    double getWeaponDamage();
}
