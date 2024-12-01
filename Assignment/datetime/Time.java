package datetime;

import java.util.Random;

public class Time {
    private int hours;
    private int minutes;
    private int seconds=00; //used a predetermined value for pm am situation where no seconds count entered

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(boolean flag) {
        if (flag) {
            Random rand = new Random();
            this.hours = rand.nextInt(24) ;
            this.minutes = rand.nextInt(60) ;
            this.seconds = rand.nextInt(60) ;
        } else {
            this.hours = 00;
            this.minutes = 00;
            //took the 00:00:00 as default value
            System.out.println("Printing the default time.....");
        }
    }

    public Time(String timeString) {
        //trim the string to remove unintentional whitespaces from beginning and end
        timeString = timeString.trim();

        if(timeString.substring(timeString.length()-1).equalsIgnoreCase("m")) {

            String period = timeString.substring(timeString.length()-2);
            String newTime = timeString.substring(0, timeString.length()-2);

            setTime(newTime);

            if (period.equalsIgnoreCase("pm" )&&this.hours<12) {
                this.hours=this.hours+12;
            }
        }else{
            setTime(timeString);
        }
    }

    public void setTime(String timeString){
        String[] time = timeString.split("[-:., ]");
        if (time.length == 1 ) {

            if (timeString.length()==4){
                String hrs = timeString.substring(0, 2);
                String mins = timeString.substring(2, 4);

                time = new String[]{hrs,mins};
            } else if (timeString.length()==6){
                String hrs = timeString.substring(0, 2);
                String mins = timeString.substring(2, 4);
                String secs = timeString.substring(4, 6);

                time = new String[]{hrs,mins,secs};
            }else{
                System.out.println("Invalid time format");
            }
        }

        this.hours = Integer.parseInt(time[0]);
        this.minutes = Integer.parseInt(time[1]);

        if (time.length == 3) {
            this.seconds = Integer.parseInt(time[2]);
        }
    }


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
