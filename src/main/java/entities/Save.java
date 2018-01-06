package entities;

import java.util.Date;

public class Save extends Entity{
    private int id;
    private String titulo;
    private String enlace;
    private String descripcion;
    private float precioAntes;
    private float precioDespues;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private String empresaNoPatrocinada;
    private Category categoria;
    private User usuario;
    private Company empresaPatrocinada;

    public Save(int id, String titulo, String enlace, String descripcion, float precioAntes, float precioDespues, Date fechaCreacion, Date fechaActualizacion, String empresaNoPatrocinada, Category categoria, User usuario, Company empresaPatrocinada) {
        this.id = id;
        this.titulo = titulo;
        this.enlace = enlace;
        this.descripcion = descripcion;
        this.precioAntes = precioAntes;
        this.precioDespues = precioDespues;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.empresaNoPatrocinada = empresaNoPatrocinada;
        this.categoria = categoria;
        this.usuario = usuario;
        this.empresaPatrocinada = empresaPatrocinada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioAntes() {
        return precioAntes;
    }

    public void setPrecioAntes(float precioAntes) {
        this.precioAntes = precioAntes;
    }

    public float getPrecioDespues() {
        return precioDespues;
    }

    public void setPrecioDespues(float precioDespues) {
        this.precioDespues = precioDespues;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEmpresaNoPatrocinada() {
        return empresaNoPatrocinada;
    }

    public void setEmpresaNoPatrocinada(String empresaNoPatrocinada) {
        this.empresaNoPatrocinada = empresaNoPatrocinada;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Company getEmpresaPatrocinada() {
        return empresaPatrocinada;
    }

    public void setEmpresaPatrocinada(Company empresaPatrocinada) {
        this.empresaPatrocinada = empresaPatrocinada;
    }
}
