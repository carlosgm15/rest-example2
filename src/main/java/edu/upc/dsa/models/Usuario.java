package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.Date;
import java.util.List;

public class Usuario { //Como nos dicen en el cuarto punto, un usuario tiene un alistade muestras. Hay que hacerla ademas de los atributos
                        // dados por el enunciado

    String id;
    String nombre;
    String apellido;
    String fechaNacimiento;
    String valoracion;
    List<Muestra> listaMuestras;

    public Usuario(List<Muestra> listaMuestras) {
        this.listaMuestras = listaMuestras;
    }

    public List<Muestra> getListaMuestras() {
        return listaMuestras;
    }

    public void setListaMuestras(List<Muestra> listaMuestras) {
        this.listaMuestras = listaMuestras;
    }

    public Usuario(String id, String nombre, String apellido, String fechaNacimiento, String valoracion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.valoracion = valoracion;
    }
    public Usuario() {

        this.id = RandomUtils.getId(); //para generaar un id random
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Usuario [id="+id+", nombre=" + nombre+ ", apellido=" + apellido +",fechaNacimiento=" + fechaNacimiento +", valoracion =" + valoracion+"]";
    }
    }

}