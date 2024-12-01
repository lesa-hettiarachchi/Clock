package datetime;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;


public class Date{
    private int day;
    private int month;
    private int year = -1; // 0000 is a valid year unlike for days or months
    private static final Map<String , Integer> monthMap = createMonthMap();


    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(boolean flag) {
        if (flag) {
            Random rand = new Random();
            this.day = rand.nextInt(29) ;  // Days between 1 and 28 for simplicity
            this.month = rand.nextInt(13) ; // Months between 1 and 12
            this.year = rand.nextInt(801)+1700 ; // Years between 1700 and 2500
        } else {
            this.day = 1;
            this.month = 1;
            this.year = 2000;// Default date: 1st January 2000

            System.out.println("Printing the default date.....");
        }
    }

    public Date(String strDate) {
        String[] date = strDate.split("[-/., ]");
        if (!(date.length <=1)) {
            if (isInteger(date[1])) {
                this.month = (Integer.parseInt(date[1]));
            } else {
                this.month = monthMap.get(date[1].toLowerCase());
            }
            this.day = Integer.parseInt(date[0]);
            this.year = Integer.parseInt(date[2]);
        }
    }

    private static Map<String, Integer> createMonthMap() {
        Map<String, Integer> monthMap = new HashMap<>();
        //long format
        monthMap.put("january", 1);
        monthMap.put("february", 2);
        monthMap.put("march", 3);
        monthMap.put("april", 4);
        monthMap.put("may", 5);
        monthMap.put("june", 6);
        monthMap.put("july", 7);
        monthMap.put("august", 8);
        monthMap.put("september", 9);
        monthMap.put("october", 10);
        monthMap.put("november", 11);
        monthMap.put("december", 12);

        // Short format
        monthMap.put("jan", 1);
        monthMap.put("feb", 2);
        monthMap.put("mar", 3);
        monthMap.put("apr", 4);
        // may remove from here because may is same for short and long
        monthMap.put("jun", 6);
        monthMap.put("jul", 7);
        monthMap.put("aug", 8);
        monthMap.put("sep", 9);
        monthMap.put("oct", 10);
        monthMap.put("nov", 11);
        monthMap.put("dec", 12);

        return monthMap;
    }

    public String monthChooser(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid month";
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%02d %s %04d", day, monthChooser(month), year);
    }
}