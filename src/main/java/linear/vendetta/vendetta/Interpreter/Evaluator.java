/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

import java.util.HashMap;
import java.util.List;
import linear.vendetta.vendetta.API.Vector;
import linear.vendetta.vendetta.Interpreter.Node.NodeKind;
import linear.vendetta.vendetta.Interpreter.Interpreter;

/**
 *
 * @author ian
 */
public class Evaluator {
    
    
    public Evaluator(Node root, HashMap<String, Object> memory) {
        this.root = root;
        this.memory = memory;
    }
    
    public static Object evaluateNode(Node root) {
            return switch (root.kind()) {
                case NodeKind.ASSIGN -> Interpreter.assign();
                
                case NodeKind.BINARY -> evaluateBin(root);
                
                case NodeKind.CALL -> evaluateCall(root);
                
                case NodeKind.NAME -> memory.containsKey(root.text()) ? memory.get(root.text()) : throw new CommandException(String.format("%s is used but never initialized!", root.text()));
                
                case NodeKind.NUMBER -> Double.parseDouble(node.text());
                
            }

        }    
    }
    
    private Object evaluateBin(Node node) {
        return switch(node.text()) {
            case "+" ->  {
                sum(node.children());
            };
            case "-" -> ;
            case "/" -> ;
            case "*" -> ;    
        }
    } 
    
    private Object evaluateCall(Node node) {
        
    }    
    
    private Object sum(List<Object> os) {
        if (os.get(0).getClass() != os.get(1).getClass()) {
            throw new CommandException("Invalid sum");
        }
        
        
        return switch(os.get(0).getClass()) {
            case Vector -> (Vector) os.get(0).add((Vector) os.get(1));
        }    
    }
}
