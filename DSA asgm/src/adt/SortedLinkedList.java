package adt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author Quah Tze Wei
 */
public class SortedLinkedList<T extends Comparable<T>> implements SortedListInterface<T>, Serializable {
    
    private Node firstNode;
    private int length;
    
    public SortedLinkedList() {
        firstNode = null;
        length = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        Node nodeBefore = null; 
        Node currentNode = firstNode;   
        while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
            nodeBefore = currentNode;
            currentNode = currentNode.next;
        }

        if (isEmpty() || (nodeBefore == null)) { 
            newNode.next = firstNode;
            firstNode = newNode;
        } else {
            newNode.next = currentNode;
            nodeBefore.next = newNode;
        }
        length++;
        return true;
    }

    @Override
    public boolean remove(T anEntry) {
        if (!isEmpty()){
            Node previousNode = null;
            Node currentNode = firstNode;
            while (currentNode != null && currentNode.data.compareTo(anEntry) < 0){
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode != null && currentNode.data.equals(anEntry)){
                if (currentNode == firstNode)
                    firstNode = firstNode.next;
                else
                    previousNode.next = currentNode.next;
                length--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node tempNode = firstNode;
        int pos = 1;

        while (!found && (tempNode != null)) {
            if (anEntry.compareTo(tempNode.data) <= 0) {
                found = true;
            } else {
                tempNode = tempNode.next;
                pos++;
            }
        }
        if (tempNode != null && tempNode.data.equals(anEntry)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        firstNode = null;
        length = 0;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return(length == 0);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        
        if ((givenPosition >= 1) && (givenPosition <= length)) {
            Node currentNode = firstNode;
     
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;	
            }
        
            result = currentNode.data;
        }
        return result;
    }
    
    

    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return outputStr;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }   
}
