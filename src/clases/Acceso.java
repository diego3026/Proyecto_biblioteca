/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;


public class Acceso {
    private static Biblioteca biblioteca = new Biblioteca();
    
    public static boolean addUsuarios(String nombreDelUsuario,String contraseña, boolean admin){
        return biblioteca.addUsuarios(nombreDelUsuario, contraseña, admin);
    }
    
    public static void removeLibro(Libro libro){
        biblioteca.removeLibros(libro);
    }
    
    public static ArrayList<Libro> mostrarLibros(){        
        return biblioteca.getLibros();
    }
    
    public static Usuario getUsuario(int id, String contraseña){
        Usuario user = biblioteca.obtUsuario(id, contraseña);
        return user;
    } 
    
    public static ArrayList<Libro> obtenerLibrosPrestados(){
        return biblioteca.getLibrosPrestados();
    }
    
    public static int getId(String nombre, String contraseña){
        for (int i = 0; i < biblioteca.getUsuarios().size(); i++) {
            Usuario get = biblioteca.getUsuarios().get(i);
            if(get.getNombre().equals(nombre) && get.getContraseña().equals(contraseña)){
                return get.getNumeroDeIdentificacion();
            }
        }
        return -1;
    }
    
    public static boolean autenticar(int id, String contraseña){
        if(getUsuario(id, contraseña)!= null){
            Usuario aux = getUsuario(id, contraseña);
            if(aux.getNumeroDeIdentificacion()==id && aux.getContraseña().equals(contraseña)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static boolean addLibro(String titulo, String autor, int añoDePublicacion, String genero) {
        Libro libro = new Libro(titulo, autor, añoDePublicacion, genero);
        return biblioteca.addLibros(libro);
    }

    public static boolean realizarPrestamo(int id, String titulo, String autor, int añoDePublicacion, String genero) {
        Libro libro = new Libro(titulo, autor, añoDePublicacion, genero);
        return biblioteca.realizarPrestamo(id, libro);
    }

    public static boolean addLibroPrestado(String titulo, String autor, int añoDePublicacion, String genero) {
        Libro libro = new Libro(titulo, autor, añoDePublicacion, genero);
        return biblioteca.addLibrosPrestados(libro);
    }    
    public static boolean devolverLibro(int id, String titulo, String autor, int añoDePublicacion, String genero) {
        Libro libro = new Libro(titulo, autor, añoDePublicacion, genero);
        return biblioteca.devolverLibroPrestado(id, libro);
    }

    public static boolean consultarLibro(String titulo, String autor, int añoDePublicacion, String genero) {
        Libro libroConsultar = new Libro(titulo, autor, añoDePublicacion, genero);
        return biblioteca.consultarDisponibilidad(libroConsultar);
    }

    public static ArrayList<Libro> obtenerLibrosPopulares() {
        return biblioteca.librosPopulares();
    }

    public static ArrayList<Usuario> obtenerUsuariosConMasPrestamos() {
        return biblioteca.usuariosConMasPrestamos();
    }

    public static void cargarUsuariosConPrestamo(int id, Libro libro) {
        ArrayList<Usuario> usuarios = biblioteca.getUsuarios();
        
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario get = usuarios.get(i);
            if(get.getNumeroDeIdentificacion() == id){
                get.addHistorialDePrestamos(libro);
            }
        }
    }

    public static boolean isAdmin(int id, String contraseña) {
        if(getUsuario(id, contraseña)!= null){
            Usuario aux = getUsuario(id, contraseña);
            if(aux.getNumeroDeIdentificacion()==id && aux.getContraseña().equals(contraseña) && aux.isAdministrador()){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static void addHistorialLibrosPrestados(String titulo, String autor, int añoDePublicacion, String genero) {
        Libro libro = new Libro(titulo, autor, añoDePublicacion, genero);
        biblioteca.addHistorialLibrosPrestados(libro);
    }
}
