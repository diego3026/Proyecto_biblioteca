
package clases;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private int numeroDeIdentificacion;
    private String contraseña;
    private ArrayList<Libro> historialDePrestamos;
    private boolean administrador;

    public Usuario(String nombre, int numeroDeIdentificacion, String contraseña, boolean administrador) {
        this.nombre = nombre;
        this.numeroDeIdentificacion = numeroDeIdentificacion;
        this.historialDePrestamos = new ArrayList<>();
        this.contraseña = contraseña;
        this.administrador = administrador;
    }

    public boolean isAdministrador() {
        return administrador;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", numeroDeIdentificacion=" + numeroDeIdentificacion + ", historialDePrestamos=" + historialDePrestamos.toString() + '}';
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public void setNumeroDeIdentificacion(int numeroDeIdentificacion) {
        this.numeroDeIdentificacion = numeroDeIdentificacion;
    }

    public ArrayList<Libro> getHistorialDePrestamos() {
        return historialDePrestamos;
    }

    public void addHistorialDePrestamos(Libro libroPrestado) {
        this.historialDePrestamos.add(libroPrestado);
    } 
    
    public void removeHistorialDePrestamos(Libro libroPrestado) {
        this.historialDePrestamos.remove(libroPrestado);
    }
    
}
