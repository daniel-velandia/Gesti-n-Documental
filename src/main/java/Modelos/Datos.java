/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Familia
 */
public class Datos {
    
    private ArrayList<Estudiante> arrayListEstudiantes;
    private ArrayList<Compania> arrayListCompanias;
    private ArrayList<Encargado> arrayListEncargados;
    private ArrayList<Documento> arrayListDocumentos;

    public Datos() {
    }

    public Datos(ArrayList<Estudiante> arrayListEstudiantes, ArrayList<Compania> arrayListCompanias, ArrayList<Encargado> arrayListEncargados, ArrayList<Documento> arrayListDocumentos) {
        this.arrayListEstudiantes = arrayListEstudiantes;
        this.arrayListCompanias = arrayListCompanias;
        this.arrayListEncargados = arrayListEncargados;
        this.arrayListDocumentos = arrayListDocumentos;
    }

    /**
     * @return the arrayListEstudiantes
     */
    public ArrayList<Estudiante> getArrayListEstudiantes() {
        return arrayListEstudiantes;
    }

    /**
     * @param arrayListEstudiantes the arrayListEstudiantes to set
     */
    public void setArrayListEstudiantes(ArrayList<Estudiante> arrayListEstudiantes) {
        this.arrayListEstudiantes = arrayListEstudiantes;
    }

    /**
     * @return the arrayListCompanias
     */
    public ArrayList<Compania> getArrayListCompanias() {
        return arrayListCompanias;
    }

    /**
     * @param arrayListCompanias the arrayListCompanias to set
     */
    public void setArrayListCompanias(ArrayList<Compania> arrayListCompanias) {
        this.arrayListCompanias = arrayListCompanias;
    }

    /**
     * @return the arrayListEncargados
     */
    public ArrayList<Encargado> getArrayListEncargados() {
        return arrayListEncargados;
    }

    /**
     * @param arrayListEncargados the arrayListEncargados to set
     */
    public void setArrayListEncargados(ArrayList<Encargado> arrayListEncargados) {
        this.arrayListEncargados = arrayListEncargados;
    }

    /**
     * @return the arrayListDocumentos
     */
    public ArrayList<Documento> getArrayListDocumentos() {
        return arrayListDocumentos;
    }

    /**
     * @param arrayListDocumentos the arrayListDocumentos to set
     */
    public void setArrayListDocumentos(ArrayList<Documento> arrayListDocumentos) {
        this.arrayListDocumentos = arrayListDocumentos;
    }
    
    
}
