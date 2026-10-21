/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package linear.vendetta.vendetta;

/**
 *
 * @author Alex
 */
public interface elementalOperations<T> {
    void rowMultiply(double a, int idx);
    void rowSwap(int idx1, int idx2);
    void rowComp(int idx1, int idx2, double k);
}
