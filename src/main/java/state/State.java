package state;

import inputHandler.GameEventHandler;
import items.Bean;
import items.Wand;
import screens.Screen;

import java.util.ArrayList;

public class State {
    private Location currentLocation;
    private final GameEventHandler eventHandler;
    private int hold;
    private int holdMax;
    private int cash;
    private int cashInBank;
    private int cashInDebt;
    private Wand wand;
    private int statusPoints;
    private int health;
    private int maxHealth;
    private int debtCounter;
    boolean debt;
    private final ArrayList<Bean> beans;
    private final Date date;

    public State(Location currentLocation) {
        this.currentLocation = currentLocation;
        hold = 10;
        holdMax = 10;
        cash = 5000;
        cashInBank = 0;
        cashInDebt = 0;
        statusPoints = 6;
        health = 100;
        maxHealth = 100;
        debtCounter = 0;
        debt = false;
        wand = new Wand("None", 0, 5, 0);
        date = new Date(31, 7, 1980);
        beans = new ArrayList<Bean>();
        eventHandler = new GameEventHandler(this, new Screen(this));
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getLocationName() {
        return currentLocation.getName();
    }

    public void setCurrentLocation(Location newLocation) {
        this.currentLocation = newLocation;
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

    public int getNumberOfWands() {
        return this.wand.getNumberOfWands();
    }

    public void setWand(Wand wand) {
        this.wand = wand;
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

    public boolean getDebt() {
        return debt;
    }

    public void setDebt(boolean debt) {
        this.debt = debt;
    }

    public int getDebtCounter() {
        return debtCounter;
    }

    public void setHoldMax(int newHoldMax) {
        if(newHoldMax >= 0 && newHoldMax > holdMax){
            hold += newHoldMax - holdMax;
            this.holdMax = newHoldMax;
        } else {
            throw new IllegalArgumentException("argument number: " + newHoldMax + " was negative or smaller than old HoldMax");
        }
    }

    public void updatePrices() {
        currentLocation.updatePrices();
    }
    public void reduceOnePrice(int numberOfBean, double factor){
        if(factor > 0 && numberOfBean > 0){
            currentLocation.reduceOnePrice(numberOfBean, factor);
        } else {
            throw new IllegalArgumentException("argument: " + numberOfBean + " or " + factor + " was negative");
        }
    }
    public void increaseOnePrice(int numberOfBean, double factor){
        if(factor > 0 && numberOfBean > 0){
            currentLocation.increaseOnePrice(numberOfBean, factor);
        } else {
            throw new IllegalArgumentException("argument: " + numberOfBean + " or " + factor + " was negative");
        }
    }

    public int getPriceOf(int number) {
        return currentLocation.getPriceOf(number);
    }

    public int getBean(int number) {
        return beans.get(number).getNumber();
    }
    public String getBeanName(int number) {return beans.get(number).getName();}
    public int getBeansSize(){return beans.size();}

    public void addBean(int bean, int number) {
        if (hold >= number && number >= 0) {
            beans.get(bean).add(number);
            hold -= number;
        } else {
            throw new IllegalArgumentException("argument number: " + number + " was negative or bigger than hold");
        }
    }

    public void subtractBean(int bean, int number) {
        if (number <= beans.get(bean).getNumber()) {
            beans.get(bean).subtract(number);
            hold += number;
        } else {
            throw new IllegalArgumentException("argument: " + number + " was bigger than the amount of beans");
        }
    }

    public void addDeposit(int number) {
        if (number >= 0) {
            cashInBank += number;
        } else {
            throw new IllegalArgumentException("argument: " + number + " was negative");
        }
    }

    public void withdrawDeposit(int number) {
        if (number <= cashInBank && number >= 0) {
            cashInBank -= number;
        } else {
            throw new IllegalArgumentException("argument: " + number + " was negative or bigger than cash in Bank");
        }
    }

    public void addCash(int number) {
        if (number >= 0) {
            cash += number;
        } else {
            throw new IllegalArgumentException("argument: " + number + " was negative");
        }
    }

    public void subtractCash(int number) {
        if (number <= cash && number >= 0) {
            cash -= number;
        } else {
            throw new IllegalArgumentException("argument: " + number + " was negative or bigger that cash");
        }
    }

    public void addBeanToBeans(Bean bean) {
        beans.add(bean);
    }

    public void addCashInDebt(int number) {
        if (number > 0) {
            cashInDebt = cashInDebt + number;
        } else {
            throw new IllegalArgumentException("argument: " + number + " was negative");
        }
    }

    public void subtractCashInDebt(int number) {
        if (number > 0 && number <= cashInDebt) {
            cashInDebt -= number;
        } else {
            throw new IllegalArgumentException("argument: " + number + " was negative or bigger than cash in debt");
        }
    }

    public void subtractHealth(int damage) {
        if(damage >= health){
            health = 0;
        } else if (damage > 0) {
            health -= damage;
        }
    }

    //Debtcounter nur auf neuen wert setzen, falls der neue Wert niedriger ist als der aktuelle oder noch gar kein Debtcounter gesetzt wurde
    public void setDebtCounter(int countdownStart) {
        if (debtCounter > countdownStart || (debtCounter == 0 && !debt)) {
            debtCounter = countdownStart;
            debt = true;
        }
    }

    public void nextDay() {
        date.nextDay();
        if (debt) {
            cashInDebt += (int) (cashInDebt * 0.05);
            debtCounter--;
            if (debtCounter < 0) {
                eventHandler.startDebtEvent();
                debtCounter = 5;
            }
        }
        if (Math.random() < 0.33){
            eventHandler.startRandomEvent();
        }
    }

    public void fullHealth() {
        health = 100;
    }

    public void addStatusPoints(int newStatusPoints) {
        if(statusPoints < newStatusPoints) {
            statusPoints = newStatusPoints;
        }
    }

    public String getWandName() {
        return wand.getName();
    }
    public int getWandDamage(){
        return wand.getDamage();
    }
    public void subtractNumberOfWands(int number) {
        if(number > 0 && number <= getNumberOfWands()){
            wand.subtractNumberOfWands(number);
        } else {
            throw new IllegalArgumentException("argument: " + number + " was negative or bigger than the number of Wands");
        }
    }

    public void subtractStatusPoints(int number) {
        if(number > 0 && number <= statusPoints){
            statusPoints -= number;
        } else {
            throw new IllegalArgumentException("argument: " + number + " was negative or bigger than the number of Status Points");
        }
    }
}
