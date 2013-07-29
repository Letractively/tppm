/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains.dao;

import java.util.ArrayList;
import java.util.List;
import tppm.domains.RegraEmprestimo;
import tppm.exceptions.DAOExceptions.RegraEmprestimoDAOException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraEmprestimoDAOMemoria implements RegraEmprestimoDAO{
    
    private List<RegraEmprestimo> regrasDeEmprestimo;

    public RegraEmprestimoDAOMemoria() {
        regrasDeEmprestimo = new ArrayList<RegraEmprestimo>();
    }
    
    public void excluirTudo() throws RegraEmprestimoDAOException{
        regrasDeEmprestimo = new ArrayList<RegraEmprestimo>();
    }
    
    public RegraEmprestimo procurar(String sexo, int idade, Double salario) throws RegraEmprestimoDAOException{
        for(RegraEmprestimo regra : regrasDeEmprestimo){
            if(regra.getSexo().equals(sexo) && regra.verificaSeIdadeEstaNaFaixa(idade) && regra.verificaSeSalarioEstaNaFaixa(salario))
                return regra;
        }
        return null;
    }
    
    public int obterIdadeMinima(String sexo) throws RegraEmprestimoDAOException{
        int idadeMinima = 0;
        for(RegraEmprestimo regra : regrasDeEmprestimo){
            if(regra.getSexo().equals(sexo) && (idadeMinima == 0 || regra.getIdadeMinima() < idadeMinima))
                idadeMinima = regra.getIdadeMinima();
        }
        return idadeMinima;
    }
    
    public int obterIdadeMaxima(String sexo) throws RegraEmprestimoDAOException{
        int idadeMaxima = 0;
        for(RegraEmprestimo regra : regrasDeEmprestimo){
            if(regra.getSexo().equals(sexo) && (idadeMaxima == 0 || regra.getIdadeMaxima() > idadeMaxima))
                idadeMaxima = regra.getIdadeMaxima();
        }
        return idadeMaxima;
    }
    
    public void incluir(RegraEmprestimo regraEmprestimoEmpregado) throws RegraEmprestimoDAOException{
        regrasDeEmprestimo.add(new RegraEmprestimo(regraEmprestimoEmpregado));
    }
    
    public void excluir(RegraEmprestimo regraEmprestimoEmpregado) throws RegraEmprestimoDAOException{
        regrasDeEmprestimo.remove(regraEmprestimoEmpregado);
    }
    
    public void alterar(RegraEmprestimo regraEmprestimoEmpregado) throws RegraEmprestimoDAOException{
        excluir(regraEmprestimoEmpregado);
        incluir(regraEmprestimoEmpregado);
    }
}
