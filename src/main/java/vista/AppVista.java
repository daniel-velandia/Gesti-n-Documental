
package com.mycompany.gestiondocumenta.vista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AppVista {
    
    public String getInicioApp() {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("***\nGESTION DOCUMENTAL***" +
                           "\n1. INICIO" +
                           "\n2. INGRESAR USUARIO"+
                           "\n3. REGISTRAR" +
                           "\n4. CONSULTAR");
        return teclado.nextLine();
    }
    
    public String getEntrada(String texto){
        
        Scanner teclado=new Scanner(System.in);
        
        System.out.println(texto);
        
        return teclado.nextLine();
    }
    
    public void setTexto(String texto){
        
        System.out.println(texto);
    }
    //*****CODIGO PARA MOSTRAR LOS DOCUMENTOS CUANDO SE CONSULTAN*****
    //Se hace en el controlador
        /*public DefaultTableModel mostrarDocumento() {
            String [] nombresColumnas = {"Datos de cocumento", "Datos Remitente", "Datos Encargado", "Descargar"};
            String [] registros = new String[4];
            
            DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
            
            String sql = "SELECT * FROM documento";
            
            Connection cn = null; 
            
            PreparedStatement pst = null;
            
            ResultSet rs = null;
            
            try {
                cn = Conexion.conectar(); //Conexion es una clase en modelos y hay un metodo Conexion
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                
                while(rs.next()) {
                    registros[0] = rs.getString("Datos de documento");
                    registros[1] = rs.getString("Datos Remitente");
                    registros[2] = rs.getString("Datos Encargado");
                    registros[3] = rs.getString("Descargar");
                    
                    modelo.addRow(registros);
                }
            }
            catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");
            }
            finally {
                try {
                    if(rs != null)
                        rs.close();
                    if(pst != null)
                        pst.close();
                    if(cn != null)
                        cn.close();
                }
                catch(SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            return modelo;
        }
   */
        
        
        public void setMostrarDocumento() {
        
        
    }
    
}
