
package com.mycompany.gestiondocumentalfesc.dao;


public class Constantes {
    
    public static final String URL="jdbc:mysql://localhost:3306/";
    public static final String DATABASE="gestiondocumental";
    public static final String USER="root";
    public static final String PASSWORD="";
    
    public static final String T_REGISTRARUSUARIO="registrar_usuario";
    public static final String TRU_ID="id_usuario";
    public static final String TRU_NOMBRE="nombre";
    public static final String TRU_APELLIDO="apellido";
    public static final String TRU_USERNAME="nombre_usuario";
    public static final String TRU_PASSWORD="contraseña";
    public static final String TRU_CONPASSWORD="confirmar_contraseña";
    
    public static final String T_LOGIN="login_usuario";
    public static final String TL_IDLOGIN="id_login";
    public static final String TL_USERNAME="nombre_usuario";
    public static final String TL_PASSWORD="contraseña";
    
    public static final String T_ESTUDIANTE="estudiante";
    public static final String TE_IDESTUDIANTE="id_estudiante";
    public static final String TE_DOCUMENTO="id_documento";
    public static final String TE_NOMBRES="nombres";
    public static final String TE_APELLIDOS="apellidos";
    public static final String TE_CORREO="correo";
    public static final String TE_TELEFONO="telefono";
    public static final String TE_CARRERA="carrera";
    public static final String TE_SEMESTRE="semestre";
    
    public static final String T_DOCUMENTO="documento";
    public static final String TD_IDDOCUMENTO="id_documento";
    public static final String TD_ARCHIVOPDF="archivo_pdf";
    public static final String TD_FECHA="fecha";
    public static final String TD_NUMERORADICADO="numero_radicado";
    public static final String TD_TIPORADICADO="tipo_radicado";
    public static final String TD_ASUNTO="asunto";
    public static final String TD_ANEXO="anexo";
    public static final String TD_REQRESPUESTA="requiere_respuesta";
    public static final String TD_CLASEDOCUMENTO="clase_documento";
    public static final String TD_REMITENTEID="remitente_id";
    public static final String TD_ENCARGADOID="encargado_id";
    public static final String TD_RESPUESTAID="respuesta_id";
    
    public static final String T_COMPANIA="compañia";
    public static final String TC_IDCOMPANIA="id_compañia";
    public static final String TC_DOCUMENTO="documento";
    public static final String TC_NOMBRES="nombres";
    public static final String TC_APELLIDOS="apellidos";
    public static final String TC_CORREO="correo";
    public static final String TC_TELEFONO="telefono";
    public static final String TC_NOMBRECOMPANIA="nombre_compañia";
    public static final String TC_NIT="nit";
}
