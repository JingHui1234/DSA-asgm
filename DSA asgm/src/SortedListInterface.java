/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Quah Tze Wei
 */
public interface SortedListInterface<T extends Comparable<T>> {
    
    public boolean add(T newEntry);
    
    public boolean remove(T anEntry);
    
    public boolean contains(T anEntry);
    
    public void clear();
    
    public int getLength();
    
    public boolean isEmpty();
    
    public boolean isFull();
    
    public T getEntry(int givenPosition);
    
}
