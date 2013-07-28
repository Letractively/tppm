/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import tppm.domains.RegraEmprestimo;
import tppm.exceptions.DAOExceptions.RegraEmprestimoDAOException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public interface RegraEmprestimoDAO {
    public RegraEmprestimo procurar(String sexo, int idade, Double salario) throws RegraEmprestimoDAOException;
    public int obterIdadeMinima(String sexo) throws RegraEmprestimoDAOException;
    public int obterIdadeMaxima(String sexo) throws RegraEmprestimoDAOException;
    public void incluir(RegraEmprestimo regraEmprestimoEmpregado) throws RegraEmprestimoDAOException;
    public void excluir(RegraEmprestimo regraEmprestimoEmpregado) throws RegraEmprestimoDAOException;
    public void alterar(RegraEmprestimo regraEmprestimoEmpregado) throws RegraEmprestimoDAOException;
}
