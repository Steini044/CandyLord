public class Screen {
    public void printScreen(State state, Location location){
        System.out.printf(
                "╔═════════════════════════════════════════════════════════════════════════════╗ \n" +
                "║                       * * * D R U G  L O R D * * *                          ║ \n" +
                "╠═══ Date: 09/28/90 ═══════════════════════════╦══════════════════════════════╣ \n" +
                "║                                              ║   Location: Los Angeles      ║ \n" +
                "╠═══ Drugs on Hand ═══╦════ Street Prices ═════╣       Hold: %2d     (%2d max)  ║ \n" +
                "║                     ║                        ║                              ║ \n" +
                "║   Cocaine         0 ║   Cocaine        50444 ║       Cash:  $0              ║ \n" +
                "║   Crack           0 ║   Crack                ║    In Bank:  $0              ║ \n" +
                "║   Heroin          0 ║   Heroin               ║    In Debt:  $0              ║ \n" +
                "║   Acid            0 ║   Acid                 ║                              ║ \n" +
                "║   Crystal         0 ║   Crystal              ║  # of Guns: 0                ║ \n" +
                "║   Grass           0 ║   Grass                ║   Gun Type: None             ║ \n" +
                "║   Speed           0 ║   Speed                ║                              ║ \n" +
                "║   Ludes           0 ║   Ludes                ║  Status Pts: 1               ║ \n" +
                "║                     ║                        ║      Health: 100             ║ \n" +
                "╚═════════════════════╩════════════════════════╩══════════════════════════════╝ \n" +
                "                                                                (Q)uit the game \n" +
                "                  Here's a list of possible plans dude \n" +
                "             (B)uy Drugs,                  (V)isit de Bank, \n" +
                "             (S)ell Drugs                  Go to the (H)ospital, \n" +
                "             (J)et to another city,        See the (L)oan Shark \n" +
                "\n" +
                "                              Make up your mind ► ",state.getHold(), state.getHoldMax());
    }
}
