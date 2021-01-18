import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean continuar = false, sigue = true;
		String []clientes = {"VIP", "Común"};
		int opcion, turno = 0, sale = 0;
		
		Scanner leer = new Scanner(System.in);
		MetodosNodo envioNodo = new MetodosNodo();
		
		while(continuar) {
			System.out.println("");
			System.out.println("Uso de colas dinámicas");
			System.out.println("1.- Nuevo Cliente");
			System.out.println("2.- Pasar a Ventanilla");
			System.out.println("3.- Mostrar colas");
			System.out.println("4.- Terminar una ventanilla");
			System.out.println("5.- Salir");
			opcion = leer.nextInt();
			
			switch (opcion) {
			case 1:
				if(turno == 0)
					turno = (int) (Math.random()*10+1);
				else
					turno++;
				
				int numero = (int) (Math.random()*2+0);
				
				if (numero == 0) 					
					envioNodo.Insertar(clientes[0], turno);
				else 
					envioNodo.Insertar(clientes[1], turno);
				
				break;
				
			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				break;
				
			case 5:
				continuar = false;
				break;
			default:
				break;
			}
		}

	}

}

