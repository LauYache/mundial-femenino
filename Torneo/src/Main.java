import java.util.LinkedList;
import javax.swing.JOptionPane;

class Main {
	public static void main(String[] args) {

		String[] menuPpal = { "Gestionar equipos", "Gestionar torneo", "Salir" };
		String[] menuEquipos = { "Eliminar jugador", "Agregar jugador", "Buscar jugador",
				"Mostrar cantidad de jugadores", "Mostrar lista de jugadores", "Salir" };
		String[] menuTorneo = { "Eliminar equipo", "Agregar equipo", "Buscar equipo", "Mostrar cantidad de equipos",
				"Mostrar lista de equipos", "Jugar partido", "Salir" };

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
			}
		};

		GestionTorneo nuevoTorneo = new GestionTorneo(new LinkedList<Equipo>() {
			{
				add(new Equipo("Argentina"));
				add(new Equipo("Chile"));
				add(new Equipo("Alemania"));
				add(new Equipo("Italia"));
				add(new Equipo("Francia"));
				add(new Equipo("Inglaterra"));
			}
		});

		for (Equipo equipos : nuevoTorneo.getEquipos()) {
			for (Jugador jugador : jugadoras) {
				equipos.getJugadores().add(jugador);

			}
			System.out.print(nuevoTorneo.getEquipos().get(4).getJugadores());
		}

		String[] listaEquipos = nuevoTorneo.generarListaEquipos();

		int opcionPpal;
		int opcionEquipos;
		int opcionTorneo;

		Equipo equipoAModificar = new Equipo();

		do {
			opcionPpal = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, menuPpal,
					menuPpal[0]);
			switch (opcionPpal) {

			case 0:
				if (nuevoTorneo.getEquipos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vuelva al inicio y agregue equipos al torneo");
				} else {

					do {
						equipoAModificar = nuevoTorneo.seleccionarEquipo(nuevoTorneo.getEquipos(), listaEquipos);

						opcionEquipos = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null,
								menuEquipos, menuEquipos[0]);

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
							equipoAModificar.generarListaJugadores(jugadoras);

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

						nuevoTorneo.eliminarEquipoDeLista();
						break;
					case 1:
						nuevoTorneo.agregarEquipo();

						break;
					case 2:

						nuevoTorneo.buscarEquipoPorNombre();
						break;
					case 3:
						JOptionPane.showMessageDialog(null,
								"Hay " + nuevoTorneo.cantidadTotalEquipos() + " equipos en el torneo. ");

						break;
					case 4:

						nuevoTorneo.mostrarListaEquipos(nuevoTorneo.generarListaEquipos());

						break;
					case 5:

						nuevoTorneo.jugarPartido(nuevoTorneo.getEquipos(), nuevoTorneo.generarListaEquipos());
						break;

					}

				} while (opcionTorneo != 6);

				break;

			}

		} while (opcionPpal != 2);
	}

}
