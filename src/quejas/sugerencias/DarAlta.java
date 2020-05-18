/*
 * PROYECTO DE PROGRAMACIÓN III
 * ESTUDIANTES:
 * MONTALVO BECERRA JUAN GERARDO - 170441
 * MATA HERNÁNDEZ SEBASTIAN - 170258
 * SEMESTRE 2019-A
 */
package quejas.sugerencias;
//Imports requeridos
import java.awt.Color;
import java.sql.*;
import java.text.*;
import javax.swing.JOptionPane;
import java.util.Date;

public class DarAlta extends javax.swing.JFrame {
    //Declaración de variables
    Connection cn;
    Statement st;
    String cliente, descripcion, direccion, incidencia, usuario;
    int id_direccion;
    int id_descripcion;
    int id_cliente;
    int id_usuario;
    int interior=0;
    String fecha, hora, nombre, ciudad, estado, colonia, descrip;
    public DarAlta(int id_usuario) {
        //Conexión con la base de datos
        this.id_usuario=id_usuario;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        initComponents();
        //Diseño del panel principal
        Panelxd.setBackground(new Color(134, 105, 226, 221));
        //Variable para insertar fecha
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fecha = dateFormat.format(date);
        //Variable para insertar hora
        Date hour = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        hora = format.format(hour);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelxd = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtNombreC = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnDarAlta = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtCalle = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtCP = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtExterior = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtInterior = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescr = new javax.swing.JTextArea();
        boxIncid = new javax.swing.JComboBox<>();
        boxUrge = new javax.swing.JComboBox<>();
        boxPais = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 204, 204));

        Panelxd.setBackground(new java.awt.Color(134, 105, 221));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Incidencia");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Dirección");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Teléfono");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Urgencia");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Edad");

        txtTelefono.setBackground(new java.awt.Color(240, 240, 240));

        txtNombreC.setBackground(new java.awt.Color(240, 240, 240));

        txtEdad.setBackground(new java.awt.Color(240, 240, 240));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Dar de Alta una Incidencia");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Descripción de la incidencia");

        btnDarAlta.setBackground(new java.awt.Color(134, 105, 221));
        btnDarAlta.setText("Dar de alta");
        btnDarAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarAltaActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(134, 105, 221));
        btnLimpiar.setText("Limpiar campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Calle");

        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("Ciudad");

        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("Colonia");

        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("CP");

        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setText("Estado");

        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("Exterior");

        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("Interior");

        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setText("País");

        txtDescr.setColumns(20);
        txtDescr.setRows(5);
        jScrollPane1.setViewportView(txtDescr);

        boxIncid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Queja", "Sugerencia" }));

        boxUrge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En espera", "Urgente" }));

        boxPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentina", "Bolivia", "Brasil", "Chile", "Colombia"
            , "Costa Rica", "Cuba", "Ecuador", "El Salvador", "Guatemala", "Honduras", "México", "Nicarágua", "Panamá", "Paraguay", "Puerto Rico"
            , "Perú", "República Dominicana", "Uruguay", "Venezuela"}));

