package com.maxihome.maxihome.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sugerencia")
public class Sugerencia {

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

    @NotBlank(message = "Debes seleccionar un tipo")
    @Size(max = 50, message = "Máximo 50 caracteres")
    @Column(nullable = false, length = 50)
    private String tipo;

    @NotBlank(message = "El mensaje es obligatorio")
    @Size(min = 10, message = "El mensaje debe tener al menos 10 caracteres")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensaje;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    // no setter para creadoEn
}
