package screens.eventscreens;

public class HigherPricesEventScreen {
    public void printHigherPricesEvent(String beanName) {
        System.out.printf(
                """
                        There is less %s on the market than usual, the price escalated\s
                                                               """,beanName);
    }
    public void printHigherPricesEvent(String beanName, String beanName2) {
        System.out.printf(
                """
                        There is less %s and %s on the market than usual, the price escalated\s
                                                               """,beanName, beanName2);
    }
    public void printHigherPricesEvent(String beanName, String beanName2, String beanName3) {
        System.out.printf(
                """
                        There is less %s, %s and %s on the market than usual, the price escalated\s
                                                               """,beanName, beanName2, beanName3);
    }
}
