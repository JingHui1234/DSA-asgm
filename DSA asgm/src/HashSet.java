/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author Msi
 */
public class HashSet<E> implements HashSetInterface<E>, Serializable{
    
    private E[] set;
    private int length;
 
    public HashSet(){
        
    }
    
    public HashSet(int initialSize) {
        length = 0;
        set = (E[]) new Object[initialSize];
    }
    
    // ADT implementation
    @Override
    public boolean insert(E entry) {
        for (int i = 0; i < length; i++) {
            if (set[i].equals(entry)) {
                return false;
            }
        }

        if (isSetFull()) {
            incSize();
        }

        set[length] = entry;
        length++;
        return true;
    }

    public void incSize() {
        E[] oldSet = set;
        set = (E[]) new Object[2 * oldSet.length];
        for (int i = 0; i < length; i++) {
            set[i] = oldSet[i];
        }
    }

    private boolean isSetFull() {
        return length == set.length;
    }

    @Override
    public boolean insert(int position, E entry) {
        boolean successful = true;

        for (int i = 0; i < length; i++) {
            if (set[i].equals(entry)) {
                successful = false;
            }
        }

        if ((position >= 1) && (position <= length + 1)) {
            if (isSetFull()) {
                incSize();
            }
            makeRoom(position);
            set[position - 1] = entry;
            length++;
        } else {
            successful = false;
        }
        return successful;
    }

    private void makeRoom(int position) {
        int newIndex = position - 1;
        int lastIndex = length - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            set[index + 1] = set[index];
        }
    }

    @Override
    public boolean remove(int position) {
        boolean successful = false;
        if ((position >= 1) && (position <= length)) {
            if (position < length) {
                removeGap(position);
            }
            length--;
            successful = true;
        }
        return successful;
    }

    private void removeGap(int position) {
        int removedIndex = position - 1;
        int lastIndex = length - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            set[index] = set[index + 1];
        }
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public E getEntry(int position) {
        E output = null;
        if ((position >= 1) && (position <= length)) {
            output = set[position - 1];
        }
        return output;
    }

    @Override
    public boolean isDuplicated(E entry) {
        boolean successful = false;
        for (int i = 0; i < length; i++) {
            if (entry.equals(set[i])) {
                successful = true;
            }
        }
        return successful;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean moveToStart(E entry) {
        E[] newArr = set.clone();
        boolean found = false;
        boolean successful = false;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (set[i].equals(entry)) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            E content = set[index];
            for (int i = index; i > 0; i--) {
                newArr[i] = set[i - 1];
            }
            set = newArr;
            set[0] = content;
            successful = true;
        }
        return successful;
    }

    @Override
    public boolean moveToEnd(E entry) {
        E[] newArr = set.clone();
        boolean found = false;
        boolean successful = false;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (set[i].equals(entry)) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            E content = set[index];
            for (int i = index; i < length; i++) {
                newArr[i] = set[i + 1];
            }
            set = newArr;
            set[length - 1] = content;
            successful = true;
        }
        return successful;
    }

    @Override
    public boolean move(int position, E entry) {
        E[] newArr = set.clone();
        boolean found = false;
        boolean successful = false;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (set[i].equals(entry)) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            E content = set[index];

            if (index > position) {
                for (int i = index; i >= position; i--) {
                    newArr[i] = set[i - 1];
                }
            } else if (index < position) {
                for (int i = index; i < position; i++) {
                    newArr[i] = set[i + 1];
                }
            }

            set = newArr;
            set[position - 1] = content;
            successful = true;
        }
        return successful;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int i = 0; i < length; i++) {
            outputStr += set[i] + "\n";
        }
        return outputStr;
    }

    @Override
    public boolean replace(int position, E entry) {
        if ((position >= 1) && (position <= length)) {
            set[position - 1] = entry;
        } else {
            return false;
        }
        return true;
    }
    
}
