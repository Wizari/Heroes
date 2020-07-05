package managers;

import entyty.Fraction;
import entyty.Hero;
import entyty.OffHand;
import entyty.WeaponClass;
import utils.Helper;

import java.util.concurrent.ThreadLocalRandom;

public class HeroManager {
    private Hero hero;
    private double weaponDamage;
    private double hp;


    public HeroManager(String name, Fraction fraction, WeaponClass weaponClass, OffHand offHand) {
        double hp = Helper.getRandom(10, 15);
        if (weaponClass == WeaponClass.HEAVY) {
            weaponDamage = 1;
        }
        if (weaponClass == WeaponClass.LONGBOW) {
            weaponDamage = 1;
        }
        if (weaponClass == WeaponClass.LIGHT) {
            weaponDamage = 1 * 0.60;
        }
        hero = new Hero(name, fraction, hp, weaponClass, offHand);

    }

    public int move(int distance) {
        if (distance >= 0) {
            if (hero.getWeaponClass() != WeaponClass.LONGBOW) {
                System.out.println(hero.getName() + ": Делаю шаг вперед, дистанция до противника " + distance + "м.");
                distance--;
                return distance;
            }
        }
        return distance;
    }

    public boolean hit(HeroManager heroManager, int distance) {
        switch (hero.getWeaponClass()) {
            case HEAVY:
                if (distance <= 0) {
                    System.out.println(hero.getName() + ": Наношу " + weaponDamage + " урона.");
                    hp = heroManager.hero.getHp() - weaponDamage;
                    heroManager.hero.setHp(hp);
                    System.out.println(heroManager.hero.getName() + " осталось: " + heroManager.hero.getHp() + " HP");
                    if (heroManager.getHp() <= 0) {
                        winMessage();
                        return false;
                    }
                }
                break;
            case LIGHT:
                if (distance <= 0) {
                    for (int i = 0; i < 2; i++) {
                        System.out.println(hero.getName() + ": Наношу " + weaponDamage + " урона.");
                        hp = heroManager.hero.getHp() - weaponDamage;
                        heroManager.hero.setHp(hp);
                        System.out.println(heroManager.hero.getName() + " осталось: " + heroManager.hero.getHp() + " HP");
                        if (heroManager.getHp() <= 0) {
                            winMessage();
                            return false;
                        }
                    }
                }
                break;
            case LONGBOW:
                if (distance >= 3) {
                    double damage = damageСalculation(weaponDamage, heroManager);
                    damage = Helper.round(damage, 2);
                    hp = heroManager.hero.getHp() - damage;
                    hp = Helper.round(hp, 2);
                    System.out.println(hero.getName() + ": Наношу " + damage + " урона.");
                    heroManager.hero.setHp(hp);
                    System.out.println(heroManager.hero.getName() + " осталось: " + heroManager.hero.getHp() + " HP");
                    if (heroManager.getHp() <= 0) {
                        winMessage();
                        return false;
                    }
                } else {
                    System.out.println(hero.getName() + " - Т_Т я не могу стрелять!");
                }
                break;
        }
        return true;
    }

    public void winMessage() {
        System.out.println("Герой - " + hero.getName() + " Побеждает");
    }


    public double getHp() {
        return hero.getHp();
    }

    public double damageСalculation (double weaponDamage, HeroManager heroManager) {
        if (heroManager.hero.getOffHand() == OffHand.SHIELD) {
            double diminution = ThreadLocalRandom.current().nextDouble(0, 1);
//            System.out.println(diminution);
            return weaponDamage * diminution;
        } else {
            return weaponDamage;
        }
    }

}
