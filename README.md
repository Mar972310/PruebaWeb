# PROYECTO FINAL - CICLO DE VIDA DEL DESARROLLO DE SOFTWARE

## Nombre del proyecto: *MVP TOP GEAR TUNNING*

### Información del Curso

- *Periodo Académico*: 2024-1
- *Nombre del Curso*: Ciclos de Vida de Desarrollo de software

### Integrantes del Proyecto

- Alexandra Cortes Tovar - Rol: Equipo de Desarrollo (Back)
- Maria Valentina Torres Monsalve - Rol: Equipo de Desarrollo (Front)
- José Ricardo Vásquez Vega - Rol: Scrum Master
- Juan Sebastián Vásquez Vega - Rol: Equipo de Desarrollo (Back)

### Información del Profesor

- *Nombre del Profesor*: Ivan Dario Lemus Moya
- *Rol*: Product Owner

## 1. Descripción del producto.

### Funcionalidades del Administrador

#### 1. Acceso Privado
El administrador puede acceder a un módulo de administración privado mediante usuario y contraseña desde una página de inicio de sesión.

#### 2. Home Page
Tras la autenticación exitosa, el administrador es redirigido a una página principal con las siguientes opciones:

#### 3. Ver Cotizaciones
- Permite ver todas las cotizaciones en curso.
- Capacidad de ingresar a cada cotización para visualizar toda la información proporcionada por el usuario.
- Posibilidad de cambiar el estado de cada cotización entre: CREADO, EN PROCESO, FINALIZADO, y ELIMINADO.

#### 4. Administración de Productos
- Implementación de un CRUD para gestionar productos.
- Cada producto incluye: Nombre, descripción breve, descripción técnica, categoría, imagen (ruta de la imagen), valor, moneda, descuento e impuestos.
- Gestión de productos desde el módulo privado.

### Funcionalidades para los Usuarios

#### 1. Realización de Cotizaciones
- Acceso a una página web pública para realizar cotizaciones de productos disponibles en la base de datos suministrada por el cliente.
- Los usuarios pueden agregar y quitar productos de un carrito de compras.

#### 2. Detalle de la Cotización
- Visualización del detalle completo de la cotización en una página específica, mostrando subtotales, impuestos y total.

#### 3. Finalización de la Cotización
- Posibilidad de finalizar la cotización en la página del carrito de compras.
- Redirección a una página final donde se puede imprimir la cotización o contactar a un asesor mediante WhatsApp.
- Envío de un enlace de la cotización en curso por WhatsApp, con acceso a la cotización sin posibilidad de edición.


## 2. Descripción general.

### Funcionalidades Más Importantes

#### 1. Página de Login

![Página de Login](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/Login.png)

![Página de Login Admi](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/LoginAdmi.png)

- *Descripción*: La página de login permite al administrador autenticarse en el sistema mediante un usuario y una contraseña. Esta es la puerta de entrada al módulo de administración privado.

#### 2. Home Page del Administrador

![Home Page](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/HomeAdmi.png)

- *Descripción*: Tras la autenticación exitosa, el administrador es redirigido a la página principal del módulo de administración, donde puede acceder a varias opciones como ver cotizaciones y administrar productos.

#### 3. Ver Cotizaciones

![Ver Cotizaciones](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/Quotes.png)

- *Descripción*: Esta funcionalidad permite al administrador ver todas las cotizaciones en curso, ingresar a cada cotización individualmente, y ver toda la información suministrada por el usuario. Además, el administrador puede cambiar el estado de cada cotización entre: CREADO, EN PROCESO, FINALIZADO y ELIMINADO.

#### 4. Administración de Productos

![Administración de Productos](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/Products.png)

- *Descripción*: En esta sección, el administrador puede gestionar los productos mediante un CRUD. Cada producto cuenta con información como nombre, descripción breve, descripción técnica, categoría, imagen, valor, moneda, descuento e impuestos.

#### 5. Página de Cotización del Usuario

![Página de Cotización](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/QuoteUsers.png)

