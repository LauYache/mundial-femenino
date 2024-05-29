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
	

	public void jugarPartido(Equipo equipoA, Equipo equipoB) {
		Equipo equipoGanador = null;
		Boolean empate = false;
		
		do {
			
		
		
		int puntajeEquipoA = (int) (Math.random() * 10) + 1;
		int puntajeEquipoB = (int) (Math.random() * 10) + 1;
	
		
		if (puntajeEquipoB != puntajeEquipoA) {
			
			if (puntajeEquipoB < puntajeEquipoA) {
			equipoGanador = equipoA;
		
			}else {
			equipoGanador = equipoB;
			}
			
		}else {
			empate = true;
		}
		}while(empate);
		
		JOptionPane.showMessageDialog(null, "Equipo ganador: " + equipoGanador.getPais());
		
	}
	
	public void agregarEquipo() {
		
			String pais = JOptionPane.showInputDialog("Ingrese pais");
			
			this.getEquipos().add(new Equipo(pais));
	
		}
		

	//Deberia devolver un linkedList nuevo?
	
	public void eliminarEquipoDeLista() {
		String nombre = JOptionPane.showInputDialog("Ingrese nombre del equipo");


		for (Equipo equipo : this.getEquipos()) {
			if (equipo.getPais().equals(nombre)) {
				this.getEquipos().remove(equipo);
				break;
			}
		}
		
	
	}
		
		
	public void buscarEquipoPorNombre() {
		String nombre = JOptionPane.showInputDialog("Ingrese nombre del equipo");
		Equipo equipoBuscado = null;
		
		for (Equipo equipo : this.getEquipos()) {
			if (equipo.getPais().equals(nombre)) {
				equipoBuscado = equipo;
				JOptionPane.showMessageDialog(null, "Se encontro un resultado " + equipoBuscado);
				break;
			}else if (equipoBuscado == null) {
				JOptionPane.showMessageDialog(null, "No se encontro ningun equipo con ese nombre" + equipoBuscado);
			}
		}
		
	}

	public String seleccionarEquipo1(LinkedList<Equipo>equipos, String[] listaEquipos) {
		Equipo equipoBuscado = null;
		String equipoSeleccionado;
		equipoSeleccionado = (String) JOptionPane.showInputDialog(null, "Elija una opcion", null, 0, null, listaEquipos, listaEquipos[0]);
		
		
		for (int i = 0; i < listaEquipos.length; i++) {
			if (equipos.get(i).getPais().equalsIgnoreCase(equipoSeleccionado)) {
				equipoBuscado = equipos.get(i);
			}
			
		}
		JOptionPane.showMessageDialog(null, "Estas modificando el equipo: " + equipoBuscado.getPais());
		

			return equipoSeleccionado;
		}
	
	public Equipo seleccionarEquipo(LinkedList<Equipo>equipos, String[] listaEquipos) {
		Equipo equipoBuscado = null;
		String equipoSeleccionado;
		equipoSeleccionado = (String) JOptionPane.showInputDialog(null, "Elija una opcion", null, 0, null, listaEquipos, listaEquipos[0]);
		
		
		for (int i = 0; i < listaEquipos.length; i++) {
			if (equipos.get(i).getPais().equalsIgnoreCase(equipoSeleccionado)) {
				equipoBuscado = equipos.get(i);
			}
			
		}
		JOptionPane.showMessageDialog(null, "Estas modificando el equipo: " + equipoBuscado.getPais());
		

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
		
	
		JOptionPane.showMessageDialog(null,  listaDeEquipos);
		

		
	}

}

