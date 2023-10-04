package screens;

import state.Location;
import state.State;

import java.util.ArrayList;

public class Screen {
    State state;
    BuyScreen buyScreen;
    SellScreen sellScreen;
    JetScreen jetScreen;
    BankScreen bankScreen;
    HospitalScreen hospitalScreen;
    LoanSharkScreen loanSharkScreen;
    public Screen(State state) {
        this.state = state;
        this.buyScreen = new BuyScreen();
        this.sellScreen = new SellScreen();
        this.jetScreen = new JetScreen();
        this.bankScreen = new BankScreen();
        this.hospitalScreen = new HospitalScreen();
        this.loanSharkScreen = new LoanSharkScreen();
    }

    public void printMainscreen(){
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
                        ║   Tutti-Frutti   %2d ║   Tutti-Frutti  %5d  ║  In Debt:  $%5d            ║\s
                        ║   Cinnamon       %2d ║   Cinnamon      %5d  ║                              ║\s
                        ║   Gras           %2d ║   Gras          %5d  ║  # of Guns: %2d               ║\s
                        ║   Earthworm      %2d ║   Earthworm     %5d  ║   Gun Type: None             ║\s
                        ║   Dirt           %2d ║   Dirt          %5d  ║                              ║\s
                        ║   Vomit          %2d ║   Vomit         %5d  ║  Status Pts: %2d              ║\s
                        ║                     ║                        ║      Health: %3d             ║\s
                        ╚═════════════════════╩════════════════════════╩══════════════════════════════╝\s
                        """
                ,state.getDate().toString() ,state.getLocationName() ,state.getHold(), state.getHoldMax(), state.getBean(0), state.getPriceOf(0), state.getCash(), state.getBean(1), state.getPriceOf(1),
                state.getCashInBank(), state.getBean(2), state.getPriceOf(2), state.getCashInDebt(), state.getBean(3), state.getPriceOf(3),
                state.getBean(4), state.getPriceOf(4), state.getNumberOfWands(),state.getBean(5), state.getPriceOf(5),
                state.getBean(6), state.getPriceOf(6), state.getBean(7), state.getPriceOf(7),  state.getStatusPoints(), state.getHealth());
    }
    public void printMainDialogue(){
        System.out.print(
                """
                                                                                        (Q)uit the game\s
                                          Here's a list of possible plans dude\s
                                     (B)uy Drugs,                  (V)isit de Bank,\s
                                     (S)ell Drugs                  Go to the (H)ospital,\s
                                     (J)et to another city,        See the (L)oan Shark\s

                                                      Make up your mind ► \s
                        """);
    }

    public void printBuyDialogueStart(){
        buyScreen.printBuyDialogueStart();
    }

    public void printBuyDialogueSecondQuestion(int pickedNumber, int maxAffordableBeans){
        buyScreen.printBuyDialogueSecondQuestion(pickedNumber,maxAffordableBeans);
    }

    public void printBuyDialogueNotEnoughHold(int pickedNumber, int maxAffordableBeans) {
        buyScreen.printBuyDialogueNotEnoughHold(pickedNumber,maxAffordableBeans);
    }

    public void printBuyDialogueNotEnoughCash(int pickedNumber, int maxAffordableBeans) {
        buyScreen.printBuyDialogueNotEnoughCash(pickedNumber,maxAffordableBeans);
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
}

