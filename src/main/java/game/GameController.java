package game;

import inputHandler.*;
import items.Bean;
import screen.Screen;
import state.State;
import state.Location;

import java.util.Scanner;

public class GameController {

    private State state;
    private BuyHandler buyHandler;
    private SellHandler sellHandler;
    private void initGame() {
        //getRandomStartLocation()
        Location randomLocation = new Location("Hogwarts");
        state = new State(randomLocation);
        Bean cherry = new Bean("Cherry");
        Bean banana = new Bean("Banana");
        Bean tutti_frutti = new Bean("Tutti-Frutti");
        Bean cinnamon = new Bean("Cinnamon");
        Bean gras = new Bean("Gras");
        Bean earthworm = new Bean("Earthworm");
        Bean dirt = new Bean("Dirt");
        Bean vomit = new Bean("Vomit");
        state.addBeanToBeans(cherry);
        state.addBeanToBeans(banana);
        state.addBeanToBeans(tutti_frutti);
        state.addBeanToBeans(cinnamon);
        state.addBeanToBeans(gras);
        state.addBeanToBeans(earthworm);
        state.addBeanToBeans(dirt);
        state.addBeanToBeans(vomit);
        buyHandler = new BuyHandler(state);
        sellHandler = new SellHandler(state);
    }

    public void startGame() {
        initGame();
        boolean done = false;
        Scanner input = new Scanner(System.in);
        String cmd;
        Screen screen = new Screen(state);

        do{
            state.updatePrices();
            screen.printMainscreen();
            screen.printMainDialogue();
            cmd = input.next();
            if(cmd.equalsIgnoreCase("b")){
                buyHandler.handleBuy();
            } else if(cmd.equalsIgnoreCase("s")){
                sellHandler.handleSell();
            } else if (cmd.equalsIgnoreCase("q")){
                done = true;
            }
        }while(!done);
        //DO WHILE (!Done)
    }
}
