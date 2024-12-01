import datetime.Date;
import datetime.DateWithTime;
import datetime.Time;
import java.util.Scanner;


public class DateTimeTester {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("\n-------Date and Time-------");
            System.out.println("1. Create Date");
            System.out.println("2. Create Time");
            System.out.println("3. Create DateWithTime");
            System.out.println("4. Quit");
            System.out.print("Choose an option (1-4): ");

            try{
                String userChoice = input.nextLine();
                int choice = Integer.parseInt(userChoice);
                switch (choice) {
                    case 1:
                        createDate(input);
                        break;
                    case 2:
                        createTime(input);
                        break;
                    case 3:
                        createDateWithTime(input);
                        break;
                    case 4:
                        flag = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

        }
    }

    public static void createDate(Scanner input){
        System.out.println("\nDo you want a random date? (yes/no):");
        String response = input.nextLine();

        Date date;
        if (response.equalsIgnoreCase("yes")) {
            date = new Date(true);  // Random date
            System.out.println("Created Dime: " + date.toString());
        } else if (response.equalsIgnoreCase("no")) {
            System.out.println("Enter the date:");
            String dateString = input.nextLine();
            if(dateString.isEmpty()){
                date = new Date(false);
            }else {
                date = new Date(dateString);  // datetime.Date from user input
            }
            if(Validator.dateValidator(date.getYear(), date.getMonth(), date.getDay())){
                System.out.println("Created Dime: " + date.toString());
            }
        }else{
            System.out.println("Invalid input. Please try again.");
        }

    }

    public static void createTime(Scanner input){
        System.out.println("\nDo you want a random time? (yes/no):");
        String response = input.nextLine();

        Time time;
        if (response.equalsIgnoreCase("yes")) {
            time = new Time(true);
            System.out.println("Created Time: " + time.toString());
        }else if(response.equalsIgnoreCase("no")){
            System.out.println("Enter the time:");
            String timeString = input.nextLine();
            if(timeString.isEmpty()){
                time = new Time(false);
            }else{
                time = new Time(timeString);
            }
            if(Validator.timeValidator(time.getHours(), time.getMinutes(), time.getSeconds())){
                System.out.println("Created Time: " + time.toString());
            }
        }else{
            System.out.println("Invalid input. Please try again.");
        }


    }

    public static void createDateWithTime(Scanner input){
        System.out.println("\nDo you want a random date and time? (yes/no):");
        String response = input.nextLine();

        DateWithTime dateWithTime;
        if (response.equalsIgnoreCase("yes")) {
            dateWithTime = new DateWithTime(true);
            System.out.println("Created Date and Time: " + dateWithTime.toString());
        }else if(response.equalsIgnoreCase("no")){
            System.out.println("Enter the date and time:");
            String dateWithTimeString = input.nextLine();
            if(dateWithTimeString.isEmpty()){
                dateWithTime = new DateWithTime(false);
            }else{
                dateWithTime = new DateWithTime(dateWithTimeString);
            }
            if(Validator.dateWithTimeValidator(dateWithTime.getDate(),dateWithTime.getTime())){
                System.out.println("Created Date and Time: " + dateWithTime.toString());
            }
        }else{
            System.out.println("Invalid input. Please try again.");
        }

    }
}
