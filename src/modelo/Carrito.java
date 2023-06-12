/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Carrito {
    private int idCliente;
    private double valorPagar;
    private String fechaVenta;
    private int estado;
    
    public Carrito(){
        this.idCliente = 0;
        this.valorPagar = 0.0;
        this.fechaVenta = "";
        this.estado = 0;
    }
    
    public Carrito(int idCliente, double valorPagar, String fechaVenta, int estado) {
        this.idCliente = idCliente;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "CabeceraVenta{" + "id cliente=" + idCliente + ", valorPagar=" + valorPagar + ", fechaVenta=" + fechaVenta + ", estado=" + estado + '}';
    }
}
