package managers;

import entyty.Hero;
import entyty.Position;

public class MoveManager implements IMoveManager {
    @Override
    public void move(Hero attackHero, Hero defHero) {
        final int distance = Math.abs( attackHero.getX() - defHero.getX());
        if (distance > attackHero.getRange()){
            int step = attackHero.getSpeed() * (attackHero.getPosition().equals(Position.LEFT) ? 1 : -1);
            attackHero.setX(attackHero.getX() + step);
            System.out.println("Герой " + attackHero.getName() + " пермещается в позицию " + attackHero.getX());
        } else {
            System.out.println("Герой " + attackHero.getName() + " может атаковать, поэтому он остается в позиции " + attackHero.getX());
        }

    }
}
