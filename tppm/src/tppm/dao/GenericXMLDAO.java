/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import tppm.exceptions.DAOExceptions.XMLDAOExceptions.ErroAoCarregarOArquivoException;
import tppm.exceptions.DAOExceptions.XMLDAOExceptions.ErroAoCriarArquivoException;
import tppm.exceptions.DAOExceptions.XMLDAOExceptions.ErroAoSalvarNoArquivoException;
import tppm.exceptions.DAOExceptions.XMLDAOExceptions.GenericXMLDAOException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class GenericXMLDAO {
    
    private String nomeArquivo;

    public GenericXMLDAO(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    
    public Object carregarDadosDoArquivo() throws GenericXMLDAOException{
        XMLDecoder xml = null;
        Object resposta = null;
        
        try{
            try{            
                xml = new XMLDecoder(new FileInputStream(nomeArquivo));
                resposta = xml.readObject();
            
            } finally {
                if (xml != null){
                    xml.close();
                }
            }
        } 
        catch(FileNotFoundException e){
            criarArquivo();
        }
        catch(IOException e){
            throw new ErroAoCarregarOArquivoException("Não foi possível carregar os dados da aplicação!");
        }
        
        return resposta;
    }
    
    public void salvarDadosNoArquivo(Object dados) throws GenericXMLDAOException{
        XMLEncoder xml = null;
        try{
            try{
                xml = new XMLEncoder(new FileOutputStream(nomeArquivo));
                xml.writeObject(dados); 
            }finally{
                if (xml != null){
                    xml.close();
                }
            }
        } 
        catch(IOException e){
           throw new ErroAoSalvarNoArquivoException("Não foi possivel salvar os dados da aplicação!");
        }        
    }
    
    private void criarArquivo() throws ErroAoCriarArquivoException{
        try{
            salvarDadosNoArquivo(null);
        } catch(Exception e){
            throw new ErroAoCriarArquivoException("Não foi possivel criar o arquivo de dados da aplicação!");
        }
    }
}
