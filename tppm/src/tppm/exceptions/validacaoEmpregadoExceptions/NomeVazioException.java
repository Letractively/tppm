/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class NomeVazioException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>NomeVazioException</code> without detail message.
     */
    public NomeVazioException() {
    }

    /**
     * Constructs an instance of <code>NomeVazioException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NomeVazioException(String msg) {
        super(msg);
    }
}
