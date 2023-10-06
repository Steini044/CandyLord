package screens;

public class LoanSharkScreen {
    public void printLoanSharkDialogueStart() {
        System.out.print(
                """
                    Ya set foot in the ´sharks office. You've been in locker rooms that smelled\s
                    better than dis place! His boys are lookin' tough in their nice goon suits;\s
                    but you don't pay dem no never-mind, cause the head-honcho, Guido is talkin ...\s
                                         He say, you wanna (B)orrow some chash,                   \s
                                           or do you wanna (P)ay me back?                \s
                                           """);
    }

    public void printLoanSharkDialogueBorrow() {
        System.out.print(
                """                    
                                                                     \s
                                  How much ya wanna borrow? \s
                                                           """);
    }

    public void printLoanSharkDialoguePayBack() {
        System.out.print(
                """      
                                                                    \s
                                  How much ya wanna pay back? \s
                                                           """);
    }

    public void printLoanSharkDialogueTooMuchMoney() {
        System.out.print(
                """
                    No deal, too big a risk for me! I'm a businessman, ya'know!\s
                                                           """);
    }

    public void printLoanSharkDialogueAlreadyInDebt(int cashInDebt) {
        System.out.printf(
                """
                    look, you already owe me %d bucks, I'm not given ya THAT much more!!!\s
                                     Christ, what do I look like, Santi-Claus?                     
                                                           """, cashInDebt);
    }

    public void printLoanSharkDialogueTooLessMoney() {
        System.out.print(
                """
                    Sorry, bud, but I got a $1000 minimum. Got no time for penny-ante stuff!\s
                                                           """);
    }

    public void printLoanSharkDialogueNotInDebt() {
        System.out.print(
                """
                        My books show dat you don't ow me nut'in... would youse like to take out\s
                        a little loan?                                       \s
                                                               """);
    }

    public void printLoanSharkDialogueNotEnoughMoney() {
        System.out.print(
                """
                        'fraid you don't got that in cash, my man.\s
                                                               """);
    }

    public void printLoanSharkDialogueCountdownStarted(int debtCounter) {
        System.out.printf(
                """
                        Alright, I'll loan ya de money, but if you welch, my boys will come lookin\s
                        for ya! I expect to see you here to pay me in full in %2d days.        \s
                                                               """,debtCounter);
    }

    public void printLoanSharkDialogueStillDebtRemaining(int cashInDebt) {
        System.out.printf(
                """
                        OK, but you still owe me %5d bucks!\s
                                                               """, cashInDebt);
    }
}
