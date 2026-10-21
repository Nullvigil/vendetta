/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

import java.util.List;

/**
 *
 * @author ian
 */
public class Tokenizer {
    private String command;
    private List<Token> tokens;
    private List<String> reservedWords = List.of("Adj","Inv","Trans","Det","Dot", "Cross", "Project", "SolveSystem", "Vector", "Matrix");
    
     
    public Tokenizer(String command) {
        this.command = command;
        
        tokenize();
    }
    
    private void tokenize() {
        StringBuilder current = new StringBuilder();
        
        for (int i = 0; i < command.length(); i++) {
            
        }
        
        tokens.add(new Token("", Token.TokenType.END));
    }
    
    public List<Token> getTokens() {
        return tokens;
    }
}
