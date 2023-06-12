/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Pedido;

/**
 *
 * @author Usuario
 */
public class Ctrl_Carrito {

    public int obtenerIdCarrito(int cliente) {
        int id = 0;
        String sql = " select max(id) from carrito where idCliente=" + cliente + ";";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("max(id)");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener id carrito: " + e);
        }
        return id;
    }

    public boolean eliminar(int idCarrito) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from carrito where id='" + idCarrito + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar Carrito: " + e);
        }
        return respuesta;
    }
    public boolean insertarCarrito(int idCliente, double total, String fecha, int estado, int cant) {
        boolean respuesta = false;
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO carrito (idCliente, totalCompra, estado,fecha, cant) VALUES(?,?,?,?,?)");
            consulta.setInt(1, idCliente);
            consulta.setDouble(2, total);
            consulta.setInt(3, estado);
            consulta.setString(4, fecha);
            consulta.setInt(5, cant);
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar EN EL CARRITO: " + e);
        }

        return respuesta;
    }

}
