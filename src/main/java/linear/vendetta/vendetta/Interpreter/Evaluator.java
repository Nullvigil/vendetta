/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

import java.util.ArrayList;
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
                
            case NodeKind.NAME -> lookup(root.text());  
                
            case NodeKind.NUMBER -> Double.parseDouble(root.text());                
        };
       
    }
    
    private static Object lookup(String name) {
    Object value = memory.get(name);
    if (value == null) {
        throw new CommandException(name + " is used but never initialized!");
    }
    return value;
}
    
    private static Object assign(Node root) {
        Object value = evaluateNode(root.children().get(0));
        
        Interpreter.assignToMemory(root.text(), value);
        
        return value;
    }

    private static Object bin(Node node) {
        Object left  = evaluateNode(node.children().get(0));
        Object right = evaluateNode(node.children().get(1));
        
        return switch(node.text()) {
            case "+" -> sum(left, right);
            case "-" -> sub(left, right);
            case "*" -> times(left, right);
            case "/" -> div(left, right);    
            default -> throw new IllegalStateException("Unexpected value: " + (node.text()));
        };
    }
    
    //"Adj","Inv","Trans","Det","Dot", "Cross", "Project", "SolveSystem", "Vector", "Matrix"
    private static Object call(Node node) {
        List<Object> args = new ArrayList<>();
        
        for (Node child : node.children()) {
            args.add(evaluateNode(child));
        }
        
        return switch(node.text()) {
            case "adj" -> adj(args);
            case "inv" -> inv(args);
            case "trans" -> trans(args);
            case "det" -> det(args);
            case "project" -> project(args);
            case "solveSystem" -> solveSystem(args);
            case "Vector" -> vector(args);
            case "Matrix" -> matrix(args);    
                
            default -> throw new IllegalStateException("Unexpected value: " + (node.text()));
        };
    }    
    
    private static Object adj(List<Object> args) {
    
    }
    
    private static Object inv(List<Object> args) {
    
    }

    private static Object trans(List<Object> args) {
    
    }
    
    private static Object det(List<Object> args) {
    
    }
    
    private static Object project(List<Object> args) {
    
    }
    
    private static Object solveSystem(List<Object> args) {
    
    }
    
    private static Object vector(List<Object> args) {
    
    }
    
    private static Object matrix(List<Object> args) {
    
    }
    
    
    
    private static Object sum(Object o1, Object o2) { 
        if (o1.getClass() != o1.getClass()) {
            throw new CommandException("Invalid types for sum");
        }
        
        if (o1 instanceof Vector) {
            Vector v1 = (Vector) o1;
            Vector v2 = (Vector) o2;
            
            return v1.add(v2);
        }
        
        if (o1 instanceof Matrix) {
            Matrix v1 = (Matrix) o1;
            Matrix v2 = (Matrix) o2;
            
            return v1.add(v2);
        }
        
        if (o1 instanceof Double) {
            return (Double) o1 + (Double) o1;
        }
        
        return null;
    }
    
    private static Object sub(Object o1, Object o2) {
        if (o1.getClass() != o1.getClass()) {
            throw new CommandException("Invalid types for sum");
        }
        
        if (o1 instanceof Vector) {
            Vector v1 = (Vector) o1;
            Vector v2 = (Vector) o2;
            
            return v1.subtract(v2);
        }
        
        if (o1 instanceof Matrix) {
            Matrix v1 = (Matrix) o1;
            Matrix v2 = (Matrix) o2;
            
            return v1.subtract(v2);
        }
        
        if (o1 instanceof Double) {
            return (Double) o1 - (Double) o1;
        }
        
        return null;
    }
    
    private static Object times(Object o1, Object o2) {
        if (o1 instanceof Vector && o2 instanceof Vector) {
            Vector v1 = (Vector) o1;
            Vector v2 = (Vector) o2;
            
            return v1.dotProduct(v2);
        }
        
        if (o1 instanceof Matrix && o2 instanceof Matrix) {
            Matrix v1 = (Matrix) o1;
            Matrix v2 = (Matrix) o2;
            
            return v1.multiply(v2);
        }
        
        if (o1 instanceof Double && o2 instanceof Double) {
            return (Double) o1 * (Double) o2;
        }
     
        return null;
    }
    
    private static Object div(Object o1, Object o2) {
        
    }
}