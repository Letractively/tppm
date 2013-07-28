/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions;

/**
 *
 * @author Tiago
 */
public class ErroAoInicializarDAOsMemoriaException extends Exception {

    /**
     * Creates a new instance of <code>ErroAoInicializarDAOsMemoriaException</code> without detail message.
     */
    public ErroAoInicializarDAOsMemoriaException() {
    }

    /**
     * Constructs an instance of <code>ErroAoInicializarDAOsMemoriaException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ErroAoInicializarDAOsMemoriaException(String msg) {
        super(msg);
    }
}
