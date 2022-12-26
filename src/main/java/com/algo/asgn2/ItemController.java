package com.algo.asgn2;

import Models.BakedGoods;
import Resources.LinkedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;

import static com.algo.asgn2.Controller.itemButton;

public class ItemController {
    @FXML
    private Label recipeBakedGoodName;
    @FXML
    private Label recipeBakedGoodCountry;
    @FXML
    private Label recipeBakedGoodKcal;

    public static Node[] nodes;

    public Object getBakedGoodItems(LinkedList<BakedGoods> list) throws IOException {
        nodes = new Node[list.numNodes()];
        for(int i = 0; i < list.numNodes(); i++) {
            nodes[i] = FXMLLoader.load(ItemController.class.getResource("Item.fxml"));
            HBox hBox = (HBox) nodes[i];
            Label recipeBakedGoodName = (Label) hBox.getChildren().get(0);
            Label recipeBakedGoodCountry = (Label) hBox.getChildren().get(1);
            Label recipeBakedGoodKcal = (Label) hBox.getChildren().get(2);
            recipeBakedGoodName.setText(((BakedGoods) list.get(i)).getGoodsName());
            recipeBakedGoodCountry.setText(((BakedGoods) list.get(i)).getOriginCountry());
            recipeBakedGoodKcal.setText(String.valueOf(((BakedGoods) list.get(i)).getKcal()));
            int j = i;
            nodes[i].setOnMouseEntered(event -> {
                nodes[j].setStyle("-fx-background-color : #0A0E3F");
            });
            nodes[i].setOnMouseExited(event -> {
                nodes[j].setStyle("-fx-background-color : #02030A");
            });
        }
        return nodes;
    }
    public void inspectBakedGood(MouseEvent event){
        itemButton();
    }
}
