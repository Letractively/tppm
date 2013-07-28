/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.DAOExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraEmprestimoDAOException extends Exception {

    /**
     * Creates a new instance of <code>RegraEmprestimoDAOException</code> without detail message.
     */
    public RegraEmprestimoDAOException() {
    }

    /**
     * Constructs an instance of <code>RegraEmprestimoDAOException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public RegraEmprestimoDAOException(String msg) {
        super(msg);
    }
}
