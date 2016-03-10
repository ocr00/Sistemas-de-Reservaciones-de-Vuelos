package reservaciones.registro.interfaceBD;

import reservaciones.interfaceUsuario.*;
import reservaciones.principal.*;
import reservaciones.dominio.*;
import reservaciones.registro.usuario.*;
import reservaciones.registro.tarjeta.*;
import reservaciones.registro.interfaceBD.*;
import java.util.*;
import java.io.*;

public class ArchivoRegistro
{
      	private Vector<Datos> listaRegistro;
	private File freg;
        private Class creg;
        private String name;
        private String filename;

 	public ArchivoRegistro(String dirname, Datos reg, String classname) // String filename, String packagename, String classname)
	{
                creg = reg.getClass();
                name = classname;
                filename = classname + ".dat";
                System.out.println ("\nLeyendo archivo " + filename + " con objetos de clase: " + classname);
                listaRegistro = new Vector<Datos>();
		freg = new File(dirname,filename);
		inicializarRegistrosArchivo();
	}
        // Contrato 2: Validar Registro
	public boolean leerRegistro(Datos reg, String log)
	{
		System.out.println("Login: "+log);
		for (int i = 0; i < listaRegistro.size(); i++) {
			Datos datos = (Datos) listaRegistro.elementAt(i);
			if (log.equals(datos.leerValor(0))) {
			    for (int j = 0; j < datos.numeroAtributos(); j++) {
				reg.escribirValor(j,datos.leerValor(j));
			    }
                            return true;
                        }
		}
		return false;
	}
        // Escribir Registro
        public boolean crearRegistro(Datos reg)
	{
		if (leerRegistro(reg,reg.leerValor(0)) == false){
                    listaRegistro.addElement(reg);
                    return actualizarArchivoRegistro();
		}
		else
                    return actualizarRegistro(reg);
	}
        // Actualizar Registro
	public boolean actualizarRegistro(Datos reg)
	{
		int indice = leerIndiceRegistro(reg.leerValor(0));
		if (indice  != -1) {
     		    listaRegistro.setElementAt(reg,indice);
                    return actualizarArchivoRegistro();
		}
  	        return false;
	}
        // Eliminar Registro
	public boolean eliminarRegistro(Datos reg)
	{
		int indice = leerIndiceRegistro(reg.leerValor(0));
		if (indice  != -1) {
     		    listaRegistro.removeElementAt(indice);
                    return actualizarArchivoRegistro();
		}
  	      return false;
	}
        // Contrato 2: Validar Registro
	public boolean validarRegistro(Datos reg, String log, String pass)
	{
		System.out.println("Login: "+log);
		System.out.println("Password: "+pass);
                if (leerRegistro(reg,log) != false && reg != null) {
                    String preg = reg.leerValor(1);
		    if (pass.equals(preg))
			return true;
                }
		System.out.println("registro: "+reg);
		return false;
	}
        // Responsabilidades Privadas
	private void inicializarRegistrosArchivo()
	{
		try {
			BufferedReader is = new BufferedReader(new FileReader(freg));
			leerRegistrosArchivo(listaRegistro,is);
			is.close();
		}
		catch(IOException e) {
			System.out.print("Error Lectura Registro: " + e);
			System.exit(1);
		}
	}

	private boolean leerRegistrosArchivo(Vector<Datos> vectorDatos, BufferedReader is) throws IOException
	{
                Datos datos;
		String s = is.readLine();
		Integer ns = Integer.valueOf(s);
		int n = ns.intValue();
		for (int i = 0; i < n; i++)
		{
                        try {
                              datos = (Datos) creg.newInstance();
                        }
                        catch (Exception ex){
                              System.out.println ("\n*** IllegalAccessException interceptado ***\n");
		              ex.printStackTrace ();
                              return false;
                        }
			s = is.readLine();
			StringTokenizer t = new StringTokenizer(s, "|");
			for (int j = 0; j < datos.numeroAtributosBD(); j++)
			{
 				String val = t.nextToken();
				datos.escribirValor(j,val);
			}
                        datos.actualizarAtributos(); // actualizar valores no leidos
			vectorDatos.addElement(datos);
		}
                return true;
	}
        private boolean actualizarArchivoRegistro()
        {
		try {
                        BufferedWriter os = new BufferedWriter(new FileWriter(freg));
			escribirDatos(listaRegistro, os);
                        os.close();
                }
		catch(IOException e) {
                        System.out.print("Error: " + e);
			System.exit(1);
                        return false;
                }
                return true;
        }
        private boolean escribirDatos(Vector vectorDatos, BufferedWriter os) throws IOException
	{
		int num = vectorDatos.size();
 		String numStr = String.valueOf(num);
                os.write(numStr);
                os.newLine();
		for (int i = 0; i < num; i++) {
			Datos datos = (Datos) vectorDatos.elementAt(i);
                        for (int j = 0; j < datos.numeroAtributosBD(); j++) {
                                String str = datos.leerValor(j);
                                if (str.equals("") == true)
                                        str = " ";
                                os.write(str+"|");
                        }
                        os.newLine();
                }
                return true;
        }
        private int leerIndiceRegistro(String regname)
        {
		for (int i = 0; i < listaRegistro.size(); i++) {
			Datos datos = (Datos) listaRegistro.elementAt(i);
			if (regname.equals(datos.leerValor(0)) == true)
				return i;
		}
		return -1;
	}
        String getName() { return name; }
}

