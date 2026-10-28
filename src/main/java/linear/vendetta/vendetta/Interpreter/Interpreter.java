/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author ian
 */
public class Interpreter {
    private static HashMap<String, Object> memory = new HashMap();
    
    public static void assignToMemory(String name, Object obj) {
        memory.put(name, obj);
    }
    
    public static HashMap<String, Object> getMemory() {
        return memory;
    }    
}
