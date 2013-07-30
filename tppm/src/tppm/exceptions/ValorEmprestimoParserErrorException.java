/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions;

/**
 *
 * @author Tiago
 */
public class ValorEmprestimoParserErrorException extends Exception {

    /**
     * Creates a new instance of <code>ValorEmprestimoParserErrorException</code> without detail message.
     */
    public ValorEmprestimoParserErrorException() {
    }

    /**
     * Constructs an instance of <code>ValorEmprestimoParserErrorException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ValorEmprestimoParserErrorException(String msg) {
        super(msg);
    }
}
