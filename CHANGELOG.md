

# Historial de Cambios - MaxiHome Web

Todos los cambios notables en este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es-ES/1.0.0/),
y este proyecto adhiere a [Versionado Semántico](https://semver.org/spec/v2.0.0.html).

## [1.0.0] - 2024-10-25
### Added
- **Configuración Organización GitHub**
  - Creación de organización `MaxiHome-Dev`
  - Transferencia del repositorio a la organización
  - Configuración de branch protection rules para `main`

- **Sistema de Labels Organizado**
  - 18 labels categorizados en 4 grupos
  - Estructura modular: `module/core`, `module/catalog`, `module/cart`, `module/user`, `module/admin`
  - Labels de estado: `in progress`, `blocked`, `high priority`, `review needed`

- **Planificación con Milestones**
  - 6 milestones definidos para desarrollo progresivo
  - Fechas establecidas hasta diciembre 2024
  - Agrupación por módulos técnicos

- **Documentación Completa**
  - `README.md` con descripción completa del proyecto
  - `CONTRIBUTING.md` con guía detallada de contribución
  - `CHANGELOG.md` con historial de cambios
  - Documentación de configuración en `/docs/`

- **Flujo Colaborativo Implementado**
  - Proceso de issues → branches → PRs → review → merge
  - Convención de commits establecida
  - Revisión de código entre cuentas demostrada
  - Cierre automático de issues con PRs
- **EVIDENCIA FORK/UPSTREAM** 
  - Configuración real de fork y upstream con cuenta secundaria
### Changed
- N/A (Versión inicial)

### Fixed
- N/A (Versión inicial)

### Configuración Técnica
- **Spring Boot** con estructura MVC
- **MySQL** como base de datos
- **Thymeleaf + Bootstrap** para frontend
- **Maven** para gestión de dependencias
