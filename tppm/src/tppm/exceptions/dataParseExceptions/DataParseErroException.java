/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.dataParseExceptions;

/**
 *
 * @author Tiago
 */
public class DataParseErroException extends Exception {

    /**
     * Creates a new instance of <code>DataParseErroException</code> without detail message.
     */
    public DataParseErroException() {
    }

    /**
     * Constructs an instance of <code>DataParseErroException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataParseErroException(String msg) {
        super(msg);
    }
}
