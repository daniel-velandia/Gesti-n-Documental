/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia
 */
public class Compania extends Entidad {
    
    private String nombreCompañia;
    private String nit;

    public Compania() {
    }

    public Compania(String nombreCompañia, String nit, String documento, String nombres, String apellidos, String Correo, String telefono) {
        super(documento, nombres, apellidos, Correo, telefono);
        this.nombreCompañia = nombreCompañia;
        this.nit = nit;
    }
    
    public Compania(String nombreCompañia, String nit, int id, String documento, String nombres, String apellidos, String Correo, String telefono) {
        super(id, documento, nombres, apellidos, Correo, telefono);
        this.nombreCompañia = nombreCompañia;
        this.nit = nit;
    }

    /**
     * @return the nombreCompañia
     */
    public String getNombreCompañia() {
        return nombreCompañia;
    }

    /**
     * @param nombreCompañia the nombreCompañia to set
     */
    public void setNombreCompañia(String nombreCompañia) {
        this.nombreCompañia = nombreCompañia;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    
}
