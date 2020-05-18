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
import java.awt.Dimension;
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

public class DarBaja extends javax.swing.JFrame {
    //Declaración de variables
    private final String titulos2[]=new String[5];    
    private final ArrayList <ArrayList<Object>> incidencia=new ArrayList();
    private int limit2=10;
    private int offset2=0;
    int id_descripcion;
    int id_incidencia;
    String fecha, hora;
    public DarBaja() {
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
        //Llenado del arreglo para la tabla de incidencias
        datosTablaIncidencia();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        desc6 = new javax.swing.JTextArea();
        calle6 = new javax.swing.JTextField();
        estado6 = new javax.swing.JTextField();
        ext6 = new javax.swing.JTextField();
        ciudad6 = new javax.swing.JTextField();
        colonia6 = new javax.swing.JTextField();
        cp6 = new javax.swing.JTextField();
        pais6 = new javax.swing.JTextField();
        int6 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        incidencia6 = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        urgen6 = new javax.swing.JTextField();
        nombre6 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        edad6 = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        tel6 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        fecha6 = new javax.swing.JTextField();
        id6 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        cliente6 = new javax.swing.JTextField();
        hora6 = new javax.swing.JTextField();
        usuario6 = new javax.swing.JTextField();
        descrip4 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        btnDarBaja = new javax.swing.JButton();
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

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jPanel19.setBackground(new java.awt.Color(134, 105, 221));

        jLabel106.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setText("INCIDENCIAS");

        desc6.setEditable(false);
        desc6.setColumns(20);
        desc6.setRows(5);
        jScrollPane7.setViewportView(desc6);

        calle6.setEditable(false);

        estado6.setEditable(false);

        ext6.setEditable(false);

        ciudad6.setEditable(false);

        colonia6.setEditable(false);

        cp6.setEditable(false);

        pais6.setEditable(false);

        int6.setEditable(false);

        jLabel107.setForeground(new java.awt.Color(240, 240, 240));
        jLabel107.setText("Interior");

        jLabel108.setForeground(new java.awt.Color(240, 240, 240));
        jLabel108.setText("Exterior");

        jLabel109.setForeground(new java.awt.Color(240, 240, 240));
        jLabel109.setText("Estado");

        jLabel110.setForeground(new java.awt.Color(240, 240, 240));
        jLabel110.setText("Calle");

        jLabel111.setForeground(new java.awt.Color(240, 240, 240));
        jLabel111.setText("Ciudad");

        jLabel112.setForeground(new java.awt.Color(240, 240, 240));
        jLabel112.setText("Colonia");

        jLabel113.setForeground(new java.awt.Color(240, 240, 240));
        jLabel113.setText("CP");

        jLabel114.setForeground(new java.awt.Color(240, 240, 240));
        jLabel114.setText("País");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(240, 240, 240));
        jLabel115.setText("Incidencia");

