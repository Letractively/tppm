/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.utils;

import java.util.Date;
import tppm.exceptions.*;

/**
 *
 * @author Tiago
 */
public class ValidacaoUtils {
    
    static public void validaStringObrigatoria(String stringObrigatoria, String nomeVariavel) throws ValidacaoException{
        if(stringObrigatoria == null) throw new ValidacaoException("O campo '"+nomeVariavel+"' é obrigatório!");
        if(stringObrigatoria.equals("")) throw new ValidacaoException("O campo '"+nomeVariavel+"' não pode ser vazio!");
    }
    
    static public void validaDataObrigatoria(Date dataObrigatoria, String nomeVariavel) throws ValidacaoException{
        if(dataObrigatoria == null) throw new ValidacaoException("O campo '"+nomeVariavel+"' é obrigatório!");
    }
    
    static public void validaDoubleObrigatorio(Double doubleObrigatorio, String nomeVariavel) throws ValidacaoException{
        if(doubleObrigatorio == null) throw new ValidacaoException("O campo '"+nomeVariavel+"' é obrigatório!");
    }
    
    static public void validaSeDataAnteriorADataHoje(Date data, String nomeVariavel) throws ValidacaoException{
        Date dataHoje = new Date();
        if(!data.before(dataHoje)){
            throw new ValidacaoException("A data '"+nomeVariavel+"' deve ser anterior a data de hoje!");
        }
    }
    
    static public void validaNumeroCPF(String cpf) throws ValidacaoException{
        //Código obtido no link passado no trabalho: http://javafree.uol.com.br/topic-860897-Validar-CPF--CNPJ-e-consultar-CEP.html
        
        int     d1, d2;  
        int     digito1, digito2, resto;  
        int     digitoCPF;  
        String  nDigResult;  

        d1 = d2 = 0;  
        digito1 = digito2 = resto = 0;  

        for (int nCount = 1; nCount < cpf.length() -1; nCount++){  
            digitoCPF = Integer.valueOf (cpf.substring(nCount -1, nCount)).intValue();  

            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
            d1 = d1 + ( 11 - nCount ) * digitoCPF;  

            //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
            d2 = d2 + ( 12 - nCount ) * digitoCPF;  
        }

        //Primeiro resto da divisão por 11.  
        resto = (d1 % 11);  

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2)  
            digito1 = 0;  
        else  
            digito1 = 11 - resto;  

        d2 += 2 * digito1;  

        //Segundo resto da divisão por 11.  
        resto = (d2 % 11);  

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2)  
            digito2 = 0;  
        else  
            digito2 = 11 - resto;  

        //Digito verificador do CPF que está sendo validado.  
        String nDigVerific = cpf.substring (cpf.length()-2, cpf.length());  

        //Concatenando o primeiro resto com o segundo.  
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);  

        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
        if(!nDigVerific.equals(nDigResult)){
            throw new ValidacaoException("O CPF inserido não é válido!");
        }
    }
}
