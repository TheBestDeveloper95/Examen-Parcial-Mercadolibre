# **Examen Parcial - API Mutante Mercadolibre**
![GitHub](https://img.shields.io/github/license/TheBestDeveloper95/Examen-Parcial-Mercadolibre)
![GitHub last commit](https://img.shields.io/github/last-commit/TheBestDeveloper95/Examen-Parcial-Mercadolibre)
![GitHub issues](https://img.shields.io/github/issues/TheBestDeveloper95/Examen-Parcial-Mercadolibre)
---
## Indice 📖
- [Introducción del reto](#-introducción-del-reto)
    - [Alcance](#alcance)

- [Tecnologías utilizadas](#️-tecnologías-utilizadas)
    - [Pagina web (nivel 1)](#Pagina-web-nivel-1)
- [Descripción de la API](#-descripción-de-la-api)
    - [HTTP POST (mediante Postman)](#http-post-mediante-postman)
    - [HTTP GET (mediante Postman)](#http-get-mediante-postman)

- [Instalación en local](#️-instalación-en-local)

- [Diagrama de Arquitectura](#️-diagrama-de-arquitectura)

- [Diagrama de secuencia](#️-diagrama-de-secuencia)

- [Cobertura de Código (>80%)](#-cobertura-de-código-80)

- [Ejemplos de funcionamiento (Postman)](#-ejemplos-de-funcionamiento-postman)
    - [ADN Humano](#-adn-humano)
    - [ADN Mutante](#-adn-mutante)
    - [Estadísticas](#-estadísticas)

- [Base de datos H2 para guardar los ADN´s verificados por la API](#️-base-de-datos-h2-para-guardar-los-adns-verificados-por-la-api)

- [Prueba de documentación con Swagger](#️-prueba-de-documentación-con-swagger)

- [Ejemplos de funcionamiento (Render + Postman)](#-ejemplos-de-funcionamiento-render--postman)
    - [Funcionamiento POST en Render](#funcionamiento-post-en-render)
    - [Funcionamiento GET en Render](#funcionamiento-get-en-render)
- [Pruebas de rendimiento JMeter](#-pruebas-de-rendimiento-jmeter)

- [Live test (Render)](#-live-test-render)

## 🧬 Introducción del reto

###   Alcance:
Esta API logra identificar si una secuencia de ADN es mutante o humana y almacenar cada secuencia en una base de datos H2 para poner
a disposición estadísticas de las verificaciones mediante un API REST. 

Contará con dos servicios web.
Un servicio web será "/mutant/", que se encargará de determinar si un adn humano o mutante. En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un 403-Forbidden
El otro servicio web será "/stats" que se encargará devolver un Json con las estadísticas de las verificaciones de ADN.
Se guardara el request y un boolean si es mutante o no en la base de datos, ademas de las veces que se hizo la misma request.


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

### Pagina web (nivel 1)
Aquí explico de manera detallada como desarrolle el método solicitado:
<a href="https://thebestdeveloper95.github.io/Documentacion-HTML-Examen-Mercadolibre/" target="_blank">Como afronté el Examen de Mercadolibre</a>

## 🚀 **Descripción de la API**
<pre><code> URL local: http://localhost:8080</code></pre>

### HTTP POST (mediante Postman)

Permite enviar un JSON con una secuencia de ADN y recibe como respuesta un Status 200 OK si es mutante y 403 Forbidden
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

## 🖥️ Instalación en local


1. Clonar o Descargar Proyecto desde la rama main:

[Descargar aquí](https://github.com/TheBestDeveloper95/Examen-Parcial-Mercadolibre/archive/refs/heads/main.zip)

2. Abrir el proyecto en intelliJ IDEA:

<pre><code>Ejecutar MutantApplication</code></pre>

3. Descargar e instalar H2:

<pre><code>LEVANTAR H2 con este comando: http://localhost:8080/h2-console/
Controlador: org.h2.Driver
URL JDBC: jdbc:h2:mem:testdb
</code></pre>

4. Enviar secuencia de ADN en formato JSON mediante:
<pre><code>a)Postman: (Instalar postman)
b)Swagger: llamandolo mediante http://localhost:8080/swagger-ui/index.html
</code></pre>
Si solo quieren testear el deploy de la API de render con Postman a continuación dejo el servicio en vivo:
<pre><code>https://examen-parcial-mercadolibre.onrender.com

La lógica es la misma:
POST https://examen-parcial-mercadolibre.onrender.com/mutant
GET  https://examen-parcial-mercadolibre.onrender.com/stats
</code></pre>

## 🖥️ Diagrama de Arquitectura
![Arquitectura.png](imagenes%2FArquitectura.png)

## 🖥️ Diagrama de secuencia

Diagrama de secuencia correspondiente a mutant

![Secuencia stats.png](imagenes%2FSecuencia%20stats.png)

Diagrama de secuencia correspondiente a stats

![Secuencia mutant.png](imagenes%2FSecuencia%20mutant.png)
## 📊 Cobertura de Código (>80%)

La aplicación cuenta con cobertura de código muy por encima del 80%.

![Test classees.png](imagenes%2FTest%20classees.png)

Resultado Packages

![Test pakages.png](imagenes%2FTest%20pakages.png)

Realice un segúndo coverage con el test de cobertura predeterminado mediante la herramienta integrada en Intellij.

![CoverageIntellij.png](imagenes%2FCoverageIntellij.png)


## 🧪 Ejemplos de funcionamiento en Local con (Postman)

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

## 🗄️ Base de datos H2 para guardar los ADN´s verificados por la API.
Se utilizó H2 como base de datos para almacenar todas las secuencias de adn, sin que se repitan, 
pero guardando el numero de veces que se realizo la misma request.

![H2.png](imagenes%2FH2.png)

## 🗄️ Prueba de documentación con Swagger
#### Funcionamiento POST o GET en Swagger
<pre><code>https://examen-parcial-mercadolibre.onrender.com/swagger-ui/index.html</code></pre>
![Swagger.png](imagenes%2FSwagger.png)

## 🧪 Ejemplos de funcionamiento (Render + Postman)

#### Funcionamiento POST en Render
<pre><code>POST: https://examen-parcial-mercadolibre.onrender.com/mutant</code></pre>
![renderPost.png](imagenes%2FrenderPost.png)

#### Funcionamiento GET en Render
<pre><code>GET:  https://examen-parcial-mercadolibre.onrender.com/stats</code></pre>
![renderGet.png](imagenes%2FrenderGet.png)



## 🔨 Pruebas de rendimiento JMeter
Se realizaron pruebas de rendimiento de manera local Tanto POST como GET, se probó desde 100
usuarios por segundo hasta 5000, respondiendo correctamente la aplicación hasta 2099 sin presentar error en la petición.
Cabe destacar que elegí un Ramp-up period de 1 segundo, lo que significa que en tan solo un segundo se recibieron las 2099 peticiones.
En las imagenes que se muestran a continuación se utilizo JMeter (5.6.3) 

![jmeterGetT.png](imagenes%2FjmeterGetT.png)
![jmeterGetT2.png](imagenes%2FjmeterGetT2.png)
![jmeterPostT.png](imagenes%2FjmeterPostT.png)

Para más información sobre el reto, la implementación del resto de tecnologias y temas como la eficiencia
y la complejidad cuadrática del algoritmo visitar mi pagina:

<a href="https://thebestdeveloper95.github.io/Documentacion-HTML-Examen-Mercadolibre/" target="_blank">Como afronté el Examen de Mercadolibre</a>

## 🏆 Desafíos cumplidos:
### Nivel 1: ✓
### Nivel 2: ✓ 
### Nivel 3: ✓

## 🧬 Posibles Pruebas unitarias
- **Mutante 1**

<pre><code>{
"dna": ["AAAA", "CCCC", "TCAG", "GGTC"]
}</code></pre>
- **Humano 1**

<pre><code>{
    "dna": ["AAAT", "AACC", "AAAC", "CGGG"]
}</code></pre>


- **Mutante 2**
<pre><code>{
    "dna": ["TGAC", "AGCC", "TGAC", "GGTC"]
}</code></pre>

- **Humano 2**
<pre><code>{
    "dna": ["TGAC", "ATCC", "TAAG", "GGTC"]
}</code></pre>

- **Mutante 3**
<pre><code>{
    "dna": ["TCGGGTGAT", "TGATCCTTT", "TACGAGTGA", "AAATGTACG", "ACGAGTGCT", "AGACACATG", "GAATTCCAA", "ACTACGACC", "TGAGTATCC"]
}</code></pre>

- **Mutante 4**
<pre><code>{
    "dna": ["TTTTTTTTT", "TTTTTTTTT", "TTTTTTTTT", "TTTTTTTTT", "CCGACCAGT", "GGCACCTCA", "AGGACACTA", "CAAAGGCAT", "GCAGTCCCC"]
}</code></pre>


## 🧬 Live test (Render)

- **Swagger** https://examen-parcial-mercadolibre.onrender.com/swagger-ui/index.html
- **H2**  https://examen-parcial-mercadolibre.onrender.com/h2-console
<pre><code>LEVANTAR H2 con este URL JDBC:  jdbc:h2:mem:testdb
</code></pre>
- **Mutant check url (POST)**  https://examen-parcial-mercadolibre.onrender.com/mutant
- **Stats url (GET)**  https://examen-parcial-mercadolibre.onrender.com/stats
