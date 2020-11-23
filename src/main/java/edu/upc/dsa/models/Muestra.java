package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;
import java.util.*;

public class Muestra {

    String id;
    String idClinica;
    String idPersona; //P
    String fecha;
    String idLab;

    public Muestra(String id, String idClinica, String idPersona, String fecha, String idLab) {
        this.id = id;
        this.idClinica = idClinica;
        this.idPersona = idPersona;
        this.fecha = fecha;
        this.idLab = idLab;
    }

    public Muestra() {

        this.id = RandomUtils.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(String idClinica) {
        this.idClinica = idClinica;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }





    @Override
    public String toString() {
        return "Muestra [id="+id+", nomClinica=" + idClinica+ ", idPersona=" + idPersona +",fecha=" + fecha +", idLab =" + idLab+"]";
    }

}