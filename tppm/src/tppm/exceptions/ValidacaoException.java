/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions;

/**
 *
 * @author Tiago
 */
public class ValidacaoException extends Exception {

    /**
     * Creates a new instance of <code>ValidacaoException</code> without detail message.
     */
    public ValidacaoException() {
    }

    /**
     * Constructs an instance of <code>ValidacaoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ValidacaoException(String msg) {
        super(msg);
    }
}
