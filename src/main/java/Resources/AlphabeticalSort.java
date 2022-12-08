package Resources;

public class AlphabeticalSort {
    public static LinkedList<Object> sort = new LinkedList<>();

    public static void sortAlphabetically(String firstLetters, Object item) {
        int hash = firstLetters.hashCode();
        if (sort == null) {
            sort.add(item);
        } else {
            if (((Sort) sort.get(0)).getHashValue() >= hash) {
                sort.addAtIndex(item, 0);
            }
            if (sort.numNodes() > 3) {
                for (int i = 0; i < sort.numNodes(); i++) {
                    if (((Sort) sort.get(i)).getHashValue() >= hash && ((Sort) sort.get(i--)).getHashValue() <= hash) {
                        sort.addAtIndex(item, i);
                    }
                }
            } else {
                sort.add(item);
            }
        }
    }

}
