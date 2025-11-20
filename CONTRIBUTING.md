
## 🎯 Flujo de Trabajo Colaborativo

### 1. Configuración Inicial
```bash
# Clonar el repositorio
git clone https://github.com/MaxiHome-Dev/MaxiHome-Web.git

# Configurar usuario (ejemplo)
git config user.name "Tu Nombre"
git config user.email "tu.email@ejemplo.com"
```

### 2. Estructura de Ramas

#### 🏗️ Ramas Principales
- `main` - Rama de producción (PROTEGIDA)
- `develop` - Rama de desarrollo integrado

#### 🌿 Ramas de Trabajo
| Tipo | Convención | Propósito |
|------|------------|-----------|
| **Feature** | `feature/nombre-funcionalidad` | Nuevas funcionalidades |
| **Fix** | `fix/descripcion-error` | Corrección de errores |
| **Docs** | `docs/tipo-documentacion` | Documentación |
| **Hotfix** | `hotfix/descripcion-urgente` | Correcciones críticas |

#### ✅ Ejemplos Reales Usados
- `feature/configuracion-repositorio` - Configuración inicial GitHub
- `feature/organizacion-labels` - Organización de etiquetas
- `docs/documentacion-completa` - Documentación del proyecto

### 3. Convención de Commits

#### 📝 Formato
```
tipo(ámbito): descripción breve

descripción detallada (opcional)
```

#### 🏷️ Tipos de Commit
| Tipo | Cuándo Usar | Ejemplo |
|------|-------------|---------|
| `feat` | Nueva funcionalidad | `feat: agregar entidad Producto` |
| `fix` | Corrección de error | `fix: resolver error en cálculo total` |
| `docs` | Documentación | `docs: agregar CONTRIBUTING.md` |
| `chore` | Tareas mantenimiento | `chore: actualizar dependencias Maven` |
| `style` | Formato código | `style: formatear archivos HTML` |
| `refactor` | Refactorización | `refactor: optimizar servicio Producto` |

#### ✅ Ejemplos Reales
```bash
git commit -m "docs: add repository configuration setup documentation"
git commit -m "feat: add complete labels organization documentation"
```

### 4. Proceso de Pull Request

#### 🔄 Flujo Completo
1. **Crear Issue** en GitHub con labels apropiados
2. **Crear Branch** desde el issue (`feature/`, `fix/`, `docs/`)
3. **Desarrollar** con commits atómicos
4. **Crear PR** vinculado al issue
5. **Revisión de Código** por al menos 1 revisor
6. **Aprobación** y merge
7. **Cierre automático** del issue

#### 📋 Requisitos del PR
- **Título descriptivo** con convención
- **Descripción detallada** de cambios
- **Issue vinculado** con `Cierra #número`
- **Labels apropiados** (`review needed`, `documentation`, etc.)
- **Revisor asignado**
- **Milestone correcto**

### 5. Organización con Labels

#### 🏷️ Categorías de Labels
| Categoría | Labels | Propósito |
|-----------|--------|-----------|
| **Módulos** | `module/core`, `module/catalog`, `module/cart`, `module/user`, `module/admin` | Agrupar por funcionalidad |
| **Estado** | `in progress`, `blocked`, `high priority`, `review needed` | Seguimiento de progreso |
| **Tipo** | `bug`, `documentation`, `enhancement`, `question` | Clasificar issues |
| **Colaboración** | `help wanted`, `good first issue`, `duplicate` | Gestión equipo |

### 6. Protección de Ramas

#### 🛡️ Reglas de la Rama `main`
- ✅ **Require pull request** antes de merge
- ✅ **Require approvals** (mínimo 1)
- ✅ **Dismiss stale approvals** con nuevos commits
- ✅ **Require status checks**
- ✅ **Require conversation resolution** antes de merge
- ✅ **Include administrators**

### 7. Resolución de Conflictos

#### 🔧 Cuando Ocurren Conflictos
1. **Actualizar tu rama** con los últimos cambios de `main`
```bash
git checkout main
git pull origin main
git checkout tu-rama
git merge main
```

2. **Resolver conflictos** manualmente en los archivos
3. **Hacer commit** de la resolución
```bash
git add archivos-resueltos
git commit -m "fix: resolve merge conflicts in archivo"
```

### 8. Estándares de Código

#### ☕ Spring Boot / Java
- Seguir convenciones de nombres Java
- Usar inyección de dependencias Spring
- Mantener controllers delgados
- Lógica de negocio en services

#### 🎨 Frontend (Thymeleaf + Bootstrap)
- HTML semántico y accesible
- Clases Bootstrap para responsive design
- Integración Thymeleaf con Spring

### 9. Comandos Git Esenciales

#### 🔄 Flujo Diario
```bash
# Actualizar repositorio local
git checkout main
git pull origin main

# Crear nueva rama
git checkout -b feature/nueva-funcionalidad

# Trabajar y hacer commits
git add .
git commit -m "feat: descripción de cambios"

# Subir cambios
git push -u origin feature/nueva-funcionalidad
```

#### 🛠️ Comandos Avanzados Usados
```bash
# Ver estado actual
git status

# Ver historial de commits
git log --oneline --graph

# Restaurar archivos no deseados
git restore archivo.html

# Configurar usuario específico
git config user.name "Nombre Usuario"
```

---

## ¿Necesitas Ayuda?
- Revisa los **issues existentes** con label `help wanted`
- Consulta los **PRs mergeados** como referencia
- Pregunta en issues con label `question`

---
### 10. Trabajo con Forks y Upstream - EVIDENCIA REAL

#### 🍴 Fork Realizado
- **Repositorio original:** `MaxiHome-Dev/MaxiHome-Web`
- **Fork creado:** `rrrrrenzo545-dev/MaxiHome-Web`
- **Fecha:** Octubre 2024

#### 🔄 Configuración Upstream Real
```bash
# Comandos ejecutados reales
git remote add upstream https://github.com/MaxiHome-Dev/MaxiHome-Web.git
git fetch upstream
git merge upstream/main