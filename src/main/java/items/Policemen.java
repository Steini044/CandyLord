package items;

public class Policemen extends Fighter{
    public Policemen(Wand wand, int health) {
        super(wand, health);
    }
    public Policemen(int health) {
        super(randomPoliceWand(), health);
    }

    private static Wand randomPoliceWand() {
        double random = Math.random();
        if(random < 0.1){
            return new Wand("Police Wand", 1, 50, 0);
        } else if (random < 0.5) {
            return new Wand("Police Wand", 1, 30, 0);
        } else {
            return new Wand("Police Wand", 1, 20, 0);
        }
    }

}
