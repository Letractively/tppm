/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains.dao;

import java.util.HashMap;
import tppm.domains.Empregado;
import tppm.exceptions.DAOExceptions.EmpregadoDAOException;
import tppm.exceptions.DAOExceptions.XMLDAOExceptions.GenericXMLDAOException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class EmpregadoDAOXML implements EmpregadoDAO{
    
    private GenericXMLDAO genericXMLDAO;

    public EmpregadoDAOXML(String nomeArquivo) {
        genericXMLDAO = new GenericXMLDAO(nomeArquivo);
    }
    
    private HashMap<String, Empregado> carregarEmpregadosDoArquivo() throws EmpregadoDAOException{
        HashMap<String, Empregado> resposta = null;
        try{
            resposta = (HashMap<String, Empregado>) genericXMLDAO.carregarDadosDoArquivo();
            if(resposta == null) resposta = new HashMap<String, Empregado>();
        } catch(GenericXMLDAOException e){
            throw new EmpregadoDAOException(e.getMessage());
        }
        return resposta;
    }
    
    private void salvarEmpregadosNoArquivo(HashMap<String, Empregado> empregados) throws EmpregadoDAOException{
        try {
            genericXMLDAO.salvarDadosNoArquivo(empregados);
        } catch (GenericXMLDAOException e) {
            throw new EmpregadoDAOException(e.getMessage());
        }      
    }
    
    public void limparArquivo() throws EmpregadoDAOException{
        salvarEmpregadosNoArquivo(null);
    }

    public Empregado procurar(String cpf)throws EmpregadoDAOException{       
        HashMap<String, Empregado> empregados = carregarEmpregadosDoArquivo();
        return empregados.get(cpf);
    }
    public void incluir(Empregado empregado) throws EmpregadoDAOException{
        HashMap<String, Empregado> empregados = carregarEmpregadosDoArquivo();
        empregados.put(empregado.getCpf(), empregado);
        salvarEmpregadosNoArquivo(empregados);
    }
    public void excluir(Empregado empregado) throws EmpregadoDAOException{
        HashMap<String, Empregado> empregados = carregarEmpregadosDoArquivo();
        empregados.remove(empregado.getCpf());
        salvarEmpregadosNoArquivo(empregados);    
    }
    public void alterar(Empregado empregado) throws EmpregadoDAOException{
        HashMap<String, Empregado> empregados = carregarEmpregadosDoArquivo();
        empregados.remove(empregado.getCpf());
        empregados.put(empregado.getCpf(), empregado);        
        salvarEmpregadosNoArquivo(empregados);
    }
}
