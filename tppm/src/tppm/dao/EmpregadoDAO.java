/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import tppm.domains.Empregado;

/**
 *
 * @author Tiago
 */
public interface EmpregadoDAO {
    Empregado procurar(String cpf);
    void incluir(Empregado empregado);
    void excluir(Empregado empregado);
    void alterar(Empregado empregado);
}
