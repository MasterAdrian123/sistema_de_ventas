package vista;

import conexion.Conexion;
import controlador.Ctrl_Carrito;
import controlador.Ctrl_Pedidos;
//import controlador.VentaPDF;
import controlador.Ctrl_Producto;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Carrito;
import modelo.Pedido;

public class InterFacturacion extends javax.swing.JInternalFrame {

    //Modelo de los datos
    private DefaultTableModel modeloDatosProductos;
    //lista para el detalle de venta de los productos
    ArrayList<Pedido> listaProductos = new ArrayList<>();
    private Pedido producto;

    private int idCliente = 0;//id del cliente sleccionado

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIva = 0;

    private int cantidad = 0;//cantidad de productos a comprar
    private double subtotal = 0.0;//cantidad por precio
    private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    //variables para calculos globales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double ivaGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    //fin de variables de calculos globales

    private int idCarrito = 0;

    private int auxIdDetalle = 1;//id del detalle de venta

    public InterFacturacion() {
        initComponents();
        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturacion");

        //Cargar lo Clientes en la vista - cargar productos
        //this.CargarComboClientes();        
        this.CargarComboProductos();

        this.inicializarTablaProducto();

        txt_efectivo.setEnabled(false);
        jButton_calcular_cambio.setEnabled(false);

        txt_subtotal.setText("0.0");
        txt_iva.setText("0.0");
        txt_descuento.setText("0.0");
        txt_total_pagar.setText("0.0");

        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
    }

    //metodo para inicializar la tabla de los productos
    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel();
        //añadir columnas
        modeloDatosProductos.addColumn("No. pedido");
        //modeloDatosProductos.addColumn("N");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("SubTotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Iva");
        modeloDatosProductos.addColumn("Total Pagar");
        modeloDatosProductos.addColumn("Accion");
        //agregar los datos del modelo a la tabla
        this.jTable_productos.setModel(modeloDatosProductos);
    }

    //metodo para presentar la informacion de la tavla DetalleVenta
    private void listaTablaProductos() {

        //this.modeloDatosProductos.setRowCount(listaProductos.size() - 1);
        int contadorPedido = 1;
        Ctrl_Producto pp = new Ctrl_Producto();
        //Pedido pedido;
        for (Pedido pedido : listaProductos) {
            //pedido = listaProductos.get(j);
            Object fila[] = new Object[9];
            for (int i = 0; i < 9; i++) {
                switch (i) {
                    case 0:
                        fila[i] = contadorPedido;
                        contadorPedido += 1;
                        break;
                    case 8:
                        fila[8] = "Eliminar";
                        break;
                    case 1:
                        fila[1] = pp.nombreProducto(pedido.getIdProducto());
                        break;
                    case 2:
                        fila[2] = pedido.getCantidad();
                        break;
                    case 3:
                        fila[3] = pedido.getPrecioUnitario();
                        break;
                    case 4:
                        fila[4] = pedido.getSubTotal();
                        break;
                    case 5:
                        fila[5] = pedido.getDescuento();
                        break;
                    case 6:
                        fila[6] = pedido.getIva();
                        break;
                    case 7:
                        fila[7] = pedido.getTotalPagar();
                        break;
                }
            }
            this.modeloDatosProductos.addRow(fila);
        }

        jTable_productos.setModel(modeloDatosProductos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jComboBox_producto = new javax.swing.JComboBox<>();
        txt_cliente_buscar = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jButton_busca_cliente = new javax.swing.JButton();
        jButton_añadir_producto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton_calcular_cambio = new javax.swing.JButton();
        jButton_RegistrarVenta = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturación");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 80, -1));

        jComboBox_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 170, -1));

        jComboBox_producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        txt_cliente_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cliente_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 150, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 60, -1));

        jButton_busca_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_cliente.setText("Buscar");
        jButton_busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_busca_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 80, -1));

        jButton_añadir_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_añadir_producto.setText("Añadir Productos");
        jButton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_añadir_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 150, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Iva:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_subtotal.setEnabled(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_iva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_iva.setEnabled(false);
        jPanel2.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));

        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        jButton_calcular_cambio.setBackground(new java.awt.Color(51, 255, 255));
        jButton_calcular_cambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_calcular_cambio.setText("Calcular Cambio");
        jButton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcular_cambioActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcular_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 380, 210));

        jButton_RegistrarVenta.setBackground(new java.awt.Color(51, 255, 255));
        jButton_RegistrarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_RegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito.png"))); // NOI18N
        jButton_RegistrarVenta.setText("AGREGAR AL CARRITO");
        jButton_RegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 170, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_clienteActionPerformed
