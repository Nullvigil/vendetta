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
    private Node root;
    private HashMap<String, Object> memory = new HashMap();
    
    public Evaluator(Node root, HashMap<String, Object> memory) {
        this.root = root;
        this.memory = memory;
    }
    
    Object evaluateNode(List<Node> root) {
        for (Node node: root) {
            switch (node.kind()) {
                case NodeKind.ASSIGN:
                    memory.put(node.text(), evaluateNode(node.children()));
                break;
                
                case NodeKind.BINARY:
                    
                break;
                
                case NodeKind.CALL:
                    switch(node.text()) {
                        case 
                    }
                break;
                
                case NodeKind.NAME:
                    if (!memory.containsKey(node.text())) {
                        throw new CommandException(String.format("%s is used but never initialized!", node.text()));
                    }
                    
                    return memory.get(node.text());
                
                case NodeKind.NUMBER: return Double.parseDouble(node.text());
                
            }

        }    
    }
    
    private Node evaluateBin(Node node) {
        return switch(node.text()) {
            case "+" ->  {
                sum(node.children());
            };
            case "-" -> ;
            case "/" -> ;
            case "*" -> ;    
        }
    } 
    
    private Object sum(List<Object> os) {
        if (os.get(0).getClass() != os.get(1).getClass()) {
            throw new CommandException("Invalid sum");
        }
        
        
        return switch(os.get(0).getClass()) {
            case Vector -> os.get(0).add(os.get(1));
        }    
    }
}