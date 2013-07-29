/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.dataParseExceptions;

/**
 *
 * @author Tiago
 */
public class DataDeNascimentoParserErrorException extends DataParseErroException {

    /**
     * Creates a new instance of <code>DataDeNascimentoParserErrorException</code> without detail message.
     */
    public DataDeNascimentoParserErrorException() {
    }

    /**
     * Constructs an instance of <code>DataDeNascimentoParserErrorException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataDeNascimentoParserErrorException(String msg) {
        super(msg);
    }
}
