
package vhs.palace;

public class Contenido {
    private int peliculaId;
    private String titulo;
    private String genero;
    private String formato;
    private int ano;
    private double precio;
    private int stock;

    // Constructor completo
    public Contenido(int peliculaId, String titulo, String genero, String formato, int ano, double precio, int stock) {
        this.peliculaId = peliculaId;
        this.titulo = titulo;
        this.genero = genero;
        this.formato = formato;
        this.ano = ano;
        this.precio = precio;
        this.stock = stock;
    }

    // Constructor vacío
    public Contenido() {}

    // Getters y Setters
    public int getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(int peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
