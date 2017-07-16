package pe.pardoschicken.reserva.model;

import java.util.List;

/**
 * Created by Orlando on 13/07/2017.
 */
public class Cliente {

    private String dni;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String direccion;
    private String telefono;
    private String correo;
    private Reniec dniReniec;
    private List<Reserva> reservas;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Reniec getDniReniec() {
        return dniReniec;
    }

    public void setDniReniec(Reniec dniReniec) {
        this.dniReniec = dniReniec;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
