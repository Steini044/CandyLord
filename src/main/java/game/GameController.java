package game;

import inputHandler.*;
import items.Bean;
import screens.Screen;
import state.State;
import state.Location;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

    private State state;
    private Screen screen;
    private BuyHandler buyHandler;
    private SellHandler sellHandler;
    private JetHandler jetHandler;
    private BankHandler bankHandler;
    private HospitalHandler hospitalHandler;
    private LoanSharkHandler loanSharkHandler;

    private void initGame() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Hogwarts"));
        locations.add(new Location("Ollivanders"));
        locations.add(new Location("Hogsmaede Village"));
        locations.add(new Location("Azkaban"));
        locations.add(new Location("Ministry of Magic"));
        locations.add( new Location("Malfoy Manor"));
        locations.add(new Location("Little Hangleton"));
        locations.add(new Location("Godrics Hollow"));

        state = new State(getRandomLocation(locations));
        state.addBeanToBeans(new Bean("Cherry"));
        state.addBeanToBeans(new Bean("Banana"));
        state.addBeanToBeans(new Bean("Tutti-Frutti"));
        state.addBeanToBeans(new Bean("Cinnamon"));
        state.addBeanToBeans(new Bean("Gras"));
        state.addBeanToBeans(new Bean("Earthworm"));
        state.addBeanToBeans(new Bean("Dirt"));
        state.addBeanToBeans(new Bean("Vomit"));

        screen = new Screen(state);
        buyHandler = new BuyHandler(state, screen);
        sellHandler = new SellHandler(state, screen);
        jetHandler = new JetHandler(state, locations, screen);
        bankHandler = new BankHandler(state, screen);
        hospitalHandler = new HospitalHandler(state, screen);
        loanSharkHandler = new LoanSharkHandler(state, screen);
    }

    public void startGame() {
        initGame();
        boolean done = false;
        Scanner input = new Scanner(System.in);
        String cmd;

        do{
            screen.printMainscreen();
            screen.printMainDialogue();
            cmd = input.next();
            if(cmd.equalsIgnoreCase("b")){
                buyHandler.handleBuy();
            } else if(cmd.equalsIgnoreCase("s")) {
                sellHandler.handleSell();
            } else if (cmd.equalsIgnoreCase("j")) {
                jetHandler.handleJet();
            } else if (cmd.equalsIgnoreCase("v")) {
                bankHandler.handleBank();
            } else if(cmd.equalsIgnoreCase("h")) {
                hospitalHandler.handleHospital();
            } else if(cmd.equalsIgnoreCase("l")) {
                loanSharkHandler.handleLoanShark();
            } else if(cmd.equalsIgnoreCase("r")){
                state.nextDay();
            } else if (cmd.equalsIgnoreCase("q")){
                done = true;
            }
            if(state.getHealth() == 0){
                screen.printDeath();
                done = true;
            }
        }while(!done);
    }
    private Location getRandomLocation(ArrayList<Location> locations){
        int randomIndex = (int) (Math.random() * locations.size());
        return locations.get(randomIndex);
    }
}
