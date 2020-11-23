package edu.upc.dsa;

import edu.upc.dsa.models.Muestra;

import java.util.*;

import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

public class Covid19ManagerImpl implements Covid19Manager {

    private static Covid19Manager instance;

    protected Queue<Muestra> colaMuestras;
    protected List<Muestra> listaMuestras;
    private HashMap<String, Usuario> usuarios;

    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);


    private Covid19ManagerImpl() {
        this.colaMuestras = new LinkedList<>();
        this.listaMuestras= new LinkedList<>();
        this.usuarios = new HashMap<>();
    }

    public static Covid19Manager getInstance() {
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }

    public int usuarioSize() {  //nos da el tamaño que ocupa
        int ret = this.usuarios.size();
        logger.info("size " + ret);

        return ret;
    }

    public int size() {
        int ret = this.listaMuestras.size();
        logger.info("size " + ret);

        return ret;
    }


    @Override
    public void addUsuario(String id, String nombre, String apellido, String fechaNacimiento, String valoracion) {

        this.usuarios.put(id, new Usuario(id,nombre,apellido,fechaNacimiento,valoracion));
    }


    public void addMuestra(String id, String idClinico, String idPersona, String fechaNacimiento, String idLab) {

        this.listaMuestras.add(new Muestra(id,idClinico,idPersona,fechaNacimiento,idLab));
    }


    @Override
    public Muestra getMuestra(String id) {

            logger.info("getmuestra(" + id + ")");

            for (muestra muestra : this.listaMuestras) {
                if (muestra.getIdmuestra().equals(id)) {
                    logger.info("getmuestra(" + id+ "): " + muestra);

                    return muestra;
                }
            }

            logger.warn("not found " + idmuestra);
            return null;
        }


    @Override
    public Usuario enviarMuestra(String id) {
        return null;
    }

    @Override
    public Queue<Muestra> colaMuestras(Muestra id) {
        logger.info("Nueva muestra a añadir" + id);
        this.colaMuestras.add(id);
        return colaMuestras;
    }

    @Override
    public Usuario getIdUsuario(Usuario usuario) {
        this.usuarios.get(usuario);
        return
    }
    public Muestra getMuestra(String id) {


        for (Muestra t: this.listaMuestras) {
            if (t.getId().equals(id)) {
                logger.info("getTrack("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }





}