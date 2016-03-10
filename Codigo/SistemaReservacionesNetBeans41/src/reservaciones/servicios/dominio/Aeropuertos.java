//Source file: C:\\ALFREDO\\alfredo\\Libro\\Reservaciones\\SistemaReservacionesAnalisis\\reservaciones\\servicios\\dominio\\Aeropuerto.java

package reservaciones.servicios.dominio;

import reservaciones.dominio.*;

public class Aeropuertos extends Datos
{
   public Aeropuertos() {
        agregarAtributo("Aeropuerto_id","",true);
        agregarAtributo("Aeropuerto","",true);
    	agregarAtributo("Ciudad","",true);
    	agregarAtributo("Estado","",true);
       	agregarAtributo("Pais","",true);
   }
}
