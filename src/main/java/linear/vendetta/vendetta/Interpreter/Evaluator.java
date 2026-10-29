/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

import java.util.HashMap;
import java.util.List;
import linear.vendetta.vendetta.API.Matrix;
import linear.vendetta.vendetta.API.Vector;
import linear.vendetta.vendetta.Interpreter.Node.NodeKind;

/**
 *
 * @author ian
 */
public class Evaluator {
    private static HashMap<String, Object> memory = Interpreter.getMemory();
    
    public static Object evaluateNode(Node root) {
        
        return switch (root.kind()) {
            case NodeKind.ASSIGN -> assign(root);
                
            case NodeKind.BINARY -> bin(root);
                
            case NodeKind.CALL -> call(root);
                
            case NodeKind.NAME -> memory.containsKey(root.text()) ? memory.get(root.text()) : throw new CommandException(String.format("%s is used but never initialized!", root.text()));  
                
            case NodeKind.NUMBER -> Double.parseDouble(node.text());                
        };
       
    }
    
    private static Object assign(Node root) {
        Object value = evaluateNode(root.children().get(0));
        
        Interpreter.assignToMemory(root.text(), value);
        
        return evaluateNode(root.children().get(0));
    }

    private static Object bin(Node node) {
        return switch(node.text()) {
            case "+" -> sum(node.children());
            case "-" -> sub(node.children());
            case "*" -> times(node.children());
            case "/" -> div(node.children());    
            default -> throw new IllegalStateException("Unexpected value: " + (node.text()));
        };
    }
    //"Adj","Inv","Trans","Det","Dot", "Cross", "Project", "SolveSystem", "Vector", "Matrix"
    private static Object call(Node node) {
        return switch(node.text()) {
            case "adj" -> adj(node.children());
            case "inv" -> inv(node.children());
            case "trans" -> trans(node.children());
            case "det" -> det(node.children());
            case "project" -> project(node.children());
            case "solveSystem" -> solveSystem(node.children());
            case "Vector" -> vector(node.children());
            case "Matrix" -> matrix(node.children());    
                
            default -> throw new IllegalStateException("Unexpected value: " + (node.text()));
        };
    }    
    
    private static Object adj(List<Node> arg) {
    
    }
    
    private static Object inv(List<Node> arg) {
    
    }

    private static Object trans(List<Node> arg) {
    
    }
    
    private static Object det(List<Node> arg) {
    
    }
    
    private static Object project(List<Node> arg) {
    
    }
    
    private static Object solveSystem(List<Node> arg) {
    
    }
    
    private static Object vector(List<Node> arg) {
    
    }
    
    private static Object matrix(List<Node> arg) {
    
    }
    
    
    
    private static Object sum(List<Node> nodes) { 
        Object[] summ = new Object[2];
        
        summ[0] = nodes.get(0);
        summ[1] = nodes.get(1);
        
        while (summ[0] instanceof Node) {
            summ[0] = evaluateNode((Node) summ[0]);
        }
        
        while (summ[1] instanceof Node) {
            summ[1] = evaluateNode((Node) summ[1]);
        }
        
        if (summ[0].getClass() != summ[1].getClass()) {
            throw new CommandException("Invalid types for sum");
        }
        
        if (summ[0] instanceof Vector) {
            Vector v1 = (Vector) summ[0];
            Vector v2 = (Vector) summ[1];
            
            return v1.add(v2);
        }
        
        if (summ[0] instanceof Matrix) {
            Matrix v1 = (Matrix) summ[0];
            Matrix v2 = (Matrix) summ[1];
            
            return v1.add(v2);
        }
        
        if (summ[0] instanceof Double) {
            return (Double) summ[0] + (Double) summ[1];
        }
        
        return null;
    }
    
    private static Object sub(List<Node> nodes) {
        
    }
    
    private static Object times(List<Node> nodes) {
        
    }
    
    private static Object div(List<Node> nodes) {
        
    }

    
}