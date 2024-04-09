# proyecto-fase2


<h1>Proyecto Vertech+ con Java, Spring Boot y Angular</h1>

<h2>Descripción</h2>
<p>Este proyecto fue desarrollado para el programa Vertech+ y requirió el consumo de la API de Google Reel. La aplicación se divide en dos partes: el backend, desarrollado en Java con Spring Boot para proporcionar servicios RESTful y acceder a la API de Google Reel, y el frontend, desarrollado en Angular para proporcionar una interfaz de usuario interactiva y amigable.</p>

<h2>Características Principales</h2>
<ul>
  <li>Consumo de la API de Google Reel para acceder a funcionalidades de edición de videos.</li>
  <li>Desarrollo del backend en Java utilizando Spring Boot para proporcionar servicios RESTful.</li>
  <li>Desarrollo del frontend en Angular para crear una interfaz de usuario dinámica y moderna.</li>
</ul>

<h2>Tecnologías Utilizadas</h2>
<ul>
  <li>Java</li>
  <li>Spring Boot</li>
  <li>Angular</li>
  <li>API de Google Reel</li>
</ul>

<h2>Estructura del Proyecto</h2>
<p>La estructura del proyecto se divide en backend y frontend:</p>
<pre>
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── tuempresa/
│   │   │   │   │   ├── controllers/        # Controladores RESTful
│   │   │   │   │   ├── models/             # Modelos de datos
│   │   │   │   │   ├── services/           # Servicios de negocio
│   │   │   │   │   └── Application.java     # Clase principal de la aplicación
│   ├── resources/
│   │   └── application.properties          # Configuración del backend
frontend/
├── src/
│   ├── app/
│   │   ├── components/                     # Componentes de Angular
│   │   ├── services/                       # Servicios para comunicación con el backend
│   │   ├── models/                         # Modelos de datos en el frontend
│   │   ├── views/                          # Vistas de Angular
│   │   └── app-routing.module.ts           # Configuración de rutas de la aplicación
</pre>

<h2>Uso</h2>
<p>Para utilizar la aplicación:</p>
<ol>
  <li>Configura el backend con las credenciales de la API de Google Reel en <code>application.properties</code>.</li>
  <li>Ejecuta el backend utilizando Spring Boot.</li>
  <li>Configura el frontend para comunicarse con el backend en <code>environment.ts</code>.</li>
  <li>Ejecuta el frontend utilizando Angular.</li>
  <li>Accede a la aplicación desde tu navegador para utilizar las funcionalidades de la API de Google Reel.</li>
</ol>

<h2>Contribuciones</h2>
<p>¡Las contribuciones son bienvenidas! Si tienes sugerencias para mejorar la aplicación, añadir nuevas funcionalidades o resolver problemas, no dudes en enviar un pull request.</p>




<h3>Video funcionamiento</h3>

link: https://youtu.be/Z7-7nz-UMMM
