package linear.vendetta.vendetta;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class PrimaryController {

    @FXML
    private Label brandTitle;

    @FXML
    private StackPane cartesianPane;

    @FXML
    private Button clearButton;

    @FXML
    private Spinner<?> colsASpinner;

    @FXML
    private Spinner<?> colsBSpinner;

    @FXML
    private GridPane matrixAContainer;

    @FXML
    private GridPane matrixBContainer;

    @FXML
    private ComboBox<?> operationComboBox;

    @FXML
    private TextArea resultArea;

    @FXML
    private BorderPane rootPane;

    @FXML
    private Spinner<?> rowsASpinner;

    @FXML
    private Spinner<?> rowsBSpinner;

    @FXML
    private TextField scalarField;

    @FXML
    private Button solveButton;

    @FXML
    private Label subtitleLabel;
    
    
}
