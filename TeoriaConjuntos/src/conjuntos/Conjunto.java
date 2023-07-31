package conjuntos;

import java.util.Arrays;

public class Conjunto implements ConjuntoInterface {

  private int[] array;

  @Override
  public int[] intersection(int[] a, int[] b) {
    if (a.length == 0 || b.length == 0 ) throw new IllegalStateException("Conjunto vacio!");

    mergeSort(a, 0, a.length - 1); // ordenar el primer conjunto
    mergeSort(b, 0, b.length - 1); // ordenar el segundo conjunto

    int[] c = new int[a.length];
    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length) {
      if (a[i] == b[j]) {
        c[k] = a[i];
        k++;
        i++;
        j++;
      } else {
    	  if (a[i] < b[j]) {
    	    i++;
    	  } else { // a[i] > b[j]
    		  j++;
    	  }
      }
    }

    array = Arrays.copyOf(c, k);
    return array;
  }

  /**
   * Método de ordenamiento mergeSort (ordenamiento por mezcla).
   * Su complejidad en tiempo es: O (n * log(n)).
   * @param array un arreglo con elementos a ordenar.
   * @param left cota inferior del arreglo (por convención es 0).
   * @param right cota superior del arreglo (por convención es array.length - 1).
   */
  private void mergeSort(int[] array, int left, int right){
    if (left < right){
      int middle = (left + right) / 2;
	  mergeSort(array, left, middle);
      mergeSort(array, middle + 1, right);
      merge(array, left, middle, right);
	}
  }

  /**
   * Es invocado y utilizado por el método mergeSort, colabora en la ordenación
   * de los elementos.
   * Su complejidad en tiempo es: O (n).
   * @param array un arreglo con elementos a ordenar.
   * @param left cota inferior del arreglo.
   * @param middle la posición media del arreglo.
   * @param right cota superior del arreglo.
   */
  private void merge(int[] array, int left, int middle, int right) {
    //Tamaño de los sub arreglos
    int n1 = middle - left + 1;
    int n2 = right - middle;

    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    for (int i=0; i < n1; i++) {
      leftArray[i] = array[left+i];
    }

    for (int j=0; j < n2; j++) {
      rightArray[j] = array[middle + j + 1];
    }

    /* Unir los arrays temporales */
    //Indices del primer y segundo subvector.
    int i = 0, j = 0;
    //Indice inicial del sub array parametro.
    int k = left;

    //Ordenamiento.
    while (i < n1 && j < n2) {
      if ( leftArray[i] <= rightArray[j] ) {
        array[k] = leftArray[i];
        i++;
      } else {
          array[k] = rightArray[j];
          j++;
        }
      k++;

    }

    // Si quedan elementos por ordenar, copiar los elementos restantes de leftArray[].
    while (i < n1) {
      array[k] = leftArray[i];
      i++;
      k++;
    }

    //Copiar los elementos restantes de rightArray[].
    while (j < n2) {
      array[k] = rightArray[j];
      j++;
      k++;
    }

  }

  @Override
  public int[] union(int[] a, int[] b) {
    /* Casos bases */
	if (a.length == 0 && b.length == 0) throw new IllegalStateException("Conjunto vacio!");

    if (a.length != 0 && b.length == 0) {
      array = Arrays.copyOf(a, a.length);
      return array;
    }

    if (a.length == 0 && b.length != 0) {
      array = Arrays.copyOf(b, b.length);
      return array;
    }

    /* Caso cuando ambos conjuntos no estan vacios */
    int[] c = new int[a.length + b.length];

    /* Copio el arreglo a al arreglo c */
    int i = 0, k = 0;
    while (i < a.length) {
      c[k] = a[i];
      k++;
      i++;
    }

    /* Copio el arreglo b al arreglo c, comenzando en la posicion correcta */
    int j = k, p = 0;
    while (j < a.length + b.length) {
      c[j] = b[p];
      p++;
      j++;
    }

    mergeSort(c, 0, c.length - 1); // ordeno elementos
    array = borrarDuplicados(c); // borro duplicados
    return array;
  }

  /**
   * Borra los elementos duplicados de un arreglo. Debe trabajar si o si con elementos ordenados.
   * Complejidad temporal en peor caso: O (n).
   * @param arre un arreglo con elementos.
   * @return un arreglo sin elementos duplicados.
   */
  private int[] borrarDuplicados(int[] arre) {
	int i = 0, j = 0;
    while (i < arre.length) {
	  arre[j] = arre[i]; // el arreglo se va asignando valores a si mismo
	  j++;
	  i++;
	  while (i < arre.length && arre[i] == arre[i - 1]) {
	    i++;
      }
    }
    int[] arreAux = Arrays.copyOf(arre, j); // en arreAux se almacena el contenido de arre con una longitud de j
    return arreAux;
  }

  @Override
  public int[] diference(int[] a, int[] b) {
    /* Casos bases */
	if (a.length == 0) throw new IllegalStateException("Conjunto vacio!");

    if (b.length == 0) {
      array = Arrays.copyOf(a, a.length);
      return array;
    }
    /* Caso en que ambos arreglos no estan vacios */
    mergeSort(b, 0, b.length - 1); // Se ordena el arreglo b para aplicarle la busqueda binaria.
    int[] c = new int[a.length];
    int k = 0;
    boolean find;
    for (int i = 0; i < a.length; i++) {
      find = binarySearch(b, 0, b.length - 1, a[i]); // si a[i] está en b -> find = true sino find = false
      if (!find) {
        c[k] = a[i];
        k++;
      }
    }
    array = Arrays.copyOf(c, k);
    mergeSort(array, 0, array.length - 1);
    return array;
  }

  /**
   * Busca un elemento en un arreglo ordenado.
   * Complejidad temporal: O (log (n)).
   * @param arre un arreglo ordenado de enteros.
   * @param low la cota inferior del arreglo (por convención 0).
   * @param high la cota superior del arreglo (por convención arre.lenght - 1).
   * @param elem el elemento a buscar.
   * @return true si encuentra el elemento sino false.
   */
  private boolean binarySearch(int[] arre, int low, int high, int elem) {
    boolean find = false;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (elem == arre[mid]) {
        find = true;
        return find;
      } else {
    	  if (elem < arre[mid]) {
    	    high = mid - 1;
    	  } else { // elem > arre[mid]
    		  low = mid + 1;
    	  }
      }
    }
    return find;
  }

  @Override
  public int[] complement(int[] universal, int[] a) {
	/* Caso base */
	if (universal.length == 0 && a.length == 0) throw new IllegalStateException("Ambos conjuntos vacios!.");
    if (universal.length == 0) throw new IllegalArgumentException("Conjunto universal vacio!.");
    if (a.length == 0) {
      array = Arrays.copyOf(universal, universal.length);
      return array;
    }
    /* Caso donde a no es vacio */
    mergeSort(a, 0, a.length - 1); // se ordenan los elementos del conjunto a
    int[] c = new int[universal.length];
    int k = 0;
    boolean find;
    for (int i = 0; i < universal.length; i++) {
      find = binarySearch(a, 0, a.length - 1, universal[i]);
      if(!find) {
        c[k] = universal[i];
        k++;
      }
    }

    array = Arrays.copyOf(c, k);
    mergeSort(array, 0, array.length - 1);
    return array;
  }

  @Override
  public int[] simetricDiference(int[] a, int[] b) {
    /* Casos bases */
    if (a.length == 0 && b.length == 0) throw new IllegalStateException("Conjunto vacio!");
    if (a.length != 0 && b.length == 0) {
      array = Arrays.copyOf(a, a.length);
      return array;
    }
    if (a.length == 0 && b.length != 0) {
      array = Arrays.copyOf(b, b.length);
      return array;
    }
    /* Caso cuando ambos conjuntos no estan vacios */
	int[] c = union(a, b);
    int[] d = intersection(a, b);
    int[] e = diference(c, d);
    array = Arrays.copyOf(e, e.length);
    return array;
  }

  @Override
  public String toString() {
    if (array.length == 0) return "{}";

    String result = "{";
    for (int i = 0; i < array.length; i++) {
      result += String.valueOf(array[i]);
      if (i != array.length - 1) {
        result += ", ";
      }
    }
    result += "}";
    return result;
  }
}
