package Resources;
import java.util.Scanner;

public class HashTable {
    private int[] hashTable;

    public HashTable(int size){
        hashTable=new int [size];
    }

    public void displayHashTable() {
        System.out.println("Hash Table (using Linear Probing)\n======================");
        for(int i=0;i<hashTable.length;i++)
            System.out.println(i+". "+hashTable[i]);
    }

    public int hashFunction(int key) {
        return key%hashTable.length;
    }

    public int get(int key){
        int index = hashFunction(key);
        return hashTable[index];
    }

    public int add(int item) {
        int home = hashFunction(item),loc=home;

        do {
            if(hashTable[loc]==0) //Slot is free
            {
                hashTable[loc]=item;
                return loc;
            }
            else { //Collision resolution
                loc=(loc+1)%hashTable.length; //Probe ahead by 1 with wraparound
                System.out.println("Collision.  Probing location "+loc+"...");
            }

        }while(loc!=home); //While not returned to original home (i.e. hash table is full)
        return -1; //Hash table is full
    }

    public int add(int item, int location) {
        int it = hashFunction(item);
        int home = hashFunction(location),loc=home;

        do {
            if(hashTable[loc]==0) //Slot is free
            {
                hashTable[loc]=it;
                return loc;
            }
            else { //Collision resolution
                loc=(loc+1)%hashTable.length; //Probe ahead by 1 with wraparound
                System.out.println("Collision.  Probing location "+loc+"...");
            }

        }while(loc!=home); //While not returned to original home (i.e. hash table is full)
        return -1; //Hash table is full
    }

}
