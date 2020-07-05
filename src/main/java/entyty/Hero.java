package entyty;

public class Hero {
    private String name;
    private Fraction fraction;
    private double hp;
    private WeaponClass weaponClass;
    private OffHand offHand;

    public Hero(String name, Fraction fraction, double hp, WeaponClass weaponClass, OffHand offHand) {
        this.name = name;
        this.fraction = fraction;
        this.hp = hp;
        this.weaponClass = weaponClass;
        this.offHand = offHand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public WeaponClass getWeaponClass() {
        return weaponClass;
    }

    public void setWeaponClass(WeaponClass weaponClass) {
        this.weaponClass = weaponClass;
    }

    public OffHand getOffHand() {
        return offHand;
    }

    public void setOffHand(OffHand offHand) {
        this.offHand = offHand;
    }
}
