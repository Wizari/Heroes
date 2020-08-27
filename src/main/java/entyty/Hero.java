package entyty;

public class Hero implements IHero {

    private final String name;
    private Integer health;
    private Integer x;
    private final Position position;

    public Hero(String name, Integer health, Position position) {
        this.name = name;
        this.health = health;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getRange() {
        return 1;
    }

    public int getSpeed() {
        return 1;
    }

    @Override
    public int getAttack() {
        return 1;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Position getPosition() {
        return position;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
