
package com.mycompany.gestiondocumentalfesc.dao;

import com.mycompany.gestiondocumentalfesc.Modelos.Estudiante;


public interface IDaoEstudiante {
    
    public boolean estudianteRegistrado(Estudiante estudiante);
    
    public boolean RegistrarEstudiante(Estudiante estudiante);
}