- *Descripción*: Los usuarios pueden acceder a una página web pública para realizar cotizaciones de productos disponibles. Pueden agregar y quitar productos de un carrito de compras y ver el detalle completo de la cotización (subtotal, impuestos y total).

#### 6. Finalización de la Cotización

![Finalización de la Cotización](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/quotation_final.png)

- *Descripción*: En la página del carrito de compras, el usuario puede finalizar la cotización. Esto lo redirige a una última página donde puede imprimir la cotización o contactar a un asesor mediante WhatsApp. Al presionar el link enviado por WhatsApp, el usuario puede ver la cotización sin posibilidad de edición.

## 3. Arquitectura y Diseño detallado:

### A. Modelo E-R (Entidad-Relación)

![alt text](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/ModeloER.png)

#### Descripción del Modelo E-R

El modelo Entidad-Relación (E-R) describe la estructura lógica de la base de datos del sistema TOP GEAR. A continuación, se presentan las principales entidades, sus atributos y las relaciones entre ellas:

### B. Diagrama de Clases (Generado mediante Ingeniería Inversa)

![alt text](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/DiagramPaquets.png)

![alt text](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/DiagramClassController.png)

![alt text](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/DiagramModel.png)

![alt text](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/DiagramRepository.png)

#### Descripción del Proceso

El diagrama de clases se ha generado utilizando una técnica conocida como ingeniería inversa. Esto implica importar el código fuente del proyecto en una herramienta de modelado UML que soporte esta funcionalidad, y luego generar automáticamente el diagrama de clases a partir de dicho código.

### B. Descripción de la Arquitectura

El proyecto utiliza una arquitectura en capas que facilita la organización del código y promueve la separación de responsabilidades. A continuación, se describen las capas utilizadas:

#### Capas de la Arquitectura

1. *Controlador (Controller)*
   - *Responsabilidad*: Maneja las solicitudes HTTP entrantes, las procesa y devuelve las respuestas adecuadas.
   - *Descripción*: Esta capa actúa como intermediario entre el usuario y el sistema. Recibe las solicitudes del cliente, llama a los servicios necesarios y devuelve la respuesta al cliente.

2. *Servicio (Service)*
   - *Responsabilidad*: Contiene la lógica de negocio del sistema.
   - *Descripción*: La capa de servicio se encarga de realizar las operaciones necesarias, utilizando los métodos proporcionados por la capa de repositorio, para cumplir con los requisitos del negocio.

3. *Repositorio (Repository)*
   - *Responsabilidad*: Interactúa con la base de datos para realizar operaciones CRUD.
   - *Descripción*: Esta capa abstrae la lógica de acceso a los datos. Utiliza un ORM para comunicarse con la base de datos y realiza las operaciones de persistencia.

4. *Base de Datos (Database)*
   - *Responsabilidad*: Almacena y gestiona los datos persistentes del sistema.
   - *Descripción*: La base de datos es el componente donde se almacenan todos los datos necesarios para el funcionamiento del sistema. Se puede utilizar cualquier sistema de gestión de bases de datos (SGBD) compatible con el ORM seleccionado.

5. *ORM (Model)*
   - *Responsabilidad*: Mapea los objetos del dominio a las tablas de la base de datos.
   - *Descripción*: El ORM (Object-Relational Mapping) facilita la interacción con la base de datos al permitir trabajar con objetos en lugar de directamente con tablas y SQL.

6. *Configuración (Config)*
   - *Responsabilidad*: Maneja las configuraciones necesarias para el funcionamiento del sistema.
   - *Descripción*: Esta capa incluye la configuración del sistema, como la configuración de la base de datos, los parámetros de seguridad, y otras configuraciones específicas de la aplicación.

### C. Stack de Tecnologías Utilizado

El proyecto se ha implementado utilizando el siguiente stack de tecnologías:

1. *Backend*
   - *Lenguaje de Programación*: Java
   - *Framework*: Spring boot

