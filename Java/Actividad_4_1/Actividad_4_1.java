/**
 * Esta Práctica consite en realizar un programa en java que reciba como parametro de entrada el nombre de un entrada.txt .
 * 
 * 
 */

/**
 *
 * @author AJ
 */

import java.io.BufferedWriter;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;
import misClases.coche.coche;


public class Actividad_4_1 {

    /**
     * Métodos de la clase Actividad_4_1
     */
 
 
    
 private static void limpiarPantalla(){
     System.out.print("\033[H\033[2J");
     System.out.flush(); 
 }
 
private static boolean buscarCoincidencias(String cadena, String busca){
   return true;
}
 
 public static void main(String args[])
    {
    
        
        
      switch(args.length){
          
          case 0: System.out.println("Falta el nombre del fichero de entrada."); 
              break;
              
          case 1:   // Fichero del que queremos leer
		 System.out.printf("Fichero de entrada: %s ",args[0]);  
		
                 Scanner teclado = new Scanner(System.in);
                 Scanner fich  = null;
                 ArrayList<coche> flota = new ArrayList<coche>(); 
                 int opcion=0;
             
                 try {
                        File fichero = new File(args[0]);
                        System.out.println("... Leemos el contenido del fichero ...");
                           
                       // coche carAux = new coche();
                            
			    // Leemos linea a linea el fichero
                        do{
                            limpiarPantalla();
                            fich = new Scanner(fichero);
                            while (fich.hasNextLine()) {
                                    String linea = fich.nextLine();    // Guardamos la linea en un String
                                    System.out.println(linea);      // Imprimimos la linea
                            }
                             fich.close();                            // reseteo el scanner y lo vuelvo a cargar 
                           
                            opcion = teclado.nextInt();
                         
                            // desarrollo de las opciones de menu.
                            
                            switch(opcion) {
                                case 1: 
                                    limpiarPantalla();
                                    coche carAux = new coche(); 
                                    
                                    carAux.capturaDatos();    // Capturo los datos del Coche nuevo CarAux
                                    flota.add(carAux);     // Lo introduzco en la Flota.
                                 
                                    System.out.println("\n---------------------  Coche dado de Alta -----------------------");
                                    System.out.println(carAux.getCoche());
                                    System.out.println("------------------------------------------------------------------\n");                                     
                                    Thread.sleep(5000);
                                    
                                    break;
                                case 2: 
                                    limpiarPantalla();
                                    System.out.println("\n  La flota de vehiculos completa utilizando el metodo del arrayList \".forEach\"\n");
                                    System.out.println("------------------------------------------------------------------------------------\n");
                                    flota.forEach((c) -> { c.muestraDatos(); System.out.println();});
                                    
                                    System.out.println("\n\n  La flota de vehiculos completa utilizando FOR con  arrayList\n");
                                    System.out.println("------------------------------------------------------------------------------------\n");
                                    for(coche c: flota){
                                         System.out.println("Vehiculo : " + c.getCoche() );
                                     }
                                    
                                    Thread.sleep(5000);
                                    
                                    break;
                                case 3: {
                                    String busca;
                                  //  String registro="";    
                                  //  boolean resultado=false;
                                   List<coche> encontrados = new ArrayList<coche>();
                                    limpiarPantalla();
                                    System.out.print("\n Que desea encontrar: \n");
                                    busca = teclado.next();
                                    String busca1 ="["+busca+"]";
                                    
                                    
                                    flota.forEach((c) -> { 
                                        String registro;  
                                   
                                        registro =c.getCoche();
                                        boolean resultado= registro.contains(busca);
                                        if (resultado) { 
                                            encontrados.add(c);  
                                           
                                        }           // si encuentra coincidencia en algun campo lo añade a la lista de encontrados
                                    });
                                    
                                    if(encontrados.size()>0){
                                            System.out.printf("\n  Coches de la flota que contienen alguna coincidencia con ' %s ' \n",busca);
                                            System.out.println("-----------------------------------------------------------------------------------\n");       
                                            encontrados.forEach((c) -> { 
                                               c.muestraDatos(); System.out.println(); 
                                           });
                                    } else  System.out.printf("\n  No se ha encontrado ninguna coincidencia con ' %s ' \n",busca);
                                    
                                    Thread.sleep(10000);
                                }  
                                  break;
                                case 4: 
                                    limpiarPantalla();
                                    String ficheroSalida = "ListadoCoches.txt";
                             
                                         try {
                                                
                                               // Writer out = null;
                                                FileOutputStream fw = new FileOutputStream(ficheroSalida) ;
                                                Writer out = new BufferedWriter(new OutputStreamWriter(fw, "UTF-8"));

                                                 // Escribimos linea a linea en el fichero
                                                 for (coche car : flota) {
                                                         try {
                                                                 out.write(car.getCoche()+"\n");
                                                         } catch (Error ex) {
                                                                 System.out.println("Mensaje excepcion escritura: " + ex.getMessage());
                                                         }
                                                 }

                                         } catch (UnsupportedEncodingException | FileNotFoundException ex2) {
                                                 System.out.println("Mensaje error 2: " + ex2.getMessage());
                                         }
                                    break;
                                default: {}
                                    
                            }
                            
                            
                        } while(opcion != 5);

                    } catch (Exception ex) { 
			                            System.out.println("Mensaje: " + ex.getMessage());
                    } finally {
                                // Cerramos el fichero tanto si la lectura ha sido correcta o no
                                    try {
                                                    if (fich != null)	fich.close(); teclado.close();
                                    } catch (Exception ex2) { System.out.println("Mensaje 2: " + ex2.getMessage());	}
                                            }
               break;
          default:
             {  System.out.println("Hay demasiados parámetros. Debe escribir solo el nombre del fichero de entrada --> \"nombre.txt\""); }
          
      }  
      
     
        
        
    }
}
