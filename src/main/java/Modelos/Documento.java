/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Date;

/**
 *
 * @author Familia
 */
public class Documento {
    
    private int id;
    private byte[] archivoPdf;
    private Date fecha;
    private String numRadicado;
    private boolean tipoRadicado;
    private int tipoDocumento;
    private String asunto;
    private String anexos;
    private boolean reqRespuesta;
    private int remitenteId;
    private int encargadoId;
    private int respuestaId;

    public Documento() {
    }

    public Documento(int id, byte[] archivoPdf, Date fecha, String numRadicado, boolean tipoRadicado, int tipoDocumento, String asunto, String anexos, boolean reqRespuesta, int remitenteId, int encargadoId, int respuestaId) {
        this.id = id;
        this.archivoPdf = archivoPdf;
        this.fecha = fecha;
        this.numRadicado = numRadicado;
        this.tipoRadicado = tipoRadicado;
        this.tipoDocumento = tipoDocumento;
        this.asunto = asunto;
        this.anexos = anexos;
        this.reqRespuesta = reqRespuesta;
        this.remitenteId = remitenteId;
        this.encargadoId = encargadoId;
        this.respuestaId = respuestaId;
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
     * @return the archivoPdf
     */
    public byte[] getArchivoPdf() {
        return archivoPdf;
    }

    /**
     * @param archivoPdf the archivoPdf to set
     */
    public void setArchivoPdf(byte[] archivoPdf) {
        this.archivoPdf = archivoPdf;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the numRadicado
     */
    public String getNumRadicado() {
        return numRadicado;
    }

    /**
     * @param numRadicado the numRadicado to set
     */
    public void setNumRadicado(String numRadicado) {
        this.numRadicado = numRadicado;
    }

    /**
     * @return the tipoRadicado
     */
    public boolean isTipoRadicado() {
        return tipoRadicado;
    }

    /**
     * @param tipoRadicado the tipoRadicado to set
     */
    public void setTipoRadicado(boolean tipoRadicado) {
        this.tipoRadicado = tipoRadicado;
    }

    /**
     * @return the tipoDocumento
     */
    public int getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the anexos
     */
    public String getAnexos() {
        return anexos;
    }

    /**
     * @param anexos the anexos to set
     */
    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }

    /**
     * @return the reqRespuesta
     */
    public boolean isReqRespuesta() {
        return reqRespuesta;
    }

    /**
     * @param reqRespuesta the reqRespuesta to set
     */
    public void setReqRespuesta(boolean reqRespuesta) {
        this.reqRespuesta = reqRespuesta;
    }

    /**
     * @return the remitenteId
     */
    public int getRemitenteId() {
        return remitenteId;
    }

    /**
     * @param remitenteId the remitenteId to set
     */
    public void setRemitenteId(int remitenteId) {
        this.remitenteId = remitenteId;
    }

    /**
     * @return the encargadoId
     */
    public int getEncargadoId() {
        return encargadoId;
    }

    /**
     * @param encargadoId the encargadoId to set
     */
    public void setEncargadoId(int encargadoId) {
        this.encargadoId = encargadoId;
    }

    /**
     * @return the respuestaId
     */
    public int getRespuestaId() {
        return respuestaId;
    }

    /**
     * @param respuestaId the respuestaId to set
     */
    public void setRespuestaId(int respuestaId) {
        this.respuestaId = respuestaId;
    }

    
}
