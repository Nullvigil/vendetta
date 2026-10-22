/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ian
 */
public class Tokenizer {
    private String command;
    private List<Token> tokens = new ArrayList<>();
    private static final List<String> reservedWords = List.of("Adj","Inv","Trans","Det","Dot", "Cross", "Project", "SolveSystem", "Vector", "Matrix");
    
     
    public Tokenizer(String command) throws CommandException {
        this.command = command;
        
        tokenize();
    }
    
    private void tokenize() throws CommandException {
        StringBuilder current = new StringBuilder();
        char[] commandChars = command.toCharArray();
        
        
        for (int i = 0; i < command.length(); i++) {
            
            switch (commandChars[i]) {
                case ',' -> {
                    validate(current.toString());
                    tokens.add(new Token(",", Token.TokenType.COMMA));
                    clear(current);
                    continue;
                }
                case '=' -> {
                    validate(current.toString());
                    tokens.add(new Token("=", Token.TokenType.EQUALS));
                    clear(current);
                    continue;
                }
                case '(' -> {
                    validate(current.toString());
                    tokens.add(new Token("(", Token.TokenType.LPAREN));
                    clear(current);
                    continue;
                }
                case '-' -> {
                    validate(current.toString());
                    tokens.add(new Token("-", Token.TokenType.MINUS));
                    clear(current);
                    continue;
                }
                case '+' -> {
                    validate(current.toString());
                    tokens.add(new Token("+", Token.TokenType.PLUS));
                    clear(current);
                    continue;
                }
                case ')' -> {
                    validate(current.toString());
                    tokens.add(new Token(")", Token.TokenType.RPAREN));
                    clear(current);
                    continue;
                }
                case '/' -> {
                    validate(current.toString());
                    tokens.add(new Token("/", Token.TokenType.SLASH));
                    clear(current);
                    continue;
                }
                case '*' -> {
                    validate(current.toString());
                    tokens.add(new Token("*", Token.TokenType.STAR));
                    clear(current);
                    continue;
                }
               
            }
            
            if (Character.isWhitespace(commandChars[i])) {
                validate(current.toString());
                clear(current);
                continue;
            }    
            
            current.append(commandChars[i]);
        }
        
        validate(current.toString());
        tokens.add(new Token("", Token.TokenType.END));
    }
    
    private void validate(String str) throws CommandException {
        if (str.isEmpty()) {
            return;
        }
        
        if (reservedWords.contains(str)) {
            tokens.add(new Token(str, Token.TokenType.FUNCT));
        } else if (str.matches("^[a-zA-Z][a-zA-Z0-9]*$")) {
            tokens.add(new Token(str, Token.TokenType.NAME));
        } else if (str.matches("^\\d+(\\.\\d+)?$")) {
            tokens.add(new Token(str, Token.TokenType.NUMBER));
        } else {
            throw new CommandException();
        }   
    }
    
    private void clear(StringBuilder str) {
        str.setLength(0);
    }
    
    public List<Token> getTokens() {
        return tokens;
    }
}
