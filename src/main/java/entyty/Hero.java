package entyty;

public class Hero {
    String name;
    int distance;

    public Hero(String name) {
        this.name = name;
    }

    public void move(int distance) {
        System.out.println(name+ ": Делаю шаг преред, дистанция до противника "+ distance + "м.");
        if (distance == 1) {
            System.out.println(name+ ": Ударяю противника");
            System.out.println("Герой - "+ name+ " Побеждает");
        }
    }

}
