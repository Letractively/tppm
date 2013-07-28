/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmprestimoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class ValorSolicitadoMaiorQueOPermitidoException extends ValidacaoEmprestimoException {

    /**
     * Creates a new instance of <code>ValorSolicitadoMaiorQueOPermitidoException</code> without detail message.
     */
    public ValorSolicitadoMaiorQueOPermitidoException() {
    }

    /**
     * Constructs an instance of <code>ValorSolicitadoMaiorQueOPermitidoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ValorSolicitadoMaiorQueOPermitidoException(String msg) {
        super(msg);
    }
}
