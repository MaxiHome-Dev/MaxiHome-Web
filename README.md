-----

# 🛒 MaxiHome Ferretería – Sistema de Carrito de Compras

## 📋 Descripción del Proyecto

Sistema web de carrito de compras desarrollado para **MaxiHome Ferretería**, una empresa peruana con más de una década de experiencia en la venta de herramientas, materiales de construcción y productos para el hogar. El proyecto implementa un carrito de compras con roles de usuario y administrador, aplicando buenas prácticas de control de versiones con Git.

-----

## 🏢 Contexto de la Empresa

| Aspecto | Descripción |
| :--- | :--- |
| **Nombre del Negocio** | MaxiHome Ferretería |
| **Fundación** | 11 de junio de 2010 (Arequipa, Perú) |
| **Rubro** | Venta de herramientas, materiales de construcción y productos para el hogar |
| **Cobertura** | 8 departamentos del Perú |
| **Problemática** | Falta de una plataforma digital limita su competitividad en el mercado actual |

-----

## 🎯 Objetivos

### Objetivo General

Desarrollar una aplicación funcional de tipo carrito de compras con roles de usuario y administrador, aplicando buenas prácticas de control de versiones con Git.

### Objetivos Específicos

  * Implementar catálogo de productos con nombre, descripción y precio.
  * Desarrollar carrito de compras con funciones de agregar, eliminar y mostrar total.
  * Crear panel de administrador para gestión de productos (CRUD).
  * Aplicar flujo de trabajo con Git usando ramas y commits atómicos.

-----

## ✅ Requisitos Funcionales

### Rol: Usuario 👤

| Funcionalidad | Descripción |
| :--- | :--- |
| Ver productos | Visualizar catálogo de productos disponibles |
| Gestión de carrito | Agregar y quitar productos del carrito |
| Total de compra | Visualizar el total actualizado de la compra |
| Simular compra | Realizar proceso de compra simulada |

### Rol: Administrador 🔒

| Funcionalidad | Descripción |
| :--- | :--- |
| Crear productos | Añadir nuevos productos al catálogo |
| Editar productos | Modificar productos existentes |
| Eliminar productos | Remover productos del catálogo |

-----

## ⚙️ Requisitos No Funcionales

| Tipo | Requisito |
| :--- | :--- |
| **Persistencia** | Base de datos MySQL |
| **Interfaz** | Aplicación web responsive con Bootstrap |
| **Control de versiones** | Git con GitHub |
| **Calidad de código** | Commits descriptivos y atómicos |
| **Arquitectura** | Patrón MVC con Spring Boot |
| **Seguridad** | Acceso restringido para panel administrativo |

-----

## 💻 Tecnologías Utilizadas

| Área | Tecnologías |
| :--- | :--- |
| **Backend** | Spring Boot, Java, Spring Data JPA |
| **Frontend** | Thymeleaf, Bootstrap 5, JavaScript |
| **Base de Datos** | MySQL 8.0 |
| **Control de Versiones** | Git, GitHub |
| **IDE** | Apache NetBeans |
| **Gestión de Dependencias** | Maven |

-----

## 🚀 Instalación y Ejecución

### Prerrequisitos

  * Java 17 o superior
  * MySQL 8.0 o superior
  * Maven 3.6+
  * Git

### Pasos de Instalación

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/TuUsuario/MaxiHome-Web.git
    cd MaxiHome-Web
    ```
2.  **Configurar base de datos:**
      * Crear base de datos MySQL: `maxihome_db`
      * Configurar credenciales en: `src/main/resources/application.properties`
3.  **Ejecutar la aplicación:**
    ```bash
    ./mvnw spring-boot:run
    ```
4.  **Acceder a la aplicación:**
      * URL: `http://localhost:8080`

-----

## 🧑‍💻 Roles y Créditos

| Nombre | Rol | Funciones |
| :--- | :--- | :--- |
| Coveñas Ramirez Renzo Jeanpiere | Desarrollador Full Stack | Análisis, diseño, desarrollo backend/frontend, control de versiones |

-----

## 🌳 Flujo de Trabajo en Git

### Estructura de Ramas

| Rama | Propósito |
| :--- | :--- |
| `main` | Rama principal de producción |
| `feature/` | Desarrollo de nuevas funcionalidades |
| `fix/` | Corrección de errores |
| `docs/` | Documentación del proyecto |

### Comandos Utilizados

```bash
# Crear nueva rama para funcionalidad
git checkout -b feature/agregar-entidad-producto

# Hacer commit de cambios
git add .
git commit -m "feat: add Product entity with JPA annotations"

# Subir cambios al repositorio remoto
git push -u origin feature/agregar-entidad-producto

# Fusionar cambios a main
git checkout main
git merge --no-ff feature/agregar-entidad-producto
```

-----

## 📸 Capturas de Pantalla

### Configuración de Spring
![Configuración de Spring](docs/images/springboot.png)

### Estructura Inicial del Proyecto
![Estructura Inicial del Proyecto](docs/images/estructura.png)

### Configuración inicial del Git y primer commit
![Pantalla Principal](docs/images/cap1.png)

### Conexión y subida del proyecto a Github
![Pantalla Principal](docs/images/cap2.png)

### Repositorio creado en GitHub
![Pantalla Principal](docs/images/github.png)

### Commit: Actualización del archivo .gitignore y añadimiento del archivo LICENSE
![Pantalla Principal](docs/images/cap3.png)

