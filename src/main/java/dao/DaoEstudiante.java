
package com.mycompany.gestiondocumentalfesc.dao;

import com.mycompany.gestiondocumentalfesc.Modelos.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoEstudiante extends Conexion implements IDaoEstudiante {

    @Override
    public boolean estudianteRegistrado(Estudiante estudiante) {
        
        String sql= "SELECT * FROM "+
                Constantes.T_ESTUDIANTE+
                " WHERE "+Constantes.TE_DOCUMENTO+"='"+estudiante.getDocumento()+"'";
    
        try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {                
                
                estudiante.setId(resultSet.getInt(Constantes.TE_IDESTUDIANTE));
                estudiante.setDocumento(resultSet.getString(Constantes.TE_DOCUMENTO));
                estudiante.setNombres(resultSet.getString(Constantes.TE_NOMBRES));
                estudiante.setApellidos(resultSet.getString(Constantes.TE_APELLIDOS));
                estudiante.setCorreo(resultSet.getString(Constantes.TE_CORREO));
                estudiante.setTelefono(resultSet.getString(Constantes.TE_TELEFONO));
                estudiante.setCarrera(resultSet.getString(Constantes.TE_CARRERA));
                estudiante.setSemestre(resultSet.getString(Constantes.TE_SEMESTRE));
                
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
    public boolean RegistrarEstudiante(Estudiante estudiante) {
        
        String sql="INSERT INTO "+Constantes.T_ESTUDIANTE+"("+
                    Constantes.TE_DOCUMENTO+","+
                    Constantes.TE_NOMBRES+","+
                    Constantes.TE_APELLIDOS+","+
                    Constantes.TE_CORREO+","+
                    Constantes.TE_TELEFONO+","+
                    Constantes.TE_CARRERA+","+
                    Constantes.TE_SEMESTRE+") VALUES(?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps=getConexion().prepareStatement(sql);
            ps.setString(1, estudiante.getDocumento());
            ps.setString(2, estudiante.getNombres());
            ps.setString(3, estudiante.getApellidos());
            ps.setString(4, estudiante.getCorreo());
            ps.setString(5, estudiante.getTelefono());
            ps.setString(6, estudiante.getCarrera());
            ps.setString(7, estudiante.getSemestre());
            ps.executeUpdate();
            
            System.out.println("Estudiante creado con exito");
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al crear el estudiante "+e.getMessage());
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
