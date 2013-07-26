/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions;

/**
 *
 * @author Drope
 */
public class EmpregadoDAOException extends Exception {

    /**
     * Creates a new instance of <code>transacaoException</code> without detail message.
     */
    public EmpregadoDAOException() {
    }

    /**
     * Constructs an instance of <code>transacaoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmpregadoDAOException(String msg) {
        super(msg);
    }
}
