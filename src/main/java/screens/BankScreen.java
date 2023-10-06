package screens;

public class BankScreen {
    protected void printBankDialogueStart(){
        System.out.print(
                """
                                              You arrive at Gringotts Wizarding Bank\s
                                                                                              \s
                               Would ya like to (D)eposit  some moola,                         \s
                                             or (W)ithdraw some moola?\s
                                                                \s
                                                            """);
    }

    protected void printBankDialogueDeposit() {
        System.out.print(
                """
                                              You arrive at Gringotts Wizarding Bank\s
                                                                                              \s
                               Would ya like to (D)eposit  some moola,                      \s
                                             or (W)ithdraw some moola?\s
                               \s
                               How much ´ya gonna rathole?                                 \s
                                                            """);
    }

    protected void printBankDialogueWithdraw() {
        System.out.print(
                """
                                              You arrive at Gringotts Wizarding Bank\s
                                                                                              \s
                               Would ya like to (D)eposit  some moola,                        \s
                                             or (W)ithdraw some moola?\s
                               \s
                               How much ´ya gonna pull out?                                 \s
                                                            """);
    }

    protected void printBankDialogueNotEnoughMoney() {
        System.out.print(
                """
                                              You arrive at Gringotts Wizarding Bank\s
                                                                                              \s
                               Would ya like to (D)eposit  some moola,                      \s
                                             or (W)ithdraw some moola?\s
                               \s
                               How much ´ya gonna rathole?                                 \s
                                             You ain't got that much to deposit!             \s
                                                            """);
    }

    protected void printBankDialogueNotEnoughMoneyInBank() {
        System.out.print(
                """
                                              You arrive at Gringotts Wizarding Bank\s
                                                                                              \s
                               Would ya like to (D)eposit  some moola,                        \s
                                             or (W)ithdraw some moola?\s
                               \s
                               How much ´ya gonna rathole?                                 \s
                                              You ain't got that much to pull out!             \s
                                                            """);
    }
}
