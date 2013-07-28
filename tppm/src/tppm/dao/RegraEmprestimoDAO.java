/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import tppm.domains.RegraEmprestimo;
import tppm.exceptions.RegraEmprestimoException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public interface RegraEmprestimoDAO {
    public RegraEmprestimo procurar(String sexo, int idade, Double salario) throws RegraEmprestimoException;
    public int obterIdadeMinima(String sexo) throws RegraEmprestimoException;
    public int obterIdadeMaxima(String sexo) throws RegraEmprestimoException;
    public void incluir(RegraEmprestimo regraEmprestimoEmpregado) throws RegraEmprestimoException;
    public void excluir(RegraEmprestimo regraEmprestimoEmpregado) throws RegraEmprestimoException;
    public void alterar(RegraEmprestimo regraEmprestimoEmpregado) throws RegraEmprestimoException;
}
