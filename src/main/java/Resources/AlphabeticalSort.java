package Resources;

public class AlphabeticalSort {
    public static LinkedList<Object> sort = new LinkedList<>();

    public static void sortAlphabetically(String firstLetters, Object item) {
        //System.out.println(sort.numNodes());
        int hash = firstLetters.hashCode();
        Object srt = new Sort(hash,item);
        if (sort.getHead() == null) {
            sort.add(srt);
            //System.out.println(sort.listAll());
        } else {
            if (((Sort) sort.get(0)).getHashValue() >= hash) {
                sort.addAtIndex(srt, 0);
            }
            if (sort.numNodes() > 3) {
                for (int i = 0; i < sort.numNodes(); i++) {
                    if (((Sort) sort.get(i)).getHashValue() >= hash && ((Sort) sort.get(i--)).getHashValue() <= hash) {
                        sort.addAtIndex(srt, i);
                    }
                }
            } else {
                sort.add(srt);
            }
        }
        //System.out.println(sort.listAll());
    }

    public static void resetSortLL(){
        sort.delAll();
    }

}
