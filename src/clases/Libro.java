
package clases;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private int añoDePublicacion;
    private String genero;

    public Libro(String titulo, String autor, int añoDePublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoDePublicacion = añoDePublicacion;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", a\u00f1oDePublicacion=" + añoDePublicacion + ", genero=" + genero + '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAñoDePublicacion() {
        return añoDePublicacion;
    }

    public void setAñoDePublicacion(int añoDePublicacion) {
        this.añoDePublicacion = añoDePublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.añoDePublicacion != other.añoDePublicacion) {
            return false;
        }
        if (!this.titulo.equalsIgnoreCase(other.titulo.toLowerCase())) {
            return false;
        }
        if (!this.genero.equalsIgnoreCase(other.genero)) {
            return false;
        }
        return this.autor.equalsIgnoreCase(autor);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.titulo.toLowerCase());
        hash = 53 * hash + Objects.hashCode(this.autor.toLowerCase());
        hash = 53 * hash + this.añoDePublicacion;
        hash = 53 * hash + Objects.hashCode(this.genero.toLowerCase());
        return hash;
    }
    
    

}
