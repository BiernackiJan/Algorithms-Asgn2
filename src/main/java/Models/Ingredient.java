package Models;

public class Ingredient {
    private String ingName;
    private String ingDes;
    private int calories;
    private int amount;
    private int kcal;

    public Ingredient(String n, String d, int c, int a) {
        this.ingName = n;
        this.ingDes = d;
        this.calories = c;
        this.amount = a;
    }

    public Ingredient(String n,String d,int kcal){
        this.ingName = n;
        this.ingDes = d;
        this.kcal = kcal;
    }
    //Getters-----------------------------------------------------
    public String getIngName() {
        return ingName;
    }

    public String getIngDes() {
        return ingDes;
    }

    public float getCalories() {
        return calories;
    }

    public float getAmount() {
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

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //Methods--------------------------------------------------

    public int calculateKcal(int per){
        int kcalPer1g = calories/amount;
        return kcalPer1g*per;
    }


    @Override
    public String toString() {
        return  "  " + ingName + ",  " + ingDes +
                "  " + calculateKcal(100) + "kcal per 100g" + '\n' ;
    }
}
