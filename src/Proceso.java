import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Proceso {
	
	ArrayList<String> nombreList= new ArrayList<String>();
	ArrayList<Double> estaturaList= new ArrayList<Double>();
	ArrayList<Double> pesoList= new ArrayList<Double>();
	ArrayList<Double> imcList= new ArrayList<Double>();
	
	String nombreIngresado;
	
	public void Iniciar() {
		
		JOptionPane.showMessageDialog(null, "Indice de masa corporal.");
		
		String menu="Calcula tu IMC \n";
		menu+="1. Llenar datos. \n";
		menu+="2. Imprimir Resultado. \n";
		menu+="3. Buscar por nombre. \n";
		menu+="4. Actualizar. \n";
		menu+="5. Eliminar persona. \n";
		menu+="6. Limpiar Lista. \n";
		menu+="7. Salir. \n";
		menu+="Ingrese una opcion: \n";
		
		int opc = 0;
		
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarMenu(opc);
			
		} while (opc != 7);	
	}
	
	public void validarMenu(int opc) {
		switch (opc) {
		case 1:
				PedirDatos();
			break;
		case 2:
				if (nombreIngresado != null) {
					Imc();
					imprimirResultado();
				} else {
					System.out.println("Debe primero llenar datos!");
				}
			break;
		case 3:
				if (nombreIngresado != null) {
					Imc();
					buscarPorNombre();
				} else {
					System.out.println("Debe primero llenar datos!");
				}
			break;
		case 4:
				if (nombreIngresado != null) {
					actualizar();
				} else {
					System.out.println("Debe primero llenar datos!");
				}
			break;
		case 5:
				if (nombreIngresado != null) {
					eliminarPersona();
				} else {
					System.out.println("Debe primero llenar datos!");
				}
			break;
		case 6:
				if (nombreIngresado != null) {
					limpiarLista();
				} else {
					System.out.println("Debe primero llenar datos!");
				}
			break;
		case 7:
				System.out.println("Chao parce¡");
			break;
		default:
				System.out.println("Ingrese una opcion valida.");
			break;
		}
	}
	
	public void PedirDatos() {
		int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de personas a realizar el proceso: "));
		for (int i = 0; i < cant; i++) {
			nombreIngresado=JOptionPane.showInputDialog(i+1+" ingrese su nombre: ");
			nombreList.add(nombreIngresado);
			estaturaList.add(Double.parseDouble(JOptionPane.showInputDialog(nombreList.get(i)+" ingrese su estatura: ")));
			pesoList.add(Double.parseDouble(JOptionPane.showInputDialog(nombreList.get(i)+" ingrese su peso: ")));
			
		}
	}
	
	public void Imc() {
		double imc=0;
		for (int j = 0; j < nombreList.size(); j++) {
			imc=pesoList.get(j)/(estaturaList.get(j)*estaturaList.get(j));
			imcList.add(imc);
		}
	}
	
	public void imprimirResultado() {
		for (int i = 0; i < nombreList.size(); i++) {
			if (imcList.get(i) < 18) {
				System.out.println(" Usuario "+(i+1)+")"+nombreList.get(i)+"\n Su peso es: "+pesoList.get(i)+"Kg\n su estatura es: "+
						estaturaList.get(i)+"cm \n Para un resultado de Anorexia \n");
			}
			else if (imcList.get(i) >= 18 && imcList.get(i) < 20) {
				System.out.println(" Usuario "+(i+1)+")"+nombreList.get(i)+"\n Su peso es: "+pesoList.get(i)+"Kg\n su estatura es: "+
						estaturaList.get(i)+"cm \n Para un resultado de Delgadez \n");
			}
			else if (imcList.get(i) >= 20 && imcList.get(i) < 27) {
				System.out.println(" Usuario "+(i+1)+")"+nombreList.get(i)+"\n Su peso es: "+pesoList.get(i)+"Kg\n su estatura es: "+
						estaturaList.get(i)+"cm \n Para un resultado de Normalidad \n");
			}
			else if (imcList.get(i) >= 27 && imcList.get(i) < 30) {
				System.out.println(" Usuario "+(i+1)+")"+nombreList.get(i)+"\n Su peso es: "+pesoList.get(i)+"Kg\n su estatura es: "+
						estaturaList.get(i)+"cm \n Para un resultado de Obecidad grado 1 \n");
			}
			else if (imcList.get(i) >= 30 && imcList.get(i) < 35) {
				System.out.println(" Usuario "+(i+1)+")"+nombreList.get(i)+"\n Su peso es: "+pesoList.get(i)+"Kg\n su estatura es: "+
						estaturaList.get(i)+"cm \n Para un resultado de Obecidad grado 2 \n");
			}
			else if (imcList.get(i) >= 35 && imcList.get(i) < 40) {
				System.out.println(" Usuario "+(i+1)+")"+nombreList.get(i)+"\n Su peso es: "+pesoList.get(i)+"Kg\n su estatura es: "+
						estaturaList.get(i)+"cm \n Para un resultado de Obecidad grado 3 \n");
			}
			else if (imcList.get(i) >= 40) {
				System.out.println(" Usuario "+(i+1)+")"+nombreList.get(i)+"\n Su peso es: "+pesoList.get(i)+"Kg\n su estatura es: "+
						estaturaList.get(i)+"cm \n Para un resultado de Obesidad morbida \n");
			}
		} 
	}
	
	public void buscarPorNombre() {
		System.out.println("Buscar por nombre ");
		
		int contador=0;
		
		String nombrebuscar = JOptionPane.showInputDialog("ingrese el nombre a buscar");
		
		for (int i = 0; i < nombreList.size(); i++) {
			if (nombreList.get(i).equalsIgnoreCase(nombrebuscar)) {
				System.out.println("se encontro a "+nombrebuscar+" en la posicion "+(i+1));
				contador++;
			}
		}
		if (contador > 0) {
			System.out.println("Encontro a "+nombrebuscar+" "+contador+" veces");
		} else {
			System.out.println("la persona "+nombrebuscar+" no fue registrada");
		}
	}
	
	public void actualizar() {
		String name=JOptionPane.showInputDialog("Ingrese el usuario que desea actualizar");
		String nombre;
		double peso, altura;
		
		if (!(nombreList.contains(name))) {
			JOptionPane.showMessageDialog(null, "No se encontro un usuario con dicho nombre");
		}else {
			for (int i = 0; i < nombreList.size(); i++) {
				if (nombreList.get(i).equalsIgnoreCase(name)) {
					nombre = JOptionPane.showInputDialog("Ingresar nombre: ");
					nombreList.set(i, nombre);
					peso = Double.parseDouble(JOptionPane.showInputDialog("Ingresar peso: "));
					pesoList.set(i, peso);
					altura = Double.parseDouble(JOptionPane.showInputDialog("Ingresar peso: "));
					estaturaList.set(i, altura);
				}
			}
		}	
	}
	
	public void eliminarPersona() {
		String name=JOptionPane.showInputDialog("Ingrese el nombre del usuario que desea aliminar");
		if (!(nombreList.contains(name))) {
			JOptionPane.showMessageDialog(null, "No se encontro el usuario ingresado");
		} else {
			for (int i = 0; i < nombreList.size(); i++) {
				if (nombreList.get(i).equalsIgnoreCase(name)) {
					nombreList.remove(i);
					pesoList.remove(i);
					estaturaList.remove(i);
					imcList.remove(i);
				}
			}
		}
	}
	
	public void limpiarLista() {
		nombreList.clear();
		pesoList.clear();
		estaturaList.clear();
		imcList.clear();
	}
	
	
}














