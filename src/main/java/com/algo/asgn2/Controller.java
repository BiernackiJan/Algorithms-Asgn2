package com.algo.asgn2;

import Models.BakedGoods;
import Models.Ingredient;
import Models.Recipe;
import Resources.LinkedList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static java.lang.String.valueOf;

public class Controller {
    public static LinkedList<BakedGoods> list = new LinkedList<>();
    public static LinkedList<Ingredient> items = new LinkedList<>();






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
    private Button btnDrillDown1;
    @FXML
    private Pane pnlDrillDown1;


    @FXML
    public void handleClicks(ActionEvent actionEvent) {//side panel with buttons each button corresponds to displaying a panel
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
        }
        if(actionEvent.getSource()== btnSignout){
            Platform.exit();;
        }

        if(actionEvent.getSource()==btnDrillDown1){
            pnlDrillDown1.toFront();
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlEdit.setVisible(false);
            pnlSearch.setVisible(false);
            pnlDrillDown.setVisible(false);
            pnlDrillDown1.setVisible(true);
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
//    @FXML
//    private ListView<Ingredient> ingredientList;

    @FXML
    private void addIngredient(ActionEvent event){
        ingWasAdded.setVisible(true);
        listAddedIng.setVisible(true);

        String iN = ingredientName.getText();
        String iD = ingredientDesc.getText();
        int iK = Integer.parseInt(ingredientKcal.getText());
        int iM = Integer.parseInt(perMeasurement.getText());

        items.add(new Ingredient(iN,iD, iK,iM));

        ingredientName.clear();
        ingredientDesc.clear();
        ingredientKcal.clear();
        perMeasurement.clear();


        listAllIng.getItems().add(new Ingredient(iN,iD, iK,iM));

        listAddedIng.getItems().clear();
        listAddedIng.getItems().add(new Ingredient(iN,iD, iK,iM));
    } //button to add an ingredient to the system














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

        list.add(new BakedGoods(bN, bD, bC, bU));
        listAddedGood.getItems().add(new BakedGoods(bN, bD, bC, bU));

        //https://media.istockphoto.com/id/184276818/photo/red-apple.jpg?s=612x612&w=0&k=20&c=NvO-bLsG0DJ_7Ii8SSVoKLurzjmV0Qi4eGfn6nW3l5w= Sample Apple image
        Image image = new Image(bU);
        goodsImage.setImage(image);

        goodsName.clear();
        originCt.clear();
        goodsDesc.clear();
        imageUrl.clear();
    } //displays the youHaveAdded label bellow the add button

