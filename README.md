# EndGame

**EndGame** es la primera historia de un juego de historias interactivas. Ambientado en el año 2612. Este proyecto es una crítica social al capitalismo que permite a los jugadores tomar decisiones que afectan directamente el desarrollo de la trama.


### Sobre el juego

**EndGame** presenta una historia ambientada en un mundo distópico. Las elecciones de los jugadores son fundamentales, ya que afectan no solo el destino de su historia, sino también el curso del mundo.

**Cada decisión tiene un impacto significativo y podría cambiar los resultados futuros.**

### Características principales

- **Sistema de inicio de sesión** con roles de usuario.
- **Elecciones** con consecuencias que alteran la narrativa.
- **Una historia disponible por ahora**, con planes de implementar más en el futuro.
- **Base de datos relacional** para gestionar usuarios, historias y progresos.

---

### Tecnologías utilizadas

#### Backend
- **Java 21**
- **Spring Boot**
- **MySQL**
- **JPA/Hibernate**

#### Testing
- **JUnit**
- **Mockito**
- **Cobertura del 65%**

#### Herramientas
- **VSCode**
- **Postman**

---

### Requisitos de instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tuusuario/endgame.git
   cd endgame
   ```

2. **Configurar la base de datos MySQL**:
   - Crear una base de datos llamada `endgame`.
   - Actualizar el archivo `application.properties` con las credenciales de tu base de datos.

3. **Construir el proyecto**:
   - Asegúrate de tener Maven instalado.
   - Ejecuta el siguiente comando:
     ```bash
     mvn clean install
     ```

4. **Ejecutar la aplicación**:
   ```bash
   mvn spring-boot:run
   ```

5. **Probar la API con Postman**:
   - Importa el archivo de colección Postman que se encuentra en `docs/postman_collection.json`.

6. **Ejecutar las pruebas unitarias**:
   - Usa el comando:
     ```bash
     mvn test
     ```

---


---

### Estado del proyecto

- **Cobertura de pruebas**: 65%+
- **Funcionalidades principales implementadas**: completadas.
- **Pendientes**:
  - Continuar la historia.
  - Implementar más historias.
  - Añadir elementos más visuales.


## Diagramas del Proyecto
# End Game

## Diagramas del Proyecto

### Diagrama Entidad-Relación
Este diagrama describe la estructura de la base de datos utilizada en el proyecto.

![Diagrama Entidad-Relación](https://i.imgur.com/sv8nkSY.png "Diagrama Entidad-Relación")

---

### Diagrama UML
El siguiente diagrama UML muestra la estructura de clases y las relaciones entre ellas.

![Diagrama UML](https://www.planttext.com/api/plantuml/png/lLR1RXiX4BrRyZ-Wd8Zg77grgYf9VMYaA8wIvWCmq5qalBZ09cgZ_7lPDR03dZXHrTO7sxo1cRTl7h3dpZFh-wsUpxXcpf47rpEh37cUpqZuV52T9qf4D6Bttggk8PtPRgn4GznOAoji5z8_6IiYUcSqiKR7aJQDwkXf73dflumPw3xHaknpf7YJuwSfDAsyWRHeGHB9Kyu6wLxciwJ9GBNKuouJBxIOu9mvGA-J789v9I07QdzLpXkhM4KWmIKB8HstQiULwIOUgmd4cC0mM8-pMO-nYiiQ5lnVJ6wjQQnqjL4JNB9ferekbDXeywENJ30NvrmRplIAUKc-IzucHTC-w0jxvswqfVvDc2IONLzmtpEjVZ5x6xQL4epclRCaWU42j2u2EBVQgPpPvhMaQSucR0au9scH9Y6kMdrR_w6nG0RQvYTAAEOQwGwhlSywO3qrqHDx3FV4OPs_PWjGWkwolWajwLpqlhsNzb5ncUaaMx4GavrNF1Ie3hb5FYcFdmXrwkk0Vm9j-KpsfaaGnPk2fW6AfpG9efM3yHRKMM5htkFbHwC4USlG1vd_vJOixmDKjO03mS8eg5MkV73IhgHdIYVThxOx3ToHmqGR9eRnvS_XksDRIVlu1sSL7_2WeH4VzB6o2Jo3faTlnmLvov2BuUPU3ZeW_Kgvuybv9GgRf0rmyl64d9sDF-EjcSzp4CYl5bXmEgYEHSDJunE0m-Spk5En-hMqDVaZSP03RJqszLnsOdmb-mq0 "Diagrama UML")

---

### Diagrama de Testing
Este diagrama muestra cómo se organizan y ejecutan las pruebas en el proyecto.

![Diagrama de Testing](https://i.imgur.com/WaM22FN.png "Diagrama de Testing")





---

### Contribuciones

Si deseas contribuir, por favor sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una rama con un nombre descriptivo:
   ```bash
   git checkout -b feature/nombre-funcionalidad
   ```
3. Envía un pull request describiendo tus cambios.

---



