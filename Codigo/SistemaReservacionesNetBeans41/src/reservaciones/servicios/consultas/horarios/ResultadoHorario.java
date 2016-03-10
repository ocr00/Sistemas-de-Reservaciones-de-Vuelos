/*
 * ResultadoHorario.java
 *
 */

package reservaciones.servicios.consultas.horarios;

import reservaciones.dominio.*;

public class ResultadoHorario extends Datos {
    
    /** Creates a new instance of ResultadoHorario */
    public ResultadoHorario() {
        agregarAtributo("Aerolinea","",true);
    	agregarAtributo("Vuelo","",true);
        agregarAtributo("Dias","",true);
    	agregarAtributo("Hora_salida","",true);        
        agregarAtributo("Restricciones","",true);
    }
    
}
