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
	
	public void agregarEquipo(LinkedList<Equipo>equipos) {
		
			
			String pais = JOptionPane.showInputDialog("Ingrese pais");
			
			equipos.add(new Equipo(pais));
		}
		

	//Deberia devolver un linkedList nuevo?
	
	public void eliminarEquipoDeLista(LinkedList<Equipo>equipos) {
		String nombre = JOptionPane.showInputDialog("Ingrese nombre del equipo");
		Equipo equipoAeliminar = null;
		
		for (Equipo equipo : equipos) {
			if (equipo.getPais().equals(nombre)) {
				equipoAeliminar = equipo;
				break;
			}
		}
		
		equipos.remove(equipoAeliminar);
	}
		
		
	public void buscarEquipoPorNombre(LinkedList<Equipo>equipos) {
		String nombre = JOptionPane.showInputDialog("Ingrese nombre del equipo");
		Equipo equipoBuscado = null;
		
		for (Equipo equipo : equipos) {
			if (equipo.getPais().equals(nombre)) {
				equipoBuscado = equipo;
				JOptionPane.showMessageDialog(null, "Se encontro un resultado" + equipoBuscado);
				break;
			}else if (equipoBuscado == null) {
				JOptionPane.showMessageDialog(null, "No se encontro ningun equipo con ese nombre" + equipoBuscado);
			}
		}
		
	}
	/**
	 * Funcion para seleccionar un equipo de la lista para realizar las operaciones
	 * @param linkedList de un torneo
	 * @param array de string con el nombre/pais del equipo
	 * @return objeto equipo para manipularlo con las opciones del menu del usuario
	 */
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

	
	public int cantidadTotalEquipos(LinkedList<Equipo>equipos) {
		
		return equipos.size();
	}
	

	public String[] generarListaEquipos(LinkedList<Equipo>equipos) {
		
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

