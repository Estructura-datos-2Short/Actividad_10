package Actividad_Arboles;

/**
 * Clase Arbol: implementa un Arbol Binario de Busqueda (ABB).
 *
 * Glosario de terminologia del arbol utilizada en esta clase:
 *
 * - RAIZ: nodo principal del arbol, sin padre. Es el punto de entrada.
 * - HOJA: nodo sin hijos. Es el nivel mas bajo de una rama.
 * - NODO INTERNO: nodo que tiene al menos un hijo.
 * - PADRE: nodo que tiene referencia a otro nodo (su hijo).
 * - HIJO: nodo al que apunta un padre (izquierdo o derecho).
 * - HERMANO: nodos que comparten el mismo padre.
 * - ANCESTRO: cualquier nodo en el camino desde la raiz hasta un nodo dado.
 * - DESCENDIENTE: cualquier nodo alcanzable desde un nodo dado hacia abajo.
 * - ALTURA DEL ARBOL: numero de aristas en el camino mas largo desde la raiz
 *   hasta una hoja.
 * - PROFUNDIDAD DE UN NODO: numero de aristas desde la raiz hasta ese nodo.
 * - GRADO DE UN NODO: numero de hijos directos que tiene ese nodo (0, 1 o 2).
 */
public class Arbol {

    // La RAIZ es el nodo principal del arbol. Es el punto de partida para
    // cualquier recorrido o busqueda dentro de la estructura.
    Nodo raiz;

    /**
     * Constructor del arbol.
     * Al iniciar, el arbol esta vacio, es decir, la raiz es nula.
     */
    public Arbol() {
        this.raiz = null;
    }

    // =========================================================================
    // INSERCION
    // =========================================================================

    /**
     * Inserta un nuevo valor en el arbol respetando la propiedad del ABB:
     * - Valores menores al nodo actual van al subArbol IZQUIERDO.
     * - Valores mayores al nodo actual van al subArbol DERECHO.
     * - Valores duplicados no se insertan.
     *
     * @param valor El dato entero a insertar.
     */
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    /**
     * Metodo auxiliar recursivo para insertar un valor.
     * La recursion baja por el arbol hasta encontrar la posicion correcta.
     *
     * Relacion PADRE-HIJO: cada llamada recursiva desciende de un nodo PADRE
     * hacia su HIJO izquierdo o derecho segun la propiedad del ABB.
     *
     * @param nodoActual El nodo que se esta evaluando en esta llamada.
     * @param valor      El valor a insertar.
     * @return El nodo actualizado (con el nuevo descendiente insertado).
     */
    private Nodo insertarRecursivo(Nodo nodoActual, int valor) {
        // Caso base: posicion vacia encontrada, se crea la HOJA nueva
        if (nodoActual == null) {
            return new Nodo(valor);
        }

        if (valor < nodoActual.valor) {
            // El valor es menor: se inserta en el subArbol IZQUIERDO
            // El nodo actual es ANCESTRO del nuevo nodo
            nodoActual.izquierdo = insertarRecursivo(nodoActual.izquierdo, valor);
        } else if (valor > nodoActual.valor) {
            // El valor es mayor: se inserta en el subArbol DERECHO
            // El nodo actual es ANCESTRO del nuevo nodo
            nodoActual.derecho = insertarRecursivo(nodoActual.derecho, valor);
        }
        // Si valor == nodoActual.valor, no se inserta (sin duplicados)

        return nodoActual;
    }

    // =========================================================================
    // RECORRIDOS
    // =========================================================================

