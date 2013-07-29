/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains.dao;

import java.util.ArrayList;
import java.util.List;
import tppm.domains.RegraTaxaDeJuros;
import tppm.exceptions.DAOExceptions.RegraTaxaDeJurosDAOException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraTaxaDeJurosDAOMemoria implements RegraTaxaDeJurosDAO{
    
    private List<RegraTaxaDeJuros> regrasDeTaxaDeJuros;
    
    public RegraTaxaDeJurosDAOMemoria() {
        regrasDeTaxaDeJuros = new ArrayList<RegraTaxaDeJuros>();
    }
    
    public void excluirTudo() throws RegraTaxaDeJurosDAOException{
        regrasDeTaxaDeJuros = new ArrayList<RegraTaxaDeJuros>();
    }
    
    public RegraTaxaDeJuros procurar(int numeroPrestacoes) throws RegraTaxaDeJurosDAOException{
        for(RegraTaxaDeJuros regra : regrasDeTaxaDeJuros){
            if(regra.verificaNumeroDePrestacoesPertenceAFaixaDaTaxa(numeroPrestacoes))
                return regra;
        }
        return null;
    }
    
    public int obterNumeroMinimoPrestacoes() throws RegraTaxaDeJurosDAOException{
        int minimoDePrestacoes = 0;
        for(RegraTaxaDeJuros regra : regrasDeTaxaDeJuros){
            if(minimoDePrestacoes == 0 || regra.getNumeroMinimoDePrestacoes() < minimoDePrestacoes)
                minimoDePrestacoes = regra.getNumeroMinimoDePrestacoes();
        }
        return minimoDePrestacoes;
    }
    
    public int obterNumeroMaximoPrestacoes() throws RegraTaxaDeJurosDAOException{
        int maximoDePrestacoes = 0;
        for(RegraTaxaDeJuros regra : regrasDeTaxaDeJuros){
            if(maximoDePrestacoes == 0 || regra.getNumeroMaximoDePrestacoes() > maximoDePrestacoes)
                maximoDePrestacoes = regra.getNumeroMaximoDePrestacoes();
        }
        return maximoDePrestacoes;
    }
    
    public void incluir(RegraTaxaDeJuros taxaDeJuros) throws RegraTaxaDeJurosDAOException{
        regrasDeTaxaDeJuros.add(new RegraTaxaDeJuros(taxaDeJuros));
    }
    
    public void excluir(RegraTaxaDeJuros taxaDeJuros) throws RegraTaxaDeJurosDAOException{
        regrasDeTaxaDeJuros.remove(taxaDeJuros);
    }
    
    public void alterar(RegraTaxaDeJuros taxaDeJuros) throws RegraTaxaDeJurosDAOException{
        excluir(taxaDeJuros);
        incluir(taxaDeJuros);
    }
}
