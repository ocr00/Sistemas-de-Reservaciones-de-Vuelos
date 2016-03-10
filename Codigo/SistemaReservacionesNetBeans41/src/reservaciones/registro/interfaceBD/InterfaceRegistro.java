package reservaciones.registro.interfaceBD;

import reservaciones.interfaceUsuario.*;
import reservaciones.principal.*;
import reservaciones.dominio.*;
import reservaciones.registro.usuario.*;
import reservaciones.registro.tarjeta.*;

public abstract class InterfaceRegistro extends InterfaceBaseDatos
{
 	// Contrato 1: Registrar Usuario
	// Contrato 2: Registrar Tarjeta
        public abstract boolean obtenerRegistro(Datos reg,String log);
        public abstract boolean crearRegistro(Datos reg);
	public abstract boolean actualizarRegistro(Datos reg);
	public abstract boolean eliminarRegistro(Datos reg);
	public abstract boolean validarRegistro(Datos reg,String log,String pass);
}

