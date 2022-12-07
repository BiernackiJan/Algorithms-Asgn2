module com.algo.asgn2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.algo.asgn2 to javafx.fxml;
    opens Resources;
    opens Models;
    exports com.algo.asgn2;
}