//        if(!txt_cliente_buscar.isEnabled()){
//            String clienteBuscar = jComboBox_cliente.getItemAt(WIDTH);
//            Connection cn = Conexion.conectar();
//            String sql = "select nombre, p_apellido from cliente where cedula = '" + clienteBuscar + "'";
//            Statement st;
//            try {
//                st = cn.createStatement();
//                ResultSet rs = st.executeQuery(sql);
//
//                if (rs.next()) {
//                    jComboBox_cliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
//                } else {
//                    jComboBox_cliente.setSelectedItem("Seleccione cliente:");
//                    JOptionPane.showMessageDialog(null, "¡Cedula de cliente incorrecta o no encontrada!");
//                }
//                txt_cliente_buscar.setText("");
//                cn.close();
//            } catch (SQLException e) {
//                System.out.println("¡Error al buscar cliente!, " + e);
//            }
//        }else{
        JOptionPane.showMessageDialog(null, "ya existe un cliente agregado");
//        }
    }//GEN-LAST:event_jButton_busca_clienteActionPerformed

    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed
        Ctrl_Pedidos ctrlP = new Ctrl_Pedidos();
        Ctrl_Carrito Cc = new Ctrl_Carrito();
        this.ObtenerIdCliente();
        idCarrito = Cc.obtenerIdCarrito(idCliente) + 1;

        String combo = this.jComboBox_producto.getSelectedItem().toString();
        //validar que seleccione un producto
        if (combo.equalsIgnoreCase("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            //validar que ingrese una cantidad
            if (!txt_cantidad.getText().isEmpty()) {
                //validar que el usuario no ingrese caracteres no numericos
                boolean validacion = validar(txt_cantidad.getText());
                if (validacion) {
                    //validar que la cantidad sea mayor a cero
                    if (Integer.parseInt(txt_cantidad.getText()) > 0 && Integer.parseInt(txt_cantidad.getText()) < 21) {
                        cantidad = Integer.parseInt(txt_cantidad.getText());
                        //ejecutar metodo para obtener datos del producto
                        this.DatosDelProducto();
                        //validar que la cantidad de productos seleccionado no sea mayor al stock de la base de datos
                        if (cantidad <= cantidadProductoBBDD) {

                            subtotal = precioUnitario * cantidad;
                            totalPagar = subtotal + iva + descuento;

                            //redondear decimales
                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            iva = (double) Math.round(iva * 100) / 100;
                            descuento = (double) Math.round(descuento * 100) / 100;
                            totalPagar = (double) Math.round(totalPagar * 100) / 100;

                            //se crea un nuevo producto
                            producto = new Pedido(
                                    idCliente, //idCabecera
                                    idProducto,
                                    Integer.parseInt(txt_cantidad.getText()),
                                    precioUnitario,
                                    subtotal,
                                    descuento,
                                    iva,
                                    totalPagar,
                                    1,//estado por PAGAR // 2 = PAGADO
                                    idCarrito
                            );
                            //añadir a la lista
                            //if (ctrlP.guardar(producto)) {
                            listaProductos.add(producto);
                            JOptionPane.showMessageDialog(null, "Producto Agregado");
                            auxIdDetalle++;
                            txt_cantidad.setText("");//limpiar el campo
                            //volver a cargar combo productos
                            this.CargarComboProductos();
                            //this.cargarListaProductos();
                            this.CalcularTotalPagar();
                            this.inicializarTablaProducto();
                            txt_efectivo.setEnabled(true);
                            jButton_calcular_cambio.setEnabled(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad supera el Stock");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero (0), ni negativa\n puede solicitar maximo 20 unidades");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numericos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa la cantidad de productos");
            }
        }
        //llamar al metodo
        this.listaTablaProductos();
    }//GEN-LAST:event_jButton_añadir_productoActionPerformed

    private void cargarListaProductos() {
        Connection con = Conexion.conectar();
        Statement st;
        String sql = " select p.idProducto, "
                + "p.cantidad, "
                + "p.precio, "
                + "p.subtotal, "
                + "p.descuento, "
                + "p.iva, "
                + "p.totalProducto, "
                + "p.estado from pedido as p, cliente as c "
                + "where p.idCliente = " + idCliente + " AND p.estado = 1;";
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //int contadorPedido = 1;
            Pedido consulta = new Pedido();
            consulta.setIdCliente(idCliente);
            while (rs.next()) {
                consulta.setIdProducto(rs.getInt("idProducto"));
                consulta.setCantidad(rs.getInt("cantidad"));
                consulta.setPrecioUnitario(rs.getInt("precio"));
                consulta.setDescuento(rs.getInt("descuento"));
                consulta.setIva(rs.getInt("iva"));
                consulta.setTotalPagar(rs.getInt("totalProducto"));
                consulta.setEstado(rs.getInt("estado"));
                consulta.setSubTotal(rs.getInt("subtotal"));

                listaProductos.add(consulta);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla PEDIDOS: " + e);
        }
    }

    private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcular_cambioActionPerformed
        if (!txt_efectivo.getText().isEmpty()) {
            //validamos que el usuario no ingrese otros caracteres no numericos 
            boolean validacion = validarDouble(txt_efectivo.getText());
            if (validacion == true) {
                //validar que el efectivo sea mayor a cero
                double efc = Double.parseDouble(txt_efectivo.getText().trim());
                double top = Double.parseDouble(txt_total_pagar.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El Dinero en efectivo no es suficiente");
                } else {
                    double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    txt_cambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No de admiten caracteres no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }
    }//GEN-LAST:event_jButton_calcular_cambioActionPerformed
    int idArrayList = 0;
    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        int fila_point = jTable_productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?");
        //opciones de confir dialog - (si = 0; no = 1; cancel = 2; close = -1)
        switch (opcion) {
            case 0: //presione si
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.inicializarTablaProducto();
                this.listaTablaProductos();
                break;
            case 1: //presione no
                break;
            default://sea que presione cancel (2) o close (-1)
                break;
        }
    }//GEN-LAST:event_jTable_productosMouseClicked

    private int extraerIdPedido(Pedido pedido) {
        int resultado = 0;
        Ctrl_Pedidos ctrl = new Ctrl_Pedidos();
        int validar = ctrl.obtenerIdPedido(pedido);
        if (validar == 0) {
            JOptionPane.showMessageDialog(null, "ID de PEDIDO ES 0");
        } else {
            resultado = validar;
        }
        return resultado;
    }
    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed

        Ctrl_Pedidos controlPedido = new Ctrl_Pedidos();
        Ctrl_Carrito carrito = new Ctrl_Carrito();
        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);

        if (!jComboBox_cliente.getSelectedItem().equals("Seleccione cliente:")) {
            if (listaProductos.size() > 0) {
 //               try {
                    double pago = totalPagarGeneral;
                    int tamaño = listaProductos.size();
                    int cliente = idCliente; 
                    if (carrito.insertarCarrito(cliente,pago , fechaActual, 1, tamaño )) {
                        JOptionPane.showMessageDialog(null, "CARRITO CREADO");
                        txt_subtotal.setText("0.0");
                        txt_iva.setText("0.0");
                        txt_descuento.setText("0.0");
                        txt_total_pagar.setText("0.0");
                        txt_efectivo.setText("");
                        txt_cambio.setText("0.0");
                        auxIdDetalle = 1;

                        //this.CargarComboClientes(txt_cliente_buscar.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "error al agregar al carrito");
                    }
 //               } catch (SQLException e) {
//                    System.out.println("Error al crear carrito btn guardar carrito: " + e);
//                }

                int contador = 0;
                for (Pedido pedidox : listaProductos) {
                    if (controlPedido.guardar(pedidox)) {
                        contador += 1;
                        JOptionPane.showMessageDialog(null, "se agrego " + contador + " producto");
                        this.RestarStockProductos(pedidox.getIdProducto(), pedidox.getCantidad());
                    }

                    System.out.println("Producto agregado : " + contador);
                }
                listaProductos.clear();
                inicializarTablaProducto();
                listaTablaProductos();
            } else {
                JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
        }
        JOptionPane.showMessageDialog(null, "ir a la ventana visualizar pedidos");
    }//GEN-LAST:event_jButton_RegistrarVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_RegistrarVenta;
    private javax.swing.JButton jButton_añadir_producto;
    private javax.swing.JButton jButton_busca_cliente;
    private javax.swing.JButton jButton_calcular_cambio;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    public javax.swing.JTextField txt_cliente_buscar;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables


    /*
    Metodo para cargar los clientes en el jComboBox
     */
    public void CargarComboClientes(String cedula) {
        Connection cn = Conexion.conectar();
        String sql = "select * from cliente WHERE cedula='" + cedula + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_cliente.removeAllItems();
            //jComboBox_cliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                jComboBox_cliente.addItem(rs.getString("nombre") + " " + rs.getString("p_apellido"));
                jComboBox_cliente.addItem(rs.getString("cedula"));
            }
            txt_cliente_buscar.setText((String) jComboBox_cliente.getItemAt(1));
            jComboBox_cliente.setEnabled(false);
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar clientes, !" + e);
        }
    }

    /*
    Metodo para cargar los productos en el jComboBox
     */
    private void CargarComboProductos() {
        Connection cn = Conexion.conectar();
        String sql = "select * from producto";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar productos, !" + e);
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para mostrar los datos del producto seleccionado
     */
    private void DatosDelProducto() {
        try {
            String sql = "select cod_producto, nombre, stock, precio_venta, iva from producto where nombre = '" + this.jComboBox_producto.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("cod_producto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("stock");
                precioUnitario = rs.getDouble("precio_venta");
                porcentajeIva = rs.getInt("iva");
                this.CalcularIva(precioUnitario, porcentajeIva);//calcula y retorna el iva
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto, " + e);
        }
    }

    /*
        Metodo para calcular iva
     */
    private double CalcularIva(double precio, int porcentajeIva) {
        int p_iva = porcentajeIva;

        switch (p_iva) {
            case 0:
                iva = 0.0;
                break;
            case 12:
                iva = (precio * cantidad) * 0.12;
                break;
            case 14:
                iva = (precio * cantidad) * 0.14;
                break;
            default:
                break;
        }

        return iva;
    }

    /*
    Metodo para calcular el total a pagar de todos los productos agregados
     */
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        ivaGeneral = 0;
        totalPagarGeneral = 0;

        for (Pedido elemento : listaProductos) {
            subtotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            ivaGeneral += elemento.getIva();
            totalPagarGeneral += elemento.getTotalPagar();
        }
        //redondear decimales
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        ivaGeneral = (double) Math.round(ivaGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        //enviar datos a la vista
        txt_subtotal.setText(String.valueOf(subtotalGeneral));
        txt_iva.setText(String.valueOf(ivaGeneral));
        txt_descuento.setText(String.valueOf(descuentoGeneral));
        txt_total_pagar.setText(String.valueOf(totalPagarGeneral));
    }

    /*
    Metodo para obtener id del cliente
     */
    private void ObtenerIdCliente() {
        try {
            String sql = "select id from cliente where concat(nombre,' ',p_apellido) = '" + this.jComboBox_cliente.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente, " + e);
        }
    }

    //metodo para restar la cantidad (stock) de los productos vendidos
    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBaseDeDatos = 0;
        try {
            Connection cn = Conexion.conectar();
            String sql = "select stock from producto where cod_producto = '" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosBaseDeDatos = rs.getInt("stock");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1, " + e);
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement consulta = cn.prepareStatement("update producto set stock=? where cod_producto = '" + idProducto + "'");
            int cantidadNueva = cantidadProductosBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            consulta.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2, " + e);
        }
    }
}
