/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.XMLDAOExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class ErroAoCarregarOArquivoException extends GenericXMLDAOException {

    /**
     * Creates a new instance of <code>ErroAoCarregarOArquivoException</code> without detail message.
     */
    public ErroAoCarregarOArquivoException() {
    }

    /**
     * Constructs an instance of <code>ErroAoCarregarOArquivoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ErroAoCarregarOArquivoException(String msg) {
        super(msg);
    }
}
