/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

import java.util.HashMap;
import java.util.List;
import linear.vendetta.vendetta.API.Vector;
import linear.vendetta.vendetta.Interpreter.Node.NodeKind;

/**
 *
 * @author ian
 */
public class Evaluator {
    private static HashMap<String, Object> memory = Interpreter.getMemory();
    
    public static Object evaluateNode(List<Node> root) {
        for (Node node: root) {
            return switch (node.kind()) {
                case NodeKind.ASSIGN -> assign(node);
                
                case NodeKind.BINARY -> bin(node);
                
                case NodeKind.CALL -> call(node);
                
                case NodeKind.NAME -> memory.containsKey(node.text()) ? memory.get(root.text()) : throw new CommandException(String.format("%s is used but never initialized!", node.text()));  
                    
                case NodeKind.NUMBER -> Double.parseDouble(node.text());                
            };
        }    
    }
    
    private static Object assign(Node node) {
        Interpreter.assignToMemory(node.text(), evaluateNode(node.children()));
        return evaluateNode(node.children());
    }

    private static Object bin(Node node) {
        return switch(node.text()) {
            case "+" -> sum(node.children());
            case "-" -> sub(node.children());
            case "*" -> times(node.children());
            case "/" -> div(node.children());    
        }
    }
    
    private static Object sum(List<Node> nodes) {
        
    }
    
    private static Object sub(List<Node> nodes) {
        
    }
    
    private static Object times(List<Node> nodes) {
        
    }
    
    private static Object div(List<Node> nodes) {
        
    }

    private static Object call(Node node) {
    
    }    
}