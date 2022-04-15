/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Oferta;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioOfertaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author javil
 */
@Stateless
public class ServicioOfertaMock implements IServicioOfertaMockLocal{
    
    private IServicioPersistenciaMockLocal persistencia;
    
    public ServicioOfertaMock(){
        persistencia=new ServicioPersistenciaMock();

    }

    @Override
    public void agregarOferta(Oferta oferta) {
        try {
            persistencia.create(oferta);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioOfertaMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizarOferta(Oferta oferta) {
        persistencia.update(oferta);
    }

    @Override
    public void eliminarOferta(Oferta oferta) {
        try {
            persistencia.delete(oferta);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioOfertaMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Oferta> obtenerOfertas() {
        return persistencia.findAll(Oferta.class);
    }

    @Override
    public Oferta obtenerOfertaPorId(Long id) {
        return (Oferta) persistencia.findById(Oferta.class, id);
    }
        
}
