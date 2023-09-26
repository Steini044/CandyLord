import java.util.ArrayList;

public class State {
    Location location;
    int hold;
    int holdMax;
    int cash;
    int cashInBank;
    int cashInDebt;
    int numberOfGuns;
    GunType guntype;
    int statusPoints;
    int health;
    ArrayList<Bean> beans;
    Date date;

    public State(Location location){
        this.location = location;
        hold = 10;
        holdMax = 10;
        cash = 500;
        cashInBank = 0;
        cashInDebt = 0;
        numberOfGuns = 0;
        guntype = GunType.NONE;
        statusPoints = 1;
        health = 100;
        date = new Date();
        beans = new ArrayList<Bean>();
        Bean cherry = new Bean("Cherry");
        Bean banana = new Bean("Banana");
        Bean tutti_frutti = new Bean("Tutti-Frutti");
        Bean cinnamon = new Bean("Cinnamon");
        Bean gras = new Bean("Gras");
        Bean earthworm = new Bean("Earthworm");
        Bean dirt = new Bean("Dirt");
        Bean vomit = new Bean("Vomit");
        beans.add(cherry);
        beans.add(banana);
        beans.add(tutti_frutti);
        beans.add(cinnamon);
        beans.add(gras);
        beans.add(earthworm);
        beans.add(dirt);
        beans.add(vomit);
    }


    public int getHold() {
        return hold;
    }

    public int getHoldMax() {
        return holdMax;
    }

    public int getCash() {
        return cash;
    }

    public int getCashInBank() {
        return cashInBank;
    }

    public int getCashInDebt() {
        return cashInDebt;
    }

    public int getNumberOfGuns() {
        return numberOfGuns;
    }

    public int getStatusPoints() {
        return statusPoints;
    }

    public int getHealth() {
        return health;
    }

    public Date getDate() {
        return date;
    }

    public GunType getGuntype() {
        return guntype;
    }
    public void addBean(int bean, int number){
        beans.get(bean).add(number);
    }
    public void subtractBean(int bean, int number){
        if (number < beans.get(bean).number){
            beans.get(bean).subtract(number);
        } else {
            //Exception
            return;
        }
    }
}
