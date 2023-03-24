/*
Author: Mariam Minhas
E-mail: mbm6797@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 1
Due date: 1/28/2022
File: HW1-VIN.java
Purpose: Java application that implements a simple Vehicle Identification Number (VIN) decoder.
Compiler/IDE: Java SE Development Kit 17.0.1/IntelliJ
Operating system: macOS Big Sur
Reference(s):
-https://en.wikipedia.org/wiki/Vehicle_identification_number#Model_year_encoding
-Lecture notes chapter 1, 2
-https://www.javatpoint.com/how-to-take-string-input-in-java
-https://www.javatpoint.com/java-program-to-remove-all-white-spaces-from-a-string
-https://www.techiedelight.com/check-string-contains-alphanumeric-characters-java/
*/
//scanner class to have input

import java.util.Scanner;


public class VINDecoder {
    /**
     * This method checks if the string is alphanumeric
     *
     * @param str the string that is read
     * @return false if not alphanumeric, true if alphanumeric
     */
    public static Boolean CharacterCheck(String str) {
        for (int x = 0; x < str.length(); x++) {
            //loop to check each character in string for letter or number
            char place = str.charAt(x);
            if ((!(place >= 'A' && place <= 'Z')) && (!(place >= 'a' && place <= 'z')) && (!(place >= '0' && place <= '9'))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * This method prints out the WMI, VDS, and VIS
     *
     * @param str the string that is read
     * @return void
     */
    public static void AssessVIN(String str) {
        // initialize
        String wmi;
        String vds;
        String vis;

        System.out.println("Values by group:");
        //print out the WMI,VDS,VIS
        wmi = str.substring(0, 3);
        //wmi,print out with 5 leading spaces
        System.out.println("     World Manufacturer Identifier (WMI): " + wmi.toUpperCase());
        vds = str.substring(3, 9);
        //vds,print out with 5 leading spaces
        System.out.println("     Vehicle Descriptor Section (VDS):    " + vds.toUpperCase());
        vis = str.substring(9, 17);
        //vis,print out with 5 leading spaces
        System.out.println("     Vehicle Identifier Section (VIS):    " + vis.toUpperCase());
    }


    /**
     * This method prints out the country of manufacture and the manufacturer
     *
     * @param str the string that is read
     * @return void
     */
    public static void Attributes(String str) {
        //initialize
        char ctry;
        char manf;
        char check;
        char year;
        String serial;

        //take the character within the string
        ctry = str.charAt(0);
        manf = str.charAt(1);
        check = str.charAt(8);
        year = str.charAt(9);
        serial = str.substring(11, 17);

        System.out.println("Vehicle attributes:");

        //country codes and print statement within
        if (ctry == '1' || ctry == '4' || ctry == '5') {
            System.out.println("     Country of manufacture: Germaxny");
        } else if (ctry == '2') {
            System.out.println("     Country of manufacture: Canada");
        } else if (ctry == '3') {
            System.out.println("     Country of manufacture: Mexico");
        } else if (ctry == 'J' || ctry == 'j') {
            System.out.println("     Country of manufacture: Japan");
        } else if (ctry == 'S' || ctry == 's') {
            System.out.println("     Country of manufacture: United Kingdom");
        } else if (ctry == 'W' || ctry == 'w') {
            System.out.println("     Country of manufacture: Germany");
        }

        //manufacturer codes with print statement within
        if (manf == 'C' || manf == 'c') {
            System.out.println("     Manufacturer:           Chrysler (United States)");
        } else if (manf == 'F' || manf == 'f') {
            System.out.println("     Manufacturer:           Ford (North America)");
        } else if (manf == 'G' || manf == 'g') {
            System.out.println("     Manufacturer:           General Motors (United States)");
        } else if (manf == 'H' || manf == 'h') {
            System.out.println("     Manufacturer:           Honda (Japan or North America)");
        } else if (manf == 'T' || manf == 't') {
            System.out.println("     Manufacturer:           Toyota (Japan or North America)");
        } else if (manf == 'B' || manf == 'b') {
            System.out.println("     Manufacturer:           BMW (Germany)");
        } else if (manf == 'A' || manf == 'a') {
            System.out.println("     Manufacturer:           Jaguar (United Kingdom)");
        } else if (manf == 'D' || manf == 'd') {
            System.out.println("     Manufacturer:           Mercedes-Benz (Germany)");
        }
    }

    /**
     * this method prints out the check digit
     *
     * @param str the string that is read
     * @return void
     */
    public static void CheckDigit(String str) {
        //initialize
        char check;

        //take the character within the string
        check = str.charAt(8);

        if ((check >= '0' && check <= '9') || check == 'X' || check == 'x') {
            System.out.println("     Check digit:            " + check);
        }
    }

    /**
     * this method finds and prints the year of the VIN
     *
     * @param str the string that is read
     * @return void
     */
    public static void AssessYear(String str) {
        //initialize
        char year;

        //take the character in the string
        year = str.charAt(9);
        String modyear = "";

        if (year == 'y' || year == 'Y') {
            modyear = "2000";
        } else if (year == '1') {
            modyear = "2001";
        } else if (year == '2') {
            modyear = "2002";
        } else if (year == '3') {
            modyear = "2003";
        } else if (year == '4') {
            modyear = "2004";
        } else if (year == '5') {
            modyear = "2005";
        } else if (year == '6') {
            modyear = "2006";
        } else if (year == '7') {
            modyear = "2007";
        } else if (year == '8') {
            modyear = "2008";
        } else if (year == '9') {
            modyear = "2009";
        } else if (year == 'A' || year == 'a') {
            modyear = "2010";
        } else if (year == 'B' || year == 'b') {
            modyear = "2011";
        } else if (year == 'C' || year == 'c') {
            modyear = "2012";
        } else if (year == 'D' || year == 'd') {
            modyear = "2013";
        } else if (year == 'E' || year == 'e') {
            modyear = "2014";
        } else if (year == 'F' || year == 'f') {
            modyear = "2015";
        } else if (year == 'G' || year == 'g') {
            modyear = "2016";
        } else if (year == 'H' || year == 'h') {
            modyear = "2017";
        } else if (year == 'J' || year == 'j') {
            modyear = "2018";
        } else if (year == 'K' || year == 'k') {
            modyear = "2019";
        } else if (year == 'L' || year == 'l') {
            modyear = "2020";
        } else if (year == 'M' || year == 'm') {
            modyear = "2021";
        } else if (year == 'N' || year == 'n') {
            modyear = "2022";
        } else if (year == 'P' || year == 'p') {
            modyear = "2023";
        } else if (year == 'R' || year == 'r') {
            modyear = "2024";
        } else if (year == 'S' || year == 's') {
            modyear = "2025";
        } else if (year == 'T' || year == 't') {
            modyear = "2026";
        } else if (year == 'V' || year == 'v') {
            modyear = "2027";
        } else if (year == 'W' || year == 'w') {
            modyear = "2028";
        } else if (year == 'X' || year == 'x') {
            modyear = "2029";
        }
        System.out.println("     Model year:             " + modyear);

    }

    /**
     * this method finds and prints the serial number of the VIN
     *
     * @param str the string that is read
     * @return void
     */
    public static void Serial(String str) {
        System.out.println("     Serial number:          " + str.substring(11, 17));
    }

    /**
     * this method Assesses the VIN number and prints the output
     *
     * @param str the string that is read
     * @return void
     */
    public static void Rerun(String str) {
        //Now check for validity of string input
        //1. if there are spaces, get rid of them
        str = str.replaceAll("\\s", "");
        if ((str.length() == 17) && CharacterCheck(str)) {
            //print a blank line for spacing purposes
            System.out.println();
            //print that the decoding is in progress
            System.out.println("VIN is valid. Decoding in progress ...");
            System.out.println();
            AssessVIN(str);
            System.out.println();
            Attributes(str);
            CheckDigit(str);
            AssessYear(str);
            Serial(str);
            System.out.println();

        }

    }

    /**
     * this method has the invalid content of the VIN Number
     *
     * @param str the string that is read
     * @return void
     */
    public static void Invalid(String str) {
        String notctry = "14523JSW";
        String notmanf = "CFGHTBAD";
        String badlet = "OIQ";

        //initialize
        char ctry;
        char manf;
        char check;
        char year;
        String serial;

        //take the character within the string
        ctry = str.charAt(0);
        manf = str.charAt(1);
        check = str.charAt(8);
        year = str.charAt(9);

        //turn the chars into string to ask contains
        String sctry = String.valueOf(ctry);
        String smanf = String.valueOf(manf);
        String syear = String.valueOf(year);

        str = str.replaceAll("\\s", "");


        if ((str.length() != 17)) {
            System.out.println();
            System.out.println("** VIN must contain 17 characters. **");
            System.out.println();
        } else if ((CharacterCheck(str)) == Boolean.FALSE) {
            System.out.println();
            System.out.println("** VIN can only contain letters and digits. **");
            System.out.println();
        } else if ((sctry.contains(notctry)) || (smanf.contains(notmanf))) {
            System.out.println();
            System.out.println(sctry);
            System.out.println("** VIN is invalid. **");
            System.out.println();
        } else if (!(((check >= '0') && (check <= '9')) || (check == 'X') || (check == 'x'))) {
            System.out.println();
            System.out.println(check);
            System.out.println("** VIN is invalid. **");
            System.out.println();

        } else if (!((year >= '0' && year <= '9') || (year >= 'A' && year <= 'Y') || (year >= 'a' && year <= 'y'))) {
            System.out.println();
            System.out.println(year);
            System.out.println("** VIN is invalid. **");
            System.out.println();
        } else if (str.contains("Q") || str.contains("q") || str.contains("I") || str.contains("i") || str.contains("O") || str.contains("o")) {
            System.out.println();
            System.out.println("** VIN is invalid. **");
            System.out.println();
        }

        String reply;
        Scanner prompt = new Scanner(System.in);
        //ask user if they want to do another VIN
        //print if they want to do another one
        System.out.println("Enter another VIN (Y/N)?");
        reply = prompt.nextLine();
        if (reply.equals('y') || reply.equals('Y')) {
            System.out.println("********************************************************************************");
        }
        if ((reply.equals("N") || reply.equals("n"))) {
            System.out.println();
            System.out.println("********************************************************************************");
            System.out.println("Thanks for using my VIN decoder!");
            System.out.println("********************************************************************************");
            System.exit(0);
        }

    }

    public static void Other(String rep) {
        String vininput;
        String reply;
        Scanner keyboard = new Scanner(System.in);
        vininput = keyboard.nextLine();

    }

    public static void main(String[] args) {
        //print header
        System.out.println("********************************************************************************");
        System.out.println("                                 VIN Decoder                                    ");
        System.out.println("********************************************************************************");

        //Initialize
        String vininput;
        int length;
        String check;
        String reply;

        //make object of scanner class named keyboard
        Scanner keyboard = new Scanner(System.in);
        //print the prompt
        System.out.println("Please enter a string representing a Vehicle Identification Number (VIN):");
        //scan in a vin number from input
        vininput = keyboard.nextLine();
        //find length of input
        length = vininput.length();


        //Now check for validity of string input

        //1. if there are spaces, get rid of them
        vininput = vininput.replaceAll("\\s", "");

        //2. check for 17 length and alphanumeric
        if ((vininput.length() == 17) && CharacterCheck(vininput)) {
            //print a blank line for spacing purposes
            System.out.println();
            //print that the decoding is in progress
            System.out.println("VIN is valid. Decoding in progress ...");
            System.out.println();
            AssessVIN(vininput);
            System.out.println();
            Attributes(vininput);
            CheckDigit(vininput);
            AssessYear(vininput);
            Serial(vininput);
            System.out.println();
        }
        if (vininput.length() != 17) {
            System.out.println();
            System.out.println("** VIN must contain 17 characters. **");
            System.out.println();
        }
        if ((CharacterCheck(vininput)) == Boolean.FALSE) {
            System.out.println();
            System.out.println("** VIN can only contain letters and digits. **");
            System.out.println();
        }

        //try doing it all again
        //reset the VIN
        vininput = "";
        //ask user if they want to do another VIN
        Scanner prompt = new Scanner(System.in);
        //print if they want to do another one
        System.out.println("Enter another VIN (Y/N)?");
        reply = prompt.nextLine();
        while (reply.equals("Y") || reply.equals("y")) {
            vininput = "";
            System.out.println();
            System.out.println("********************************************************************************");
            System.out.println();
            System.out.println("Please enter a string representing a Vehicle Identification Number (VIN):");
            //scan in a vin number from input
            vininput = keyboard.nextLine();
            //find length of input
            length = vininput.length();
            Rerun(vininput);
            Invalid(vininput);
            if ((reply.equals("N") || reply.equals("n"))) {
                System.out.println();
                System.out.println("********************************************************************************");
                System.out.println("Thanks for using my VIN decoder!");
                System.out.println("********************************************************************************");
                System.exit(0);
            }
            if (!(reply.equals("N") || reply.equals("n")) || !(reply.equals("Y") || reply.equals("y"))) {
                System.out.println();
                System.out.println("** You may only choose Y or N. **");
                System.out.println();
                System.out.println("Enter another VIN (Y/N)?");
                reply = prompt.nextLine();
                if ((reply.equals("N") || reply.equals("n"))) {
                    System.out.println();
                    System.out.println("********************************************************************************");
                    System.out.println("Thanks for using my VIN decoder!");
                    System.out.println("********************************************************************************");
                    System.exit(0);
                }
                while (reply.equals("Y") || reply.equals("y")) {
                    vininput = "";
                    System.out.println();
                    System.out.println("********************************************************************************");
                    System.out.println();
                    System.out.println("Please enter a string representing a Vehicle Identification Number (VIN):");
                    //scan in a vin number from input
                    vininput = keyboard.nextLine();
                    //find length of input
                    length = vininput.length();
                    Rerun(vininput);
                    Invalid(vininput);
                    if ((reply.equals("N") || reply.equals("n"))) {
                        System.out.println();
                        System.out.println("********************************************************************************");
                        System.out.println("Thanks for using my VIN decoder!");
                        System.out.println("********************************************************************************");
                        System.exit(0);
                    }

                }
                if ((reply.equals("N") || reply.equals("n"))) {
                    System.out.println();
                    System.out.println("********************************************************************************");
                    System.out.println("Thanks for using my VIN decoder!");
                    System.out.println("********************************************************************************");
                    System.exit(0);
                }
            }
            }

            if ((reply.equals("N") || reply.equals("n"))) {
                System.out.println();
                System.out.println("********************************************************************************");
                System.out.println("Thanks for using my VIN decoder!");
                System.out.println("********************************************************************************");
                System.exit(0);
            }
        }
    }




