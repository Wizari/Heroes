package entyty.weapons;

import entyty.Hero;
import managers.HeroManager;
import utils.Helper;

public class WeaponLongbow extends WeaponHeavySwordImpl {
    private double weaponDamage;
    private double hp;

    public WeaponLongbow() {
        this.weaponDamage = 1;
    }

    @Override
    public boolean hit(Hero hero, HeroManager antagonistHero, double distance) {
        if (distance >= 3) {
            double damage = damageCalculation(weaponDamage, antagonistHero);
            damage = Helper.round(damage, 2);
            hp = antagonistHero.getHero().getHp() - damage; //TODO какого фига если от 10 отнять 0.11 может выдать ~9.899999
            hp = Helper.round(hp, 2); //TODO если не использовать вторую подрезкк
            System.out.println(hero.getName() + ": Наношу [" + damage + "] урона.");
            antagonistHero.getHero().setHp(hp);
            System.out.println(antagonistHero.getHero().getName() + " осталось: " + antagonistHero.getHero().getHp() + " HP");
            if (antagonistHero.getHp() <= 0) {
                winMessage(hero);
                return false;
            }
        } else {
            System.out.println(hero.getName() + " - Т_Т я не могу стрелять!");
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
