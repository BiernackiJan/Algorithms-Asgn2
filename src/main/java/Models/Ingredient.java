package Models;

public class Ingredient {
    private String ingName;
    private String ingDes;
    private float calories;
    private float amount;
    private float kcal;

    public Ingredient(String n, String d, float c, float a) {
        this.ingName = n;
        this.ingDes = d;
        this.calories = c;
        this.amount = a;
        this.kcal = calculateKcal(1);
    }

    public Ingredient(String n,String d,float calories){
        this.ingName = n;
        this.ingDes = d;
        this.kcal = calories;
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

    public float getKcal() { return kcal; }

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

    public float calculateKcal(float per){
        kcal = calories/amount;
        return kcal*per;
    }



    public String toString1() {
        return  "  " + ingName + ",  " + ingDes +
                "  " + kcal + "kcal " + '\n' ;
    }

    @Override
    public String toString() {
        return  "  " + ingName + ",  " + ingDes +
                "  " + kcal*100 + "kcal per 100g" + '\n' ;
    }

}
