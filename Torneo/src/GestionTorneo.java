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
	
	/**
	 * Genera un random para cada equipo y determina cual fue el mayor para imprimir un mensaje de quien fue el ganador. En caso de empate 	tambien lo muestra en pantalla.
	 * @param equipoA
	 * @param equipoB
	 */
	public void jugarPartido(Equipo equipoA, Equipo equipoB) {
		
		Equipo equipoGanador = null;
		int puntajeEquipoA = (int) (Math.random() * 10) + 1;
		int puntajeEquipoB = (int) (Math.random() * 10) + 1;
		String mensaje = "Equipo ganador: ";
		
		if (puntajeEquipoB != puntajeEquipoA) {
			
			if (puntajeEquipoB < puntajeEquipoA) {
			equipoGanador = equipoA;
		
			}else {
			equipoGanador = equipoB;
			}
			mensaje += equipoGanador.getNombre();
			
		}else {
			mensaje = "Partido empatado";
		}
		
		JOptionPane.showMessageDialog(null, mensaje);
		}		
	
	public void agregarEquipo(LinkedList<Equipo>equipos) {
		
			String nombre = JOptionPane.showInputDialog("Ingrese nombre del equipo");
			String pais = JOptionPane.showInputDialog("Ingrese pais");
			
			equipos.add(new Equipo(nombre, pais));
		}
		

	//Deberia devolver un linkedList nuevo?
	
	public void eliminarEquipoDeLista(LinkedList<Equipo>equipos) {
		String nombre = JOptionPane.showInputDialog("Ingrese nombre del equipo");
		Equipo equipoAeliminar = null;
		
		for (Equipo equipo : equipos) {
			if (equipo.getNombre().equals(nombre)) {
				equipoAeliminar = equipo;
				break;
			}
		}
		
		equipos.remove(equipoAeliminar);
	}
		
		
	public void buscarEquipoPorNombre(LinkedList<Equipo>equipos) {
		String nombre = JOptionPane.showInputDialog("Ingrese nombre del jugador");
		Equipo equipoBuscado = null;
		
		for (Equipo equipo : equipos) {
			if (equipo.getNombre().equals(nombre)) {
				equipoBuscado = equipo;
				JOptionPane.showMessageDialog(null, "Se encontro un resultado" + equipoBuscado);
				break;
			}else if (equipoBuscado == null) {
				JOptionPane.showMessageDialog(null, "No se encontro ningun jugador con ese nombre" + equipoBuscado);
			}
		}
		
	}
	public int cantidadTotalEquipos(LinkedList<Equipo>equipos) {
		
		return equipos.size();
	}
	
	public void mostrarListaEquipos(LinkedList<Equipo>equipos) {
		
		String[] listaEquipos = new String[equipos.size()];
		
		for (int i = 0; i < equipos.size(); i++) {
			
			listaEquipos[i] = equipos.get(i).getNombre();
			JOptionPane.showMessageDialog(null, i+1 + "-" + listaEquipos[i]);
			
		}
		
	}

}

