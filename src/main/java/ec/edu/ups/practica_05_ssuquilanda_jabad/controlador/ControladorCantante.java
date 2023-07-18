/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.controlador;

import ec.edu.ups.practica_05_ssuquilanda_jabad.idao.ICantanteDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Cantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Compositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.modelo.Disco;
import java.util.List;

/**
 *
 * @author josea
 */
public class ControladorCantante {

    //objetos vist
    //private VistaCantante vistaCantante;
    //private VistaDisco vistaDisco;
    //objetos modelo
    private Cantante cantante;
    private Disco disco;
    //objetos DAO
    private ICantanteDAO cantanteDAO;
    
    

    public ControladorCantante(ICantanteDAO cantanteDAO) {
        this.cantanteDAO = cantanteDAO;
    }
    

    //llama al DAO para guardar un cantante
    public void registrarCantante(Cantante cantante) {
        this.cantante = cantante;
        
        
        cantanteDAO.create(cantante);
    }

    //llama al DAO para obtener un cantante por el id y luego los muestra en la vista
    public Cantante buscarCantante(int codigo) {

        this.cantante = cantanteDAO.read(codigo);
        cantante.setSalarioFinal(cantante.calcularSalario(cantante.getSalario()));
        return this.cantante;
    }

    public Cantante verCantantexDisco(int codigo) {
        List<Cantante> cantantes = cantanteDAO.findAll();
        for (Cantante cantante : cantantes) {
            List<Disco> discos = cantante.listarDiscos();
            for (Disco disco : discos) {
                if (disco.equals(cantante.buscarDisco(codigo))) {
                    return cantante;
                }
            }

        }
        return null;
    }

    //llama al DAO para actualizar un cantante
    public boolean actualizarCantante(Cantante cantante) {
         Cantante cantanteEncontrado = this.buscarCantante(cantante.getCodigo());
        if (cantanteEncontrado != null) {
            cantanteDAO.update(cantante);
            return true;
        }
        return false;
    }

    //llama al DAO para eliminar un cantante
    public boolean eliminarCantante(Cantante cantante) {
        Cantante cantanteEncontrado = this.buscarCantante(cantante.getCodigo());
        if (cantanteEncontrado != null) {
            cantanteDAO.delete(cantante);
            return true;
        }
        return false;
    }

    //llama al DAO para obtener todos los cantantes y luego los muestra en la vista
    public List<Cantante> listarCantantes(){
        return cantanteDAO.findAll();
    }
    //Metodos de Disco
    public void agregarDisco(Cantante cantante, Disco disco) {
        this.cantante = cantante;
        this.disco = disco;
        cantante.agregarDisco(disco);
    }
    public Disco buscarDisco (Cantante cantante, int codigo){
        this.cantante = cantante;
        Disco disco = cantante.buscarDisco(codigo);
        if(disco!=null){
            return disco;
        }else{
            return null;
        }
    }
    public boolean eliminarDisco(Cantante cantante, Disco disco) {
        Cantante cantanteEncontrado = this.cantante;
        if (cantanteEncontrado != null) {
            cantanteEncontrado.eliminarDisco(disco);
            return true;
        }
        return false;
    }
    public boolean actualizarDisco(Cantante cantante, Disco disco) {
        Cantante cantanteEncontrado = this.cantante;
        if (cantanteEncontrado != null) {
            cantanteEncontrado.actualizarDisco(disco);
            return true;
        }
        return false;
    }
    public List<Disco> discografia(Cantante cantante) {
        Cantante cantanteEncontrado = this.cantante;
        if (cantanteEncontrado != null) {
            return cantanteEncontrado.listarDiscos();
        } else {
            return null;
        }

    }
    
}

    

