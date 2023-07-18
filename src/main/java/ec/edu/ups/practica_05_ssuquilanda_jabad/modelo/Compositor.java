/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ESTUDIANTE
 */
public class Compositor extends Persona {

    // Atributos de la clase
    private int numeroDeComposiciones;
    //Atributos de la relacion de composición
    private List<Cancion> cancionesTop100Billboard;
    private List<Cantante> clientes;

    //Constructor con todos los parametros
    public Compositor(int numeroDeComposiciones, int codigo, String nombre, String apellido, int edad, double salario, String nacionalidad) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.numeroDeComposiciones = numeroDeComposiciones;
        this.cancionesTop100Billboard = new ArrayList();
        this.clientes = new ArrayList();
    }

    public Compositor() {
    }

    public List<Cancion> getCancionesTop100Billboard() {
        return cancionesTop100Billboard;
    }

    public void setCancionesTop100Billboard(List<Cancion> cancionesTop100Billboard) {
        this.cancionesTop100Billboard = cancionesTop100Billboard;
    }

    public List<Cantante> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cantante> clientes) {
        this.clientes = clientes;
    }

    public Compositor(int codigo) {
        super(codigo);
    }

    //Getters y Setters
    public int getNumeroDeComposiciones() {
        return numeroDeComposiciones;
    }

    public void setNumeroDeComposiciones(int numeroDeComposiciones) {
        this.numeroDeComposiciones = numeroDeComposiciones;
    }

    //Sobreescritura del metodo hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numeroDeComposiciones;
        hash = 83 * hash + Objects.hashCode(this.cancionesTop100Billboard);
        hash = 83 * hash + Objects.hashCode(this.clientes);
        return hash;
    }

    //Sobreescritura del metodo equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compositor other = (Compositor) obj;
        if (this.numeroDeComposiciones != other.numeroDeComposiciones) {
            return false;
        }
        if (!Objects.equals(this.cancionesTop100Billboard, other.cancionesTop100Billboard)) {
            return false;
        }
        return Objects.equals(this.clientes, other.clientes);
    }
    //toString

    @Override
    public String toString() {
        return "Compositor{" + "numeroDeComposiciones=" + numeroDeComposiciones + '}';
    }

    //sobreescritura del metodo abstracto de la clase Persona
    @Override
    public double calcularSalario(double salario) {
        double salarioFinal = salario;
        if (numeroDeComposiciones > 5) {
            salarioFinal = salarioFinal + 300;
        }
        if (cancionesTop100Billboard == null) {
            salarioFinal = salarioFinal;
        } else if (cancionesTop100Billboard.size() >= 1 && cancionesTop100Billboard.size() <= 3) {
            salarioFinal = salarioFinal + (salario * 1.1);
        } else if (cancionesTop100Billboard.size() >= 4 && cancionesTop100Billboard.size() <= 6) {
            salarioFinal = salarioFinal + (salario * 1.2);
        } else if (cancionesTop100Billboard.size() > 6) {
            salarioFinal = salarioFinal + (salario * 1.2);
        }

        return salarioFinal;
    }

    //Metodos Agregacion Canción
    public void agregarCancion(Cancion cancion) {
        cancionesTop100Billboard.add(cancion);
    }

    public Cancion buscarCancion(int codigo) {
        for (Cancion cancion : cancionesTop100Billboard) {
            if (cancion.getCodigo() == codigo) {
                return cancion;
            }
        }
        return null;
    }

    public void actualizarCancion(Cancion cancion) {
        for (int i = 0; i < cancionesTop100Billboard.size(); i++) {
            Cancion c = cancionesTop100Billboard.get(i);
            if (c.getCodigo() == cancion.getCodigo()) {
                cancionesTop100Billboard.set(i, cancion);
                break;
            }
        }

    }

    public void eliminarCancion(Cancion cancion) {
        Iterator<Cancion> it = cancionesTop100Billboard.iterator();
        while (it.hasNext()) {
            Cancion c = it.next();
            if (c.getCodigo() == cancion.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    public List<Cancion> listarCanciones() {
        return cancionesTop100Billboard;
    }

    //Metodos agregacion Cliente
    public void agregarCliente(Cantante cliente) {
        clientes.add(cliente);
    }

    public Cantante buscarCliente(int codigo) {
        for (Cantante cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    public void actualizarCliente(Cantante cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            Cantante c = clientes.get(i);
            if (c.getCodigo() == cliente.getCodigo()) {
                clientes.set(i, cliente);
                break;
            }
        }

    }

    public void eliminarCliente(Cantante cliente) {
        Iterator<Cantante> it = clientes.iterator();
        while (it.hasNext()) {
            Cantante c = it.next();
            if (c.getCodigo() == cliente.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    public List<Cantante> listarClientes() {
        return clientes;
    }

}
