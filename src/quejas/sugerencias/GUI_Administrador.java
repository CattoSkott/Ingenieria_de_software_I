package quejas.sugerencias;
//Librerias utilizadas
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable; 
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;





/**
 *
 * @author gerar
 */
public class GUI_Administrador extends javax.swing.JFrame implements WindowListener{
    //Varieables de instancia
    private int id_usuario;
    private ArrayList <ArrayList<Object>> users=new ArrayList();
    private final String titulos1[]=new String[2];        
    private int limit1=10;
    private int offset1=0;
    private boolean stop=false;
    private final String titulos2[]=new String[4];
    private final ArrayList <ArrayList<Object>> incidencia=new ArrayList();
    private int limit2=10;
    private int offset2=0;
    private final String titulos3[]=new String[18];
    private final String titulos4[]=new String[4];
    private int limit4=10;
    private int offset4=0;
    //Constructor
    public GUI_Administrador(int id_usuario) {
        //Titulos para las tablas usadas
        titulos1[0]="ID";
        titulos1[1]="NOMBRE";
        titulos2[0]="ID INCIDENCIA";
        titulos2[1]="FECHA";
        titulos2[2]="HORA";
        titulos2[3]="ID USUARIO";       
        titulos3[0]="ID";
        titulos3[1]="FECHA";
        titulos3[2]="HORA";
        titulos3[3]="NOMBRE";
        titulos3[4]="EDAD";
        titulos3[5]="TELEFONO";
        titulos3[6]="CALLE";
        titulos3[7]="COLONIA";
        titulos3[8]="INTERIOR";
        titulos3[9]="EXTERIOR";
        titulos3[10]="CP";
        titulos3[11]="CIUDAD";
        titulos3[12]="ESTADO";
        titulos3[13]="PAIS";
        titulos3[14]="ATENDIÓ";
        titulos3[15]="INCIDENCIA";
        titulos3[16]="ESTATUS";
        titulos3[17]="DESCRIPCIÓN";
        titulos4[0]="NOMBRE";
        titulos4[1]="TIPO";
        titulos4[2]="FECHA";
        titulos4[3]="HORA";
        //Se inician componentes
        initComponents();
        addWindowListener(this);
        //Botones de tabla se deshabilitan
        ANTERIOR.setEnabled(false);
        btnAnt2.setEnabled(false);
        btnAnteriorRep.setEnabled(false);
        //Se recibe el usuario
        this.id_usuario=id_usuario;
        tabbed.setBackground(new Color(243,129,129,225));
        //Imagenes del tabbed pane
        tabbed.setIconAt(0, new javax.swing.ImageIcon("imagenes/1.png"));
        tabbed.setIconAt(1, new javax.swing.ImageIcon("imagenes/2.png"));
        tabbed.setIconAt(2, new javax.swing.ImageIcon("imagenes/3.png"));
        tabbed.setIconAt(3, new javax.swing.ImageIcon("imagenes/4.png"));
        tabbed.setIconAt(4, new javax.swing.ImageIcon("imagenes/5.png"));
        //Colores y fuente del tabbed pane
        tabbed.setFont(new java.awt.Font("Dialog", 1, 20));
        tabbed.setBackgroundAt(0,new Color(255,255,255));
        tabbed.setBackgroundAt(1,new Color(134,105,226,255));
        tabbed.setBackgroundAt(2,new Color(134,105,226,255));
        tabbed.setBackgroundAt(3,new Color(134,105,226,255));
        tabbed.setBackgroundAt(4,new Color(134,105,226,255));
        tabbed.setForegroundAt(0,new Color(134,105,226,255));
        tabbed.setForegroundAt(1,new Color(255,255,255));
        tabbed.setForegroundAt(2,new Color(255,255,255));
        tabbed.setForegroundAt(3,new Color(255,255,255));
        tabbed.setForegroundAt(4,new Color(255,255,255));
        //Colores de los botones usados
        actualizarBtn.setBackground(Color.white);
        actualizarBtn.setForeground(new Color(134,105,226));
        ANTERIOR.setBackground(new Color(134,105,226));
        ANTERIOR.setForeground(Color.white);
        sig.setBackground(new Color(134,105,226));
        sig.setForeground(Color.white);
        btnAnt2.setBackground(new Color(134,105,226));
        btnAnt2.setForeground(Color.white);
        btnSig2.setBackground(new Color(134,105,226));
        btnSig2.setForeground(Color.white);
        btnAnteriorRep.setBackground(new Color(134,105,226));
        btnAnteriorRep.setForeground(Color.white);
        btnSigRep.setBackground(new Color(134,105,226));
        btnSigRep.setForeground(Color.white);
        insertarDato.setBackground(Color.white);
        insertarDato.setForeground(new Color(134,105,226));
        nuevoDato.setBackground(Color.white);
        nuevoDato.setForeground(new Color(134,105,226));
        //Funciones para actualizar tablas usadas
        datosTabla();
        datosTablaIncidencia();
        datosTablaReportes();
        btnDescargar.setEnabled(false);
        actualizarBtn.setEnabled(false);
        nuevoDato.setEnabled(true);
        insertarDato.setEnabled(false);
        txtId.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        tabbed = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtCp = new javax.swing.JTextField();
        boxtipo = new javax.swing.JComboBox();
        actualizarBtn = new javax.swing.JToggleButton();
        jLabel43 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        nuevoDato = new javax.swing.JToggleButton();
        insertarDato = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableclientes = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int collIndex)
            {
                return false;
            }
        }
        ;
        sig = new javax.swing.JButton();
        ANTERIOR = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
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
        pais2 = new javax.swing.JTextField();
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
        incidencia2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        urgen2 = new javax.swing.JTextField();
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
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        pnGrafica = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        boxGrafico = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableConsultar = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int collIndex)
            {
                return false;
            }
        }
        ;
        jPanel19 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        btnDescargar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableReporte = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int collIndex)
            {
                return false;
            }
        }
        ;
        btnSigRep = new javax.swing.JButton();
        btnAnteriorRep = new javax.swing.JButton();
        btnDescRep = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        tabbed.setBackground(new java.awt.Color(134, 105, 221));
        tabbed.setForeground(new java.awt.Color(255, 255, 255));
        tabbed.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(134, 105, 221));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(134, 105, 221));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLIENTES");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("APELLIDO");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CALLE");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NÚMERO");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CP");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MUNICIPIO");

        boxtipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactivo", "Activo" }));
        boxtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxtipoActionPerformed(evt);
            }
        });

        actualizarBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        actualizarBtn.setText("Actualizar");
        actualizarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                actualizarBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                actualizarBtnMouseExited(evt);
            }
        });
        actualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarBtnActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("COLONIA");

        txtMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMunicipioActionPerformed(evt);
            }
        });

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("ESTADO");

        nuevoDato.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nuevoDato.setText("Nuevo");
        nuevoDato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nuevoDatoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nuevoDatoMouseExited(evt);
            }
        });
        nuevoDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoDatoActionPerformed(evt);
            }
        });

        insertarDato.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        insertarDato.setText("Agregar");
        insertarDato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                insertarDatoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                insertarDatoMouseExited(evt);
            }
        });
        insertarDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarDatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel45))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel44)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtColonia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCalle)
                                .addComponent(txtCp, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMunicipio, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boxtipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(actualizarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nuevoDato, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(insertarDato, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(7, 7, 7)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoDato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertarDato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        nuevoDato.getAccessibleContext().setAccessibleName("alo");

        tableclientes.setBackground(new java.awt.Color(255, 255, 255));
        tableclientes.setForeground(new java.awt.Color(0, 0, 0));
        tableclientes.setModel(new javax.swing.table.DefaultTableModel(

        ));
        tableclientes.setRequestFocusEnabled(false);
        tableclientes.setRowHeight(50);
        tableclientes.setSelectionBackground(new java.awt.Color(134, 105, 221));
        tableclientes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableclientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableclientes);

        sig.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        sig.setText("⇢");
        sig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sigMouseExited(evt);
            }
        });
        sig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigActionPerformed(evt);
            }
        });

        ANTERIOR.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        ANTERIOR.setText("\t⇠");
        ANTERIOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ANTERIORMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ANTERIORMouseExited(evt);
            }
        });
        ANTERIOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANTERIORActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(ANTERIOR, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sig, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sig, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ANTERIOR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbed.addTab("GESTIÓN DE CLIENTES", jPanel2);

        jPanel6.setBackground(new java.awt.Color(134, 105, 221));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(134, 105, 221));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("INCIDENCIAS");

        desc2.setEditable(false);
        desc2.setColumns(20);
        desc2.setRows(5);
        jScrollPane3.setViewportView(desc2);

        calle2.setEditable(false);

        estado2.setEditable(false);

        ext2.setEditable(false);

        ciudad2.setEditable(false);

        colonia2.setEditable(false);

        cp2.setEditable(false);

        pais2.setEditable(false);

        int2.setEditable(false);

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

        incidencia2.setEditable(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setText("Urgencia");

        urgen2.setEditable(false);

        nombre2.setEditable(false);
        nombre2.setBackground(new java.awt.Color(240, 240, 240));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        jLabel21.setText("Nombre");

        edad2.setEditable(false);
        edad2.setBackground(new java.awt.Color(240, 240, 240));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(240, 240, 240));
        jLabel22.setText("Edad");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(240, 240, 240));
        jLabel23.setText("Teléfono");

        tel2.setEditable(false);
        tel2.setBackground(new java.awt.Color(240, 240, 240));

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
        fecha2.setBackground(new java.awt.Color(240, 240, 240));

        id2.setEditable(false);
        id2.setBackground(new java.awt.Color(240, 240, 240));

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

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel10))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(incidencia2)
                                .addComponent(urgen2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(35, 35, 35)
                            .addComponent(jScrollPane3))
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
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
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
                                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(estado2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ext2)
                                                    .addComponent(int2)
                                                    .addComponent(pais2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                            .addComponent(pais2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(incidencia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(urgen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))))
                        .addGap(26, 26, 26))
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

        table1.setBackground(new java.awt.Color(255, 255, 255));
        table1.setForeground(new java.awt.Color(0, 0, 0));
        table1.setModel(new javax.swing.table.DefaultTableModel(

        ));
        table1.setRequestFocusEnabled(false);
        table1.setRowHeight(50);
        table1.setSelectionBackground(new java.awt.Color(134, 105, 221));
        table1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        btnSig2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnSig2.setText("⇢");
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

        btnAnt2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnAnt2.setText("\t⇠");
        btnAnt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnt2MouseClicked(evt);
            }
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
                .addGap(29, 29, 29)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnAnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSig2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAnt2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSig2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbed.addTab("INCIDENCIAS", jPanel3);

        jPanel7.setBackground(new java.awt.Color(134, 105, 221));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        pnGrafica.setLayout(new javax.swing.BoxLayout(pnGrafica, javax.swing.BoxLayout.LINE_AXIS));

        jPanel12.setBackground(new java.awt.Color(134, 105, 221));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(134, 105, 221));
        jButton1.setText("GENERAR REGISTRO");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Registros");

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Tipo de gráfico:");

        boxGrafico.setBackground(new java.awt.Color(255, 255, 255));
        boxGrafico.setForeground(new java.awt.Color(134, 105, 221));
        boxGrafico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia","Mes","Año" }));
        boxGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGraficoActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Número de quejas");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(134, 105, 221));
        jButton2.setText("GENERAR QUEJA");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(89, 89, 89))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel36)
                .addGap(42, 42, 42)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel34)
                .addGap(66, 66, 66)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbed.addTab("ESTADÍSTICAS", jPanel4);

        jPanel1.setBackground(new java.awt.Color(134, 105, 221));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        tableConsultar.setBackground(new java.awt.Color(255, 255, 255));
        tableConsultar.setForeground(new java.awt.Color(0, 0, 0));
        tableConsultar.setModel(new javax.swing.table.DefaultTableModel(

        ));
        tableConsultar.setRequestFocusEnabled(false);
        tableConsultar.setRowHeight(50);
        tableConsultar.setSelectionBackground(new java.awt.Color(134, 105, 221));
        tableConsultar.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableConsultarMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableConsultar);

        jPanel19.setBackground(new java.awt.Color(134, 105, 221));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel37.setText("Consultar");

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Por:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "Mes" }));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Hora de inicio:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Hora final:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(134, 105, 221));
        jButton6.setText("MOSTRAR");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnDescargar.setBackground(new java.awt.Color(255, 255, 255));
        btnDescargar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnDescargar.setForeground(new java.awt.Color(134, 105, 221));
        btnDescargar.setText("DESCARGAR");
        btnDescargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDescargarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDescargarMouseExited(evt);
            }
        });
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(572, 572, 572)
                        .addComponent(jLabel37))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel38)
                        .addGap(12, 12, 12)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel39)
                        .addGap(16, 16, 16)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel37)
                .addGap(11, 11, 11)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        tabbed.addTab("CONSULTAR", jPanel1);

        jPanel8.setBackground(new java.awt.Color(134, 105, 221));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        tableReporte.setBackground(new java.awt.Color(255, 255, 255));
        tableReporte.setForeground(new java.awt.Color(0, 0, 0));
        tableReporte.setModel(new javax.swing.table.DefaultTableModel(

        ));
        tableReporte.setRequestFocusEnabled(false);
        tableReporte.setRowHeight(50);
        tableReporte.setSelectionBackground(new java.awt.Color(134, 105, 221));
        tableReporte.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReporteMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableReporte);

        btnSigRep.setBackground(new java.awt.Color(134, 105, 221));
        btnSigRep.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnSigRep.setForeground(new java.awt.Color(255, 255, 255));
        btnSigRep.setText("⇢");
        btnSigRep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSigRepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSigRepMouseExited(evt);
            }
        });
        btnSigRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigRepActionPerformed(evt);
            }
        });

        btnAnteriorRep.setBackground(new java.awt.Color(134, 105, 221));
        btnAnteriorRep.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnAnteriorRep.setForeground(new java.awt.Color(255, 255, 255));
        btnAnteriorRep.setText("\t⇠");
        btnAnteriorRep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnteriorRepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnteriorRepMouseExited(evt);
            }
        });
        btnAnteriorRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorRepActionPerformed(evt);
            }
        });

        btnDescRep.setBackground(new java.awt.Color(134, 105, 221));
        btnDescRep.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDescRep.setForeground(new java.awt.Color(255, 255, 255));
        btnDescRep.setText("DESCARGAR");
        btnDescRep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDescRepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDescRepMouseExited(evt);
            }
        });
        btnDescRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescRepActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("INCIDENCIAS");

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(134, 105, 221));
        jLabel42.setText("REPORTES");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(btnAnteriorRep, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btnDescRep, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSigRep, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(538, 538, 538)
                        .addComponent(jLabel42)))
                .addContainerGap(147, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(522, 522, 522)
                    .addComponent(jLabel41)
                    .addContainerGap(523, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAnteriorRep, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSigRep, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDescRep, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(320, 320, 320)
                    .addComponent(jLabel41)
                    .addContainerGap(321, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tabbed.addTab("REPORTES", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbed))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Funcion para cambiar de color tabbed pane
    private void tabbedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedMouseClicked
        // TODO add your handling code here:
        
        if(tabbed.getSelectedIndex()==0)
        {
            tabbed.setBackgroundAt(0,new Color(255,255,255,225));
            tabbed.setBackgroundAt(1,new Color(134,105,226));
            tabbed.setBackgroundAt(2,new Color(134,105,226));
            tabbed.setBackgroundAt(3,new Color(134,105,226));
            tabbed.setBackgroundAt(4,new Color(134,105,226));
            
            tabbed.setForegroundAt(0,new Color(134,105,226));
            tabbed.setForegroundAt(1,new Color(255,255,255,225));
            tabbed.setForegroundAt(2,new Color(255,255,255,225));
            tabbed.setForegroundAt(3,new Color(255,255,255,225));
            tabbed.setForegroundAt(4,new Color(255,255,255,225));
        }
        else if(tabbed.getSelectedIndex()==1)
        {
            tabbed.setBackgroundAt(1,new Color(255,255,255,225));
            tabbed.setBackgroundAt(0,new Color(134,105,226));
            tabbed.setBackgroundAt(2,new Color(134,105,226));
            tabbed.setBackgroundAt(3,new Color(134,105,226));
            tabbed.setBackgroundAt(4,new Color(134,105,226));
            
            tabbed.setForegroundAt(1,new Color(134,105,226));
            tabbed.setForegroundAt(0,new Color(255,255,255,225));
            tabbed.setForegroundAt(2,new Color(255,255,255,225));
            tabbed.setForegroundAt(3,new Color(255,255,255,225));
            tabbed.setForegroundAt(4,new Color(255,255,255,225));
        }
        else if(tabbed.getSelectedIndex()==2)
        {
            tabbed.setBackgroundAt(2,new Color(255,255,255,225));
            tabbed.setBackgroundAt(1,new Color(134,105,226));
            tabbed.setBackgroundAt(0,new Color(134,105,226));
            tabbed.setBackgroundAt(3,new Color(134,105,226));
            tabbed.setBackgroundAt(4,new Color(134,105,226));
            
            tabbed.setForegroundAt(2,new Color(134,105,226));
            tabbed.setForegroundAt(1,new Color(255,255,255,225));
            tabbed.setForegroundAt(0,new Color(255,255,255,225));
            tabbed.setForegroundAt(3,new Color(255,255,255,225));
            tabbed.setForegroundAt(4,new Color(255,255,255,225));
        }
        else if(tabbed.getSelectedIndex()==3)
        {
            tabbed.setBackgroundAt(3,new Color(255,255,255,225));
            tabbed.setBackgroundAt(1,new Color(134,105,226));
            tabbed.setBackgroundAt(2,new Color(134,105,226));
            tabbed.setBackgroundAt(0,new Color(134,105,226));
            tabbed.setBackgroundAt(4,new Color(134,105,226));
            
            tabbed.setForegroundAt(3,new Color(134,105,226));
            tabbed.setForegroundAt(1,new Color(255,255,255,225));
            tabbed.setForegroundAt(2,new Color(255,255,255,225));
            tabbed.setForegroundAt(0,new Color(255,255,255,225));
            tabbed.setForegroundAt(4,new Color(255,255,255,225));
        }
        else if(tabbed.getSelectedIndex()==4)
        {
            tabbed.setBackgroundAt(4,new Color(255,255,255,225));
            tabbed.setBackgroundAt(1,new Color(134,105,226));
            tabbed.setBackgroundAt(2,new Color(134,105,226));
            tabbed.setBackgroundAt(3,new Color(134,105,226));
            tabbed.setBackgroundAt(0,new Color(134,105,226));
            
            tabbed.setForegroundAt(4,new Color(134,105,226));
            tabbed.setForegroundAt(1,new Color(255,255,255,225));
            tabbed.setForegroundAt(2,new Color(255,255,255,225));
            tabbed.setForegroundAt(3,new Color(255,255,255,225));
            tabbed.setForegroundAt(0,new Color(255,255,255,225));
        }
        
    }//GEN-LAST:event_tabbedMouseClicked
    //Funcion de boton para cambiar de pagina en las tablas
    private void ANTERIORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANTERIORActionPerformed
        // TODO add your handling code here:
        if(offset1!=0)
        {
            offset1-=10;
            users.clear();            
            datosTabla();
            sig.setEnabled(true);
            ANTERIOR.setEnabled(true);
            if(offset1==0)
            {
                ANTERIOR.setEnabled(false);                
            }
        }               
    }//GEN-LAST:event_ANTERIORActionPerformed
    //Funcion de boton para cambiar de pagina en las tablas
    private void sigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigActionPerformed
        // TODO add your handling code here:
        if((contarRows()-offset1)>10)
        {
            offset1+=10;
            users.clear();
            datosTabla();
            sig.setEnabled(true);
            ANTERIOR.setEnabled(true);
            if((contarRows()-offset1)<=10)
            {
                sig.setEnabled(false);
            }
        }
    }//GEN-LAST:event_sigActionPerformed
    //Funcion para obtener el elemento seleccionado de la tabla y mostrar sus datos mediante un query
    private void tableclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableclientesMouseClicked
        // TODO add your handling code here:
        actualizarBtn.setEnabled(true);
        nuevoDato.setEnabled(true);
        insertarDato.setEnabled(false);
        String id=String.valueOf(tableclientes.getValueAt(tableclientes.getSelectedRow(), 0));
        for(int x=0;x<users.size();x++)
        {
            
            if(users.get(x).get(0).equals(id))
            {
                txtId.setEditable(false);
                txtId.setText(users.get(x).get(0).toString());
                txtCliente.setText(users.get(x).get(1).toString());
                txtApellido.setText(users.get(x).get(2).toString());
                txtCalle.setText(users.get(x).get(3).toString());
                txtNumero.setText(users.get(x).get(4).toString());
                txtColonia.setText(users.get(x).get(5).toString());
                txtCp.setText(users.get(x).get(6).toString());
                txtMunicipio.setText(users.get(x).get(7).toString());
                txtEstado.setText(users.get(x).get(8).toString());
                boxtipo.setSelectedIndex(Integer.parseInt(users.get(x).get(9).toString()));
            }
        }
    }//GEN-LAST:event_tableclientesMouseClicked
    //Funcion para actualizar los datos seleccionados
    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        // TODO add your handling code here:
        actualizarBtn.setEnabled(true);
        nuevoDato.setEnabled(true);
        insertarDato.setEnabled(false);
        if(!txtId.getText().equals(""))
        {
            Connection cn;
            ConexionBD conected=new ConexionBD();
            cn=conected.conexion();
            try
            {
                PreparedStatement stmt = cn.prepareStatement("UPDATE cliente INNER JOIN direccion ON (cliente.id_direccion = direccion.id_direccion) SET cliente.nombre=?, cliente.apellido=?, direccion.calle=?, direccion.numero=?, direccion.colonia=?, direccion.cp=?, direccion.municipio=?, direccion.estado=?, cliente.activo=? WHERE cliente.id_cliente=? AND cliente.id_direccion=direccion.id_direccion;");
                stmt.setString(1, txtCliente.getText());
                stmt.setString(2, txtApellido.getText());
                stmt.setString(3, txtCalle.getText());
                stmt.setInt(4, Integer.parseInt(txtNumero.getText()));
                stmt.setString(5, txtColonia.getText());
                stmt.setInt(6, Integer.parseInt(txtCp.getText()));
                stmt.setString(7, txtMunicipio.getText());
                stmt.setString(8, txtEstado.getText());
                stmt.setInt(9, boxtipo.getSelectedIndex());
                stmt.setInt(10, Integer.parseInt(txtId.getText()));

                stmt.executeUpdate();
                stmt.close();
                datosTabla();
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
            catch(java.lang.NullPointerException e2)
            {
                JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un dato de la tabla","SIN DATOS",2);
        }
        
    }//GEN-LAST:event_actualizarBtnActionPerformed
    //Funcion para obtener el elemento seleccionado de la tabla y mostrar sus datos mediante un query
    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        String id=String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0));
        for(int x=0;x<incidencia.size();x++)
        {
            if(incidencia.get(x).get(0).equals(id))
            {
                id2.setText(incidencia.get(x).get(0).toString());
                fecha2.setText(incidencia.get(x).get(1).toString());
                hora2.setText(incidencia.get(x).get(2).toString());
                cliente2.setText(incidencia.get(x).get(3).toString());
                usuario2.setText(incidencia.get(x).get(4).toString());
                descrip.setText(incidencia.get(x).get(5).toString());
                
                
                Connection cn;
                ConexionBD conected=new ConexionBD();
                cn=conected.conexion();
                String id_direccion="";
                try
                {
                    PreparedStatement stmt=cn.prepareStatement("SELECT * FROM cliente WHERE id_cliente=?;");
                    stmt.setString(1, (incidencia.get(x).get(3).toString()));
                    ResultSet resultado = stmt.executeQuery();

                    while(resultado.next())
                    {
                        nombre2.setText(resultado.getString("nombre"));
                        edad2.setText(resultado.getString("edad"));
                        tel2.setText(resultado.getString("telefono"));
                        id_direccion=resultado.getString("id_direccion");
                        
                    }
                    stmt=cn.prepareStatement("SELECT * FROM direccion WHERE id_direccion=?;");
                    stmt.setString(1, id_direccion);
                    resultado=stmt.executeQuery();
                    while(resultado.next())
                    {
                        calle2.setText(resultado.getString("calle"));
                        colonia2.setText(resultado.getString("colonia"));
                        int2.setText(resultado.getString("interior"));
                        ext2.setText(resultado.getString("exterior"));
                        cp2.setText(resultado.getString("cp"));
                        ciudad2.setText(resultado.getString("ciudad"));
                        estado2.setText(resultado.getString("estado"));
                        pais2.setText(resultado.getString("pais"));                  
                    }
                    stmt=cn.prepareStatement("SELECT * FROM descripcion WHERE id_descripcion=?;");
                    stmt.setString(1, (incidencia.get(x).get(5).toString()));
                    resultado = stmt.executeQuery();

                    while(resultado.next())
                    {
                       incidencia2.setText(resultado.getString("Incidencia"));
                       urgen2.setText(resultado.getString("estatus"));
                       desc2.setText(resultado.getString("descripcion"));                       
                    }
                    stmt.close();
                }
                catch(SQLException ex)
                {
                    System.out.println(ex);
                }
                catch(java.lang.NullPointerException e2)
                {
                    JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
                }
            }
        }
    }//GEN-LAST:event_table1MouseClicked
    //Boton para moverse de pagina en la tabla
    private void btnSig2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSig2ActionPerformed
        // TODO add your handling code here:
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
    //Boton para moverse de pagina en la tabla
    private void btnAnt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnt2ActionPerformed
        // TODO add your handling code here:
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
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void actualizarBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnMouseEntered
        // TODO add your handling code here:
        actualizarBtn.setBackground(new Color(134,105,226));
        actualizarBtn.setForeground(Color.white);
    }//GEN-LAST:event_actualizarBtnMouseEntered
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void actualizarBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnMouseExited
        // TODO add your handling code here:
        actualizarBtn.setBackground(Color.white);
        actualizarBtn.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_actualizarBtnMouseExited
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void ANTERIORMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ANTERIORMouseEntered
        // TODO add your handling code here:
        ANTERIOR.setBackground(Color.white);
        ANTERIOR.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_ANTERIORMouseEntered
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void ANTERIORMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ANTERIORMouseExited
        // TODO add your handling code here:
        ANTERIOR.setBackground(new Color(134,105,226));
        ANTERIOR.setForeground(Color.white);
    }//GEN-LAST:event_ANTERIORMouseExited
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void sigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sigMouseEntered
        // TODO add your handling code here:
        sig.setBackground(Color.white);
        sig.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_sigMouseEntered
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void sigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sigMouseExited
        // TODO add your handling code here:
        sig.setBackground(new Color(134,105,226));
        sig.setForeground(Color.white);
    }//GEN-LAST:event_sigMouseExited

    private void btnAnt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnt2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnt2MouseClicked
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void btnAnt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnt2MouseEntered
        // TODO add your handling code here:
        btnAnt2.setBackground(Color.white);
        btnAnt2.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_btnAnt2MouseEntered
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void btnAnt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnt2MouseExited
        // TODO add your handling code here:
        btnAnt2.setBackground(new Color(134,105,226));
        btnAnt2.setForeground(Color.white);
    }//GEN-LAST:event_btnAnt2MouseExited
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void btnSig2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSig2MouseEntered
        // TODO add your handling code here:
        btnSig2.setBackground(Color.white);
        btnSig2.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_btnSig2MouseEntered
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void btnSig2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSig2MouseExited
        // TODO add your handling code here:
        btnSig2.setBackground(new Color(134,105,226));
        btnSig2.setForeground(Color.white);
    }//GEN-LAST:event_btnSig2MouseExited
    //Funcion para generar grafico. Toma valor del comboBox y genera la grafica que le corresponde
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection cn;
        ConexionBD conected=new ConexionBD();
        DefaultCategoryDataset dcd= new DefaultCategoryDataset();
        cn=conected.conexion();
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT COUNT(id_usuario), id_usuario FROM movimiento GROUP BY id_usuario ORDER BY COUNT(id_usuario) DESC LIMIT 10");
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                
                dcd.setValue(Integer.parseInt(resultado.getString(1)),resultado.getString(2),".");  
            }
            stmt.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(java.lang.NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
        JFreeChart jChart = ChartFactory.createBarChart3D("USUARIOS CON MÁS MOVIMIENTOS", "USUARIOS", "MOVIMIENTOS", dcd, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot plot =jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartPanel chartPanel = new ChartPanel(jChart);
        pnGrafica.removeAll();
        pnGrafica.add(chartPanel);
        pnGrafica.updateUI();
    }//GEN-LAST:event_jButton1ActionPerformed
    //Funcion para generar grafico. Toma valor del comboBox y genera la grafica que le corresponde
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Connection cn;
        ConexionBD conected=new ConexionBD();
        DefaultCategoryDataset dcd= new DefaultCategoryDataset();
        dcd.clear();
        cn=conected.conexion();
        try
        {
            if(boxGrafico.getSelectedIndex()==0)
            {
                PreparedStatement stmt=cn.prepareStatement("SELECT YEAR(fecha), MONTH(fecha),DAY(fecha), COUNT(*) FROM incidencia GROUP BY YEAR(fecha), MONTH(fecha),DAY(fecha)");
                ResultSet resultado = stmt.executeQuery();

                while(resultado.next())
                {

                    dcd.setValue(Integer.parseInt(resultado.getString(4)),resultado.getString(1)+"-"+resultado.getString(2),resultado.getString(3));  
                }
                stmt.close();
            }
            else if(boxGrafico.getSelectedIndex()==1)
            {
                PreparedStatement stmt=cn.prepareStatement("SELECT YEAR(fecha), MONTH(fecha), COUNT(*) FROM incidencia GROUP BY YEAR(fecha), MONTH(fecha)");
                ResultSet resultado = stmt.executeQuery();

                while(resultado.next())
                {

                    dcd.setValue(Integer.parseInt(resultado.getString(3)),resultado.getString(2),resultado.getString(1));  
                }
                stmt.close();
            }
            else if(boxGrafico.getSelectedIndex()==2)
            {
                PreparedStatement stmt=cn.prepareStatement("SELECT YEAR(fecha), COUNT(*) FROM incidencia GROUP BY YEAR(fecha)");
                ResultSet resultado = stmt.executeQuery();

                while(resultado.next())
                {

                    dcd.setValue(Integer.parseInt(resultado.getString(2)),resultado.getString(1),"");  
                }
                stmt.close();
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(java.lang.NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
        JFreeChart jChart = ChartFactory.createBarChart3D("CANTIDAD DE REGISTROS", "FECHAS", "REGISTROS", dcd, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot plot =jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartPanel chartPanel = new ChartPanel(jChart);
        pnGrafica.removeAll();
        pnGrafica.add(chartPanel);
        pnGrafica.updateUI();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableConsultarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableConsultarMouseClicked
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setBackground(new Color(134,105,226));
        jButton2.setForeground(Color.white);
    }//GEN-LAST:event_jButton2MouseEntered
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setBackground(Color.white);
        jButton2.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_jButton2MouseExited
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setBackground(new Color(134,105,226));
        jButton1.setForeground(Color.white);
    }//GEN-LAST:event_jButton1MouseEntered
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setBackground(Color.white);
        jButton1.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_jButton1MouseExited
    //Funcion para cambiar de pagina en la tabla
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        jComboBox3.removeAllItems();
        int aux=jComboBox2.getSelectedIndex();
        for(int i=aux;i<=23;i++)
        {
            jComboBox3.addItem(i+":00");
        }
        
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void boxGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGraficoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxGraficoActionPerformed
    //Funcion para obtener consultas, que se muestran en una tabla
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        btnDescargar.setEnabled(true);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = dateFormat.format(date);
        
        Date hour = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        String hora = format.format(hour);
        
        
        
        Object datos1[][]=new Object[10][18];
        
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();

        try
        {
            PreparedStatement stmt;
            if(jComboBox1.getSelectedIndex()==0)
            {
                stmt=cn.prepareStatement("SELECT id_incidencia,CONCAT(año,\"-\",mes,\"-\",dia) as fecha,CONCAT(hora,\":\",minuto) as hora,nombre,edad,telefono,calle,colonia,interior,exterior,cp,ciudad,estado,pais,atendio,incidencia,estatus,descripcion  FROM(SELECT incidencia.id_incidencia, YEAR(incidencia.fecha) AS año,MONTH(incidencia.fecha) AS mes,DAY(incidencia.fecha) AS dia, HOUR(incidencia.hora) AS hora,MINUTE(incidencia.hora) AS minuto, cliente.nombre, cliente.edad, cliente.telefono, direccion.calle, direccion.colonia, direccion.interior, direccion.exterior, direccion.cp, direccion.ciudad, direccion.estado, direccion.pais, usuario.nombre AS atendio, descripcion.incidencia, descripcion.estatus, descripcion.descripcion FROM incidencia INNER JOIN cliente ON incidencia.id_cliente=cliente.id_cliente INNER JOIN usuario ON incidencia.id_usuario=usuario.id_usuario INNER JOIN descripcion ON incidencia.id_descripcion=descripcion.id_descripcion INNER JOIN direccion ON cliente.id_direccion=direccion.id_direccion) table1 WHERE año='"+fecha.substring(0,4)+"' AND mes='"+fecha.substring(5,7)+"' AND dia='"+fecha.substring(8,10)+"' AND hora BETWEEN '"+jComboBox2.getSelectedIndex()+"' AND '"+(jComboBox2.getSelectedIndex()+jComboBox3.getSelectedIndex())+"' LIMIT 10;");
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next())
                {
                    incidencia.add(new ArrayList<>());
                    for(int x=0;x<18;x++)
                    {
                        datos1[i][x]=resultado.getString(x+1); 
                    }
                    i++;
                }
                stmt.close();
            }
            else if(jComboBox1.getSelectedIndex()==1)
            {
                stmt=cn.prepareStatement("SELECT id_incidencia,CONCAT(año,\"-\",mes,\"-\",dia) as fecha,CONCAT(hora,\":\",minuto) as hora,nombre,edad,telefono,calle,colonia,interior,exterior,cp,ciudad,estado,pais,atendio,incidencia,estatus,descripcion  FROM(SELECT incidencia.id_incidencia, YEAR(incidencia.fecha) AS año,MONTH(incidencia.fecha) AS mes,DAY(incidencia.fecha) AS dia, HOUR(incidencia.hora) AS hora,MINUTE(incidencia.hora) AS minuto, cliente.nombre, cliente.edad, cliente.telefono, direccion.calle, direccion.colonia, direccion.interior, direccion.exterior, direccion.cp, direccion.ciudad, direccion.estado, direccion.pais, usuario.nombre AS atendio, descripcion.incidencia, descripcion.estatus, descripcion.descripcion FROM incidencia INNER JOIN cliente ON incidencia.id_cliente=cliente.id_cliente INNER JOIN usuario ON incidencia.id_usuario=usuario.id_usuario INNER JOIN descripcion ON incidencia.id_descripcion=descripcion.id_descripcion INNER JOIN direccion ON cliente.id_direccion=direccion.id_direccion) table1 WHERE año='"+fecha.substring(0,4)+"' AND mes='"+fecha.substring(5,7)+"' AND hora BETWEEN '"+jComboBox2.getSelectedIndex()+"' AND '"+(jComboBox2.getSelectedIndex()+jComboBox3.getSelectedIndex())+"' LIMIT 10");
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next())
                {
                    incidencia.add(new ArrayList<>());
                    for(int x=0;x<18;x++)
                    {
                        datos1[i][x]=resultado.getString(x+1); 
                    }
                    i++;
                }
                stmt.close();
            }
            tableConsultar.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos3));
            if(i==0)
            {
                JOptionPane.showMessageDialog(null,"No existen datos para esta busqueda...","No hay datos",2);
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    //Funcion que realiza un query y guarda todo en una tabla dentro de un pdf
    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        // TODO add your handling code here:
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = dateFormat.format(date);
        
        Date hour = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        String hora = format.format(hour);
        
        Date arch = new Date();
        DateFormat archFormat = new SimpleDateFormat("ddMMyy-hhmmss");
        String archivo = archFormat.format(arch);
        
        
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        
        
        
        try 
        {
            Document document = new Document(PageSize.A4.rotate(), 10f, 10f, 10f, 1f);

            PdfWriter.getInstance(document, new FileOutputStream("descargas/Consultas-"+archivo+".pdf"));

            document.open();
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Consultas:           Fecha: "+fecha+"            Hora: "+hora+"", font);
            document.add(chunk);
            
            PdfPTable table = new PdfPTable(18);
            Stream.of("ID", "FECHA", "HORA","NOMBRE", "EDAD", "TELEFONO","CALLE", "COLONIA", "INT","EXT", "CP", "CD","ESTADO", "PAIS", "ETENDIÓ","INCIDENCIA", "ESTATUS", "DESCRIPCIÓN")
                .forEach(columnTitle -> {
                  PdfPCell header = new PdfPCell();
                  header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                  header.setBorderWidth(2);
                  header.setPhrase(new Phrase(columnTitle));
                  table.addCell(header);
            });
            
            PreparedStatement stmt;
            if(jComboBox1.getSelectedIndex()==0)
            {
                stmt=cn.prepareStatement("SELECT id_incidencia,CONCAT(año,\"-\",mes,\"-\",dia) as fecha,CONCAT(hora,\":\",minuto) as hora,nombre,edad,telefono,calle,colonia,interior,exterior,cp,ciudad,estado,pais,atendio,incidencia,estatus,descripcion  FROM(SELECT incidencia.id_incidencia, YEAR(incidencia.fecha) AS año,MONTH(incidencia.fecha) AS mes,DAY(incidencia.fecha) AS dia, HOUR(incidencia.hora) AS hora,MINUTE(incidencia.hora) AS minuto, cliente.nombre, cliente.edad, cliente.telefono, direccion.calle, direccion.colonia, direccion.interior, direccion.exterior, direccion.cp, direccion.ciudad, direccion.estado, direccion.pais, usuario.nombre AS atendio, descripcion.incidencia, descripcion.estatus, descripcion.descripcion FROM incidencia INNER JOIN cliente ON incidencia.id_cliente=cliente.id_cliente INNER JOIN usuario ON incidencia.id_usuario=usuario.id_usuario INNER JOIN descripcion ON incidencia.id_descripcion=descripcion.id_descripcion INNER JOIN direccion ON cliente.id_direccion=direccion.id_direccion) table1 WHERE año='"+fecha.substring(0,4)+"' AND mes='"+fecha.substring(5,7)+"' AND dia='"+fecha.substring(8,10)+"' AND hora BETWEEN '"+jComboBox2.getSelectedIndex()+"' AND '"+(jComboBox2.getSelectedIndex()+jComboBox3.getSelectedIndex())+"' ;");
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next())
                {
                    incidencia.add(new ArrayList<>());
                    for(int x=0;x<18;x++)
                    {
                        table.addCell(resultado.getString(x+1)); 
                    }
                    i++;
                }
                stmt.close();
            }
            else if(jComboBox1.getSelectedIndex()==1)
            {
                stmt=cn.prepareStatement("SELECT id_incidencia,CONCAT(año,\"-\",mes,\"-\",dia) as fecha,CONCAT(hora,\":\",minuto) as hora,nombre,edad,telefono,calle,colonia,interior,exterior,cp,ciudad,estado,pais,atendio,incidencia,estatus,descripcion  FROM(SELECT incidencia.id_incidencia, YEAR(incidencia.fecha) AS año,MONTH(incidencia.fecha) AS mes,DAY(incidencia.fecha) AS dia, HOUR(incidencia.hora) AS hora,MINUTE(incidencia.hora) AS minuto, cliente.nombre, cliente.edad, cliente.telefono, direccion.calle, direccion.colonia, direccion.interior, direccion.exterior, direccion.cp, direccion.ciudad, direccion.estado, direccion.pais, usuario.nombre AS atendio, descripcion.incidencia, descripcion.estatus, descripcion.descripcion FROM incidencia INNER JOIN cliente ON incidencia.id_cliente=cliente.id_cliente INNER JOIN usuario ON incidencia.id_usuario=usuario.id_usuario INNER JOIN descripcion ON incidencia.id_descripcion=descripcion.id_descripcion INNER JOIN direccion ON cliente.id_direccion=direccion.id_direccion) table1 WHERE año='"+fecha.substring(0,4)+"' AND mes='"+fecha.substring(5,7)+"' AND hora BETWEEN '"+jComboBox2.getSelectedIndex()+"' AND '"+(jComboBox2.getSelectedIndex()+jComboBox3.getSelectedIndex())+"' ;");
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next())
                {
                    for(int x=0;x<18;x++)
                    {
                        table.addCell(resultado.getString(x+1)); 
                    }
                    i++;
                    
                }
                stmt.close();
            }
            if(i==0)
            {
                JOptionPane.showMessageDialog(null,"No existen datos para esta busqueda...","No hay datos",2);
            } 
            table.setWidthPercentage(90);
            document.add(table);            
            document.close();            
        } 
        catch (DocumentException e) 
        {
            JOptionPane.showMessageDialog(null,"Error en el Archivo","Archivo",0);
        } 
        catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null,"Archivo Existente.","Archivo",0);           
        } 
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
    }//GEN-LAST:event_btnDescargarActionPerformed

    private void tableReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReporteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableReporteMouseClicked

    private void btnAnteriorRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorRepActionPerformed
        // TODO add your handling code here:
        if(offset4!=0)
        {
            offset4-=10;
            datosTablaReportes();
            btnSigRep.setEnabled(true);
            btnAnteriorRep.setEnabled(true);
            if(offset4==0)
            {
                btnAnteriorRep.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnAnteriorRepActionPerformed

    private void btnSigRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigRepActionPerformed
        // TODO add your handling code here:
        if((contarRowsReporte()-offset4)>10)
        {
            offset4+=10;
            datosTablaReportes();
            btnSigRep.setEnabled(true);
            btnAnteriorRep.setEnabled(true);
            if((contarRowsReporte()-offset4)<=10)
            {
                btnSigRep.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnSigRepActionPerformed

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setForeground(Color.white);
        jButton6.setBackground(new Color(134,105,226));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
        jButton6.setBackground(Color.white);
        jButton6.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_jButton6MouseExited

    private void btnDescargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescargarMouseEntered
        // TODO add your handling code here:
        btnDescargar.setBackground(new Color(134,105,226));
        btnDescargar.setForeground(Color.white);
    }//GEN-LAST:event_btnDescargarMouseEntered

    private void btnDescargarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescargarMouseExited
        // TODO add your handling code here:
        btnDescargar.setForeground(new Color(134,105,226));
        btnDescargar.setBackground(Color.white);
    }//GEN-LAST:event_btnDescargarMouseExited

    private void btnSigRepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSigRepMouseEntered
        // TODO add your handling code here:
        btnSigRep.setBackground(Color.white);
        btnSigRep.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_btnSigRepMouseEntered

    private void btnSigRepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSigRepMouseExited
        // TODO add your handling code here:
        btnSigRep.setForeground(Color.white);
        btnSigRep.setBackground(new Color(134,105,226));
    }//GEN-LAST:event_btnSigRepMouseExited

    private void btnAnteriorRepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorRepMouseEntered
        // TODO add your handling code here:
        btnAnteriorRep.setBackground(Color.white);
        btnAnteriorRep.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_btnAnteriorRepMouseEntered

    private void btnAnteriorRepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorRepMouseExited
        // TODO add your handling code here:
        btnAnteriorRep.setForeground(Color.white);
        btnAnteriorRep.setBackground(new Color(134,105,226));
    }//GEN-LAST:event_btnAnteriorRepMouseExited

    private void btnDescRepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescRepMouseEntered
        // TODO add your handling code here:
        btnDescRep.setBackground(Color.white);
        btnDescRep.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_btnDescRepMouseEntered

    private void btnDescRepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescRepMouseExited
        // TODO add your handling code here:
        btnDescRep.setForeground(Color.white);
        btnDescRep.setBackground(new Color(134,105,226));
    }//GEN-LAST:event_btnDescRepMouseExited
    //Funcion que realiza un query y guarda todo en una tabla dentro de un pdf
    private void btnDescRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescRepActionPerformed
        // TODO add your handling code here:
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = dateFormat.format(date);
        
        Date hour = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        String hora = format.format(hour);
        
        Date arch = new Date();
        DateFormat archFormat = new SimpleDateFormat("ddMMyy-hhmmss");
        String archivo = archFormat.format(arch);
        
        
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        
        
        
        try 
        {
            Document document = new Document();
            document.setPageSize(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream("descargas/Reporte-"+archivo+".pdf"));

            document.open();
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Reportes:           Fecha: "+fecha+"            Hora: "+hora, font);
            document.add(chunk);
            
            PdfPTable table = new PdfPTable(4);
            Stream.of("NOMBRE","TIPO","FECHA","HORA")
                .forEach(columnTitle -> {
                  PdfPCell header = new PdfPCell();
                  header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                  header.setBorderWidth(2);
                  header.setPhrase(new Phrase(columnTitle));
                  table.addCell(header);
            });
            
            PreparedStatement stmt=cn.prepareStatement("SELECT * FROM (SELECT usuario.nombre, movimiento.tipo, movimiento.fecha, movimiento.hora FROM movimiento INNER JOIN usuario ON usuario.id_usuario=movimiento.id_usuario) table1 ORDER BY nombre ASC ");
            ResultSet resultado = stmt.executeQuery();

            while(resultado.next())
            {
                table.addCell(resultado.getString(1));
                table.addCell(resultado.getString(2));
                table.addCell(resultado.getString(3));
                table.addCell(resultado.getString(4));
                i++;
            }
            stmt.close();
            if(i==0)
            {
                JOptionPane.showMessageDialog(null,"No existen datos para esta busqueda...","No hay datos",2);
            } 
            table.setWidthPercentage(90);
            document.add(table);            
            document.close();            
        } 
        catch (DocumentException e) 
        {
            JOptionPane.showMessageDialog(null,"Error en el Archivo","Archivo",0);
        } 
        catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null,"Archivo Existente.","Archivo",0);           
        } 
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
    }//GEN-LAST:event_btnDescRepActionPerformed

    private void txtMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void boxtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxtipoActionPerformed

    private void nuevoDatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoDatoMouseEntered
        // TODO add your handling code here:
        nuevoDato.setBackground(new Color(134,105,226));
        nuevoDato.setForeground(Color.white);
    }//GEN-LAST:event_nuevoDatoMouseEntered

    private void nuevoDatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoDatoMouseExited
        // TODO add your handling code here:
        nuevoDato.setBackground(Color.white);
        nuevoDato.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_nuevoDatoMouseExited

    private void nuevoDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoDatoActionPerformed
        // TODO add your handling code here:
        actualizarBtn.setEnabled(false);
        nuevoDato.setEnabled(true);
        insertarDato.setEnabled(true);

        txtId.setText("");
        txtCliente.setText("");
        txtApellido.setText("");
        txtCalle.setText("");
        txtNumero.setText("");
        txtColonia.setText("");
        txtCp.setText("");
        txtMunicipio.setText("");
        txtEstado.setText("");
        boxtipo.setEnabled(false);
        boxtipo.setSelectedIndex(1);
        
    }//GEN-LAST:event_nuevoDatoActionPerformed

    private void insertarDatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarDatoMouseEntered
        // TODO add your handling code here:
        insertarDato.setBackground(new Color(134,105,226));
        insertarDato.setForeground(Color.white);
    }//GEN-LAST:event_insertarDatoMouseEntered

    private void insertarDatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarDatoMouseExited
        // TODO add your handling code here:
        insertarDato.setBackground(Color.white);
        insertarDato.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_insertarDatoMouseExited

    private void insertarDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarDatoActionPerformed
        if(!txtCliente.getText().equals("") &&
           !txtApellido.getText().equals("") &&
           !txtCalle.getText().equals("") &&
           !txtNumero.getText().equals("") &&
           !txtColonia.getText().equals("") &&
           !txtCp.getText().equals("") &&
           !txtMunicipio.getText().equals("") &&
           !txtEstado.getText().equals("") )
        {
            // TODO add your handling code here:
            actualizarBtn.setEnabled(true);
            nuevoDato.setEnabled(true);
            insertarDato.setEnabled(true);
            Connection cn;
            ConexionBD conected=new ConexionBD();
            cn=conected.conexion();
            try
            {

                String direccion = "INSERT INTO direccion (numero, calle, colonia, cp, estado, municipio) VALUES (?,?,?,?,?,?);";
                PreparedStatement stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, Integer.parseInt(txtNumero.getText()));
                stmt.setString(2, txtCalle.getText());
                stmt.setString(3, txtColonia.getText());
                stmt.setInt(4, Integer.parseInt(txtCp.getText()));
                stmt.setString(5, txtEstado.getText());
                stmt.setString(6, txtMunicipio.getText());

                stmt.executeUpdate();
                ResultSet rs=stmt.getGeneratedKeys();
                int id_direccion=0;
                if(rs.next())
                {
                    id_direccion = rs.getInt(1);
                }
                direccion = "INSERT INTO cliente (nombre, apellido, id_direccion, activo) VALUES (?,?,?,?);";
                stmt = cn.prepareStatement(direccion,Statement.RETURN_GENERATED_KEYS);

                stmt.setString(1, txtCliente.getText());
                stmt.setString(2, txtApellido.getText());
                stmt.setInt(3, id_direccion);
                stmt.setInt(4, 1);


                stmt.executeUpdate();
                stmt.close();
                datosTabla();

                actualizarBtn.setVisible(true);
                insertarDato.setVisible(true);
                txtId.setText("");
                txtCliente.setText("");
                txtApellido.setText("");
                txtCalle.setText("");
                txtNumero.setText("");
                txtColonia.setText("");
                txtCp.setText("");
                txtMunicipio.setText("");
                txtEstado.setText("");
                boxtipo.setEnabled(false);
                boxtipo.setSelectedIndex(1);

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
            catch(NullPointerException e2)
            {
                //Excepción para conexión con XAMPP
                JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Complete todas las casillas.","ERROR",0);
        }
    }//GEN-LAST:event_insertarDatoActionPerformed
    //Actualiza los datos, respecto al LIMIT y OFFSET que se dió
    public void datosTabla()
    {
        Object datos1[][]=new Object[10][2];
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT * FROM direccion INNER JOIN cliente ON cliente.id_direccion = direccion.id_direccion LIMIT "+limit1+" OFFSET "+offset1);
            ResultSet resultado = stmt.executeQuery();
            users = new ArrayList();
            while(resultado.next())
            {
                users.add(new ArrayList<>());
                datos1[i][0]=resultado.getString("id_cliente");
                datos1[i][1]=resultado.getString("nombre")+" "+resultado.getString("apellido");
                
                users.get(i).add(resultado.getString("id_cliente"));
                users.get(i).add(resultado.getString("nombre"));
                users.get(i).add(resultado.getString("apellido"));
                users.get(i).add(resultado.getString("calle"));
                users.get(i).add(resultado.getString("numero"));
                users.get(i).add(resultado.getString("colonia"));
                users.get(i).add(resultado.getString("cp"));
                users.get(i).add(resultado.getString("municipio"));
                users.get(i).add(resultado.getString("estado"));
                users.get(i).add(resultado.getString("ACTIVO"));
                
                i++;
            }
            
            tableclientes.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos1));
            stmt.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(java.lang.NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
    }
    //Actualiza los datos, respecto al LIMIT y OFFSET que se dió
    public void datosTablaIncidencia()
    {
        Object datos1[][]=new Object[10][4];
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT * FROM incidencia WHERE 1 LIMIT "+limit2+" OFFSET "+offset2);
            ResultSet resultado = stmt.executeQuery();

            while(resultado.next())
            {
                incidencia.add(new ArrayList<>());
                datos1[i][0]=resultado.getString("id_incidencia");
                datos1[i][1]=resultado.getString("fecha");
                datos1[i][2]=resultado.getString("hora");
                datos1[i][3]=resultado.getString("id_usuario");
                
                incidencia.get(i).add(resultado.getString("id_incidencia"));
                incidencia.get(i).add(resultado.getString("fecha"));
                incidencia.get(i).add(resultado.getString("hora"));
                incidencia.get(i).add(resultado.getString("id_cliente"));
                incidencia.get(i).add(resultado.getString("id_usuario"));
                incidencia.get(i).add(resultado.getString("id_descripcion"));
                
                i++;
            }
            stmt.close();
            table1.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos2));
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(java.lang.NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
    }
    //Actualiza los datos, respecto al LIMIT y OFFSET que se dió
    public void datosTablaReportes()
    {
        Object datos1[][]=new Object[10][4];
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT * FROM (SELECT usuario.nombre, movimiento.tipo, movimiento.fecha, movimiento.hora FROM movimiento INNER JOIN usuario ON usuario.id_usuario=movimiento.id_usuario) table1 ORDER BY nombre ASC LIMIT "+limit4+" OFFSET "+offset4);
            ResultSet resultado = stmt.executeQuery();

            while(resultado.next())
            {
                datos1[i][0]=resultado.getString(1);
                datos1[i][1]=resultado.getString(2);
                datos1[i][2]=resultado.getString(3);
                datos1[i][3]=resultado.getString(4);
                i++;
            }
            stmt.close();
            tableReporte.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos4));
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(java.lang.NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
    }
    //Cuenta los datos de la tabla
    public int contarRows()
    {
        int num=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT COUNT(*) AS rowcount FROM usuario ");
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next())
            {
                num=resultado.getInt("rowcount");
            }
            stmt.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(java.lang.NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
        return num;
    }
    //Cuenta los datos de la tabla
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
            stmt.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(java.lang.NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
        return num;
    }
    //Cuenta los datos de la tabla
    public int contarRowsReporte()
    {
        int num=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT COUNT(*) AS rowcount FROM movimiento ");
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next())
            {
                num=resultado.getInt("rowcount");
            }
            stmt.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(java.lang.NullPointerException e2)
        {
            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
        }
        return num;
    }
    @Override
    public void windowClosing(WindowEvent we) {
        GUI_Log inicio=new GUI_Log();
        inicio.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GUI_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Administrador(60000).setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ANTERIOR;
    private javax.swing.JToggleButton actualizarBtn;
    private javax.swing.JComboBox boxGrafico;
    private javax.swing.JComboBox boxtipo;
    private javax.swing.JButton btnAnt2;
    private javax.swing.JButton btnAnteriorRep;
    private javax.swing.JButton btnDescRep;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JButton btnSig2;
    private javax.swing.JButton btnSigRep;
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
    private javax.swing.JTextField incidencia2;
    private javax.swing.JToggleButton insertarDato;
    private javax.swing.JTextField int2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField nombre2;
    private javax.swing.JToggleButton nuevoDato;
    private javax.swing.JTextField pais2;
    private javax.swing.JPanel pnGrafica;
    private javax.swing.JButton sig;
    private javax.swing.JTabbedPane tabbed;
    private javax.swing.JTable table1;
    private javax.swing.JTable tableConsultar;
    private javax.swing.JTable tableReporte;
    private javax.swing.JTable tableclientes;
    private javax.swing.JTextField tel2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtCp;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField urgen2;
    private javax.swing.JTextField usuario2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    
}
