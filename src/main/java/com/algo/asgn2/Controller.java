package com.algo.asgn2;


import Resources.HashTable;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import Models.BakedGoods;
import Models.Ingredient;
import Models.Recipe;
import Resources.LinkedList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.*;

import static com.algo.asgn2.ItemController.nodes;
import static java.lang.String.valueOf;

public class Controller {
    public static LinkedList<BakedGoods> list = new LinkedList<>();
    public  LinkedList<Ingredient> items = new LinkedList<>();







    //Side Panel
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnIngredients;
    @FXML
    private Button btnBakedGoods;
    @FXML
    private Button btnRecipes;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnDrillDown;
    @FXML
    private Button btnSignout;


    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {//side panel with buttons each button corresponds to displaying a panel
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            pnlBakedGoods.setVisible(false);
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlEdit.setVisible(false);
            pnlSearch.setVisible(false);
            pnlDrillDown.setVisible(false);
            pnlOverview.setVisible(true);
        }
        if (actionEvent.getSource() == btnIngredients) {
            pnlIngredients.setStyle("-fx-background-color : #02030A");
            pnlIngredients.toFront();
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlRecipes.setVisible(false);
            pnlEdit.setVisible(false);
            pnlSearch.setVisible(false);
            ingWasAdded.setVisible(false);
            listAddedIng.setVisible(false);
            pnlDrillDown.setVisible(false);
            populateAllIngredientList();
            pnlIngredients.setVisible(true);
        }
        if(actionEvent.getSource()== btnBakedGoods) {
            pnlBakedGoods.setStyle("-fx-background-color : #02030A");
            pnlBakedGoods.toFront();
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlEdit.setVisible(false);
            pnlSearch.setVisible(false);
            pnlDrillDown.setVisible(false);
            pnlBakedGoods.setVisible(true);
        }
        if (actionEvent.getSource() == btnRecipes) {
            populateRecipeFields();
            pnlRecipes.setStyle("-fx-background-color : #02030A");
            pnlRecipes.toFront();
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlEdit.setVisible(false);
            pnlSearch.setVisible(false);
            pnlDrillDown.setVisible(false);
            pnlRecipes.setVisible(true);
        }
        if(actionEvent.getSource()== btnEdit){
            pnlEdit.setStyle("-fx-background-color : #02030A");
            chooseTypeToEdit.getItems().clear();
            chooseTypeToEdit.getItems().addAll("Ingredients","Baked Goods","Recipes");
            pnlEdit.toFront();
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlSearch.setVisible(false);
            pnlDrillDown.setVisible(false);
            pnlEdit.setVisible(true);
        }
        if(actionEvent.getSource()== btnSearch){
            pnlSearch.setStyle("-fx-background-color : #02030A");
            pnlSearch.toFront();
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlEdit.setVisible(false);
            pnlDrillDown.setVisible(false);
            pnlSearch.setVisible(true);
        }
        if(actionEvent.getSource()==btnDrillDown){
            pnlDrillDown.setStyle("-fx-background-color : #02030A");
            pnlDrillDown.toFront();
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlEdit.setVisible(false);
            pnlSearch.setVisible(false);
            pnlDrillDown.setVisible(true);
            initial();
        }
        if(actionEvent.getSource()== btnSignout){
            Platform.exit();;
        }

    }












    //Home
    @FXML
    private Pane pnlOverview;//Nothing needed here for now Maybe a save and load button + reset facility if needed












    //Ingredients
    @FXML
    private Pane pnlIngredients; //ingredients plane
    @FXML
    private TextField ingredientName;
    @FXML
    private TextField ingredientKcal; //kcal in ingredient
    @FXML
    private TextArea ingredientDesc;
    @FXML
    private TextField perMeasurement; //kcal per how much
    @FXML
    private ListView<Ingredient> listAddedIng;
    @FXML
    private ListView<Ingredient> listAllIng;
    @FXML
    private Label ingWasAdded;//label to show above list view when add ingredient button is pressed

    @FXML
    private void addIngredient(ActionEvent event){
        ingWasAdded.setVisible(true);
        listAddedIng.setVisible(true);
        int i = items.numNodes();

        String iN = ingredientName.getText();
        String iD = ingredientDesc.getText();
        float iK = Float.parseFloat(ingredientKcal.getText());
        float iM = Float.parseFloat(perMeasurement.getText());

        Ingredient ing = new Ingredient(iN,iD, iK,iM);
        items.add(ing);

        ingredientName.clear();
        ingredientDesc.clear();
        ingredientKcal.clear();
        perMeasurement.clear();


        populateAllIngredientList();

        listAddedIng.getItems().clear();
        listAddedIng.getItems().add(ing);
    } //button to add an ingredient to the system

    public void populateAllIngredientList(){
        listAllIng.getItems().clear();
        for(int i = 0; i < items.numNodes(); i++){
            Ingredient ing = (Ingredient) items.get(i);
            listAllIng.getItems().add(ing);
        }
    }

















    //Baked Goods
    @FXML
    private Pane pnlBakedGoods;
    @FXML
    private TextField goodsName;//enter the BakedGoods name
    @FXML
    private TextField originCt;//enter the BakedGoods origin country
    @FXML
    private TextArea goodsDesc;//enter the BakedGoods description
    @FXML
    private TextField imageUrl;//enter the BakedGoods image url
    @FXML
    private Group bakedImage;
    @FXML
    private ImageView goodsImage;//ImageView to show the image of the added BakedGood left sied bellow button
    @FXML
    private ListView<BakedGoods> listAddedGood; //show the added BakedGood bellow the button
    @FXML
    public void addGood(ActionEvent actionEvent){
        listAddedGood.getItems().clear();
        bakedImage.setVisible(true);

        String bN = goodsName.getText();
        String bC = originCt.getText();
        String bD = goodsDesc.getText();
        String bU = imageUrl.getText();

        BakedGoods bg = new BakedGoods(bN, bD, bC, bU);

        list.add(bg);
        listAddedGood.getItems().add(bg);


        Image image = new Image(bU);
        goodsImage.setImage(image);





        goodsName.clear();
        originCt.clear();
        goodsDesc.clear();
        imageUrl.clear();
    } //displays the youHaveAdded label bellow the add button















    //Recipes
    @FXML
    private Pane pnlRecipes;
    @FXML
    private ComboBox<BakedGoods> chooseGood; //choose which baked good to make a recipe for
    @FXML
    private TextField recipeName;//Name of the recipe
    @FXML
    private ListView<Ingredient> ingredientsList;//to list all ingredients and allow to pick one to add
    @FXML
    private TextField ingredientGrams;//measurement of Ingredient to the recipe to calculate grams later
    @FXML
    private ListView<String> addedIngredients; //listView to show the ingredients already added to the recipe
    @FXML
    private ComboBox<Recipe> chooseRecipeToAddTo;


    public void populateRecipeFields(){
        chooseGood.getItems().clear();
        ingredientsList.getItems().clear();
        for(int i = 0; i < list.numNodes(); i++){
            chooseGood.getItems().add((BakedGoods) list.get(i));
        }
        for(int i = 0; i < items.numNodes(); i++){
            ingredientsList.getItems().add((Ingredient) items.get(i));
        }
    }

    public void createRecipe(ActionEvent event){
        String str = recipeName.getText();
        Recipe R = new Recipe(str);
        BakedGoods bg = chooseGood.getSelectionModel().getSelectedItem();
        bg.recipes.add(R);
        choseBakedGood();
    }

    private Ingredient selectedIng;

    public void selectedIngredient(MouseEvent event){
        selectedIng = ingredientsList.getSelectionModel().getSelectedItem();
    }

    public void addToRec(ActionEvent action) {
        Recipe r = chooseRecipeToAddTo.getSelectionModel().getSelectedItem();
        float amnt = Float.parseFloat(ingredientGrams.getText());
        float cals = amnt*selectedIng.getKcal();

        Ingredient rIng = new Ingredient(selectedIng.getIngName(),selectedIng.getIngDes(),cals,amnt);

        float f = r.getKcal() + cals;
        r.setKcal(f);

        ingredientGrams.clear();


        if (selectedIng != null && ingredientGrams.getCharacters() != "") {
            int i = r.recipeIngredients.numNodes();
            r.recipeIngredients.add(rIng);
            addedIngredients.getItems().clear();

            for(int j = 0; j < r.recipeIngredients.numNodes(); j++){
                Ingredient ing = (Ingredient) r.recipeIngredients.get(j);
                addedIngredients.getItems().add(ing.toString());
            }
            r.recipeIngredientsTable.add(ingredientsList.getSelectionModel().getSelectedIndex() ,r.recipeIngredients.get(i).hashCode());//TODO input value in to recipe hash table from the hashed ingredient in recipe. (That gives location) Input location of ingredient in main hash table.

        }
    } //Button to add an ingredient to a recipe

    public void choseBakedGood(){
        chooseRecipeToAddTo.getItems().clear();

        BakedGoods bg = chooseGood.getSelectionModel().getSelectedItem();
        if(bg != null) {
            for (int i = 0; i < bg.recipes.numNodes(); i++) {
                chooseRecipeToAddTo.getItems().add((Recipe) bg.recipes.get(i));
            }
        }
    }//Populating choose Recipe choice box when Baked Good is chosen in the ComboBox





















    //Edit/Delete/Update
    @FXML
    private Pane pnlEdit;




    //Left Side of plane to choose item to edit
    @FXML
    private ComboBox<String> chooseTypeToEdit;//choose if you want to edit an Ingredient, Baked Good or Recipe

    //3 ListViews one for each object type
    @FXML
    private ListView<Ingredient> editChosenIngredient;
    @FXML
    private ListView<BakedGoods> editChosenGood;
    @FXML
    private ListView<Recipe> editChosenRecipe;


    @FXML
    private Button btnStartEdit;
    @FXML
    private Button btnStartDelete;

    public void populateChosenIngredientList(){
        editChosenIngredient.getItems().clear();
        for(int i = 0; i < items.numNodes(); i++) {
            Ingredient ing = (Ingredient) items.get(i);
            editChosenIngredient.getItems().add(ing);
        }
    }

    public void populateChosenGoodList(){
        editChosenGood.getItems().clear();
        for(int i = 0 ; i < list.numNodes(); i++){
            BakedGoods bg = (BakedGoods) list.get(i);
            editChosenGood.getItems().add(bg);
        }
    }

    public void populateChosenRecipeList(){
        editChosenRecipe.getItems().clear();
        for(int i = 0; i < list.numNodes(); i++){
            BakedGoods bg = (BakedGoods) list.get(i);
            for(int j = 0; j < bg.recipes.numNodes(); j++){
                Recipe rp = (Recipe) bg.recipes.get(j);
                editChosenRecipe.getItems().add(rp);
            }
        }
    }

    public void populateRecipeIngredientList(){
        chosenRecipeIngredients.getItems().clear();
        Recipe rp = editChosenRecipe.getSelectionModel().getSelectedItem();
        for(int i = 0 ; i < rp.recipeIngredients.numNodes(); i++){
            Ingredient ing = (Ingredient) rp.recipeIngredients.get(i);
            chosenRecipeIngredients.getItems().add(ing);
        }
    }

    @FXML
    private void chooseItemToList(ActionEvent event){
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==0){//Show the ListView when Ingredients are chosen in the ComboBox
            editChosenGood.setVisible(false);
            editChosenRecipe.setVisible(false);
            editChosenIngredient.setVisible(true);
            populateChosenIngredientList();
        }
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==1){//Show the ListView when Baked Goods are chosen in the ComboBox
            editChosenIngredient.setVisible(false);
            editChosenRecipe.setVisible(false);
            editChosenGood.setVisible(true);
            populateChosenGoodList();
        }
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==2){//Show ListView when Recipe is chosen in the ComboBox
            editChosenGood.setVisible(false);
            editChosenIngredient.setVisible(false);
            editChosenRecipe.setVisible(true);
            populateChosenRecipeList();
        }

    }//Used to show the list of all Ingredients, Baked Goods or Recipes






    //Right side of the pick item field that displays fields to edit depending on the item chosen and button pressed
    @FXML
    private Group updateIngredientsField;//group of elements to show up when the edit button is pressed and the element from Ingredients is chosen
    @FXML
    private Group updateGoodsField;//group to display with input text fields to edit a BakedGood when it is chosen from the list view and edit button pressed
    @FXML
    private Group confirmDelete;//group to ask if you are sure that oyu want to delete this item
    @FXML
    private ListView chosenItemToDelete;





    //Recipe Item Edit/Delete
    @FXML
    private Group ingFromRecipe;//group that contains the listView of Ingredients in a chosen recipe to edit and has the Edit and Delete button for Ingredients for a recipe
    @FXML
    private Group editChosenRecipeIngredient;//Group containing fields to edit a chosen Ingredient from Recipe and button to confirm update
    @FXML
    private Button btnEditSelectedIngredient;//after choosing an Ingredient from a recipe you can edit it
    @FXML
    private Button btnDelSelectedIngredient;//after choosing an Ingredient from a recipe you can delete it



    //Ingredient Update Fields
    @FXML
    private TextField ingrNameUpdate;//Update an ingredient name chosen from a Recipe
    @FXML
    private TextField ingKcalUpdate;//Update an ingredient kcal chosen from Recipe
    @FXML
    private TextField ingMlUpdate;//Update an ingredient image url chosen from Recipe
    @FXML
    private TextArea ingDescUpdate;//Update an ingredient Description chosen form Recipe


    //Baked Goods Update Fields
    @FXML
    private TextField goodNameUpdate;
    @FXML
    private TextField goodCtUpdate;
    @FXML
    private TextField goodUrlUpdate;
    @FXML
    private TextArea goodDescUpdate;


    //Recipe Update Fields
    @FXML
    private Label recipeToUpdateName;
    @FXML
    private ListView<Ingredient> chosenRecipeIngredients;
    @FXML
    private TextField chosenIngMlUpdate;

    @FXML
    private TextField chosenRecipeNameUpdate;
    @FXML
    private Group editChosenRecipeUpdate;


    public void editItems(ActionEvent event) {
        if (event.getSource() == btnStartEdit ) {//Edit boxes show up
            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 0 && editChosenIngredient.getSelectionModel().getSelectedItem() != null) {//When Ingredients are chosen in the ComboBox the fields will show up to edit fields when the button is pressed
                updateGoodsField.setVisible(false);
                ingFromRecipe.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                confirmDelete.setVisible(false);
                editChosenRecipeUpdate.setVisible(false);
                updateIngredientsField.setVisible(true);

                Ingredient ing = editChosenIngredient.getSelectionModel().getSelectedItem();

                ingrNameUpdate.setText(ing.getIngName());
                ingKcalUpdate.setText(valueOf(ing.getCalories()));
                ingMlUpdate.setText(valueOf(ing.getAmount()));
                ingDescUpdate.setText(ing.getIngDes());
            }
            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 1 && editChosenGood.getSelectionModel().getSelectedItem() != null) {//When Baked Goods are chosen in the ComboBox only fields to edit those will show up
                updateIngredientsField.setVisible(false);
                ingFromRecipe.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                confirmDelete.setVisible(false);
                editChosenRecipeUpdate.setVisible(false);
                updateGoodsField.setVisible(true);

                BakedGoods bg = editChosenGood.getSelectionModel().getSelectedItem();

                goodNameUpdate.setText(bg.getGoodsName());
                goodCtUpdate.setText(valueOf(bg.getOriginCountry()));
                goodUrlUpdate.setText(valueOf(bg.getURL()));
                goodDescUpdate.setText(bg.getGoodsDesc());
            }
            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 2 && editChosenRecipe.getSelectionModel().getSelectedItem() != null) {//When Recipe is chosen in the ComboBox and edit button is pressed fields to edit Ingredients in the Recipe
                updateIngredientsField.setVisible(false);
                confirmDelete.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                updateGoodsField.setVisible(false);
                ingFromRecipe.setVisible(true);
                editChosenRecipeUpdate.setVisible(true);
                editChosenRecipeUpdate.setVisible(true);

                Recipe rp = editChosenRecipe.getSelectionModel().getSelectedItem();
                recipeToUpdateName.setText(rp.getName());
                chosenRecipeNameUpdate.setText(rp.getName());

                populateRecipeIngredients();
            }
        }


        if (event.getSource() == btnStartDelete) {//Delete message shows up when the button is pressed
            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 0 && editChosenIngredient.getSelectionModel().getSelectedItem() != null) {
                updateIngredientsField.setVisible(false);
                updateGoodsField.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                ingFromRecipe.setVisible(false);
                editChosenRecipeUpdate.setVisible(false);
                confirmDelete.setVisible(true);

                chosenItemToDelete.getItems().clear();
                Ingredient ing = editChosenIngredient.getSelectionModel().getSelectedItem();
                chosenItemToDelete.getItems().add(ing);
            }

            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 1 && editChosenGood.getSelectionModel().getSelectedItem() != null) {
                updateIngredientsField.setVisible(false);
                updateGoodsField.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                ingFromRecipe.setVisible(false);
                editChosenRecipeUpdate.setVisible(false);
                confirmDelete.setVisible(true);

                chosenItemToDelete.getItems().clear();
                BakedGoods bg = editChosenGood.getSelectionModel().getSelectedItem();
                chosenItemToDelete.getItems().add(bg);
            }

            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 2 && editChosenRecipe.getSelectionModel().getSelectedItem() != null) {
                updateIngredientsField.setVisible(false);
                updateGoodsField.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                ingFromRecipe.setVisible(false);
                editChosenRecipeUpdate.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                confirmDelete.setVisible(true);

                chosenItemToDelete.getItems().clear();

                Recipe rp = editChosenRecipe.getSelectionModel().getSelectedItem();
                chosenItemToDelete.getItems().add(rp);
            }
        }
    }


    public void populateRecipeIngredients(){
        chosenRecipeIngredients.getItems().clear();
        Recipe rp = editChosenRecipe.getSelectionModel().getSelectedItem();
        for(int i = 0; i < rp.recipeIngredients.numNodes(); i++) {
            Ingredient ing = (Ingredient) rp.recipeIngredients.get(i);
            chosenRecipeIngredients.getItems().add(ing);//TODO: NEED TO CHANGE INGREDIENTS TOSTRING SO THAT IT IS GENERIC AND THAT LIST VIEWS THAT NEED TO BE ADDED TO THAT ARE NOT OBJECT TYPE ONLY RETURN toSting1
        }
    }

    public void confirmDelete(ActionEvent event){
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 0 && editChosenIngredient.getSelectionModel().getSelectedItem() != null){
            int i = editChosenIngredient.getSelectionModel().getSelectedIndex();
            items.deleteNode(i);
            populateChosenIngredientList();
            confirmDelete.setVisible(false);
        }

        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 1 && editChosenGood.getSelectionModel().getSelectedItem() != null){
            int i = editChosenGood.getSelectionModel().getSelectedIndex();
            list.deleteNode(i);
            populateChosenGoodList();
            confirmDelete.setVisible(false);
        }

        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 2 && editChosenRecipe.getSelectionModel().getSelectedItem() != null && chosenRecipeIngredients.getSelectionModel().getSelectedItem() == null){
            for(int i = 0; i  < list.numNodes(); i++){
                BakedGoods bg = (BakedGoods) list.get(i);
                Recipe rp = editChosenRecipe.getSelectionModel().getSelectedItem();
                for(int j = 0; j < bg.recipes.numNodes(); j++){
                    Recipe rpToCheck = (Recipe) bg.recipes.get(j);
                    if(rp.hashCode() == rpToCheck.hashCode()){
                        bg.recipes.deleteNode(j);
                        populateChosenRecipeList();
                        confirmDelete.setVisible(false);
                        ingFromRecipe.setVisible(false);
                    }
                }
            }
        }

        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 2 && editChosenRecipe.getSelectionModel().getSelectedItem() != null && chosenRecipeIngredients.getSelectionModel().getSelectedItem() != null){
            Recipe rp = editChosenRecipe.getSelectionModel().getSelectedItem();
            int i = chosenRecipeIngredients.getSelectionModel().getSelectedIndex();
            rp.recipeIngredients.deleteNode(i);
            populateRecipeIngredients();
            confirmDelete.setVisible(false);
        }
    }//when this button is pressed the chosen Ingredient/BakedGood/Recipe should be deleted

    public void confirmEdit(ActionEvent event){
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 0 && editChosenIngredient.getSelectionModel().getSelectedItem() != null){
            Ingredient ing = editChosenIngredient.getSelectionModel().getSelectedItem();
            String ingName = ingrNameUpdate.getText();
            float ingKcal = Float.parseFloat(ingKcalUpdate.getText());
            float ingMl = Float.parseFloat(ingMlUpdate.getText());
            String ingDesc = ingDescUpdate.getText();


            ing.setIngName(ingName);
            ing.setCalories(ingKcal);
            ing.setAmount(ingMl);
            ing.setIngDes(ingDesc);


            populateChosenIngredientList();
            updateIngredientsField.setVisible(false);
        }

        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 1 && editChosenGood.getSelectionModel().getSelectedItem() != null){
            BakedGoods bg = editChosenGood.getSelectionModel().getSelectedItem();
            String goodName = goodNameUpdate.getText();
            String goodCT = goodCtUpdate.getText();
            String goodDesc = goodDescUpdate.getText();
            String goodUrl = goodUrlUpdate.getText();


            bg.setGoodsName(goodName);
            bg.setOriginCountry(goodCT);
            bg.setGoodsDes(goodDesc);
            bg.setURL(goodUrl);


            populateChosenGoodList();
            updateGoodsField.setVisible(false);
        }

        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 2 && editChosenRecipe.getSelectionModel().getSelectedItem() != null){

            Recipe rp = editChosenRecipe.getSelectionModel().getSelectedItem();
            String name = chosenRecipeNameUpdate.getText();

            rp.setName(name);
            populateChosenRecipeList();


            recipeToUpdateName.setText(rp.getName());
            chosenRecipeNameUpdate.setText(rp.getName());
            editChosenRecipeUpdate.setVisible(false);
        }

        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 2 && chosenRecipeIngredients.getSelectionModel().getSelectedItem() != null){
            Ingredient ing = chosenRecipeIngredients.getSelectionModel().getSelectedItem();

            float amnt = Float.parseFloat(chosenIngMlUpdate.getText());

            ing.setCalories(amnt);
            ing.setAmount(amnt);

            editChosenRecipeIngredient.setVisible(false);

            populateRecipeIngredients();
        }
    }//when this is pressed all the fields that were edited should be changed and applied to the object


    @FXML
    public void recipeItemControl(ActionEvent action){
        if(action.getSource()==btnEditSelectedIngredient && chosenRecipeIngredients.getSelectionModel().getSelectedItem() != null){//Edit button to edit a selected Ingredient from the chosen Recipe
            editChosenRecipeUpdate.setVisible(false);
            confirmDelete.setVisible(false);
            editChosenRecipeIngredient.setVisible(true);

            Ingredient ing = chosenRecipeIngredients.getSelectionModel().getSelectedItem();
            String str = String.valueOf(ing.getAmount());
            chosenIngMlUpdate.setText(str);
        } //Selecting the Ingredient from the list in a recipe and pressing the button should start the edit of said ingredient
        if(action.getSource()==btnDelSelectedIngredient && chosenRecipeIngredients.getSelectionModel().getSelectedItem() != null) {
            editChosenRecipeIngredient.setVisible(false);
            editChosenRecipeUpdate.setVisible(false);
            confirmDelete.setVisible(true);

            chosenItemToDelete.getItems().clear();
            Ingredient ing = chosenRecipeIngredients.getSelectionModel().getSelectedItem();
            chosenItemToDelete.getItems().add(ing);

        }//Selecting an Ingredient from the list of Ingredients in a Recipe and pressing the delete button should pop up a question if you confirm
    }//control to delete or edit an ingredient from a recipe after pressing one of the two buttons


















    //Search
    @FXML
    private Pane pnlSearch;
    @FXML
    private ImageView searchIcon;
    @FXML
    private ImageView searchIcon1;
    @FXML
    private Button byKcal;//button to sort searched items by Kcal
    @FXML
    private Button alphabetical;//button to sort searched items by alphabet
    @FXML
    private ListView<Object> listSearchItems;
    @FXML
    private ListView<String> listIngInOtherRecipe;
    @FXML
    private ListView<Object> listAllSearchItems;//TODO delete this
    @FXML
    private TextField searchOption1;

    @FXML
    private TextField searchOption2;


    public static LinkedList<Object> searchItems = new LinkedList<>();
    public static LinkedList<String> allSearchItems = new LinkedList<>();
    public void searchForItems(MouseEvent event){//Press on Search Icon to search for Items
        System.out.println("Searching");
        searchIcon.setVisible(false);
        searchIcon1.setVisible(true);
        listSearchItems.getItems().clear();
        searchItems.delAll();
        allSearchItems.delAll();
        String s1 = searchOption1.getText();
        String s2 = searchOption2.getText();


        //returns the baked good and recipe that the search word is found in
        if (!searchOption1.getText().isBlank() && searchOption2.getText().isBlank()){
            //loops through everything in order to find all the items with name
            for (int i=0; i < list.numNodes(); i++){
                BakedGoods b = ((BakedGoods) list.get(i));
                if (b.toString().toLowerCase().contains(s1.toLowerCase())){
                    String str1 = ((BakedGoods) list.get(i)).fullString();
                    listSearchItems.getItems().add(str1);
                    searchItems.add(list.get(i));
                    allSearchItems.add(str1);
                } for (int j = 0; j < b.recipes.numNodes(); j++){
                    Recipe r = (Recipe) b.recipes.get(j);
                    String str2 = r.stringCheck();
                    if (str2.toLowerCase().contains(s1.toLowerCase())){
                        listSearchItems.getItems().add(str2);
                        searchItems.add(r);
                        allSearchItems.add(str2);
                    }
                }
            }
        }
        //returns all instances of the word
        if (!searchOption2.getText().isBlank() && searchOption1.getText().isBlank()){
            //loops through all the Baked Goods
//            for (int i = 0; i < list.numNodes(); i++){
//                BakedGoods b = ((BakedGoods) list.get(i));
//                //loops through all the recipes
//                for (int j = 0; j < b.recipes.numNodes(); j++) {
//                    Recipe r = (Recipe) b.recipes.get(j);
//                    //loops through all the ingredients and if any match searchOption2 it will print to list view
//                    for (int k = 0; k < r.recipeIngredients.numNodes(); k++){
//                        Ingredient ing = (Ingredient) items.get(k);
//                        //String temp = r.toString();
//                        if (ing.toString().toLowerCase().contains(s2.toLowerCase())) {
//                            System.out.println(ing);
//                            listSearchItems.getItems().add(ing);
//                            searchItems.add(ing);
//                            allSearchItems.add(ing.toString());
//                        }
//                    }
//                }
//            }
            for (int i = 0; i < items.numNodes(); i++){
                Ingredient ing = (Ingredient) items.get(i);
                if (ing.toString().toLowerCase().contains(s2.toLowerCase())){
                    listSearchItems.getItems().add(ing);
                    searchItems.add(ing);
                    allSearchItems.add(ing.toString());
                }
            }
        }

        if (!searchOption2.getText().isBlank() && !searchOption1.getText().isBlank()){
            //loops through everything in order to find all the items with name
            for (int i=0; i < list.numNodes(); i++){
                BakedGoods b = ((BakedGoods) list.get(i));

                for (int j = 0; j < b.recipes.numNodes(); j++) {
                    Recipe r = (Recipe) b.recipes.get(j);
                    if (b.toString().toLowerCase().contains(s1.toLowerCase()) && r.stringCheck().toLowerCase().contains(s2.toLowerCase())){
                        listSearchItems.getItems().add(r + "  In: " + b);
                        searchItems.add(r);
                        allSearchItems.add(r + "  In: " + b);
                    } else System.out.println("ERROR");
                }
            }
        }
    }


    @FXML
    void displayRecipes(MouseEvent event) {
        listIngInOtherRecipe.getItems().clear();
        Object s = listSearchItems.getSelectionModel().getSelectedItem();
        if (s != null){
            //loops through all the backed goods
            for (int i = 0; i < list.numNodes(); i++){
                BakedGoods b = (BakedGoods) list.get(i);
                //loops through all the recipes
                for (int j = 0; j < b.recipes.numNodes(); j++){
                    Recipe r = (Recipe) b.recipes.get(j);
                    for (int k = 0; k < r.recipeIngredients.numNodes(); k++){
                        Ingredient ing = (Ingredient) r.recipeIngredients.get(k);
                        if (s.toString().contains(ing.getIngName())){
                            listIngInOtherRecipe.getItems().add(r.stringCheck());
                        }
                    }
                }
            }
        }
    }


    public void searchIconHover(MouseEvent event){//Effect of image brightening when releasing the mouse
        searchIcon1.setVisible(false);
        searchIcon.setVisible(true);
    }

    public void sortButton(ActionEvent event){
        LinkedList<String> temporary = new LinkedList<>();
        if(event.getSource()==alphabetical){
            temporary.delAll();
            alphabeticalSort(searchItems);

            for(int i = 0; i < searchItems.numNodes(); i++) {
                String o = searchItems.get(i).toString();
                String s1 = o.substring(0, 8);
                for (int j = 0; j < allSearchItems.numNodes(); j++) {
                    String o1 = allSearchItems.get(j).toString();
                    String s2 = o1.substring(0, 10);
                    if (s2.contains(s1)) {
                        temporary.add(o1);
                    }
                }
            }
            System.out.println("Sorting Alphabetical");
        }
        if(event.getSource()==byKcal){
            temporary.delAll();
            kcalSort(searchItems);

            for(int i = 0; i < searchItems.numNodes(); i++) {
                String o = searchItems.get(i).toString();
                String s1 = o.substring(0, 8);
                for (int j = 0; j < allSearchItems.numNodes(); j++) {
                    String o1 = allSearchItems.get(j).toString();
                    String s2 = o1.substring(0, 10);
                    if (s2.contains(s1)) {
                        temporary.add(o1);
                    }
                }

            }
            System.out.println("Sorting by Kcal");
        }
        listSearchItems.getItems().clear();
        System.out.println(temporary.listAll());
        allSearchItems = temporary;
        int i = 0;
        while(i < allSearchItems.numNodes()) {
            listSearchItems.getItems().add(allSearchItems.get(i));
            i++;
        }
    }

    //Make an alphabetical sort class that will take in a Linked List and sort it alphabetically
    public void alphabeticalSort(LinkedList<Object> list) {
        boolean added;
        LinkedList<Object> sortedList = new LinkedList<>();
        sortedList.delAll();
        for (int j = 0; j < list.numNodes(); j++) {
            added = false;
            Object obj = list.get(j);
            String str = obj.toString().toLowerCase();
            String str1 = str.substring(2, 4);
            int hash = str1.hashCode();
            for (int i = 0; i < list.numNodes(); i++) {
                if (!added) {
                    if (sortedList.numNodes() == 0) {
                        sortedList.add(obj);
                        added = true;
                    }
                    Object obj1 = sortedList.get(i);
                    String str2 = obj1.toString().toLowerCase();
                    String str3 = str2.substring(2, 4);
                    int hash1 = str3.hashCode();
                    if (!added) {
                        if (hash <= hash1) {
                            sortedList.add(i, obj);
                            added = true;
                        }
                    }
                    if (!added && i == sortedList.numNodes() - 1) {
                        sortedList.add(obj);
                        added = true;
                    }
                }
            }
        }
        searchItems = sortedList;
    }

    public void kcalSort(LinkedList<Object> list) {
        //TODO make a linked list that will sort the items by Kcal in a insertion sort fashion
        LinkedList<Object> sortedList = new LinkedList<>();
        sortedList.delAll();
        boolean added;
        for (int i = 0; i < list.numNodes(); i++) {
            added = false;
            Object obj = list.get(i);
            float objKcal = 0;
            if(obj instanceof Ingredient){
                objKcal = ((Ingredient) obj).getKcal();
            }
            if(obj instanceof Recipe){
                objKcal = ((Recipe) obj).getKcal();
            }
            if(obj instanceof BakedGoods){
                objKcal = ((BakedGoods) obj).getKcal();
            }
            if (sortedList.numNodes() == 0) {
                sortedList.add(obj);
                added = true;
            }
            for (int j = 0; j < sortedList.numNodes(); j++) {
                Object obj1 = sortedList.get(j);
                if (!added) {
                    if(obj1 instanceof Ingredient){
                        if (objKcal <= ((Ingredient) obj1).getKcal()) {
                            sortedList.add(j, obj);
                            added = true;
                        }else if (!added && j == sortedList.numNodes() - 1) {
                            sortedList.add(obj);
                            added = true;
                        }
                    }
                    if(obj1 instanceof Recipe){
                        if (objKcal <= ((Recipe) obj1).getKcal()) {
                            sortedList.add(j, obj);
                            added = true;
                        }else if (!added && j == sortedList.numNodes() - 1) {
                            sortedList.add(obj);
                            added = true;
                        }
                    }
                    if(obj1 instanceof BakedGoods){
                        if (objKcal <= ((BakedGoods) obj1).getKcal()) {
                            sortedList.add(j, obj);
                            added = true;
                        }else if (!added && j == sortedList.numNodes() - 1) {
                            sortedList.add(obj);
                            added = true;
                        }
                    }
                }
            }
        }
        searchItems = sortedList;
    }









    //Drill Down
    @FXML
    private Pane pnlDrillDown;
    @FXML
    private VBox pnItems = null;
    @FXML
    private ListView<String> inspectedGoodName;
    @FXML
    private ListView inspectedGoodRecipes;
    @FXML
    private ListView originalIngredients;

    public void initial() throws IOException {
        ItemController itemController = new ItemController();
        itemController.getBakedGoodItems(list);
        pnItems.getChildren().clear();
        for (int i = 0; i < nodes.length; i++) {
            pnItems.getChildren().add(nodes[i]);
            int j = i;

        }
    }

    private int index = 0;
    public void itemButton(int index){
        this.index = index;
    }

    public void inspected(ActionEvent action){
        inspectedGoodName.getItems().clear();
        inspectedGoodRecipes.getItems().clear();
        BakedGoods bg = (BakedGoods) list.get(index);
        inspectedGoodName.getItems().add(bg.toString());
        originalIngredients.getItems().clear();

        String str = "";
        for(int i = 0; i < bg.recipes.numNodes(); i++){
            Recipe r = (Recipe) bg.recipes.get(i);
            str += r.toString() + "   Ingredients: " + "\n";
            for(int j = 0; j < r.recipeIngredients.numNodes(); j++){
                Ingredient ing = (Ingredient) r.recipeIngredients.get(j);
                str += "     " + ing;
            }
            for(int j = 0; j < r.recipeIngredients.numNodes(); j++){
                int k = r.recipeIngredients.get(j).hashCode();
                int l = r.recipeIngredientsTable.get(k);
                originalIngredients.getItems().add(items.get(l));
            }
            str += "" + "\n";
        }

        inspectedGoodRecipes.getItems().add(str);
    }






    @FXML
    void save(MouseEvent event) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Baking_Store.xml"));
        LinkedList<BakedGoods> list1 = list;
        LinkedList<Ingredient> list2 = items;
        out.writeObject(list1);
        out.writeObject(list2);
        out.close();
    }

    @FXML
    void load(MouseEvent event) throws Exception {
        Class<?>[] classes = new Class[]{BakedGoods.class, Recipe.class, Ingredient.class,
                LinkedList.class, Node.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("Baking_Store.xml"));
        list = (LinkedList<BakedGoods>) in.readObject();
        items = (LinkedList<Ingredient>) in.readObject();
        in.close();

    }
    @FXML
    void reset(MouseEvent event){
        //deletes all the nodes in both linked lists
        list.delAll();
        items.delAll();

        listAllIng.getItems().clear();
        listAddedIng.getItems().clear();
        listAddedGood.getItems().clear();

        ingredientsList.getItems().clear();
        addedIngredients.getItems().clear();
        listSearchItems.getItems().clear();
        listIngInOtherRecipe.getItems().clear();


    }






}