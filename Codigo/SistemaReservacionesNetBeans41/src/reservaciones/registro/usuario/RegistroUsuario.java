package reservaciones.registro.usuario;

import reservaciones.dominio.*;

public class RegistroUsuario extends Datos {

    public RegistroUsuario() {
     	agregarAtributo("login","",true);
    	agregarAtributo("password","",true);
    	agregarAtributo("nombre","",true);
    	agregarAtributo("apellido","",true);
    	agregarAtributo("direccion","",true);
    	agregarAtributo("colonia","",true);
    	agregarAtributo("ciudad","",true);
    	agregarAtributo("pais","",true);
	agregarAtributo("CP","",true);
	agregarAtributo("telCasa","",true);
	agregarAtributo("telOficina","",true);
	agregarAtributo("fax","",true);
	agregarAtributo("email","",true);
    	agregarAtributo("rpassword","",false); // debe ir de ultimo por no guardarse
    }
    public void actualizarAtributos() {
        copiarValor("password","rpassword");
    }
}
