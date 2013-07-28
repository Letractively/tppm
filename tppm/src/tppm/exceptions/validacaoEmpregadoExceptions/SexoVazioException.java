/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class SexoVazioException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>SexoVazioException</code> without detail message.
     */
    public SexoVazioException() {
    }

    /**
     * Constructs an instance of <code>SexoVazioException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SexoVazioException(String msg) {
        super(msg);
    }
}
