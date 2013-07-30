/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions;

/**
 *
 * @author Tiago
 */
public class NumeroDePrestacoesParserErrorException extends Exception {

    /**
     * Creates a new instance of <code>NumeroDePrestacoesParserErrorException</code> without detail message.
     */
    public NumeroDePrestacoesParserErrorException() {
    }

    /**
     * Constructs an instance of <code>NumeroDePrestacoesParserErrorException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NumeroDePrestacoesParserErrorException(String msg) {
        super(msg);
    }
}
