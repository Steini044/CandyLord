package screens.eventscreens;

public class LowerPricesEventScreen {
    public void printLowerPricesEvent(String beanName) {
        System.out.printf(
                """
                        There is more %s on the market than usual, it's way cheaper\s
                                                               """,beanName);
    }
    public void printLowerPricesEvent(String beanName, String beanName2) {
        System.out.printf(
                """
                        There is more %s and %s on the market than usual, they're way cheaper\s
                                                               """,beanName, beanName2);
    }
    public void printLowerPricesEvent(String beanName, String beanName2, String beanName3) {
        System.out.printf(
                """
                        There is more %s, %s and %s on the market than usual, they're way cheaper\s
                                                               """,beanName, beanName2, beanName3);
    }
}
