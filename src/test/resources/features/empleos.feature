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