/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Oferta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author javil
 */
@Local
public interface IServicioOfertaMockLocal {
    public void agregarOferta(Oferta oferta);
    public void actualizarOferta(Oferta oferta);
    public void eliminarOferta(Oferta oferta);
    public List<Oferta> obtenerOfertas();
    public Oferta obtenerOfertaPorId(Long id);
    
}
