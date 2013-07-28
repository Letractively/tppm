/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.utils;

import java.util.Date;
import java.util.GregorianCalendar;

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
    
}
