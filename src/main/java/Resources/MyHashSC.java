package Resources;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyHashSC<E> {
    private List<E>[] hashTable;

    public MyHashSC(int size){
        hashTable= (List<E>[]) new List [size];

//        for(int i=0;i<hashTable.length;i++)
//            hashTable[i]=new LinkedList<>();
    }

    public void displayHashTable() {
        System.out.println("Hash Table (using Separate Chaining)\n======================");
        for(int i=0;i<hashTable.length;i++) {
            System.out.println("\nChain "+i+"\n------------");
            for(E e : hashTable[i])
                System.out.println(e);
        }
    }

    public int hashFunction(int key) {
        return key%hashTable.length;
    }

    public int add(E item, int key) {
        hashTable[key].add(item);
        return key;
    }

    public int add(E item) {
        int home = hashFunction(Math.abs(item.hashCode()));
        hashTable[home].add(item);
        return home;
    }


    public List<E> get(int key){
        return hashTable[key];
    }


//    public static void main(String[] args) {
//        MyHashSC<String> h=new MyHashSC<>(7);
//        Scanner k=new Scanner(System.in);
//        String data;
//
//        do {
//            System.out.print("Enter value: ");
//            data=k.nextLine();
//            if(data.length()>0) {
//                int loc=h.add(data);
//                if(loc!=-1) System.out.println("Item "+data+" stored at location "+loc);
//                else System.out.println("Error. Cannot store "+data+". Table is full.");
//            }
//        }while(data.length()>0);
//
//        h.displayHashTable();
//    }
}
