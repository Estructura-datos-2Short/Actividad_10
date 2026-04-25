# Actividad: Implementación de Estructuras No Lineales - Árboles

**Estudiante:** Larry David Botia Contreras
**Materia:** Estructura de Datos
**Docente:** Endi Jainner Romero

---

## Objetivo

El proyecto implementa un Árbol Binario de Búsqueda (ABB) en Java para representar y trabajar con estructuras de datos no lineales. A través de esta aplicación se demuestran los conceptos fundamentales de los árboles: terminología, clasificación, recorridos, propiedades estructurales y representación visual jerárquica por consola.

---

## Tipo de árbol implementado

Se implementó un **Árbol Binario de Búsqueda (ABB)**.

Un ABB es un árbol binario donde cada nodo puede tener máximo dos hijos: un hijo izquierdo y un hijo derecho. Además, cumple estrictamente la propiedad de orden:

- Los valores **menores** al nodo actual se ubican en el subárbol **izquierdo**.
- Los valores **mayores** al nodo actual se ubican en el subárbol **derecho**.
- No se permiten valores duplicados.

Esta propiedad garantiza que el recorrido en inorden siempre produce los valores en orden ascendente.

---

## Clasificación de árboles

### Árbol general
Un árbol general es una estructura jerárquica donde cada nodo puede tener cualquier cantidad de hijos. No impone restricciones sobre el número de descendientes ni sobre el orden de los valores.

### Árbol binario
Un árbol binario es un caso especial del árbol general donde cada nodo puede tener **máximo dos hijos**: uno izquierdo y uno derecho. No impone ningún orden entre los valores.

### Árbol Binario de Búsqueda (ABB)
Un ABB es un árbol binario que cumple la propiedad de orden descrita anteriormente. Esta propiedad permite realizar búsquedas, inserciones y eliminaciones de forma eficiente, en tiempo promedio O(log n).

### Árbol AVL
Un árbol AVL es un ABB **auto-balanceado**. Garantiza que la diferencia de altura entre el subárbol izquierdo y el derecho de cualquier nodo no supere 1. Esto evita que el árbol se degenere en una lista enlazada en el peor caso. Utiliza rotaciones para mantener el balance tras cada inserción o eliminación.

---

## Justificación del modelo usado

Se eligió el **Árbol Binario de Búsqueda (ABB)** por las siguientes razones:

- **Es fácil de representar:** su estructura binaria (máximo dos hijos por nodo) simplifica la implementación en código.
- **Permite aplicar reglas de orden:** cada inserción respeta la propiedad del ABB, lo que garantiza que la estructura siempre esté organizada.
- **Facilita los recorridos:** los recorridos en preorden, inorden y postorden se implementan de forma natural con recursión.
- **Permite identificar toda la terminología técnica:** en un ABB se puede señalar claramente la raíz, las hojas, los nodos internos, las relaciones padre-hijo, los hermanos, los ancestros y los descendientes.
- **Cumple con los criterios de clasificación y lógica solicitados:** el ABB es un árbol binario con restricciones de orden, lo que lo ubica dentro de la clasificación de árboles binarios especiales.

---

## Funcionalidades del programa

| Funcionalidad               | Descripción                                                                 |
|-----------------------------|-----------------------------------------------------------------------------|
| Inserción de nodos          | Agrega valores respetando la propiedad del ABB (menores a la izquierda, mayores a la derecha). |
| Recorrido preorden          | Visita: raíz → hijo izquierdo → hijo derecho.                               |
| Recorrido inorden           | Visita: hijo izquierdo → raíz → hijo derecho. Produce valores en orden ascendente. |
| Recorrido postorden         | Visita: hijo izquierdo → hijo derecho → raíz.                               |
| Cálculo de altura           | Retorna el número de aristas en el camino más largo desde la raíz hasta la hoja más lejana. |
| Conteo de hojas             | Cuenta los nodos sin hijos (grado 0).                                       |
| Cálculo de profundidad      | Retorna el número de aristas desde la raíz hasta un nodo específico.        |
| Cálculo de grado            | Retorna el número de hijos directos de un nodo específico (0, 1 o 2).      |
| Impresión visual por consola | Muestra el árbol con caracteres ASCII indicando niveles y relaciones padre-hijo. |

---

## Estructura del proyecto

