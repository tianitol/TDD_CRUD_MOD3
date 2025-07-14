# 🧪 Proyecto CRUD con TDD – Módulo 3
Este proyecto consiste en la implementación de un CRUD completo utilizando **Java**, **Maven** y el enfoque de **Desarrollo guiado por pruebas (TDD)**. El objetivo principal fue aplicar buenas prácticas de diseño y pruebas automatizadas para garantizar un código limpio, mantenible y confiable.

## 📌 Objetivos
- Aplicar **TDD (Test-Driven Development)** en cada método del CRUD.
- Utilizar **Mockito** para simular dependencias.
- Aplicar principios de diseño como **SOLID**, **KISS**, **DRY** y **SRP**.
- Implementar pruebas unitarias con **JUnit 5**.
- Generar reporte de cobertura con **JaCoCo**.
- Documentar el proceso de desarrollo a través de commits representativos.


🔗 https://github.com/tianitol/TDD_CRUD_MOD3

---


## 🧪 Enfoque TDD
Cada método del CRUD fue desarrollado siguiendo el ciclo **RED → GREEN → REFACTOR**:

1. **RED**: Se escribió primero el test que falla.
2. **GREEN**: Se implementó el código mínimo necesario para que el test pase.
3. **REFACTOR**: Se aplicaron principios de diseño para mejorar la calidad del código.

#### Los commits del repositorio reflejan claramente cada etapa del ciclo TDD para los métodos:

- createItem()
- getItemById()
- getItems()
- deleteItemById()
- updateItemById()

## 🧪 Mockito
Se utilizó **Mockito** para simular el comportamiento del repositorio (`ItemRepository`) en los tests de `ItemService`, permitiendo aislar la lógica de negocio y validar interacciones como:

```java
when(itemRepository.save(item)).thenReturn(item);
verify(itemRepository, times(1)).save(item);
```

---


## 🗃️ Persistencia
Aunque la consigna sugería utilizar una base de datos, se optó por implementar una solución más simple y enfocada en el objetivo del módulo: **ItemRepositoryInMemory**, una clase que simula una base de datos utilizando un Map<Integer, Item> como almacenamiento.

Esto permitió concentrarse en el diseño, pruebas y principios sin añadir complejidad innecesaria.

---

## 🧠 Principios de diseño aplicados
- **SRP (Single Responsibility Principle)**: Separación clara entre validación, lógica de negocio y persistencia.
- **KISS (Keep It Simple, Stupid)**: Métodos simples, claros y enfocados.
- **DRY (Don't Repeat Yourself)**: Reutilización de validaciones comunes como validateItemExists().
- **Open/Closed Principle**: Clases preparadas para extenderse sin ser modificadas.
- **Modularidad**: Separación de responsabilidades en paquetes como validation, exception, repository.

---

## 📊 Reporte de cobertura con JaCoCo
Se utilizó **JaCoCo** para generar un reporte de cobertura de código. Este reporte permite visualizar qué partes del código están cubiertas por pruebas y detectar posibles áreas sin testear.

#### Para generar el reporte:

```shell
mvn clean test
mvn jacoco:report
```

#### El reporte HTML se encuentra en:

```
target/site/jacoco/index.html
```

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
```
   git clone https://github.com/tianitol/TDD_CRUD_MOD3.git
   cd TDD_CRUD_MOD3
```

2. Ejecuta los tests:
```
   mvn test
```

3. Genera el reporte de cobertura:
```
   mvn jacoco:report
```




