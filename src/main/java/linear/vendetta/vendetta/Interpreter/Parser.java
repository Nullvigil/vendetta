/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linear.vendetta.vendetta.Interpreter;

import java.util.List;
import linear.vendetta.vendetta.Interpreter.Token.TokenType;

/**
 *
 * @author ian
 */
public class Parser {
    private final List<Token> tokens;
    private int pos = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private Token peek() {                          
        return tokens.get(pos);
    }

    private Token next() {                          
        Token t = tokens.get(pos);
        if (t.tokenType != TokenType.END) {
            pos++;                                  
        }
        return t;
    }

    private Token expect(TokenType type, String message) {   
        if (peek().tokenType != type) {
            throw new CommandException(message);
        }
        return next();
    }

    public Node parse() {
        Node tree = parseStatement();
        if (peek().tokenType != TokenType.END) {   
            throw new CommandException("Unexpected '" + peek().oriText + "'");
        }
        return tree;
    }
    
    
    private Node parseFactor() {
        
    }
    
    private Node parseUnary() {
        
    }
    
    private Node parseExpression() {
        
    }

    private Node parseTerm() {
    
    }
    
    private Node parseStatement() {
        
    }
}
