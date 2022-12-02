package Models;

import Resources.LinkedList;

public class Recipe {
    public LinkedList<Ingredient> recipeIngredients = new LinkedList<>();

    private String Name;
    private int Kcal = 0;

    public Recipe(String name) {
        this.Name = name;
    }

}
