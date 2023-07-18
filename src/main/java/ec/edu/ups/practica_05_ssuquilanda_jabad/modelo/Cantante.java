/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cantante extends Persona {

    private String nombreArtistico;
    private String generoMusical;
    private int numeroDeSencillos;
    private int numeroDeConciertos;
    private int numeroDeGiras;
    //atributo de relacion con la clase Disco
    private List<Disco> discografia;

    /*
        Creamos un contructor con los atributos de la clase Cantante, 
        ademas de los atributos que hereda de la clase Persona
     */
    public Cantante(String nombreArtistico, String generoMusical, int numeroDeSencillos, int numeroDeConciertos, int numeroDeGiras, int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.numeroDeSencillos = numeroDeSencillos;
        this.numeroDeConciertos = numeroDeConciertos;
        this.numeroDeGiras = numeroDeGiras;
        this.discografia = new ArrayList<>();
    }

    public Cantante() {
    }

    public Cantante(int codigo) {
        super(codigo);
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getNumeroDeSencillos() {
        return numeroDeSencillos;
    }

    public void setNumeroDeSencillos(int numeroDeSencillos) {
        this.numeroDeSencillos = numeroDeSencillos;
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos;
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos;
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras;
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras;
    }

    public List<Disco> getDiscografia() {
        return discografia;
    }

    public void setDiscografia(List<Disco> discografia) {
        this.discografia = discografia;
    }

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
        final Cantante other = (Cantante) obj;
        if (this.numeroDeSencillos != other.numeroDeSencillos) {
            return false;
        }
        if (this.numeroDeConciertos != other.numeroDeConciertos) {
            return false;
        }
        if (this.numeroDeGiras != other.numeroDeGiras) {
            return false;
        }
        if (!Objects.equals(this.nombreArtistico, other.nombreArtistico)) {
            return false;
        }
        if (!Objects.equals(this.generoMusical, other.generoMusical)) {
            return false;
        }
        return Objects.equals(this.discografia, other.discografia);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.nombreArtistico);
        hash = 13 * hash + Objects.hashCode(this.generoMusical);
        hash = 13 * hash + this.numeroDeSencillos;
        hash = 13 * hash + this.numeroDeConciertos;
        hash = 13 * hash + this.numeroDeGiras;
        hash = 13 * hash + Objects.hashCode(this.discografia);
        return hash;
    }

    @Override
    public String toString() {
        return "Cantante{" + "nombreArtistico=" + nombreArtistico + ", generoMusical=" + generoMusical + ", numeroDeSencillos=" + numeroDeSencillos + ", numeroDeConciertos=" + numeroDeConciertos + ", numeroDeGiras=" + numeroDeGiras + ", discografia=" + discografia + '}';
    }

    public void agregarDisco(Disco disco) {
        discografia.add(disco);
    }

    public Disco buscarDisco(int codigo) {
        for (Disco disco : discografia) {
            if (disco.getCodigo() == codigo) {
                return disco;
            }
        }
        return null;
    }

    public void eliminarDisco(Disco disco) {
        if (discografia.contains(disco)) {
            int index = discografia.indexOf(disco);
            discografia.remove(index);
        }
    }

    public void actualizarDisco(Disco disco) {
        if (discografia.contains(disco)) {
            int index = discografia.indexOf(disco);
            discografia.set(index, disco);
        }
    }

    public List<Disco> listarDiscos() {
        return discografia;
    }

    @Override
    public double calcularSalario(double salario) {
        double salarioFinal = salario;
        if (numeroDeSencillos > 10 && numeroDeGiras > 3) {
            salarioFinal = salarioFinal + 1000;
        }
        if (numeroDeSencillos >= 1 && numeroDeSencillos <= 10) {
            salarioFinal = salarioFinal + (salario * 1.05);
        }
        if (numeroDeGiras >= 1 && numeroDeGiras <= 3) {
            salarioFinal = salarioFinal + (salario * 1.03);
        }
        if (discografia == null) {
            salarioFinal = salarioFinal;
        } else if (discografia.size() >= 5) {
            salarioFinal = salarioFinal + 2000;
        }
        return salarioFinal;
    }
}

