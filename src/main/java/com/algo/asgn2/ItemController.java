package com.algo.asgn2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ItemController {
    @FXML
    private static Label recipeBakedGoodName;
    @FXML
    private static Label recipeBakedGoodCountry;
    @FXML
    private static Label recipeBakedGoodKcal;
    @FXML
    private static HBox itemC;

    public static HBox getBakedGoodItems(String name, String country, String kcal) {
        recipeBakedGoodName.setText(name);
        recipeBakedGoodCountry.setText(country);
        recipeBakedGoodKcal.setText(kcal);
        return itemC;
    }
    public void inspectBakedGood(MouseEvent event){}
}