        incidencia6.setEditable(false);

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(240, 240, 240));
        jLabel116.setText("Urgencia");

        urgen6.setEditable(false);

        nombre6.setEditable(false);

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(240, 240, 240));
        jLabel117.setText("Nombre");

        edad6.setEditable(false);

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(240, 240, 240));
        jLabel118.setText("Edad");

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(240, 240, 240));
        jLabel119.setText("Teléfono");

        tel6.setEditable(false);

        jLabel120.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setText("CLIENTE");

        jLabel121.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setText("DIRECCIÓN");

        jLabel122.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setText("DESCRIPCIÓN");

        jLabel123.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setText("INCIDENCIA");

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(240, 240, 240));
        jLabel124.setText("ID");

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(240, 240, 240));
        jLabel125.setText("Fecha");

        fecha6.setEditable(false);

        id6.setEditable(false);

        jLabel126.setForeground(new java.awt.Color(240, 240, 240));
        jLabel126.setText("Hora");

        jLabel127.setForeground(new java.awt.Color(240, 240, 240));
        jLabel127.setText("ID Cliente");

        cliente6.setEditable(false);

        hora6.setEditable(false);

        usuario6.setEditable(false);

        descrip4.setEditable(false);

        jLabel128.setForeground(new java.awt.Color(240, 240, 240));
        jLabel128.setText("ID Descripción");

        jLabel129.setForeground(new java.awt.Color(240, 240, 240));
        jLabel129.setText("ID Usuario");

        btnDarBaja.setText("Dar Baja");
        btnDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel123)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel106))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel115)
                                        .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(incidencia6)
                                        .addComponent(urgen6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(35, 35, 35)
                            .addComponent(jScrollPane7))
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel122)
                                        .addComponent(jLabel120))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel19Layout.createSequentialGroup()
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel125, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel124, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel19Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(fecha6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(id6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel19Layout.createSequentialGroup()
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel119, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel117, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel19Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(edad6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tel6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(nombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel112)
                                                .addGroup(jPanel19Layout.createSequentialGroup()
                                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel113, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel110, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(ciudad6, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(colonia6, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cp6, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                        .addComponent(calle6)))
                                                .addComponent(jLabel121))
                                            .addGap(57, 57, 57)
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel109)
                                                .addComponent(jLabel108)
                                                .addComponent(jLabel107)
                                                .addComponent(jLabel114))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(estado6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ext6)
                                                    .addComponent(int6)
                                                    .addComponent(pais6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel126, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(hora6, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                                .addComponent(cliente6))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel129)
                                                .addComponent(jLabel128))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(usuario6)
                                                .addComponent(descrip4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGap(11, 11, 11))))
                .addGap(22, 22, 22))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel106)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel123)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel124)
                                    .addComponent(id6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel125)
                                    .addComponent(fecha6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hora6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel126))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cliente6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel127))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel120)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(estado6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel109))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ext6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel108))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(int6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel107))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(pais6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel114)))
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel117)
                                            .addComponent(nombre6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel118)
                                            .addComponent(edad6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel119)
                                            .addComponent(tel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel121)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calle6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel110))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ciudad6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel111))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(colonia6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel112))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel113))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jLabel122)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(incidencia6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(urgen6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel116))
                                .addGap(33, 33, 33)
                                .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuario6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel129))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descrip4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel128))
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

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSig2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSig2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        //MouseClicked para mostrar el contenido de la tabla de incidencia en los campos
        String id = String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0));
        //Ciclo para sacar el contenido del arreglo y mostrarlo en la tabla
        for(int x=0;x<incidencia.size();x++)
        {
            //Condicional para verificar que incidencia se seleccionó en la tabla
            if(incidencia.get(x).get(0).equals(id))
            {
                id6.setText(incidencia.get(x).get(0).toString());
                fecha6.setText(incidencia.get(x).get(1).toString());
                hora6.setText(incidencia.get(x).get(2).toString());
                cliente6.setText(incidencia.get(x).get(3).toString());
                usuario6.setText(incidencia.get(x).get(4).toString());
                descrip4.setText(incidencia.get(x).get(5).toString());
                
                //Conexión con la base de datos
                Connection cn;
                ConexionBD conected=new ConexionBD();
                cn=conected.conexion();
                String id_direccion="";
                // try/catch para sacar los datos de la base de datos
                try
                {
                    PreparedStatement stmt=cn.prepareStatement("SELECT * FROM cliente WHERE id_cliente=?;");
                    stmt.setString(1, (incidencia.get(x).get(3).toString()));
                    ResultSet resultado = stmt.executeQuery();
                    //Sacar datos de la tabla cliente
                    while(resultado.next())
                    {
                        nombre6.setText(resultado.getString("nombre"));
                        edad6.setText(resultado.getString("edad"));
                        tel6.setText(resultado.getString("telefono"));
                        id_direccion=resultado.getString("id_direccion");

                    }
                    stmt=cn.prepareStatement("SELECT * FROM direccion WHERE id_direccion=?;");
                    stmt.setString(1, id_direccion);
                    resultado=stmt.executeQuery();
                    //Sacar datos de la tabla dirección
                    while(resultado.next())
                    {
                        calle6.setText(resultado.getString("calle"));
                        colonia6.setText(resultado.getString("colonia"));
                        int6.setText(resultado.getString("interior"));
                        ext6.setText(resultado.getString("exterior"));
                        cp6.setText(resultado.getString("cp"));
                        ciudad6.setText(resultado.getString("ciudad"));
                        estado6.setText(resultado.getString("estado"));
                        pais6.setText(resultado.getString("pais"));
                    }
                    stmt=cn.prepareStatement("SELECT * FROM descripcion WHERE id_descripcion=?;");
                    stmt.setString(1, (incidencia.get(x).get(5).toString()));
                    resultado = stmt.executeQuery();
                    //Sacar datos de la tabla descripción
                    while(resultado.next())
                    {
                        incidencia6.setText(resultado.getString("Incidencia"));
                        urgen6.setText(resultado.getString("estatus"));
                        desc6.setText(resultado.getString("descripcion"));
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

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed
        //ActionPerformed para dar de baja incidencia
        
        //Conexión con la base de datos
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        String descripcion, movimiento;
        //Condicional para verificar que alguna incidencia haya sida seleccionada
        if(table1.getSelectedRow()>=0 || table1.getSelectedRow()<=0)
        {
            //Mensaje de verificación para dar de baja
            String darBaja = "¿Está seguro que desea dar de baja la incidencia?\n"
                    + "En caso de que no haya dado de baja la incidencia correcta\n"
                    + "puede modificar el estado de esta en la parte de \n"
                    + "Editar/Consultar incidencia";
            if(id6.getText().length()!=0)
            {
                //Condicional para verificar que el usuario haya presionado "Si", al dar de baja
                if(JOptionPane.showConfirmDialog(null, darBaja)==0)
                {
                    // try/catch para modificar la columna "estado" a "Inactiva"
                    try
                    {
                        descripcion = "UPDATE incidencia SET estado=? WHERE id_incidencia=?;";
                        PreparedStatement stmt = cn.prepareStatement(descripcion,Statement.RETURN_GENERATED_KEYS);
                        stmt.setString(1, ("Inactiva"));
                        stmt.setInt(2, Integer.parseInt(id6.getText()));
                        stmt.executeUpdate();
                        ResultSet rs=stmt.getGeneratedKeys();
                        if(rs.next())
                        {
                            id_incidencia = rs.getInt(1);
                        }
                        stmt.close();
                    }
                    catch(SQLException ex)
                    {
                        //Excepción para error de SQL
                        System.out.println(ex);
                    }
                    catch(NullPointerException e1)
                    {
                        //Excepción para verificar que haya seleccionado una incidencia
                        JOptionPane.showMessageDialog(null,"Seleccione alguna incidencia","ATENCIÓN",2);
                    }
                    try{
                        movimiento = "INSERT INTO movimiento (id_usuario, tipo, fecha, hora) VALUES (?,?,?,?);";
                        PreparedStatement stmt = cn.prepareStatement(movimiento,Statement.RETURN_GENERATED_KEYS);
                        stmt.setInt(1, Integer.parseInt(usuario6.getText()));
                        stmt.setString(2, "Baja");
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
                else{
                    //Vuelve a llenar el arreglo de las incidencias para la tabla
                    incidencia.clear();
                    datosTablaIncidencia();
                    //Limpiar campos
                    id6.setText("");
                    fecha6.setText("");
                    hora6.setText("");
                    cliente6.setText("");
                    usuario6.setText("");
                    descrip4.setText("");
                    calle6.setText("");
                    nombre6.setText("");
                    edad6.setText("");
                    tel6.setText("");
                    ciudad6.setText("");
                    colonia6.setText("");
                    cp6.setText("");
                    estado6.setText("");
                    int6.setText("");
                    ext6.setText("");
                    pais6.setText("");
                    incidencia6.setText("");
                    urgen6.setText("");
                    desc6.setText("");
                }
            }
            else
            {
                //En caso de no haber seleccionado una incidencia
                //Manda el siguiente mensaje
                JOptionPane.showMessageDialog(null, "Seleccione una incidencia a editar");
            }
        }
        //Vuelve a llenar el arreglo de las incidencias para la tabla
        incidencia.clear();
        datosTablaIncidencia();
        //Limpiar campos
        id6.setText("");
        fecha6.setText("");
        hora6.setText("");
        cliente6.setText("");
        usuario6.setText("");
        descrip4.setText("");
        calle6.setText("");
        nombre6.setText("");
        edad6.setText("");
        tel6.setText("");
        ciudad6.setText("");
        colonia6.setText("");
        cp6.setText("");
        estado6.setText("");
        int6.setText("");
        ext6.setText("");
        pais6.setText("");
        incidencia6.setText("");
        urgen6.setText("");
        desc6.setText("");
    }//GEN-LAST:event_btnDarBajaActionPerformed
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
            PreparedStatement stmt=cn.prepareStatement("SELECT * FROM incidencia WHERE estado='Activa' LIMIT "+limit2+" OFFSET "+offset2);
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
            stmt.close();
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
            PreparedStatement stmt=cn.prepareStatement("SELECT COUNT(*) AS rowcount FROM incidencia WHERE estado='Activa'");
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next())
            {
                num=resultado.getInt("rowcount");
            }
            stmt.close();
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
            java.util.logging.Logger.getLogger(DarBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DarBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DarBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DarBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DarBaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnt2;
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JButton btnSig2;
    private javax.swing.JTextField calle6;
    private javax.swing.JTextField ciudad6;
    private javax.swing.JTextField cliente6;
    private javax.swing.JTextField colonia6;
    private javax.swing.JTextField cp6;
    private javax.swing.JTextArea desc6;
    private javax.swing.JTextField descrip4;
    private javax.swing.JTextField edad6;
    private javax.swing.JTextField estado6;
    private javax.swing.JTextField ext6;
    private javax.swing.JTextField fecha6;
    private javax.swing.JTextField hora6;
    private javax.swing.JTextField id6;
    private javax.swing.JTextField incidencia6;
    private javax.swing.JTextField int6;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField nombre6;
    private javax.swing.JTextField pais6;
    private javax.swing.JTable table1;
    private javax.swing.JTextField tel6;
    private javax.swing.JTextField urgen6;
    private javax.swing.JTextField usuario6;
    // End of variables declaration//GEN-END:variables
}
