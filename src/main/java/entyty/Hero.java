package entyty;

public class Hero {
    String name;
    Fraction fraction;
    int hp;

    public Hero(String name, Fraction fraction, int hp) {
        this.name = name;
        this.fraction = fraction;
        this.hp = hp;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
