package controlador;

import conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author Edison Zambrano - © Programador Fantasma
 */
public class Ctrl_Usuario {
    
    
    /**
     * **************************************************
     * metodo para guardar un nuevo usuario
     * **************************************************
     */
    public boolean guardar(Usuario objeto, boolean tipo) {
        boolean respuesta = false;
        
        String sql = "";
        
        Connection cn = Conexion.conectar();
        try {
            if(tipo){
                sql ="INSERT INTO administrador(nombre,apellido,cedula,telefono,direccion,clave) VALUES(?,?,?,?,?,?)";
            }else{
                sql ="INSERT INTO cliente(nombre,p_apellido,cedula,telefono,direccion,clave) VALUES(?,?,?,?,?,?)";
            }
                PreparedStatement consulta = cn.prepareStatement(sql);
            //consulta.setInt(1, 0);//id
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCedula());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setString(6, objeto.getContraseña());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
        }
        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si el producto ya esta registrado en la BBDD
     * ********************************************************************
     */
    public boolean existeUsuario(String cedula) {
        boolean respuesta = false;
        String sql = "SELECT id FROM Usuario WHERE cedula = '" + cedula + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para Iniciar Sesion
     * **************************************************
     * @param objeto
     * @param tipo
     * @return 
     */
    public boolean loginUser(Usuario objeto, boolean tipo) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql;
        
        if(tipo){
            sql = "SELECT  cedula, clave FROM administrador Where cedula = '" + objeto.getCedula() + "' AND clave = '" + objeto.getContraseña() + "';";
        }else{
            sql = "SELECT  cedula, clave FROM cliente Where cedula = '" + objeto.getCedula() + "' AND clave = '" + objeto.getContraseña() + "';";
        }
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }
        return respuesta;
        
    }
    
    /**
     * **************************************************
     * metodo para actualizar un usuario
     * **************************************************
     * @param objeto
     * @param id
     * @param tipo
     * @return 
     */
    public boolean actualizar(Usuario objeto, int id, boolean tipo) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        PreparedStatement consulta;
        try {
            if(tipo){
                consulta = cn.prepareStatement("UPDATE administrador SET nombre=?, apellido = ?, cedula = ?, clave= ?, telefono = ?, direccion = ? where id ='" + id + "'");
            }else{
                consulta = cn.prepareStatement("UPDATE cliente SET nombre=?, p_apellido = ?, cedula = ?, clave= ?, telefono = ?, direccion = ? where id ='" + id + "'");
            }
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCedula());
            consulta.setString(4, objeto.getContraseña());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para eliminar un usuario
     * **************************************************
     * @param id
     * @param tipo
     * @return 
     */
    public boolean eliminar(int id, boolean tipo) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            String sql;
            if(tipo){
                sql = "DELETE FROM administrador WHERE id='" + id + "'";
            }else{
                sql = "DELETE FROM cliente WHERE id='" + id + "'";
            }
            PreparedStatement consulta = cn.prepareStatement(sql);
            //consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
        return respuesta;
    }
}
