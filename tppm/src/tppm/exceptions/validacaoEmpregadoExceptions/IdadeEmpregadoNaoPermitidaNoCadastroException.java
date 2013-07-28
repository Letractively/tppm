/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class IdadeEmpregadoNaoPermitidaNoCadastroException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>IdadeEmpregadoNaoPermitidaNoCadastroException</code> without detail message.
     */
    public IdadeEmpregadoNaoPermitidaNoCadastroException() {
    }

    /**
     * Constructs an instance of <code>IdadeEmpregadoNaoPermitidaNoCadastroException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public IdadeEmpregadoNaoPermitidaNoCadastroException(String msg) {
        super(msg);
    }
}