2. *Frontend*
   - *Lenguaje de Programación*: JavaScript / HTML / CSS

3. *Base de Datos*
   - *Sistema de Gestión de Bases de Datos*: H2

4. *ORM*
   - *Librería*: java.io, java.util, UUID, com.fasterxml.jackson.databind y jakarta.persistence.

5. *Despliegue, DevOps, Repository*
   - *Plataformas*: Azure, Maven, GitHub

8. *Testing*
   - *Frameworks*: mockito, Junit
 
### D. Enlace a la aplicación

- [Aplicación](https://github.com/Richi025/cvds-2024-I-prj-final/tree/master)  

### E. Enlace al Backlog de Azure DevOps

- [Backlog de Azure DevOps](https://dev.azure.com/ivanlemus0422/cvds-2024-I-jjam-solutions/_backlogs/backlog/cvds-2024-I-jjam-solutions%20Team/Epics) 

## Descripción del proceso:

### 1. Metodología SCRUM

#### Descripción

SCRUM es una metodología ágil de gestión de proyectos utilizada principalmente en el desarrollo de software. Se enfoca en entregar productos de alta calidad mediante iteraciones cortas y manejables llamadas Sprints.

#### Proceso Resumido

#### A.  Roles Clave
- *Product Owner*: Define y prioriza las características del producto (Product Backlog).
- *Scrum Master*: Facilita el proceso SCRUM y elimina obstáculos.
- *Equipo de Desarrollo*: Grupo de profesionales que trabajan en el desarrollo del producto.

#### B. Componentes Principales
- *Product Backlog*: Lista priorizada de todas las características y requerimientos del producto.
- *Sprint*: Iteración de tiempo fijo (generalmente de 2 a 4 semanas) durante la cual se trabaja en los elementos del Product Backlog.
- *Sprint Backlog*: Lista de tareas a realizar durante el Sprint, seleccionadas del Product Backlog.

#### C. Eventos Principales
- *Sprint Planning*: Reunión al inicio de cada Sprint para planificar las tareas del Sprint.
- *Daily Standup*: Reunión diaria de corta duración (15 minutos) para sincronizar el trabajo y discutir problemas.
- *Sprint Review*: Reunión al final del Sprint para revisar lo que se ha completado y adaptar el Product Backlog si es necesario.
- *Sprint Retrospective*: Reunión para reflexionar sobre el Sprint y mejorar el proceso para el siguiente Sprint.

#### D. Resumen del Ciclo SCRUM

1. *Planificación del Sprint (Sprint Planning)*
   - El equipo selecciona elementos del Product Backlog para trabajar durante el Sprint.
   - Se define el Sprint Goal.

2. *Ejecución del Sprint*
   - El equipo trabaja en las tareas del Sprint Backlog.
   - Se llevan a cabo Daily Standups para monitorear el progreso y resolver problemas.

3. *Revisión del Sprint (Sprint Review)*
   - El equipo presenta el trabajo completado al Product Owner y otros interesados.
   - Se recopila feedback para futuras iteraciones.

4. *Retrospectiva del Sprint (Sprint Retrospective)*
   - El equipo discute lo que funcionó bien, lo que no funcionó y cómo mejorar el proceso.

Este ciclo se repite hasta que el producto se completa o se decide finalizar el proyecto. La metodología SCRUM permite una mejora continua y una rápida adaptación a los cambios, asegurando que el producto final cumpla con las expectativas del cliente.


### 2. Reporte de Pruebas y Cobertura

![Sprints Reporte de Pruebas](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/imageTests1.png)

![Sprints Reporte de Pruebas](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/imageTests.png)

### 3. Backlog por Sprint

![Backlog](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/image0.png)

#### A. Sprint 1

![Sprint 1 Backlog](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/image.png)

#### B. Sprint 2

![Sprint 2 Backlog](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/image2.png)

#### C. Sprint 3

![Sprint 3 Backlog](https://github.com/Richi025/cvds-2024-I-prj-final/blob/dev/Pictures/image3.png)