javax.swing.GroupLayout PanelxdLayout = new javax.swing.GroupLayout(Panelxd);
Panelxd.setLayout(PanelxdLayout);
PanelxdLayout.setHorizontalGroup(
    PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(PanelxdLayout.createSequentialGroup()
        .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelxdLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel5))
            .addGroup(PanelxdLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnDarAlta)
                .addGap(80, 80, 80)
                .addComponent(btnLimpiar))
            .addGroup(PanelxdLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(PanelxdLayout.createSequentialGroup()
                        .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCiudad)
                                .addComponent(txtColonia)
                                .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)))
                .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelxdLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(txtExterior, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(txtInterior)
                            .addComponent(boxPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelxdLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boxIncid, 0, 132, Short.MAX_VALUE)
                            .addComponent(txtNombreC))))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
        .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelxdLayout.createSequentialGroup()
                .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelxdLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelxdLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono)
                    .addComponent(txtEdad)
                    .addComponent(boxUrge, 0, 132, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelxdLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(66, 66, 66))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(62, 62, 62))
    .addGroup(PanelxdLayout.createSequentialGroup()
        .addGap(226, 226, 226)
        .addComponent(jLabel11)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    PanelxdLayout.setVerticalGroup(
        PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(PanelxdLayout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addComponent(jLabel11)
            .addGap(18, 18, 18)
            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelxdLayout.createSequentialGroup()
                    .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(boxUrge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(42, 42, 42)
                    .addComponent(jLabel9)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelxdLayout.createSequentialGroup()
                    .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxIncid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(14, 14, 14)
                    .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelxdLayout.createSequentialGroup()
                            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addGap(18, 18, 18)
                            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGap(18, 18, 18)
                            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addGap(18, 18, 18)
                            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)))
                        .addGroup(PanelxdLayout.createSequentialGroup()
                            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addGap(18, 18, 18)
                            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtExterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17))
                            .addGap(18, 18, 18)
                            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtInterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addGap(18, 18, 18)
                            .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(boxPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(48, 48, 48)
                    .addGroup(PanelxdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDarAlta)
                        .addComponent(btnLimpiar))))
            .addContainerGap(46, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(Panelxd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(Panelxd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //ActionPerformed para limpiar todos los campos
        txtNombreC.setText("");
        txtCP.setText("");
        txtCalle.setText("");
        txtCiudad.setText("");
        txtColonia.setText("");
        txtEstado.setText("");
        txtExterior.setText("");
        txtInterior.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtDescr.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnDarAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarAltaActionPerformed
        //ActionPerformed para dar de alta una queja/sugerencia
        nombre = txtNombreC.getText();
        ciudad = txtCiudad.getText();
        estado = txtEstado.getText();
        colonia = txtColonia.getText();
        descrip = txtDescr.getText();
        String movimiento;
        //Condicional para verificar que todos los campos necesarios estén llenados
        if( !txtNombreC.getText().equals("") &&
            !txtCP.getText().equals("") &&
            !txtCalle.getText().equals("") &&
            !txtCiudad.getText().equals("") &&
            !txtColonia.getText().equals("") &&
            !txtEstado.getText().equals("") &&
            !txtExterior.getText().equals("") &&
            !boxPais.getSelectedItem().toString().equals("") &&
            !txtTelefono.getText().equals("") &&
            !txtDescr.getText().equals(""))
        {
            //Condicional para verificar que la edad esté entre 0 y 100
            if(Integer.parseInt(txtEdad.getText())>=0 && Integer.parseInt(txtEdad.getText())<=100)
            {
                //Condicional para verificar que el teléfono sea de 6 dígitos
                if(txtTelefono.getText().length()==6)
                {
                    if(txtInterior.getText().equals(""))
                    {
                        //Si no se introduce número interior este será igual a 0
                        interior = 0;
                    }
                    else
                    {
                        //Si se introduce número interior este será lo que traiga el textField del teléfono
                        interior = Integer.parseInt(txtInterior.getText());
                    }
                    // try/catch para introducir los datos en la tabla "dirección"
                    try
                    {
                        soloLetras(ciudad);
                        soloLetras(estado);
                        direccion = "INSERT INTO direccion (calle, colonia, interior, exterior, cp, ciudad, estado, pais) VALUES (?,?,?,?,?,?,?,?);";
                        PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                        stmt.setString(1, (txtCalle.getText()));
                        stmt.setString(2, colonia);
                        stmt.setInt(3, interior);
                        stmt.setInt(4, (Integer.parseInt(txtExterior.getText())));
                        stmt.setInt(5, (Integer.parseInt(txtCP.getText())));
                        stmt.setString(6, ciudad);
                        stmt.setString(7, estado);
                        stmt.setString(8, (boxPais.getSelectedItem().toString()));
                        stmt.executeUpdate();
                        ResultSet rs=stmt.getGeneratedKeys();
                        if(rs.next())
                        {
                            id_direccion = rs.getInt(1);
                        }
                        stmt.close();
                    }
                    catch(SQLException ex)
                    {
                        //Excepción para error de SQL
                        System.out.println(ex);
                    }
                    catch(java.lang.NumberFormatException e1)
                    {
                        //Excepción para alguna invalidez de numérica
                        JOptionPane.showMessageDialog(null,"Ingrese solo números (interior/exterior y CP)","ALERTA",2);
                    }
                    catch(MyException e)
                    {
                        //Excepcion para alguna invalidez de caracteres
                        JOptionPane.showMessageDialog(null, "Ingrese solo letras (ciudad y estado)");
                    }
                    catch(NullPointerException e2)
                    {
                        //Excepción para conexión con XAMPP
                        JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
                    }
                    // try/catch para introducir los datos en la tabla "descripcion"
                    try
                    {
                        descripcion = "INSERT INTO descripcion (incidencia, descripcion, estatus) VALUES (?,?,?);";
                        PreparedStatement stmt = cn.prepareStatement(descripcion,Statement.RETURN_GENERATED_KEYS);
                        stmt.setString(1, (boxIncid.getSelectedItem().toString()));
                        stmt.setString(2, descrip);
                        stmt.setString(3, (boxUrge.getSelectedItem().toString()));
                        stmt.executeUpdate();
                        ResultSet rs=stmt.getGeneratedKeys();
                        if(rs.next())
                        {
                            id_descripcion = rs.getInt(1);
                        }
                        stmt.close();
                    }
                    catch(SQLException ex)
                    {
                        //Excepción para error de SQL
                        System.out.println(ex);
                    }
                    catch(NullPointerException e2)
                    {
                        //Excepción para conexión con XAMPP
                        JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
                    }
                    // try/catch para introducir los datos en la tabla "cliente"
                    try
                    {
                        //Se necesita id de direccion
                        soloLetras(nombre);
                        cliente = "INSERT INTO cliente (nombre, id_direccion, edad, telefono) VALUES (?,?,?,?);";
                        PreparedStatement stmt = cn.prepareStatement(cliente,Statement.RETURN_GENERATED_KEYS);
                        stmt.setString(1, nombre);
                        stmt.setInt(2, id_direccion);
                        stmt.setInt(3, (Integer.parseInt(txtEdad.getText())));
                        stmt.setInt(4, (Integer.parseInt(txtTelefono.getText())));
                        stmt.executeUpdate();
                        ResultSet rs=stmt.getGeneratedKeys();
                        if(rs.next())
                        {
                            id_cliente = rs.getInt(1);
                        }
                        stmt.close();
                    }
                    catch(SQLException ex)
                    {
                        //Excepción para error de SQL
                        System.out.println(ex);
                    }
                    catch(java.lang.NumberFormatException e1)
                    {
                        //Excepción para alguna invalidez de numérica
                        JOptionPane.showMessageDialog(null,"Ingrese número (edad y teléfono)","ALERTA",2);
                    }
                    catch(MyException e)
                    {
                        //Excepcion para alguna invalidez de caracteres
                        JOptionPane.showMessageDialog(null, "Ingrese solo letras en el nombre");
                    }
                    catch(NullPointerException e2)
                    {
                        //Excepción para conexión con XAMPP
                        JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
                    }
                    // try/catch para introducir los datos en la tabla "incidencia"
                    try
                    {
                        //cliente, usuario, descripcion
                        incidencia = "INSERT INTO incidencia (fecha, hora, id_cliente,id_usuario,id_descripcion) VALUES (?,?,?,?,?);";
                        PreparedStatement stmt = cn.prepareStatement(incidencia);
                        stmt.setString(1, fecha);
                        stmt.setString(2, hora);
                        stmt.setInt(3, id_cliente);
                        stmt.setInt(4, id_usuario);
                        stmt.setInt(5, id_descripcion);
                        stmt.executeUpdate();
                        stmt.close();
                    }
                    catch(SQLException ex)
                    {
                        //Excepción para error de SQL
                        System.out.println(ex);
                    }
                    catch(java.lang.NumberFormatException e1)
                    {
                        //Excepción para alguna invalidez de numérica
                        JOptionPane.showMessageDialog(null,"Ingrese solo números (incidencia)","ALERTA",2);
                    }
                    catch(NullPointerException e2)
                    {
                        //Excepción para conexión con XAMPP
                        JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
                    }
                    try{
                        movimiento = "INSERT INTO movimiento (id_usuario, tipo, fecha, hora) VALUES (?,?,?,?);";
                        PreparedStatement stmt = cn.prepareStatement(movimiento,Statement.RETURN_GENERATED_KEYS);
                        stmt.setInt(1, id_usuario);
                        stmt.setString(2, "Alta");
                        stmt.setString(3, fecha);
                        stmt.setString(4, hora);
                        stmt.executeUpdate();
                        ResultSet rs=stmt.getGeneratedKeys();
                        stmt.close();
                    }
                    catch(SQLException ex)
                    {
                        //Excepción para SQL
                        System.out.println(ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El teléfono deben ser por lo menos 6 dígitos");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ingrese una edad válida, entre 0 y 100 años");
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos...","ERROR",0);
        }
    }//GEN-LAST:event_btnDarAltaActionPerformed
    public void soloLetras(String cadena) throws MyException{
        //Función para lanzar excepción para validar solo caracteres
        char letra='0';
        for(int i=0; i<cadena.length();i++){
            letra = cadena.charAt(i);
            if(Character.isLetter(letra)){}
            else
            {
                //Excepción propia
                throw new MyException();
            }
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DarAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DarAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DarAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DarAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DarAlta().setVisible(true);
//            }
//        });
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DarAlta().setVisible(true);
//            }
//        });
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DarAlta().setVisible(true);
//            }
//        });
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DarAlta().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panelxd;
    private javax.swing.JComboBox<String> boxIncid;
    private javax.swing.JComboBox<String> boxPais;
    private javax.swing.JComboBox<String> boxUrge;
    private javax.swing.JButton btnDarAlta;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextArea txtDescr;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtExterior;
    private javax.swing.JTextField txtInterior;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
