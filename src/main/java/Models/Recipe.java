package Models;

import Resources.HashTable;
import Resources.LinkedList;

public class Recipe {
    public LinkedList<Ingredient> recipeIngredients = new LinkedList<>();
    public HashTable recipeIngredientsTable = new HashTable(30);
    private String Name;
    private float Kcal = 0;

    public Recipe(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getKcal() {
        return Kcal;
    }

    public void setKcal(float kcal) {
        Kcal = kcal;
    }

    public String stringCheck(){
        return  "  " + Name +
                ", " + Kcal + "\n" +
                "  Ingredients: " + "\n" + recipeIngredients.listAll();
    }
    @Override
    public String toString() {
        return  "  " + Name +
                ", " + Kcal + "\n" ;
    }
}

