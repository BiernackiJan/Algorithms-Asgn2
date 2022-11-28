package com.algo.asgn2;

import Models.BakedGoods;
import Models.Ingredient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private Button btnPackages;
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
            pnlIngredients.setVisible(true);
        }
        if (actionEvent.getSource() == btnRecipes) {
            pnlRecipes.setStyle("-fx-background-color : #02030A");
            pnlRecipes.toFront();
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            pnlBakedGoods.setVisible(false);
            pnlRecipes.setVisible(true);
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            pnlBakedGoods.setVisible(false);
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(true);
        }
        if(actionEvent.getSource()== btnBakedGoods)
        {
            pnlBakedGoods.setStyle("-fx-background-color : #02030A");
            pnlBakedGoods.toFront();
            pnlRecipes.setVisible(false);
            pnlIngredients.setVisible(false);
            pnlOverview.setVisible(false);
            youHaveAdded.setVisible(false);
            pnlBakedGoods.setVisible(true);
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
    private TextField goodsName;
    @FXML
    private TextField originCt;
    @FXML
    private TextArea goodsDesc;
    @FXML
    private TextField imageUrl;
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