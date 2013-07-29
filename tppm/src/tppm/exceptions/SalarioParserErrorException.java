/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions;

/**
 *
 * @author Tiago
 */
public class SalarioParserErrorException extends Exception {

    /**
     * Creates a new instance of <code>SalarioParserErrorException</code> without detail message.
     */
    public SalarioParserErrorException() {
    }

    /**
     * Constructs an instance of <code>SalarioParserErrorException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SalarioParserErrorException(String msg) {
        super(msg);
    }
}
