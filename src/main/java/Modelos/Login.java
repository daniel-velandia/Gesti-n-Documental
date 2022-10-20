
package com.mycompany.gestiondocumenta.modelos;


public class Login {
    
    private int id;
    private Usuario nombreUsuario;
    private Usuario contraseña;

    public Login() {
    }

    public Login(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(Usuario nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario getContraseña() {
        return contraseña;
    }

    public void setContraseña(Usuario contraseña) {
        this.contraseña = contraseña;
    }

    

}
