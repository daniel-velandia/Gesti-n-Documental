
package com.mycompany.gestiondocumentalfesc.dao;

import com.mycompany.gestiondocumentalfesc.Modelos.Usuario;

public interface IDaoUsuario {
    
    public boolean usuarioCreado(Usuario usuario);
    
    public boolean crearUsuario(Usuario usuario);
}
