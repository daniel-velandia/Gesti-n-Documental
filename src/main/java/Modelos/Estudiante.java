/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia
 */
public class Estudiante extends Entidad {
    
    private int carrera;
    private int semestre;

    public Estudiante() {
    }
    
    public Estudiante(int carrera, int semestre, String documento, String nombres, String apellidos, String Correo, String telefono) {
        super(documento, nombres, apellidos, Correo, telefono);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public Estudiante(int carrera, int semestre, int id, String documento, String nombres, String apellidos, String Correo, String telefono) {
        super(id, documento, nombres, apellidos, Correo, telefono);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    /**
     * @return the carrera
     */
    public int getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    
}
