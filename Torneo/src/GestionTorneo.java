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

	// Deberia devolver un linkedList nuevo?

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
				JOptionPane.showMessageDialog(null, "No se encontro ningun equipo. \nPara agregarlo vuelva al menú principal.");
				break;
			}
		}

	}

	public String seleccionarEquipo1(LinkedList<Equipo> equipos, String[] listaEquipos) {
		Equipo equipoBuscado = null;
		String equipoSeleccionado;
		equipoSeleccionado = (String) JOptionPane.showInputDialog(null, "Elija una opcion", null, 0, null, listaEquipos,
				listaEquipos[0]);

		for (int i = 0; i < listaEquipos.length; i++) {
			if (equipos.get(i).getPais().equalsIgnoreCase(equipoSeleccionado)) {
				equipoBuscado = equipos.get(i);
			}

		}
		JOptionPane.showMessageDialog(null, "Estas modificando el equipo: " + equipoBuscado.getPais());

		return equipoSeleccionado;
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

	public void mostrarListaEquipos(String[] listaDeEquipos) {

		JOptionPane.showMessageDialog(null, listaDeEquipos);

	}

	public void jugarPartido(LinkedList<Equipo> equipos, String[] listaEquipos) {
		boolean flag = true;
		Equipo equipoA;
		Equipo equipoB;
		
		do {
			
			equipoA = this.seleccionarEquipo(equipos, listaEquipos);
			equipoB = this.seleccionarEquipo(equipos, listaEquipos);
			
			 if (equipoA.getPais().equals(equipoB.getPais())) {
		            flag = true; 
		        } else {
		            flag = false; 
		        }
		    } while (flag); 
		int goles = 0;
		

		Equipo equipoGanador = null;
		Boolean empate = false;

		do {

			int puntajeEquipoA = (int) (Math.random() * 5) + 1;
			int puntajeEquipoB = (int) (Math.random() * 5) + 1;

			if (puntajeEquipoB != puntajeEquipoA) {

				if (puntajeEquipoB < puntajeEquipoA) {
					equipoGanador = equipoA;
					goles = puntajeEquipoA;

				} else {
					equipoGanador = equipoB;
					goles = puntajeEquipoB;

				}

			} else {
				empate = true;
			}
		} while (empate);

		JOptionPane.showMessageDialog(null, "El equipo ganador es : " + equipoGanador.getPais() + " con " + goles + " goles.");

	}

}
