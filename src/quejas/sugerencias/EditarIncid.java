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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class EditarIncid extends javax.swing.JFrame {
    //Declaración de variables
    private final String titulos2[]=new String[5];    
    private final ArrayList <ArrayList<Object>> incidencia=new ArrayList();
    private int limit2=10;
    private int offset2=0;
    private int id_descripcion, id_dir, id_cliente, interior;
    private String id_direccion="";
    String nombre, ciudad, estado, colonia, description, id, fecha, hora;
    
    public EditarIncid() {
        //Títulos de la tabla de incidencias
        titulos2[0]="ID INCIDENCIA";
        titulos2[1]="FECHA";
        titulos2[2]="HORA";
        titulos2[3]="ID USUARIO";
        titulos2[4]="ESTADO";
        
        initComponents();
        //Variable para insertar fecha
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fecha = dateFormat.format(date);
        //Variable para insertar hora
        Date hour = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        hora = format.format(hour);
        datosTablaIncidencia();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        desc2 = new javax.swing.JTextArea();
        calle2 = new javax.swing.JTextField();
        estado2 = new javax.swing.JTextField();
        ext2 = new javax.swing.JTextField();
        ciudad2 = new javax.swing.JTextField();
        colonia2 = new javax.swing.JTextField();
        cp2 = new javax.swing.JTextField();
        int2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        nombre2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        edad2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tel2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        fecha2 = new javax.swing.JTextField();
        id2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cliente2 = new javax.swing.JTextField();
        hora2 = new javax.swing.JTextField();
        usuario2 = new javax.swing.JTextField();
        descrip = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        boxIncid = new javax.swing.JComboBox<>();
        boxUrge = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        boxEstado = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        boxPais = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int collIndex)
            {
                return false;
            }
        }
        ;
        btnSig2 = new javax.swing.JButton();
        btnAnt2 = new javax.swing.JButton();

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(134, 105, 221));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("INCIDENCIAS");

        desc2.setColumns(20);
        desc2.setRows(5);
        jScrollPane3.setViewportView(desc2);

        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("Interior");

        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("Exterior");

        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setText("Estado");

        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Calle");

        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("Ciudad");

        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("Colonia");

        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("CP");

        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setText("País");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Incidencia");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setText("Urgencia");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        jLabel21.setText("Nombre");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(240, 240, 240));
        jLabel22.setText("Edad");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(240, 240, 240));
        jLabel23.setText("Teléfono");

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("CLIENTE");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("DIRECCIÓN");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("DESCRIPCIÓN");

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("INCIDENCIA");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(240, 240, 240));
        jLabel28.setText("ID");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(240, 240, 240));
        jLabel29.setText("Fecha");

        fecha2.setEditable(false);

        id2.setEditable(false);

        jLabel30.setForeground(new java.awt.Color(240, 240, 240));
        jLabel30.setText("Hora");

        jLabel31.setForeground(new java.awt.Color(240, 240, 240));
        jLabel31.setText("ID Cliente");

        cliente2.setEditable(false);

        hora2.setEditable(false);

        usuario2.setEditable(false);

        descrip.setEditable(false);

        jLabel32.setForeground(new java.awt.Color(240, 240, 240));
        jLabel32.setText("ID Descripción");

        jLabel33.setForeground(new java.awt.Color(240, 240, 240));
        jLabel33.setText("ID Usuario");

        boxIncid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Queja", "Sugerencia" }));

        boxUrge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En espera", "Urgente" }));

        btnActualizar.setText("Guardar Cambios");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "Inactiva" }));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Estado");

        boxPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentina", "Bolivia", "Brasil", "Chile", "Colombia"
            , "Costa Rica", "Cuba", "Ecuador", "El Salvador", "Guatemala", "Honduras", "México", "Nicarágua", "Panamá", "Paraguay", "Puerto Rico"
            , "Perú", "República Dominicana", "Uruguay", "Venezuela" }));

javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
jPanel15.setLayout(jPanel15Layout);
jPanel15Layout.setHorizontalGroup(
    jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel15Layout.createSequentialGroup()
        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel10))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel24))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(edad2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(ciudad2, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(colonia2, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cp2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                    .addComponent(calle2)))
                                            .addComponent(jLabel25))
                                        .addGap(57, 57, 57)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel19))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(estado2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                            .addComponent(ext2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                            .addComponent(int2)
                                            .addComponent(boxPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(hora2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                            .addComponent(cliente2))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel33)
                                            .addComponent(jLabel32))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(usuario2)
                                            .addComponent(descrip, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(11, 11, 11))))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boxEstado, 0, 97, Short.MAX_VALUE)
                            .addComponent(boxIncid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxUrge, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane3)))
        .addGap(22, 22, 22))
    );
    jPanel15Layout.setVerticalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                    .addComponent(jLabel10)
                    .addGap(28, 28, 28))
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel27)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29)
                                .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(estado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ext2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(int2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19)
                                        .addComponent(boxPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21)
                                        .addComponent(nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(edad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23)
                                        .addComponent(tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(42, 42, 42))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(calle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ciudad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(colonia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boxIncid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(boxUrge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34))
                            .addGap(18, 18, 18)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(21, 21, 21))
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(descrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );

    table1.setModel(new javax.swing.table.DefaultTableModel(

    ));
    table1.setRequestFocusEnabled(false);
    table1.setRowHeight(50);
    table1.setSelectionBackground(new java.awt.Color(134, 105, 221));
    table1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            table1MouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(table1);

    btnSig2.setText("SIGUIENTE");
    btnSig2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnSig2MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnSig2MouseExited(evt);
        }
    });
    btnSig2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSig2ActionPerformed(evt);
        }
    });

    btnAnt2.setText("ANTERIOR");
    btnAnt2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnAnt2MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnAnt2MouseExited(evt);
        }
    });
    btnAnt2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAnt2ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(btnAnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnSig2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 37, Short.MAX_VALUE))
                .addComponent(jScrollPane2))
            .addContainerGap())
    );
    jPanel11Layout.setVerticalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSig2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        //MouseClicked para mostrar el contenido de la tabla de incidencia en los campos
        id = String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0));
        //Ciclo para sacar el contenido del arreglo y mostrarlo en la tabla
        for(int x=0;x<incidencia.size();x++)
        {
            //Condicional para verificar que incidencia se seleccionó en la tabla
            if(incidencia.get(x).get(0).equals(id))
            {
                id2.setText(incidencia.get(x).get(0).toString());
                fecha2.setText(incidencia.get(x).get(1).toString());
                hora2.setText(incidencia.get(x).get(2).toString());
                cliente2.setText(incidencia.get(x).get(3).toString());
                usuario2.setText(incidencia.get(x).get(4).toString());
                descrip.setText(incidencia.get(x).get(5).toString());
                
                //Conexión con la base de datos
                Connection cn;
                ConexionBD conected=new ConexionBD();
                cn=conected.conexion();
                // try/catch para sacar los datos de la base de datos
                try
                {
                    PreparedStatement stmt=cn.prepareStatement("SELECT * FROM cliente WHERE id_cliente=?;");
                    stmt.setString(1, (incidencia.get(x).get(3).toString()));
                    ResultSet resultado = stmt.executeQuery();
                    //Sacar datos de la tabla cliente
                    while(resultado.next())
                    {
                        nombre2.setText(resultado.getString("nombre"));
                        edad2.setText(resultado.getString("edad"));
                        tel2.setText(resultado.getString("telefono"));
                        id_direccion=resultado.getString("id_direccion");

                    }
                    stmt=cn.prepareStatement("SELECT * FROM incidencia WHERE id_incidencia=?;");
                    stmt.setString(1, (incidencia.get(x).get(0).toString()));
                    resultado = stmt.executeQuery();
                    //Sacar datos de la tabla incidencia
                    while(resultado.next())
                    {
                        boxEstado.setSelectedItem(resultado.getString("estado"));

                    }
                    stmt=cn.prepareStatement("SELECT * FROM direccion WHERE id_direccion=?;");
                    stmt.setString(1, id_direccion);
                    resultado=stmt.executeQuery();
                    //Sacar datos de la tabla dirección
                    while(resultado.next())
                    {
                        calle2.setText(resultado.getString("calle"));
                        colonia2.setText(resultado.getString("colonia"));
                        int2.setText(resultado.getString("interior"));
                        ext2.setText(resultado.getString("exterior"));
                        cp2.setText(resultado.getString("cp"));
                        ciudad2.setText(resultado.getString("ciudad"));
                        estado2.setText(resultado.getString("estado"));
                        boxPais.setSelectedItem(resultado.getString("pais"));
                    }
                    stmt=cn.prepareStatement("SELECT * FROM descripcion WHERE id_descripcion=?;");
                    stmt.setString(1, (incidencia.get(x).get(5).toString()));
                    resultado = stmt.executeQuery();
                    //Sacar datos de la tabla descripción
                    while(resultado.next())
                    {
                        boxIncid.setSelectedItem(resultado.getString("Incidencia"));
                        boxUrge.setSelectedItem(resultado.getString("estatus"));
                        desc2.setText(resultado.getString("descripcion"));
                    }
                    stmt.close();
                }
                catch(SQLException ex)
                {
                    //Excepción para error de SQL
                    System.out.println(ex);
                }
                catch(java.lang.NullPointerException e2)
                {
                    //Excepción para conexión con XAMPP
                    JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
                }
            }
        }
        incidencia.clear();
        datosTablaIncidencia();
    }//GEN-LAST:event_table1MouseClicked

    private void btnSig2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSig2MouseEntered
        //Diseño de botón Siguiente
        btnSig2.setBackground(Color.white);
        btnSig2.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_btnSig2MouseEntered

    private void btnSig2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSig2MouseExited
        //Diseño de botón Siguiente
        btnSig2.setBackground(new Color(134,105,226));
        btnSig2.setForeground(Color.white);
    }//GEN-LAST:event_btnSig2MouseExited

    private void btnSig2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSig2ActionPerformed
        //ActionPerformed para avanzar en la tabla
        if((contarRowsIncidencia()-offset2)>10)
        {
            offset2+=10;
            incidencia.clear();
            datosTablaIncidencia();
            btnSig2.setEnabled(true);
            btnAnt2.setEnabled(true);
            if((contarRowsIncidencia()-offset2)<=10)
            {
                btnSig2.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnSig2ActionPerformed

    private void btnAnt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnt2MouseEntered
        //Diseño de botón Anterior
        btnAnt2.setBackground(Color.white);
        btnAnt2.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_btnAnt2MouseEntered

    private void btnAnt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnt2MouseExited
        //Diseño de botón Anterior
        btnAnt2.setBackground(new Color(134,105,226));
        btnAnt2.setForeground(Color.white);
    }//GEN-LAST:event_btnAnt2MouseExited

    private void btnAnt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnt2ActionPerformed
        //ActionPerformed para retroceder en la tabla
        if(offset2!=0)
        {
            offset2-=10;
            incidencia.clear();
            datosTablaIncidencia();
            btnSig2.setEnabled(true);
            btnAnt2.setEnabled(true);
            if(offset2==0)
            {
                btnAnt2.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnAnt2ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //ActionPerformed para dar editar una incidencia
        
        //Conexión con la base de datos
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        String direccion, descripcion, cliente, movimiento;
        //Condicional para verificar que alguna incidencia haya sida seleccionada
        if(table1.getSelectedRow()>=0 || table1.getSelectedRow()<=0)
        {
            if(id2.getText().length()!=0)
            {
                id_dir = Integer.parseInt(id_direccion);
                //Mensaje de verificación para editar incidencia
                String editarIncidencia = "¿Está seguro que desea dar de baja la incidencia?\n"
                        + "En caso de que no haya dado de baja la incidencia correcta\n"
                        + "puede modificar el estado de esta en la parte de \n"
                        + "Editar/Consultar incidencia";
                nombre = nombre2.getText();
                ciudad = ciudad2.getText();
                estado = estado2.getText();
                colonia = colonia2.getText();
                description = desc2.getText();
                //Condicional para verificar que el usuario haya presionado "Si", al editar
                if(JOptionPane.showConfirmDialog(null, editarIncidencia)==0)
                {
                    //Condicional para verificar que todos los campos necesarios estén llenados
                    if( !calle2.getText().equals("") &&
                            !nombre2.getText().equals("") &&
                            !edad2.getText().equals("") &&
                            !tel2.getText().equals("") &&
                            !ciudad2.getText().equals("") &&
                            !colonia2.getText().equals("") &&
                            !cp2.getText().equals("") &&
                            !estado2.getText().equals("") &&
                            !desc2.getText().equals(""))
                    {
                        //Condicional para verificar que la edad esté entre 0 y 100
                        if(Integer.parseInt(edad2.getText())>=0 && Integer.parseInt(edad2.getText())<=100)
                        {
                            //Condicional para verificar que el teléfono sea de 6 dígitos
                            if(tel2.getText().length()==6)
                            {
                                if(int2.getText().equals(""))
                                {
                                    //Si no se introduce número interior este será igual a 0
                                    interior = 0;
                                }
                                else
                                {
                                    //Si se introduce número interior este será lo que traiga el textField del teléfono
                                    interior = Integer.parseInt(int2.getText());
                                }
                                // try/catch para actualizar datos en la tabla cliente
                                try
                                {
                                    cliente = "UPDATE cliente SET telefono=? WHERE id_cliente=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(cliente,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setInt(1, Integer.parseInt(tel2.getText()));
                                    stmt.setInt(2, Integer.parseInt(cliente2.getText()));
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
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                catch(java.lang.NumberFormatException e1)
                                {
                                    //Excepción para alguna invalidez numérica
                                    JOptionPane.showMessageDialog(null,"Ingrese solo números (teléfono)","ALERTA",2);
                                }
                                try
                                {
                                    cliente = "UPDATE cliente SET edad=? WHERE id_cliente=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(cliente,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setInt(1, Integer.parseInt(edad2.getText()));
                                    stmt.setInt(2, Integer.parseInt(cliente2.getText()));
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
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                catch(java.lang.NumberFormatException e1)
                                {
                                    //Excepción para alguna invalidez numérica
                                    JOptionPane.showMessageDialog(null,"Ingrese solo números (edad)","ALERTA",2);
                                }

                                try
                                {
                                    soloLetras(nombre);
                                    cliente = "UPDATE cliente SET nombre=? WHERE id_cliente=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(cliente,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, nombre2.getText());
                                    stmt.setInt(2, Integer.parseInt(cliente2.getText()));
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
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                catch(MyException e)
                                {
                                    //Excepción propia
                                    JOptionPane.showMessageDialog(null, "Ingrese solo letras (nombre)");
                                }
                                // try/catch para actualizar datos en la tabla dirección
                                try
                                {
                                    direccion = "UPDATE direccion SET calle=? WHERE id_direccion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, calle2.getText());
                                    stmt.setInt(2, id_dir);
                                    stmt.executeUpdate();
                                    ResultSet rs=stmt.getGeneratedKeys();

                                    if(rs.next())
                                    {
                                        id_dir = rs.getInt(1);
                                    }
                                    stmt.close();
                                }
                                catch(SQLException ex)
                                {
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }

                                try
                                {
                                    soloLetras(ciudad);
                                    direccion = "UPDATE direccion SET ciudad=? WHERE id_direccion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, ciudad2.getText());
                                    stmt.setInt(2, id_dir);
                                    stmt.executeUpdate();
                                    ResultSet rs=stmt.getGeneratedKeys();

                                    if(rs.next())
                                    {
                                        id_dir = rs.getInt(1);
                                    }
                                    stmt.close();
                                }
                                catch(SQLException ex)
                                {
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                catch(MyException e)
                                {
                                    //Excepción propia
                                    JOptionPane.showMessageDialog(null, "Ingrese solo letras (ciudad)");
                                }

                                try
                                {
                                    soloLetras(colonia);
                                    direccion = "UPDATE direccion SET colonia=? WHERE id_direccion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, colonia2.getText());
                                    stmt.setInt(2, id_dir);
                                    stmt.executeUpdate();
                                    ResultSet rs=stmt.getGeneratedKeys();

                                    if(rs.next())
                                    {
                                        id_dir = rs.getInt(1);
                                    }
                                    stmt.close();
                                }
                                catch(SQLException ex)
                                {
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                catch(MyException e)
                                {
                                    //Excepción propia
                                    JOptionPane.showMessageDialog(null, "Ingrese solo letras (colonia)");
                                }

                                try
                                {
                                    direccion = "UPDATE direccion SET cp=? WHERE id_direccion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setInt(1, Integer.parseInt(cp2.getText()));
                                    stmt.setInt(2, id_dir);
                                    stmt.executeUpdate();
                                    ResultSet rs=stmt.getGeneratedKeys();

                                    if(rs.next())
                                    {
                                        id_dir = rs.getInt(1);
                                    }
                                    stmt.close();
                                }
                                catch(SQLException ex)
                                {
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                catch(java.lang.NumberFormatException e1)
                                {
                                    //Excepción para alguna invalidez numérica
                                    JOptionPane.showMessageDialog(null,"Ingrese solo números (CP)","ALERTA",2);
                                }

                                try
                                {
                                    soloLetras(estado);
                                    direccion = "UPDATE direccion SET estado=? WHERE id_direccion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, estado2.getText());
                                    stmt.setInt(2, id_dir);
                                    stmt.executeUpdate();
                                    ResultSet rs=stmt.getGeneratedKeys();

                                    if(rs.next())
                                    {
                                        id_dir = rs.getInt(1);
                                    }
                                    stmt.close();
                                }
                                catch(SQLException ex)
                                {
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                catch(MyException e)
                                {
                                    //Exccepción propia
                                    JOptionPane.showMessageDialog(null, "Ingrese solo letras (estado)");
                                }

                                try
                                {
                                    direccion = "UPDATE direccion SET interior=? WHERE id_direccion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setInt(1, interior);
                                    stmt.setInt(2, id_dir);
                                    stmt.executeUpdate();
                                    ResultSet rs=stmt.getGeneratedKeys();

                                    if(rs.next())
                                    {
                                        id_dir = rs.getInt(1);
                                    }
                                    stmt.close();
                                }
                                catch(SQLException ex)
                                {
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                catch(java.lang.NumberFormatException e1)
                                {
                                    //Excepción para alguna invalidez numérica
                                    JOptionPane.showMessageDialog(null,"Ingrese solo números (interior)","ALERTA",2);
                                }
                                try
                                {
                                    direccion = "UPDATE direccion SET exterior=? WHERE id_direccion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setInt(1, Integer.parseInt(ext2.getText()));
                                    stmt.setInt(2, id_dir);
                                    stmt.executeUpdate();
                                    ResultSet rs=stmt.getGeneratedKeys();

                                    if(rs.next())
                                    {
                                        id_dir = rs.getInt(1);
                                    }
                                    stmt.close();
                                }
                                catch(SQLException ex)
                                {
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                catch(java.lang.NumberFormatException e1)
                                {
                                    //Excepción para alguna invalidez numérica
                                    JOptionPane.showMessageDialog(null,"Ingrese solo números (exterior)","ALERTA",2);
                                }

                                try
                                {
                                    direccion = "UPDATE direccion SET pais=? WHERE id_direccion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, boxPais.getSelectedItem().toString());
                                    stmt.setInt(2, id_dir);
                                    stmt.executeUpdate();
                                    ResultSet rs=stmt.getGeneratedKeys();

                                    if(rs.next())
                                    {
                                        id_dir = rs.getInt(1);
                                    }
                                    stmt.close();
                                }
                                catch(SQLException ex)
                                {
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                // try/catch para actualizar datos en la tabla descripción
                                try
                                {
                                    descripcion = "UPDATE descripcion SET incidencia=? WHERE id_descripcion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(descripcion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, boxIncid.getSelectedItem().toString());
                                    stmt.setInt(2, Integer.parseInt(descrip.getText()));
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
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }

                                try
                                {
                                    descripcion = "UPDATE descripcion SET estatus=? WHERE id_descripcion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(descripcion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, boxUrge.getSelectedItem().toString());
                                    stmt.setInt(2, Integer.parseInt(descrip.getText()));
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
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }

                                try
                                {
                                    descripcion = "UPDATE descripcion SET descripcion=? WHERE id_descripcion=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(descripcion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, desc2.getText());
                                    stmt.setInt(2, Integer.parseInt(descrip.getText()));
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
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                // try/catch para actualizar datos en la tabla incidencia
                                try
                                {
                                    descripcion = "UPDATE incidencia SET estado=? WHERE id_incidencia=? ;";
                                    PreparedStatement stmt = cn.prepareStatement(descripcion,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setString(1, boxEstado.getSelectedItem().toString());
                                    stmt.setInt(2, Integer.parseInt(id2.getText()));
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
                                    //Excepción para SQL
                                    System.out.println(ex);
                                }
                                try{
                                    movimiento = "INSERT INTO movimiento (id_usuario, tipo, fecha, hora) VALUES (?,?,?,?);";
                                    PreparedStatement stmt = cn.prepareStatement(movimiento,Statement.RETURN_GENERATED_KEYS);
                                    stmt.setInt(1, Integer.parseInt(usuario2.getText()));
                                    stmt.setString(2, "Modificacion");
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
                                JOptionPane.showMessageDialog(null, "El teléfono debe ser de 6 números");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "La edad debe ser menor a 100");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
                    }
                }else
                {
                    //Rellena los datos de la tabla de incidencias
                    incidencia.clear();
                    datosTablaIncidencia();
                    limpiar();
                }
            }
            else
            {
                //En caso de que no seleccione niguna incidencia
                JOptionPane.showMessageDialog(null, "Seleccione una incidencia a editar");
            }
        }
        //Rellena los datos de la tabla de incidencias
        incidencia.clear();
        datosTablaIncidencia();
        limpiar();
    }//GEN-LAST:event_btnActualizarActionPerformed
    public void limpiar(){
        //Limpiar campos
        id2.setText("");
        fecha2.setText("");
        hora2.setText("");
        cliente2.setText("");
        usuario2.setText("");
        descrip.setText("");
        nombre2.setText("");
        edad2.setText("");
        tel2.setText("");
        calle2.setText("");
        ciudad2.setText("");
        colonia2.setText("");
        cp2.setText("");
        estado2.setText("");
        ext2.setText("");
        int2.setText("");
        boxPais.setSelectedItem(1);
        boxIncid.setSelectedItem(1);
        boxUrge.setSelectedItem(1);
        boxEstado.setSelectedItem(1);
        desc2.setText("");
    }
    //Llena el arreglo para mostrarlo en la tabla de la GUI
    public void datosTablaIncidencia()
    {
        //Arreglo para la tabla de incidencias
        Object datos1[][]=new Object[10][5];
        int i=0;
        //Conexión con la base de datos
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        
        // try/catch para sacar los datos de la tabla de "incidencia"
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT * FROM incidencia WHERE 1 LIMIT "+limit2+" OFFSET "+offset2);
            ResultSet resultado = stmt.executeQuery();
            //Cilco para sacar todo de la tabla "incidencia"
            while(resultado.next())
            {
                incidencia.add(new ArrayList<>());
                datos1[i][0]=resultado.getString("id_incidencia");
                datos1[i][1]=resultado.getString("fecha");
                datos1[i][2]=resultado.getString("hora");
                datos1[i][3]=resultado.getString("id_usuario");
                datos1[i][4]=resultado.getString("estado");
                
                incidencia.get(i).add(resultado.getString("id_incidencia"));
                incidencia.get(i).add(resultado.getString("fecha"));
                incidencia.get(i).add(resultado.getString("hora"));
                incidencia.get(i).add(resultado.getString("id_cliente"));
                incidencia.get(i).add(resultado.getString("id_usuario"));
                incidencia.get(i).add(resultado.getString("id_descripcion"));
                
                i++;
            }
            table1.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos2));
        }
        catch(SQLException ex)
        {
            //Excepción para SQL
            System.out.println(ex);
        }
        catch(NullPointerException e2)
        {
            //Excepción para conexión con XAMPP
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
    }
    //Contar filas para seguir agregando los registros de la tabla
    public int contarRowsIncidencia()
    {
        int num=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT COUNT(*) AS rowcount FROM incidencia ");
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next())
            {
                num=resultado.getInt("rowcount");
            }
        }
        catch(SQLException ex)
        {
            //Excepción para SQL
            System.out.println(ex);
        }
        catch(java.lang.NullPointerException e2)
        {
            //Excepción para conexión con XAMPP
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
        return num;
    }
    public void soloLetras(String cadena) throws MyException{
        char letra='0';
        for(int i=0; i<cadena.length();i++){
            letra = cadena.charAt(i);
            if(Character.isLetter(letra)){}
            else
            {
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
            java.util.logging.Logger.getLogger(EditarIncid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarIncid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarIncid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarIncid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarIncid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JComboBox<String> boxIncid;
    private javax.swing.JComboBox<String> boxPais;
    private javax.swing.JComboBox<String> boxUrge;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAnt2;
    private javax.swing.JButton btnSig2;
    private javax.swing.JTextField calle2;
    private javax.swing.JTextField ciudad2;
    private javax.swing.JTextField cliente2;
    private javax.swing.JTextField colonia2;
    private javax.swing.JTextField cp2;
    private javax.swing.JTextArea desc2;
    private javax.swing.JTextField descrip;
    private javax.swing.JTextField edad2;
    private javax.swing.JTextField estado2;
    private javax.swing.JTextField ext2;
    private javax.swing.JTextField fecha2;
    private javax.swing.JTextField hora2;
    private javax.swing.JTextField id2;
    private javax.swing.JTextField int2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nombre2;
    private javax.swing.JTable table1;
    private javax.swing.JTextField tel2;
    private javax.swing.JTextField usuario2;
    // End of variables declaration//GEN-END:variables
}
