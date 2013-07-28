/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.XMLDAOExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class ErroAoSalvarNoArquivoException extends GenericXMLDAOException {

    /**
     * Creates a new instance of <code>ErroAoSalvarNoArquivoException</code> without detail message.
     */
    public ErroAoSalvarNoArquivoException() {
    }

    /**
     * Constructs an instance of <code>ErroAoSalvarNoArquivoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ErroAoSalvarNoArquivoException(String msg) {
        super(msg);
    }
}
