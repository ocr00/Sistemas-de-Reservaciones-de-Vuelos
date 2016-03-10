package reservaciones.registro.interfaceBD;

import reservaciones.interfaceUsuario.*;
import reservaciones.principal.*;
import reservaciones.dominio.*;
import reservaciones.registro.usuario.*;
import reservaciones.registro.tarjeta.*;
import reservaciones.registro.interfaceBD.*;
import java.util.*;
import java.io.*;

public class InterfaceArchivoRegistro extends InterfaceRegistro
{
	private String path = "baseDatos";
        private Datos reg;
        private String  regname;
	private File freg, ftar;
        private Vector<ArchivoRegistro> archivoRegistro;
        private ArchivoRegistro ar;

 	public InterfaceArchivoRegistro()
	{
                // reconocer nombres directo de objetos
                archivoRegistro = new Vector<ArchivoRegistro>();
                reg = new RegistroUsuario();
                regname = getClassName(reg);
                ar = new ArchivoRegistro(path,reg,regname);
                archivoRegistro.addElement(ar);
                reg = new RegistroTarjeta();
                regname = getClassName(reg);
                ar = new ArchivoRegistro(path,reg,regname);
                archivoRegistro.addElement(ar);
    	}
	// Contrato 1: Registrar Usuario
	// Contrato 2: Registrar Tarjeta
	public boolean obtenerRegistro(Datos reg, String log)
	{
              String regname = getClassName(reg);
              for (int i = 0; i < archivoRegistro.size(); i++) {
			ar = (ArchivoRegistro) archivoRegistro.elementAt(i);
			if (ar != null && regname.equals(ar.getName()) == true)
				return ar.leerRegistro(reg, log);
              }

    	      return false;
	}
	public boolean crearRegistro(Datos reg)
	{
              String regname = getClassName(reg);
              for (int i = 0; i < archivoRegistro.size(); i++) {
			ar = (ArchivoRegistro) archivoRegistro.elementAt(i);
			if (ar != null && regname.equals(ar.getName()) == true)
				return ar.crearRegistro(reg);
              }
   	      return false;
	}
	public boolean actualizarRegistro(Datos reg)
	{
              String regname = getClassName(reg);
              for (int i = 0; i < archivoRegistro.size(); i++) {
			ar = (ArchivoRegistro) archivoRegistro.elementAt(i);
			if (ar != null && regname.equals(ar.getName()) == true)
				return ar.actualizarRegistro(reg);
              }
  	      return false;
	}
	public boolean eliminarRegistro(Datos reg)
	{
              String regname = getClassName(reg);
              for (int i = 0; i < archivoRegistro.size(); i++) {
			ar = (ArchivoRegistro) archivoRegistro.elementAt(i);
			if (ar != null && regname.equals(ar.getName()) == true)
				return ar.eliminarRegistro(reg);
              }
  	      return false;
	}
	public boolean validarRegistro(Datos reg, String log, String pass)
	{
              String regname = getClassName(reg);
              for (int i = 0; i < archivoRegistro.size(); i++) {
			ar = (ArchivoRegistro) archivoRegistro.elementAt(i);
			if (ar != null && regname.equals(ar.getName()) == true)
				return ar.validarRegistro(reg, log, pass);
              }

    	      return false;
	}
}

