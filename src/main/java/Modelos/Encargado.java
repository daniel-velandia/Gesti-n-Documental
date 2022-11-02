/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia
 */
public class Encargado extends Entidad {
    
    private String area;
    private String cargo;

    public Encargado() {
    }

    public Encargado(String area, String cargo, int id, String documento, String nombres, String apellidos, String Correo, String telefono) {
        super(id, documento, nombres, apellidos, Correo, telefono);
        this.area = area;
        this.cargo = cargo;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
