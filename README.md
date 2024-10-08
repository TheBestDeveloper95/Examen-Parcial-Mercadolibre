# **Examen Parcial - API Mutante Mercadolibre**

---

## 🧬 Introducción del reto

Esta API logra identificar si una secuencia de ADN es mutante o humana y almacenar cada secuencia en una base de datos H2 para poner
a disposición estadísticas de las verificaciones mediante un API REST. 

---

## 🛠️ Tecnologías utilizadas

- **Java 17** *(Desarrollo con IntelliJ IDEA)*
- **Gradle** *(Gestor de dependencias)*
- **Spring Boot** *(Framework backend)*
- **H2** *(Base de datos embebida)*
- **Postman** *(Cliente para pruebas de API)*
- **JUnit** *(Pruebas unitarias)*
- **JMeter** *(Pruebas de estrés y performance)*
- **Render** *(Despliegue en la nube de la API)*
- **Docker Desktop** *(Deploy contenedor)*
- **Swagger** *(Documentación interactiva de APIs)*
---
### Pagina web (nivel 1)
Aquí explico de manera detallada como desarrolle el método solicitado:
<a href="https://thebestdeveloper95.github.io/Documentacion-HTML-Examen-Mercadolibre/" target="_blank">Como afronté el Examen de Mercadolibre</a>

## 🚀 **Descripción de la API REST**

<pre><code> URL local: http://localhost:8080</code></pre>

### HTTP POST (mediante Postman)

Permite enviar un JSON con una secuencia de ADN y recibe como respuesta un Status en este caso 200 OK si es mutante y 403 Forbidden
en caso de ser humano

Path: http://localhost:8080/mutant

Request Body
<pre><code>{
"dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
]
}
</code></pre>

Response Status (ADN Mutante):
<pre><code>200 OK</code></pre>


Response Status (ADN Humano):
<pre><code>403 Forbidden</code></pre>

### HTTP GET (mediante Postman)

Devuelve un JSON con las estadisticas de las veridficaciones de ADN

Path: http://localhost:8080/stats

Response:

<pre><code>{
    "count_mutant_dna": 40,
    "count_human_dna": 100,
    "ratio": 0.4
}</code></pre>
---
## 🖥️ Instalación en local


1. Clonar o  Descargar Proyecto desde la rama main:

<pre><code>https://github.com/narengifor/mutant.git</code></pre>

2. Abrir el proyecto en intelliJ IDEA:

<pre><code>Ejecutar MutantApplication</code></pre>

3. Descargar e instalar H2:

<pre><code>LEVANTAR H2 con este comando: http://localhost:8080/h2-console/
Controlador: org.h2.Driver
URL JDBC: jdbc:h2:mem:testdb
</code></pre>
## 📊 Cobertura de Código (>80%)

![img.png](imagenes%2Fimg.png)

---

## 🧪 Ejemplos de funcionamiento (Postman)

* ### 🔬 ADN Humano

#### POST: http://localhost:8080/mutant
<pre><code>{
    "dna": [
        "TTGCGCAGCT",
        "CAGTAAACCT",
        "TTAGAGAGGT",
        "ATTCGGGAAA",
        "CCCAAACTAG",
        "GGGTACTGAA",
        "TTAGAGAGGT",
        "ATTCGGGAAA",
        "TTGCGCAGCT",
        "CAGTAAACCT"
    ]
}
</code></pre>

![403 fORBIDEN.png](imagenes%2F403%20fORBIDEN.png)

* ### 🧬 ADN Mutante
#### POST: http://localhost:8080/mutant
<pre><code>{
    "dna": [
        "ATGCGA", 
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA", 
        "TCACTG"
    ]
}
</code></pre>

![200OK.png](imagenes%2F200OK.png)

* ### 📈 Estadísticas
#### GET: http://localhost:8080/stats

![STATS.png](imagenes%2FSTATS.png)

---

## 🗄️ Base de datos H2 para guardar los ADN´s verificados por la API.
Se utilizó H2 como base de datos para almacenar todas las secuencias de adn, sin que se repitan.

![H2.png](imagenes%2FH2.png)

---
## 🗄️ Prueba de documentación con Swagger

![Swagger.png](imagenes%2FSwagger.png)

## 🏆 Desafíos cumplidos:
### Nivel 1: ✓
### Nivel 2: ✓ 
### Nivel 3: ✓
