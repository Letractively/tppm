/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.utils;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import tppm.config.TPPMConfig;
import tppm.exceptions.dataParseExceptions.DataParseErroException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class Utils {
    
    public static int calculaDiferencaAnos(Date data1, Date data2){
        GregorianCalendar data1Calendar = new GregorianCalendar();  
        data1Calendar.setTime(data1);  
        GregorianCalendar data2Calendar = new GregorianCalendar();
        if(data2 != null) data2Calendar.setTime(data2); 
        int diferenca = data2Calendar.get(GregorianCalendar.YEAR) - data1Calendar.get(GregorianCalendar.YEAR);  
        if (data2Calendar.get(GregorianCalendar.DAY_OF_YEAR) < data1Calendar.get(GregorianCalendar.DAY_OF_YEAR))  
            diferenca--;  
        return diferenca;
    }
    
    public static Date adicionarAnosNaData(Date dataAntiga, int quantidadeAnos){
        return adicionarNaData(GregorianCalendar.YEAR, dataAntiga, quantidadeAnos);
    }
    
    public static Date adicionarDiasNaData(Date dataAntiga, int quantidadeDias){
        return adicionarNaData(GregorianCalendar.DAY_OF_MONTH, dataAntiga, quantidadeDias);
    }
    
    public static Date adicionarNaData(int campo, Date dataAntiga, int quantidade){
        GregorianCalendar dataNova = new GregorianCalendar();
        dataNova.setTime(dataAntiga);
        dataNova.add(campo, quantidade);
        return dataNova.getTime();
    }
    
    public static Date dataAtual(){
        return new Date();
    }
    
    public static Date converterStringParaData(String data) throws DataParseErroException{
        try{
            if(data == null || data.length() == 0) return null;
            SimpleDateFormat formato = new SimpleDateFormat(TPPMConfig.FORMATO_DATA);  
            formato.setLenient(false);
            return formato.parse(data);
        }
        catch(Exception e){
            throw new DataParseErroException("O padrão de data não foi reconhecido pelo sistema");
        }
    }
    
    public static String converterDataParaString(Date data){
        SimpleDateFormat formato = new SimpleDateFormat(TPPMConfig.FORMATO_DATA);  
        formato.setLenient(false);
        return formato.format(data);
    }
    
    public static void exibeErro(Component component, String mensagem){
        JOptionPane.showMessageDialog(component, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void exibeMensagem(Component component, String mensagem){
        JOptionPane.showMessageDialog(component, mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
}
