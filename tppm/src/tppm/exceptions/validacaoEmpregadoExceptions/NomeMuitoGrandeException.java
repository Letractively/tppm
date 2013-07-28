/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class NomeMuitoGrandeException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>NomeMuitoGrandeException</code> without detail message.
     */
    public NomeMuitoGrandeException() {
    }

    /**
     * Constructs an instance of <code>NomeMuitoGrandeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NomeMuitoGrandeException(String msg) {
        super(msg);
    }
}
