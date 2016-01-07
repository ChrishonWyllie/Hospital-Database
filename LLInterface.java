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
public interface LLinterface<T>
{
    int size();
    //This method returns the size of the elements in the list.
    
    void add(T element);
    //This method adds the patient element into the list.
    
    boolean contains (T element);
    //This method returns true if this list holds the element of the parameter and false if it does not.
    
    boolean remove (T element);
    //This method removes the elment from the list and then returns true. If the element does not exist, it returns false instead.
    
    T get(T element);
    //This method returns the element in the list that matches the one in the parameter. If the element cannot be found, it returns null.
    
    String toString();
    //This method returns a the elements of the list in a proper format.
    
    void reset();
    //This method resets all the elements in the list to null
    
    T getNext();
    //This method returns the element at the current index of the list. if the current index is the last element, then it references the value 
    //of the current index to the first elemnt. In any other case, it references the next element.
}
