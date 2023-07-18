/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.controlador;

import ec.edu.ups.practica_05_ssuquilanda_jabad.idao.ICantanteDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.idao.ICompositorDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cancion;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Compositor;
import java.util.List;

/**
 *
 * @author josea
 */
public class ControladorCompositor {

    //objetos modelo
    private Compositor compositor;
    private Cancion cancion;
    private Cantante cantante;
    //objetos DAO
    private ICompositorDAO compositorDAO;
    private ICantanteDAO cantanteDAO;

    public ControladorCompositor(ICompositorDAO compositorDAO) {
        this.compositorDAO = compositorDAO;
    }

    public ControladorCompositor(Compositor compositor, Cancion cancion, Cantante cantante, ICompositorDAO compositorDAO, ICantanteDAO cantanteDAO) {
        this.compositor = compositor;
        this.cancion = cancion;
        this.cantante = cantante;
        this.compositorDAO = compositorDAO;
        this.cantanteDAO = cantanteDAO;
    }

    public Compositor verCompositorxCancion(int codigo) {
        List<Compositor> compositores = compositorDAO.findAll();

        for (Compositor compositor : compositores) {
            List<Cancion> canciones = compositor.listarCanciones();
            for (Cancion cancion : canciones) {
                if (cancion.equals(compositor.buscarCancion(codigo))) {
                    return compositor;
                }
            }

        }
        return null;
    }

    //llama al DAO para guardar un compositor
    public void registrarCompositor(Compositor compositor) {
        this.compositor = compositor;
        compositorDAO.create(compositor);
    }

    public void registrarCliente(Compositor compositor, Cantante cliente) {
        this.compositor = compositor;
        this.cantante = cliente;
        compositor.agregarCliente(cliente);
    }

    //llama al DAO para obtener un compositor por el id y luego los muestra en la vista
    public Compositor buscarCompositor(int codigo) {
        this.compositor = compositorDAO.read(codigo);
        return this.compositor;
    }

    //llama al DAO para actualizar un compositor
    public boolean actualizarCompositor(Compositor compositor) {
        Compositor compositorEncontrado = this.buscarCompositor(compositor.getCodigo());
        if (compositorEncontrado != null) {
            compositorDAO.update(compositor);
            return true;
        }
        return false;
    }

    //llama al DAO para 
    public boolean eliminarCompositor(Compositor compositor) {
        Compositor compositorEncontrado = this.buscarCompositor(compositor.getCodigo());
        if (compositorEncontrado != null) {
            compositorDAO.delete(compositor);
            return true;
        }
        return false;
    }

    //llama al DAO para obtener todos los cantantes y luego los muestra en la vista
    public List<Compositor> listarCompositores() {
        return compositorDAO.findAll();
    }

    //ejemplo de agregacion de Cancion
    public void agregarCancion(Compositor compositor, Cancion cancion) {
        this.compositor = compositor;
        this.cancion = cancion;
        compositor.agregarCancion(cancion);
    }
    //Metodos de cancion
    public Cancion buscarCancion(Compositor compositor, int codigo) {
        this.compositor = compositor;
        Cancion cancion = compositor.buscarCancion(codigo);
        if(cancion!=null){
            return cancion;
        }else{
            return null;
        }
    }

    //llama al DAO para actualizar un compositor
    public boolean actualizarCancion(Compositor compositor, Cancion cancion) {
        Compositor compositorEncontrado = this.compositor;
        if (compositorEncontrado != null) {
            compositorEncontrado.actualizarCancion(cancion);
            return true;
        }
        return false;
    }

    //llama al DAO para 
    public boolean eliminarCancion(Compositor compositor, Cancion cancion) {
        Compositor compositorEncontrado = this.compositor;
        if (compositorEncontrado != null) {
            compositorEncontrado.eliminarCancion(cancion);
            return true;
        }
        return false;
    }

    //llama al DAO para obtener todos los cantantes y luego los muestra en la vista
    public List<Cancion> listarCanciones(Compositor compositor) {
        Compositor compositorEncontrado = this.compositor;
        if (compositorEncontrado != null) {
            return compositorEncontrado.listarCanciones();
        }else{
           return null; 
        }
    }
    public boolean actualizarCliente(Compositor compositor, Cantante cliente) {
        Compositor compositorEncontrado = this.compositor;
        if (compositorEncontrado != null) {
            cantanteDAO.update(cliente);
            return true;
        }
        return false;
    }

    public boolean eliminarClienteDelCompositor(Compositor compositor, Cantante cliente) {
        Compositor compositorEncontrado = this.compositor;
        if (compositorEncontrado != null) {
            cantanteDAO.delete(cliente);
            return true;
        }
        return false;
    }

    public List<Cantante> listarClientes(Compositor compositor) {
        Compositor compositorEncontrado = this.compositor;
        if (compositorEncontrado != null) {
            return compositorEncontrado.listarClientes();
        } else {
            return null;
        }

    }
}

