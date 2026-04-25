package Actividad_Arboles;

/**
 * Clase Principal: punto de entrada del programa.
 *
 * Esta clase demuestra el funcionamiento completo del Arbol Binario de
 * Busqueda (ABB). Se crean los nodos, se insertan en orden correcto y
 * se muestran todas las propiedades y recorridos del arbol en consola.
 * Se incluye una representacion grafica del arbol utilizando caracteres ASCII
 * para visualizar claramente la estructura jerarquica, las relaciones entre
 * los nodos (PADRE-HIJO, HERMANOS) y las caracteristicas de cada nodo (RAIZ, NODOS INTERNOS, HOJAS).
 */
public class Principal {

    public static void main(String[] args) {

        // Se crea el objeto Arbol. Al inicio esta vacio (raiz = null).
        Arbol arbol = new Arbol();

        // =====================================================================
        // INSERCION DE NODOS
        // El primer valor insertado (50) se convierte en la RAIZ del arbol.
        // Los valores siguientes se ubican segun la propiedad del ABB:
        //   - Menores a la izquierda
        //   - Mayores a la derecha
        // =====================================================================

        int[] valores = {50, 30, 70, 20, 40, 60, 80};

        System.out.println("============================================================");
        System.out.println("   ACTIVIDAD: ARBOL BINARIO DE BUSQUEDA (ABB)");
        System.out.println("   Estudiante: Larry David Botia Contreras");
        System.out.println("   Materia: Estructura de Datos");
        System.out.println("   Docente: Endi Jainner Romero");
        System.out.println("============================================================");
        System.out.println();

        System.out.print("Valores insertados: ");
        for (int valor : valores) {
            arbol.insertar(valor);
            System.out.print(valor + " ");
        }
        System.out.println();
        System.out.println("(El primer valor insertado, 50, es la RAIZ del arbol.)");
        System.out.println();

        // =====================================================================
        // RECORRIDOS DEL ARBOL
        // Los recorridos visitan cada nodo una sola vez en un orden especifico.
        // =====================================================================

        System.out.println("--- Recorridos del arbol ---");
        arbol.preorden();    // Raiz -> Izquierdo -> Derecho
        arbol.inorden();     // Izquierdo -> Raiz -> Derecho (resultado en orden ascendente)
        arbol.postorden();   // Izquierdo -> Derecho -> Raiz
        System.out.println();

        // =====================================================================
        // PROPIEDADES DEL ARBOL
        // =====================================================================

        System.out.println("--- Propiedades del arbol ---");

        // Altura: camino mas largo desde la RAIZ hasta la HOJA mas lejana
        System.out.println("Altura del arbol:           " + arbol.getAltura());

        // Numero de HOJAS: nodos sin hijos
        System.out.println("Numero de hojas:            " + arbol.contarHojas());
        System.out.println();

        // Profundidad del nodo 40: numero de aristas desde la RAIZ hasta ese nodo
        int nodoProfundidad = 40;
        int profundidad = arbol.getProfundidad(nodoProfundidad);
        System.out.println("Profundidad del nodo " + nodoProfundidad + ":       "
                + profundidad + " (aristas desde la RAIZ hasta el nodo " + nodoProfundidad + ")");

        // Profundidad de la RAIZ (debe ser 0)
        System.out.println("Profundidad de la RAIZ (50): "
                + arbol.getProfundidad(50) + " (la RAIZ siempre tiene profundidad 0)");
        System.out.println();

        // Grado del nodo 30: numero de HIJOS directos (en este caso, 2: el 20 y el 40)
        int nodoGrado = 30;
        int grado = arbol.getGrado(nodoGrado);
        System.out.println("Grado del nodo " + nodoGrado + ":             "
                + grado + " hijo(s) directo(s)");
        System.out.println("  (Los hijos de " + nodoGrado + " son 20 y 40, que son HERMANOS entre si.)");

        // Grado de una HOJA (debe ser 0)
        System.out.println("Grado del nodo 20 (HOJA):   "
                + arbol.getGrado(20) + " hijo(s) directo(s) (es una HOJA, no tiene hijos)");
        System.out.println();

        // =====================================================================
        // REPRESENTACION GRAFICA DEL ARBOL
        // Muestra la estructura jerarquica con caracteres ASCII.
        // Se pueden identificar claramente: RAIZ, NODOS INTERNOS, HOJAS,
        // relaciones PADRE-HIJO, HERMANOS, ANCESTROS y DESCENDIENTES.
        // =====================================================================

        System.out.println("--- Representacion grafica del arbol ---");
        arbol.imprimirArbol();
        System.out.println();
        System.out.println("Leyenda:");
        System.out.println("  RAIZ:          50 (nivel 0, profundidad 0)");
        System.out.println("  NODOS INTERNOS: 30 y 70 (tienen hijos)");
        System.out.println("  HOJAS:         20, 40, 60, 80 (sin hijos)");
        System.out.println("  HERMANOS:      30 y 70 comparten PADRE (50)");
        System.out.println("                 20 y 40 comparten PADRE (30)");
        System.out.println("                 60 y 80 comparten PADRE (70)");
        System.out.println("  ANCESTROS de 20: 30 y 50");
        System.out.println("  DESCENDIENTES de 70: 60 y 80");
        System.out.println("============================================================");
    }
}
