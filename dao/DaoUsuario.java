
package com.mycompany.gestiondocumentalfesc.dao;

import com.mycompany.gestiondocumentalfesc.Modelos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoUsuario extends Conexion implements IDaoUsuario{

    @Override
    public boolean usuarioCreado(Usuario usuario) {
        String sql= "SELECT * FROM "+
                    Constantes.T_REGISTRARUSUARIO+
                    " WHERE "+Constantes.TRU_CONPASSWORD+"='"+usuario.getConfirmarContrasena()+"'";
        try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {                
                
                usuario.setId(resultSet.getInt(Constantes.TRU_ID));
                usuario.setNombre(resultSet.getString(Constantes.TRU_NOMBRE));
                usuario.setApellido(resultSet.getString(Constantes.TRU_APELLIDO));
                usuario.setNombreUsuario(resultSet.getString(Constantes.TRU_USERNAME));
                usuario.setContrasena(resultSet.getString(Constantes.TRU_PASSWORD));
                usuario.setConfirmarContrasena(resultSet.getString(Constantes.TRU_CONPASSWORD));
                
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
    public boolean crearUsuario(Usuario usuario) {
        String sql= "INSERT INTO "+Constantes.T_REGISTRARUSUARIO+"("+
                    Constantes.TRU_NOMBRE+","+
                    Constantes.TRU_APELLIDO+","+
                    Constantes.TRU_USERNAME+","+
                    Constantes.TRU_PASSWORD+","+
                    Constantes.TRU_CONPASSWORD+") VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getNombreUsuario());
            ps.setString(4, usuario.getContrasena());
            ps.setString(5, usuario.getConfirmarContrasena());
            ps.executeUpdate();
            
            System.out.println("Usuario creado con exito");
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al crear el usuario "+e.getMessage());
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

    

    

