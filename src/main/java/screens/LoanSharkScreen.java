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
                    Ya set foot in the ´sharks office. You've been in locker rooms that smelled\s
                    better than dis place! His boys are lookin' tough in their nice goon suits;\s
                    but you don't pay dem no never-mind, cause the head-honcho, Guido is talkin ...\s
                                                            \s
                                  How much ya wanna borrow? \s
                                                           """);
    }

    public void printLoanSharkDialoguePayBack() {
        System.out.print(
                """
                    Ya set foot in the ´sharks office. You've been in locker rooms that smelled\s
                    better than dis place! His boys are lookin' tough in their nice goon suits;\s
                    but you don't pay dem no never-mind, cause the head-honcho, Guido is talkin ...\s
                                                            \s
                                  How much ya wanna pay back? \s
                                                           """);
    }
}
