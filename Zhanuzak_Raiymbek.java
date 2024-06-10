import java.io.*;
import java.util.*;

public class Zhanuzak_Raiymbek{
    static Scanner scanner = new Scanner(System.in);
    public static void greeting(){
        System.out.println("Welcome to Vacation Planner!");
        System.out.println("What is your name: "); String name = scanner.nextLine();
        System.out.println("Nice to meet you " + name + ", where are you travelling to?"); String country = scanner.nextLine();
        System.out.println("Great! " + country + " sounds like a great trip");
    }
    public static void travelTimeBudget(){
        System.out.println("How many days are you going to spend traveling? "); long days = scanner.nextLong();
        System.out.println("How much money, in USD, are you planning to spend on your trip: "); long money_usd = scanner.nextLong();
        System.out.println("What is the three letter currency symbol for your travel destination? "); String symbol = scanner.next();
        System.out.println("How many " + symbol + " are there in 1 USD?"); double course = scanner.nextDouble();
        long hours = days * 24;
        long minutes = hours * 60;
        long seconds = minutes * 60;
        double money = (double)((int)((money_usd * (double)course) * 100)) / 100;
        double usd_perday = (double)((int)((money_usd / (double)days) * 100)) / 100;
        double perday = (double)((int)((money / (double)days) * 100)) / 100;
        System.out.println("If you are traveling for " + days + " days that is same as " + hours + " hours or " + minutes + " minutes or " + seconds + " seconds.");
        System.out.println("If you are going to spend $" + money_usd + " USD that means per day you can spend up to $" + usd_perday + " USD.");
        System.out.println("Your total budget in " + symbol + " is " + money + " " + symbol + " , which per day is " + perday + " " + symbol + ".");
    }
    public static void timeDifference(){
        System.out.println("What is the time difference, in hours, between your home and your destination? "); double timedifference = scanner.nextDouble();
        int timedifference2 = (int)timedifference % 24;
        double minute = timedifference - (int)timedifference;
        int minute2 = (int)(minute * 60);
        int midnight = 24 + timedifference2;
        midnight %= 24;
        int noon = 12 + timedifference2;
        if(timedifference < 0){
            if(minute2 != 0){ noon = (24 + noon) % 24 - 1; midnight -= 1; minute2 += 60;}
            else noon = (24 + noon) % 24;
        }
        else noon %= 24;
        String minute3 = String.valueOf(minute2);
        if(minute2 == 0) minute3 += "0";
        System.out.println("That means that when it is midnight at home it will be " + midnight + ":" + minute3 + " in your travel destination and when it's noon at home it will be " + noon + ":" + minute3);
    }
    public static void countryArea(){
        System.out.println("What is square area of your destination country in km2? "); int area_km = scanner.nextInt();
        double area_mile = area_km * 0.38610215854245;
        area_mile = (double)((int)(area_mile * 100)) / 100;
        System.out.println("In miles2 that is " + area_mile);
    }
    public static void nextDestination(){
        System.out.println("How many places you traveled to : "); int numplace = scanner.nextInt();
        String[] places = new String[numplace];
        for(int i = 0; i < numplace; i++) { scanner.nextLine(); System.out.println("Enter the name: "); places[i] = scanner.next();}
        System.out.println("Next place you want to travel to : ");
        String[] placesIwant = {"Italy", "England", "Netherlands", "Germany", "France"};
        for(int j = 0; j < numplace; j++) System.out.println(j + ": " + placesIwant[j]);
        int newCountry = scanner.nextInt();
        System.out.println("Thank you, Your next location is : " + placesIwant[newCountry - 1]);
        //travelTimeBudget(); //I wasn't sure if it was necessary, but logically the last method had to run all the code again, so I added it as a comment
        //timeDifference();
        //countryArea();
        //nextDestination();
    }
    public static void main(String[] args) {
        greeting();
        travelTimeBudget();
        timeDifference();
        countryArea();
        nextDestination();
    }
}