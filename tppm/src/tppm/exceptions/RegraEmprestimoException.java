/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraEmprestimoException extends Exception {

    /**
     * Creates a new instance of <code>RegraEmprestimoException</code> without detail message.
     */
    public RegraEmprestimoException() {
    }

    /**
     * Constructs an instance of <code>RegraEmprestimoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public RegraEmprestimoException(String msg) {
        super(msg);
    }
}
