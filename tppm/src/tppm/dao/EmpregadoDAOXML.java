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
    
    private HashMap<String, Empregado> carregar()throws EmpregadoDAOException{
        XMLDecoder xml = null;

        HashMap<String, Empregado> listaEmpregados = new HashMap<String, Empregado>();

        try{
            try{
                
                xml = new XMLDecoder(new FileInputStream("listaEmpregados.xml"));
                listaEmpregados = (HashMap<String, Empregado>) xml.readObject();
            
            }finally{
                if (xml != null){
                    xml.close();
                }
            }
        } 
        catch(IOException e){
           throw new EmpregadoDAOException("Não foi possivel carregar os dados dos Empregados");   
        }
        
        return listaEmpregados;
    }
    
    private void salvar( HashMap<String, Empregado> empregado)throws EmpregadoDAOException{
        XMLEncoder xml = null;
        try{
            try{
                xml = new XMLEncoder(new FileOutputStream("listaEmpregados.xml"));
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
        
        HashMap<String, Empregado> listaEmpregados = new HashMap<String, Empregado>();
        Empregado empregado = new Empregado();
        
        try{
            listaEmpregados = carregar();
        } catch ( EmpregadoDAOException e ){
            throw e;
        }
                
        empregado = listaEmpregados.get(cpf);
        
        return empregado;

    }
    public void incluir(Empregado empregado) throws EmpregadoDAOException{
        
        HashMap<String, Empregado> listaEmpregados = new HashMap<String, Empregado>();
                
        listaEmpregados = carregar();       
        
        listaEmpregados.put(empregado.getCpf(),empregado);
        
        try{
            salvar(listaEmpregados);
        } catch ( EmpregadoDAOException e ){
             throw e;
        }
        
    }
    public void excluir(Empregado empregado) throws EmpregadoDAOException{
        
        HashMap<String, Empregado> listaEmpregados = new HashMap<String, Empregado>();
                
        try{
            listaEmpregados = carregar();
        } catch ( EmpregadoDAOException e ){
             throw e;
        }
        
        listaEmpregados.remove(empregado.getCpf());
        
        try{
            salvar(listaEmpregados);
        } catch ( EmpregadoDAOException e ){
             throw e;
        }
        
    }
    public void alterar(Empregado empregado) throws EmpregadoDAOException{
        HashMap<String, Empregado> listaEmpregados = new HashMap<String, Empregado>();
                
        try{
            listaEmpregados = carregar();
        } catch ( EmpregadoDAOException e ){
             throw e;
        }
        
        listaEmpregados.remove(empregado.getCpf());
        
        listaEmpregados.put(empregado.getCpf(),empregado);        
        
        try{
            salvar(listaEmpregados);
        } catch ( EmpregadoDAOException e ){
             throw e;
        }
    }
}
