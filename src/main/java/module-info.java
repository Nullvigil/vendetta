module linear.vendetta.vendetta {
    requires javafx.controls;
    requires javafx.fxml;

    opens linear.vendetta.vendetta to javafx.fxml;
    exports linear.vendetta.vendetta;
}
