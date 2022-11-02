
package Controladores;

import Modelos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    
    // modelo
    Estudiante estudiante;
    Encargado encargado;
    Compania compania;
    Documento documento;
    Datos datos;
    
    // Dao
    
    // Vista
    JFrame jFrame;
    DefaultListModel listModelTipoRemitente, listModelFiltro, listModelTipoRadicado;
    DefaultTableModel tableModelConsulta;
    
    JFileChooser jfc;

    public Controlador(JFrame jFrame) {
        this.estudiante = new Estudiante();
        this.encargado = new Encargado();
        this.compania = new Compania();
        this.documento = new Documento();
        this.jFrame = jFrame;
        this.listModelTipoRemitente = new DefaultListModel();
        this.listModelFiltro = new DefaultListModel();
        this.listModelTipoRadicado = new DefaultListModel();
        this.tableModelConsulta = new DefaultTableModel();
        this.jfc  = new JFileChooser();
    }
    
    public void iniciar() {
        
        addColumnConsulta();
        setJcbTipoRemitente();
        setJcbFiltro();
    }
    
    public void mostrarConsulta(Datos datos) {
        
        if (tableModelConsulta.getRowCount() > 0) {
            for (int i = 0; i < tableModelConsulta.getRowCount(); i++) {
                tableModelConsulta.removeRow(i);
            }
        }
        
        for (int i = 0; i < datos.getArrayListDocumentos().size(); i++) {
            String[] d = new String[10];
            
            if (datos.getArrayListEstudiantes().size() > 0) {
                
                d[0] = datos.getArrayListEstudiantes().get(i).getNombres();
                d[1] = datos.getArrayListEstudiantes().get(i).getCorreo();
                
                switch (datos.getArrayListEstudiantes().get(i).getCarrera()) {
                    case 1:
                        d[2] = "Diseño grafico";
                        break;
                    case 2:
                        d[2] = "Diseño de modas";
                        break;
                    case 3:
                        d[2] = "Hoteleria y turismo";
                        break;
                    case 4:
                        d[2] = "Ingenieria de software";
                        break;
                    case 5:
                        d[2] = "Negocios internacionales";
                        break;
                    case 6:
                        d[2] = "Administracion financiera";
                        break;
                    case 7:
                        d[2] = "Logistica empresarial";
                        break;
                    default:
                        d[2] = "N/A";
                        break;
                }
            } else {
                
                d[0] = datos.getArrayListCompanias().get(i).getNombres();
                d[1] = datos.getArrayListCompanias().get(i).getCorreo();
                d[2] = datos.getArrayListCompanias().get(i).getNombreCompañia();
            }
            
            d[3] = String.valueOf(datos.getArrayListDocumentos().get(i).getArchivoPdf().length);
            d[4] = datos.getArrayListDocumentos().get(i).getNumRadicado();
            d[5] = String.valueOf(datos.getArrayListDocumentos().get(i).getFecha());
            d[6] = String.valueOf(datos.getArrayListDocumentos().get(i).getRespuestaId());
            
            d[7] = datos.getArrayListEncargados().get(i).getNombres();
            d[8] = datos.getArrayListEncargados().get(i).getCorreo();
            d[9] = datos.getArrayListEncargados().get(i).getArea();
            
            tableModelConsulta.addRow(d);
            
            jFrame.jtConsulta.setModel(tableModelConsulta);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == jFrame.jtbConsultar) {
            
            String identificacion = jFrame.identificacion.getText();
            String tipoRemitente = getJcbTipoRemitente();
            String filtro = getJcbFiltro();
            Date fecha = jFrame.jdcFecha.getDate();
            
            if (!identificacion.equals("") && !tipoRemitente.equals("")) {
                
                datos = IDaoDocumento.getDocumentos;
                
                if (!filtro.equals("")) {
                    datos = IDaoDocumento.filtrarPorTipo(filtro, datos);
                }

                if (!fecha.equals("")) {
                    datos = IDaoDocumento.FiltrarPorFecha(fecha, datos);
                }
                
                mostrarConsulta(datos);
                
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar la identificacion y el tipo de remitente para hacer la busqueda");
            }
            
        } else if (e.getSource() == jFrame.jtbSeleccionarArchivo) {
            
            seleccionarPdf();
            
        } else if (e.getSource() == jFrame.jtbRegistrar) {
            
            if (getJcbTipoRemitente().equals("Estudiante")) {
                
            } else {
                
            }
        } 
    }
    
    public void seleccionarPdf() {
 
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("pdf", "pdf");
        jfc.setFileFilter(filtro);
        
        int opcion = jfc.showOpenDialog(jFrame);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            
            String nombreArchivo = jfc.getSelectedFile().getName();
            String rutaArchivo = jfc.getSelectedFile().getPath();
        }
    }
    
    public String getJcbTipoRemitente() {
        return jFrame.jcbTipoRemitente.getSelectedItem().toString();
    }
    
    public void setJcbTipoRemitente() {
        jFrame.jcbTipoRemitente.removeAllItems();
        jFrame.jcbTipoRemitente.addItem("Seleccionar");
        jFrame.jcbTipoRemitente.addItem("Estudiante");
        jFrame.jcbTipoRemitente.addItem("Compañia");
    }
    
    public String getJcbFiltro() {
        return jFrame.jcbFiltro.getSelectedItem().toString();
    }
    
    public void setJcbFiltro() {
        jFrame.jcbFiltro.removeAllItems();
        jFrame.jcbFiltro.addItem("Seleccionar");
        jFrame.jcbFiltro.addItem("Todos los radicados");
        jFrame.jcbFiltro.addItem("Radicados de entrega con respuesta");
        jFrame.jcbFiltro.addItem("Solo radicados de entrega");
        jFrame.jcbFiltro.addItem("Solo radicados de respuesta");
    }
    
    public void limpiarTexto() {
        jFrame.jcbTipoRemitente.setSelectedIndex();
        jFrame.jcbFiltro.setSelectedIndex();
        jFrame.identificacion.setText(null);
        jfc = new JFileChooser();
    }
    
    public void addColumnConsulta() {
        
        tableModelConsulta.addColumn("remitente");
        tableModelConsulta.addColumn("remitente");
        tableModelConsulta.addColumn("remitente");
        
        tableModelConsulta.addColumn("documento");
        tableModelConsulta.addColumn("radicado");
        tableModelConsulta.addColumn("fecha");
        tableModelConsulta.addColumn("respuesta");
        tableModelConsulta.addColumn("encargado");
        tableModelConsulta.addColumn("correo");
        tableModelConsulta.addColumn("area");
    }
}
