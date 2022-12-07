module com.algo.asgn2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.algo.asgn2 to javafx.fxml, xstream;
    exports com.algo.asgn2;
    opens Resources to xstream;
    opens Models to xstream;
    exports Models to xstream;
    exports Resources to xstream;

}