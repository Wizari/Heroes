package entyty.weapons;

import entyty.Hero;
import managers.HeroManager;
import utils.Helper;

public class WeaponLightSaber extends WeaponHeavySwordImpl {
    private double weaponDamage;
    private double hp;

    public WeaponLightSaber() {
        this.weaponDamage = 1 * 0.6;
    }

    @Override
    public boolean hit(Hero hero, HeroManager antagonistHero, double distance) {
        if (distance <= 0) {
            for (int i = 0; i < 2; i++) {
                System.out.println(hero.getName() + ": Наношу [" + weaponDamage + "] урона.");
                hp = antagonistHero.getHero().getHp() - weaponDamage;
                hp = Helper.round(hp, 2);
                antagonistHero.getHero().setHp(hp);
                System.out.println(antagonistHero.getHero().getName() + " осталось: " + antagonistHero.getHero().getHp() + " HP");
                if (antagonistHero.getHp() <= 0) {
                    winMessage(hero);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void winMessage(Hero hero) {
        super.winMessage(hero);
    }

    @Override
    public double damageCalculation(double weaponDamage, HeroManager antagonistHero) {
        return super.damageCalculation(weaponDamage, antagonistHero);
    }

    @Override
    public double getWeaponDamage() {
        return super.getWeaponDamage();
    }
}
