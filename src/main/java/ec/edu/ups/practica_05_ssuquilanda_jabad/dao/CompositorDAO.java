/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.dao;

import ec.edu.ups.practica_05_ssuquilanda_jabad.idao.ICompositorDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cancion;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Compositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Disco;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
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
                archivoCompositor.seek(0);
                archivoCompositor.writeInt(compositor.getCodigo());
                String nombre = compositor.getNombre();
                CalcularTamaño(archivoCompositor, nombre);
                String apellido = compositor.getApellido();
                CalcularTamaño(archivoCompositor, apellido);
                archivoCompositor.writeInt(compositor.getEdad());
                String nacionalidad = compositor.getNacionalidad();
                CalcularTamaño(archivoCompositor, nacionalidad);
                archivoCompositor.writeInt(compositor.getNumeroDeComposiciones());
                archivoCompositor.writeDouble(compositor.getSalario());
                archivoCompositor.writeDouble(compositor.getSalarioFinal());
                GenerarVacios(archivoCompositor);
                System.out.println(archivoCompositor.length());
                archivoCompositor.close();
            } else {
                archivoCompositor.seek(archivoCompositor.length());
                archivoCompositor.writeInt(compositor.getCodigo());
                String nombre = compositor.getNombre();
                CalcularTamaño(archivoCompositor, nombre);
                String apellido = compositor.getApellido();
                CalcularTamaño(archivoCompositor, apellido);
                archivoCompositor.writeInt(compositor.getEdad());
                String nacionalidad = compositor.getNacionalidad();
                CalcularTamaño(archivoCompositor, nacionalidad);
                archivoCompositor.writeInt(compositor.getNumeroDeComposiciones());
                archivoCompositor.writeDouble(compositor.getSalario());
                archivoCompositor.writeDouble(compositor.getSalarioFinal());
                GenerarVacios(archivoCompositor);
                archivoCompositor.close();
            }
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    @Override
    public Compositor read(int id) {
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al buscar");
        }

        try {
            boolean encuentra = false;
            int pos = 0;
            while (!encuentra && pos < archivoCompositor.length()) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                if (cod == id) {
                    encuentra = true;
                    //Para encontrar el nombre
                    //archivoCompositor.seek(pos+ 4); //Posicion donde comienza el nombre(0) + 4
                    String nombre = archivoCompositor.readUTF();
                    //Para encontrar el apellido
                    //archivoCompositor.seek(pos+31);//Posicion donde comienza el apellido(25) + 4(del anterior) + 2 
                    String apellido = archivoCompositor.readUTF();
                    //Para encontrar la edad
                    //archivoCompositor.seek(pos+58); //Posicion donde comienza la edad(54)+4
                    int edad = archivoCompositor.readInt();
                    //Para encontrar la nacionalidad
                    //archivoCompositor.seek(pos+62);//Posicion donde comienza la nacionalidad(58)+4
                    String nacionalidad = archivoCompositor.readUTF();
                    //Para encontrar el num composiciones
                    //archivoCompositor.seek(pos+66);
                    int numeroDeComposiciones = archivoCompositor.readInt();
                    //Para encontrar el salario
                    //archivoCompositor.seek(pos+ 70);
                    double salario = archivoCompositor.readDouble();
                    return new Compositor(numeroDeComposiciones, cod, nombre, apellido, edad, nacionalidad, salario);

                }
                pos += 2479;
            }
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            archivoCompositor.close();
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void CalcularTamaño(RandomAccessFile archivoCompositor, String prueba) throws IOException {
        if (prueba.length() < 25) {
            StringBuilder sbGM = new StringBuilder(prueba);
            while (sbGM.length() < 25) {
                sbGM.append(" ");
            }
            prueba = sbGM.toString();
        } else if (prueba.length() > 25) {
            int eliminar = prueba.length() - 25;
            prueba = prueba.substring(0, prueba.length() - eliminar);
        }
        archivoCompositor.writeUTF(prueba);
    }

    public void GenerarVacios(RandomAccessFile archivoCompositor) throws IOException {
        // int n = 0;
        //while (n < 117) {
        //  archivoCantante.writeUTF(" ");
        //n += 1;
        //}
        byte[] bytes = new byte[2371];
        archivoCompositor.write(bytes);
    }

    @Override
    public void update(Compositor compositor2) {
        try {
            System.out.println("El tamaño del archivo antes de actualizar es: " + archivoCompositor.length());
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            while (!encuentra && pos < archivoCompositor.length()) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                if (cod == compositor2.getCodigo()) {
                    encuentra = true;
                    archivoCompositor.seek(0);
                    archivoCompositor.writeInt(compositor2.getCodigo());
                    String nombre = compositor2.getNombre();
                    CalcularTamaño(archivoCompositor, nombre);
                    String apellido = compositor2.getApellido();
                    CalcularTamaño(archivoCompositor, apellido);
                    archivoCompositor.writeInt(compositor2.getEdad());
                    String nacionalidad = compositor2.getNacionalidad();
                    CalcularTamaño(archivoCompositor, nacionalidad);
                    archivoCompositor.writeInt(compositor2.getNumeroDeComposiciones());
                    archivoCompositor.writeDouble(compositor2.getSalario());
                    archivoCompositor.writeDouble(compositor2.getSalarioFinal());
                    //GenerarVacios(archivoCompositor);
                    System.out.println("El tamaño del archivo despues de actualizar algo es: " + archivoCompositor.length());
                    archivoCompositor.close();
                    break;
                }
                pos += 2479;
            }
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Compositor compositor2) {
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al eliminar");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            while (!encuentra && pos < archivoCompositor.length()) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                if (cod == compositor2.getCodigo()) {
                    int longuitud = (int) archivoCompositor.length();

                    encuentra = true;
                    archivoCompositor.seek(pos + 2479);
                    byte[] compositorEliminado = new byte[longuitud - (pos + 2479)];
                    archivoCompositor.read(compositorEliminado);
                    archivoCompositor.seek(pos);
                    archivoCompositor.write(compositorEliminado);
                    archivoCompositor.setLength(longuitud - 2479);
                    archivoCompositor.close();
                }
                pos += 2479;

            }
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Compositor> findAll() {
        List<Compositor> compositores = new ArrayList<>();
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }

        try {

            int pos = 0;
            while (pos < archivoCompositor.length()) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                //archivoCompositor.seek(pos+ 4); //Posicion donde comienza el nombre(0) + 4
                String nombre = archivoCompositor.readUTF();
                //Para encontrar el apellido
                //archivoCompositor.seek(pos+31);//Posicion donde comienza el apellido(25) + 4(del anterior) + 2 
                String apellido = archivoCompositor.readUTF();
                //Para encontrar la edad
                //archivoCompositor.seek(pos+58); //Posicion donde comienza la edad(54)+4
                int edad = archivoCompositor.readInt();
                //Para encontrar la nacionalidad
                //archivoCompositor.seek(pos+62);//Posicion donde comienza la nacionalidad(58)+4
                String nacionalidad = archivoCompositor.readUTF();
                //Para encontrar el num composiciones
                //archivoCompositor.seek(pos+66);
                int numeroDeComposiciones = archivoCompositor.readInt();
                //Para encontrar el salario
                //archivoCompositor.seek(pos+ 70);
                double salario = archivoCompositor.readDouble();

                Compositor compositor = new Compositor(numeroDeComposiciones, cod, nombre, apellido, edad, nacionalidad, salario);
                compositores.add(compositor);
                pos += 2479;
            }
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compositores;
    }

    @Override
    public void createCancion(Compositor compositor2, Cancion cancion) {
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            int pos2 = pos;
            while (!encuentra && pos < archivoCompositor.length()) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                pos2 = pos;
                System.out.println("El codigo que se está comparando es: " + cod);
                System.out.println("Se compara con: " + compositor2.getCodigo());
                while (cod == compositor2.getCodigo() && !encuentra) {
                    System.out.println("Se está escribiendo en el cantante con codigo: " + cod + "Que está en la posicion: " + pos2);
                    archivoCompositor.seek(pos2 + 97 + 4);
                    if (archivoCompositor.readUTF().isBlank()) {
                        archivoCompositor.seek(pos2 + 97);
                        encuentra = true;
                        archivoCompositor.writeInt(cancion.getCodigo());
                        archivoCompositor.writeUTF(cancion.getTitulo());
                        archivoCompositor.writeDouble(cancion.getTiempoEnMinutos());
                        archivoCompositor.close();
                    }
                    pos2 += 66;
                }
                pos += 2479;
            }
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Cancion readCancion(Compositor compositor2, int codigo) {
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            int pos2 = pos;
            while (!encuentra && pos < archivoCompositor.length()) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                while ((cod == compositor2.getCodigo())) {
                    archivoCompositor.seek(pos2 + 97);
                    int codCancion = archivoCompositor.readInt();
                    if (codCancion == codigo) {
                        encuentra = true;
                        String titulo = archivoCompositor.readUTF();
                        String letra = archivoCompositor.readUTF();
                        int tiempo = archivoCompositor.readInt();
                        archivoCompositor.close();
                        return new Cancion(codigo, titulo, letra, tiempo);
                    }
                    pos2 += 66;
                }
                pos += 2479;

            }
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public void updateCancion(Compositor compositor2, Cancion cancion) {
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            int pos2 = pos;
            while (!encuentra && pos < archivoCompositor.length()) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                while (!encuentra && cod == compositor2.getCodigo()) {
                    archivoCompositor.seek(pos2 + 97);
                    int codCancion = archivoCompositor.readInt();
                    while (!encuentra && codCancion == cancion.getCodigo()) {
                        archivoCompositor.writeUTF(cancion.getTitulo());
                        archivoCompositor.writeUTF(cancion.getLetra());
                        archivoCompositor.writeDouble(cancion.getTiempoEnMinutos());
                        encuentra = true;
                        archivoCompositor.close();
                    }
                    pos2 += 66;
                }
                pos += 2479;
            }
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deleteCancion(Compositor compositor2, Cancion cancion) {
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            int pos2 = pos;
            while (!encuentra && pos < archivoCompositor.length()) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                while (!encuentra && cod == compositor2.getCodigo()) {
                    archivoCompositor.seek(pos2 + 97);
                    int codCancion = archivoCompositor.readInt();
                    while (!encuentra && codCancion == cancion.getCodigo()) {
                        int longuitud = (int) archivoCompositor.length();
                        encuentra = true;
                        archivoCompositor.seek(pos2 + 97);
                        byte[] compositorEliminado = new byte[longuitud - (pos + 66)];
                        archivoCompositor.seek(pos2 + 97);
                        archivoCompositor.write(compositorEliminado);
                        archivoCompositor.setLength(longuitud - 66);
                        archivoCompositor.close();
                    }
                    pos2 += 66;
                }
                pos += 2479;
            }
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cancion> findAllCancion(Compositor compositor2) {
        List<Cancion> canciones = new ArrayList<>();
        try {
            try {
                archivoCompositor = new RandomAccessFile(compositorFile, "rw");
            } catch (IOException ex) {
                System.out.println("Error al crear");
            }
            boolean encuentra = false;
            int pos = 0;
            while (!encuentra && pos < archivoCompositor.length()) {
                archivoCompositor.seek(pos);
                int cod = archivoCompositor.readInt();
                int pos2 = pos + 97;
                while (!encuentra && cod == compositor2.getCodigo()) {
                    //System.out.println(encuentra);
                    //System.out.println("Hasta aqui todo bien");
                    while (pos2 < (pos + 2479)) {
                        archivoCompositor.seek(pos2);
                        int codigo = archivoCompositor.readInt();
                        String titulo = archivoCompositor.readUTF();
                        String letra = archivoCompositor.readUTF();
                        double tiempo = archivoCompositor.readDouble();
                        Cancion cancion = new Cancion(codigo, titulo, letra, tiempo);
                        canciones.add(cancion);
                        pos2 += 66;
                    }
                    encuentra = true;

                }
                pos += 2439;

            }

        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return canciones;
    }

    @Override
    public Compositor readCancionWOS(int codigo) {
        try {
            archivoCompositor = new RandomAccessFile(compositorFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 97;
            int cont = 0;
            while (!encuentra && pos < archivoCompositor.length()) {
                int pos2 = pos;
                archivoCompositor.seek(pos2);
                int codCancion = archivoCompositor.readInt();
                while (cont < 10) {
                    if (codCancion == codigo) {
                        encuentra = true;
                        archivoCompositor.seek(pos2 - ((66 * cont) + 97));
                        int cod = archivoCompositor.readInt();
                        //archivoCompositor.seek(pos+ 4); //Posicion donde comienza el nombre(0) + 4
                        String nombre = archivoCompositor.readUTF();
                        //Para encontrar el apellido
                        //archivoCompositor.seek(pos+31);//Posicion donde comienza el apellido(25) + 4(del anterior) + 2 
                        String apellido = archivoCompositor.readUTF();
                        //Para encontrar la edad
                        //archivoCompositor.seek(pos+58); //Posicion donde comienza la edad(54)+4
                        int edad = archivoCompositor.readInt();
                        //Para encontrar la nacionalidad
                        //archivoCompositor.seek(pos+62);//Posicion donde comienza la nacionalidad(58)+4
                        String nacionalidad = archivoCompositor.readUTF();
                        //Para encontrar el num composiciones
                        //archivoCompositor.seek(pos+66);
                        int numeroDeComposiciones = archivoCompositor.readInt();
                        //Para encontrar el salario
                        //archivoCompositor.seek(pos+ 70);
                        double salario = archivoCompositor.readDouble();
                        archivoCompositor.close();
                        return new Compositor(numeroDeComposiciones, cod, nombre, apellido, edad, nacionalidad, salario);
                    }
                    pos2 += 66;
                }
                pos += 2479;
                cont = 0;
            }
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CompositorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
