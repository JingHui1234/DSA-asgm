


import adt.ArrayList;
import adt.ListInterface;

/**
 *
 * @author Ang Chia Ling
 */
public class testArrayList {
    public static void main(String[] args) {
        ListInterface<Integer> numList = new ArrayList<>();
        
        System.out.println("Add 10: " + numList.insert(10));
        System.out.println("Add 20: " + numList.insert(20));
        System.out.println("Add 30: " + numList.insert(30));
        System.out.println("Add 40: " + numList.insert(40));
        System.out.println("Add 50: " + numList.insert(50));
        System.out.println("Add 60: " + numList.insert(60));
        System.out.println("Add 70: " + numList.insert(70));
        System.out.println("Add 80: " + numList.insert(80));
        System.out.println("Add 90: " + numList.insert(90));
        System.out.println("Add 100: " + numList.insert(100));
        System.out.println("Add 110: " + numList.insert(110));
        System.out.println("Add 120: " + numList.insert(120));
        System.out.println("Add 130: " + numList.insert(130));
        System.out.println("Add 140: " + numList.insert(140));
        System.out.println("Add 150: " + numList.insert(150));
        
        System.out.println("Add 25 at position 2: "+ numList.insert(2,25));
        System.out.println("Add 35 at position 20: "+ numList.insert(20,35));
        System.out.println("Add 45 at position 40: "+ numList.insert(45,40));
        
        System.out.println("Remove out of position: " + numList.remove(300));
        System.out.println("Remove 30: " + numList.remove(3));
        
        numList.clear();
        System.out.println("Cleared arraylist: " + numList);
        
        System.out.println("Add 10: " + numList.insert(10));
        System.out.println("Add 20: " + numList.insert(20));
        System.out.println("Add 30: " + numList.insert(30));
        System.out.println("Add 40: " + numList.insert(40));
        System.out.println("Add 50: " + numList.insert(50));
        System.out.println("Add 60: " + numList.insert(60));
        System.out.println("Add 70: " + numList.insert(70));
        System.out.println("Add 80: " + numList.insert(80));
        System.out.println("Add 90: " + numList.insert(90));
        System.out.println("Add 100: " + numList.insert(100));
        
        System.out.println("Get Entry for postion 10: " + numList.getEntry(10));
        System.out.println("Get Entry for postion 3: " + numList.getEntry(3));
        
        System.out.println("Is Duplicated: " + numList.isDuplicated(10));
        System.out.println("Is Duplicated: " + numList.isDuplicated(200));
        System.out.println("Is Duplicated: " + numList.isDuplicated(10));
        System.out.println("Is Duplicated: " + numList.isDuplicated(200));
        System.out.println("Is Duplicated: " + numList.isDuplicated(200));
        
        System.out.println(numList);
        System.out.println("Move 200 to start: " + numList.moveToStart(200));
        System.out.println(numList);
        System.out.println("Move 20 to start: " + numList.moveToStart(20));
        System.out.println(numList);
        System.out.println("Move 10 to start: " + numList.moveToStart(10));
        
        System.out.println(numList);
        System.out.println("Move 30 to end: " + numList.moveToEnd(30));
        System.out.println(numList);
        System.out.println("Move 20 to end: " + numList.moveToEnd(20));
        System.out.println(numList);
        System.out.println("Move 300 to end: " + numList.moveToEnd(300));
        System.out.println(numList);
        
        numList.clear();
        System.out.println("Add 10: " + numList.insert(10));
        System.out.println("Add 20: " + numList.insert(20));
        System.out.println("Add 30: " + numList.insert(30));
        System.out.println("Add 40: " + numList.insert(40));
        System.out.println("Add 50: " + numList.insert(50));
        System.out.println("Add 60: " + numList.insert(60));
        System.out.println("Add 70: " + numList.insert(70));
        System.out.println("Add 80: " + numList.insert(80));
        System.out.println("Add 90: " + numList.insert(90));
        System.out.println("Add 100: " + numList.insert(100));
        System.out.println("Move 40 to position 2: " + numList.move(2,40));
        System.out.println(numList);
        System.out.println("Move 40 to position 4: " + numList.move(4,40));
        System.out.println(numList);
        System.out.println("Move 10 to position 4: " + numList.move(4,10));
        System.out.println(numList);
        
        
    }
}
