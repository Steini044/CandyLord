package player;

import state.State;
import state.Location;

public class Player {
    State state;
    public Player(State state){
        this.state = state;
    }
    public void buyBeans(int bean, int number){
        state.addBean(bean, number);
    }
    public void sellBeans(int bean, int number){
        state.subtractBean(bean, number);
    }
    public void jet(Location location){

    }
    public void depositCash(int number){
        if(number <= state.getCash()){
            state.addDeposit(number);
        } else {
            //Exception
            return;
        }
    }
    public void withdrawalCash(){

    }
}
