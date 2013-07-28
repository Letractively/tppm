/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmprestimoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class NumeroDePrestacoesMaiorQueOPermitidoException extends ValidacaoEmprestimoException {

    /**
     * Creates a new instance of <code>NumeroDePrestacoesMaiorQueOPermitidoException</code> without detail message.
     */
    public NumeroDePrestacoesMaiorQueOPermitidoException() {
    }

    /**
     * Constructs an instance of <code>NumeroDePrestacoesMaiorQueOPermitidoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NumeroDePrestacoesMaiorQueOPermitidoException(String msg) {
        super(msg);
    }
}
