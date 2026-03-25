# 🧪 UX Lab Analytics: HCI Testing Suite

![Laravel](https://img.shields.io/badge/Laravel-11-FF2D20?style=for-the-badge&logo=laravel)
![Filament](https://img.shields.io/badge/Filament-v3-EAB308?style=for-the-badge&logo=laravel)
![PHP](https://img.shields.io/badge/PHP-8.3-777BB4?style=for-the-badge&logo=php)
![Tailwind](https://img.shields.io/badge/Tailwind-CSS-38B2AC?style=for-the-badge&logo=tailwind-css)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

> **Plataforma avanzada para la gestión de pruebas de usabilidad y análisis de Interacción Humano-Computador (HCI).**

UX Lab Analytics permite a ingenieros y analistas de UX gestionar el ciclo completo de evaluación de interfaces: desde la planificación de pruebas de usabilidad hasta la generación de hallazgos técnicos. Optimizado para comparar la eficacia y eficiencia entre múltiples aplicativos (Caso de estudio: Cooperativa JEP vs. Maquita).

---

## 📸 Vista Previa del Sistema

| Panel de Control | Gestión de Planes |
| :---: | :---: |
| ![Dashboard](https://raw.githubusercontent.com/tu-usuario/tu-repo/main/public/screenshots/dashboard.png) | ![Planes](https://raw.githubusercontent.com/tu-usuario/tu-repo/main/public/screenshots/planes.png) |
| *Interfaz limpia con Branding personalizado* | *Listado optimizado con filtros inteligentes* |

---

## 🛠️ Características Principales

* **Estructura de HCI Profesional:** Gestión de planes de prueba, tareas cronometradas y sesiones de usuario.
* **Panel Administrativo Reactivo:** Construido con Filament PHP, ofreciendo una experiencia de usuario rápida y fluida.
* **Gestión de Catálogos Maestros:** Control total sobre métodos de evaluación, niveles de severidad y prioridades de atención.
* **Análisis de Hallazgos:** Módulo especializado para documentar problemas de usabilidad con métricas de impacto.
* **Filtros Inteligentes:** Capacidad de segmentación por participante, tarea y aplicativo sin duplicados.
* **Accesibilidad Integrada:** Widget de accesibilidad dinámico (UserWay) para estándares de inclusión.

---

## 🏗️ Arquitectura del Sistema

El proyecto sigue una arquitectura **MVC** robusta potenciada por componentes **Livewire**:

* **Backend:** Laravel 11 con tipado estricto PHP 8.3.
* **Frontend:** Filament Dashboard con personalización de Branding y Hooks.
* **Base de Datos:** MySQL con integridad referencial completa en catálogos y transacciones.

---

## 🚀 Instalación y Configuración

Siga estos pasos para desplegar el laboratorio de pruebas localmente:

### Requisitos
* PHP 8.3+
* Composer 2.8.2+
* MySQL / MariaDB

### Pasos de Despliegue
1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/ux-lab-analytics.git](https://github.com/tu-usuario/ux-lab-analytics.git)
    cd ux-lab-analytics
    ```

2.  **Instalar dependencias:**
    ```bash
    composer install
    ```

3.  **Configurar entorno:**
    ```bash
    cp .env.example .env
    # Configura tus credenciales de base de datos en el archivo .env
    php artisan key:generate
    ```

4.  **Migraciones y Datos Semilla:**
    ```bash
    php artisan migrate --seed
    ```

5.  **Lanzar servidor:**
    ```bash
    php artisan serve
    ```
    Accede a: `http://127.0.0.1:8000/admin`

---

## 📊 Flujo de Trabajo (WorkFlow)

1.  **Configuración:** Definir Aplicativos, Métodos y Estados en los Catálogos.
2.  **Planificación:** Crear un *Plan de Prueba* de Usabilidad.
3.  **Ejecución:** Registrar *Sesiones* vinculando Participantes y Tareas.
4.  **Análisis:** Generar *Observaciones* y documentar los *Hallazgos* finales.

---

## 👥 Contribuidores

Agradecemos a las personas que han colaborado en el desarrollo de este ecosistema de UX:

* **Josué** - [@tu-usuario-github](https://github.com/tu-usuario-github) - *Arquitecto de Software & Especialista en HCI*
* **Colaborador 2** - [@usuario2](https://github.com/usuario2) - *Diseño de Base de Datos*

---

## 📄 Licencia

Este proyecto está bajo la Licencia **MIT**. Consulte el archivo `LICENSE` para más detalles.

---

Desarrollado con ❤️ para la optimización de la Interacción Humano-Computador.
