
package com.mycompany.gestiondocumentalfesc.dao;

import com.mycompany.gestiondocumentalfesc.Modelos.Login;


public interface IDaoLogin {
    
    public boolean sesionIniciada(Login login);
    
    public boolean iniciarSesion(Login login);
}
