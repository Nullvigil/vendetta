/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.API;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Matthew, Ian, Adrian
 */
public class Matrix implements operable<Matrix>, elementalOperations {
    private List<Vector> rows;
    private int[] size = new int[2];
    private double determinant;

       
     // Private: go through build()
    private Matrix(List<Vector> rows) {
        this.rows = rows;
        this.size[0] = rows.size();                  // number of rows
        this.size[1] = vectorValues(rows.get(0)).size(); // number of columns
        calcDeterminant();
    }
    
    public static Matrix inverse() {
        /*
        Vector vector = new Vector(1);
        this.rows.add(vector);  //TODO: Content
        return new Matrix(this.rows,404); //404 recognizable for not existing
        */
        
        return new Matrix(List.of(
            new Vector(List.of(1, 0, 0)),
            new Vector(List.of(0, 1, 0)),
            new Vector(List.of(0, 0, 1))
        ));
    }
    
    public void calcDeterminant() {
        determinant = 1; //TODO: COntent
    }
    
    public static Matrix toTriangle() { //gaussian elim
        return new Matrix(List.of(
                new Vector(List.of(1, 0, 0)),
                new Vector(List.of(0, 1, 0)),
                new Vector(List.of(0, 0, 1))
        ));
    }
    
    public static Matrix multiply(Matrix M) {
        
        return new Matrix(List.of(
                new Vector(List.of(1, 0, 0)),
                new Vector(List.of(0, 1, 0)),
                new Vector(List.of(0, 0, 1))
        ));
    }
    
    public Matrix getSubMatrix(int i , int j) {
        return new Matrix(List.of(
                new Vector(List.of(1, 0, 0)),
                new Vector(List.of(0, 1, 0)),
                new Vector(List.of(0, 0, 1))
        ));
    }
    
    public static Matrix adj() {
        return new Matrix(List.of(
                new Vector(List.of(1, 0, 0)),
                new Vector(List.of(0, 1, 0)),
                new Vector(List.of(0, 0, 1))
        ));
    }

    @Override
    public Matrix add(Matrix a) {
        return new Matrix(List.of(
                new Vector(List.of(1, 0, 0)),
                new Vector(List.of(0, 1, 0)),
                new Vector(List.of(0, 0, 1))
        ));
    }

    @Override
    public Matrix subtract(Matrix a) {
        return this.add(a.scalarMult(-1)); 
    }

    @Override
    public Matrix scalarMult(double k) {
         List<Vector> newValues = List.copyOf(this.rows);
         
         for (int i = 0; i < newValues.size(); i++) {
             newValues.get(i).scalarMult(k);
         }
         
         return new Matrix(newValues);
    }
    
    @Override  
    public void rowMultiply(double a, int idx) {
        Vector oldVector = this.rows.get(idx);
        Vector newVector = oldVector.scalarMult(a); 
        this.rows.set(idx, newVector);
        this.determinant = determinant * a;
    }

    @Override
    public void rowSwap(int idx1, int idx2) {
        Collections.swap(this.rows, idx1, idx2); //skeptical if it works but it
        //should work
        
        this.determinant = determinant * -1;
    }

    @Override
    public void rowComp(int idx1, int idx2, double k) {
        
    }
    
    //Adding new method that allows dynamic creation of matrix no matter the size
    public Matrix summonIdentity(int rowNum, int colNum) {
        List<Vector> equations = new ArrayList<>();
        for (int i = 0; i < rowNum; i++) {
            List<Double> values = new ArrayList<>(); //for vector creation
            values.clear(); //initialize for new row
            for (int j = 0; j < colNum; j++) {
                if (j == i) { //1,1 2,2 3,3 4,4 ... (leading 1 / pivot)
                    values.add(1.0);
                } else {
                    values.add(0.0);
                }
            }
            Vector temp = new Vector(values);
            equations.add(temp);
        }
        
        return new Matrix(equations);
    }
    
 
    /**
     * Matrix builder. Each Vector is one row; the size of its
     * List<Integer> is the number of columns.
     */
    public static Matrix build(List<Vector> rows) {
        return new Matrix(new ArrayList<>(rows)); // defensive copy of the list
    }
 
    // Single point of contact with your Vector class.
    private static List<Double> vectorValues(Vector v) {
        return v.getValues(); // <-- rename if your getter differs
    }
 
    // Getters
  
    public int getNumRows() { return size[0]; }
 
    public int getNumCols() { return size[1]; }
 
    public double get(int row, int col) { return vectorValues(rows.get(row)).get(col); }
 
    /**
     * Hey, @Matthew here, um see, I had a stroke of inspiration here and I am 
     * semi-confident in how functional this code is. I actually drew up my 
     * thoughts on paper for this one. I am too tired to test it out.
     * @return the matrix that is now transposed
     */
    public Matrix transpose() {
    List<Vector> transposed = new ArrayList<>();
    for (int c = 0; c < size[1]; c++) {
        List<Double> vals = new ArrayList<>();
        for (int r = 0; r < size[0]; r++) {
            vals.add(get(r, c));
        }
        transposed.add(new Vector(vals)); // assumes a Vector(List<Double>) constructor
    }
    return build(transposed);
}
    
}
 

