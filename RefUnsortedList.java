/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI260ProjectOne;

/**
 *
 * @author Chrishon595
 */
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class RefUnsortedList<T> implements LLinterface<T>, Serializable 
{
    protected int numElements;
    protected LLNode<T> currentPos;
    protected boolean found;
    protected LLNode<T> location;
    protected LLNode<T> previous;
    protected LLNode<T> list;
    
    public RefUnsortedList()
    {
        numElements =0;
        list = null;
        currentPos =null;
    }
    
    public void add(T element)
    {
      LLNode<T> newNode = new LLNode<T>(element);
      newNode.setLink(list);
      list= newNode;
      numElements++;
    }
    
    protected void find(T target)
    {
        location = list;
        found = false;
        
        while(location !=null)
        {
            if (location.getInfo().equals(target))
            {
                found = true;
                return;
            }
            else
            {
                previous = location;
                location = location.getLink();
            }
        }
    }
    
    public int size()
    {
        return numElements;
    }
    
    public boolean contains( T element)
    {
        find(element);
        return found;
    }
    
    public boolean remove (T element)
    {
        find(element);
        if (found)
        {
            if (list == location)
                list = list.getLink();
            else
                previous.setLink(location.getLink());
            
            numElements--;
        }
        return found;
    }
    
    public String removePatient (String element)
            //remove the element and return ture if it is removed
    {
        LLNode<T> node = list;
        LLNode<T> previous = null;
        LLNode<T> location = node;
        
        while(node!=null){
        if (((Patient)node.getInfo()).getPatientID().equalsIgnoreCase(element))
        
        {
            if (list == location)
                list = list.getLink();
            else
                previous.setLink(location.getLink());
            
            numElements--;
            node = node.getLink();
            return " This Patient is remove from the list.";
        }
        else
        {
            node = node.getLink();
        }
        }
        return "We can not find this Patient."; 
    }
    
    public T get( T element)
    {
        find(element);
        if (found)
            return location.getInfo();
        else
            return null;
    }
        
    public String toString()
    {
        LLNode<T> currNode = list;
        String listString = "Likst: \n";
        while (currNode != null)
        {
            listString= listString + " " + currNode.getInfo() + "\n";
            currNode = currNode.getLink();
        }
        return listString;
    }
    
    public void reset()
    {
        currentPos = list;
    }
    
    public T getNext()
    {
        T next = currentPos.getInfo();
        if (currentPos.getLink() ==null)
            currentPos = list;
        else
            currentPos = currentPos.getLink();
        return next;
    }
    
    public double getAverageAge()
    //it calculates the age for all patients on the list and return the age
    {
        LLNode<T> youngestNode= list;
        double averageAge = 0;
        double sum = 0;
        while(youngestNode != null)
        {
            sum = sum + ((Patient)youngestNode.getInfo()).getAge();
            youngestNode=youngestNode.getLink();
        }
        averageAge = sum/size();
        
        return averageAge;
    }
    
    public String getYoungestPatient()
    // returns the youngest patient information
    {
        LLNode<T> youngestNode=list;
        int intialAge = 1000000;
        int compare = 0;
        String youngestPatient = null;
        while(youngestNode != null)
        {
            compare = ((Patient)youngestNode.getInfo()).getAge();
            if(intialAge>compare)
            {
                intialAge = compare;
                youngestNode = youngestNode.getLink();
            }
            else
            {
                youngestNode = youngestNode.getLink();
            }
        }
        youngestNode = list;
        youngestPatient= Integer.toString(intialAge);
        while(youngestNode!= null)
        {
            if(((Patient)youngestNode.getInfo()).getAge()== intialAge)
            {
                youngestPatient=""+((Patient) youngestNode.getInfo()).toString();
                youngestNode = youngestNode.getLink();
            }
            else
            {
                youngestNode = youngestNode.getLink();
            }
        }
        return youngestPatient;
    }
    
    public void returnPatientID(String element)
            // This method is use to return the the Patient information for 
            //the user that he/she want to see
    {
        LLNode<T> node = list ;
        while(node != null)
        {
            if(((Patient)node.getInfo()).getPatientID().equalsIgnoreCase(element))
            {
                System.out.println(((Patient)node.getInfo()).toString());
                node = node.getLink();
            }
            else
            {
                node = node.getLink();
        }
        }
    }
    
    public String checkPatientID(String element)
            //This method is use to check if the patientID is same as the ID 
            //that already inside of the list
    {
        LLNode<T> node = list;
        while(node != null)
        {
            if(((Patient)node.getInfo()).getPatientID().equalsIgnoreCase(element))
            {
                node= node.getLink();
                return "This ID is already being used";
            }
            else
            {
                node = node.getLink();
            }
        }
        return "Enter Patient Info:";
    }
    
    public void overdue()
    //check if the patient needs to come for a visist
    {
        LLNode<T> node= list;
        int lastVisit = 0;
        while (node != null)
        {
            lastVisit= ((Patient)node.getInfo()).LastVisit();
            
            if(lastVisit>3)
            {
                System.out.println(node.getInfo());
                node = node.getLink();
            }
            else
            {
                node = node.getLink();
            }
        }
    }
    
    public void printTxt()
    // this allow the user to save the add or remove patient after the user quit the program
    {
        LLNode<T> patientNode = list;
        String newPatientName = null;
        String newPatientID = null;
        String newPatientAddress = null;
        Date newPatientDOB = null;
        Date newInitialVisit = null;
        Date newLastVisit = null;
        double newPatientHeight = 0;
        double newPatientWeight = 0;
        
        //System.out.println("Please Enter the file name that you want to Open.");
        //System.out.print("File Name:");
        //Scanner input = new Scanner(System.in);
        //String fileName = input.next();
        PrintWriter writer = null;
        try
        {
            FileWriter fw = new FileWriter("test.txt", true);
            writer =new PrintWriter(fw);
        } 
        catch (FileNotFoundException e) {
            System.out.println("Unable to find the file.");
            System.exit(0);
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }
        writer.println("------------new add Patient----------");
        System.out.println("Data stores in " + "test.txt" + "file.");
        while(patientNode != null)
        {
            newPatientName = ((Patient)patientNode.getInfo()).patientName;
            newPatientID = ((Patient)patientNode.getInfo()).patientID;
            newPatientAddress = ((Patient)patientNode.getInfo()).patientAddress;
            newPatientHeight = ((Patient)patientNode.getInfo()).height;
            newPatientWeight = ((Patient)patientNode.getInfo()).weight;
            newInitialVisit = ((Patient)patientNode.getInfo()).div;
            newLastVisit = ((Patient)patientNode.getInfo()).dlv;
            writer.println(newPatientName);
            writer.println(newPatientID);
            writer.println(newPatientAddress);
            writer.println(newPatientHeight);
            writer.println(newPatientWeight);
            writer.println(newInitialVisit);
            writer.println(newLastVisit);
            patientNode = patientNode.getLink();
        }
            writer.close();
    }
}
    
