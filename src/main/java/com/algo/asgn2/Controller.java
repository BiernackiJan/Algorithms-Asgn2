package com.algo.asgn2;

import Models.BakedGoods;
import Models.Ingredient;
import Models.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

//    @FXML
//    private VBox pnItems = null;

    public void initialize(){
        chooseTypeToEdit.getItems().addAll("Ingredients","Baked Goods","Recipes");
    }






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
    private Button btnSettings;
    @FXML
    private Button btnSignout;


    @FXML
    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnIngredients) {
            pnlIngredients.setStyle("-fx-background-color : #02030A");
            pnlIngredients.toFront();
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlRecipes.setVisible(false);
            pnlEdit.setVisible(false);
            pnlIngredients.setVisible(true);
        }
        if (actionEvent.getSource() == btnRecipes) {
            pnlRecipes.setStyle("-fx-background-color : #02030A");
            pnlRecipes.toFront();
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlEdit.setVisible(false);
            pnlRecipes.setVisible(true);
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            pnlBakedGoods.setVisible(false);
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlEdit.setVisible(false);
            pnlOverview.setVisible(true);
        }
        if(actionEvent.getSource()== btnBakedGoods) {
            pnlBakedGoods.setStyle("-fx-background-color : #02030A");
            pnlBakedGoods.toFront();
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlEdit.setVisible(false);
            youHaveAdded.setVisible(false);
            pnlBakedGoods.setVisible(true);
        }
        if(actionEvent.getSource()== btnEdit){
            pnlEdit.setStyle("-fx-background-color : #02030A");
            pnlEdit.toFront();
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlEdit.setVisible(true);
        }

    }












    //Home
    @FXML
    private Pane pnlOverview;//Nothing needed here for now Maybe a save and load button + reset facility if needed



    //Ingredients
    @FXML
    private Pane pnlIngredients; //ingredients pane
    @FXML
    private TextField ingredientName;
    @FXML
    private TextField ingredientKcal; //kcal
    @FXML
    private TextArea ingredientDesc;
    @FXML
    private TextField perMeasurememt; //kcal per how much


    @FXML
    private void addIngredient(ActionEvent event){} //button to add an ingredient to the system














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
    private Label youHaveAdded;//You Have Added:   "Label"
    @FXML
    private ImageView goodsImage;//ImageView to show the image of the added BakedGood
    @FXML
    private ListView<String> listAddedGood; //show the added BakedGood bellow the button
    @FXML
    public void addGood(ActionEvent actionEvent){
        youHaveAdded.setVisible(true);
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
    private ListView<Ingredient> ingredientsList;//to list all ingredients and allow to pick one to add
    @FXML
    private TextField ingredientGrams;//measurement of Ingredient to the recipe to calculate grams later
    @FXML
    private ListView<Ingredient> addedIngredients; //listView to show the ingredients already added to the recipe


    @FXML
    public void addToRec(ActionEvent action){} //Button to add an ingredient to a recipe
    @FXML
    public void chooseIngredient(MouseEvent event){}//Choosing an ingredient from the list by pressing it












    //Edit/Delete/Update
    @FXML
    private Pane pnlEdit;




    //Left Side of plane to choose item to edit
    @FXML
    private ComboBox<String> chooseTypeToEdit;
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


    @FXML
    private void chooseItemToList(MouseEvent event){
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==0){
            editChosenGood.setVisible(false);
            editChosenRecipe.setVisible(false);
            editChosenIngredient.setVisible(true);
        }
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==1){
            editChosenIngredient.setVisible(false);
            editChosenRecipe.setVisible(false);
            editChosenGood.setVisible(true);
        }
        if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==2){ //TODO: MAKE THIS ONLY SHOW THE EDIT ELEMENTS IF A RECIPE IS CHOSEN FROM THE LIST
            editChosenGood.setVisible(false);
            editChosenIngredient.setVisible(false);
            editChosenRecipe.setVisible(true);
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
    private Group ingFromRecipe;//group that contains the listView of Ingredients in a chosen recipe to edit and has the Edit and Delete button for Ingredients for a recipe



    //Idea for Edit/Deletion of recipe that I have came up with and created in the GUI:
    //When recipe is chosen from the choice box to edit, the recipes will list in the listView, once a recipe is selected and then the Edit
    //button is pressed, a list of all Ingredients imputed into the Recipe is displayed in the top right of the screen. You can then, select
    //an Ingredient and choose to edit it or delete it. if you choose to edit it 4 text fields will pop up below the buttons and an Update
    //button will be at the bottom to confirm the edit. If you choose to delete an ingredient a confirmation question will pop-up under the
    //buttons with the item that you wish to delete displaying in a listView bellow and a confirm button will be present at the bottom.


    public void editItems(ActionEvent event){
        if(event.getSource()==btnStartEdit){
            if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==0) {
                updateGoodsField.setVisible(false);
                ingFromRecipe.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                selectedIngDelete.setVisible(false);
                confirmDelete.setVisible(false);
                updateIngredientsField.setVisible(true);
            }
            if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==1){
                updateIngredientsField.setVisible(false);
                ingFromRecipe.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                selectedIngDelete.setVisible(false);
                confirmDelete.setVisible(false);
                updateGoodsField.setVisible(true);
            }
            if(chooseTypeToEdit.getSelectionModel().getSelectedIndex()==2){
                updateIngredientsField.setVisible(false);
                confirmDelete.setVisible(false);
                editChosenRecipeIngredient.setVisible(false);
                selectedIngDelete.setVisible(false);
                updateGoodsField.setVisible(false);
                ingFromRecipe.setVisible(true);//TODO: GET THIS TO BE ONLY DISPLAYED ONCE A RECIPE IS CHOSEN FROM THE LIST OF RECIPES TO WORK OFF OF
            }
        }
        if(event.getSource()==btnStartDelete){
            updateIngredientsField.setVisible(false);
            updateGoodsField.setVisible(false);
            editChosenRecipeIngredient.setVisible(false);
            selectedIngDelete.setVisible(false);
            ingFromRecipe.setVisible(false);
            confirmDelete.setVisible(true);
        }
    }




    public void confirmDelete(ActionEvent event){}//when this button is pressed the chosen Ingredient/BakedGood/Recipe should be deleted

    public void confirmEdit(ActionEvent event){}//when this is pressed all the fields that were edited should be changed and applied to the object





    //Recipe Item Edit/Delete
    @FXML
    private Group editChosenRecipeIngredient;//Group containing fields to edit a chosen Ingredient from Recipe and button to confirm update
    @FXML
    private Group selectedIngDelete;//Group containing a confirmation message to delete the selected item with a confirm button
    @FXML
    private Button btnEditSelectedIngredient;//after choosing an Ingredient from a recipe you can edit it
    @FXML
    private Button btnDelSelectedIngredient;//after choosing an Ingredient from a recipe you can delete it




    //updateIngredientField

    @FXML
    private TextField ingrNameUpdate;
    @FXML
    private TextField ingKcalUpdate;
    @FXML
    private TextField ingMlUpdate;
    @FXML
    private TextArea ingDescUpdate;







    @FXML
    public void recipeItemControl(ActionEvent action){ //TODO: MAKE THESE ONLY WORK IF AN INGREDIENT IS CHOSEN FROM THE LISTVIEW
        if(action.getSource()==btnEditSelectedIngredient){
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


    public void none(){}





//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        Node[] nodes = new Node[10];
//        for (int i = 0; i < nodes.length; i++) {
//            try {
//
//                final int j = i;
//                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));
//
//                //give the items some effect
//
//                nodes[i].setOnMouseEntered(event -> {
//                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
//                });
//                nodes[i].setOnMouseExited(event -> {
//                    nodes[j].setStyle("-fx-background-color : #02030A");
//                });
//                pnItems.getChildren().add(nodes[i]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }






}