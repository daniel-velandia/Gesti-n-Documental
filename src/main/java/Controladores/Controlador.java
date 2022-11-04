
package Controladores;

import Modelos.*;
import dao.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    
    // modelo
    Estudiante estudiante;
    Compania compania;
    Encargado encargado;
    Documento documento;
    Documentista documentista;
    Datos datos;
    // Login login;
    
    // Dao
    IDaoEstudiante daoEstudiante;
    IDaoCompania daoCompania;
    IDaoEncargado daoEncargado;
    IDaoDocumento daoDocumento;
    IDaoDocumentista daoDocumentista;
    // IDaoLogin daoLogin;
    
    // Vista
    JFrame jFrame;
    DefaultListModel listModelTipoRemitente, listModelFiltro, listModelTipoRadicado;
    DefaultTableModel tableModelConsulta;
    
    JFileChooser jfc;
    String rutaArchivo;

    public Controlador(JFrame jFrame) {
        this.estudiante = new Estudiante();
        this.compania = new Compania();
        this.encargado = new Encargado();
        this.documento = new Documento();
        this.documentista = new Documentista();
        this.datos = new Datos();
        
        this.daoEstudiante = new DaoEstudiante();
        this.daoCompania = new DaoCompania();
        this.daoEncargado = new DaoEncargado();
        this.daoDocumento = new DaoDocumento();
        this.daoDocumentista = new DaoDocumentista();
        
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
            
            String identificacion = jFrame.jtfIdentificacion.getText();
            String tipoRemitente = getJcbTipoRemitente();
            String filtro = getJcbFiltro();
            String fecha = jFrame.jsFecha.getText();
            
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
            
        } else if (e.getSource() == jFrame.jrbEstudiante || e.getSource() == jFrame.jrbCompania) {
        
            SelecionarRemitente();
            
        } else if (e.getSource() == jFrame.jtbRegistrar) {
            
            String asunto = jFrame.jtaAsunto.getText();
            String numRadicado = jFrame.jtfNumRadicado.getText();
            String fecha = jFrame.jsFecha.getText();
            String anexos = jFrame.jtfAnexos.getText();
            boolean tipoRadicado;
            int tipoDocumento;
            boolean reqRespuesta = false;
            
            switch(jFrame.jcbTipoRadicado.getSelectedItem()) {
                case "Entrega":
                    tipoRadicado = true;
                    break;
                case "Respuesta":
                    tipoRadicado = false;
                    break;
            }
            
            switch(jFrame.jcbTipoDocumento.getSelectedItem()) {
                case "Carta":
                    tipoDocumento = 1;
                    break;
                case "Solicitud":
                    tipoDocumento = 2;
                    break;
                case "Derecho de petición":
                    tipoDocumento = 3;
                    break;
                case "Citacion":
                    tipoDocumento = 4;
                    break;
                case "Memorando":
                    tipoDocumento = 5;
                    break;
                case "Caja":
                    tipoDocumento = 6;
                    break;
                case "Factura":
                    tipoDocumento = 7;
                    break;
                case "Remisión":
                    tipoDocumento = 8;
                    break;
                case "Paquete":
                    tipoDocumento = 9;
                    break;
            }
            
            if(jcbReqRespuesta.isSelected()) {
                reqRespuesta = true;
            }
            
            documento = new Documento();
            
            String documentoRem = jFrame.jtfDocRemitente.getText();
            String nombresRem = jFrame.jtfNombresRemitente.getText();
            String apellidosRem = jFrame.jtfApellidosRemitente.getText();
            String correoRem = jFrame.jtfCorreoRemitente.getText();
            String telefonoRem = jFrame.jtfTelefonoRemitente.getText();
            
            if (jrbEstudiante.isSelected()) {
                
                int carrera;
                
                switch(jFrame.jcbCarreraEstudiante.getSelectedItem()) {
                    case "Diseño grafico":
                        carrera = 1;
                        break;
                    case "Diseño de modas":
                        carrera = 2;
                        break;
                    case "Hoteleria y turismo":
                        carrera = 3;
                        break;
                    case "Ingenieria de software":
                        carrera = 4;
                        break;
                    case "Negocios internacionales":
                        carrera = 5;
                        break;
                    case "Administracion financiera":
                        carrera = 6;
                        break;
                    case "Logistica empresarial":
                        carrera = 7;
                        break;
                    default:
                        carrera = 0;
                        break;
                }
                
                int semestre = Integer.parseInt(jFrame.jtfSemestre.getText());
                
                estudiante = new Estudiante(carrera, semestre, documentoRem, nombresRem, apellidosRem, correoRem, telefonoRem);
                
            } else if (jrbCompania.isSelected()) {
                
                String nombreCompania = jFrame.jtfNombreCompania.getText();
                String nit = jFrame.jtfNit.getText();
                
                compania = new Compania(nombreCompania, nit, documentoRem, nombresRem, apellidosRem, correoRem, telefonoRem);
                        
            } else {
                
            }
            
            String DocumentoEncargado = jFrame.jtfDocEncargado.getText();
            String nombresEncargado = jFrame.jtfNombresEncargado.getTExt();
            String apellidosEncargado = jFrame.jtfApellidosEncargado.getText();
            String correoEncargado = jFrame.jtfCorreoEncargado.getText();
            String telefonoEncargado = jFrame.jtfTelefonoEncargado.getTExt();
            
        } 
    }
    
    public void seleccionarPdf() {
 
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("pdf", "pdf");
        jfc.setFileFilter(filtro);
        
        int opcion = jfc.showOpenDialog(jFrame);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            
            documento.setNombreArchivo(jfc.getSelectedFile().getName());
            rutaArchivo = jfc.getSelectedFile().getPath();
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
    
    public void SelecionarRemitente() {
        
        if (jFrame.jrbEstudiante.isSelected()) {
            
            jFrame.jtfCarrera.setEnable(true);
            jFrame.jtfSemestre.setEnable(true);
            
            jFrame.jtfNombreCompania.setEnable(false);
            jFrame.jtfNit.setEnable(false);
            
        } else {
            
            jFrame.jtfCarrera.setEnable(false);
            jFrame.jtfSemestre.setEnable(false);
            
            jFrame.jtfNombreCompania.setEnable(true);
            jFrame.jtfNit.setEnable(true);
            
        }
    }
}
