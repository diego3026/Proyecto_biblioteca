package clases;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author asus
 */
public class Biblioteca {

    private ArrayList<Libro> libros;
    private ArrayList<Libro> librosPrestados;
    private ArrayList<Libro> historialDeLibrosPrestados;
    private ArrayList<Usuario> usuarios;
    private int idUser;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        librosPrestados = new ArrayList<>();
        historialDeLibrosPrestados = new ArrayList<>();
        idUser = 100;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public int getIdUser() {
        return idUser;
    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    public boolean addLibros(Libro libro) {
        boolean bandera = true;
        if (libros.contains(libro)) {
            return false;
        }
        for (int i = 0; i < librosPrestados.size(); i++) {
            Libro get = librosPrestados.get(i);
            if (get.getTitulo().equalsIgnoreCase(libro.getTitulo())
                    && get.getAutor().equalsIgnoreCase(libro.getAutor())
                    && get.getAñoDePublicacion() == libro.getAñoDePublicacion()
                    && get.getGenero().equalsIgnoreCase(libro.getGenero())) {
                bandera = false;
            }
        }
        if(bandera==true){
            this.libros.add(libro);
            return true;  
        }
        return false;
    }

    public boolean addLibrosPrestados(Libro libro) {
        if (!librosPrestados.contains(libro)) {
            librosPrestados.add(libro);
            historialDeLibrosPrestados.add(libro);
            return true;
        }
        return false;
    }

    public void addHistorialLibrosPrestados(Libro libro) {
        historialDeLibrosPrestados.add(libro);
    }

    public void removeLibros(Libro libro) {
        this.libros.remove(libro);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean addUsuarios(String nombreDelUsuario, String contraseña, boolean admin) {
        boolean estado = false;
        try {
            this.usuarios.add(new Usuario(nombreDelUsuario, getIdUser(), contraseña, admin));
            idUser++;
            estado = true;
        } catch (Exception e) {
        }
        return estado;
    }

    public ArrayList<Libro> getHistorialDeLibrosPrestados() {
        return historialDeLibrosPrestados;
    }

    public Usuario obtUsuario(int id, String contraseña) {
        if (id > idUser) {
            return null;
        } else {
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario get = usuarios.get(i);
                if (get.getNumeroDeIdentificacion() == id && get.getContraseña().equals(contraseña)) {
                    return get;
                }
            }
            return null;
        }
    }

    public ArrayList<Usuario> usuariosConMasPrestamos() {
        int contador = 0;
        HashMap<Usuario, Integer> usuariosConMasP = new HashMap<>();

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario get = usuarios.get(i);
            for (int j = 0; j < get.getHistorialDePrestamos().size(); j++) {
                contador++;
            }
            if (contador > 0) {
                usuariosConMasP.put(get, contador);
                contador = 0;
            }
        }

        ArrayList<Usuario> usuariosConMasPrestamos = new ArrayList<>(usuariosConMasP.keySet());

        return usuariosConMasPrestamos;
    }

    public ArrayList<Libro> librosPopulares() {
        int contador = 1;
        HashMap<Libro, Integer> librosP = new HashMap<>();

        for (int i = 0; i < historialDeLibrosPrestados.size(); i++) {
            Libro get = historialDeLibrosPrestados.get(i);

            for (int j = 0; j < historialDeLibrosPrestados.size(); j++) {
                Libro get1 = historialDeLibrosPrestados.get(j);
                if (get.equals(get1)) {
                    contador++;
                }
            }
            librosP.put(get, contador);
            contador = 1;
        }
        ArrayList<Libro> librosPopulares = new ArrayList<>(librosP.keySet());
        return librosPopulares;
    }

    public void removeUsuarios(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public boolean realizarPrestamo(int idUsuario, Libro libro) {
        boolean prestamo = false;
        if (this.idUser < idUsuario) {
            return false;
        } else {
            if (consultarDisponibilidad(libro)) {
                for (int i = 0; i < usuarios.size(); i++) {
                    Usuario get = usuarios.get(i);
                    if (get.getNumeroDeIdentificacion() == idUsuario && !get.isAdministrador()) {
                        get.addHistorialDePrestamos(libro);
                        prestamo = true;
                    }
                }
                if (prestamo) {
                    this.librosPrestados.add(libro);
                    this.historialDeLibrosPrestados.add(libro);
                    libros.remove(libro);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean devolverLibroPrestado(int idUsuario, Libro libroPrestado) {
        if (this.idUser < idUsuario) {
            return false;
        } else {
            if (this.librosPrestados.contains(libroPrestado)) {
                for (int i = 0; i < usuarios.size(); i++) {
                    Usuario get = usuarios.get(i);
                    if (get.getNumeroDeIdentificacion() == idUsuario) {
                        for (int j = 0; j < get.getHistorialDePrestamos().size(); j++) {
                            Libro get1 = get.getHistorialDePrestamos().get(j);
                            if (get1.getTitulo().equalsIgnoreCase(libroPrestado.getTitulo())
                                    && get1.getAutor().equalsIgnoreCase(libroPrestado.getAutor())
                                    && get1.getAñoDePublicacion() == libroPrestado.getAñoDePublicacion()
                                    && get1.getGenero().equalsIgnoreCase(libroPrestado.getGenero())) {
                                librosPrestados.remove(libroPrestado);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean consultarDisponibilidad(Libro libro) {
        for (int i = 0; i < libros.size(); i++) {
            Libro get = libros.get(i);
            if (get.getTitulo().equalsIgnoreCase(libro.getTitulo())
                    && get.getAutor().equalsIgnoreCase(libro.getAutor())
                    && get.getAñoDePublicacion() == libro.getAñoDePublicacion()
                    && get.getGenero().equalsIgnoreCase(libro.getGenero())) {

                return true;
            }
        }
        return false;
    }

}
