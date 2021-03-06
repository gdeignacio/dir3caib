package es.caib.dir3caib.persistence.model.ws;

import es.caib.dir3caib.persistence.model.Oficina;
import es.caib.dir3caib.persistence.model.RelacionOrganizativaOfi;
import es.caib.dir3caib.persistence.model.RelacionSirOfi;
import es.caib.dir3caib.persistence.model.Servicio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fundació BIT.
 *
 * @author earrivi
 *         Date: 27/02/14
 */
public class OficinaTF {

    private String codigo;
    private String denominacion;
    private String estado;    //CatEstadoEntidad
    private Long nivelAdministracion;  //CatNivelAdministracion
    private Long tipoOficina;  //CatJerarquiaOficina
    private String codUoResponsable;      //Unidad
    private String codOfiResponsable;   //Oficina
    private List<RelacionSirOfiTF> sirOfi;
    private List<RelacionOrganizativaOfiTF> organizativasOfi;
    private Long codigoPais;
    private Long codigoComunidad;
    private String descripcionLocalidad; //LOCALIDAD
    private String nombreVia;
    private String numVia;
    private Long codigoTipoVia;
    private String codPostal;
    private List<Long> servicios;

    public OficinaTF() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getNivelAdministracion() {
        return nivelAdministracion;
    }

    public void setNivelAdministracion(Long nivelAdministracion) {
        this.nivelAdministracion = nivelAdministracion;
    }

    public Long getTipoOficina() {
        return tipoOficina;
    }

    public void setTipoOficina(Long tipoOficina) {
        this.tipoOficina = tipoOficina;
    }

    public String getCodUoResponsable() {
        return codUoResponsable;
    }

    public void setCodUoResponsable(String codUoResponsable) {
        this.codUoResponsable = codUoResponsable;
    }

    public String getCodOfiResponsable() {
        return codOfiResponsable;
    }

    public void setCodOfiResponsable(String codOfiResponsable) {
        this.codOfiResponsable = codOfiResponsable;
    }

    public List<RelacionSirOfiTF> getSirOfi() {
        return sirOfi;
    }

    public void setSirOfi(List<RelacionSirOfiTF> sirOfi) {
        this.sirOfi = sirOfi;
    }

    public Long getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Long codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Long getCodigoComunidad() {
        return codigoComunidad;
    }

    public void setCodigoComunidad(Long codigoComunidad) {
        this.codigoComunidad = codigoComunidad;
    }

    public String getDescripcionLocalidad() {
        return descripcionLocalidad;
    }

