/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.XMLDAOExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class GenericXMLDAOException extends Exception {

    /**
     * Creates a new instance of <code>GenericXMLDAOException</code> without detail message.
     */
    public GenericXMLDAOException() {
    }

    /**
     * Constructs an instance of <code>GenericXMLDAOException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public GenericXMLDAOException(String msg) {
        super(msg);
    }
}
