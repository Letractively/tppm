/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.DAOExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraTaxaDeJurosDAOException extends Exception {

    /**
     * Creates a new instance of <code>RegraTaxaDeJurosDAOException</code> without detail message.
     */
    public RegraTaxaDeJurosDAOException() {
    }

    /**
     * Constructs an instance of <code>RegraTaxaDeJurosDAOException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public RegraTaxaDeJurosDAOException(String msg) {
        super(msg);
    }
}
