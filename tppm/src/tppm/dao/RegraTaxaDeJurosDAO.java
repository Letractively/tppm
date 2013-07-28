/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import tppm.domains.RegraTaxaDeJuros;
import tppm.exceptions.RegraTaxaDeJurosDAOException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public interface RegraTaxaDeJurosDAO {
    public RegraTaxaDeJuros procurar(int numeroPrestacoes) throws RegraTaxaDeJurosDAOException;
    public int obterNumeroMinimoPrestacoes() throws RegraTaxaDeJurosDAOException;
    public int obterNumeroMaximoPrestacoes() throws RegraTaxaDeJurosDAOException;
    public void incluir(RegraTaxaDeJuros taxaDeJuros) throws RegraTaxaDeJurosDAOException;
    public void excluir(RegraTaxaDeJuros taxaDeJuros) throws RegraTaxaDeJurosDAOException;
    public void alterar(RegraTaxaDeJuros taxaDeJuros) throws RegraTaxaDeJurosDAOException;
}
