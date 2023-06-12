/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import static controlador.Ctrl_RegistrarVenta.idCabeceraRegistrada;
import java.sql.*;
import java.util.ArrayList;
import modelo.Carrito;
import modelo.DetalleVenta;
import modelo.Pedido;
/**
 *
 * @author Usuario
 */
public class Ctrl_Pedidos {
    
    public static int idCabeceraRegistrada;
    
    public boolean guardar(Pedido objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into pedido ("
                    + "idProducto, "
                    + "idCliente, "
                    + "cantidad, "
                    + "precio,"
                    + "subtotal,"
                    + "descuento,"
                    + "iva,"
                    + "totalProducto,"
                    + "estado,"
                    + "idCarrito) values(?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, objeto.getIdProducto());//id
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setDouble(4, objeto.getPrecioUnitario());
            consulta.setDouble(5, objeto.getSubTotal());
            consulta.setDouble(6, objeto.getDescuento());
            consulta.setDouble(7, objeto.getIva());
            consulta.setDouble(8, objeto.getTotalPagar());
            consulta.setInt(9, objeto.getEstado());
            consulta.setInt(10, objeto.getIdCarrito());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar PEDIDO: " + e);
        }
        return respuesta;
    }
//    public boolean guardarDetalle(Carrito objeto) {
//        boolean respuesta = false;
//        Connection cn = Conexion.conectar();
//        try {
//            PreparedStatement consulta = cn.prepareStatement("insert into ventas (idCarrito, idCliente,totalPagado,fecha) values(?,?,?,?)");
//            consulta.setInt(1, idCabeceraRegistrada);
//            consulta.setInt(2,);
//            consulta.setInt(3, objeto.getCantidad());
//            consulta.setDouble(4, objeto.getPrecioUnitario());
//            
//            if (consulta.executeUpdate() > 0) {
//                respuesta = true;
//            }
//            cn.close();
//        } catch (SQLException e) {
//            System.out.println("Error al guardar detalle de venta: " + e);
//        }
//        return respuesta;
//    }
    
    public int obtenerIdPedido(Pedido pedido){
        int id= 0;
        String sql = "SELECT id FROM pedido "
                + "WHERE idProducto= "+ pedido.getIdProducto() +" AND "
                + "idCliente= '"+ pedido.getIdCliente() +"' "
                + "AND cantidad= "+pedido.getCantidad() +" AND "
                + "precio = "+ pedido.getPrecioUnitario()+" AND "
                + "descuento= "+pedido.getDescuento()+" AND "
                + "iva = "+pedido.getIva()+" AND "
                + "estado = 1;";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("id");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return id;
    }
}
