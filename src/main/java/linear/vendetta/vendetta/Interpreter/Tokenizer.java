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
        char[] commandChars = command.toCharArray();
        
        iteration:
        for (int i = 0; i < command.length(); i++) {
            
            switch (commandChars[i]) {
                case ',':
                    validate(current.toString());
                    tokens.add(new Token(",", Token.TokenType.COMMA));
                    clear(current);
                    
                continue iteration;
                case '=':
                    validate(current.toString());
                    tokens.add(new Token("=", Token.TokenType.EQUALS));
                    clear(current);
                continue iteration;
                case '(':
                    validate(current.toString());
                    tokens.add(new Token("(", Token.TokenType.LPAREN));
                    clear(current);
                continue iteration;
                case '-':
                    validate(current.toString());
                    tokens.add(new Token("-", Token.TokenType.MINUS));
                    clear(current);
                continue iteration;
                case '+':
                    validate(current.toString());
                    tokens.add(new Token("+", Token.TokenType.PLUS));
                    clear(current);
                continue iteration;
                case ')':
                    validate(current.toString());
                    tokens.add(new Token(")", Token.TokenType.RPAREN));
                    clear(current);
                continue iteration;
                case '/':
                    validate(current.toString());
                    tokens.add(new Token("/", Token.TokenType.SLASH));
                    clear(current);
                continue iteration;
                case '*':
                    validate(current.toString());
                    tokens.add(new Token("*", Token.TokenType.STAR));
                    clear(current);
                continue iteration;
                case ' ':
                    validate(current.toString());
                    clear(current);
                continue iteration;
            }
            
            current.append(commandChars[i]);
        }
        
        tokens.add(new Token("", Token.TokenType.END));
    }
    
    private void validate(String str) {
        if (!reservedWords.contains(str)) {
            
        }
    }
    
    private void clear(StringBuilder str) {
        str.delete(0, str.toString().length());
    }
    
    public List<Token> getTokens() {
        return tokens;
    }
}