### Commit: Configuración del Application Properties
![Pantalla Principal](docs/images/cap4.png)

### Creación de una rama para agregar una funcionalidad
![Pantalla Principal](docs/images/cap5.png)

### Salida del git status, commit y push exitoso de la rama
![Pantalla Principal](docs/images/cap6.png)

### Merge(fusion) de la rama con el main
![Pantalla Principal](docs/images/cap8.png)

### Eliminación de la rama ya usada del local y del repositorio
![Pantalla Principal](docs/images/cap9.png)

### Creación de una rama para el README, commit y push exitoso
![Pantalla Principal](docs/images/cap10.png)

### Merge de la rama "docs/readme"
![Pantalla Principal](docs/images/cap11.png)

### Merge exitoso con el push
![Pantalla Principal](docs/images/cap12.png)

### Actualización del archivo README terminado
![Pantalla Principal](docs/images/cap13.png)

### Falla al hacer merge
![Pantalla Principal](docs/images/cap14.png)

### Resolución del error y merge exitoso
```bash
git checkout main
git reset --hard origin/main
git merge docs/readme
git push -u origin docs/readme
```
![Pantalla Principal](docs/images/cap15.png)

---

## 📋 **ORGANIZACIÓN PROPUESTA PARA LAS EVIDENCIAS**

### **🏗️ 1. CONFIGURACIÓN INICIAL DE LA ORGANIZACIÓN**


### Creación de la Organización MaxiHome-Dev
![Botón para crear nueva organización en GitHub](docs/images2/cap1.png)

### Configuración de la Organización
![Formulario de configuración de la organización GitHub](docs/images2/cap2.png)

### Colaborador Agregado a la Organización
![Invitación enviada a colaborador para unirse a la organización](docs/images2/cap3.png)

### Organización Creada Exitosamente
![Página principal de la organización MaxiHome-Dev creada](docs/images2/cap7.png)


### **🔄 2. TRANSFERENCIA Y CONFIGURACIÓN DEL REPOSITORIO**


### Inicio de Transferencia del Repositorio
![Sección Danger Zone para transferir el repositorio a la organización](docs/images2/cap4.png)

### Confirmación de Transferencia
![Ventana de confirmación para transferir el repositorio a MaxiHome-Dev](docs/images2/cap5.png)


### **🛡️ 3. CONFIGURACIÓN DE BRANCH PROTECTION RULES**


### Acceso a Configuración de Branch Protection
![Ventana para añadir Branch Protection Rules](docs/images2/cap6.png)

### Configuración Detallada de las Reglas
![Configuración de las reglas con todos los checks habilitados](docs/images2/cap8.png)

### Regla de Protección Creada Exitosamente
![Branch Protection Rule activa para la rama main](docs/images2/cap9.png)


### **🏷️ 4. ORGANIZACIÓN DE LABELS Y MILESTONES**


### Creación de Labels
![Botón para crear nuevos labels en el repositorio](docs/images2/cap10.png)

### Labels Organizados por Categorías
![Lista completa de los 18 labels organizados en módulos, estado, tipo y colaboración](docs/images2/cap11.png)

### Creación de Milestones
![Ventana para crear nuevos milestones del proyecto](docs/images2/cap12.png)

### Planificación Completa con Milestones
![Lista de los 6 milestones: Setup del proyecto y 5 sprints de desarrollo](docs/images2/cap13.png)


### **📝 5. GESTIÓN DE ISSUES Y PULL REQUESTS**


### Creación de un Issue
![Ventana de creación de un issue con todos los campos](docs/images2/cap14.png)

### Issues del Milestone 0 - Setup
![5 issues creados y organizados para el Milestone 0 - Setup del Proyecto](docs/images2/cap15.png)

### Pull Request Esperando Revisión
![Pull request en estado de revisión, esperando aprobación de colaborador](docs/images2/cap16.png)

### Revisión de Código por Colaborador
![Colaborador enviando revisión con comentarios y aprobación](docs/images2/cap17.png)

### PR Aprobado y Mergeado
![Pull request aprobado y fusionado exitosamente al repositorio](docs/images2/cap18.png)

### Flujo de Trabajo en Git Bash - Ejemplo
![Comandos en Git Bash mostrando creación de rama, commits y push para un issue](docs/images2/cap19.png)


### **🍴 6. TRABAJO COLABORATIVO CON FORKS Y UPSTREAM**


### Creación de Fork desde Cuenta Secundaria
![Botón para crear un fork desde la cuenta secundaria en GitHub](docs/images2/cap20.png)

### Fork Creado Exitosamente
![Fork del repositorio creado en la cuenta secundaria](docs/images2/cap21.png)

### Preparación para Pull Request desde Fork
![Pantalla lista para crear pull request desde el fork de la cuenta secundaria](docs/images2/cap22.png)

### Pull Request Creado desde el Fork
![Pull request creado desde el fork hacia el repositorio principal](docs/images2/cap23.png)

### Configuración de Upstream en Git Bash
![Comandos en Git Bash para configurar upstream al repositorio original](docs/images2/cap24.png)

### Sincronización con Upstream
![Comandos en Git Bash para sincronizar el fork con los cambios upstream](docs/images2/cap25.png)

### Uso de Fork y Upstream - Comandos Ejecutados
![Comandos en Git Bash demostrando el uso completo de fork y upstream](docs/images2/cap26.png)


---

