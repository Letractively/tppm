/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago
 */
public class CPFNaoEstaCadastradoException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>CPFNaoEstaCadastradoException</code> without detail message.
     */
    public CPFNaoEstaCadastradoException() {
    }

    /**
     * Constructs an instance of <code>CPFNaoEstaCadastradoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CPFNaoEstaCadastradoException(String msg) {
        super(msg);
    }
}
