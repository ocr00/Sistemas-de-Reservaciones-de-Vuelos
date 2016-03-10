package reservaciones.registro.tarjeta;

import reservaciones.dominio.*;

public class RegistroTarjeta extends Datos {

    public RegistroTarjeta() {
    	agregarAtributo("login","",true);
    	agregarAtributo("nombre","",true);
    	agregarAtributo("numero","",true);
        agregarAtributo("tipo","",true);
    	agregarAtributo("fecha","",true);
    }
}