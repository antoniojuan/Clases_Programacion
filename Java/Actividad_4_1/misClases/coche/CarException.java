/* Actividad_4_1. Menu con 4 opciones 
 */

package misClases.coche;

/**
 *
 * @author AJ
 */

public class CarException extends Exception {
    
    private String  errorMessage;

    public CarException() {
        this.errorMessage = "Error Indefinido";
    }

    public CarException(String message) {
       this.errorMessage = message;
       
    }
    
    /**
     *
     * @return
     */
    // Sobreescribimos el metodo getMessage de la clase Exception
    
   @Override
    public String getMessage(){
        return this.errorMessage;
       
    }
    
}
