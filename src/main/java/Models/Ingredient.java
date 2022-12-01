package Models;

public class Ingredient {
    private String ingName;
    private String ingDes;
    private float calories;
    private float amount;

    public Ingredient(String n, String d, float c, float a) {
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

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    //Methods--------------------------------------------------

    public void calculateKcal(float per){
        float kcalPer1g = calories/amount;
    }


    @Override
    public String toString() {
        return  "  " + ingName + ",  " + ingDes +
                "  Calories: " + calories + " Amount needed: " + amount + '\n' ;
    }
}
