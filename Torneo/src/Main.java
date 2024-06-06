import java.util.LinkedList;
import javax.swing.JOptionPane;

class Main {
	public static void main(String[] args) {

		String[] menuPpal = { "Gestionar equipos", "Gestionar torneo", "Jugar mundial", "Salir" };
		String[] menuEquipos = { "Eliminar jugador", "Agregar jugador", "Buscar jugador",
				"Mostrar cantidad de jugadores", "Mostrar lista de jugadores", "Salir" };
		String[] menuTorneo = { "Eliminar equipo", "Agregar equipo", "Buscar equipo", "Mostrar cantidad de equipos",
				"Mostrar lista de equipos", "Jugar partido", "Jugar torneo", "Salir" };

		LinkedList<Jugador> jugadoras = new LinkedList<Jugador>() {
			{
				add(new Jugador("Ana Pérez", 9, 1, 24));
				add(new Jugador("María López", 11, 2, 27));
				add(new Jugador("Lucía Fernández", 7, 3, 22));
				add(new Jugador("Sofía Martínez", 10, 4, 25));
				add(new Jugador("Elena García", 8, 5, 30));
				add(new Jugador("Carla Rodríguez", 6, 6, 28));
				add(new Jugador("Laura Sánchez", 4, 7, 21));
				add(new Jugador("Marta Ruiz", 5, 8, 26));
				add(new Jugador("Irene Gómez", 3, 9, 29));
				add(new Jugador("Paula Díaz", 2, 10, 23));
				add(new Jugador("Romina Cabello", 4, 10, 23));
			}
		};

		GestionTorneo mundialFemenino = new GestionTorneo(new LinkedList<Equipo>() {
			{
				add(new Equipo("Argentina"));
				add(new Equipo("Chile"));
				add(new Equipo("Alemania"));
				add(new Equipo("Italia"));
				add(new Equipo("Francia"));
				add(new Equipo("Inglaterra"));
				add(new Equipo("Holanda"));
				add(new Equipo("Brasil"));
				add(new Equipo("Costa Rica"));
				add(new Equipo("Japon"));
				add(new Equipo("Espana"));
				add(new Equipo("Belgica"));
				add(new Equipo("Peru"));
				add(new Equipo("Nigeria"));
				add(new Equipo("Ghana"));
				add(new Equipo("Gales"));



			}
		});

		for (Equipo equipos : mundialFemenino.getEquipos()) {
			for (Jugador jugador : jugadoras) {
				equipos.getJugadores().add(jugador);
			}
		}

		String[] listaEquipos = mundialFemenino.generarListaEquipos();

		int opcionPpal;
		int opcionEquipos;
		int opcionTorneo;

		Equipo equipoAModificar = new Equipo();
		
		JOptionPane.showMessageDialog(null, "Bienvenido al gestor del Mundial Femenino de fútbol. \n Presiona **Aceptar** para ingresar al menú.");

		do {
			opcionPpal = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, menuPpal,
					menuPpal[0]);
			switch (opcionPpal) {

			case 0:
				if (mundialFemenino.getEquipos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vuelva al inicio y agregue equipos al torneo");
				} else {

					do {
						int equipoSeleccionado = seleccionarEquipo(mundialFemenino.getEquipos());

						opcionEquipos = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null,
								menuEquipos, menuEquipos[0]);

						switch (opcionEquipos) {
						case 0:
							mundialFemenino.getEquipos().get(equipoSeleccionado).eliminarJugador();

							break;
						case 1:
							mundialFemenino.getEquipos().get(equipoSeleccionado).agregarJugador();
							

							break;
						case 2:
							mundialFemenino.getEquipos().get(equipoSeleccionado).buscarJugador();

							break;
						case 3:
							mundialFemenino.getEquipos().get(equipoSeleccionado).cantidadJugadoras();

							break;
						case 4:
							
							String[] listaJugadoras = mundialFemenino.getEquipos().get(equipoSeleccionado).generarListaJugadoras();
							mundialFemenino.getEquipos().get(equipoSeleccionado).mostrarListaJugadoras(listaJugadoras);

							break;

						}
					} while (opcionEquipos != 5);
				}
				break;

			case 1:
				do {

					opcionTorneo = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, menuTorneo,
							menuTorneo[0]);

					switch (opcionTorneo) {
					case 0:

						mundialFemenino.eliminarEquipoDeLista();
						break;
					case 1:
						mundialFemenino.agregarEquipo();

						break;
					case 2:

						mundialFemenino.buscarEquipoPorNombre();
						break;
					case 3:
						JOptionPane.showMessageDialog(null,
								"Hay " + mundialFemenino.cantidadTotalEquipos() + " equipos en el torneo. ");

						break;
					case 4:

						mundialFemenino.mostrarListaEquipos(mundialFemenino.generarListaEquipos());

						break;
					case 5:

						mundialFemenino.jugarPartido(mundialFemenino.getEquipos(), mundialFemenino.generarListaEquipos());
						break;

					case 6:
						
						mundialFemenino.jugarTorneo();
						break;
					}
					

				} while (opcionTorneo != 7);

					break;

		
			
			case 2:
				
					mundialFemenino.jugarFases(mundialFemenino.getEquipos());
					break;
			}

		} while (opcionPpal != 3);
	}
	
	public static int seleccionarEquipo(LinkedList<Equipo> equipos) {
		String[] equiposarray = new String[equipos.size()];
		for (int i = 0; i < equipos.size(); i++) {
			equiposarray[i] = equipos.get(i).getPais();
		}
		int opcion = JOptionPane.showOptionDialog(null, 
				"Seleccione equipo", null, 0, 0, null, equiposarray, equiposarray[0]);
		
		return opcion;
	}

}
