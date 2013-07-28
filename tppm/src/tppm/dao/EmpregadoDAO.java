/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import tppm.domains.Empregado;
import tppm.exceptions.DAOExceptions.EmpregadoDAOException;

/**
 *
 * @author Tiago
 */
public interface EmpregadoDAO {
    public Empregado procurar(String cpf) throws EmpregadoDAOException;
    public void incluir(Empregado empregado) throws EmpregadoDAOException;
    public void excluir(Empregado empregado) throws EmpregadoDAOException;
    public void alterar(Empregado empregado) throws EmpregadoDAOException;
}
