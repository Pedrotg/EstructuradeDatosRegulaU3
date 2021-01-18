public class MetodosNodo {

	CrearNodo raizA = null;
	CrearNodo raizB = null;
	
	CrearNodo cimaA = null;
	CrearNodo cimaB = null;
	
	CrearNodo []ventanilla = {null,null,null};
	
	public void Insertar (String tipoDeCliente, int turno) {
		
		CrearNodo nuevoNodo = new CrearNodo(tipoDeCliente, turno);

		if(tipoDeCliente.equals("VIP")) {
			
			if(raizA == null) {
				raizA = nuevoNodo;
				cimaA = nuevoNodo;
			}else {
				cimaA.apuntador =  nuevoNodo;
				cimaA = nuevoNodo;
			}
		}else{			
			
			if(raizB == null) {
				raizB = nuevoNodo;
				cimaB = nuevoNodo;
			}else {
				cimaB.apuntador =  nuevoNodo;
				cimaB = nuevoNodo;
			}
		}
		
		System.out.println("");
		System.out.println("Usuarios:");
		MostrarUsuarios();
		System.out.println("");
	}
	
	public void PasarAVentanilla() {
		
		if(raizA == null && raizB == null)
			System.out.println("No existe nungún cliente en las colas");
		
		if(ventanilla[0]!= null && ventanilla[1]!= null && ventanilla[2]!= null)
			System.out.println("Las ventanillas están ocupadas");
		
		if(raizA != null || raizB != null) {
			if(raizA != null) {
				for (int i = 0; i < 3; i++) {
					if(ventanilla[i]==null && raizA != null) {						
						ventanilla[i] = raizA;
						raizA = raizA.apuntador;
					}
				}
				
			}if(raizB != null) {
				for (int i = 0; i < 3; i++) {
					if(ventanilla[i]==null && raizB != null) {						
						ventanilla[i] = raizB;
						raizB = raizB.apuntador;
					}
				}
			}
		}
		
		if(ventanilla != null)
			MostrarVentanilla();
	}
	
	public void MostrarUsuarios() {
		CrearNodo dato1 = raizA;
		CrearNodo dato2 = raizB;
		
		System.out.print("ColaVIP: ");
		while(dato1 != null) {
			System.out.print(" "+dato1.tipoDeCliente+dato1.turno);
			dato1 = dato1.apuntador;
		}
		
		System.out.println("");
		System.out.print("ColaComún: ");
		while(dato2 != null) {
			System.out.print(" "+dato2.tipoDeCliente+dato2.turno);
			dato2 = dato2.apuntador;
		}
		System.out.println("");
	}
	
	public void MostrarVentanilla() {
		
		for (int i = 0; i < 3; i++) {
			if(ventanilla[i] != null)
				System.out.println("usuario en ventanilla "+(i+1)+": "+ventanilla[i].tipoDeCliente+ventanilla[i].turno);
		}
	}
	
	public void SalirVentanilla(int sale) {
		
		sale = (int) (Math.random()*3+0);
		
		if(ventanilla[sale] != null) {
			ventanilla[sale] = null;
			System.out.println("La ventanilla que se desocupó fue la: "+(sale+1));
			MostrarVentanilla();
		}else if(ventanilla[0]== null && ventanilla[1]== null && ventanilla[2]== null)
			System.out.println("Todas las ventanillas están desocupadas");
		else
			SalirVentanilla(sale);
	}
}
