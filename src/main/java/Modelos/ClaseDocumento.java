/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia
 */
public class ClaseDocumento {
    
    private int id;
    private String claseDocumento;

    public ClaseDocumento() {
    }

    public ClaseDocumento(int id, String claseDocumento) {
        this.id = id;
        this.claseDocumento = claseDocumento;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the claseDocumento
     */
    public String getClaseDocumento() {
        return claseDocumento;
    }

    /**
     * @param claseDocumento the claseDocumento to set
     */
    public void setClaseDocumento(String claseDocumento) {
        this.claseDocumento = claseDocumento;
    }
    
    
}
