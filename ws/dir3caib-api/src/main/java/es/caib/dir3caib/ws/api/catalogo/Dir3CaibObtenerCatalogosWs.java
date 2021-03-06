package es.caib.dir3caib.ws.api.catalogo;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.4
 * 2015-11-17T08:51:36.617+01:00
 * Generated source version: 2.6.4
 * 
 */
@WebService(targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", name = "Dir3CaibObtenerCatalogosWs")
@XmlSeeAlso({ObjectFactory.class})
public interface Dir3CaibObtenerCatalogosWs {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtenerCatLocalidad", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatLocalidad")
    @WebMethod
    @ResponseWrapper(localName = "obtenerCatLocalidadResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatLocalidadResponse")
    public java.util.List<es.caib.dir3caib.ws.api.catalogo.CatLocalidadTF> obtenerCatLocalidad();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtenerCatProvincia", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatProvincia")
    @WebMethod
    @ResponseWrapper(localName = "obtenerCatProvinciaResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatProvinciaResponse")
    public java.util.List<es.caib.dir3caib.ws.api.catalogo.CatProvinciaTF> obtenerCatProvincia();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtenerCatEntidadGeografica", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatEntidadGeografica")
    @WebMethod
    @ResponseWrapper(localName = "obtenerCatEntidadGeograficaResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatEntidadGeograficaResponse")
    public java.util.List<es.caib.dir3caib.ws.api.catalogo.CatEntidadGeograficaTF> obtenerCatEntidadGeografica();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtenerCatNivelAdministracion", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatNivelAdministracion")
    @WebMethod
    @ResponseWrapper(localName = "obtenerCatNivelAdministracionResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatNivelAdministracionResponse")
    public java.util.List<es.caib.dir3caib.ws.api.catalogo.CatNivelAdministracion> obtenerCatNivelAdministracion();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtenerCatComunidadAutonoma", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatComunidadAutonoma")
    @WebMethod
    @ResponseWrapper(localName = "obtenerCatComunidadAutonomaResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatComunidadAutonomaResponse")
    public java.util.List<es.caib.dir3caib.ws.api.catalogo.CatComunidadAutonomaTF> obtenerCatComunidadAutonoma();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtenerCatTipoVia", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatTipoVia")
    @WebMethod
    @ResponseWrapper(localName = "obtenerCatTipoViaResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatTipoViaResponse")
    public java.util.List<es.caib.dir3caib.ws.api.catalogo.CatTipoVia> obtenerCatTipoVia();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtenerCatPais", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatPais")
    @WebMethod
    @ResponseWrapper(localName = "obtenerCatPaisResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatPaisResponse")
    public java.util.List<es.caib.dir3caib.ws.api.catalogo.CatPais> obtenerCatPais();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getVersionWs", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.GetVersionWs")
    @WebMethod
    @ResponseWrapper(localName = "getVersionWsResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.GetVersionWsResponse")
    public java.lang.String getVersionWs();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtenerCatServicio", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatServicio")
    @WebMethod
    @ResponseWrapper(localName = "obtenerCatServicioResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatServicioResponse")
    public java.util.List<es.caib.dir3caib.ws.api.catalogo.Servicio> obtenerCatServicio();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "obtenerCatEstadoEntidad", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatEstadoEntidad")
    @WebMethod
    @ResponseWrapper(localName = "obtenerCatEstadoEntidadResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.ObtenerCatEstadoEntidadResponse")
    public java.util.List<es.caib.dir3caib.ws.api.catalogo.CatEstadoEntidad> obtenerCatEstadoEntidad();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getVersion", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.GetVersion")
    @WebMethod
    @ResponseWrapper(localName = "getVersionResponse", targetNamespace = "http://catalogo.ws.dir3caib.caib.es/", className = "es.caib.dir3caib.ws.api.catalogo.GetVersionResponse")
    public java.lang.String getVersion();
}
