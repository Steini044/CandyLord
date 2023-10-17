package screens;

import screens.eventscreens.*;
import state.Location;
import state.State;

import java.util.ArrayList;

public class Screen {
    private final State state;
    private final BuyScreen buyScreen;
    private final SellScreen sellScreen;
    private final JetScreen jetScreen;
    private final BankScreen bankScreen;
    private final HospitalScreen hospitalScreen;
    private final LoanSharkScreen loanSharkScreen;
    private final LowerPricesEventScreen lowerPricesEventScreen;
    private final HigherPricesEventScreen higherPricesEventScreen;
    private final DebtEventScreen debtEventScreen;
    private final RobbedEventScreen robbedEventScreen;
    private final LostAllGrasEventScreen lostAllGrasEventScreen;
    private final CoatEventScreen coatEventScreen;
    private final WandEventScreen wandEventScreen;
    private final FightEventScreen fightEventScreen;

    public Screen(State state) {
        this.state = state;
        this.buyScreen = new BuyScreen();
        this.sellScreen = new SellScreen();
        this.jetScreen = new JetScreen();
        this.bankScreen = new BankScreen();
        this.hospitalScreen = new HospitalScreen();
        this.loanSharkScreen = new LoanSharkScreen();
        this.lowerPricesEventScreen = new LowerPricesEventScreen();
        this.higherPricesEventScreen = new HigherPricesEventScreen();
        this.debtEventScreen = new DebtEventScreen();
        this.robbedEventScreen = new RobbedEventScreen();
        this.lostAllGrasEventScreen = new LostAllGrasEventScreen();
        this.coatEventScreen = new CoatEventScreen();
        this.wandEventScreen = new WandEventScreen();
        this.fightEventScreen = new FightEventScreen();
    }

    public void printMainscreen() {
        System.out.printf(
                """
                        ╔═════════════════════════════════════════════════════════════════════════════╗\s
                        ║                       * * * B E A N  L O R D * * *                          ║\s
                        ╠═══ Date: %12s ═══════════════════════╦══════════════════════════════╣\s
                        ║                                              ║   Location: %-17s║\s
                        ╠═══ Beans on Hand ═══╦════ Street Prices ═════╣   Hold: %2d  (%2d max)         ║\s
                        ║                     ║                        ║                              ║\s
                        ║   Cherry         %2d ║   Cherry        %5d  ║     Cash:  $%5d            ║\s
                        ║   Banana         %2d ║   Banana        %5d  ║  In Bank:  $%5d            ║\s
                        ║   Tutti-Frutti   %2d ║   Tutti-Frutti  %5d  ║  In Debt:  $%5d    %4s    ║\s
                        ║   Cinnamon       %2d ║   Cinnamon      %5d  ║                              ║\s
                        ║   Gras           %2d ║   Gras          %5d  ║  # of Wands: %2d              ║\s
                        ║   Earthworm      %2d ║   Earthworm     %5d  ║   Wand Name: %-10s      ║\s
                        ║   Dirt           %2d ║   Dirt          %5d  ║                              ║\s
                        ║   Vomit          %2d ║   Vomit         %5d  ║  Status Pts: %2d              ║\s
                        ║                     ║                        ║      Health: %3d             ║\s
                        ╚═════════════════════╩════════════════════════╩══════════════════════════════╝\s
                        """
                , state.getDate().toString(), state.getLocationName(), state.getHold(), state.getHoldMax(), state.getBean(0), state.getPriceOf(0), state.getCash(), state.getBean(1), state.getPriceOf(1),
                state.getCashInBank(), state.getBean(2), state.getPriceOf(2), state.getCashInDebt(), state.getDebt() ? "(" + state.getDebtCounter() + ")" : "    ", state.getBean(3), state.getPriceOf(3),
                state.getBean(4), state.getPriceOf(4), state.getNumberOfWands(), state.getBean(5), state.getPriceOf(5),
                state.getWandName() ,state.getBean(6), state.getPriceOf(6), state.getBean(7), state.getPriceOf(7), state.getStatusPoints(), state.getHealth());
    }

