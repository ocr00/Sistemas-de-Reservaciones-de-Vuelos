/*
 * ConsultaHorario.java
 *
 */

package reservaciones.servicios.consultas.horarios;

import reservaciones.dominio.*;

/**
 *
 */
public class ConsultaHorario extends Datos {
    
    /** Creates a new instance of ConsultaHorario */
    public ConsultaHorario() {
        agregarAtributo("origen","",true);
    	agregarAtributo("destino","",true);
    }
    
}
