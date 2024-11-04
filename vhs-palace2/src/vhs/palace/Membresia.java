/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vhs.palace;

public class Membresia {
    private int membresiaId;
    private int usuarioId;
    private String fechaInicio;
    private String fechaFin;
    private String tipo;

    // Constructor completo
    public Membresia(int membresiaId, int usuarioId, String fechaInicio, String fechaFin, String tipo) {
        this.membresiaId = membresiaId;
        this.usuarioId = usuarioId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
    }

    // Constructor vacío
    public Membresia() {}

    // Getters y Setters
    public int getMembresiaId() {
        return membresiaId;
    }

    public void setMembresiaId(int membresiaId) {
        this.membresiaId = membresiaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
