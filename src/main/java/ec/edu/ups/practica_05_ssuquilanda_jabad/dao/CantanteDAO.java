/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.dao;

import ec.edu.ups.practica_05_ssuquilanda_jabad.idao.ICantanteDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cantante;
import java.io.BufferedWriter;
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
                archivoCantante.seek(archivoCantante.length());
                archivoCantante.writeChars("\n");
                archivoCantante.writeInt(cantante.getCodigo());
                String nombre = cantante.getNombre();
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
                archivoCantante.writeUTF(nombre);
                String apellido = cantante.getApellido();
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
                archivoCantante.writeUTF(apellido);
                archivoCantante.writeInt(cantante.getEdad());
                String Nacionalidad = cantante.getNacionalidad();
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
                archivoCantante.writeUTF(Nacionalidad);
                String NombreArtistico = cantante.getNombreArtistico();
                if (NombreArtistico.length() < 25) {
                    StringBuilder sbNA = new StringBuilder(NombreArtistico);
                    while (sbNA.length() < 25) {
                        sbNA.append(" ");
                    }
                    NombreArtistico = sbNA.toString();
                } else if (NombreArtistico.length() > 25) {
                    int eliminar = NombreArtistico.length() - 25;
                    NombreArtistico = NombreArtistico.substring(0, NombreArtistico.length() - eliminar);
                }
                
                archivoCantante.writeUTF(NombreArtistico);
                String GeneroMusical = cantante.getGeneroMusical();
                if (GeneroMusical.length() < 25) {
                    StringBuilder sbGM = new StringBuilder(GeneroMusical);
                    while (sbGM.length() < 25) {
                        sbGM.append(" ");
                    }
                    GeneroMusical = sbGM.toString();
                } else if (GeneroMusical.length() > 25) {
                    int eliminar = GeneroMusical.length() - 25;
                    GeneroMusical = GeneroMusical.substring(0, GeneroMusical.length() - eliminar);
                }
                
                archivoCantante.writeUTF(GeneroMusical);
                archivoCantante.writeInt(cantante.getNumeroDeSencillos());
                archivoCantante.writeInt(cantante.getNumeroDeConciertos());
                archivoCantante.writeInt(cantante.getNumeroDeGiras());
                archivoCantante.writeDouble(cantante.getSalario());
                archivoCantante.writeDouble(cantante.getSalarioFinal());
                archivoCantante.close();
            } else {
                archivoCantante.seek(archivoCantante.length());
                archivoCantante.writeChars("\n");
                archivoCantante.writeInt(cantante.getCodigo());
                String nombre = cantante.getNombre();
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
                archivoCantante.writeUTF(nombre);
                String apellido = cantante.getApellido();
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
                archivoCantante.writeUTF(apellido);
                archivoCantante.writeInt(cantante.getEdad());
                String Nacionalidad = cantante.getNacionalidad();
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
                archivoCantante.writeUTF(Nacionalidad);
                String NombreArtistico = cantante.getNombreArtistico();
                if (NombreArtistico.length() < 25) {
                    StringBuilder sbNA = new StringBuilder(NombreArtistico);
                    while (sbNA.length() < 25) {
                        sbNA.append(" ");
                    }
                    NombreArtistico = sbNA.toString();
                } else if (NombreArtistico.length() > 25) {
                    int eliminar = NombreArtistico.length() - 25;
                    NombreArtistico = NombreArtistico.substring(0, NombreArtistico.length() - eliminar);
                }
                
                archivoCantante.writeUTF(NombreArtistico);
                String GeneroMusical = cantante.getGeneroMusical();
                if (GeneroMusical.length() < 25) {
                    StringBuilder sbGM = new StringBuilder(GeneroMusical);
                    while (sbGM.length() < 25) {
                        sbGM.append(" ");
                    }
                    GeneroMusical = sbGM.toString();
                } else if (GeneroMusical.length() > 25) {
                    int eliminar = GeneroMusical.length() - 25;
                    GeneroMusical = GeneroMusical.substring(0, GeneroMusical.length() - eliminar);
                }
                
                archivoCantante.writeUTF(GeneroMusical);
                archivoCantante.writeInt(cantante.getNumeroDeSencillos());
                archivoCantante.writeInt(cantante.getNumeroDeConciertos());
                archivoCantante.writeInt(cantante.getNumeroDeGiras());
                archivoCantante.writeDouble(cantante.getSalario());
                archivoCantante.writeDouble(cantante.getSalarioFinal());
                archivoCantante.close();
            }
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
/*
    @Override
    public int read(int id) {
        try {
            boolean encuentra = false;
            int pos = 0;
            archivoCantante.seek(pos);
            archivoCantante.
            while (encuentra) {
                int cod = archivoCantante.readInt();
                if (cod == id) {
                    return cod;
                } else {
                    pos +=;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CantanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /*
    @Override
    public void update(Cantante cantante) {
        for (int i = 0; i < listaCantante.size(); i++) {
            Cantante c = listaCantante.get(i);
            if (c.getCodigo() == cantante.getCodigo()) {
                listaCantante.set(i, cantante);
                break;
            }
        }

    }

    @Override
    public void delete(Cantante cantante) {
        Iterator<Cantante> it = listaCantante.iterator();
        while (it.hasNext()) {
            Cantante c = it.next();
            if (c.getCodigo() == cantante.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Cantante> findAll() {
        return listaCantante;
    }
     */
    @Override
    public int read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Cantante cantante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Cantante cantante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cantante> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
