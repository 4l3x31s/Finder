package com.yvaganet.finder.objects;

/**
 * Created by Alexeis on 15 jun 2016.
 */
public class RequestMascotaPerdida extends RequestGlobal {
    private String latitud;
    private String longitud;
    private String direccion;
    private String comentario;
    private String imagen;
    private String contacto;
    private String qrMascota;

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getQrMascota() {
        return qrMascota;
    }

    public void setQrMascota(String qrMascota) {
        this.qrMascota = qrMascota;
    }
}