    public void printMainDialogue() {
        System.out.print(
                """
                                                                                        (Q)uit the game\s
                                          Here's a list of possible plans dude\s
                                     (B)uy Beans,                   (V)isit Gringotts,\s
                                     (S)ell Beans                   Go to the St. Mungo (H)ospital,\s
                                     (J)et to another location,     See the (L)oan Shark\s

                                                      Make up your mind ► \s
                        """);
    }

    public void printAreYouSureYouWannaQuit() {
        System.out.print(
                """
                                     Are you sure you wanna quit?\s
                                                   (Y/N) \s
                        """);
    }

    public void printBuyDialogueStart() {
        buyScreen.printBuyDialogueStart();
    }

    public void printBuyDialogueSecondQuestion(int pickedNumber, int maxAffordableBeans) {
        buyScreen.printBuyDialogueSecondQuestion(pickedNumber, maxAffordableBeans);
    }

    public void printBuyDialogueNotEnoughHold(int pickedNumber, int maxAffordableBeans) {
        buyScreen.printBuyDialogueNotEnoughHold(pickedNumber, maxAffordableBeans);
    }

    public void printBuyDialogueNotEnoughCash(int pickedNumber, int maxAffordableBeans) {
        buyScreen.printBuyDialogueNotEnoughCash(pickedNumber, maxAffordableBeans);
    }

    public void printSellDialogueStart() {
        sellScreen.printSellDialogueStart();
    }

    public void printSellDialogueZeroBeansHold(int pickedBeanNumber) {
        sellScreen.printSellDialogueZeroBeansHold(pickedBeanNumber);
    }

    public void printSellDialogueSecondQuestion(int pickedBeanNumber) {
        sellScreen.printSellDialogueSecondQuestion(pickedBeanNumber);
    }

    public void printSellDialogueNotEnoughBeansHold(int pickedBeanNumber) {
        sellScreen.printSellDialogueNotEnoughBeansHold(pickedBeanNumber);
    }

    public void printJetDialogueStart(ArrayList<Location> locations, int[] prices) {
        jetScreen.printJetDialogueStart(locations, prices);
    }

    public void printJetDialogueYourLocation(ArrayList<Location> locations, int[] prices) {
        jetScreen.printJetDialogueYourLocation(locations, prices);
    }

    public void printJetDialogueNotEnoughCash(ArrayList<Location> locations, int[] prices) {
        jetScreen.printJetDialogueNotEnoughCash(locations, prices);
    }

    public void printBankDialogueStart() {
        bankScreen.printBankDialogueStart();
    }

    public void printBankDialogueDeposit() {
        bankScreen.printBankDialogueDeposit();
    }

    public void printBankDialogueWithdraw() {
        bankScreen.printBankDialogueWithdraw();
    }

    public void printBankDialogueNotEnoughMoney() {
        bankScreen.printBankDialogueNotEnoughMoney();
    }

    public void printBankDialogueNotEnoughMoneyInBank() {
        bankScreen.printBankDialogueNotEnoughMoneyInBank();
    }

    public void printHospitalMaxHealth() {
        hospitalScreen.printHospitalMaxHealth();
    }

    public void printLoanSharkDialogueStart() {
        loanSharkScreen.printLoanSharkDialogueStart();
    }

    public void printLoanSharkDialogueBorrow() {
        loanSharkScreen.printLoanSharkDialogueBorrow();
    }

    public void printLoanSharkDialoguePayBack() {
        loanSharkScreen.printLoanSharkDialoguePayBack();
    }

    public void printLoanSharkDialogueTooMuchMoney() {
        loanSharkScreen.printLoanSharkDialogueTooMuchMoney();
    }

    public void printLoanSharkDialogueAlreadyInDebt(int cashInDebt) {
        loanSharkScreen.printLoanSharkDialogueAlreadyInDebt(cashInDebt);
    }

    public void printLoanSharkDialogueTooLessMoney() {
        loanSharkScreen.printLoanSharkDialogueTooLessMoney();
    }

    public void printLoanSharkDialogueNotInDebt() {
        loanSharkScreen.printLoanSharkDialogueNotInDebt();
    }

    public void printLoanSharkDialogueNotEnoughMoney() {
        loanSharkScreen.printLoanSharkDialogueNotEnoughMoney();
    }

