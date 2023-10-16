package events;

import items.Deatheater;
import items.Fighter;
import items.Policemen;
import items.Wand;
import screens.Screen;
import state.State;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FightEvent extends Event {

    public FightEvent(State state) {
        super(state);
    }

    @Override
    public void start() {
        Screen screen = new Screen(state);
        Scanner input = new Scanner(System.in);
        String cmd;
        boolean continueInput = true;

        int numberOfPolicemen = (int) (Math.random() * 3 + 1);
        ArrayList<Fighter> policemen = new ArrayList<>();
        for (int i = 0; i < numberOfPolicemen; i++) {
            policemen.add(new Policemen(100));
        }

        ArrayList<Fighter> companions = new ArrayList<>();

        screen.printFightEventStart();
        do {
            cmd = input.next();
            if(cmd.equalsIgnoreCase("y")){
                screen.printFightEventRecruiting();
                companions.addAll(recrute());
                continueInput = false;
            } else if (cmd.equalsIgnoreCase("n")) {
                continueInput = false;
            }
        }while(continueInput);

        continueInput = true;
        do{
            screen.printFightEventMainScreen();
            screen.printFightEventYourself(state.getHealth(),state.getWandDamage());
            for (int i = 0; i < companions.size(); i++) {
                screen.printFightEventCompanion(i + 1, companions.get(i).getHealth(),companions.get(i).getDamage());
            }
            for (int i = 0; i < policemen.size(); i++) {
                screen.printFightEventPolicemen(i + 1, policemen.get(i).getHealth(),policemen.get(i).getDamage());
            }

            screen.printFightEventOptions();
            cmd = input.next();
            if(cmd.equalsIgnoreCase("a")){
                screen.printFightEventAttackWho();
                do{
                    try{
                        int target = input.nextInt();
                        if(target > 0 && target <= policemen.size()){
                            attack(policemen.get(target - 1));
                            continueInput = false;
                        }
                    }catch(InputMismatchException ex){
                        input.nextLine();
                    }
                }while(continueInput);
                removeAllDead(policemen);
                continueInput = true;
            } else if(cmd.equalsIgnoreCase("f")){
                if(Math.random() < 0.4){
                    screen.printFightEventSuccessfulEscape();
                    return;
                }
            }

            if(!companions.isEmpty() && !policemen.isEmpty()) {
                for (Fighter companion : companions) {
                    if (companion.getHealth() > 0) {
                        companion.attack(getRandomEnemy(policemen));
                    }
                }
                removeAllDead(policemen);
            }

            if(!policemen.isEmpty()) {
                for (Fighter policeman : policemen) {
                    if(!companions.isEmpty()){
                        policeman.attack(getRandomEnemy(companions));
                        removeAllDead(companions);
                    } else {
                        int damage = (int) (Math.random() * policeman.getDamage() + 1);
                        state.subtractHealth(damage);
                        if (state.getHealth() <= 0){
                            return;
                        }
                    }
                }
            }

            if(policemen.isEmpty()){
                continueInput = false;
            }

        }while (continueInput);
    }

    private void removeAllDead(ArrayList<Fighter> fighters) {
        fighters.removeIf(fighter -> fighter.getHealth() == 0);
    }

    //nicht mit fighters = null aufrufen
    private Fighter getRandomEnemy(ArrayList<Fighter> fighters) {
        do {
            int randomIndex = (int) (Math.random() * fighters.size());
            if (fighters.get(randomIndex).getHealth() > 0) {
                return fighters.get(randomIndex);
            }
        } while (true);
    }

    private void attack(Fighter fighter) {
        fighter.takeDamage(state.getWandDamage());
    }

    private ArrayList<Deatheater> recrute() {
        Screen screen = new Screen(state);
        Scanner input = new Scanner(System.in);
        int numberOfRecruits;
        ArrayList<Deatheater> deatheaters = new ArrayList<>();
        boolean continueInput = true;

        do {
            try{
                numberOfRecruits = input.nextInt();
                if(numberOfRecruits > state.getStatusPoints()){
                    screen.printFightEventNotEnoughStatus();
                    continue;
                } else if(numberOfRecruits > 0){
                    state.subtractStatusPoints(numberOfRecruits);
                    for (int i = 0; i < numberOfRecruits; i++) {
                        if(state.getNumberOfWands() > 1){
                            Wand deatheaterWand = new Wand(state.getWandName(),1,state.getWandDamage(),0);
                            deatheaters.add(new Deatheater(deatheaterWand,100));
                            state.setNumberOfWands(state.getNumberOfWands() - 1);
                        } else {
                            Wand deatheaterWand = new Wand("Fist", 1, 5, 0);
                            deatheaters.add(new Deatheater(deatheaterWand, 100));
                        }
                    }
                    continueInput = false;
                } else {
                    continueInput = false;
                }
            }catch (InputMismatchException ex){
                input.nextLine();
            }
        }while(continueInput);

        return deatheaters;
    }
}
