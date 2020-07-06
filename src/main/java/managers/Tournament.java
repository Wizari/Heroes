package managers;

import java.util.ArrayList;

public class Tournament {
    ArrayList<HeroManager> array = new ArrayList<HeroManager>();
    private int distance;
    private ActionManager actionManager1;
    private ActionManager actionManager2;
    private ActionManager actionManager3;
    private boolean fight1 = true;
    private boolean fight2 = false;
    private boolean fight3 = false;
    private  boolean showMustGoOn = true;
    private HeroManager heroWinnerBracket1;
    private HeroManager heroWinnerBracket2;


    public void create(int distance, HeroManager heroManager1, HeroManager heroManager2, HeroManager heroManager3, HeroManager heroManager4) {
        this.distance = distance;
        array.add(heroManager1);
        array.add(heroManager2);
        array.add(heroManager3);
        array.add(heroManager4);
        actionManager1 = new ActionManager(array.get(0), array.get(1), distance);
        actionManager2 = new ActionManager(array.get(2), array.get(3), distance);

    }

    public void fight() {
        if (fight1) {
            fight1 = actionManager1.update();
            if (!fight1) {
                this.heroWinnerBracket1 = actionManager1.getWinner();
                this.heroWinnerBracket1.refresh();
                fight2 = true;
            }
        }
        if (fight2) {
            fight2 = actionManager2.update();
            if (!fight2) {
                this.heroWinnerBracket2 = actionManager2.getWinner();
                this.heroWinnerBracket2.refresh();
                actionManager3 = new ActionManager(heroWinnerBracket1, heroWinnerBracket2, distance);
                fight3 = true;
            }
        }
        if (fight3) {
            fight3 = actionManager3.update();
            if (!fight3) {
                showMustGoOn = false;
            }
        }

    }

    public boolean isShowMustGoOn() {
        return showMustGoOn;
    }
}
