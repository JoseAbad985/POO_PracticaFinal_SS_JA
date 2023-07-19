/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.dao;

import ec.edu.ups.practica_05_ssuquilanda_jabad.idao.ICompositorDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Compositor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESTUDIANTE
 */
public class CompositorDAO implements ICompositorDAO {

    private RandomAccessFile archivoCompositor;
    private String compositorFile = "compositor.dat";

    public CompositorDAO() throws IOException {

    }

    @Override
    public void create(Compositor compositor) {

        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            if (archivoCompositor.length() == 0) {
                archivoCompositor.seek(archivoCompositor.length());
                archivoCompositor.writeChars("\n");
                archivoCompositor.writeInt(compositor.getCodigo());
                String nombre = compositor.getNombre();
                if (nombre.length() < 25) {
                    StringBuilder sb = new StringBuilder(nombre);
                    while (sb.length() < 25) {
                        sb.append(" ");
                    }
                    nombre = sb.toString();
                } else if (nombre.length() > 25) {
                    int eliminar = nombre.length() - 25;
                    nombre = nombre.substring(0, nombre.length() - eliminar);
                }
                archivoCompositor.writeUTF(nombre);
                String apellido = compositor.getApellido();
                if (apellido.length() < 25) {
                    StringBuilder sbA = new StringBuilder(apellido);
                    while (sbA.length() < 25) {
                        sbA.append(" ");
                    }
                    apellido = sbA.toString();
                } else if (apellido.length() > 25) {
                    int eliminar = apellido.length() - 25;
                    apellido = apellido.substring(0, apellido.length() - eliminar);
                }
                archivoCompositor.writeUTF(apellido);
                archivoCompositor.writeInt(compositor.getEdad());
                String Nacionalidad = compositor.getNacionalidad();
                if (Nacionalidad.length() < 25) {
                    StringBuilder sbN = new StringBuilder(Nacionalidad);
                    while (sbN.length() < 25) {
                        sbN.append(" ");
                    }
                    Nacionalidad = sbN.toString();
                } else if (Nacionalidad.length() > 25) {
                    int eliminar = Nacionalidad.length() - 25;
                    Nacionalidad = Nacionalidad.substring(0, Nacionalidad.length() - eliminar);
                }
                archivoCompositor.writeUTF(Nacionalidad);
                archivoCompositor.writeInt(compositor.getNumeroDeComposiciones());
                archivoCompositor.writeDouble(compositor.getSalario());
                archivoCompositor.writeDouble(compositor.getSalarioFinal());
                archivoCompositor.close();
            } else {
                archivoCompositor.seek(archivoCompositor.length());
                archivoCompositor.writeChars("\n");
                archivoCompositor.writeInt(compositor.getCodigo());
                String nombre = compositor.getNombre();
                if (nombre.length() < 25) {
                    StringBuilder sb = new StringBuilder(nombre);
                    while (sb.length() < 25) {
                        sb.append(" ");
                    }
                    nombre = sb.toString();
                } else if (nombre.length() > 25) {
                    int eliminar = nombre.length() - 25;
                    nombre = nombre.substring(0, nombre.length() - eliminar);
                }
                archivoCompositor.writeUTF(nombre);
                String apellido = compositor.getApellido();
                if (apellido.length() < 25) {
                    StringBuilder sbA = new StringBuilder(apellido);
                    while (sbA.length() < 25) {
                        sbA.append(" ");
                    }
                    apellido = sbA.toString();
                } else if (apellido.length() > 25) {
                    int eliminar = apellido.length() - 25;
                    apellido = apellido.substring(0, apellido.length() - eliminar);
                }
                archivoCompositor.writeUTF(apellido);
                archivoCompositor.writeInt(compositor.getEdad());
                String Nacionalidad = compositor.getNacionalidad();
                if (Nacionalidad.length() < 25) {
                    StringBuilder sbN = new StringBuilder(Nacionalidad);
                    while (sbN.length() < 25) {
                        sbN.append(" ");
                    }
                    Nacionalidad = sbN.toString();
                } else if (Nacionalidad.length() > 25) {
                    int eliminar = Nacionalidad.length() - 25;
                    Nacionalidad = Nacionalidad.substring(0, Nacionalidad.length() - eliminar);
                }
                archivoCompositor.writeUTF(Nacionalidad);
                archivoCompositor.writeInt(compositor.getNumeroDeComposiciones());
                archivoCompositor.writeDouble(compositor.getSalario());
                archivoCompositor.writeDouble(compositor.getSalarioFinal());
                archivoCompositor.close();
            }
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    @Override
    public Compositor read(int id) {
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "r");
        } catch (IOException ex) {
            System.out.println("Error al buscar");
        }
        
        try {
            boolean encuentra = false;
            int pos = 0;
            while (!encuentra) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                System.out.println(cod); 
               if (cod == id) {
                    encuentra = true;                    
                    //Para encontrar el nombre
                    archivoCompositor.seek(pos+ 4); //Posicion donde comienza el nombre(0) + 4
                    String nombre = archivoCompositor.readUTF();
                    //Para encontrar el apellido
                    archivoCompositor.seek(pos+31);//Posicion donde comienza el apellido(25) + 4(del anterior) + 2 
                    String apellido = archivoCompositor.readUTF();
                    //Para encontrar la edad
                    archivoCompositor.seek(pos+58); //Posicion donde comienza la edad(54)+4
                    int edad = archivoCompositor.readInt();
                    //Para encontrar la nacionalidad
                    archivoCompositor.seek(pos+62);//Posicion donde comienza la nacionalidad(58)+4
                    String nacionalidad = archivoCompositor.readUTF();
                    //Para encontrar el num composiciones
                    archivoCompositor.seek(pos+66);
                    int numeroDeComposiciones = archivoCompositor.readInt();
                    //Para encontrar el salario
                    archivoCompositor.seek(pos+ 70);
                    double salario = archivoCompositor.readDouble();
                    return new Compositor(numeroDeComposiciones, cod, nombre, apellido, edad, nacionalidad, salario);
                } else {
                    if(pos+80 < archivoCompositor.length()){
                        pos += 80; //378;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private static byte[] readCharsFromFile(String filePath, int seek, int chars) throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath, "r");
		file.seek(seek);
		byte[] bytes = new byte[chars];
		file.read(bytes);
		file.close();
		return bytes;
    }
        /*@Override
        public void update
        (Compositor compositor
        
        
            ) {
        for (int i = 0; i < listaCompositor.size(); i++) {
                Compositor c = listaCompositor.get(i);
                if (c.getCodigo() == compositor.getCodigo()) {
                    listaCompositor.set(i, compositor);
                    break;
                }
            }

        }

        @Override
        public void delete
        (Compositor compositor
        
        
            ) {
        Iterator<Compositor> it = listaCompositor.iterator();
            while (it.hasNext()) {
                Compositor c = it.next();
                if (c.getCodigo() == compositor.getCodigo()) {
                    it.remove();
                    break;
                }
            }
        }

        @Override
        public List<Compositor> findAll
        
        
            () {
        return listaCompositor;
        }*/

    @Override
    public void update(Compositor compositor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Compositor compositor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Compositor> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    }
