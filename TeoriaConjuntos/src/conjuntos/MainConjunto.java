package conjuntos;

import java.util.Scanner;

public class MainConjunto {

  public static void main(String[] args) {
	System.out.println("\n");
	System.out.println("==============================================================");
	System.out.println("A continuación se muestra un menú con OPERACIONES DE CONJUNTOS");
	System.out.println("==============================================================");
	Conjunto instance = new Conjunto();
	Scanner value = new Scanner(System.in);
	int[] conjuntoUniversal;
	int[] conjuntoA;
	int[] conjuntoB;
	int num = 100;
	String s = "Usted seleccionó la opción";

	while (num != 6) {
	  System.out.println("\n");
	  System.out.println("====");
	  System.out.println("MENU");
	  System.out.println("====");
	  System.out.println("1) Unión \n2) Intersección \n3) Diferencia \n4) Complemento \n5) Diferencia simétrica \n6) Salir");
	  System.out.println("Seleccione una opción:");
	  num = value.nextInt();
	  switch(num){
	    case 1:
	      System.out.println("===> " + s + " 1) Unión <===");
	      System.out.println("\n");
	      conjuntoA = enterElements("A");
	      conjuntoB = enterElements("B");
	      instance.union(conjuntoA, conjuntoB);
	      System.out.println("\n");
	      System.out.println("------------------------");
	      System.out.println("La unión entre A y B es: " + instance.toString());
	      System.out.println("------------------------");
	      break;
	    case 2:
	      System.out.println("===> " + s + " 2) Intersección <===");
		  System.out.println("\n");
	      conjuntoA = enterElements("A");
	      conjuntoB = enterElements("B");
	      instance.intersection(conjuntoA, conjuntoB);
	      System.out.println("\n");
	      System.out.println("-------------------------------");
	      System.out.println("La intersección entre A y B es: " + instance.toString());
	      System.out.println("-------------------------------");
	      break;
	    case 3:
	      System.out.println("===> " + s + " 3) Diferencia <===");
		  System.out.println("\n");
	      conjuntoA = enterElements("A");
		  conjuntoB = enterElements("B");
		  instance.diference(conjuntoA, conjuntoB);
		  System.out.println("\n");
		  System.out.println("-----------------------------");
		  System.out.println("La diferencia entre A y B es: " + instance.toString());
		  System.out.println("-----------------------------");
	      break;
	    case 4:
	      System.out.println("===> " + s + " 4) Complemento <===");
		  System.out.println("\n");
		  conjuntoUniversal = enterElements("Universal");
		  conjuntoA = enterElements("A");
		  instance.complement(conjuntoUniversal, conjuntoA);
		  System.out.println("\n");
		  System.out.println("----------------------");
		  System.out.println("El complemento de A es: " + instance.toString());
		  System.out.println("----------------------");
	      break;
	    case 5:
	      System.out.println("===> " + s + " 5) Diferencia simétrica <===");
		  System.out.println("\n");
	      conjuntoA = enterElements("A");
		  conjuntoB= enterElements("B");
		  instance.simetricDiference(conjuntoA, conjuntoB);
		  System.out.println("\n");
		  System.out.println("---------------------------------------");
		  System.out.println("La diferencia simétrica entre A y B es: " + instance.toString());
		  System.out.println("---------------------------------------");
	      break;
	    case 6:
	      System.out.println("======");
	      System.out.println("Adiós!");
	      System.out.println("======");
	      break;
	  }
	}
  }

  private static int[] enterElements(String nameSet) {
	Scanner enter = new Scanner(System.in);
	System.out.println("Ingresar el número de elementos para el conjunto " + nameSet + ": ");
    int cant = enter.nextInt();
    int[] set = new int[cant];
    if (cant > 0) {
      System.out.println("Ingresar los elementos del conjunto " + nameSet + ": ");
      for (int i = 0; i < set.length; i++) {
        set[i] = enter.nextInt();
      }
    }
    return set;
  }

}
