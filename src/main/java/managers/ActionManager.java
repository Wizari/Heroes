package managers;

public class ActionManager {
    private HeroManager hero1;
    private HeroManager hero2;
    private HeroManager temp;
    private HeroManager activeHero;
    private int distance;
    private boolean showMustGoOn = true;

    public ActionManager(HeroManager hero1, HeroManager hero2, int distance) {
        this.hero1 = hero1;
        this.hero2 = hero2;
        this.distance = distance;
    }

    public boolean update() {
        activeHero = getAnotherHero(hero1, hero2);
        distance = activeHero.move(distance);
        showMustGoOn = activeHero.hit(getAntagonist(hero1, hero2), distance);

        return showMustGoOn;
    }

    private HeroManager getAnotherHero(HeroManager hero1, HeroManager hero2) {
        if (hero1 != temp) {
            temp = hero1;
            return hero1;
        } else {
            temp = hero2;
            return hero2;
        }
    }

    private HeroManager getAntagonist(HeroManager hero1, HeroManager hero2) {
        if (hero1 != temp) {
            return hero1;
        } else {
            return hero2;
        }
    }
}

