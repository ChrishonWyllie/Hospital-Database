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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Patient {
    
    protected String patientName;
    protected String patientID ;
    protected String patientAddr;
    protected int height = 0;
    protected double weight = 0;
    protected Date dob;
    protected Date firstVisit;
    protected Date lastVisit;
    protected boolean ofv;
    protected hospitaldatabase2.LLNode<Patient> list;
    
    public Patient(String patientID)
    {
        this.patientID = patientID;
    }
    
     public Patient(String patientName, String patientID, String patientAddr, int height, double weight, String dob, String firstVisist, String lastVisit)
             // basic constructor
    {
        SimpleDateFormat DateFormat = new SimpleDateFormat("MM-DD-YYYY");
        
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientAddr = patientAddr;
        this.height = height;
        this.weight = weight;
        try { //to throw ParseException if Date is wrong.
            this.dob = DateFormat.parse(dob);
            this.firstVisit = DateFormat.parse(firstVisit);
            this.lastVisit = DateFormat.parse(lastVisit);
        } catch (ParseException e) {
        }
    }// end of consturctor
     
     public void setPatientName(String patientName) 
    {
        this.patientName = patientName;
    }
    
    public String getPatientName()
    {
        return patientName;
    }
    
    public void setPatientID(String patientID)
    {
        this.patientID = patientID;
    }
    
    public String getPatientID()
    {
        return patientID;
    }
    
    public void setPatientAddress(String patientAddress)
    {
        this.patientAddress = patientAddress;
    }
    
    public String getPatientAddress()
    {
        return patientAddress;
    }    
    
    public int feet(){
        return height /12;
    }
    
    public int inches()
    {
        return height%12;
    }
    
    public void setHeight(int height)
    {
        this.height= height;
    }
    
    public String getHeight()
    {
        return(feet() + "ft" + " " + inches() + "in.");
    }
    
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    
    public double getWeigth()
    {
        return weight;
    }
    
    
    public void setDOB(Date dob)
    {
        this.dob= dob;
    }
    public Date getDOB()
    {
        return dob;
    }
    
    public void setDiv(Date div)
    {
        this.div= div;
    }
    public Date getDiv()
    {
        return div;
    }
    
    public void setDlv(Date dlv)
    {
        this.dlv=dlv;
    }
    public Date getDlv()
    {
        return dlv;
    }
    
    public int getAge()
    {
        Calendar dateCalendar = Calendar.getInstance();
        int newMonth = dateCalendar.get(Calendar.MONTH)+1;
        int newDay = dateCalendar.get(Calendar.DATE);
        int newYear= dateCalendar.get(Calendar.YEAR);
        
        return newYear - dob.getYear();
    }
    
    public int yearasPatient()
    {
        Calendar dateCalendar = Calendar.getInstance();
        int newMonth = dateCalendar.get(Calendar.MONTH)+1;
        int newDay = dateCalendar.get(Calendar.DATE);
        int newYear= dateCalendar.get(Calendar.YEAR);
        
      return 1;
       // return newYear - div.getYear() - 1990 + 1;
    
    }
    
    public int LastVisit()
    {
        SimpleDateFormat DateFormat = new SimpleDateFormat("MM-DD-YYYY");
        Calendar dateCalendar = Calendar.getInstance();
        int newMonth = dateCalendar.get(Calendar.MONTH)+1;
        int newDay = dateCalendar.get(Calendar.DATE);
        int newYear= dateCalendar.get(Calendar.YEAR);
        
        return 1;
    }
    
    public String overdue()
    {
        int overDue = 3;
        
        if (LastVisit()> 3)
        {
            return "This Patient needs to Come visit.";
        }
        else
        {
            return "No action need to tacken.";
        }
    }
    
    public String patientToString()
            // for option 1 display.
    {
        return patientName + patientID;
    }
    
    public String toString()
            //the formatt that show on the txt file.
    {
        return ("Patient Information:\n\n Patient Name: "+ patientName + "\n Patient ID: " 
                + patientID + "\n Address:"+ patientAddress +"\n Date of Birth: "+ dob
                + "\n Height: "+ feet()+ "ft." + inches()+ "in." +"\n Weight: "+ weight + "lbs."
                + "\n Number of years as a patient:"+ yearasPatient() +
                "\n Number of years scince last vist" + LastVisit() + "\n" +
                overdue());
    }
}
