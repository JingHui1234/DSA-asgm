package adt;

import java.io.Serializable;

/**
 *
 * @author Jing Hui
 */
public class DLList<T> implements DLListInterface<T>, Serializable {

    private Node firstNode;
    private Node lastNode;
    private int numOfEntries;

    public DLList() {
        clear();
    }

    private class Node implements Serializable {

        private T data;
        private Node next;
        private Node previous;

        private Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        private Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    @Override
    public void add(T newEntry) {
        // create the new node for the new entry
        Node newNode = new Node(newEntry);

        // if the list is empty, newNode is the first node and lastnode
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.previous = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
        }
        numOfEntries++;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean addSuccessful = true;
        Node newNode = new Node(newEntry);

        if (newPosition >= 1 && newPosition <= numOfEntries + 1) {
            Node nodeBefore = firstNode;

            if (isEmpty() || newPosition == 1) {  // add to the first node
                newNode.next = firstNode;
                firstNode.previous = newNode;
                firstNode = newNode;
            } else {
                for (int i = 1; i < newPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;
                }
                newNode.previous = nodeBefore;
                nodeBefore.next.previous = newNode;
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;

                // if the current node is last node
                if (nodeBefore.next == null) {
                    lastNode = newNode;
                }
            }
            numOfEntries++;
        } else {
            addSuccessful = false;
        }
        return addSuccessful;
    }

    @Override
    public void addFirst(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.next = firstNode;
            firstNode.previous = newNode;
            firstNode = newNode;
        }
        numOfEntries++;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if (givenPosition >= 1 && givenPosition <= numOfEntries) {
            if (givenPosition == 1) {  // delete first entry
                result = firstNode.data;
                firstNode = firstNode.next;

                // if there is only one entry and is deleted, set lastNode to null
                if (firstNode == null) {
                    lastNode = null;
                } else {
                    firstNode.previous = null;
                }

            } else if (givenPosition == numOfEntries) {  // delete last entry
                result = lastNode.data;
                lastNode = lastNode.previous;
                lastNode.next = null;

            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;
                }

                // nodeBefore pointing to the node before givenPosition
                result = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
                nodeBefore.next.previous = nodeBefore;

            }
            numOfEntries--;
        }

        return result;
    }

    @Override
    public T removeLast() {
        T result = null;

        if (!isEmpty()) {
            result = lastNode.data;
            lastNode = lastNode.previous;

            if (lastNode == null) {
                firstNode = null;
            } else {
                lastNode.next = null;
            }

            numOfEntries--;
        }

        return result;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        numOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if (givenPosition >= 1 && givenPosition <= numOfEntries) {
            Node currentNode = firstNode;

            for (int i = 1; i < givenPosition; i++) {
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T resultEntry = null;

        if (givenPosition >= 1 && givenPosition <= numOfEntries) {
            Node currentNode = firstNode;
            for (int i = 1; i < givenPosition; i++) {
                currentNode = currentNode.next;
            }

            resultEntry = currentNode.data;
        }
        return resultEntry;
    }

    @Override
    public T poll() {
        T result = null;

        if (!isEmpty()) {
            result = firstNode.data;
            firstNode = firstNode.next;

            // if there is no entry after polled, set lastNode to null
            if (firstNode == null) {
                lastNode = null;
            } else {
                firstNode.previous = null;
            }

            numOfEntries--;
        }

        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        Node currentNode = firstNode;

        while (currentNode != null) {
            if (anEntry.equals(currentNode.data)) {
                return true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return numOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getPosition(T anEntry) {
        Node currentNode = firstNode;
        int position = 1;

        while (currentNode != null) {
            if (anEntry.equals(currentNode.data)) {
                return position;
            } else {
                currentNode = currentNode.next;
                position++;
            }
        }
        return -1; // given entry not found in the list
    }

    @Override
    public String displayBackward() {
        String outputStr = "";
        int number = 1;
        Node currentNode = lastNode;

        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.previous;
        }
        return outputStr;
    }

    @Override
    public String toString() {
        String outputStr = "";
        int number = 1;
        Node currentNode = firstNode;

        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return outputStr;
    }

}
