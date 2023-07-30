package conjuntos;

public interface ConjuntoInterface {

  /**
   * Union de conjuntos, formalmente es:
   * A U B = {x | x ∈ A v x ∈ B}.
   * Complejidad temporal en peor caso: O (n * log(n))
   * @param a un arreglo representando el conjunto A.
   * @param b un arreglo representando el conjunto B.
   * @return un arreglo con la union entre A y B.
   */
  public int[] union(int[] a, int[] b);

  /**
   * Intersección de conjuntos, formalmente es:
   * A ∩ B = {x | x ∈ A ∧  x ∈ B}.
   * Complejidad temporal en peor caso: O (n * log(n)).
   * @param a un arreglo representando el conjunto A.
   * @param b un arreglo representando el conjunto B.
   * @return un arreglo con la intersección entre A y B.
   */
  public int[] intersection(int[] a, int[] b);

  /**
   * Diferencia de conjuntos, formalmente es:
   * A - B = {x | x ∈ A ∧ ¬(x ∈ B)}.
   * Complejidad temporal en peor caso: O (n * m).
   * @param a un arreglo representando el conjunto A.
   * @param b un arreglo representando el conjunto B.
   * @return un arreglo con la diferencia entre A y B.
   */
  public int[] diference(int[] a, int[] b);

  /**
   * Complemento del conjunto, formalmente es:
   * A^c = {x | ¬(x ∈ A)}.
   * Complejidad temporal en peor caso: O (n * m).
   * @param universal un arreglo representando el conjunto Universal.
   * @param a un arreglo representando el conjunto A.
   * @return un arreglo con el complemento de A.
   */
  public int[] complement(int[] universal, int[] a);

  /**
   * Diferencia simétrica de conjuntos, formalmente es:
   * A Δ B = {x | (x ∈ A U B) - (x ∈ A ∩ B)}
   * Complejidad temporal en peor caso: O (n * m).
   * @param a a un arreglo representando el conjunto A.
   * @param b a un arreglo representando el conjunto B.
   * @return un arreglo con la diferencia simétrica entre A y B.
   */
  public int[] simetricDiference(int[] a, int[] b);

  @Override
  public String toString();

}
