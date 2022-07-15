package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserMenu extends javax.swing.JFrame{

    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    DefaultTableModel contenidoTablaEmpleados;

    public UserMenu() {
	initComponents();
	setLocationRelativeTo(null);
	listarEmpleados();

    }

    private void listarEmpleados(){
	String filtroBusqueda = txtSearch.getText();
	if (filtroBusqueda.isEmpty()){
	    
	    String queryConsulta = "SELECT * FROM empleados";

	    try {
		connection = conexion.getConnection();
		st = connection.createStatement();
		rs = st.executeQuery(queryConsulta);

		Object[] empleados = new Object[6];
		contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
		while (rs.next()) {
		    empleados[0] = rs.getInt("idEmp");
		    empleados[1] = rs.getString("nombreEmp");
		    empleados[2] = rs.getString("apellidos");
		    empleados[3] = rs.getString("tipoDocumento");
		    empleados[4] = rs.getString("documento");
		    empleados[5] = rs.getString("correo");
		    //
		    contenidoTablaEmpleados.addRow(empleados);
		    System.out.println("id: " + empleados[0] + ", nombre: " + empleados[1] + " " + ",apellidos: " + empleados[2] + ",tipoDocumento: " + empleados[3] + ",documento: " + empleados[4] + ",correo: " + empleados[5]);
		    tblEmpleados.setModel(contenidoTablaEmpleados);
		}
	    } catch (SQLException e) {
		System.out.println("Error");
	    }
	} else {
	    String queryConsulta = "SELECT * FROM empleados WHERE nombreEmp LIKE '%"+filtroBusqueda+"%' OR apellidos LIKE '%"+filtroBusqueda+"%'";
	    System.out.println(queryConsulta);
	    
	    try {
		connection = conexion.getConnection();
		st = connection.createStatement();
		rs = st.executeQuery(queryConsulta);

		Object[] empleados = new Object[6];
		contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
		while (rs.next()) {
		    empleados[0] = rs.getInt("idEmp");
		    empleados[1] = rs.getString("nombreEmp");
		    empleados[2] = rs.getString("apellidos");
		    empleados[3] = rs.getString("tipoDocumento");
		    empleados[4] = rs.getString("documento");
		    empleados[5] = rs.getString("correo");
		    //
		    contenidoTablaEmpleados.addRow(empleados);
		    System.out.println("id: " + empleados[0] + ", nombre: " + empleados[1] + " " + ",apellidos: " + empleados[2] + ",tipoDocumento: " + empleados[3] + ",documento: " + empleados[4] + ",correo: " + empleados[5]);
		    tblEmpleados.setModel(contenidoTablaEmpleados);
		}
	    } catch (SQLException e) {
		System.out.println("Error");
	    }
	    
	}
    }	    

    
    private void borrarDatosTabla(){
	for (int i = 0; i < tblEmpleados.getRowCount(); i ++){
	    contenidoTablaEmpleados.removeRow(i);
	    i -= 1;
	}
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(634, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Informacion Empleados");

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre(s)", "Apellido(s)", "Tipo documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        btnAddUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Crear.png"))); // NOI18N
        btnAddUser.setText("Crear Empleado");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nombre:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(286, 286, 286))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(164, 164, 164)
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAddUser)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)))
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(634, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Linea de Ventas", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(634, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
    
    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // TODO add your handling code here:
	AddUserForm addUserF = new AddUserForm(this,true);
	addUserF.setVisible(true);
	borrarDatosTabla();
	listarEmpleados();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
	int row = tblEmpleados.getSelectedRow();
	System.out.println("Fila seleccionada n°: " + row);
	//Validar
	if(row < 0){
	     JOptionPane.showMessageDialog(this,"Seleccione un empleado", " ", JOptionPane.WARNING_MESSAGE);
        }else{
	    int idEmp = Integer.parseInt(tblEmpleados.getValueAt(row, 0).toString());
	    String nombreEmp = tblEmpleados.getValueAt(row,1).toString();
	    String apellidos = tblEmpleados.getValueAt(row,2).toString();
	    String tipoDocumento = tblEmpleados.getValueAt(row,3).toString();
	    String documento = tblEmpleados.getValueAt(row,4).toString();
	    String correo= tblEmpleados.getValueAt(row,5).toString();
	    
	    System.out.println("idEmp: " + idEmp + ", nombre: " + nombreEmp + " " + apellidos + ", documento: " +
		    tipoDocumento + " " + documento + ",correo: " + correo );
	    
	    ShowUserForm showUserForm = new ShowUserForm(this,true);
	    showUserForm.recibeDatos(idEmp, nombreEmp, apellidos, tipoDocumento, documento, correo);
	    showUserForm.setVisible(true);
	    //
	    borrarDatosTabla();
	    listarEmpleados();
	    
	}
	   	
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarDatosTabla();
	listarEmpleados();
    }//GEN-LAST:event_jButton1ActionPerformed

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
	    java.util.logging.Logger.getLogger(UserMenu.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	

} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(UserMenu.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	

} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(UserMenu.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(UserMenu.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable()
	  {
	    public void run() {
		new UserMenu().setVisible(true);
	    }
	  });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
  }
