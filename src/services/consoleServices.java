package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class consoleServices {

    public static Date readDate(){
        String dateString = readStringFromConsole("Enter date (YYYY-MM-DD): ");
        return Date.valueOf(dateString);
    };
    public static Time readTime() {Scanner scanner = new Scanner(System.in);

        System.out.print("Enter time (HH:MM): ");
        String timeString = scanner.nextLine();

        // Define the expected time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            // Parse the time string into a LocalTime object
            LocalTime localTime = LocalTime.parse(timeString, formatter);
            return Time.valueOf(localTime);
        } catch (Exception e) {
            System.out.println("Invalid time format. Please enter time in HH:MM format.");
            // You might want to handle the exception or prompt the user again
            throw new IllegalArgumentException("Invalid time format", e);
        }
    };

    public static Integer readInt(String message){
        System.out.println(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public static Boolean readBooleanFromConsole(String message) {
        System.out.print(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException("Error reading boolean from console.", e);
        }
    }

    public static String readStringFromConsole(String message) {
        System.out.print(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading string from console.", e);
        }
    }

    public static  int  choose(){
        String input;
        int val=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - personal\n"
                + "2 - official");
        int option = 0;
        try {
            option = scanner.nextInt();
        }catch(NumberFormatException e) {
            System.out.println("Wrong input");
        }

        switch(option){
            case 1:
                val=1;
                break;
            case 2:
                val= 2;
                break;

        }
        return val;
    }


}
