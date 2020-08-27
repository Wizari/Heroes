package entyty;

public class Weapon implements IWeapon {

    protected final int attack;
    protected final int range;

    public Weapon(int attack, int range) {
        this.attack = attack;
        this.range = range;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public int getRange() {
        return this.range;
    }
}
