
/**
 *
 * @author Aj
 */

package misClases.coche;

import java.util.Scanner;

 public class coche { // creación de la clase
    //atributos:

    private String color;
    private String fabricante;
    private String modelo;
    private float  peso;
    private float  largo;   
    private Integer velocidad = 0;
   
 
    // constructor/s: 
    //---------------
    
    public coche() {}
    
    public coche(String fabricante,   String modelo, String color, float peso, float largo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
        this.peso = peso;
        this.largo = largo;
    }
    
     public coche( String fabricante) {
      this.fabricante = fabricante;
    }
        

    // métodos de la clase:
     
    // gets y sets 
     
     public String getFabricante(){    return this.fabricante;   }
     public String getModelo(){         return this.modelo;     }
     public String getColor(){         return this.color;     }
     public float getPeso(){         return this.peso;     }
     public float getLargo(){         return this.largo;     }
     
     public void setFabricante(String fabricante){    this.fabricante=fabricante;   }
     public void setModelo(String modelo){          this.modelo=modelo;     }
     public void setColor(String color){      this.color=color;     }
     public void setPeso(float peso){         this.peso=peso;     }
     public void setLargo(float largo){        this.largo=largo;     }
     
     // otros metodos
    @SuppressWarnings("empty-statement")
     public void capturaDatos(){
         try {
             Scanner teclado = new Scanner(System.in);
             System.out.print("Fabricante: "); this.fabricante = teclado.next(); System.out.print("\n");
             System.out.print("Modelo: "); this.modelo= teclado.next();System.out.print("\n");
             System.out.print("Color: "); this.color = teclado.next();System.out.print("\n");
          //   System.out.print("Peso: ");  this.peso=Float.valueOf(teclado.nextFloat()); System.out.print("\n");
        
          boolean isFloat=false;
                    do{
                       try {
                          
                           System.out.print("Peso: "); String s = teclado.next();
                            isFloat =  s.matches("^[+-]?[0-9]*(([.]?[0-9]*)?)$");
                          
                           if (!isFloat){
                                System.out.printf("Entrada de teclado --> %s ,  Lanzada excepcion ",s);
                                System.out.println("     isfloat = " + isFloat);
                                throw  new CarException(" Error de datos, el tipo introducido debe ser float: ^[+-]?[0-9]*(([.]?[0-9]*)?)$ ");
                               
                           }else{
                               //  System.out.println("Capturada Excepción 'isfloat' = " + isFloat);
                                this.peso=Float.valueOf(s);
                           }
                          
                           
                            //Thread.sleep(3000);
                           
                           
                           if (!isFloat) throw  new CarException(" Error de datos, el 'peso' introducido debe ser flotante");
                        } catch(CarException e){     //en caso de error muestro el error personalizado
                             System.out.println("Mensaje: " + e.getMessage());   
                        }finally { // Finalmente, tanto si se produce error ejecutamos lo siguiente;
                           
                        }
                    }while(!isFloat);
                    
                    isFloat=false;
                    do{
                       try {
                          System.out.print("Largo: "); String s = teclado.next(); 
                        
                            isFloat =  s.matches("^[+-]?[0-9]*(([.]?[0-9]*)?)$");
                          
                           if (!isFloat){
                                System.out.printf("Entrada de teclado --> %s ,  Lanzada excepcion ",s);
                                System.out.println("     isfloat = " + isFloat);
                                throw  new CarException(" Error de datos, el 'largo' introducido debe ser float: ^[+-]?[0-9]*(([.]?[0-9]*)?)$ ");
                               
                           }else{
                              //  System.out.println("Capturada Excepción 'isfloat' = " + isFloat);
                                this.largo=Float.valueOf(s);
                           }
                          
                           
                            //Thread.sleep(3000);
                          
                           
                           if (!isFloat) throw  new CarException(" Error de datos, el tipo introducido debe ser flotante");
                        } catch(CarException e){     //en caso de error muestro el error personalizado
                             System.out.println("Mensaje: " + e.getMessage());   
                        }finally { // Finalmente, tanto si se produce error ejecutamos lo siguiente;
                           
                        }
                    }while(!isFloat);

                   
                    Thread.sleep(3000);
                       
             
        }   catch (Exception ex) {
                             System.out.println("Mensaje: " + ex.getMessage());
        }   
     }
     
     
    
     public void muestraDatos(){
         System.out.print("Fabricante: " + this.fabricante + " - ");
         System.out.print("Modelo: " + this.modelo + " - ");
         System.out.print("Color: " + this.color + " - ");
         System.out.print("Peso: " + this.peso + " - ");
         System.out.println("Largo: " + this.largo);    
     }
     
    
     public String getCoche(){ 
         return "FABRICANTE: "+ this.fabricante + " MODELO: "+ this.modelo + " COLOR: " + this.color+ " PESO: " + this.peso + " LARGO: "+ this.largo;
     } 
       
    public void acelerar(Integer cantidad) {
        this.velocidad += cantidad ;
    }
    
    
     public static boolean isNumeric(String s)
    {
        if (s == null || s.equals("")) {
            return false;
        }
 
        return s.chars().allMatch(Character::isDigit);
       //  boolean isNumeric = (s != null && s.matches("[0-9]+"));
    }
    
     public static boolean isFloat(String s)
     {
        if (s == null || s.equals("")) {
            return false;
        }
 
        return s.chars().allMatch(Character::isDigit);
       //  boolean isFloat = (s != null && s.matches("[0-9]+[,][0-9]+"));
    }
 
    
}  
