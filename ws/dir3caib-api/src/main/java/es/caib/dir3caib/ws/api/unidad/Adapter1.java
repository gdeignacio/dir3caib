
package es.caib.dir3caib.ws.api.unidad;

import java.sql.Timestamp;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Timestamp>
{


    public Timestamp unmarshal(String value) {
        return (org.fundaciobit.genapp.common.ws.WsTimestampAdapter.parseDateTime(value));
    }

    public String marshal(Timestamp value) {
        return (org.fundaciobit.genapp.common.ws.WsTimestampAdapter.printDateTime(value));
    }

}