```
Actividad_Arboles/
│
├── src/
│   └── Actividad_Arboles/
│       ├── Nodo.java         <- Representa cada nodo del árbol
│       ├── Arbol.java        <- Lógica completa del ABB
│       └── Principal.java    <- Punto de entrada del programa
│
└── README.md
```

---

## Cómo ejecutar el proyecto

### Desde terminal (Linux, macOS o Windows con JDK instalado)

**1. Compilar:**
```bash
javac -d bin src/Actividad_Arboles/*.java
```

**2. Ejecutar:**
```bash
java -cp bin Actividad_Arboles.Principal
```

### Desde Visual Studio Code

1. Abrir la carpeta `Actividad_Arboles/` en VS Code.
2. Asegurarse de tener instalada la extensión **Extension Pack for Java** de Microsoft.
3. Abrir el archivo `Principal.java`.
4. Hacer clic en el botón **Run** que aparece encima del método `main`, o presionar `F5`.

> Se recomienda tener instalado el JDK 11 o superior.

---

## Ejemplo de salida esperada

```
============================================================
   ACTIVIDAD: ARBOL BINARIO DE BUSQUEDA (ABB)
   Estudiante: Larry David Botia Contreras
   Materia: Estructura de Datos
   Docente: Endi Jainner Romero
============================================================

Valores insertados: 50 30 70 20 40 60 80
(El primer valor insertado, 50, es la RAIZ del arbol.)

--- Recorridos del arbol ---
Preorden:  50 30 20 40 70 60 80
Inorden:   20 30 40 50 60 70 80
Postorden: 20 40 30 60 80 70 50

--- Propiedades del arbol ---
Altura del arbol:           2
Numero de hojas:            4

Profundidad del nodo 40:       2 (aristas desde la RAIZ hasta el nodo 40)
Profundidad de la RAIZ (50): 0 (la RAIZ siempre tiene profundidad 0)

Grado del nodo 30:             2 hijo(s) directo(s)
  (Los hijos de 30 son 20 y 40, que son HERMANOS entre si.)
Grado del nodo 20 (HOJA):   0 hijo(s) directo(s) (es una HOJA, no tiene hijos)

--- Representacion grafica del arbol ---
Representacion grafica del arbol:
└── 50
    ├── 30
    │   ├── 20
    │   └── 40
    └── 70
        ├── 60
        └── 80

Leyenda:
  RAIZ:          50 (nivel 0, profundidad 0)
  NODOS INTERNOS: 30 y 70 (tienen hijos)
  HOJAS:         20, 40, 60, 80 (sin hijos)
  HERMANOS:      30 y 70 comparten PADRE (50)
                 20 y 40 comparten PADRE (30)
                 60 y 80 comparten PADRE (70)
  ANCESTROS de 20: 30 y 50
  DESCENDIENTES de 70: 60 y 80
============================================================
```

---

## Terminología aplicada

| Término       | Descripción                                                                 | Ejemplo en este árbol             |
|---------------|-----------------------------------------------------------------------------|-----------------------------------|
| Raíz          | Nodo principal sin padre. Punto de entrada del árbol.                       | Nodo 50                           |
| Hoja          | Nodo sin hijos (grado 0).                                                   | Nodos 20, 40, 60, 80              |
| Nodo interno  | Nodo con al menos un hijo.                                                  | Nodos 50, 30, 70                  |
| Padre         | Nodo que tiene referencia a otro nodo (su hijo).                            | 50 es padre de 30 y 70            |
| Hijo          | Nodo al que apunta un padre.                                                | 30 y 70 son hijos de 50           |
| Hermano       | Nodos que comparten el mismo padre.                                         | 30 y 70 son hermanos              |
| Ancestro      | Cualquier nodo en el camino desde la raíz hasta un nodo dado.               | Ancestros de 20: 30 y 50          |
| Descendiente  | Cualquier nodo alcanzable desde un nodo dado hacia abajo.                   | Descendientes de 70: 60 y 80      |
| Altura        | Aristas en el camino más largo desde la raíz hasta la hoja más lejana.     | Altura del árbol: 2               |
| Profundidad   | Número de aristas desde la raíz hasta un nodo específico.                  | Profundidad de 40: 2              |
| Grado         | Número de hijos directos de un nodo.                                        | Grado de 50: 2, grado de 20: 0    |
