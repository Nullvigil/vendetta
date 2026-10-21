/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

/**
 *
 * @author ian
 */
public class CommandException extends Exception {

    /**
     * Creates a new instance of <code>CommandException</code> without detail
     * message.
     */
    public CommandException() {
    }

    /**
     * Constructs an instance of <code>CommandException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CommandException(String msg) {
        super(msg);
    }
}
