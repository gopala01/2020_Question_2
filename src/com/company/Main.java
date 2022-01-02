package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int MAX_STATIONS = 100;

        Station[] stationArray = new Station[MAX_STATIONS];
        for (int i = 0; i < MAX_STATIONS; i++) {
            String name = inputString("What is the name of the station?");
            String stepFreeAccess = inputString("Does this station have step free access (YES / NO)");
            while (!stepFreeAccess.equals("YES") && !stepFreeAccess.equals("NO"))
            {
                stepFreeAccess = inputString("Choose between YES / NO");
            }
            stationArray[i] = inputStation(name, stepFreeAccess);
        }

        choiceMethod(stationArray);
    }

    public static void choiceMethod(Station[] sArray)
    {
        String choice = inputString("Choose between the three: \n1. End Program\n2. Print whether a given station has step free access\n3. Print details of all stations with step free access");
        choice = checkChoice(choice);
        while (!choice.equals("1"))
        {
            if (choice.equals("2"))
            {
                choice2(sArray);
            }
            else if (choice.equals("3"))
            {
                choice3(sArray);
            }
            choice = inputString("Choose between the three: \n1. End Program\n2. Print whether a given station has step free access\n3. Print details of all stations with step free access");
            choice = checkChoice(choice);
        }
        print("Goodbye");

    }

    public static void choice2(Station[] sArray)
    {
        for (int i = 0; i < sArray.length; i++) {

            if (getStepFreeAccess(sArray[i]))
            {
                print(getName(sArray[i]) + " has step free access");
            }
            else if (!getStepFreeAccess(sArray[i]))
            {
                print(getName(sArray[i]) + " does not have step free access");
            }
        }
    }

    public static void choice3(Station[] sArray)
    {
        for (int i = 0; i < sArray.length; i++) {
            if (getStepFreeAccess(sArray[i]))
            {
                print("Station Name - " + getName(sArray[i]) + "\nStep free access is available");
            }
        }
    }
    public static String checkChoice(String choice)
    {
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))
        {
            choice = inputString("Choose between 1, 2 and 3");
        }
        return choice;
    }

    public static Station inputStation(String name, String stepFreeAccess)
    {
        Station s = new Station();
        s.name = name;
        if (stepFreeAccess.equals("YES"))
        {
            s.stepFreeAccess = true;
        }
        else if (stepFreeAccess.equals("NO"))
        {
            s.stepFreeAccess = false;
        }

        return s;
    }
    public static void print(String m)
    {
        System.out.println(m);
    }

    public static String inputString(String m) {
        String answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextLine();
        return answer;
    }

    public static int inputInt(String m) {
        int answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextInt();
        return answer;
    }

    public static String getName(Station s)
    {
        return s.name;
    }

    public static boolean getStepFreeAccess(Station s)
    {
        return s.stepFreeAccess;
    }

}

class Station{
    String name;
    boolean stepFreeAccess;
}
