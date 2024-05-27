import java.util.LinkedList;
import javax.swing.JOptionPane;
class Main {
	public static void main(String[] args) {
		//		Creación de una clase principal "Main" para probar el sistema:
		//			Crear instancias de jugadores, equipos y el gestor de equipos.
		//			Realizar pruebas de todas las operaciones implementadas, cómo agregar jugadores a un equipo, buscar un jugador por nombre, eliminar un equipo, etc.
		//			Simular partidos entre equipos utilizando el método "jugarPartido".
		//			Entrega:
		//			Deberán entregar el código fuente del proyecto, junto con un diagrama de clases que representará, las funcionalidades implementadas. 

		String[] menuPpal = {
				"Gestionar equipos","Gestionar torneo","Salir"	
		};
		String[] menuEquipos = {
				"Seleccionar equipo","Eliminar jugador", "Agregar jugador","Buscar jugador", "Mostrar cantidad de jugadores",  "Mostrar lista de jugadores","Salir"	
		};
		String[] menuTorneo = {
				"Eliminar equipo", "Agregar equipo","Buscar equipo", "Mostrar cantidad de equipos",  "Mostrar lista de equipos","Jugar partido", "Salir"	
			};
		LinkedList<Equipo> equiposTorneo = new LinkedList<Equipo>();
		
		GestionTorneo nuevoTorneo = new GestionTorneo(equiposTorneo);
		
		int opcionPpal;
		int opcionEquipos;
		int opcionTorneo;
		int equipoElegido;
		do {
			opcionPpal = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, menuPpal, menuPpal[0]);
			switch (opcionPpal) {
			//Gestion equipos
			case 0:	
				if (equiposTorneo.isEmpty()){
					JOptionPane.showMessageDialog(null, "Vuelva al inicio y agregue equipos al torneo");
				}else {
				
				do {
			
					
					opcionEquipos = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, menuEquipos, menuEquipos[0]);
				
				
				switch (opcionEquipos) {
					case 0:
					//Menu para seleccionar el equipo
						equipoElegido = JOptionPane.showOptionDialog(null, "Seleccione equipo", null, 0, 0, null, menuPpal, menuPpal[0]);
							break;
						case 1:
							//eliminar jugador
		
							break;
						case 2:
							//agregar jugador
		
							break;
						case 3:
							//buscar jugador
		
							break;
						case 4:
							//mostrar cantidad jugadores
		
							break;
						case 5:
							//lista jugadores
		
							break;
					
				}
					
				

				}while (opcionEquipos!=6);
				}
				
				
				break;
				//Gestion torneo
			case 1:
					do {
						opcionTorneo = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, menuTorneo, menuTorneo[0]);
						
						switch (opcionTorneo) {
							case 0:
							
								//eliminar equipo
									break;
								case 1:
										//agregar equipo
				
									break;
								case 2:
									
										//buscar equipo
									break;
								case 3:
										//mostrar cantidad equipo
				
									break;
								case 4:
										//lista equipos
				
									break;
								case 5:
									//Jugar partido
				
									break;
							
						}

						}while (opcionTorneo!=6);

					break;
						
					}

			}while (opcionPpal!=2);
		} 
	}





