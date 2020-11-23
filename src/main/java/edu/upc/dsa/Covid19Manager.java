package edu.upc.dsa;

import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Usuario;

import java.util.List;
import java.util.*;

public interface Covid19Manager {

    public void addUsuario(String id, String nombre, String apellido, String fechaNacimiento, String valoracion);
    public void addMuestra(String id, String idClinico, String idPersona, String fechaNacimiento, String idLab);
    public Muestra getMuestra(String id); //extraemos una muestra paraluego enviarla
    public Usuario enviarMuestra(String id); //enviamos la muestra con el id extraido con la funcion de arriba
    public Queue<Muestra> colaMuestras(Muestra id); //generamos un cola porque nos dice que tiene orden de llagada.
    public Usuario getIdUsuario(String idUsuario); //una vez tenemos la cola de muestras, obtenemos la id de la persona para saber la valoracion
    public List<Muestra> muestrasUsuario(String id);
    public int size();
    public int usuarioSize();




}
