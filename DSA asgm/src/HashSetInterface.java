/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Msi
 */
public interface HashSetInterface<E> {

    public boolean insert(E entry);
    public boolean insert(int position, E entry);
    public boolean remove(int position);
    public boolean replace(int position, E entry);
    public void clear();
    public E getEntry(int position);
    public boolean isDuplicated(E entry);
    public int length();
    public boolean isEmpty();
    public boolean isFull();
    public void incSize();
    public boolean moveToStart(E entry);
    public boolean moveToEnd(E entry);
    public boolean move(int position, E entry);  
    
}
