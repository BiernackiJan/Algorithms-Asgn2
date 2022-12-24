package Models;

public class Ingredient {
    private String ingName;
    private String ingDes;
    private float calories;//calories per amount
    private float amount;//amount for calories
    private float kcal;//Kcal per 1g/ml

    public Ingredient(String n, String d, float c, float a) {
        this.ingName = n;
        this.ingDes = d;
        this.calories = c; //cal per amount
        this.amount = a;
        this.kcal = calculateKcal(1);
    }

    public Ingredient(String n,String d,float amnt){
        this.ingName = n;
        this.ingDes = d;
        this.amount = amnt;
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

    public void setCalories(float amount) {
        this.calories = kcal*amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setKcal(float kcal){this.kcal = kcal;}

    //Methods--------------------------------------------------

    public float calculateKcal(float per){
        kcal = calories/amount;
        return kcal*per;
    }



    public String toString1() {
        return  "  " + ingName + ",  " + ingDes +
                "  " + amount + "g/ml ";
    }

    @Override
    public String toString() {
        return  "  " + ingName + ",  " + ingDes +
                "  " + calories + "kcal per " + amount + " g/ml " +  '\n' ;
    }

}
