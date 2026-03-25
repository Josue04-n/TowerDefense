# 🧪 UX Lab Analytics: HCI Testing Suite

[![Laravel 11](https://img.shields.io/badge/Framework-Laravel%2011-FF2D20?style=for-the-badge&logo=laravel)](https://laravel.com)
[![Filament v3](https://img.shields.io/badge/Admin-Filament%20v3-EAB308?style=for-the-badge&logo=laravel)](https://filamentphp.com)
[![PHP 8.3](https://img.shields.io/badge/PHP-8.3-777BB4?style=for-the-badge&logo=php)](https://www.php.net)
[![Tailwind CSS](https://img.shields.io/badge/UI-Tailwind%20CSS-38B2AC?style=for-the-badge&logo=tailwind-css)](https://tailwindcss.com)
[![Copilot Reviewed](https://img.shields.io/badge/GitHub-Copilot%20Reviewed-24292e?style=for-the-badge&logo=github)](https://github.com/features/copilot)

> **Plataforma avanzada para la gestión de pruebas de usabilidad y análisis de Interacción Humano-Computador (HCI).**

UX Lab Analytics es un ecosistema diseñado para ingenieros y especialistas en UX. Permite gestionar el ciclo de vida completo de una evaluación de interfaces: desde la planificación estratégica hasta la cuantificación de hallazgos técnicos. Optimizado para la comparativa de métricas de eficiencia y eficacia (Caso de estudio: Cooperativa JEP vs. Maquita).

---

## 📸 Vista Previa (Preview)

![Dashboard HCI](https://github.com/Josue04-n/TowerDefense/blob/main/Captura%20de%20pantalla%202026-03-24%20234248.png)
*Interfaz optimizada con Branding personalizado y Widget de Accesibilidad dinámico.*

---

## 🛠️ Características Destacadas

* **Estructura HCI Core:** Gestión integral de planes de prueba, tareas normalizadas y sesiones cronometradas.
* **Panel Administrativo Inteligente:** Interfaz reactiva basada en **Filament PHP**, con navegación agrupada y colapsable.
* **Arquitectura de Catálogos:** Control centralizado de Métodos de Evaluación, Severidades y Prioridades de Atención.
* **Filtrado Avanzado:** Segmentación de datos por Participante, Tarea y Aplicativo con lógica de duplicados controlada.
* **Inclusión Digital:** Integración nativa del widget **UserWay** mediante Render Hooks para cumplimiento de accesibilidad.
* **IA Assisted Development:** Código revisado y optimizado mediante **GitHub Copilot** para garantizar mejores prácticas de Laravel.

---

## 🏗️ Stack Tecnológico & Arquitectura

El sistema implementa una arquitectura **TALL Stack** (Tailwind, Alpine.js, Laravel, Livewire) de alto rendimiento:

-   **Backend:** PHP 8.3 + Laravel 11 (Strict Typing).
-   **Frontend:** Filament v3 + Tailwind CSS + Livewire v3.
-   **Base de Datos:** MySQL con integridad referencial y disparadores de catálogos.
-   **Análisis de Código:** Revisión asistida por IA (GitHub Copilot) para refactorización y seguridad.

---

## 🚀 Instalación y Despliegue

### Requisitos Técnicos
* **PHP:** `^8.3` (Configurado en `C:\xampp\php\php.exe`)
* **Composer:** `^2.8.2`
* **Base de Datos:** MySQL / MariaDB

### Guía Paso a Paso
1.  **Clonación del Proyecto:**
    ```bash
    git clone [https://github.com/Josue04-n/Grupo-HCI-5.git)
    cd ux-lab-analytics
    ```

2.  **Gestión de Dependencias:**
    ```bash
    composer install
    ```

3.  **Configuración de Entorno:**
    ```bash
    cp .env.example .env
    php artisan key:generate
    ```
    *Nota: Ajustar las credenciales de `DB_DATABASE`, `DB_USERNAME` y `DB_PASSWORD` en el archivo `.env`.*

4.  **Despliegue de Esquema y Datos:**
    ```bash
    php artisan migrate --seed
    ```

5.  **Ejecución:**
    ```bash
    php artisan serve
    ```
    🌐 Panel Administrativo: `http://127.0.0.1:8000/admin`

---

## 📈 Roadmap (Próximas Mejoras)
- [ ] Implementación de Gráficos de Eficacia (Chart Widgets).
- [ ] Exportación de Reportes HCI en formato PDF/Excel.
- [ ] Módulo de Mapas de Calor (Heatmaps) por Tarea.

---
## 👥 Contribuidores

Agradecemos la dedicación y el esfuerzo técnico de los desarrolladores que han hecho posible este ecosistema de UX:

* **Josué** - [@Josue04-n](https://github.com/Josue04-n)  
  *Lead Software Architect & HCI Specialist*
* **Alex Reyes** - [@alexJonarey](https://github.com/alexJonarey)  
  *Backend Developer & Database Manager*
* **Bryan Lopez** - [@BryanLopez257](https://github.com/BryanLopez257)  
  *UX/UI Implementation & Frontend Support*
* **Dennis Quisaguano** - [@DennisQuisaguano](https://github.com/DennisQuisaguano)  
  *QA Engineer & HCI Metrics Analyst*
* **GitHub Copilot** - *AI Code Review & Logic Optimization*

---

## 📄 Licencia
Este proyecto se distribuye bajo la licencia **MIT**. Consulte el archivo `LICENSE` para más detalles.

---
Desarrollado con rigor técnico para la optimización de la experiencia de usuario.
