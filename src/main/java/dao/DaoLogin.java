
package com.mycompany.gestiondocumentalfesc.dao;

import com.mycompany.gestiondocumentalfesc.Modelos.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoLogin extends Conexion implements IDaoLogin {

    @Override
    public boolean sesionIniciada(Login login) {
        
        String sql= "SELECT * FROM "+Constantes.T_LOGIN+
                    " WHERE "+Constantes.TL_PASSWORD+"='"+login.getContraseña()+"'";
            
            try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {                
                
                login.setId(resultSet.getInt(Constantes.TL_IDLOGIN));
                login.setNombreUsuario(resultSet.getString(Constantes.TL_USERNAME));
                login.setContraseña(resultSet.getString(Constantes.TL_PASSWORD));
                
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
    public boolean iniciarSesion(Login login) {
        
        String sql= "INSERT INTO "+Constantes.T_LOGIN+"("+
                    Constantes.TL_USERNAME+","+
                    Constantes.TL_PASSWORD+") VALUES(?,?)";
         try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ps.setString(1, login.getNombreUsuario());
            ps.setString(2, login.getContraseña());
            ps.executeUpdate();
            
            System.out.println("Inicio de sesion con exito ");
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesion "+e.getMessage());
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