    //Text fields: goodsName, originCt , ImageUrl , goodsDesc
    //at the bottom under the button is a image view to show the image from good added called goodsImage
    //there is also a list view to show the good that was just added called listAddedGood














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
        System.out.println("Selected" + selectedIng);
    }

    public void addToRec(ActionEvent action) {
        Recipe r = chooseRecipeToAddTo.getSelectionModel().getSelectedItem();
        float amnt = Float.parseFloat(ingredientGrams.getText());
        float kcals = amnt*selectedIng.getKcal();
        Ingredient rIng = new Ingredient(selectedIng.getIngName(), selectedIng.getIngDes(), kcals);
        float f = r.getKcal() + kcals;
        r.setKcal(f);

        ingredientGrams.clear();


        if (selectedIng != null && ingredientGrams.getCharacters() != "") {
            r.recipeIngredients.add(rIng);
            addedIngredients.getItems().add(rIng.toString1() + ",  " + amnt + "g/ml");
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
    private Button btnStartEdit; //TODO: Make this button work and show the edit fields when an Item is selected in the ListView
    @FXML
    private Button btnStartDelete;//TODO: Make the button show the question message when an item is selected from ListView and button is pressed


    @FXML
    private void chooseItemToList(ActionEvent event){
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==0){//Show the ListView when Ingredients are chosen in the ComboBox
            editChosenGood.setVisible(false);
            editChosenRecipe.setVisible(false);
            editChosenIngredient.setVisible(true);
            editChosenIngredient.getItems().clear();
            for(int i = 0; i < items.numNodes(); i++) {
                Ingredient ing = (Ingredient) items.get(i);
                editChosenIngredient.getItems().add(ing);
            }
        }
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==1){//Show the ListView when Baked Goods are chosen in the ComboBox
            editChosenIngredient.setVisible(false);
            editChosenRecipe.setVisible(false);
            editChosenGood.setVisible(true);
            editChosenGood.getItems().clear();
            for(int i = 0 ; i < list.numNodes(); i++){
                BakedGoods bg = (BakedGoods) list.get(i);
                editChosenGood.getItems().add(bg);
            }
        }
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==2){//Show ListView when Recipe is chosen in the ComboBox
            editChosenGood.setVisible(false);
            editChosenIngredient.setVisible(false);
            editChosenRecipe.setVisible(true);
            editChosenRecipe.getItems().clear();
            for(int i = 0; i < list.numNodes(); i++){
                BakedGoods bg = (BakedGoods) list.get(i);
                for(int j = 0; j < bg.recipes.numNodes(); j++){
                    Recipe rp = (Recipe) bg.recipes.get(j);
                    editChosenRecipe.getItems().add(rp);
                }
            }
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
    private Group selectedIngDelete;//Group containing a confirmation message to delete the selected item with a confirm button
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


    public void editItems(ActionEvent event) {
        if (event.getSource() == btnStartEdit && editChosenIngredient.getSelectionModel().getSelectedItem() != null) {//Edit boxes show up
            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 0) {//When Ingredients are chosen in the ComboBox the fields will show up to edit fields when the button is pressed
                updateGoodsField.setVisible(false);
                ingFromRecipe.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                selectedIngDelete.setVisible(false);
                confirmDelete.setVisible(false);
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
                selectedIngDelete.setVisible(false);
                confirmDelete.setVisible(false);
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
                selectedIngDelete.setVisible(false);
                updateGoodsField.setVisible(false);
                ingFromRecipe.setVisible(true);
                Recipe rp = editChosenRecipe.getSelectionModel().getSelectedItem();
                recipeToUpdateName.setText(rp.getName());
                chosenRecipeIngredients.getItems().clear();
                for(int i = 0; i < rp.recipeIngredients.numNodes(); i++) {
                    Ingredient ing = (Ingredient) rp.recipeIngredients.get(i);
                    chosenRecipeIngredients.getItems().add(ing);
                }
            }
        }


        if (event.getSource() == btnStartDelete) {//Delete message shows up when the button is pressed
            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 0 && editChosenIngredient.getSelectionModel().getSelectedItem() != null) {
                updateIngredientsField.setVisible(false);
                updateGoodsField.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                selectedIngDelete.setVisible(false);
                ingFromRecipe.setVisible(false);
                confirmDelete.setVisible(true);
                chosenItemToDelete.getItems().clear();
                Ingredient ing = editChosenIngredient.getSelectionModel().getSelectedItem();
                chosenItemToDelete.getItems().add(ing);
            }

            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 1 && editChosenGood.getSelectionModel().getSelectedItem() != null) {
                updateIngredientsField.setVisible(false);
                updateGoodsField.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                selectedIngDelete.setVisible(false);
                ingFromRecipe.setVisible(false);
                confirmDelete.setVisible(true);
                chosenItemToDelete.getItems().clear();
                BakedGoods bg = editChosenGood.getSelectionModel().getSelectedItem();
                chosenItemToDelete.getItems().add(bg);
            }

            if (chooseTypeToEdit.getSelectionModel().getSelectedIndex() == 2 && editChosenRecipe.getSelectionModel().getSelectedItem() != null) {
                chosenItemToDelete.getItems().clear();
                Recipe rp = editChosenRecipe.getSelectionModel().getSelectedItem();
                chosenItemToDelete.getItems().add(rp);
                updateIngredientsField.setVisible(false);
                updateGoodsField.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                selectedIngDelete.setVisible(false);
                ingFromRecipe.setVisible(false);
                confirmDelete.setVisible(true);
            }
        }
    }



    public void confirmDelete(ActionEvent event){}//when this button is pressed the chosen Ingredient/BakedGood/Recipe should be deleted

    public void confirmEdit(ActionEvent event){}//when this is pressed all the fields that were edited should be changed and applied to the object







    //updateIngredientField






    @FXML
    public void recipeItemControl(ActionEvent action){ //TODO: MAKE THESE ONLY WORK IF AN INGREDIENT IS CHOSEN FROM THE LISTVIEW
        if(action.getSource()==btnEditSelectedIngredient){//Edit button to edit a selected Ingredient from the chosen Recipe
            selectedIngDelete.setVisible(false);
            editChosenRecipeIngredient.setVisible(true);
        } //Selecting the Ingredient from the list in a recipe and pressing the button should start the edit of said ingredient
        if(action.getSource()==btnDelSelectedIngredient){
            editChosenRecipeIngredient.setVisible(false);
            selectedIngDelete.setVisible(true);
        }//Selecting an Ingredient from the list of Ingredients in a Recipe and pressing the delete button should pop up a question if you confirm
    }//control to delete or edit an ingredient from a recipe after pressing one of the two buttons



    //Idea:
    //For the list to edit or update/delete something choose from a choice box what Item type you want to edit from.
    //For each item type there is a listView set up that is set to non-visible when an Item in the list view will be chosen that Object can then be edited
    //When the edit button is pressed after choosing an item from a list, a menu pops up in regard to what was chosen from the list when the button was pressed
    //For baked goods the correct textFields would pop up. The same goes for the Ingredients
    //For the delete button I want to have a message pop up on the right asking if you are sure you want to delete this item and list the item and press okay to delete it
    //For the edit I want to be able to edit the values already imputed and after pressing the update button to change those values imputed btn








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
    private ListView listSearchItems;
    @FXML
    private ListView listIngInOtherRecipe;



    public void searchForItems(MouseEvent event){//Press on Search Icon to search for Items
        System.out.println("Searching");
        searchIcon.setVisible(false);
        searchIcon1.setVisible(true);
    }

    public void searchIconHover(MouseEvent event){//Effect of image brightening when releasing the mouse
        searchIcon1.setVisible(false);
        searchIcon.setVisible(true);
    }

    public void sortButton(ActionEvent event){
        if(event.getSource()==alphabetical){
            System.out.println("Sorting Alphabetical");
        }
        if(event.getSource()==byKcal){
            System.out.println("Sorting by Kcal");
        }
    }












    //Drill Down
    @FXML
    private Pane pnlDrillDown;
    @FXML
    private VBox pnItems = null;



    public void initialize() {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }






}