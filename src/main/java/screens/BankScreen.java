package screens;

public class BankScreen {
    public void printBankDialogueStart(){
        System.out.print(
                """
                                              You arrive at Gringotts Wizarding Bank\s
                                                                                              \s
                               Would ya like to (D)eposit  some moola,                         \s
                                             or (W)ithdraw some moola?\s
                                                                \s
                                                            """);
    }

    public void printBankDialogueDeposit() {
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

    public void printBankDialogueWithdraw() {
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

    public void printBankDialogueNotEnoughMoney() {
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

    public void printBankDialogueNotEnoughMoneyInBank() {
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
