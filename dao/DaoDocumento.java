
package com.mycompany.gestiondocumentalfesc.dao;

import com.mycompany.gestiondocumentalfesc.Modelos.Documento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoDocumento extends Conexion implements IDaoDocumento {

    @Override
    public boolean registrarDocumento(Documento documento) {
        
        String sql= "INSERT INTO "+Constantes.T_DOCUMENTO+"("+
                    Constantes.TD_ARCHIVOPDF+","+
                    Constantes.TD_FECHA+","+
                    Constantes.TD_NUMERORADICADO+","+
                    Constantes.TD_TIPORADICADO+","+
                    Constantes.TD_ASUNTO+","+
                    Constantes.TD_ANEXO+","+
                    Constantes.TD_REQRESPUESTA+","+
                    Constantes.TD_CLASEDOCUMENTO+","+
                    Constantes.TD_REMITENTEID+","+
                    Constantes.TD_ENCARGADOID+","+
                    Constantes.TD_RESPUESTAID+") VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            
            try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ps.setInt(1, documento.getId());
            ps.setBytes(2, documento.getArchivoPdf());
            ps.setDate(3, documento.getFecha());
            ps.setString(4, documento.getNumRadicado());
            ps.setBoolean(5, documento.isTipoRadicado());
            ps.setString(6, documento.getAsunto());
            ps.setString(7, documento.getAnexos());
            ps.setBoolean(8, documento.isReqRespuesta());
            ps.setString(9, documento.getClaseDocumento());
            ps.setInt(10, documento.getRemitenteId());
            ps.setInt(11, documento.getEncargadoId());
            ps.setInt(12, documento.getRespuestaId());
            ps.executeUpdate();
            
            System.out.println("Documento registrado con exito");
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al subir el documento "+e.getMessage());
            return false;
        }finally{
            try {
                getConexion().close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion "+e);
            }
        }
    }

    @Override
    public boolean documentoRegistrado(Documento documento) {
        
        String sql= "SELECT * FROM "+
                    Constantes.T_DOCUMENTO+
                    " WHERE "+Constantes.TD_ASUNTO+"='"+documento.getAsunto()+"'";
            
            try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {                
                
                documento.setId(resultSet.getInt(Constantes.TD_IDDOCUMENTO));
                documento.setArchivoPdf(resultSet.getBytes(Constantes.TD_ARCHIVOPDF));
                documento.setFecha(resultSet.getDate(Constantes.TD_FECHA));
                documento.setNumRadicado(resultSet.getString(Constantes.TD_NUMERORADICADO));
                documento.setTipoRadicado(resultSet.getBoolean(Constantes.TD_TIPORADICADO));
                documento.setTipoRadicado(resultSet.getBoolean(Constantes.TD_TIPORADICADO));
                documento.setAsunto(resultSet.getString(Constantes.TD_ASUNTO));
                documento.setAnexos(resultSet.getString(Constantes.TD_ANEXO));
                documento.setReqRespuesta(resultSet.getBoolean(Constantes.TD_REQRESPUESTA));
                documento.setClaseDocumento(resultSet.getString(Constantes.TD_CLASEDOCUMENTO));
                documento.setRemitenteId(resultSet.getInt(Constantes.TD_REMITENTEID));
                documento.setEncargadoId(resultSet.getInt(Constantes.TD_ENCARGADOID));
                documento.setRespuestaId(resultSet.getInt(Constantes.TD_RESPUESTAID));
                
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e.getMessage());
            return false;
        }finally{
            try {
                getConexion().close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion "+e);
            }
        }
    }

    @Override
    public boolean consultarDocumento(Documento documento) {
        String sql= "SELECT '"+Constantes.TD_CLASEDOCUMENTO+"', '"+
                    Constantes.TD_REMITENTEID+"', '"+
                    Constantes.TD_ENCARGADOID+"', '"+
                    Constantes.TD_ARCHIVOPDF+"' FROM "+
                    Constantes.T_DOCUMENTO+" WHERE "+ Constantes.TD_IDDOCUMENTO+
                    "= :"+Constantes.TD_IDDOCUMENTO;
            
            try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {                
                
                documento.setClaseDocumento(resultSet.getString(Constantes.TD_CLASEDOCUMENTO));
                documento.setRemitenteId(resultSet.getInt(Constantes.TD_REMITENTEID));
                documento.setEncargadoId(resultSet.getInt(Constantes.TD_ENCARGADOID));
                documento.setArchivoPdf(resultSet.getBytes(Constantes.TD_ARCHIVOPDF));
                
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.out.println("Error al traer los datos "+e.getMessage());
            return false;
        }finally{
            try {
                getConexion().close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion "+e);
            }
        }
    }
    
}
