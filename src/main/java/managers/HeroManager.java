package managers;

import entyty.Fraction;
import entyty.Hero;
import utils.Helper;

public class HeroManager {
    Hero hero;



    public HeroManager(String name, Fraction fraction) {
        int hp = Helper.getRandom(2, 5);
        hero = new Hero(name, fraction, hp);
    }

    public void move(int distance) {
        System.out.println(hero.getName() + ": Делаю шаг преред, дистанция до противника " + distance + "м.");
    }

    public void hit() {
        System.out.println(hero.getName() + ": Ударяю противника");
    }

    public void winMessage() {
        System.out.println("Герой - " + hero.getName() + " Побеждает");
    }

    public void takeDamage(int damage) {
        int hp = hero.getHp() - damage;
        hero.setHp(hp);
        System.out.println(hero.getName()+" осталось: " + hero.getHp()+" HP");
    }

    public int getHp() {
        return hero.getHp();
    }

}
