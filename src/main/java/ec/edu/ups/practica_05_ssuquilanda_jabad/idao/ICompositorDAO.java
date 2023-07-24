/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.idao;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cancion;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Compositor;
import java.util.List;

/**
 *
 * @author josea
 */
public interface ICompositorDAO {
    public void create(Compositor compositor);
    public Compositor read(int id);
    public void update(Compositor compositor);
    public void delete(Compositor compositor);   
    public List<Compositor> findAll();
    public void createCancion(Compositor compositor, Cancion cancion);
    public Cancion readCancion(Compositor compositor, int codigo);
    public void updateCancion(Compositor compositor, Cancion cancion);
    public void deleteCancion(Compositor compositor, Cancion cancion);
    public List<Cancion> findAllCancion(Compositor compositor);
    public Compositor readCancionWOS(int codigo);
}
