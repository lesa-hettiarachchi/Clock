import datetime.Date;
import datetime.Time;

public class Validator {

    public static boolean timeValidator(int hours, int minutes, int seconds) {
        boolean flag = true;
        if (hours <0 || hours> 23) {
            System.out.println("Enter Valid Hour Count");
            flag = false;
        }
        if (minutes <0 || minutes > 59) {
            System.out.println("Enter Valid Minute Count");
            flag = false;
        }
        if (seconds <0 || seconds > 59) {
            System.out.println("Enter Valid Second Count");
            flag = false;
        }
        return flag;
    }

    public static boolean dateValidator(int year, int month, int day) {
        boolean flag = true;
        if (month < 1 || month > 12) {
            System.out.println("Enter Valid Month");
            flag = false;
        }
        if (day < 1 || day > 31) {
            System.out.println("Enter Valid Day");
            flag = false;
        }
        if(month ==2){
            if (year%4==0 && (year%100!=0 || year%400==0)){
                if (day <1 || day > 29) {
                    System.out.println("It is a Leap Year, Maximum days in February is 29.");
                    flag = false;
                }
            }else{
                if (day < 1 || day > 28) {
                    System.out.println("It is not a Leap Year, Maximum days in February is 28.");
                    flag = false;
                }
            }
        }
        if(year<0){
            System.out.println("Enter Valid Year");
            flag = false;
        }
        return flag;
    }

    public static boolean dateWithTimeValidator(Date date, Time time) {
        return dateValidator(date.getYear(), date.getMonth(), date.getDay()) && timeValidator(time.getHours(), time.getMinutes(), time.getSeconds());
    }
}
