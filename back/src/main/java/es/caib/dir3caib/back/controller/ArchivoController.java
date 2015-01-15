package es.caib.dir3caib.back.controller;


import es.caib.dir3caib.persistence.model.Dir3caibConstantes;
import es.caib.dir3caib.persistence.model.FileSystemManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * Created 9/07/14 15:52
 *
 * @author mgonzalez
 */
@Controller
@RequestMapping(value = "/archivo")
public class ArchivoController extends BaseController{

    protected final Logger log = Logger.getLogger(getClass());

    @RequestMapping(value = "/{nombreArchivo}/{tipo}", method = RequestMethod.GET)
    public void  archivo(@PathVariable("nombreArchivo") String nombreArchivo, @PathVariable("tipo") String tipo, HttpServletRequest request, HttpServletResponse response)  {


        fullDownload(nombreArchivo,tipo, response);

    }

    public void fullDownload(String nombre, String tipo,  HttpServletResponse response) {

        FileInputStream input = null;
        OutputStream output = null;
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        File file = null;

        try {
            if (nombre != null) {
                if(Dir3caibConstantes.CATALOGO.equals(tipo)){
                  file = FileSystemManager.getArchivo(Dir3caibConstantes.CATALOGOS_LOCATION_PROPERTY, nombre);
                }
                if(Dir3caibConstantes.UNIDAD.equals(tipo)){
                  file = FileSystemManager.getArchivo(Dir3caibConstantes.UNIDADES_LOCATION_PROPERTY, nombre);
                }
                if(Dir3caibConstantes.OFICINA.equals(tipo)){
                  file = FileSystemManager.getArchivo(Dir3caibConstantes.OFICINAS_LOCATION_PROPERTY, nombre);
                }


                String contentType = mimeTypesMap.getContentType(file);

                response.setContentType(contentType);
                response.setHeader("Content-Disposition", "attachment; filename=\"" + nombre + "\"");
                response.setContentLength((int) file.length());

                output = response.getOutputStream();
                input = new FileInputStream(file);

                FileSystemManager.copy(input, output);

                input.close();
                output.close();
            }

        } catch (NumberFormatException e) {
            log.info(e);
        }  catch (Exception e) {
            e.printStackTrace();
        }


    }
}