package reservaciones.registro.usuario;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.registro.tarjeta.*;
import reservaciones.registro.interfaceBD.*;
import java.util.*;

public class ManejadorRegistroUsuario extends Manejador {

	private Pantalla pantallaCrearRegUsuario;
	private Pantalla pantallaObtenerRegUsuario;
	private RegistroUsuario registroUsuario;
	private ManejadorRegistroTarjeta mrt;
	private InterfaceRegistro interfaceRegistro;

	public ManejadorRegistroUsuario(Manejador m,InterfaceUsuario ui) {
		super(m,ui);
                registroUsuario = new RegistroUsuario();
		if (interfaceRegistro == null) {
                    if (db_flag == true) {
                        System.out.println("Usando Base de Datos");
                        interfaceRegistro = new InterfaceBaseDatosRegistro();
                    }
                    else {
                        System.out.println("Usando Archivos");
                        interfaceRegistro = new InterfaceArchivoRegistro();
                    }
                }
	}
	public InterfaceRegistro getInterfaceRegistro() { return interfaceRegistro; }
	// Contrato 1: Manejar Evento
	public void manejarEvento(String str) {
		if (str.equals("Registrar"))
			manejarEventoRegistrar();
 		else if (str.equals("Actualizar"))
			manejarEventoActualizar();
 		else if (str.equals("Eliminar"))
			manejarEventoEliminar();
 		else if (str.equals("Registrar Tarjeta"))
			manejarEventoRegistrarTarjeta();
		else
			manejarEventosAdicionales(str);
	}
 	// Contrato 2: Registrar Usuario
	public void crearRegistroUsuario() {
                pantallaCrearRegUsuario = crearPantalla("PantallaCrearRegUsuario");
                desplegarPantalla(pantallaCrearRegUsuario);
	}
	public boolean validarRegistroUsuario(String log, String pass) {
                if (registroUsuario == null)
                    registroUsuario = new RegistroUsuario();
                return interfaceRegistro.validarRegistro(registroUsuario,log,pass);
	}
	public void obtenerRegistroUsuario() {
                if (registroUsuario == null)
	            System.out.println("Registro Invalido");
                else
                    administrarRegistroUsuario();
	}
	// Responsabilidiades Privadas
	private void administrarRegistroUsuario() {
              pantallaObtenerRegUsuario = crearPantalla("PantallaObtenerRegUsuario");
              escribirElementos(pantallaObtenerRegUsuario,registroUsuario);
              desplegarPantalla(pantallaObtenerRegUsuario);
	}
 	private void manejarEventoRegistrar() {
               if (registroUsuario == null)
                    registroUsuario = new RegistroUsuario();
              leerElementos(pantalla,registroUsuario);
              interfaceRegistro.crearRegistro(registroUsuario);
              administrarRegistroUsuario();
	}
 	private void manejarEventoActualizar() {
	         if (registroUsuario == null)
                    registroUsuario = new RegistroUsuario();
                leerElementos(pantalla,registroUsuario);
                interfaceRegistro.actualizarRegistro(registroUsuario);
	}
	private void manejarEventoEliminar() {
		if (registroUsuario == null)
			System.out.println("Registro Invalido");
		else {
                    interfaceRegistro.eliminarRegistro(registroUsuario);
                    crearRegistroUsuario();
                }
 	}
	private void manejarEventoRegistrarTarjeta() {
		if (registroUsuario == null)
			System.out.println("Registro Invalido");
		else {
			if (mrt == null)
				mrt = new ManejadorRegistroTarjeta(this,interfaceUsuario);
			String id = registroUsuario.leerValor(0);    // corresponds to current id (log)
			mrt.registrarTarjeta(id);
		}
	}
}