    public void printLoanSharkDialogueCountdownStarted(int debtCounter) {
        loanSharkScreen.printLoanSharkDialogueCountdownStarted(debtCounter);
    }
    public void printLoanSharkDialogueStillDebtRemaining(int cashInDebt) {
        loanSharkScreen.printLoanSharkDialogueStillDebtRemaining(cashInDebt);
    }

    public void printLoanSharkDialoguePaidInFull() {
        loanSharkScreen.printLoanSharkDialoguePaidInFull();
    }
    public void printLowerPricesEvent(String beanName) {
        lowerPricesEventScreen.printLowerPricesEvent(beanName);
    }
    public void printLowerPricesEvent(String beanName, String beanName2) {
        lowerPricesEventScreen.printLowerPricesEvent(beanName, beanName2);
    }

    public void printLowerPricesEvent(String beanName, String beanName2, String beanName3) {
        lowerPricesEventScreen.printLowerPricesEvent(beanName, beanName2, beanName3);
    }
    public void printHigherPricesEvent(String beanName) {
        higherPricesEventScreen.printHigherPricesEvent(beanName);
    }
    public void printHigherPricesEvent(String beanName, String beanName2) {
        higherPricesEventScreen.printHigherPricesEvent(beanName, beanName2);
    }

    public void printHigherPricesEvent(String beanName, String beanName2, String beanName3) {
        higherPricesEventScreen.printHigherPricesEvent(beanName, beanName2, beanName3);
    }

    public void printDebtEvent() {
        debtEventScreen.printDebtEvent();
    }

    public void printDeath() {
        System.out.print(
                """
                        Im sorry, you ded!\s
                                                               """);
    }

    public void printHospitalCosts(int cost) {
        hospitalScreen.printHospitalCosts(cost);
    }


    public void printRobbedEvent() {
        robbedEventScreen.printRobbedEvent();
    }

    public void printLostAllGrasEvent() {
        lostAllGrasEventScreen.printLostAllGrasEvent();
    }

    public void printCoatEvent(int newHold, int price) {
        coatEventScreen.printCoatEvent(newHold, price);
    }

    public void printCoatEventSold() {
        coatEventScreen.printCoatEventSold();
    }

    public void printCoatEventNotEnoughCash() {
        coatEventScreen.printCoatEventNotEnoughCash();
    }

    public void printWandEvent(String name, int numberOfWands, int damage, int price) {
        wandEventScreen.printWandEvent(name,numberOfWands, damage, price);
    }

    public void printWandEventSold() {
        wandEventScreen.printWandEventSold();
    }

    public void printWandEventNotEnoughCash() {
        wandEventScreen.printWandEventNotEnoughCash();
    }

    public void printFightEventStart() {
        fightEventScreen.printFightEventStart();
    }

    public void printFightEventRecruiting() {
        fightEventScreen.printFightEventRecruiting();
    }

    public void printFightEventNotEnoughStatus() {
        fightEventScreen.printFightEventNotEnoughStatus();
    }

    public void printFightEventMainScreen() {
        fightEventScreen.printFightEventMainScreen();
    }

    public void printFightEventYourself(int health, int wandDamage) {
        fightEventScreen.printFightEventYourself(health, wandDamage);
    }

    public void printFightEventCompanion(int number, int health, int damage) {
        fightEventScreen.printFightEventCompanion(number, health, damage);
    }

    public void printFightEventPolicemen(int number, int health, int damage) {
        fightEventScreen.printFightEventPolicemen(number, health, damage);
    }

    public void printFightEventOptions() {
        fightEventScreen.printFightEventOptions();
    }

    public void printFightEventSuccessfulEscape() {
        fightEventScreen.printFightEventSuccessfulEscape();
    }

    public void printFightEventAttackWho() {
        fightEventScreen.printFightEventAttackWho();
    }

    public void printFightEventAllCopsDefeated() {
        fightEventScreen.printFightEventAllCopsDefeated();
    }

    public void printFightEventUnsuccessfulEscape() {
        fightEventScreen.printFightEventUnsuccessfulEscape();
    }

    public void printLoanSharkDialoguePayBackZero() {
        loanSharkScreen.printLoanSharkDialoguePayBackZero();
    }
}

