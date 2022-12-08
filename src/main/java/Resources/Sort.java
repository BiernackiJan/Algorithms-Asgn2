package Resources;

public class Sort {

    private int hashValue;
    private Object item;

    public Sort(int hashValue,Object item) {
        this.hashValue = hashValue;
        this.item = item;
    }

    public int getHashValue() {
        return hashValue;
    }

    @Override
    public String toString() {
        return item + "";
    }
}
