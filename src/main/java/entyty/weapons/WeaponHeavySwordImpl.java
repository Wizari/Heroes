package entyty.weapons;

import entyty.Hero;
import entyty.OffHand;
import managers.HeroManager;

import java.util.concurrent.ThreadLocalRandom;

public class WeaponHeavySwordImpl implements IWeapon {
    private double weaponDamage;
    private double hp;

    public WeaponHeavySwordImpl() {
        this.weaponDamage = 1;
    }

//    @Override
//    public double createWeapon(WeaponType weaponType) {
//        this.weaponDamage = 1;
//        return weaponDamage;
//    }

    @Override
    public boolean hit(Hero hero, HeroManager antagonistHero, double distance) {
        if (distance <= 0) {
            System.out.println(hero.getName() + ": Наношу [" + weaponDamage + "] урона.");
            hp = antagonistHero.getHero().getHp() - weaponDamage;
            antagonistHero.getHero().setHp(hp);
            System.out.println(antagonistHero.getHero().getName() + " осталось: " + antagonistHero.getHero().getHp() + " HP");
            if (antagonistHero.getHp() <= 0) {
                winMessage(hero);
                return false;
            }
        }
        return true;
    }

    @Override
    public void winMessage(Hero hero) {
        System.out.println("Герой - " + hero.getName() + " Побеждает!!");
    }

    @Override
    public double damageCalculation(double weaponDamage, HeroManager antagonistHero) {
        if (antagonistHero.getHero().getOffHand() == OffHand.SHIELD) {
            double diminution = ThreadLocalRandom.current().nextDouble(0, 1);
//            System.out.println(diminution);
            return weaponDamage * diminution;
        } else {
            return weaponDamage;
        }
    }

    @Override
    public double getWeaponDamage() {
        return weaponDamage;
    }

}
