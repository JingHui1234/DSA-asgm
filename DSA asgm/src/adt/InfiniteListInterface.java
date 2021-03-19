package adt;

/**
 *
 * @author Jing Hui
 */
public interface InfiniteListInterface <T> {
    
  public void add(T newEntry);
  
  public boolean add(int addPosition, T newEntry);
   
  public void addFirst(T newEntry);
    
  public T remove(int givenPosition);
  
  public T removeLast();
   
  public void clear();
  
  public boolean replace(int givenPosition, T newEntry);

  public T getEntry(int givenPosition);
  
  public T poll();

  public boolean contains(T anEntry);
  
  public int size();

  public boolean isEmpty();

  public boolean isFull();
  
  public int getPosition(T anEntry);
    
  public String displayBackward();
}
