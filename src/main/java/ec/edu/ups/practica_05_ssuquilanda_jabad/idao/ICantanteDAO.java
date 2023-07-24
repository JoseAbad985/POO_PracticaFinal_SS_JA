/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.idao;

import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Disco;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public interface ICantanteDAO {
    public void create(Cantante cantate);
    public Cantante read(int id);
    public void update(Cantante cantante);
    public void delete(Cantante cantante);   
    public List<Cantante> findAll();
    public void createDisc(Cantante cantante, Disco disco);
    public Disco readDisc(Cantante cantante, int disco);
    public void updateDisc(Cantante cantante, Disco disco);
    public void deleteDisc(Cantante cantante, Disco disco);
    public List<Disco> findAllDiscs(Cantante cantante);
    public Cantante readDiscWOS(int codigo);
}

