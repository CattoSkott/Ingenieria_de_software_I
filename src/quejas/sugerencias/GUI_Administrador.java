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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JComboBox;
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
    private int id_evento;
    private ArrayList <ArrayList<Object>> users=new ArrayList();
    private final String titulos1[]=new String[2];        
    private int limit1=10;
    private int offset1=0;
    private boolean stop=false;
    private final String titulos2[]=new String[4];
    private ArrayList <ArrayList<Object>> incidencia=new ArrayList();
    private ArrayList <ArrayList<Object>> apartados=new ArrayList();
    private ArrayList <ArrayList<Object>> evento=new ArrayList();
    private int limit2=10;
    private int offset2=0;
    private int limit3=10;
    private int offset3=0;
    private final String titulos3[]=new String[9];
    private final String titulos4[]=new String[4];
    private final String titulos5[]=new String[7];
    private final String titulos6[]=new String[5];
    private int limit4=10;
    private int offset4=0;
    //Constructor
    public GUI_Administrador(int id_usuario) {
        //Titulos para las tablas usadas
        titulos1[0]="ID";
        titulos1[1]="NOMBRE";
        
        titulos2[0]="TITULO";
        titulos2[1]="CÓDIGO";
        titulos2[2]="CANTIDAD";
        titulos2[3]="COSTO"; 
        
        titulos3[0]="FECHA";
        titulos3[1]="COMIENZA";
        titulos3[2]="FINALIZA";
        titulos3[3]="CALLE";
        titulos3[4]="NUMERO";
        titulos3[5]="COLONIA";
        titulos3[6]="CP";
        titulos3[7]="MUNICIPIO";
        titulos3[8]="ESTADO";

        
        titulos4[0]="NOMBRE";
        titulos4[1]="TIPO";
        titulos4[2]="FECHA";
        titulos4[3]="HORA";
        
        titulos5[0]="ATENDIÓ";
        titulos5[1]="CLIENTE";
        titulos5[2]="ARTICULO";
        titulos5[3]="CANTIDAD";
        titulos5[4]="TOTAL";
        titulos5[5]="FECHA";
        titulos5[6]="HORA";
        
        titulos6[0]="NOMBRE";
        titulos6[1]="DIRECCIÓN";
        titulos6[2]="TITULO";
        titulos6[3]="CANTIDAD";
        titulos6[4]="CÓDIGO";
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
        actualizabtn.setBackground(Color.white);
        actualizabtn.setForeground(new Color(134,105,226));
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
        datosTablaApartados();
        datosTablaIncidencia();
        datosTablaVenta();
        datosTablaReportes();
        //btnDescargar.setEnabled(false);
        actualizabtn.setEnabled(false);
        nuevoDato.setEnabled(true);
        insertarDato.setEnabled(false);
        txtId.setEditable(false);
        actualizabtn1.setEnabled(false);
        nuevoDato1.setEnabled(true);
        insertarDato1.setEnabled(false);
        actualizabtn1.setBackground(Color.white);
        actualizabtn1.setForeground(new Color(134,105,226));
        insertarDato1.setBackground(Color.white);
        insertarDato1.setForeground(new Color(134,105,226));
        nuevoDato1.setBackground(Color.white);
        nuevoDato1.setForeground(new Color(134,105,226));
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
        actualizabtn = new javax.swing.JToggleButton();
        jLabel43 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        nuevoDato = new javax.swing.JToggleButton();
        insertarDato = new javax.swing.JToggleButton();
        enviarDato = new javax.swing.JToggleButton();
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
        nombreEditorial = new javax.swing.JTextField();
        lugarEditorial = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        costoRetail = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cantidadRetail = new javax.swing.JTextField();
        nombreAutor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        apellidoAutor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        paginasLibro = new javax.swing.JTextField();
        idLibro = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        edicionLibro = new javax.swing.JTextField();
        tituloLibro = new javax.swing.JTextField();
        isbnLibro = new javax.swing.JTextField();
        codigoLibro = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        actualizabtn1 = new javax.swing.JToggleButton();
        nuevoDato1 = new javax.swing.JToggleButton();
        insertarDato1 = new javax.swing.JToggleButton();
        boxtipo1 = new javax.swing.JComboBox();
        enviarDato1 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLibros = new javax.swing.JTable()
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
        jPanel12 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cliente_nombre = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        codigo_libro = new javax.swing.JTextField();
        boxCantidad = new javax.swing.JComboBox();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        id_libro = new javax.swing.JTextField();
        id_cliente = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        costoLibro = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableLibrosVenta1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int collIndex)
            {
                return false;
            }
        }
        ;
        jLabel47 = new javax.swing.JLabel();
        btnAnt3 = new javax.swing.JButton();
        btnSig3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableApartar = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int collIndex)
            {
                return false;
            }
        }
        ;
        jPanel19 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        codigo_libro1 = new javax.swing.JTextField();
        id_libro1 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        cliente_nombre1 = new javax.swing.JTextField();
        id_cliente1 = new javax.swing.JTextField();
        codigoApartado = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        boxCantidad1 = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
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
        jPanel20 = new javax.swing.JPanel();
        crearbtn = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        boxFinal = new javax.swing.JComboBox();
        txtEstado1 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtMunicipio1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCp1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtColonia1 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtNumero1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCalle1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        boxDia = new javax.swing.JComboBox();
        boxInicio = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        boxAño = new javax.swing.JComboBox();
        boxMes = new javax.swing.JComboBox();
        editarbtn = new javax.swing.JButton();
        eliminarbtn = new javax.swing.JButton();

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

        actualizabtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        actualizabtn.setText("Actualizar");
        actualizabtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                actualizabtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                actualizabtnMouseExited(evt);
            }
        });
        actualizabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizabtnActionPerformed(evt);
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

        enviarDato.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        enviarDato.setText("Seleccionar Dato");
        enviarDato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enviarDatoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                enviarDatoMouseExited(evt);
            }
        });
        enviarDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarDatoActionPerformed(evt);
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
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enviarDato, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(actualizabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nuevoDato, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(insertarDato, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(actualizabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoDato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertarDato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enviarDato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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
                .addGap(37, 37, 37)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(ANTERIOR, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sig, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ANTERIOR, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sig, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
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
        jLabel10.setText("INVENTARIO");

        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("NOMBRE");

        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("LUGAR");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("COSTO");

        costoRetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoRetailActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setText("CANTIDAD");

        nombreAutor.setBackground(new java.awt.Color(240, 240, 240));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        jLabel21.setText("NOMBRE");

        apellidoAutor.setBackground(new java.awt.Color(240, 240, 240));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(240, 240, 240));
        jLabel22.setText("APELLIDO");

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("AUTOR");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("RETAIL");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("LIBRO");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(240, 240, 240));
        jLabel28.setText("ID");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(240, 240, 240));
        jLabel29.setText("PAGINAS");

        paginasLibro.setBackground(new java.awt.Color(240, 240, 240));

        idLibro.setEditable(false);
        idLibro.setBackground(new java.awt.Color(240, 240, 240));

        jLabel30.setForeground(new java.awt.Color(240, 240, 240));
        jLabel30.setText("TITULO");

        jLabel31.setForeground(new java.awt.Color(240, 240, 240));
        jLabel31.setText("EDICION");

        codigoLibro.setEditable(false);
        codigoLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoLibroActionPerformed(evt);
            }
        });

        jLabel32.setForeground(new java.awt.Color(240, 240, 240));
        jLabel32.setText("CÓDIGO");

        jLabel33.setForeground(new java.awt.Color(240, 240, 240));
        jLabel33.setText("ISBN");

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("EDITORIAL");

        actualizabtn1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        actualizabtn1.setText("Actualizar");
        actualizabtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                actualizabtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                actualizabtn1MouseExited(evt);
            }
        });
        actualizabtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizabtn1ActionPerformed(evt);
            }
        });

        nuevoDato1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nuevoDato1.setText("Nuevo");
        nuevoDato1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nuevoDato1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nuevoDato1MouseExited(evt);
            }
        });
        nuevoDato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoDato1ActionPerformed(evt);
            }
        });

        insertarDato1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        insertarDato1.setText("Agregar");
        insertarDato1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                insertarDato1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                insertarDato1MouseExited(evt);
            }
        });
        insertarDato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarDato1ActionPerformed(evt);
            }
        });

        boxtipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactivo", "Activo" }));
        boxtipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxtipo1ActionPerformed(evt);
            }
        });

        enviarDato1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        enviarDato1.setText("Seleccionar Dato");
        enviarDato1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enviarDato1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                enviarDato1MouseExited(evt);
            }
        });
        enviarDato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarDato1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(paginasLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(idLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tituloLibro)
                    .addComponent(edicionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(270, 270, 270))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel33)
                                        .addComponent(jLabel32))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(isbnLibro)
                                        .addComponent(codigoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addGap(173, 173, 173)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                            .addComponent(jLabel46)
                                            .addGap(128, 128, 128)
                                            .addComponent(jLabel25))
                                        .addComponent(jLabel10))
                                    .addGap(155, 155, 155)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21))
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(apellidoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(nombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxtipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lugarEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombreEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel20))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(costoRetail, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cantidadRetail, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(enviarDato1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(actualizabtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nuevoDato1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(insertarDato1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(idLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(paginasLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(isbnLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edicionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))))
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel46)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(nombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(apellidoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(costoRetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lugarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cantidadRetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20))
                            .addComponent(jLabel13))))
                .addGap(36, 36, 36)
                .addComponent(boxtipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(37, 37, 37)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizabtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoDato1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertarDato1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(enviarDato1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        tableLibros.setBackground(new java.awt.Color(255, 255, 255));
        tableLibros.setForeground(new java.awt.Color(0, 0, 0));
        tableLibros.setModel(new javax.swing.table.DefaultTableModel(

        ));
        tableLibros.setRequestFocusEnabled(false);
        tableLibros.setRowHeight(50);
        tableLibros.setSelectionBackground(new java.awt.Color(134, 105, 221));
        tableLibros.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLibrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableLibrosMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tableLibros);

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
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnAnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSig2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSig2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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

        tabbed.addTab("INVENTARIO", jPanel3);

        jPanel7.setBackground(new java.awt.Color(134, 105, 221));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(134, 105, 221));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(134, 105, 221));
        jButton1.setText("GENERAR COMPRA");
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

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("CODIGO DE LIBRO:");

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("VENTA");

        cliente_nombre.setEditable(false);

        jLabel48.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("CLIENTE:");

        codigo_libro.setEditable(false);

        boxCantidad.setBackground(new java.awt.Color(255, 255, 255));
        boxCantidad.setForeground(new java.awt.Color(134, 105, 221));
        boxCantidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        boxCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCantidadActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("CANTIDAD:");

        jLabel50.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("TOTAL A PAGAR:");

        txtTotal.setEditable(false);

        id_libro.setEditable(false);

        id_cliente.setEditable(false);

        jLabel51.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("COSTO INDIVIDUAL:");

        costoLibro.setEditable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel36))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTotal)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxCantidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cliente_nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(codigo_libro, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_libro, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                    .addComponent(id_cliente)))
                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(costoLibro, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel36)
                .addGap(53, 53, 53)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel48)
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        tableLibrosVenta1.setBackground(new java.awt.Color(255, 255, 255));
        tableLibrosVenta1.setForeground(new java.awt.Color(0, 0, 0));
        tableLibrosVenta1.setModel(new javax.swing.table.DefaultTableModel(

        ));
        tableLibrosVenta1.setRequestFocusEnabled(false);
        tableLibrosVenta1.setRowHeight(50);
        tableLibrosVenta1.setSelectionBackground(new java.awt.Color(134, 105, 221));
        tableLibrosVenta1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableLibrosVenta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLibrosVenta1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableLibrosVenta1);

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Tipo de gráfico:");

        btnAnt3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnAnt3.setText("\t⇠");
        btnAnt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnt3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnt3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnt3MouseExited(evt);
            }
        });
        btnAnt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnt3ActionPerformed(evt);
            }
        });

        btnSig3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnSig3.setText("⇢");
        btnSig3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSig3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSig3MouseExited(evt);
            }
        });
        btnSig3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSig3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(btnAnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSig3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSig3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 1501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbed.addTab("VENDER", jPanel4);

        jPanel1.setBackground(new java.awt.Color(134, 105, 221));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        tableApartar.setBackground(new java.awt.Color(255, 255, 255));
        tableApartar.setForeground(new java.awt.Color(0, 0, 0));
        tableApartar.setModel(new javax.swing.table.DefaultTableModel(

        ));
        tableApartar.setRequestFocusEnabled(false);
        tableApartar.setRowHeight(50);
        tableApartar.setSelectionBackground(new java.awt.Color(134, 105, 221));
        tableApartar.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableApartar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableApartarMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableApartar);

        jPanel19.setBackground(new java.awt.Color(134, 105, 221));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(134, 105, 221));
        jButton6.setText("AGREGAR APARTADO");
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

        jLabel52.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("CODIGO DE LIBRO:");

        codigo_libro1.setEditable(false);

        id_libro1.setEditable(false);

        jLabel53.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("CLIENTE:");

        cliente_nombre1.setEditable(false);

        id_cliente1.setEditable(false);
        id_cliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_cliente1ActionPerformed(evt);
            }
        });

        codigoApartado.setEditable(false);

        jLabel54.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("CÓDIGO:");

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(134, 105, 221));
        jButton7.setText("LIQIUDAR APARTADO");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        boxCantidad1.setBackground(new java.awt.Color(255, 255, 255));
        boxCantidad1.setForeground(new java.awt.Color(134, 105, 221));
        boxCantidad1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        boxCantidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCantidad1ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("CANTIDAD:");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigo_libro1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_libro1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(cliente_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(codigoApartado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(boxCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoApartado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cliente_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigo_libro1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_libro1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tabbed.addTab("APARTAR", jPanel1);

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

        jPanel20.setBackground(new java.awt.Color(134, 105, 221));

        crearbtn.setBackground(new java.awt.Color(255, 255, 255));
        crearbtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        crearbtn.setForeground(new java.awt.Color(134, 105, 221));
        crearbtn.setText("CREAR");
        crearbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearbtnMouseExited(evt);
            }
        });
        crearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearbtnActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("EVENTOS");

        boxFinal.setBackground(new java.awt.Color(255, 255, 255));
        boxFinal.setForeground(new java.awt.Color(134, 105, 221));
        boxFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        boxFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxFinalActionPerformed(evt);
            }
        });

        txtEstado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstado1ActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("ESTADO");

        txtMunicipio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMunicipio1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("MUNICIPIO");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CP");

        jLabel61.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("COLONIA");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("NÚMERO");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CALLE");

        boxDia.setBackground(new java.awt.Color(255, 255, 255));
        boxDia.setForeground(new java.awt.Color(134, 105, 221));
        boxDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Dia","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
        boxDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDiaActionPerformed(evt);
            }
        });

        boxInicio.setBackground(new java.awt.Color(255, 255, 255));
        boxInicio.setForeground(new java.awt.Color(134, 105, 221));
        boxInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"}));
        boxInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxInicioActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("FECHA");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("HORA INICIO");

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("HORA FIN");

        boxAño.setBackground(new java.awt.Color(255, 255, 255));
        boxAño.setForeground(new java.awt.Color(134, 105, 221));
        boxAño.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Año","2020","2021","2022"}));
        boxAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAñoActionPerformed(evt);
            }
        });

        boxMes.setBackground(new java.awt.Color(255, 255, 255));
        boxMes.setForeground(new java.awt.Color(134, 105, 221));
        boxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Mes","01","02","03","04","05","06","07","08","09","10","11","12"}));
        boxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMesActionPerformed(evt);
            }
        });

        editarbtn.setBackground(new java.awt.Color(255, 255, 255));
        editarbtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        editarbtn.setForeground(new java.awt.Color(134, 105, 221));
        editarbtn.setText("EDITAR ");
        editarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editarbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editarbtnMouseExited(evt);
            }
        });
        editarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarbtnActionPerformed(evt);
            }
        });

        eliminarbtn.setBackground(new java.awt.Color(255, 255, 255));
        eliminarbtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        eliminarbtn.setForeground(new java.awt.Color(134, 105, 221));
        eliminarbtn.setText("ELIMINAR");
        eliminarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarbtnMouseExited(evt);
            }
        });
        eliminarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtColonia1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumero1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCalle1)
                    .addComponent(txtCp1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMunicipio1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEstado1)
                    .addComponent(boxFinal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxInicio, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(boxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxAño, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(editarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel38)
                .addGap(38, 38, 38)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(boxAño, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColonia1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCp1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(7, 7, 7)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunicipio1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(50, 50, 50)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(btnAnteriorRep, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnDescRep, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSigRep, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAnteriorRep, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSigRep, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDescRep, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
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
        actualizabtn.setEnabled(true);
        nuevoDato.setEnabled(true);
        insertarDato.setEnabled(false);
        enviarDato.setEnabled(true);
        
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
    private void actualizabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizabtnActionPerformed
        // TODO add your handling code here:
        actualizabtn.setEnabled(true);
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
        
    }//GEN-LAST:event_actualizabtnActionPerformed
    //Funcion para obtener el elemento seleccionado de la tabla y mostrar sus datos mediante un query
    private void tableLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLibrosMouseClicked
        // TODO add your handling code here:
        actualizabtn1.setEnabled(true);
        nuevoDato1.setEnabled(true);
        insertarDato1.setEnabled(false);
        enviarDato1.setEnabled(true);
        String titulo=String.valueOf(tableLibros.getValueAt(tableLibros.getSelectedRow(), 0));
        for(int x=0;x<incidencia.size();x++)
        {
            if(incidencia.get(x).get(1).equals(titulo))
            {
                idLibro.setText(incidencia.get(x).get(0).toString());
                tituloLibro.setText(incidencia.get(x).get(1).toString());
                isbnLibro.setText(incidencia.get(x).get(2).toString());
                paginasLibro.setText(incidencia.get(x).get(3).toString());
                edicionLibro.setText(incidencia.get(x).get(4).toString());
                codigoLibro.setText(incidencia.get(x).get(5).toString());
                nombreAutor.setText(incidencia.get(x).get(6).toString());
                apellidoAutor.setText(incidencia.get(x).get(7).toString());
                nombreEditorial.setText(incidencia.get(x).get(8).toString());
                lugarEditorial.setText(incidencia.get(x).get(9).toString());
                costoRetail.setText(incidencia.get(x).get(10).toString());
                cantidadRetail.setText(incidencia.get(x).get(11).toString());
                boxtipo1.setSelectedIndex(Integer.parseInt(incidencia.get(x).get(12).toString()));
            }
        }
    }//GEN-LAST:event_tableLibrosMouseClicked
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
    private void actualizabtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizabtnMouseEntered
        // TODO add your handling code here:
        actualizabtn.setBackground(new Color(134,105,226));
        actualizabtn.setForeground(Color.white);
    }//GEN-LAST:event_actualizabtnMouseEntered
    //Boton que cambia de color dependiendo de la posicion del mouse
    private void actualizabtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizabtnMouseExited
        // TODO add your handling code here:
        actualizabtn.setBackground(Color.white);
        actualizabtn.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_actualizabtnMouseExited
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
        if (!codigo_libro.getText().equals("") &&
            !cliente_nombre.getText().equals("") &&
            !txtTotal.getText().equals("") &&
             boxCantidad.getSelectedIndex()!=0) {
            // TODO add your handling code here:

            Connection cn;
            ConexionBD conected = new ConexionBD();
            cn = conected.conexion();
            try {

                String direccion = "INSERT INTO venta (id_cliente, id_libro, id_usuario, fecha, hora, cantidad, total) VALUES (?,?,?,?,?,?,?);";
                PreparedStatement stmt = cn.prepareStatement(direccion);
                stmt.setInt(1, Integer.parseInt(id_cliente.getText()));
                stmt.setInt(2, Integer.parseInt(id_libro.getText()));
                stmt.setInt(3, id_usuario);
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = dateFormat.format(date);
                stmt.setString(4, fecha);
                Date hour = new Date();
                DateFormat format = new SimpleDateFormat("HH:mm:ss");
                String hora = format.format(hour);
                stmt.setString(5, hora);
                stmt.setInt(6, boxCantidad.getSelectedIndex());
                stmt.setFloat(7, Float.parseFloat(txtTotal.getText()));
                stmt.executeUpdate();
                
                stmt = cn.prepareStatement("UPDATE libro SET libro.cantidad=(libro.cantidad - ?) WHERE libro.id_libro=?;");
                stmt.setInt(1, boxCantidad.getSelectedIndex());
                stmt.setInt(2, Integer.parseInt(id_libro.getText()));
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Numero:"+boxCantidad.getWidth());
                
                datosTablaIncidencia();
                datosTablaVenta();
                 
                id_cliente.setText("");
                cliente_nombre.setText("");
                codigo_libro.setText("");
                id_libro.setText("");
                costoLibro.setText("");
                txtTotal.setText("");
                boxCantidad.removeAllItems(); 
                

            } catch (SQLException ex) {
                //Excepción para error de SQL
                System.out.println(ex);
            } catch (java.lang.NumberFormatException e1) {
                //Excepción para alguna invalidez de numérica
                JOptionPane.showMessageDialog(null, "Ingrese solo números (interior/exterior y CP)", "ALERTA", 2);
            } catch (NullPointerException e2) {
                //Excepción para conexión con XAMPP
                JOptionPane.showMessageDialog(null, "La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.", "ERROR", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR", "Asegurese de haber elegido el cliente, libro y una cantidad a comprar...", 0);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableApartarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableApartarMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        
        String codigo = String.valueOf(tableApartar.getValueAt(tableApartar.getSelectedRow(), 4));
        codigoApartado.setText(codigo);
        
    }//GEN-LAST:event_tableApartarMouseClicked

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

    private void boxCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCantidadActionPerformed
        // TODO add your handling code here:
        if(!costoLibro.getText().equals(""))
        {
            float total = Float.parseFloat(costoLibro.getText()) * boxCantidad.getSelectedIndex();
            txtTotal.setText(Float.toString(total));
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Debe elegir un libro","Seleccione uno en la penstaña INVENTARIO y agreguelo en AÑADIR",2);
        }
    }//GEN-LAST:event_boxCantidadActionPerformed
    //Funcion para obtener consultas, que se muestran en una tabla
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (!id_cliente1.getText().equals("") && !id_libro1.getText().equals("")) {
            Connection cn;
            ConexionBD conected = new ConexionBD();
            cn = conected.conexion();
            try {

                String direccion = "INSERT INTO apartado (estado, id_cliente, id_libro, codigo, cantidad) VALUES (1,?,?,?,?);";
                PreparedStatement stmt = cn.prepareStatement(direccion);
                stmt.setInt(1, Integer.parseInt(id_cliente1.getText()));
                stmt.setInt(2, Integer.parseInt(id_libro1.getText()));
                stmt.setString(3, codigoApartado.getText());
                stmt.setInt(4, boxCantidad1.getSelectedIndex());
                stmt.executeUpdate();

                stmt = cn.prepareStatement("UPDATE libro SET libro.cantidad=(libro.cantidad - ?) WHERE libro.id_libro=?;");
                stmt.setInt(1, boxCantidad1.getSelectedIndex());
                stmt.setInt(2, Integer.parseInt(id_libro1.getText()));
                stmt.executeUpdate();
                stmt.close();
                

                datosTablaIncidencia();
                datosTablaApartados();

                id_cliente1.setText("");
                cliente_nombre1.setText("");
                codigo_libro1.setText("");
                id_libro1.setText("");
                boxCantidad1.removeAllItems();
                codigoApartado.setText("");

            } catch (SQLException ex) {
                //Excepción para error de SQL
                System.out.println(ex);
            } catch (java.lang.NumberFormatException e1) {
                //Excepción para alguna invalidez de numérica
                JOptionPane.showMessageDialog(null, "Ingrese solo números (interior/exterior y CP)", "ALERTA", 2);
            } catch (NullPointerException e2) {
                //Excepción para conexión con XAMPP
                JOptionPane.showMessageDialog(null, "La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.", "ERROR", 0);
            }  
        }
//        btnDescargar.setEnabled(true);
//        Date date = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String fecha = dateFormat.format(date);
//        
//        Date hour = new Date();
//        DateFormat format = new SimpleDateFormat("HH:mm:ss");
//        String hora = format.format(hour);
//        
//        
//        
//        Object datos1[][]=new Object[10][18];
//        
//        int i=0;
//        Connection cn;
//        ConexionBD conected=new ConexionBD();
//        cn=conected.conexion();
//
//        try
//        {
//            PreparedStatement stmt;
//            if(jComboBox1.getSelectedIndex()==0)
//            {
//                stmt=cn.prepareStatement("SELECT id_incidencia,CONCAT(año,\"-\",mes,\"-\",dia) as fecha,CONCAT(hora,\":\",minuto) as hora,nombre,edad,telefono,calle,colonia,interior,exterior,cp,ciudad,estado,pais,atendio,incidencia,estatus,descripcion  FROM(SELECT incidencia.id_incidencia, YEAR(incidencia.fecha) AS año,MONTH(incidencia.fecha) AS mes,DAY(incidencia.fecha) AS dia, HOUR(incidencia.hora) AS hora,MINUTE(incidencia.hora) AS minuto, cliente.nombre, cliente.edad, cliente.telefono, direccion.calle, direccion.colonia, direccion.interior, direccion.exterior, direccion.cp, direccion.ciudad, direccion.estado, direccion.pais, usuario.nombre AS atendio, descripcion.incidencia, descripcion.estatus, descripcion.descripcion FROM incidencia INNER JOIN cliente ON incidencia.id_cliente=cliente.id_cliente INNER JOIN usuario ON incidencia.id_usuario=usuario.id_usuario INNER JOIN descripcion ON incidencia.id_descripcion=descripcion.id_descripcion INNER JOIN direccion ON cliente.id_direccion=direccion.id_direccion) table1 WHERE año='"+fecha.substring(0,4)+"' AND mes='"+fecha.substring(5,7)+"' AND dia='"+fecha.substring(8,10)+"' AND hora BETWEEN '"+jComboBox2.getSelectedIndex()+"' AND '"+(jComboBox2.getSelectedIndex()+jComboBox3.getSelectedIndex())+"' LIMIT 10;");
//                ResultSet resultado = stmt.executeQuery();
//                while(resultado.next())
//                {
//                    incidencia.add(new ArrayList<>());
//                    for(int x=0;x<18;x++)
//                    {
//                        datos1[i][x]=resultado.getString(x+1); 
//                    }
//                    i++;
//                }
//                stmt.close();
//            }
//            else if(jComboBox1.getSelectedIndex()==1)
//            {
//                stmt=cn.prepareStatement("SELECT id_incidencia,CONCAT(año,\"-\",mes,\"-\",dia) as fecha,CONCAT(hora,\":\",minuto) as hora,nombre,edad,telefono,calle,colonia,interior,exterior,cp,ciudad,estado,pais,atendio,incidencia,estatus,descripcion  FROM(SELECT incidencia.id_incidencia, YEAR(incidencia.fecha) AS año,MONTH(incidencia.fecha) AS mes,DAY(incidencia.fecha) AS dia, HOUR(incidencia.hora) AS hora,MINUTE(incidencia.hora) AS minuto, cliente.nombre, cliente.edad, cliente.telefono, direccion.calle, direccion.colonia, direccion.interior, direccion.exterior, direccion.cp, direccion.ciudad, direccion.estado, direccion.pais, usuario.nombre AS atendio, descripcion.incidencia, descripcion.estatus, descripcion.descripcion FROM incidencia INNER JOIN cliente ON incidencia.id_cliente=cliente.id_cliente INNER JOIN usuario ON incidencia.id_usuario=usuario.id_usuario INNER JOIN descripcion ON incidencia.id_descripcion=descripcion.id_descripcion INNER JOIN direccion ON cliente.id_direccion=direccion.id_direccion) table1 WHERE año='"+fecha.substring(0,4)+"' AND mes='"+fecha.substring(5,7)+"' AND hora BETWEEN '"+jComboBox2.getSelectedIndex()+"' AND '"+(jComboBox2.getSelectedIndex()+jComboBox3.getSelectedIndex())+"' LIMIT 10");
//                ResultSet resultado = stmt.executeQuery();
//                while(resultado.next())
//                {
//                    incidencia.add(new ArrayList<>());
//                    for(int x=0;x<18;x++)
//                    {
//                        datos1[i][x]=resultado.getString(x+1); 
//                    }
//                    i++;
//                }
//                stmt.close();
//            }
//            tableApartar.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos3));
//            if(i==0)
//            {
//                JOptionPane.showMessageDialog(null,"No existen datos para esta busqueda...","No hay datos",2);
//            }
//        }
//        catch(SQLException ex)
//        {
//            System.out.println(ex);
//        }
//        catch(NullPointerException e2)
//        {
//            JOptionPane.showMessageDialog(null,"La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.","ERROR",0);
//        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tableReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReporteMouseClicked
        // TODO add your handling code here:
        editarbtn.setEnabled(true);
        crearbtn.setEnabled(true);
        eliminarbtn.setEnabled(true);

        String titulo = String.valueOf(tableReporte.getValueAt(tableReporte.getSelectedRow(), 0));
        for (int x = 0; x < evento.size(); x++) {
            if (evento.get(x).get(0).equals(titulo)) {
               
                boxAño.setSelectedItem(evento.get(x).get(0).toString().substring(0, 4));
                boxMes.setSelectedItem(evento.get(x).get(0).toString().substring(5, 7));
                boxDia.setSelectedItem(evento.get(x).get(0).toString().substring(8, 10));
                boxInicio.setSelectedItem(evento.get(x).get(1).toString().substring(0, 5));
                boxFinal.setSelectedItem(evento.get(x).get(2).toString().substring(0, 5));
                txtCalle1.setText(evento.get(x).get(3).toString());
                txtNumero1.setText(evento.get(x).get(4).toString());
                txtColonia1.setText(evento.get(x).get(5).toString());
                txtCp1.setText(evento.get(x).get(6).toString());
                txtMunicipio1.setText(evento.get(x).get(7).toString());
                txtEstado1.setText(evento.get(x).get(8).toString());
                
                
                id_evento=Integer.parseInt(evento.get(x).get(9).toString());
            }
        }
        
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
        actualizabtn.setEnabled(false);
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
            actualizabtn.setEnabled(true);
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

                actualizabtn.setVisible(true);
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

    private void codigoLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoLibroActionPerformed

    private void actualizabtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizabtn1MouseEntered
        // TODO add your handling code here:
        actualizabtn1.setBackground(new Color(134,105,226));
        actualizabtn1.setForeground(Color.white);
    }//GEN-LAST:event_actualizabtn1MouseEntered

    private void actualizabtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizabtn1MouseExited
        // TODO add your handling code here:
        actualizabtn1.setBackground(Color.white);
        actualizabtn1.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_actualizabtn1MouseExited

    private void actualizabtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizabtn1ActionPerformed
        // TODO add your handling code here:
        actualizabtn1.setEnabled(true);
        nuevoDato1.setEnabled(true);
        insertarDato1.setEnabled(false);
        if (!idLibro.getText().equals("")) {
            Connection cn;
            ConexionBD conected = new ConexionBD();
            cn = conected.conexion();
            try {
                PreparedStatement stmt = cn.prepareStatement("UPDATE libro, autor, editorial SET libro.titulo=?, libro.isbn=?, libro.paginas=?, libro.edicion=?, autor.nombre=?, autor.apellido=?, editorial.editorial=?, editorial.lugar=?, libro.costo=?, libro.cantidad=?, libro.activo=? WHERE autor.id_autor=libro.id_autor AND editorial.id_editorial=libro.id_editorial AND libro.id_libro=?;");
                stmt.setString(1, tituloLibro.getText());
                stmt.setInt(2, Integer.parseInt(isbnLibro.getText()));
                stmt.setInt(3, Integer.parseInt(paginasLibro.getText()));
                stmt.setInt(4, Integer.parseInt(edicionLibro.getText()));
                stmt.setString(5, nombreAutor.getText());
                stmt.setString(6, apellidoAutor.getText());
                stmt.setString(7, nombreEditorial.getText());
                stmt.setString(8, lugarEditorial.getText());
                stmt.setFloat(9, Float.parseFloat(costoRetail.getText()));
                stmt.setInt(10, Integer.parseInt(cantidadRetail.getText()));
                stmt.setInt(11, boxtipo1.getSelectedIndex());
                stmt.setInt(12, Integer.parseInt(idLibro.getText()));


                stmt.executeUpdate();
                stmt.close();
                datosTablaIncidencia();
            } catch (SQLException ex) {
                System.out.println(ex);
            } catch (java.lang.NullPointerException e2) {
                JOptionPane.showMessageDialog(null, "La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.", "ERROR", 0);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un dato de la tabla", "SIN DATOS", 2);
        }
    }//GEN-LAST:event_actualizabtn1ActionPerformed

    private void nuevoDato1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoDato1MouseEntered
        // TODO add your handling code here:
        nuevoDato1.setBackground(new Color(134,105,226));
        nuevoDato1.setForeground(Color.white);
    }//GEN-LAST:event_nuevoDato1MouseEntered

    private void nuevoDato1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoDato1MouseExited
        // TODO add your handling code here:
        nuevoDato1.setBackground(Color.white);
        nuevoDato1.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_nuevoDato1MouseExited

    private void nuevoDato1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoDato1ActionPerformed
        // TODO add your handling code here:
        actualizabtn1.setEnabled(false);
        nuevoDato1.setEnabled(true);
        insertarDato1.setEnabled(true);

        idLibro.setText("");
        tituloLibro.setText("");
        isbnLibro.setText("");
        paginasLibro.setText("");
        edicionLibro.setText("");
        codigoLibro.setText("");
        nombreAutor.setText("");
        apellidoAutor.setText("");
        nombreEditorial.setText("");
        lugarEditorial.setText("");
        costoRetail.setText("");
        cantidadRetail.setText("");
        
        
    }//GEN-LAST:event_nuevoDato1ActionPerformed

    private void insertarDato1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarDato1MouseEntered
        // TODO add your handling code here:
        insertarDato1.setBackground(new Color(134,105,226));
        insertarDato1.setForeground(Color.white);
    }//GEN-LAST:event_insertarDato1MouseEntered

    private void insertarDato1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarDato1MouseExited
        // TODO add your handling code here:
        insertarDato1.setBackground(Color.white);
        insertarDato1.setForeground(new Color(134,105,226));
    }//GEN-LAST:event_insertarDato1MouseExited

    private void insertarDato1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarDato1ActionPerformed
        // TODO add your handling code here:
        if (!tituloLibro.getText().equals("") &&
            !isbnLibro.getText().equals("") &&
            !paginasLibro.getText().equals("") &&
            !edicionLibro.getText().equals("") &&
            !nombreAutor.getText().equals("") &&
            !apellidoAutor.getText().equals("") &&
            !nombreEditorial.getText().equals("") &&
            !lugarEditorial.getText().equals("") &&
            !costoRetail.getText().equals("") &&
            !cantidadRetail.getText().equals("") ){
            // TODO add your handling code here:
            actualizabtn1.setEnabled(true);
            nuevoDato1.setEnabled(true);
            insertarDato1.setEnabled(true);
            Connection cn;
            ConexionBD conected = new ConexionBD();
            cn = conected.conexion();
            try {

                String direccion = "INSERT INTO editorial (editorial, lugar) VALUES (?,?);";
                PreparedStatement stmt = cn.prepareStatement(direccion, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, nombreEditorial.getText());
                stmt.setString(2, lugarEditorial.getText());
                

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                int id_editorial = 0;
                if (rs.next()) {
                    id_editorial = rs.getInt(1);
                }
                
                direccion = "INSERT INTO autor (nombre, apellido) VALUES (?,?);";
                stmt = cn.prepareStatement(direccion, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, nombreAutor.getText());
                stmt.setString(2, apellidoAutor.getText());
                

                stmt.executeUpdate();
                rs = stmt.getGeneratedKeys();
                int id_autor = 0;
                if (rs.next()) {
                    id_autor = rs.getInt(1);
                }
                
                direccion = "INSERT INTO libro (activo, isbn, titulo, id_autor, id_editorial, paginas, edicion, codigo, costo, cantidad) VALUES (?,?,?,?,?,?,?,?,?,?);";
                stmt = cn.prepareStatement(direccion, Statement.RETURN_GENERATED_KEYS);
                
                stmt.setInt(1, 1);
                stmt.setInt(2, Integer.parseInt(isbnLibro.getText()));
                stmt.setString(3, tituloLibro.getText());
                stmt.setInt(4, id_autor);
                stmt.setInt(5, id_editorial);
                stmt.setInt(6, Integer.parseInt(paginasLibro.getText()));
                stmt.setInt(7, Integer.parseInt(edicionLibro.getText()));
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                String fecha = dateFormat.format(date);
                Date hour = new Date();
                DateFormat format = new SimpleDateFormat("HHmmss");
                String hora = format.format(hour);
                String codigo = tituloLibro.getText().substring(0,2)+isbnLibro.getText().substring(4,8)+fecha+hora;
                stmt.setString(8, codigo);
                stmt.setFloat(9, Float.parseFloat(costoRetail.getText()));
                stmt.setInt(10, Integer.parseInt(cantidadRetail.getText()));
                
                
                
                
                stmt.executeUpdate();
                stmt.close();
                datosTablaIncidencia();

                actualizabtn1.setVisible(true);
                insertarDato1.setVisible(true);
                
                idLibro.setText("");
                tituloLibro.setText("");
                isbnLibro.setText("");
                paginasLibro.setText("");
                edicionLibro.setText("");
                codigoLibro.setText("");
                nombreAutor.setText("");
                apellidoAutor.setText("");
                nombreEditorial.setText("");
                lugarEditorial.setText("");
                costoRetail.setText("");
                cantidadRetail.setText("");
                
                boxtipo1.setEnabled(false);
                boxtipo1.setSelectedIndex(1);

            } catch (SQLException ex) {
                //Excepción para error de SQL
                System.out.println(ex);
            }  catch (NullPointerException e2) {
                //Excepción para conexión con XAMPP
                JOptionPane.showMessageDialog(null, "La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.", "ERROR", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todas las casillas.", "ERROR", 0);
        }
    }//GEN-LAST:event_insertarDato1ActionPerformed

    private void boxtipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxtipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxtipo1ActionPerformed

    private void costoRetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoRetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costoRetailActionPerformed

    private void tableLibrosVenta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLibrosVenta1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableLibrosVenta1MouseClicked

    private void enviarDatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarDatoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_enviarDatoMouseEntered

    private void enviarDatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarDatoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_enviarDatoMouseExited

    private void enviarDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarDatoActionPerformed
        // TODO add your handling code here:
        String id=String.valueOf(tableclientes.getValueAt(tableclientes.getSelectedRow(), 0));
        for(int x=0;x<users.size();x++)
        {
            
            if(users.get(x).get(0).equals(id))
            {
                
                id_cliente.setText(users.get(x).get(0).toString());
                cliente_nombre.setText(users.get(x).get(1).toString()+" "+users.get(x).get(2).toString());
                id_cliente1.setText(users.get(x).get(0).toString());
                cliente_nombre1.setText(users.get(x).get(1).toString()+" "+users.get(x).get(2).toString());
                if(!id_cliente1.getText().equals("") && !id_libro1.getText().equals(""))
                {
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                    String fecha = dateFormat.format(date);
                    Date hour = new Date();
                    DateFormat format = new SimpleDateFormat("HHmmss");
                    String hora = format.format(hour);
                    String codigo = codigo_libro1.getText().substring(0,2)+cliente_nombre1.getText().substring(0,2)+fecha+hora;
                    codigoApartado.setText(codigo);
                }
            }
        }
        enviarDato.setEnabled(false);
    }//GEN-LAST:event_enviarDatoActionPerformed

    private void enviarDato1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarDato1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_enviarDato1MouseEntered

    private void enviarDato1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarDato1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_enviarDato1MouseExited

    private void enviarDato1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarDato1ActionPerformed
        // TODO add your handling code here:
        String titulo=String.valueOf(tableLibros.getValueAt(tableLibros.getSelectedRow(), 0));
        for(int x=0;x<incidencia.size();x++)
        {
            
            if(incidencia.get(x).get(1).equals(titulo))
            {
                id_libro.setText(incidencia.get(x).get(0).toString());
                codigo_libro.setText(incidencia.get(x).get(5).toString());
                costoLibro.setText(incidencia.get(x).get(10).toString());
                id_libro1.setText(incidencia.get(x).get(0).toString());
                codigo_libro1.setText(incidencia.get(x).get(5).toString());
                boxCantidad.removeAllItems();
                boxCantidad.addItem("Elija la cantidad...");
                boxCantidad1.removeAllItems();
                boxCantidad1.addItem("Elija la cantidad...");
                for (int i = 1; i <= Integer.parseInt(incidencia.get(x).get(11).toString()); i++) {
                    boxCantidad.addItem(i);
                    boxCantidad1.addItem(i);
                }
                if(!id_cliente1.getText().equals("") && !id_libro1.getText().equals(""))
                {
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                    String fecha = dateFormat.format(date);
                    Date hour = new Date();
                    DateFormat format = new SimpleDateFormat("HHmmss");
                    String hora = format.format(hour);
                    String codigo = codigo_libro1.getText().substring(0,2)+cliente_nombre1.getText().substring(0,2)+fecha+hora;
                    codigoApartado.setText(codigo);
                }

            }
        }
        enviarDato1.setEnabled(false);
    }//GEN-LAST:event_enviarDato1ActionPerformed

    private void btnAnt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnt3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnt3MouseClicked

    private void btnAnt3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnt3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnt3MouseEntered

    private void btnAnt3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnt3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnt3MouseExited

    private void btnAnt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnt3ActionPerformed
        // TODO add your handling code here:
        if(offset3!=0)
        {
            offset3-=10;
            datosTablaVenta();
            btnSig3.setEnabled(true);
            btnAnt3.setEnabled(true);
            if(offset3==0)
            {
                btnAnt3.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnAnt3ActionPerformed

    private void btnSig3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSig3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSig3MouseEntered

    private void btnSig3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSig3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSig3MouseExited

    private void btnSig3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSig3ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if((contarRowsIncidencia()-offset3)>10)
        {
            offset3+=10;
            datosTablaVenta();
            btnSig3.setEnabled(true);
            btnAnt3.setEnabled(true);
            if((contarRowsIncidencia()-offset3)<=10)
            {
                btnSig3.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnSig3ActionPerformed

    private void id_cliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_cliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_cliente1ActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (!codigoApartado.getText().equals("")) {
            // TODO add your handling code here:

            Connection cn;
            ConexionBD conected = new ConexionBD();
            cn = conected.conexion();
            try {

                String direccion = "INSERT INTO venta (id_cliente, id_libro, id_usuario, fecha, hora, cantidad, total) VALUES ((SELECT apartado.id_cliente FROM apartado WHERE apartado.codigo=?),(SELECT apartado.id_libro FROM apartado WHERE apartado.codigo=?),?,?,?,(SELECT apartado.cantidad FROM apartado WHERE apartado.codigo=?),(SELECT apartado.cantidad FROM apartado WHERE apartado.codigo=?)*(SELECT costo FROM libro WHERE id_libro=(SELECT apartado.id_libro FROM apartado WHERE apartado.codigo=?)));";
                PreparedStatement stmt = cn.prepareStatement(direccion);
                stmt.setString(1, codigoApartado.getText());
                stmt.setString(2, codigoApartado.getText());
                stmt.setInt(3, id_usuario);
                
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = dateFormat.format(date);
                stmt.setString(4, fecha);
                Date hour = new Date();
                DateFormat format = new SimpleDateFormat("HH:mm:ss");
                String hora = format.format(hour);
                stmt.setString(5, hora);
                stmt.setString(6, codigoApartado.getText());
                stmt.setString(7, codigoApartado.getText());
                stmt.setString(8, codigoApartado.getText());
                stmt.executeUpdate();

                stmt = cn.prepareStatement("UPDATE libro SET libro.cantidad=(libro.cantidad - (SELECT apartado.cantidad FROM apartado WHERE apartado.codigo=?)) WHERE libro.id_libro=(SELECT apartado.id_libro FROM apartado WHERE apartado.codigo=?);");
                stmt.setString(1, codigoApartado.getText());
                stmt.setString(2, codigoApartado.getText());
                stmt.executeUpdate();
                
                stmt = cn.prepareStatement("UPDATE apartado SET apartado.estado=0 WHERE apartado.codigo=? ;");
                stmt.setString(1, codigoApartado.getText());
                stmt.executeUpdate();
                stmt.close();
                

                datosTablaIncidencia();
                datosTablaVenta();
                datosTablaApartados();

                id_cliente1.setText("");
                cliente_nombre1.setText("");
                codigo_libro1.setText("");
                id_libro1.setText("");

                boxCantidad1.removeAllItems();

            } catch (SQLException ex) {
                //Excepción para error de SQL
                System.out.println(ex);
            } catch (java.lang.NumberFormatException e1) {
                //Excepción para alguna invalidez de numérica
                JOptionPane.showMessageDialog(null, "Ingrese solo números (interior/exterior y CP)", "ALERTA", 2);
            } catch (NullPointerException e2) {
                //Excepción para conexión con XAMPP
                JOptionPane.showMessageDialog(null, "La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.", "ERROR", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR", "Asegurese de haber elegido el cliente, libro y una cantidad a comprar...", 0);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void boxCantidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCantidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCantidad1ActionPerformed

    private void txtMunicipio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMunicipio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipio1ActionPerformed

    private void txtEstado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstado1ActionPerformed

    private void boxFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxFinalActionPerformed

    private void crearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearbtnActionPerformed
        // TODO add your handling code here:
        if (!txtCalle1.getText().equals("")
                && !txtNumero1.getText().equals("")
                && !txtColonia1.getText().equals("")
                && !txtCp1.getText().equals("")
                && !txtMunicipio1.getText().equals("")
                && !txtEstado1.getText().equals("")
                && boxAño.getSelectedIndex()!=0
                && boxDia.getSelectedIndex()!=0
                && boxMes.getSelectedIndex()!=0
                && boxInicio.getSelectedIndex()!=0
                && boxFinal.getSelectedIndex()!=0)
        {
            // TODO add your handling code here:
            crearbtn.setEnabled(true);
            editarbtn.setEnabled(false);
            eliminarbtn.setEnabled(false);
            Connection cn;
            ConexionBD conected = new ConexionBD();
            cn = conected.conexion();
            try {

                String direccion = "INSERT INTO direccion (numero, calle, colonia, cp, estado, municipio) VALUES (?,?,?,?,?,?);";
                PreparedStatement stmt = cn.prepareStatement(direccion, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, Integer.parseInt(txtNumero1.getText()));
                stmt.setString(2, txtCalle1.getText());
                stmt.setString(3, txtColonia1.getText());
                stmt.setInt(4, Integer.parseInt(txtCp1.getText()));
                stmt.setString(5, txtEstado1.getText());
                stmt.setString(6, txtMunicipio1.getText());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                int id_direccion = 0;
                if (rs.next()) {
                    id_direccion = rs.getInt(1);
                }
                direccion = "INSERT INTO evento (estado, fecha, horainicio, horafin, id_dirección) VALUES (1,?,?,?,?);";
                stmt = cn.prepareStatement(direccion, Statement.RETURN_GENERATED_KEYS);
                String fecha = boxAño.getSelectedItem().toString()+"-"+boxMes.getSelectedItem().toString()+"-"+boxDia.getSelectedItem().toString();
                System.out.println(fecha);
                stmt.setString(1, fecha);
                stmt.setString(2, boxInicio.getSelectedItem().toString()+":00");
                stmt.setString(3, boxFinal.getSelectedItem().toString()+":00");
                stmt.setInt(4, id_direccion);
                


                stmt.executeUpdate();
                stmt.close();
                datosTablaReportes();

                boxDia.setSelectedIndex(0);
                boxMes.setSelectedIndex(0);
                boxAño.setSelectedIndex(0);
                boxInicio.setSelectedIndex(0);
                boxFinal.setSelectedIndex(0);
                
                txtCalle1.setText("");
                txtNumero1.setText("");
                txtColonia1.setText("");
                txtCp1.setText("");
                txtMunicipio1.setText("");
                txtEstado1.setText("");


            } catch (SQLException ex) {
                //Excepción para error de SQL
                System.out.println(ex);
            } catch (java.lang.NumberFormatException e1) {
                //Excepción para alguna invalidez de numérica
                JOptionPane.showMessageDialog(null, "Ingrese solo números (interior/exterior y CP)", "ALERTA", 2);
            } catch (NullPointerException e2) {
                //Excepción para conexión con XAMPP
                JOptionPane.showMessageDialog(null, "La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.", "ERROR", 0);
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Complete todas las casillas.", "ERROR", 0);
        }
    }//GEN-LAST:event_crearbtnActionPerformed

    private void crearbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearbtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_crearbtnMouseExited

    private void crearbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearbtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_crearbtnMouseEntered

    private void boxDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxDiaActionPerformed

    private void boxInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxInicioActionPerformed
        // TODO add your handling code here:
        boxFinal.removeAllItems();
        for(int i=boxInicio.getSelectedIndex(); i<=24; i++)
        {
            boxFinal.addItem(String.format("%02d",i)+":00");
        }
          
        
        
        
    }//GEN-LAST:event_boxInicioActionPerformed

    private void boxAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxAñoActionPerformed

    private void boxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMesActionPerformed

    private void editarbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarbtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_editarbtnMouseEntered

    private void editarbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarbtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_editarbtnMouseExited

    private void editarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarbtnActionPerformed
        // TODO add your handling code here:
        
        
        if (!txtCalle1.getText().equals("")
                && !txtNumero1.getText().equals("")
                && !txtColonia1.getText().equals("")
                && !txtCp1.getText().equals("")
                && !txtMunicipio1.getText().equals("")
                && !txtEstado1.getText().equals("")
                && boxAño.getSelectedIndex()!=0
                && boxDia.getSelectedIndex()!=0
                && boxMes.getSelectedIndex()!=0
                && boxInicio.getSelectedIndex()!=0
                && boxFinal.getSelectedIndex()!=0) {
            Connection cn;
            ConexionBD conected = new ConexionBD();
            cn = conected.conexion();
            try {
                PreparedStatement stmt = cn.prepareStatement("UPDATE evento, direccion SET evento.fecha=?, evento.horainicio=?, evento.horafin=?, direccion.calle=?, direccion.numero=?, direccion.colonia=?, direccion.cp=?, direccion.municipio=?, direccion.estado=?  WHERE evento.id_evento=? AND evento.id_dirección=direccion.id_direccion;");
                String fecha = boxAño.getSelectedItem().toString()+"-"+boxMes.getSelectedItem().toString()+"-"+boxDia.getSelectedItem().toString();
                System.out.println(fecha);
                stmt.setString(1, fecha);
                stmt.setString(2, boxInicio.getSelectedItem().toString()+":00");
                stmt.setString(3, boxFinal.getSelectedItem().toString()+":00");
                stmt.setString(4, txtCalle1.getText());
                stmt.setInt(5, Integer.parseInt(txtNumero1.getText()));
                stmt.setString(6, txtColonia1.getText());
                stmt.setInt(7, Integer.parseInt(txtCp1.getText()));
                stmt.setString(8, txtEstado1.getText());
                stmt.setString(9, txtMunicipio1.getText());
                stmt.setInt(10, id_evento);
                
                boxDia.setSelectedIndex(0);
                boxMes.setSelectedIndex(0);
                boxAño.setSelectedIndex(0);
                boxInicio.setSelectedIndex(0);
                boxFinal.setSelectedIndex(0);
                
                txtCalle1.setText("");
                txtNumero1.setText("");
                txtColonia1.setText("");
                txtCp1.setText("");
                txtMunicipio1.setText("");
                txtEstado1.setText("");

                stmt.executeUpdate();
                stmt.close();
                datosTablaReportes();
            } catch (SQLException ex) {
                System.out.println(ex);
            } catch (java.lang.NullPointerException e2) {
                JOptionPane.showMessageDialog(null, "La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.", "ERROR", 0);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un dato de la tabla", "SIN DATOS", 2);
        }
    }//GEN-LAST:event_editarbtnActionPerformed

    private void eliminarbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarbtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarbtnMouseEntered

    private void eliminarbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarbtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarbtnMouseExited

    private void eliminarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarbtnActionPerformed
        // TODO add your handling code here:
        if (!txtCalle1.getText().equals("")
                && !txtNumero1.getText().equals("")
                && !txtColonia1.getText().equals("")
                && !txtCp1.getText().equals("")
                && !txtMunicipio1.getText().equals("")
                && !txtEstado1.getText().equals("")
                && boxAño.getSelectedIndex() != 0
                && boxDia.getSelectedIndex() != 0
                && boxMes.getSelectedIndex() != 0
                && boxInicio.getSelectedIndex() != 0
                && boxFinal.getSelectedIndex() != 0) {
            Connection cn;
            ConexionBD conected = new ConexionBD();
            cn = conected.conexion();
            try {
                PreparedStatement stmt = cn.prepareStatement("UPDATE evento SET evento.estado=0  WHERE evento.id_evento=? ;");
    
                stmt.setInt(1, id_evento);

                boxDia.setSelectedIndex(0);
                boxMes.setSelectedIndex(0);
                boxAño.setSelectedIndex(0);
                boxInicio.setSelectedIndex(0);
                boxFinal.setSelectedIndex(0);

                txtCalle1.setText("");
                txtNumero1.setText("");
                txtColonia1.setText("");
                txtCp1.setText("");
                txtMunicipio1.setText("");
                txtEstado1.setText("");

                stmt.executeUpdate();
                stmt.close();
                datosTablaReportes();
            } catch (SQLException ex) {
                System.out.println(ex);
            } catch (java.lang.NullPointerException e2) {
                JOptionPane.showMessageDialog(null, "La aplicación usa Bases de Datos mediante XAMPP, por favor active la aplicación para su correcto funcionamiento.", "ERROR", 0);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un dato de la tabla", "SIN DATOS", 2);
        }
    }//GEN-LAST:event_eliminarbtnActionPerformed

    private void tableLibrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLibrosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tableLibrosMouseEntered
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
    public void datosTablaApartados()
    {
        Object datos1[][]=new Object[10][5];
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT CONCAT(cliente.nombre, ' ', cliente.apellido) as nombre, CONCAT(direccion.calle, ' #', direccion.numero, '. Colonia ', direccion.colonia, '. ',direccion.cp) as direccion, libro.titulo, apartado.cantidad, apartado.codigo FROM apartado, cliente, libro, direccion WHERE apartado.id_cliente=cliente.id_cliente AND apartado.id_libro=libro.id_libro AND cliente.id_direccion = direccion.id_direccion AND apartado.estado = 1");
            ResultSet resultado = stmt.executeQuery();
            apartados = new ArrayList();
            while(resultado.next())
            {
                apartados.add(new ArrayList<>());
                datos1[i][0]=resultado.getString("nombre");
                datos1[i][1]=resultado.getString("direccion");
                datos1[i][2]=resultado.getString("titulo");
                datos1[i][3]=resultado.getString("cantidad");
                datos1[i][4]=resultado.getString("codigo");
                
                apartados.get(i).add(resultado.getString("nombre"));
                apartados.get(i).add(resultado.getString("direccion"));
                apartados.get(i).add(resultado.getString("titulo"));
                apartados.get(i).add(resultado.getString("cantidad"));
                apartados.get(i).add(resultado.getString("codigo"));
                
                i++;
            }
            
            tableApartar.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos6));
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
        Object datos1[][]=new Object[10][7];
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT * FROM libro, autor, editorial WHERE libro.id_autor = editorial.id_editorial AND libro.id_autor = autor.id_autor LIMIT "+limit2+" OFFSET "+offset2);
            ResultSet resultado = stmt.executeQuery();
            incidencia = new ArrayList();
            while(resultado.next())
            {
                incidencia.add(new ArrayList<>());
                datos1[i][0]=resultado.getString("titulo");
                datos1[i][1]=resultado.getString("codigo");
                datos1[i][2]=resultado.getString("cantidad");
                datos1[i][3]=resultado.getString("costo");
                
                incidencia.get(i).add(resultado.getString("id_libro"));
                incidencia.get(i).add(resultado.getString("titulo"));
                incidencia.get(i).add(resultado.getString("isbn"));
                incidencia.get(i).add(resultado.getString("paginas"));
                incidencia.get(i).add(resultado.getString("edicion"));
                incidencia.get(i).add(resultado.getString("codigo"));
                incidencia.get(i).add(resultado.getString("nombre"));
                incidencia.get(i).add(resultado.getString("apellido"));
                incidencia.get(i).add(resultado.getString("editorial"));
                incidencia.get(i).add(resultado.getString("lugar"));
                incidencia.get(i).add(resultado.getString("costo"));
                incidencia.get(i).add(resultado.getString("cantidad"));
                incidencia.get(i).add(resultado.getString("activo"));
                
                i++;
            }
            stmt.close();
            tableLibros.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos2));
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
    public void datosTablaVenta()
    {
        Object datos1[][]=new Object[10][7];
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT usuario.usuario, cliente.nombre, cliente.apellido, libro.titulo, venta.cantidad, venta.total, venta.fecha, venta.hora FROM venta, usuario, cliente, libro WHERE venta.id_cliente=cliente.id_cliente AND venta.id_libro = libro.id_libro AND venta.id_usuario = usuario.id_usuario LIMIT "+limit3+" OFFSET "+offset3);
            ResultSet resultado = stmt.executeQuery();
           
            while(resultado.next())
            {
                
                datos1[i][0]=resultado.getString("usuario");
                datos1[i][1]=resultado.getString("nombre")+" "+resultado.getString("apellido");
                datos1[i][2]=resultado.getString("titulo");
                datos1[i][3]=resultado.getString("cantidad");
                datos1[i][4]=resultado.getString("total");
                datos1[i][5]=resultado.getString("fecha");
                datos1[i][6]=resultado.getString("hora");
                

                
                i++;
            }
            stmt.close();
            tableLibrosVenta1.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos5));
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
        Object datos1[][]=new Object[10][9];
        int i=0;
        Connection cn;
        ConexionBD conected=new ConexionBD();
        cn=conected.conexion();
        try
        {
            PreparedStatement stmt=cn.prepareStatement("SELECT evento.fecha,evento.horainicio,evento.horafin,direccion.calle, direccion.numero, direccion.colonia, direccion.cp, direccion.municipio, direccion.estado, evento.id_evento FROM evento, direccion WHERE evento.id_dirección=direccion.id_direccion AND evento.estado=1 LIMIT "+limit4+" OFFSET "+offset4);
            ResultSet resultado = stmt.executeQuery();
            evento = new ArrayList();
            while(resultado.next())
            {
                evento.add(new ArrayList<>());
                datos1[i][0]=resultado.getString(1);
                datos1[i][1]=resultado.getString(2);
                datos1[i][2]=resultado.getString(3);
                datos1[i][3]=resultado.getString(4);
                datos1[i][4]=resultado.getString(5);
                datos1[i][5]=resultado.getString(6);
                datos1[i][6]=resultado.getString(7);
                datos1[i][7]=resultado.getString(8);
                datos1[i][8]=resultado.getString(9);
                evento.get(i).add(resultado.getString(1));
                evento.get(i).add(resultado.getString(2));
                evento.get(i).add(resultado.getString(3));
                evento.get(i).add(resultado.getString(4));
                evento.get(i).add(resultado.getString(5));
                evento.get(i).add(resultado.getString(6));
                evento.get(i).add(resultado.getString(7));
                evento.get(i).add(resultado.getString(8));
                evento.get(i).add(resultado.getString(9));
                evento.get(i).add(resultado.getString(10));
                
                i++;
            }
            stmt.close();
            tableReporte.setModel(new javax.swing.table.DefaultTableModel(datos1,titulos3));
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
            PreparedStatement stmt=cn.prepareStatement("SELECT COUNT(*) AS rowcount FROM cliente ");
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
            PreparedStatement stmt=cn.prepareStatement("SELECT COUNT(*) AS rowcount FROM venta ");
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
            PreparedStatement stmt=cn.prepareStatement("SELECT COUNT(*) AS rowcount FROM evento ");
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
    private javax.swing.JToggleButton actualizabtn;
    private javax.swing.JToggleButton actualizabtn1;
    private javax.swing.JTextField apellidoAutor;
    private javax.swing.JComboBox boxAño;
    private javax.swing.JComboBox boxCantidad;
    private javax.swing.JComboBox boxCantidad1;
    private javax.swing.JComboBox boxDia;
    private javax.swing.JComboBox boxFinal;
    private javax.swing.JComboBox boxInicio;
    private javax.swing.JComboBox boxMes;
    private javax.swing.JComboBox boxtipo;
    private javax.swing.JComboBox boxtipo1;
    private javax.swing.JButton btnAnt2;
    private javax.swing.JButton btnAnt3;
    private javax.swing.JButton btnAnteriorRep;
    private javax.swing.JButton btnDescRep;
    private javax.swing.JButton btnSig2;
    private javax.swing.JButton btnSig3;
    private javax.swing.JButton btnSigRep;
    private javax.swing.JTextField cantidadRetail;
    private javax.swing.JTextField cliente_nombre;
    private javax.swing.JTextField cliente_nombre1;
    private javax.swing.JTextField codigoApartado;
    private javax.swing.JTextField codigoLibro;
    private javax.swing.JTextField codigo_libro;
    private javax.swing.JTextField codigo_libro1;
    private javax.swing.JTextField costoLibro;
    private javax.swing.JTextField costoRetail;
    private javax.swing.JButton crearbtn;
    private javax.swing.JTextField edicionLibro;
    private javax.swing.JButton editarbtn;
    private javax.swing.JButton eliminarbtn;
    private javax.swing.JToggleButton enviarDato;
    private javax.swing.JToggleButton enviarDato1;
    private javax.swing.JTextField idLibro;
    private javax.swing.JTextField id_cliente;
    private javax.swing.JTextField id_cliente1;
    private javax.swing.JTextField id_libro;
    private javax.swing.JTextField id_libro1;
    private javax.swing.JToggleButton insertarDato;
    private javax.swing.JToggleButton insertarDato1;
    private javax.swing.JTextField isbnLibro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
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
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField lugarEditorial;
    private javax.swing.JTextField nombreAutor;
    private javax.swing.JTextField nombreEditorial;
    private javax.swing.JToggleButton nuevoDato;
    private javax.swing.JToggleButton nuevoDato1;
    private javax.swing.JTextField paginasLibro;
    private javax.swing.JButton sig;
    private javax.swing.JTabbedPane tabbed;
    private javax.swing.JTable tableApartar;
    private javax.swing.JTable tableLibros;
    private javax.swing.JTable tableLibrosVenta1;
    private javax.swing.JTable tableReporte;
    private javax.swing.JTable tableclientes;
    private javax.swing.JTextField tituloLibro;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCalle1;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtColonia1;
    private javax.swing.JTextField txtCp;
    private javax.swing.JTextField txtCp1;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstado1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtMunicipio1;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtNumero1;
    private javax.swing.JTextField txtTotal;
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
