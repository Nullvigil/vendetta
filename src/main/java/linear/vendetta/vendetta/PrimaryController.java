package linear.vendetta.vendetta;
 
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import linear.vendetta.vendetta.API.Matrix;
import linear.vendetta.vendetta.API.Vector;
 
public class PrimaryController {
 
    @FXML
    private Label brandTitle;
 
    @FXML
    private StackPane cartesianPane;
 
    @FXML
    private Button clearButton;
 
    @FXML
    private Spinner<Integer> colsASpinner;
 
    @FXML
    private Spinner<Integer> colsBSpinner;
 
    @FXML
    private GridPane matrixAContainer;
 
    @FXML
    private GridPane matrixBContainer;
 
    @FXML
    private ComboBox<String> operationComboBox;
 
    @FXML
    private TextArea resultArea;
 
    @FXML
    private BorderPane rootPane;
 
    @FXML
    private Spinner<Integer> rowsASpinner;
 
    @FXML
    private Spinner<Integer> rowsBSpinner;
 
    @FXML
    private TextField scalarField;
 
    @FXML
    private Button solveButton;
 
    @FXML
    private Label subtitleLabel;
 
    private TextField[][] fieldsA;
    private TextField[][] fieldsB;
 
    @FXML
    public void initialize() {
        operationComboBox.getItems().setAll(
            "Addition",
            "Subtraction",
            "Scalar Multiplication",
            "Transpose",
            "Triangle Form",
            "Determinant",
            "Inverse",
            "Matrix Multiplication",
            "Dot Product",
            "Cross Product",
            "Projection"
        );
        operationComboBox.getSelectionModel().selectFirst();
 
        // row and column selectors, 1 to 6, start at 3
        rowsASpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6, 3));
        colsASpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6, 3));
        rowsBSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6, 3));
        colsBSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6, 3));
 
        // rebuild a grid whenever its spinners change
        rowsASpinner.valueProperty().addListener((obs, oldVal, newVal) -> buildGridA());
        colsASpinner.valueProperty().addListener((obs, oldVal, newVal) -> buildGridA());
        rowsBSpinner.valueProperty().addListener((obs, oldVal, newVal) -> buildGridB());
        colsBSpinner.valueProperty().addListener((obs, oldVal, newVal) -> buildGridB());
 
        buildGridA();
        buildGridB();
    }
 
    private void buildGridA() {
        fieldsA = buildGrid(matrixAContainer, rowsASpinner.getValue(), colsASpinner.getValue());
    }
 
    private void buildGridB() {
        fieldsB = buildGrid(matrixBContainer, rowsBSpinner.getValue(), colsBSpinner.getValue());
    }
 
    private TextField[][] buildGrid(GridPane grid, int rows, int cols) {
        grid.getChildren().clear();
        TextField[][] fields = new TextField[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                TextField tf = new TextField();
                tf.setPromptText("0");
                tf.setPrefColumnCount(3);
                fields[r][c] = tf;
                grid.add(tf, c, r);
            }
        }
        return fields;
    }
 
    @FXML
    private void clearButtonPressed() {
        for (int r = 0; r < fieldsA.length; r++) {
            for (int c = 0; c < fieldsA[r].length; c++) {
                fieldsA[r][c].clear();
            }
        }
        for (int r = 0; r < fieldsB.length; r++) {
            for (int c = 0; c < fieldsB[r].length; c++) {
                fieldsB[r][c].clear();
            }
        }
 
        scalarField.clear();
        resultArea.clear();
 
        resultArea.setPromptText("Enter your values and select an operation");
    }
 
    @FXML
    private void solveButtonPressed() {
        String operation = operationComboBox.getSelectionModel().getSelectedItem();
 
        if (operation == null) {
            resultArea.setText("Please select an operation.");
            return;
        }
 
        try {
            Matrix a = readMatrix(fieldsA);
            Matrix b = readMatrix(fieldsB);
 
            if (operation.equals("Addition")) {
                resultArea.setText(matrixToText(a.add(b)));
            } else if (operation.equals("Subtraction")) {
                resultArea.setText(matrixToText(a.subtract(b)));
            } else if (operation.equals("Scalar Multiplication")) {
                double k = Double.parseDouble(scalarField.getText().trim());
                resultArea.setText(matrixToText(a.scalarMult(k)));
            } else if (operation.equals("Transpose")) {
                resultArea.setText(matrixToText(a.transpose()));
            } else if (operation.equals("Triangle Form")) {
                resultArea.setText(matrixToText(a.toTriangle()));
            } else {
                resultArea.setText(operation + " is not implemented yet.");
            }
        } catch (NumberFormatException e) {
            resultArea.setText("Please enter valid numbers.");
        }
    }
 
    // turns the text fields into a Matrix (blank = 0)
    private Matrix readMatrix(TextField[][] fields) {
        List<Vector> rows = new ArrayList<>();
        for (int r = 0; r < fields.length; r++) {
            List<Double> values = new ArrayList<>();
            for (int c = 0; c < fields[r].length; c++) {
                String text = fields[r][c].getText().trim();
                if (text.isEmpty()) {
                    values.add(0.0);
                } else {
                    values.add(Double.parseDouble(text));
                }
            }
            rows.add(new Vector(values));
        }
        return Matrix.build(rows);
    }
 
    // turns a Matrix into text for the result area
    private String matrixToText(Matrix m) {
        String text = "";
        for (int r = 0; r < m.getNumRows(); r++) {
            for (int c = 0; c < m.getNumCols(); c++) {
                text = text + m.get(r, c) + "   ";
            }
            text = text + "\n";
        }
        return text;
    }
}