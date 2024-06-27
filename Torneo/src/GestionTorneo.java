import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestionTorneo {

	private LinkedList<Equipo> equipos;

	public GestionTorneo(LinkedList<Equipo> equipos) {
		super();
		this.equipos = equipos;
	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public void agregarEquipo() {

		String pais = JOptionPane.showInputDialog("Ingrese pais");

		this.getEquipos().add(new Equipo(pais));

	}

	public void eliminarEquipoDeLista() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo");

		for (Equipo equipo : this.getEquipos()) {
			if (equipo.getPais().equals(nombre)) {
				this.getEquipos().remove(equipo);
				break;
			}
		}

	}

	public void buscarEquipoPorNombre() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo");
		Equipo equipoBuscado = null;

		for (Equipo equipo : this.getEquipos()) {
			if (equipo.getPais().equalsIgnoreCase(nombre)) {
				equipoBuscado = equipo;
				JOptionPane.showMessageDialog(null, equipoBuscado.getPais() + " está en el torneo");
				break;
			} else if (equipoBuscado == null) {
				JOptionPane.showMessageDialog(null,
						"No se encontro ningun equipo. \nPara agregarlo vuelva al menú principal.");
				break;
			}
		}

	}



	public Equipo seleccionarEquipo(LinkedList<Equipo> equipos, String[] listaEquipos) {
		Equipo equipoBuscado = null;
		String equipoSeleccionado;
		equipoSeleccionado = (String) JOptionPane.showInputDialog(null, "Elija un equipo", null, 0, null, listaEquipos,
				listaEquipos[0]);

		for (int i = 0; i < listaEquipos.length; i++) {
			if (equipos.get(i).getPais().equalsIgnoreCase(equipoSeleccionado)) {
				equipoBuscado = equipos.get(i);
			}

		}

		return equipoBuscado;
	}

	public int cantidadTotalEquipos() {

		return this.equipos.size();

	}

	public String[] generarListaEquipos() {

		String[] listaEquipos = new String[equipos.size()];

		for (int i = 0; i < equipos.size(); i++) {

			listaEquipos[i] = equipos.get(i).getPais();

		}

		return listaEquipos;

	}
	
	public void mostrarResultadosPartido(Equipo equipoA, int golesA, int tarjetasAmarillasA, int tarjetasRojasA, Equipo equipoB, int golesB, int tarjetasAmarillasB, int tarjetasRojasB) {
		JOptionPane.showMessageDialog(null, equipoA.getPais() + " " + golesA + " - " + golesB + " " + equipoB.getPais() + "\nTarjetas Amarillas: " + equipoA.getPais() + ": " + tarjetasAmarillasA + ", " + equipoB.getPais() + ": " + tarjetasAmarillasB +
		"\nTarjetas Rojas: " + equipoA.getPais() + ": " + tarjetasRojasA + ", " + equipoB.getPais() + ": " + tarjetasRojasB);
	}

	public void jugarFases(LinkedList<Equipo> equipos) {
	
		String paisGanador = (String) JOptionPane.showInputDialog(
			null, "Selecciona tu equipo ganador", "Apuesta", JOptionPane.QUESTION_MESSAGE, null, this.generarListaEquipos(), this.generarListaEquipos()[0]
		);
		String fase = "";

		while (equipos.size() > 1) {
			System.out.println("-------------------");
			System.out.println("Fase: " + equipos.size() / 2);
			System.out.println("-------------------");

			LinkedList<Equipo> equiposGanadores = new LinkedList<>();
			
			switch (equipos.size() / 2) {
			case 8: 
				fase = "Octavos";
				
				break;
			case 4: 
				fase = "Cuartos";
				
				break;
			case 2: 
				fase = "Semifinal";
				
				break;
			case 1: 
				fase = "Final";
				
				break;

			}

			for (int i = 0; i < equipos.size(); i += 2) {
				Equipo equipoA = equipos.get(i);
				Equipo equipoB = equipos.get(i + 1);
				int golesA = (int) (Math.random() * 10);
				int golesB = (int) (Math.random() * 10);
				int tarjetasAmarillasA = (int) (Math.random() * 5);
				int tarjetasRojasA = (int) (Math.random() * 3);
				int tarjetasAmarillasB = (int) (Math.random() * 5);
				int tarjetasRojasB = (int) (Math.random() * 3);
				
				
				JOptionPane.showMessageDialog(null, "Partido de " + fase );
				mostrarResultadosPartido(equipoA, golesA, tarjetasAmarillasA, tarjetasRojasA, equipoB, golesB, tarjetasAmarillasB, tarjetasRojasB);

				if (golesA != golesB) {
					if (golesA > golesB) {
						equiposGanadores.add(equipoA);
						System.out.println("Se eliminó el equipo " + equipoB.getPais());
					} else {
						equiposGanadores.add(equipoB);
						System.out.println("Se eliminó el equipo " + equipoA.getPais());
					}
				} else {
					Equipo ganadorPenales = penales(equipoA, equipoB);
					equiposGanadores.add(ganadorPenales);
					System.out.println("Ganador por penales: " + ganadorPenales.getPais());
				}
			}

			equipos = equiposGanadores;
		}


		if (!equipos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Equipo campeón: " + equipos.getFirst().getPais());
			if (paisGanador.equalsIgnoreCase(equipos.getFirst().getPais())) {
				JOptionPane.showMessageDialog(null, "¡Ganaste la apuesta!");
			} else {
				JOptionPane.showMessageDialog(null, "Perdiste la apuesta.");
			}
		}
	}


	public static Equipo penales(Equipo equipoA, Equipo equipoB) {

		int ganador = (int) (Math.random() * 1) + 1;

		if (ganador == 1) {

			System.out.println("Penales: Gano equipo " + equipoA.getPais());
			return equipoA;

		} else {
			System.out.println( "Penales: Gano equipo " + equipoB.getPais());
			return equipoB;
		}
	}

	public void mostrarListaEquipos(String[] listaDeEquipos) {

		JOptionPane.showMessageDialog(null, listaDeEquipos);

	}

	public void jugarPartido(LinkedList<Equipo> equipos, String[] listaEquipos) {

		boolean flag = true;
		Equipo equipoA = null;
		Equipo equipoB;
		int goles = 0;
		Equipo equipoGanador = null;
		Boolean empate = false;

		do {

			equipoA = this.seleccionarEquipo(equipos, listaEquipos);
			equipoB = this.seleccionarEquipo(equipos, listaEquipos);

			if (equipoA.getPais().equals(equipoB.getPais())) {
				JOptionPane.showMessageDialog(null, "No se puede jugar el partido entre un mismo equipo");
				flag = true;
			} else {
				flag = false;
			}
		} while (flag);

		if (equipoA.getJugadores().size() < 7 || equipoA.getJugadores().size() < 7) {

			JOptionPane.showMessageDialog(null, "No se puede jugar el partido porque faltan jugadores");

		} else {

			do {

				int puntajeEquipoA = (int) (Math.random() * 5) + 1;
				int puntajeEquipoB = (int) (Math.random() * 5) + 1;

				if (puntajeEquipoB != puntajeEquipoA) {

					if (puntajeEquipoB < puntajeEquipoA) {
						equipoGanador = equipoA;
						goles = puntajeEquipoA;
						this.equipos.remove(equipoB);
						System.out.print("Se elimino equipo B");
						empate = false;

					} else {
						equipoGanador = equipoB;
						goles = puntajeEquipoB;
						this.equipos.remove(equipoA);
						System.out.print("Se elimino equipo A");
						empate = false;

					}

				} else {
					empate = true;
					JOptionPane.showMessageDialog(null, "Hay empate. Juegan alargue");

				}
			} while (empate);

			JOptionPane.showMessageDialog(null,
					"El equipo ganador es : " + equipoGanador.getPais() + " con " + goles + " goles.");

		}

	}

	public void jugarTorneo() {

		boolean flag = true;
		Equipo equipoA = this.equipos.getFirst();
		Equipo equipoB = this.equipos.getLast();
		System.out.println(equipoA.getPais());
		System.out.println(equipoB.getPais());

		int goles = 0;
		Equipo equipoGanador = null;
		Boolean empate = false;

		do {

			if (equipoA.getPais().equals(equipoB.getPais())) {
				// JOptionPane.showMessageDialog(null, "No se puede jugar el partido entre un
				// mismo equipo");
				flag = true;
			} else {
				flag = false;
			}
		} while (flag);

		if (equipoA.getJugadores().size() < 7 || equipoA.getJugadores().size() < 7) {

			JOptionPane.showMessageDialog(null, "No se puede jugar el partido porque faltan jugadores");

		} else {

			do {

				int puntajeEquipoA = (int) (Math.random() * 5) + 1;
				int puntajeEquipoB = (int) (Math.random() * 5) + 1;

				if (puntajeEquipoB != puntajeEquipoA) {

					if (puntajeEquipoB < puntajeEquipoA) {
						equipoGanador = equipoA;
						goles = puntajeEquipoA;
						this.equipos.remove(equipoB);
						System.out.println("Se elimino equipo B");
						empate = false;

					} else {
						equipoGanador = equipoB;
						goles = puntajeEquipoB;
						this.equipos.remove(equipoA);
						System.out.println("Se elimino equipo A");

						empate = false;

					}

				} else {
					empate = true;
					JOptionPane.showMessageDialog(null, "Hay empate. Juegan alargue");

				}
			} while (empate);

			JOptionPane.showMessageDialog(null,
					"El equipo ganador es : " + equipoGanador.getPais() + " con " + goles + " goles.");

		}

		this.jugarTorneo();

	}
}
