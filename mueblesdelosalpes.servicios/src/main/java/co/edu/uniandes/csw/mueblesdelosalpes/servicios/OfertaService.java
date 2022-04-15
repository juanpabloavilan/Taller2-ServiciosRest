/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Oferta;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioOfertaMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/oferta")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OfertaService {
    @EJB
    private IServicioOfertaMockLocal ofertaEjb;
    
    @GET
    @Path("ofertas/")
    public List<Oferta> obtenerOfertas(){
        return ofertaEjb.obtenerOfertas();
    }
    
    @GET
    @Path("ofertaPorID/{id}")
    public Oferta obtenerOfertaPorId(@PathParam("id") Long id){        
        return ofertaEjb.obtenerOfertaPorId(id);        
    }
    
    @POST
    @Path("agregarOferta/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void agregarOferta(Oferta oferta){
        ofertaEjb.agregarOferta(oferta);
    }
    
    
    
}
