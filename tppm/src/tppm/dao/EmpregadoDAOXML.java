/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import java.util.HashMap;
import tppm.domains.Empregado;
import tppm.exceptions.EmpregadoDAOException;
import tppm.exceptions.XMLDAOExceptions.GenericXMLDAOException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class EmpregadoDAOXML implements EmpregadoDAO{
    
    private static final String NOME_ARQUIVO = "empregadosRepositorio.xml";
    private GenericXMLDAO genericXMLDAO = new GenericXMLDAO(NOME_ARQUIVO);
    
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

    public Empregado procurar(String cpf)throws EmpregadoDAOException{       
        HashMap<String, Empregado> empregados = carregarEmpregadosDoArquivo();
        Empregado empregado = new Empregado();
        empregado = empregados.get(cpf);
        return empregado;
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
