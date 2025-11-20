package com.maxihome.maxihome.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contacto")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 150, message = "Máximo 150 caracteres")
    @Column(nullable = false, length = 150)
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Correo no válido")
    @Size(max = 150, message = "Máximo 150 caracteres")
    @Column(nullable = false, length = 150)
    private String correo;

    @NotBlank(message = "El asunto es obligatorio")
    @Size(max = 200, message = "Máximo 200 caracteres")
    @Column(nullable = false, length = 200)
    private String asunto;

    @NotBlank(message = "El mensaje es obligatorio")
    @Size(min = 10, message = "El mensaje debe tener al menos 10 caracteres")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @PrePersist
    protected void onCreate() {
        this.creadoEn = LocalDateTime.now();
    }

    // Getters y setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getCreadoEn() { return creadoEn; }
    // no setter para creadoEn
}
