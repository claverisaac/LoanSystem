/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.utilidades;

/**
 *
 * @author cgarcia
 */
public class IndicesCatalogos {
    
    private String monedaArr[]={"Córdobas","Dólares","Euros"};
    private String periodoArr[]={"Dia", "Semana", "Mes", "Año"};
    
    
    /**
     * 
     * @param moneda
     * @return 
     */
    public int getIndiceMoneda(String moneda){
        System.out.println("Moneda: "+moneda);
        
        int indice = -1;
        
        for(int i=0; i<monedaArr.length;i++)
        {
            if(moneda.equals(monedaArr[i]))
            {
               indice = i; 
            }
            
        }
        
         System.out.println("Indice Moneda: "+indice);
        return indice;
    }
    
    /**
     * 
     * @param periodo
     * @return 
     */
    public int getIndicePeriodo(String periodo){
        int indice = -1;
        
        for(int i=0; i<periodoArr.length;i++)
        {
            if(periodo.equals(periodoArr[i]))
            {
                 indice = i;
            }
           
        }        
        
        return indice;
    }
    


    
}
