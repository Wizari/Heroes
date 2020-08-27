package entyty;

public class WHero extends Hero {

    private final IWeapon weapon;

    public WHero(String name, Integer health, Position position, IWeapon weapon) {
        super(name, health, position);
        this.weapon = weapon;
    }

    @Override
    public int getRange() {
        return weapon.getRange();
    }

    @Override
    public int getAttack() {
        return weapon.getAttack();
    }
}
