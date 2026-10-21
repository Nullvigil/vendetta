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

    
    //TO DO: REVIEW CONSTRUCTOR BASE ON NEEDS
    public Matrix(List<Vector> rows) {
        this.rows = rows;
        calcDeterminant();
    }
    
    public static Matrix transpose(Matrix M) {
        //TO DO: CONTENT
        return new Matrix(List.of(
                new Vector(List.of(1, 0, 0)),
                new Vector(List.of(0, 1, 0)),
                new Vector(List.of(0, 0, 1))
        ));
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
    
    public static Matrix toTriangle() {
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
}
