/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI260ProjectOne;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Chrishon595
 */
public class PatientDriver 
{

    private static int choice;
    private static PrintWriter outFile;


    public static void main(String[] args) throws IOException 
    {
            System.out.println("Welcome to NYIT Hospital");
            System.out.println();
            System.out.println("which file do you want to open?");
            
            Scanner fileInput = new Scanner (System.in); //let user to enter an file
            String fileName = fileInput.nextLine(); //read the file
            File file = new File(fileName); 
		// if file doesnt exists, then create it
            if (!file.exists()) 
            {
                file.createNewFile();
            }
            
            hospitaldatabase2.RefUnsortedList<hospitaldatabase2.Patient> patientList = new hospitaldatabase2.RefUnsortedList<>();
            
            Scanner input = new Scanner (System.in);
        do{
        System.out.println(" 1. Display list\n "
                + "2.Add a new patient\n "
                + "3.Show information for a patien\n "
                + "4. Delete a patien\n"
                + " 5. Show average patient age\n "
                + "6. Show information for the youngest patient\n"
                + " 7. Show notification list\n "
                + "8. Quit");
        
                
                choice = input.nextInt();
        
                if (choice ==1)
                {
                    System.out.println("List of Patient:\n" + patientList);

                }
                if (choice ==2)
                {
                    //letting user to enter every information their self.
                    PrintWriter writer = null;
                    FileWriter fw = new FileWriter("test.txt", true);
                    writer = new PrintWriter(fw);
                    writer.println("New Patient added:");
                    
                
                String patientID = null;
                String patientName = null;
                String patientAddress =null;
                int height = 0;
                double weight = 0;
                String dob = null;
                String div = null;
                String dlv = null;
               // aPatient = new Patient(patientName, patientID, patientAddress, height, weight, dob, div, dlv);
                    hospitaldatabase2.Patient aPatient = new hospitaldatabase2.Patient(patientID);
                    
                    System.out.println("Please create a userID:");
                    Scanner userIDInput = new Scanner (System.in);
                    String PatientID = userIDInput.nextLine();
                    aPatient.setPatientID(PatientID);
                    System.out.println("please type in the new patient name.(for example ZhicongOu)");
                    Scanner nameInput = new Scanner (System.in);
                    patientName = nameInput.nextLine();
                    aPatient.setPatientName(patientName);
                    System.out.println("Please enter the Home address:");
                    Scanner addressInput = new Scanner (System.in);
                    patientAddress = addressInput.nextLine();
                    aPatient.setPatientAddress(patientAddress);
                    System.out.println("Please inter your Date of Birth.(MM-DD-YYY)");
                    Scanner userDOBInput = new Scanner (System.in);
                    String userDOB = userDOBInput.next();
                    System.out.println("Please type in your Height:(inches)");
                    Scanner heightInput = new Scanner (System.in);
                    height = heightInput.nextInt();
                    aPatient.setHeight(height);
                    System.out.println("Please type in your Weight:(lbs.)");
                    Scanner weightInput = new Scanner (System.in);
                    weight = weightInput.nextInt();
                    aPatient.setWeight(weight);
                    System.out.println("Please enter today's date (MM-DD-YYYY)");
                    Scanner dateInput = new Scanner(System.in);
                    div = dlv= dateInput.next();

                     writer.println(aPatient);
                    patientList.add(aPatient);
                    System.out.println(aPatient);
                   
                    
//                    Patient aPatient = null;
//                    patientList.add(aPatient);;
//                    System.out.println("please type in the new patient name.(for example ZhicongOu)");
//                    Scanner nameInput = new Scanner (System.in);
//                    String patientName;
//                    patientName = nameInput.nextLine();
//                    aPatient.setPatientName(patientName);
//                    System.out.println("Please enter the Home address:");
//                    Scanner addressInput = new Scanner (System.in);
//                    String patientAddress = addressInput.nextLine();
//                    aPatient.setPatientAddress(patientAddress);
//                    System.out.println("Please create a userID:");
//                    Scanner userIDInput = new Scanner (System.in);
//                    String userID = userIDInput.nextLine();
//                    aPatient.setPatientID(userID);
//                    System.out.println("Please inter your Date of Birth.(yyy/mm/dd)");
//                    Scanner userDOBInput = new Scanner (System.in);
//                    String userDOB = userDOBInput.nextLine();;
//                    System.out.println("Please type in your Height:");
//                    Scanner heightInput = new Scanner (System.in);
//                    int height = heightInput.nextInt();
//                   aPatient.setHeight(height);
//                    System.out.println("Please type in your Weight:");
//                    Scanner weightInput = new Scanner (System.in);
//                    int weight = weightInput.nextInt();
//                    aPatient.setHeight(height);
//                    System.out.println("Please enter today's date (MM-DD-YYYY)");
//                    Scanner dateInput = new Scanner(System.in);
//                    System.out.println(aPatient);
                    writer.close();
                }
                if (choice == 3)
                {
                    System.out.println("Please type the Patient ID that you want to see the information.(for example ZhicongOu)");
                    Scanner nameInput = new Scanner (System.in);
                    String patientID;
                    patientID = nameInput.nextLine();
                    patientList.returnPatientID(patientID);
                    
                }
                if (choice == 4)
                {
                    System.out.println("Please type the Patient ID that you want to delete (for example ZhicongOu)");
                    Scanner nameInput = new Scanner (System.in);
                    String aPatient = nameInput.nextLine();
                    System.out.println(patientList.removePatient(aPatient));
                }
                if (choice == 5)
                {
                    System.out.println("average patient age is:");
                    int avg = 0;
                    System.out.println(patientList.getAverageAge());
                    
                }
                if (choice == 6)
                {
                    System.out.println("The youngest Patient is:");
                    System.out.println(patientList.getYoungestPatient());
                }
                if (choice == 7)
                {
                    System.out.println("Fellowing Patient need to come back to visit:");
                    patientList.overdue();
                    
                }
                if (choice == 8)
                {
                    System.out.println("Do you want to quit and save your file?(1 = yes, 2 = no)");
                    Scanner answerInput = new Scanner (System.in);
                    int answer = answerInput.nextInt();
                    if (answer == 1)
                    {
                        patientList.printTxt();
                    
                       break; 
                    }
                    else
                    {
                        System.out.println("Back to main manue.");
                    }
                    
                    //use scan in, if the user type yes, quit, else back to the main muen.
                }
                if (choice < 9 || choice >1)
                {
                    System.out.println("valote choice, please enter again");
                }
        }while (choice != 10);{
        
 
			System.out.println("Thank You for using PatientKeeper!");   
    }
    }
    
}
