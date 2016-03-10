

package reservaciones.servicios.dominio;

import reservaciones.dominio.*;

public class Vuelos extends Datos
{
   public Vuelos() 
   {
        agregarAtributo("id","",true);
        agregarAtributo("origen","",true);
    	agregarAtributo("destino","",true);
   }
}
