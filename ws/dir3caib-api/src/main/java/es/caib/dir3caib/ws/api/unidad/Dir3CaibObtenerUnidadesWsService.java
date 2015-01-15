
/*
 * 
 */

package es.caib.dir3caib.ws.api.unidad;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.12-patch-04
 * Fri Dec 12 13:01:16 CET 2014
 * Generated source version: 2.2.12-patch-04
 * 
 */


@WebServiceClient(name = "Dir3CaibObtenerUnidadesWsService", 
                  wsdlLocation = "http://localhost:8080/dir3caib/ws/Dir3CaibObtenerUnidades?wsdl",
                  targetNamespace = "http://www.caib.es/dir3caib") 
public class Dir3CaibObtenerUnidadesWsService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://www.caib.es/dir3caib", "Dir3CaibObtenerUnidadesWsService");
    public final static QName Dir3CaibObtenerUnidadesWs = new QName("http://www.caib.es/dir3caib", "Dir3CaibObtenerUnidadesWs");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/dir3caib/ws/Dir3CaibObtenerUnidades?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://localhost:8080/dir3caib/ws/Dir3CaibObtenerUnidades?wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public Dir3CaibObtenerUnidadesWsService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Dir3CaibObtenerUnidadesWsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Dir3CaibObtenerUnidadesWsService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     * 
     * @return
     *     returns Dir3CaibObtenerUnidadesWs
     */
    @WebEndpoint(name = "Dir3CaibObtenerUnidadesWs")
    public Dir3CaibObtenerUnidadesWs getDir3CaibObtenerUnidadesWs() {
        return super.getPort(Dir3CaibObtenerUnidadesWs, Dir3CaibObtenerUnidadesWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Dir3CaibObtenerUnidadesWs
     */
    @WebEndpoint(name = "Dir3CaibObtenerUnidadesWs")
    public Dir3CaibObtenerUnidadesWs getDir3CaibObtenerUnidadesWs(WebServiceFeature... features) {
        return super.getPort(Dir3CaibObtenerUnidadesWs, Dir3CaibObtenerUnidadesWs.class, features);
    }

}
