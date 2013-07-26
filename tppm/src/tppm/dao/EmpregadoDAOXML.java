/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import tppm.domains.Empregado;
import tppm.exceptions.EmpregadoDAOException;

/**
 *
 * @author Drope
 */

public class EmpregadoDAOXML implements EmpregadoDAO{
    
    private static final String NOME_ARQUIVO = "empregadosRepositorio.xml";
    
    private HashMap<String, Empregado> carregarEmpregadosDoArquivo()throws EmpregadoDAOException{
        XMLDecoder xml = null;

        HashMap<String, Empregado> listaEmpregados = new HashMap<String, Empregado>();

        try{
            try{
                
                xml = new XMLDecoder(new FileInputStream(NOME_ARQUIVO));
                listaEmpregados = (HashMap<String, Empregado>) xml.readObject();
            
            }finally{
                if (xml != null){
                    xml.close();
                }
            }
        } 
        catch(IOException e){
           throw new EmpregadoDAOException("Não foi possivel carregar os dados dos Empregados"); 
           //TODO: Se o arquivo não existir, lançar uma excessao para a criação dele.
        }
        
        return listaEmpregados;
    }
    
    private void salvarEmpregadosNoArquivo( HashMap<String, Empregado> empregado)throws EmpregadoDAOException{
        XMLEncoder xml = null;
        try{
            try{
                xml = new XMLEncoder(new FileOutputStream(NOME_ARQUIVO));
                xml.writeObject(empregado); 
            }finally{
                if (xml != null){
                    xml.close();
                }
            }
        } 
        catch(IOException e){
           throw new EmpregadoDAOException("Não foi possivel salvar os dados dos Empregados");
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
        empregados.put(empregado.getCpf(),empregado);
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
        empregados.put(empregado.getCpf(),empregado);        
        salvarEmpregadosNoArquivo(empregados);
    }
}
