package datetime;

public class DateWithTime {
    private Date date;
    private Time time;

    public DateWithTime(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public DateWithTime(boolean flag) {
        if (flag){
            this.date = new Date(true);
            this.time = new Time(true);
        }else{
            this.date = new Date(false);
            this.time = new Time(false);
        }
    }

    public DateWithTime(String dateWithTimeString) {
        dateWithTimeString = dateWithTimeString.trim();
        String [] dateTimeParts = dateWithTimeString.split(" ");
        String timeString;
        String dateString;
        if(dateTimeParts[dateTimeParts.length-1].equalsIgnoreCase("AM")||dateTimeParts[dateTimeParts.length-1].equalsIgnoreCase("PM")){
            timeString = dateTimeParts[dateTimeParts.length-2]+" "+dateTimeParts[dateTimeParts.length-1];
            dateString = dateWithTimeString.substring(0,dateWithTimeString.length()-timeString.length());
        }else{
            timeString = dateTimeParts[dateTimeParts.length-1];
            dateString = dateWithTimeString.substring(0,dateWithTimeString.length()-timeString.length());
        }
        this.date = new Date(dateString);
        this.time = new Time(timeString);
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return date.toString() + " " + time.toString();
    }
}
