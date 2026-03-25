# 🧪 UX Lab Analytics: HCI Testing Suite

![Laravel](https://img.shields.io/badge/Laravel-11-FF2D20?style=for-the-badge&logo=laravel)
![Filament](https://img.shields.io/badge/Filament-v3-EAB308?style=for-the-badge&logo=laravel)
![PHP](https://img.shields.io/badge/PHP-8.3-777BB4?style=for-the-badge&logo=php)
![Tailwind](https://img.shields.io/badge/Tailwind-CSS-38B2AC?style=for-the-badge&logo=tailwind-css)

> **Plataforma avanzada para la gestión de pruebas de usabilidad y análisis de Interacción Humano-Computador (HCI).**

UX Lab Analytics permite a los ingenieros y analistas de UX gestionar el ciclo completo de evaluación de interfaces: desde la planificación de pruebas de usabilidad hasta la generación de hallazgos técnicos. Optimizado para comparar la eficacia y eficiencia entre múltiples aplicativos (Caso de estudio: Cooperativa JEP vs. Maquita).

---

## 🛠️ Características Principales

* **Estructura de HCI Profesional:** Gestión de planes de prueba, tareas cronometradas y sesiones de usuario.
* **Panel Administrativo Reactivo:** Construido con Filament PHP, ofreciendo una experiencia de usuario rápida y fluida.
* **Gestión de Catálogos Maestros:** Control total sobre métodos de evaluación, niveles de severidad y prioridades de atención.
* **Análisis de Hallazgos:** Módulo especializado para documentar problemas de usabilidad con métricas de impacto.
* **Filtros Inteligentes:** Capacidad de segmentación por participante, tarea y aplicativo para auditorías rápidas.
* **Accesibilidad Integrada:** Widget de accesibilidad dinámico (UserWay) para garantizar estándares de inclusión.

## 🏗️ Arquitectura del Sistema

El proyecto sigue una arquitectura **MVC** robusta potenciada por componentes **Livewire**:

- **Backend:** Laravel 11 con tipado estricto PHP 8.3.
- **Frontend:** Filament Dashboard con personalización de Branding y Hooks.
- **Base de Datos:** MySQL con integridad referencial completa en catálogos y transacciones.

---

## 🚀 Instalación y Configuración

Siga estos pasos para desplegar el laboratorio de pruebas localmente:

### Requisitos
* PHP 8.3+
* Composer 2.8.2+
* MySQL

### Pasos
1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/tu-usuario/ux-lab-analytics.git](https://github.com/tu-usuario/ux-lab-analytics.git)
   cd ux-lab-analytics