    public void setDescripcionLocalidad(String descripcionLocalidad) {
        this.descripcionLocalidad = descripcionLocalidad;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public String getNumVia() {
        return numVia;
    }

    public void setNumVia(String numVia) {
        this.numVia = numVia;
    }

    public Long getCodigoTipoVia() {
        return codigoTipoVia;
    }

    public void setCodigoTipoVia(Long codigoTipoVia) {
        this.codigoTipoVia = codigoTipoVia;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public List<Long> getServicios() {
        return servicios;
    }

    public void setServicios(List<Long> servicios) {
        this.servicios = servicios;
    }

    /**
     * Transforma un List de {@link es.caib.dir3caib.persistence.model.RelacionSirOfi} en {@link es.caib.dir3caib.persistence.model.ws.RelacionSirOfiTF}
     * @param sirOfi
     */
    public void setSirOfiTF(List<RelacionSirOfi> sirOfi) {

        List<RelacionSirOfiTF> sirOfiTFList = new ArrayList<RelacionSirOfiTF>();

        for (RelacionSirOfi relacionSirOfi : sirOfi) {
            RelacionSirOfiTF sirOfiTF = RelacionSirOfiTF.generar(relacionSirOfi);
            sirOfiTFList.add(sirOfiTF);
        }

        this.sirOfi = sirOfiTFList;
    }

    public List<RelacionOrganizativaOfiTF> getOrganizativasOfi() {
        return organizativasOfi;
    }

    public void setOrganizativasOfi(List<RelacionOrganizativaOfiTF> organizativasOfi) {
        this.organizativasOfi = organizativasOfi;
    }

    /**
     * Transforma un List de {@link es.caib.dir3caib.persistence.model.RelacionOrganizativaOfi} en {@link es.caib.dir3caib.persistence.model.ws.RelacionOrganizativaOfiTF}
     * @param organizativasOfi
     */
    public void setOrganizativasOfiTF(List<RelacionOrganizativaOfi> organizativasOfi) {

        List<RelacionOrganizativaOfiTF> relacionOrganizativaOfiTFList = new ArrayList<RelacionOrganizativaOfiTF>();

        for (RelacionOrganizativaOfi relacionOrganizativaOfi : organizativasOfi) {
            RelacionOrganizativaOfiTF relacionOrganizativaOfiTF = RelacionOrganizativaOfiTF.generar(relacionOrganizativaOfi);
            relacionOrganizativaOfiTFList.add(relacionOrganizativaOfiTF);
        }

        this.organizativasOfi = relacionOrganizativaOfiTFList;
    }

    public void rellenar(Oficina oficina){
        this.setCodigo(oficina.getCodigo());
        this.setDenominacion(oficina.getDenominacion());
        this.setEstado(oficina.getEstado().getCodigoEstadoEntidad());
        if(oficina.getCodPais()!=null) {
            this.setCodigoPais(oficina.getCodPais().getCodigoPais());
        } else {
            this.setCodigoPais(null);
        }
        if(oficina.getCodComunidad()!=null) {
            this.setCodigoComunidad(oficina.getCodComunidad().getCodigoComunidad());
        } else {
            this.setCodigoComunidad(null);
        }
        if(oficina.getLocalidad()!=null) {
            this.setDescripcionLocalidad(oficina.getLocalidad().getDescripcionLocalidad());
        } else {
            this.setDescripcionLocalidad(null);
        }
        this.setNombreVia(oficina.getNombreVia());
        this.setNumVia(oficina.getNumVia());
        if(oficina.getTipoVia()!=null) {
            this.setCodigoTipoVia(oficina.getTipoVia().getCodigoTipoVia());
        } else {
            this.setCodigoTipoVia(null);
        }
        this.setCodPostal(oficina.getCodPostal());



        if(oficina.getNivelAdministracion() != null){
            this.setNivelAdministracion(oficina.getNivelAdministracion().getCodigoNivelAdministracion());
        } else {
            this.setNivelAdministracion(null);
        }

        if(oficina.getTipoOficina() != null){
            this.setTipoOficina(oficina.getTipoOficina().getCodigoJerarquiaOficina());
        } else {
            this.setTipoOficina(null);
        }
        this.setCodUoResponsable(oficina.getCodUoResponsable().getCodigo());

        if(oficina.getCodOfiResponsable() != null){
            this.setCodOfiResponsable(oficina.getCodOfiResponsable().getCodigo());
        } else {
            this.setCodOfiResponsable(null);
        }


        if(oficina.getSirOfi() != null){
            this.setSirOfiTF(oficina.getSirOfi());
        } else {
            this.setSirOfiTF(null);
        }

        if(oficina.getOrganizativasOfi() != null){
            this.setOrganizativasOfiTF(oficina.getOrganizativasOfi());
        } else {
            this.setOrganizativasOfiTF(null);
        }

        if(oficina.getServicios() != null){
            List<Long> serviciosIds= new ArrayList<Long>();
            for(Servicio servicio: oficina.getServicios()){
                serviciosIds.add(servicio.getCodServicio());
            }
            this.setServicios(serviciosIds);
        } else {
            this.setServicios(null);
        }
    }


    public static OficinaTF generar(Oficina oficina){
        OficinaTF oficinaTF =  new OficinaTF();
        if(oficina!=null){
            oficinaTF.rellenar(oficina);
        }
        return oficinaTF;
    }
}
