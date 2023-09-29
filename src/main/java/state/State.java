package state;

import items.Bean;
import items.Wand;

import java.util.ArrayList;

public class State {
    private Location location;
    private int hold;
    private int holdMax;
    private int cash;
    private int cashInBank;
    private int cashInDebt;
    private Wand wand = new Wand("None",0,0);
    private int statusPoints;
    private int health;
    private ArrayList<Bean> beans;
    private Date date;

    public State(Location location){
        this.location = location;
        hold = 10;
        holdMax = 10;
        cash = 500;
        cashInBank = 0;
        cashInDebt = 0;
        statusPoints = 1;
        health = 100;
        date = new Date();
        beans = new ArrayList<Bean>();
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

    public int getNumberOfWands(){
        return this.wand.getNumberOfGuns();
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

    public void updatePrices(){
        location.updatePrices();
    }
    public int getPriceOf(int number){
        return location.getPriceOf(number);
    }
    public int getBean(int number){
        return beans.get(number).getNumber();
    }
    public void addBean(int bean, int number){
        if(hold - number >= 0) {
            beans.get(bean).add(number);
            hold -= number;
        }
    }
    public void subtractBean(int bean, int number){
        if (number <= beans.get(bean).getNumber()){
            beans.get(bean).subtract(number);
            hold += number;
        } else {
            //Exception
            return;
        }
    }

    public void addDeposit(int number) {
        cashInBank += number;
        subtractCash(number);
    }

    public void addCash(int number){
        cash += number;
    }
    public void subtractCash(int number) {
        if(number <= cash){
            cash -= number;
        }
    }
    public void addBeanToBeans(Bean bean){
        beans.add(bean);
    }
}
