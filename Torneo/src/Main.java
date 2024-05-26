import javax.swing.JOptionPane;

class Main {

	public static void main(String[] args) {
		
//		Creación de una clase principal "Main" para probar el sistema:
//			Crear instancias de jugadores, equipos y el gestor de equipos.
//			Realizar pruebas de todas las operaciones implementadas, cómo agregar jugadores a un equipo, buscar un jugador por nombre, eliminar un equipo, etc.
//			Simular partidos entre equipos utilizando el método "jugarPartido".
//			Entrega:
//			Deberán entregar el código fuente del proyecto, junto con un diagrama de clases que representará, las funcionalidades implementadas. 
//	
	
		String[] opciones = {
			"Guardar producto","Ver productos","Actualizar","Eliminar","Salir"	
		};
		int opcionElegida ;
		do {
			 opcionElegida = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones[0]);
			switch (opcionElegida) {
			case 0:
				String nombre;
				do {		
					nombre = JOptionPane.showInputDialog("Ingrese nobre del producto");
					if (!nombre.equals("no")) {
						double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio"));
						int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad"));
						//Producto nuevoCreadoPorUsuario = new Producto(nombre,precio,cantidad);
						//ListaProductos.add(nuevoCreadoPorUsuario);
						ListaProductos.add(new Producto(nombre,precio,cantidad));
					} else {
						JOptionPane.showMessageDialog(null, "Saliendo de carga de productos");
					}
				} while (!nombre.equals("no"));
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Productos:" + ListaProductos);
				break;
			case 2:
				Producto seleccionado=  seleccionarProducto(ListaProductos);
				
				for (Producto producto : ListaProductos) {
					if (producto == seleccionado) {
						producto.setCantidad(Integer.parseInt(JOptionPane.showInputDialog( "Ingrese la nueva cantidad del producto")));
						producto.setNombre(JOptionPane.showInputDialog("Elija un nuevo nombre para el producto "));
						producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto")));

					}
				}
				break;
			case 3: 
				ListaProductos.remove(seleccionarProducto(ListaProductos));
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}
		} while (opcionElegida!=4);
		

		
		
	}
	 public static Producto seleccionarProducto(LinkedList<Producto> ListaProductos) {
		 String[] productosarray = new String[ListaProductos.size()];
		 Producto seleccionado=null;
			
			for (int i = 0; i < ListaProductos.size(); i++) {
				productosarray[i] = ListaProductos.get(i).getNombre();
			}
			
			String productSelect =(String)JOptionPane.showInputDialog(null, 
					"Elija un producto", null, 0, 
					null, productosarray, productosarray[0]);
			
			JOptionPane.showMessageDialog(null, productSelect);
			for (Producto producto : ListaProductos) {
				if (producto.getNombre().equals(productSelect)) {
					seleccionado = producto;
					break;
				}
			}
			return seleccionado;
	 }
	}

}
