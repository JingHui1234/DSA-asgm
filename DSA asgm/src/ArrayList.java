

import java.io.Serializable;

/**
 *
 * @author Ang Chia Ling
 */
public class ArrayList<T> implements ListInterface<T>, Serializable {

    private T[] array;
    private int length;
    private static final int DEFAULT_INITIAL_SIZE = 10;

    // constructor
    public ArrayList() {
        this(DEFAULT_INITIAL_SIZE);
    }

    public ArrayList(int initialSize) {
        length = 0;
        array = (T[]) new Object[initialSize];
    }

    // ADT implementation
    @Override
    public boolean insert(T entry) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(entry)) {
                return false;
            }
        }

        if (isArrayFull()) {
            incSize();
        }

        array[length] = entry;
        length++;
        return true;
    }

    // if the arraylist is full then double up the array
    public void incSize() {
        T[] oldArr = array;
        array = (T[]) new Object[2 * oldArr.length];
        for (int i = 0; i < length; i++) {
            array[i] = oldArr[i];
        }
    }

    // check whether the array list is full or not
    private boolean isArrayFull() {
        return length == array.length;
    }

    @Override
    public boolean insert(int position, T entry) {
        boolean successful = true;

        for (int i = 0; i < length; i++) {
            if (array[i].equals(entry)) {
                successful = false;
            }
        }

        if ((position >= 1) && (position <= length + 1)) {
            if (isArrayFull()) {
                incSize();
            }
            makeRoom(position);
            array[position - 1] = entry;
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
            array[index + 1] = array[index];
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

    // remove the gap of the arraylist after removing an element from the arraylist
    private void removeGap(int position) {
        int removedIndex = position - 1;
        int lastIndex = length - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public T getEntry(int position) {
        T output = null;
        if ((position >= 1) && (position <= length)) {
            output = array[position - 1];
        }
        return output;
    }

    @Override
    public boolean isDuplicated(T entry) {
        boolean successful = false;
        for (int i = 0; i < length; i++) {
            if (entry.equals(array[i])) {
                successful = true;
            }
        }
        return successful;
    }

    // retrive the size of the arraylist
    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean moveToStart(T entry) {
        T[] newArr = array.clone();
        boolean found = false;
        boolean successful = false;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (array[i].equals(entry)) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            T content = array[index];
            for (int i = index; i > 0; i--) {
                newArr[i] = array[i - 1];
            }
            array = newArr;
            array[0] = content;
            successful = true;
        }
        return successful;
    }

    @Override
    public boolean moveToEnd(T entry) {
        T[] newArr = array.clone();
        boolean found = false;
        boolean successful = false;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (array[i].equals(entry)) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            T content = array[index];
            for (int i = index; i < length; i++) {
                newArr[i] = array[i + 1];
            }
            array = newArr;
            array[length - 1] = content;
            successful = true;
        }
        return successful;
    }

    @Override
    public boolean move(int position, T entry) {
        T[] newArr = array.clone();
        boolean found = false;
        boolean successful = false;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (array[i].equals(entry)) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            T content = array[index];

            if (index > position) {
                for (int i = index; i >= position; i--) {
                    newArr[i] = array[i - 1];
                }
            } else if (index < position) {
                for (int i = index; i < position; i++) {
                    newArr[i] = array[i + 1];
                }
            }

            array = newArr;
            array[position - 1] = content;
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
            outputStr += array[i] + "\n";
        }
        return outputStr;
    }

    @Override
    public boolean replace(int position, T entry) {
        if ((position >= 1) && (position <= length)) {
            array[position - 1] = entry;
        } else {
            return false;
        }
        return true;
    }
}
