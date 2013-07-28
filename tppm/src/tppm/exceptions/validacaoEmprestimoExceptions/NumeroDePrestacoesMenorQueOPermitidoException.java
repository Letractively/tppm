/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmprestimoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class NumeroDePrestacoesMenorQueOPermitidoException extends ValidacaoEmprestimoException {

    /**
     * Creates a new instance of <code>NumeroDePrestacoesMenorQueOPermitidoException</code> without detail message.
     */
    public NumeroDePrestacoesMenorQueOPermitidoException() {
    }

    /**
     * Constructs an instance of <code>NumeroDePrestacoesMenorQueOPermitidoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NumeroDePrestacoesMenorQueOPermitidoException(String msg) {
        super(msg);
    }
}
