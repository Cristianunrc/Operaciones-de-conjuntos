package conjuntos;

import java.util.Scanner;

public class MainConjunto {

  public static void main(String[] args) {
	System.out.println("\n");
	System.out.println("==============================================================");
	System.out.println("A continuaci�n se muestra un men� con OPERACIONES DE CONJUNTOS");
	System.out.println("==============================================================");
	Conjunto instance = new Conjunto();
	Scanner value = new Scanner(System.in);
	int[] conjuntoUniversal;
	int[] conjuntoA;
	int[] conjuntoB;
	int num = 100;
	String s = "Usted seleccion� la opci�n";

	while (num != 6) {
	  System.out.println("\n");
	  System.out.println("====");
	  System.out.println("MENU");
	  System.out.println("====");
	  System.out.println("1) Uni�n \n2) Intersecci�n \n3) Diferencia \n4) Complemento \n5) Diferencia sim�trica \n6) Salir");
	  System.out.println("Seleccione una opci�n:");
	  num = value.nextInt();
	  switch(num){
	    case 1:
	      System.out.println("===> " + s + " 1) Uni�n <===");
	      System.out.println("\n");
	      conjuntoA = enterElements("A");
	      conjuntoB = enterElements("B");
	      instance.union(conjuntoA, conjuntoB);
	      System.out.println("\n");
	      System.out.println("------------------------");
	      System.out.println("La uni�n entre A y B es: " + instance.toString());
	      System.out.println("------------------------");
	      break;
	    case 2:
	      System.out.println("===> " + s + " 2) Intersecci�n <===");
		  System.out.println("\n");
	      conjuntoA = enterElements("A");
	      conjuntoB = enterElements("B");
	      instance.intersection(conjuntoA, conjuntoB);
	      System.out.println("\n");
	      System.out.println("-------------------------------");
	      System.out.println("La intersecci�n entre A y B es: " + instance.toString());
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
	      System.out.println("===> " + s + " 5) Diferencia sim�trica <===");
		  System.out.println("\n");
	      conjuntoA = enterElements("A");
		  conjuntoB= enterElements("B");
		  instance.simetricDiference(conjuntoA, conjuntoB);
		  System.out.println("\n");
		  System.out.println("---------------------------------------");
		  System.out.println("La diferencia sim�trica entre A y B es: " + instance.toString());
		  System.out.println("---------------------------------------");
	      break;
	    case 6:
	      System.out.println("======");
	      System.out.println("Adi�s!");
	      System.out.println("======");
	      break;
	  }
	}
  }

  private static int[] enterElements(String nameSet) {
	Scanner enter = new Scanner(System.in);
	System.out.println("Ingresar el n�mero de elementos para el conjunto " + nameSet + ": ");
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
