/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

/**
 *
 * @author ian
 */
public class CompiledResult {
    private String command;
    private Object result;
    
    public CompiledResult(String command, Object result) {
        this.command = command;
        this.result = result;
    }
    
    public String getCommand() {
        return command;
    }
    
    public Object getResult() {
        return result;
    }
}
