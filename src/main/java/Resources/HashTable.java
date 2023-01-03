package Resources;
import java.util.Scanner;

public class HashTable<E> {
    private int[] hashTable;

    public HashTable(int size) {
        hashTable = new int[size];
    }

    public int hashFunction(int key) {
        return key % (hashTable.length);
    }

    public int get(int key) {
        int index = Math.abs(hashFunction(key));
        return hashTable[index];
    }

    public int add(int item, int location) { //add item to hash table at selected location
        int it = hashFunction(item);
        int home = hashFunction(location), loc = home;

        do {
            if (hashTable[loc] == 0) //Slot is free
            {
                hashTable[loc] = it;
                return loc;
            } else { //Collision resolution
                loc = (loc + 1) % hashTable.length; //Probe ahead by 1 with wraparound
                System.out.println("Collision.  Probing location " + loc + "...");
            }

        } while (loc != home); //While not returned to original home (i.e. hash table is full)
        return -1; //Hash table is full
    }

    public void displayHashTable() {
        System.out.println("Hash Table (using Separate Chaining)\n======================");
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("\nChain " + i + "\n------------");
            for (int k : hashTable) {
                System.out.println(k);
            }
        }
    }
}
