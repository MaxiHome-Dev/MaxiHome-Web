package com.maxihome.maxihome.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reclamacion")
public class Reclamacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 150, message = "Máximo 150 caracteres")
    @Column(nullable = false, length = 150)
    private String nombre;

    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 20, message = "DNI inválido")
    @Column(nullable = false, length = 20)
    private String dni;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Correo no válido")
    @Size(max = 150, message = "Máximo 150 caracteres")
    @Column(nullable = false, length = 150)
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 7, max = 20, message = "Teléfono inválido")
    @Column(nullable = false, length = 20)
    private String telefono;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 255, message = "Máximo 255 caracteres")
    @Column(nullable = false, length = 255)
    private String direccion;

    @NotBlank(message = "El producto/servicio es obligatorio")
    @Size(max = 150, message = "Máximo 150 caracteres")
    @Column(nullable = false, length = 150)
    private String producto;

    @NotBlank(message = "Debes seleccionar tipo")
    @Pattern(regexp = "reclamo|queja", message = "Tipo inválido")
    @Column(nullable = false, length = 50)
    private String tipo;

    @NotBlank(message = "El detalle es obligatorio")
    @Size(min = 10, message = "Mínimo 10 caracteres")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String detalle;

    @Column(name = "fecha", nullable = false, updatable = false)
    private LocalDateTime fecha;

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
    }

    // Getters & Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }

    public LocalDateTime getFecha() { return fecha; }
    // no setter para fecha
}
