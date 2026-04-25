package Actividad_Arboles;

/**
 * Clase Nodo: representa cada elemento dentro del Arbol Binario de Busqueda.
 *
 * Terminologia aplicada en esta clase:
 * - El primer nodo que se inserta en el arbol es la RAIZ. No tiene padre.
 * - Un nodo que no tiene hijos (izquierdo ni derecho) es una HOJA.
 * - Un nodo que tiene al menos un hijo (izquierdo o derecho) es un NODO INTERNO.
 * - Las referencias 'izquierdo' y 'derecho' representan la relacion PADRE-HIJO:
 *     el nodo actual es el padre, y los nodos a los que apunta son sus hijos.
 */
public class Nodo {

    // Valor entero almacenado en este nodo
    int valor;

    // Referencia al hijo izquierdo (valores menores que el nodo actual)
    Nodo izquierdo;

    // Referencia al hijo derecho (valores mayores que el nodo actual)
    Nodo derecho;

    /**
     * Constructor del nodo.
     * Al crearse, el nodo no tiene hijos, por lo tanto es una HOJA.
     * Si este es el primer nodo insertado en el arbol, sera la RAIZ.
     *
     * @param valor El dato entero que almacena este nodo.
     */
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null; // Sin hijo izquierdo al inicio
        this.derecho = null;   // Sin hijo derecho al inicio
    }
}
