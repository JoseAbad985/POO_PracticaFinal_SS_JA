/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.dao;

import ec.edu.ups.practica_05_ssuquilanda_jabad.idao.ICantanteDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Disco;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESTUDIANTE
 */
public class CantanteDAO implements ICantanteDAO {

    private RandomAccessFile archivoCantante;
    private String cantantesFile = "cantante.dat";

    public CantanteDAO() throws IOException {

    }

    @Override
    public void create(Cantante cantante) {

        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            if (archivoCantante.length() == 0) {
                archivoCantante.seek(0);
                archivoCantante.writeInt(cantante.getCodigo());//4
                String nombre = cantante.getNombre();
                CalcularTamaño(archivoCantante, nombre);
                String apellido = cantante.getApellido();
                CalcularTamaño(archivoCantante, apellido);
                archivoCantante.writeInt(cantante.getEdad());//4
                String Nacionalidad = cantante.getNacionalidad();
                CalcularTamaño(archivoCantante, Nacionalidad);
                String NombreArtistico = cantante.getNombreArtistico();
                CalcularTamaño(archivoCantante, NombreArtistico);
                String GeneroMusical = cantante.getGeneroMusical();
                CalcularTamaño(archivoCantante, GeneroMusical);
                archivoCantante.writeInt(cantante.getNumeroDeSencillos());//4
                archivoCantante.writeInt(cantante.getNumeroDeConciertos());//4
                archivoCantante.writeInt(cantante.getNumeroDeGiras());//4
                archivoCantante.writeDouble(cantante.getSalario());//8
                archivoCantante.writeDouble(cantante.getSalarioFinal());//8
                GenerarVacios(archivoCantante);
                System.out.println(archivoCantante.length());
                archivoCantante.close();
            } else {
                archivoCantante.seek(archivoCantante.length());
                archivoCantante.writeInt(cantante.getCodigo());//4
                String nombre = cantante.getNombre();
                CalcularTamaño(archivoCantante, nombre);
                String apellido = cantante.getApellido();
                CalcularTamaño(archivoCantante, apellido);
                archivoCantante.writeInt(cantante.getEdad());//4
                String Nacionalidad = cantante.getNacionalidad();
                CalcularTamaño(archivoCantante, Nacionalidad);
                String NombreArtistico = cantante.getNombreArtistico();
                CalcularTamaño(archivoCantante, NombreArtistico);
                String GeneroMusical = cantante.getGeneroMusical();
                CalcularTamaño(archivoCantante, GeneroMusical);
                archivoCantante.writeInt(cantante.getNumeroDeSencillos());//4
                archivoCantante.writeInt(cantante.getNumeroDeConciertos());//4
                archivoCantante.writeInt(cantante.getNumeroDeGiras());//4
                archivoCantante.writeDouble(cantante.getSalario());//8
                archivoCantante.writeDouble(cantante.getSalarioFinal());//8
                GenerarVacios(archivoCantante);
                archivoCantante.close();
            }
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    @Override
    public Cantante read(int id) {
        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }

        try {
            boolean encuentra = false;
            int pos = 0;
            while (!encuentra && pos < archivoCantante.length()) {
                archivoCantante.seek(pos);
                int cod = archivoCantante.readInt();
                if (cod == id) {
                    encuentra = true;
                    //Para encontrar el nombre
                    // archivoCantante.seek(pos + 4); //Posicion donde comienza el nombre(0) + 4
                    String nombre = archivoCantante.readUTF();
                    //Para encontrar el apellido
                    String apellido = archivoCantante.readUTF();
                    //Para encontrar la edad
                    int edad = archivoCantante.readInt();
                    //Para encontrar la nacionalidad
                    String nacionalidad = archivoCantante.readUTF();
                    //Para encontrar el nombre artistico
                    String nombreArtistico = archivoCantante.readUTF();
                    //Para encontrar el Genero musical
                    String generoMusical = archivoCantante.readUTF();
                    //Para encontrar  el # Sencillos
                    int sencillos = archivoCantante.readInt();
                    //Para encontrar el # Conciertos
                    int conciertos = archivoCantante.readInt();
                    //Para encontrar el # Giras
                    int giras = archivoCantante.readInt();
                    //Para encontrar el salario
                    double salario = archivoCantante.readDouble();
                    return new Cantante(nombreArtistico, generoMusical, sencillos, conciertos, giras, cod, nombre, apellido, edad, nacionalidad, salario);
                }
                pos += 522;
            }
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            archivoCantante.close();
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Cantante cantante2) {
        try {
            System.out.println("El tamaño del archivo antes de actualizar es: " + archivoCantante.length());
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            while (!encuentra && pos < archivoCantante.length()) {
                archivoCantante.seek(pos);
                int cod = archivoCantante.readInt();
                if (cod == cantante2.getCodigo()) {
                    encuentra = true;
                    archivoCantante.seek(pos);
                    archivoCantante.writeInt(cantante2.getCodigo());//4
                    String nombre = cantante2.getNombre();
                    CalcularTamaño(archivoCantante, nombre);
                    String apellido = cantante2.getApellido();
                    CalcularTamaño(archivoCantante, apellido);
                    archivoCantante.writeInt(cantante2.getEdad());//4
                    String Nacionalidad = cantante2.getNacionalidad();
                    CalcularTamaño(archivoCantante, Nacionalidad);
                    String NombreArtistico = cantante2.getNombreArtistico();
                    CalcularTamaño(archivoCantante, NombreArtistico);
                    String GeneroMusical = cantante2.getGeneroMusical();
                    CalcularTamaño(archivoCantante, GeneroMusical);
                    archivoCantante.writeInt(cantante2.getNumeroDeSencillos());//4
                    archivoCantante.writeInt(cantante2.getNumeroDeConciertos());//4
                    archivoCantante.writeInt(cantante2.getNumeroDeGiras());//4
                    archivoCantante.writeDouble(cantante2.getSalario());//8
                    archivoCantante.writeDouble(cantante2.getSalarioFinal());//8
                    // GenerarVacios(archivoCantante);
                    System.out.println("El tamaño del archivo despues de actualizar algo es: " + archivoCantante.length());
                    archivoCantante.close();
                    break;
                }
                pos += 522;
            }
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Cantante cantante2) {
        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            while (!encuentra && pos < archivoCantante.length()) {
                archivoCantante.seek(pos);
                int cod = archivoCantante.readInt();
                if (cod == cantante2.getCodigo()) {
                    int longuitud = (int) archivoCantante.length();

                    encuentra = true;
                    archivoCantante.seek(pos + 522);
                    byte[] cantanteEliminado = new byte[longuitud - (pos + 522)];
                    archivoCantante.read(cantanteEliminado);
                    archivoCantante.seek(pos);
                    archivoCantante.write(cantanteEliminado);
                    archivoCantante.setLength(longuitud - 522);
                    archivoCantante.close();
                }
                pos += 522;

            }
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void CalcularTamaño(RandomAccessFile archivoCantante, String prueba) throws IOException {
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
        archivoCantante.writeUTF(prueba);
    }

    public void GenerarVacios(RandomAccessFile archivoCantante) throws IOException {
        // int n = 0;
        //while (n < 117) {
        //  archivoCantante.writeUTF(" ");
        //n += 1;
        //}
        byte[] bytes = new byte[351];
        archivoCantante.write(bytes);
    }

    public List<Cantante> findAll() {

        List<Cantante> cantantes = new ArrayList<>();
        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }

        try {

            int pos = 0;
            while (pos < archivoCantante.length()) {
                archivoCantante.seek(pos);
                //Para encontrar el nombre
                int codigo = archivoCantante.readInt();
                // archivoCantante.seek(pos + 4); //Posicion donde comienza el nombre(0) + 4
                String nombre = archivoCantante.readUTF();
                //Para encontrar el apellido
                String apellido = archivoCantante.readUTF();
                //Para encontrar la edad
                int edad = archivoCantante.readInt();
                //Para encontrar la nacionalidad
                String nacionalidad = archivoCantante.readUTF();
                //Para encontrar el nombre artistico
                String nombreArtistico = archivoCantante.readUTF();
                //Para encontrar el Genero musical
                String generoMusical = archivoCantante.readUTF();
                //Para encontrar  el # Sencillos
                int sencillos = archivoCantante.readInt();
                //Para encontrar el # Conciertos
                int conciertos = archivoCantante.readInt();
                //Para encontrar el # Giras
                int giras = archivoCantante.readInt();
                //Para encontrar el salario
                double salario = archivoCantante.readDouble();
                Cantante cantante = new Cantante(nombreArtistico, generoMusical, sencillos, conciertos, giras, codigo, nombre, apellido, edad, nacionalidad, salario);
                cantantes.add(cantante);
                pos += 522;
            }
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantantes;
    }

    @Override
    public void createDisc(Cantante cantante2, Disco disco) {
        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            int pos2 = pos;
            while (!encuentra && pos < archivoCantante.length()) {
                archivoCantante.seek(pos);
                int cod = archivoCantante.readInt();
                pos2 = pos;
                System.out.println("El codigo que se está comparando es: " + cod);
                System.out.println("Se compara con: " + cantante2.getCodigo());
                while (cod == cantante2.getCodigo() && !encuentra) {
                    System.out.println("Se está escribiendo en el cantante con codigo: " + cod + "Que está en la posicion: " + pos2);
                    archivoCantante.seek(pos2 + 171 + 4);
                    if (archivoCantante.readUTF().isBlank()) {
                        archivoCantante.seek(pos2 + 171);
                        encuentra = true;
                        archivoCantante.writeInt(disco.getCodigo());
                        archivoCantante.writeUTF(disco.getNombre());
                        archivoCantante.writeInt(disco.getAnioDeLanzamiento());
                        archivoCantante.close();
                    }
                    pos2 += 35;
                }
                pos += 522;
            }
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Disco readDisc(Cantante cantante2, int codigo) {
        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            int pos2 = pos;
            while (!encuentra && pos < archivoCantante.length()) {
                archivoCantante.seek(pos);
                int cod = archivoCantante.readInt();
                while ((cod == cantante2.getCodigo())) {
                    archivoCantante.seek(pos2 + 171);
                    int codDisc = archivoCantante.readInt();
                    if (codDisc == codigo) {
                        encuentra = true;
                        String nombre = archivoCantante.readUTF();
                        int fecha = archivoCantante.readInt();
                        archivoCantante.close();
                        return new Disco(codigo, nombre, fecha);
                    }
                    pos2 += 35;
                }
                pos += 522;

            }
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void updateDisc(Cantante cantante2, Disco disco) {
        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            int pos2 = pos;
            while (!encuentra && pos < archivoCantante.length()) {
                archivoCantante.seek(pos);
                int cod = archivoCantante.readInt();
                while (!encuentra && cod == cantante2.getCodigo()) {
                    archivoCantante.seek(pos2 + 171);
                    int codDisc = archivoCantante.readInt();
                    while (!encuentra && codDisc == disco.getCodigo()) {
                        archivoCantante.writeUTF(disco.getNombre());
                        archivoCantante.writeInt(disco.getAnioDeLanzamiento());
                        encuentra = true;
                        archivoCantante.close();
                    }
                    pos2 += 35;
                }
                pos += 522;
            }
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteDisc(Cantante cantante2, Disco disco) {
        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 0;
            int pos2 = pos;
            while (!encuentra && pos < archivoCantante.length()) {
                archivoCantante.seek(pos);
                int cod = archivoCantante.readInt();
                while (!encuentra && cod == cantante2.getCodigo()) {
                    archivoCantante.seek(pos2 + 171);
                    int codDisc = archivoCantante.readInt();
                    while (!encuentra && codDisc == disco.getCodigo()) {
                        int longuitud = (int) archivoCantante.length();
                        encuentra = true;
                        archivoCantante.seek(pos2 + 171);
                        byte[] cantanteEliminado = new byte[longuitud - (pos + 35)];
                        archivoCantante.seek(pos2 + 171);
                        archivoCantante.write(cantanteEliminado);
                        archivoCantante.setLength(longuitud - 35);
                        archivoCantante.close();
                    }
                    pos2 += 35;
                }
                pos += 522;
            }
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Disco> findAllDiscs(Cantante cantante2) {
        List<Disco> discos = new ArrayList<>();
        try {
            try {
                archivoCantante = new RandomAccessFile(cantantesFile, "rw");
            } catch (IOException ex) {
                System.out.println("Error al crear");
            }
            boolean encuentra = false;
            int pos = 0;
            while (!encuentra && pos < archivoCantante.length()) {
                archivoCantante.seek(pos);
                int cod = archivoCantante.readInt();
                int pos2 = pos + 171;
                while (!encuentra && cod == cantante2.getCodigo()) {
                    //System.out.println(encuentra);
                    //System.out.println("Hasta aqui todo bien");
                    while (pos2 < (pos + 522)) {
                        archivoCantante.seek(pos2);
                        int codigo = archivoCantante.readInt();
                        String nombre = archivoCantante.readUTF();
                        int anio = archivoCantante.readInt();
                        Disco disco = new Disco(codigo, nombre, anio);
                        discos.add(disco);
                        pos2 += 35;
                    }
                    encuentra = true;

                }
                pos += 522;

            }

        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return discos;
    }

    @Override
    public Cantante readDiscWOS(int codigo) {
        try {
            archivoCantante = new RandomAccessFile(cantantesFile, "rw");
        } catch (IOException ex) {
            System.out.println("Error al crear");
        }
        try {
            boolean encuentra = false;
            int pos = 171;
            int cont = 0;
            while (!encuentra && pos < archivoCantante.length()) {
                int pos2 = pos;
                archivoCantante.seek(pos2);
                int codDisc = archivoCantante.readInt();
                while (cont < 10) {
                    if (codDisc == codigo) {
                        encuentra = true;
                        archivoCantante.seek(pos2 - ((35 * cont) + 171));
                        int cod = archivoCantante.readInt();
                        String nombre = archivoCantante.readUTF();
                        //Para encontrar el apellido
                        String apellido = archivoCantante.readUTF();
                        //Para encontrar la edad
                        int edad = archivoCantante.readInt();
                        //Para encontrar la nacionalidad
                        String nacionalidad = archivoCantante.readUTF();
                        //Para encontrar el nombre artistico
                        String nombreArtistico = archivoCantante.readUTF();
                        //Para encontrar el Genero musical
                        String generoMusical = archivoCantante.readUTF();
                        //Para encontrar  el # Sencillos
                        int sencillos = archivoCantante.readInt();
                        //Para encontrar el # Conciertos
                        int conciertos = archivoCantante.readInt();
                        //Para encontrar el # Giras
                        int giras = archivoCantante.readInt();
                        //Para encontrar el salario
                        double salario = archivoCantante.readDouble();
                        archivoCantante.close();
                        return new Cantante(nombreArtistico, generoMusical, sencillos, conciertos, giras, cod, nombre, apellido, edad, nacionalidad, salario);
                    }
                    pos2 += 35;
                }
                pos += 171;
                cont = 0;
            }
                return null;
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
