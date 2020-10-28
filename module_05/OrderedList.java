package module_05;

import module_03.BinarySearch;

import java.util.Arrays;

public class OrderedList {

    private static final int INITIAL_CAPACITY = 10;
    private int[] orderedList;
    private int numberOfValues;

    public OrderedList() {
        this.orderedList = new int[INITIAL_CAPACITY];
        numberOfValues = 0;
    }

    public void insert(Integer element) {
        if(element == null)
            return;
        if(numberOfValues == orderedList.length)
            increaseArray();
        for(int i=0; i<orderedList.length; i++) {
            if(orderedList[i] > element || i >= numberOfValues) {
                //shift right of the elements
                for(int j=numberOfValues; j>i; j--){
                    orderedList[j] = orderedList[j-1];
                }
                orderedList[i] = element;
                numberOfValues++;
                break;
            }
        }
    }

    private void increaseArray() {
        int[] increasedList = new int[orderedList.length * 2];
        for(int i=0; i<orderedList.length; i++) {
            increasedList[i] = orderedList[i];
        }
        orderedList = increasedList;
    }

    public int indexOf(int element) {
        return binarySearchRecursive(orderedList, 0, numberOfValues, element);
    }

    private static int binarySearchRecursive(int[] values, int begin, int end, int n) {
        if(values[(begin+end)/2] == n)
            return (begin+end)/2;
        if(begin>=end) //not found
            return -1;
        if(values[(begin+end)/2] > n)
            return binarySearchRecursive(values, begin, (begin+end)/2-1, n);
        return binarySearchRecursive(values, (begin+end)/2+1, end, n);

    }

    private int[] cleanArray() {
        int[] cleanList = new int[numberOfValues];
        for(int i=0; i<numberOfValues; i++) {
            cleanList[i] = orderedList[i];
        }
        return cleanList;
    }

    public void remove(Integer element) {
        if(element == null)
            return;
        for(int i=0; i<orderedList.length; i++) {
            if(orderedList[i] == element) {
                //shift left of the elements
                for(int j=0; j<numberOfValues; j++){
                    orderedList[j] = orderedList[j+1];
                }
                orderedList[i] = element;
                numberOfValues--;
                decreaseArray();
                break;
            }
        }
    }

    private void decreaseArray() {
        int[] decreasedList = new int[numberOfValues];
        for(int i=0; i<numberOfValues; i++) {
            decreasedList[i] = orderedList[i];
        }
        orderedList = decreasedList;
    }

    @Override
    public String toString() {
        return Arrays.toString(cleanArray());
    }

    public static void main(String[] args) {
        OrderedList orderedList = new OrderedList();
        orderedList.insert(1);
        orderedList.insert(2);
        orderedList.insert(100);
        orderedList.insert(10);
        orderedList.insert(5);
        orderedList.insert(0);
        orderedList.insert(1);
        orderedList.insert(11);
        orderedList.insert(200);
        orderedList.insert(1);
        orderedList.insert(2);
        orderedList.insert(-10);
        orderedList.insert(-5);
        orderedList.insert(0);
        orderedList.insert(-1);
        orderedList.insert(11);
        orderedList.insert(-200);
        System.out.println(orderedList.indexOf(100) == 15);
        System.out.println(orderedList.indexOf(-200) == 0);
        System.out.println(orderedList.indexOf(200) == 16);
        orderedList.remove(12); //not present
        System.out.println(orderedList.indexOf(200) == 16);
        orderedList.remove(11);
        System.out.println(orderedList.indexOf(200) == 15);
    }
}
