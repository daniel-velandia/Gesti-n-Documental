
package com.mycompany.gestiondocumentalfesc.dao;

import com.mycompany.gestiondocumentalfesc.Modelos.Documento;


public interface IDaoDocumento {
    
    public boolean registrarDocumento(Documento documento);
    
    public boolean documentoRegistrado(Documento documento);
    
    public boolean consultarDocumento(Documento documento);
}
