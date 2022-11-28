package com.algo.asgn2;

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




    //Home
    @FXML
    private Pane pnlOverview;



    //Ingredients
    @FXML
    private Pane pnlIngredients;



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
    private Label youHaveAdded;
    @FXML
    private ImageView goodsImage;
    @FXML
    private ListView<String> listAddedGood;



    //Recipes
    @FXML
    private Pane pnlRecipes;




    //Baked Goods
    @FXML
    public void addGood(ActionEvent actionEvent){
        youHaveAdded.setVisible(true);
    }


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

    @FXML
    public void chooseIngredient(MouseEvent event){}


    //Side Panel
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
}