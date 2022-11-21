module com.algo.asgn2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.algo.asgn2 to javafx.fxml;
    exports com.algo.asgn2;
}