    /**
     * Recorrido PREORDEN: Raiz -> Izquierdo -> Derecho.
     * Visita el nodo actual antes que sus DESCENDIENTES.
     * Util para copiar o serializar el arbol.
     */
    public void preorden() {
        System.out.print("Preorden:  ");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo == null) return;
        System.out.print(nodo.valor + " ");      // Visita la RAIZ local
        preordenRecursivo(nodo.izquierdo);        // Recorre HIJOS izquierdos
        preordenRecursivo(nodo.derecho);          // Recorre HIJOS derechos
    }

    /**
     * Recorrido INORDEN: Izquierdo -> Raiz -> Derecho.
     * En un ABB, este recorrido produce los valores en orden ASCENDENTE,
     * lo que confirma que la propiedad de orden se respeta correctamente.
     */
    public void inorden() {
        System.out.print("Inorden:   ");
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo == null) return;
        inordenRecursivo(nodo.izquierdo);         // DESCENDIENTES izquierdos primero
        System.out.print(nodo.valor + " ");       // Luego el nodo actual
        inordenRecursivo(nodo.derecho);           // Luego DESCENDIENTES derechos
    }

    /**
     * Recorrido POSTORDEN: Izquierdo -> Derecho -> Raiz.
     * Visita todos los DESCENDIENTES antes que el nodo actual.
     * Util para eliminar o liberar nodos del arbol.
     */
    public void postorden() {
        System.out.print("Postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo == null) return;
        postordenRecursivo(nodo.izquierdo);       // Primero los HIJOS
        postordenRecursivo(nodo.derecho);
        System.out.print(nodo.valor + " ");       // Luego el ANCESTRO
    }

    // =========================================================================
    // PROPIEDADES DEL ARBOL
    // =========================================================================

    /**
     * Calcula la ALTURA del arbol.
     * La altura es el numero de aristas en el camino mas largo desde
     * la RAIZ hasta la HOJA mas lejana.
     * Un arbol con un solo nodo (la raiz) tiene altura 0.
     * Un arbol vacio tiene altura -1.
     *
     * @return La altura del arbol.
     */
    public int getAltura() {
        return calcularAltura(raiz);
    }

    /**
     * Metodo auxiliar recursivo para calcular la altura.
     * La altura de un nodo es 1 + el maximo entre la altura de su
     * subArbol IZQUIERDO y su subArbol DERECHO.
     * Cada nivel adicional de DESCENDIENTES suma 1 a la altura.
     */
    private int calcularAltura(Nodo nodo) {
        if (nodo == null) return -1; // Arbol vacio

        // HOJA: ambos hijos son nulos, altura local = 0
        int alturaIzquierda = calcularAltura(nodo.izquierdo);
        int alturaDerecha = calcularAltura(nodo.derecho);

        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    /**
     * Cuenta el numero de HOJAS del arbol.
     * Una HOJA es un nodo sin hijos izquierdo ni derecho.
     *
     * @return El total de hojas en el arbol.
     */
    public int contarHojas() {
        return contarHojasRecursivo(raiz);
    }

    /**
     * Metodo auxiliar recursivo para contar hojas.
     * Si el nodo no tiene HIJOS, es una HOJA y suma 1.
     */
    private int contarHojasRecursivo(Nodo nodo) {
        if (nodo == null) return 0;

        // Es una HOJA: no tiene hijo izquierdo ni derecho
        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }

        // Es un NODO INTERNO: tiene al menos un HIJO, se sigue bajando
        return contarHojasRecursivo(nodo.izquierdo)
             + contarHojasRecursivo(nodo.derecho);
    }

    /**
     * Calcula la PROFUNDIDAD de un nodo con el valor dado.
     * La profundidad es el numero de aristas desde la RAIZ hasta el nodo.
     * La RAIZ tiene profundidad 0.
     * Cada nivel de DESCENDENCIA suma 1 a la profundidad.
     *
     * @param valor El valor del nodo cuya profundidad se quiere conocer.
     * @return La profundidad del nodo, o -1 si no existe en el arbol.
     */
    public int getProfundidad(int valor) {
        return calcularProfundidad(raiz, valor, 0);
    }

    /**
     * Metodo auxiliar recursivo para calcular la profundidad.
     * Cada llamada recursiva representa un nivel mas profundo en el arbol
     * (un ANCESTRO mas entre la raiz y el nodo buscado).
     */
    private int calcularProfundidad(Nodo nodo, int valor, int nivel) {
        if (nodo == null) return -1; // Nodo no encontrado

        if (nodo.valor == valor) {
            return nivel; // Profundidad encontrada
        }

        if (valor < nodo.valor) {
            // El nodo buscado es DESCENDIENTE del subArbol izquierdo
            return calcularProfundidad(nodo.izquierdo, valor, nivel + 1);
        } else {
            // El nodo buscado es DESCENDIENTE del subArbol derecho
            return calcularProfundidad(nodo.derecho, valor, nivel + 1);
        }
    }

    /**
     * Calcula el GRADO de un nodo con el valor dado.
     * El grado es el numero de HIJOS directos que tiene el nodo (0, 1 o 2).
     * - Grado 0: el nodo es una HOJA.
     * - Grado 1: el nodo tiene un solo HIJO.
     * - Grado 2: el nodo es un NODO INTERNO con dos HIJOS (HERMANOS entre si).
     *
     * @param valor El valor del nodo cuyo grado se quiere conocer.
     * @return El grado del nodo, o -1 si no se encuentra en el arbol.
     */
    public int getGrado(int valor) {
        Nodo nodo = buscarNodo(raiz, valor);
        if (nodo == null) return -1;

        int grado = 0;
        if (nodo.izquierdo != null) grado++; // Tiene HIJO izquierdo
        if (nodo.derecho != null) grado++;   // Tiene HIJO derecho

        // Si grado == 2, los dos hijos son HERMANOS entre si
        return grado;
    }

    /**
     * Metodo auxiliar para buscar un nodo por valor en el arbol.
     * Aprovecha la propiedad del ABB para descartar subArboles enteros.
     */
    private Nodo buscarNodo(Nodo nodo, int valor) {
        if (nodo == null) return null;
        if (nodo.valor == valor) return nodo;

        if (valor < nodo.valor) {
            return buscarNodo(nodo.izquierdo, valor);
        } else {
            return buscarNodo(nodo.derecho, valor);
        }
    }

    // =========================================================================
    // REPRESENTACION VISUAL EN CONSOLA
    // =========================================================================

    /**
     * Imprime el arbol de forma visual en consola usando caracteres ASCII.
     * Permite identificar claramente los niveles jerarquicos y las
     * relaciones PADRE-HIJO entre los nodos.
     *
     * La RAIZ aparece en la parte superior.
     * Los HIJOS se muestran debajo con indentacion.
     * Las HOJAS son los nodos sin ramas adicionales.
     */
    public void imprimirArbol() {
        System.out.println("Representacion grafica del arbol:");
        imprimirRecursivo(raiz, "", true);
    }

    /**
     * Metodo auxiliar recursivo para imprimir el arbol con caracteres ASCII.
     *
     * @param nodo     El nodo actual a imprimir.
     * @param prefijo  La indentacion acumulada segun el nivel.
     * @param esUltimo Indica si el nodo actual es el ultimo HIJO de su PADRE.
     */
    private void imprimirRecursivo(Nodo nodo, String prefijo, boolean esUltimo) {
        if (nodo == null) return;

        // Caracter de conexion: "└──" para el ultimo hijo, "├──" para los demas
        String conector = esUltimo ? "└── " : "├── ";
        System.out.println(prefijo + conector + nodo.valor);

        // Indentacion para los DESCENDIENTES del nodo actual:
        // Si el nodo NO es el ultimo, se agrega "│   " para mantener la linea vertical
        // Si el nodo SI es el ultimo, se agrega espacios vacios
        String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");

        // Se imprimen primero los HIJOS izquierdos, luego los derechos.
        // El HIJO derecho sera siempre el "ultimo" de los dos (esUltimo = true).
        // Los dos hijos son HERMANOS entre si.
        if (nodo.izquierdo != null || nodo.derecho != null) {
            if (nodo.izquierdo != null && nodo.derecho != null) {
                // NODO INTERNO con dos HIJOS: el izquierdo no es el ultimo
                imprimirRecursivo(nodo.izquierdo, nuevoPrefijo, false);
                // El HIJO derecho es el ultimo HERMANO
                imprimirRecursivo(nodo.derecho, nuevoPrefijo, true);
            } else if (nodo.izquierdo != null) {
                // Solo tiene HIJO izquierdo, es el unico, por lo tanto es el ultimo
                imprimirRecursivo(nodo.izquierdo, nuevoPrefijo, true);
            } else {
                // Solo tiene HIJO derecho, es el unico, por lo tanto es el ultimo
                imprimirRecursivo(nodo.derecho, nuevoPrefijo, true);
            }
        }
    }
}
