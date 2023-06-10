/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import modelo.Carrito;
import modelo.Pedido;
/**
 *
 * @author Usuario
 */
public class Ctrl_Pedidos {
    
    public static int idCabeceraRegistrada;
    java.math.BigDecimal iDColVar;
    
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
                    + "descuento,iva,totalProducto,estado) values(?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, objeto.getIdProducto());//id
            consulta.setString(2, objeto.getIdCliente());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setDouble(4, objeto.getPrecioUnitario());
            consulta.setDouble(5, objeto.getSubTotal());
            consulta.setDouble(6, objeto.getDescuento());
            consulta.setDouble(7, objeto.getIva());
            consulta.setDouble(8, objeto.getTotalPagar());
            consulta.setInt(9, objeto.getEstado());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar PEDIDO: " + e);
        }
        return respuesta;
    }
    public boolean insertarCarrito(String idCliente, int idPedido, int estado, String fecha, double total){
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO carrito VALUES(?,?,?,?,?)");
            consulta.setString(1, idCliente);
            consulta.setInt(2,idPedido);
            consulta.setInt(3, estado);
            consulta.setString(4, fecha);
            consulta.setDouble(5, total);
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al guardar EN EL CARRITO: " + e);
        }
        
        return respuesta;
    }
    public int obtenerIdPedido(String cliente, double total, int producto){
        int id= 0;
        String sql = "SELECT id FROM pedido WHERE idCliente = '" + cliente + "' AND totalProducto='" + total+ "' AND idProducto='" +producto+ "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return id;
    }
}
