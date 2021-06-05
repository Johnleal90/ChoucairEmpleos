# ChoucairEmpleos
Proyecto de Automatización de la sección de empleos de la página ChoucairTesting

# Tecnologías 
- Java
- Gradle

# Dependencias
- [webdrivermanager](https://github.com/bonigarcia/webdrivermanager)
- selenium
- cucumber
- JUnit

# Patrón de diseño
- Page Object Model (POM)

# Escenarios realizados
```
# language: es

Característica: como recién graduado del SENA quiero buscar vacantes poder ver la información y aplicar en ellas.

Antecedentes:
Dado      que ingreso a la sección de empleos de choucair
Cuando    voy al portal de empleos
Y         hago click en enlace de nuestras vacantes
Entonces  Se muestran las ofertas laborales

Escenario: Yo como recién graduado del SENA quiero buscar vacantes de empleo
para iniciar en el mundo laboral de esta profesión.
Dado      Me ubico en alguna vacante de la lista
Cuando    Hago click en ver oferta completa
Entonces  El sistema muestra toda la información de la vacante

Escenario: Yo como recién graduado del SENA quiero aplicar a una vacante de empleo
para iniciar en el mundo laboral de esta profesión.
Dado      Me ubico en alguna vacante de la lista
Cuando    Hago click en Aplicar a esta oferta
Y         Se selecciona la ubicación
Y         diligencio el correo electrónico en los campos indicados
Y         Acepto el tratamiento de datos
Y         doy click en continuar
Entonces  El sistema me indica el nombre de la vacante a la que estoy aplicando
```

# Ejecutar pruebas
## Windows
```java
gradle.bat clean test
```

## Linux
```java
./gradlew clean test
```

# Reportes
Después de ejecutada la prueba  se puede ver el reporte de cucumber haciendo click en el link que se muestra en consola, por ejemplo:

┌──────────────────────────────────────────────────────────────────────────┐
│ View your Cucumber Report at:                                            │
│ *https://reports.cucumber.io/reports/17574188-87a3-480c-8491-4975a38dbbde* │
│                                                                          │
│ This report will self-destruct in 24h.                                   │
│ Keep reports forever: https://reports.cucumber.io/profile                │

Process finished with exit code 0
└──────────────────────────────────────────────────────────────────────────┘

# Referencias 

[Page Object Model con Selenium WebDriver](https://www.tutorialselenium.com/2019/02/05/page-object-model-selenium-webdriver/amp/)

[JavaScriptExecutor in Selenium WebDriver with Example](https://www.guru99.com/execute-javascript-selenium-webdriver.html)

[Buenas prácticas de Cucumber](https://www.federico-toledo.com/buenas-practicas-de-cucumber/)

[Java-Faker](https://github.com/DiUS/java-faker)