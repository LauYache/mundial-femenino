import java.util.LinkedList;
import javax.swing.JOptionPane;
class Main {
	public static void main(String[] args) {
	
		String[] menuPpal = {
				"Gestionar equipos","Gestionar torneo","Salir"	
		};
		String[] menuEquipos = {
				"Eliminar jugador", "Agregar jugador","Buscar jugador", "Mostrar cantidad de jugadores",  "Mostrar lista de jugadores","Salir"	
		};
		String[] menuTorneo = {
				"Eliminar equipo", "Agregar equipo","Buscar equipo", "Mostrar cantidad de equipos",  "Mostrar lista de equipos","Jugar partido", "Salir"	
			};
		
		LinkedList<Jugador> jugadorasArgentina = new LinkedList<Jugador>();
		jugadorasArgentina.add(new Jugador("Ana Pérez", 9, 1, 24));
		jugadorasArgentina.add(new Jugador("María López", 11, 2, 27));
		jugadorasArgentina.add(new Jugador("Lucía Fernández", 7, 3, 22));
		jugadorasArgentina.add(new Jugador("Sofía Martínez", 10, 4, 25));
		jugadorasArgentina.add(new Jugador("Elena García", 8, 5, 30));
		jugadorasArgentina.add(new Jugador("Carla Rodríguez", 6, 6, 28));
		jugadorasArgentina.add(new Jugador("Laura Sánchez", 4, 7, 21));
		jugadorasArgentina.add(new Jugador("Marta Ruiz", 5, 8, 26));
		jugadorasArgentina.add(new Jugador("Irene Gómez", 3, 9, 29));
		jugadorasArgentina.add(new Jugador("Paula Díaz", 2, 10, 23));
		 
		 
		LinkedList<Equipo> equiposTorneo = new LinkedList<Equipo>();
		equiposTorneo.add(new Equipo("Argentina"));
		equiposTorneo.add(new Equipo("Chile"));
		equiposTorneo.add(new Equipo("Alemania"));
		equiposTorneo.add(new Equipo("Italia"));
		equiposTorneo.add(new Equipo("Francia"));
		equiposTorneo.add(new Equipo("Inglaterra"));
		
		GestionTorneo nuevoTorneo = new GestionTorneo(equiposTorneo);
		String[] listaEquipos = nuevoTorneo.generarListaEquipos(equiposTorneo);
		
		int opcionPpal;
		int opcionEquipos;
		int opcionTorneo;
		
	
		Equipo equipoAModificar = new Equipo();
		
		do {
			opcionPpal = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, menuPpal, menuPpal[0]);
			switch (opcionPpal) {
			//Gestion equipos
			case 0:	
				if (equiposTorneo.isEmpty()){
					JOptionPane.showMessageDialog(null, "Vuelva al inicio y agregue equipos al torneo");
				}else {
				
				do {
					equipoAModificar = nuevoTorneo.seleccionarEquipo(equiposTorneo, listaEquipos);

					opcionEquipos = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, menuEquipos, menuEquipos[0]);
				
				switch (opcionEquipos) {
					case 0:
	
							break;
						case 1:
							equipoAModificar.agregarJugador(equipoAModificar.getJugadores());
		
							break;
						case 2:
							equipoAModificar.buscarJugador(equipoAModificar.getJugadores());
		
							break;
						case 3:
							equipoAModificar.cantidadJugadores(equipoAModificar.getJugadores());
		
							break;
						case 4:
							//mostrar lista jugadores
		
							break;
		
				}
				}while (opcionEquipos!=5);
				}
				break;
				//Gestion torneo
			case 1:
					do {
						opcionTorneo = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, menuTorneo, menuTorneo[0]);
						
						switch (opcionTorneo) {
							case 0:
							
								nuevoTorneo.eliminarEquipoDeLista(equiposTorneo);
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
									nuevoTorneo.jugarPartido(nuevoTorneo.getEquipos().get(1), nuevoTorneo.getEquipos().get(3));
									break;
							
						}

						}while (opcionTorneo!=6);

					break;
						
					}

			}while (opcionPpal!=2);
		} 
	}





