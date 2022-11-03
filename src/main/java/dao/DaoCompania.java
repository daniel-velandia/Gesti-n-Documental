
package com.mycompany.gestiondocumentalfesc.dao;

import com.mycompany.gestiondocumentalfesc.Modelos.Compania;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCompania extends Conexion implements IDaoCompania{

    @Override
    public boolean registrarCompania(Compania compania) {
        String sql= "INSERT INTO"+Constantes.T_COMPANIA+"("+
                    Constantes.TC_DOCUMENTO+","+
                    Constantes.TC_NOMBRES+","+
                    Constantes.TC_APELLIDOS+","+
                    Constantes.TC_CORREO+","+
                    Constantes.TC_TELEFONO+","+
                    Constantes.TC_NOMBRECOMPANIA+","+
                    Constantes.TC_NIT+") VALUES(?,?,?,?,?,?,?)";
            
            try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ps.setString(1, compania.getDocumento());
            ps.setString(2, compania.getNombres());
            ps.setString(3, compania.getApellidos());
            ps.setString(4, compania.getCorreo());
            ps.setString(5, compania.getTelefono());
            ps.setString(6, compania.getNombreCompañia());
            ps.setString(7, compania.getNit());
            ps.executeUpdate();
            
            System.out.println("Compania creada con exito");
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al crear la compania "+e.getMessage());
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
    public boolean CompaniaRegistrada(Compania compania) {
        
        String sql= "SELECT * FROM "+
                    Constantes.T_COMPANIA+
                    " WHERE "+Constantes.TC_DOCUMENTO+"='"+compania.getDocumento()+"'";
    
            try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {                
                
                compania.setId(resultSet.getInt(Constantes.TC_IDCOMPANIA));
                compania.setDocumento(resultSet.getString(Constantes.TC_DOCUMENTO));
                compania.setNombres(resultSet.getString(Constantes.TC_NOMBRES));
                compania.setApellidos(resultSet.getString(Constantes.TC_APELLIDOS));
                compania.setCorreo(resultSet.getString(Constantes.TC_CORREO));
                compania.setTelefono(resultSet.getString(Constantes.TC_TELEFONO));
                compania.setNombreCompañia(resultSet.getString(Constantes.TC_NOMBRECOMPANIA));
                compania.setNit(resultSet.getString(Constantes.TC_NIT));
                
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
    
}
