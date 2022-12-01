package Models;

public class Ingredient {
    private String ingName;
    private String ingDes;
    private int calories;
    private String amount;

    public Ingredient(String n, String d, int c, String a) {
        this.ingName = n;
        this.ingDes = d;
        this.calories = c;
        this.amount = a;
    }
    //Getters-----------------------------------------------------
    public String getIngName() {
        return ingName;
    }

    public String getIngDes() {
        return ingDes;
    }

    public int getCalories() {
        return calories;
    }

    public String getAmount() {
        return amount;
    }

    //Setters------------------------------------------------------
    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public void setIngDes(String ingDes) {
        this.ingDes = ingDes;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    //Methods--------------------------------------------------

    @Override
    public String toString() {
        return  "  " + ingName + ",  " + ingDes +
                "  Calories: " + calories + " Amount needed: " + amount + '\n' ;
    }
}
