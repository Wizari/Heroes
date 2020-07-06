package entyty;

import entyty.weapons.WeaponType;

public class Hero {
    private String name;
    private Fraction fraction;
    private double hp;
    private WeaponType weaponType;
    private OffHand offHand;
    private Mount mount;

    public Hero(String name, Fraction fraction, double hp, WeaponType weaponType, OffHand offHand, Mount mount) {
        this.name = name;
        this.fraction = fraction;
        this.hp = hp;
        this.weaponType = weaponType;
        this.offHand = offHand;
        this.mount = mount;
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

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public OffHand getOffHand() {
        return offHand;
    }

    public void setOffHand(OffHand offHand) {
        this.offHand = offHand;
    }

    public Mount getMount() {
        return mount;
    }

    public void setMount(Mount mount) {
        this.mount = mount;
    }
}
