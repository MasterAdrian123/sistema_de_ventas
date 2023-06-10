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
    private int idCarrito;
    private int idPedido;
    private double valorPagar;
    private String fechaVenta;
    private int estado;
    
    public Carrito(){
        this.idCarrito = 0;
        this.idPedido = 0;
        this.valorPagar = 0.0;
        this.fechaVenta = "";
        this.estado = 0;
    }
    
    public Carrito(int idCarrito, int idPedido, double valorPagar, String fechaVenta, int estado) {
        this.idCarrito = idCarrito;
        this.idPedido = idPedido;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
        return "CabeceraVenta{" + "id carrito=" + idCarrito + ", idCliente=" + idPedido + ", valorPagar=" + valorPagar + ", fechaVenta=" + fechaVenta + ", estado=" + estado + '}';
    }
}
