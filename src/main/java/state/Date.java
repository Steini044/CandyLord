package state;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    protected void nextDay(){
        day++;
        switch (month){
            case 1,3,5,7,8,10,12 -> {
                if(day > 31){
                    month++;
                    day = 1;
                }
                if (month > 12){
                    year++;
                }
            }
            case 2 -> {
                if (day > 29){
                    month++;
                    day = 1;
                }
            }
            case 4, 6, 9, 11 -> {
                if(day > 30){
                    month++;
                    day = 1;
                }
            }
        }
    }

    @Override
    public String toString() {
        return day + ". " + month + ". " + year;
    }
}
