

/**
 *
 * @author Ang Chia Ling
 */
public interface ListInterface<T> {

    // insert new element at the back of arraylist
    public boolean insert(T entry);

    // insert new element at the specific position
    public boolean insert(int position, T entry);

    // remove element at the specific position
    public boolean remove(int position);

    // replace the element with a new entry at the specific position
    public boolean replace(int position, T entry);

    // clear all the elements in the arraylist
    public void clear();

    // retrieve the element at the specific position
    public T getEntry(int position);

    // check whether the elements is duplicated with the elements in array list
    public boolean isDuplicated(T entry);

    // check the size of the array list
    public int length();

    // check whether the arraylist is empty or not
    public boolean isEmpty();

    // check whether the arraylist is full or not
    public boolean isFull();

    // move the entry provided to the beginning of the arraylist
    public boolean moveToStart(T entry);

    // move the entry provided to the end of the arraylist
    public boolean moveToEnd(T entry);

    // move the entry to the specific position
    public boolean move(int position, T entry);
}
