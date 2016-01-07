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
public class LLNode<T> 
{
    private LLNode link;
    private T info;
    
    public LLNode(T info)
    {
        this.info = info;
        link = null;
    }
    
    public void setInfo(T info)
    {
        this.info= info;
    }
    public T getInfo()
    {
        return info;
    }
    
    public void setLink(LLNode link)
    {
        this.link = link;
    }
    public LLNode getLink()
    {
        return link;
    }
}
