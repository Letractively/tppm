/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.DAOExceptions.XMLDAOExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class ErroAoCriarArquivoException extends GenericXMLDAOException {

    /**
     * Creates a new instance of <code>ErroAoCriarArquivoException</code> without detail message.
     */
    public ErroAoCriarArquivoException() {
    }

    /**
     * Constructs an instance of <code>ErroAoCriarArquivoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ErroAoCriarArquivoException(String msg) {
        super(msg);
    }
}
