package managers;

import entyty.Hero;

public class FightManager implements IFightManager{

    private final Hero hero1;
    private final Hero hero2;

    public FightManager(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }


    @Override
    public boolean fight(Hero attackHero) {
        final Hero defHero = attackHero.equals(this.hero1) ? hero2 : hero1;
        final int distance = Math.abs( attackHero.getX() - defHero.getX());

        if (distance > attackHero.getRange()) {
            System.out.println("Герой " + attackHero.getName() + " находится слишком далеко и не может атаковать");
            return false;
        }
        defHero.setHealth(defHero.getHealth() - attackHero.getAttack());
        System.out.println("Герой " + attackHero.getName() + " наносить " + attackHero.getAttack() + " урона герою " + defHero.getName() + ". У героя "
                + defHero.getName() + " оcталось " + defHero.getHealth() + " здоровья");
        return true;
    }
}
