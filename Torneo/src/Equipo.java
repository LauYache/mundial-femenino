import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {
	
	private String pais;
	private LinkedList<Jugador> jugadores;
	
	
	public Equipo() {
		
		this.pais = "";
		this.jugadores = new LinkedList<>();;
	}
	
	public Equipo(String pais) {
		
		this.pais = pais;
		this.jugadores = new LinkedList<>();;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void agregarJugador(LinkedList<Jugador> jugadores) {
		
		String nombre = JOptionPane.showInputDialog("Ingrese nombre del jugador");
		int numeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de camiseta"));
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
		int posicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese posicion"));
		
		jugadores.add(new Jugador(nombre, numeroCamiseta, posicion, edad));
	}
	
	public void eliminarJugador(LinkedList<Jugador> jugadores) {
		String nombre = JOptionPane.showInputDialog("Ingrese nombre del jugador");
		Jugador jugadorAeliminar = null;
		
		for (Jugador jugador : jugadores) {
			if (jugador.getNombre().equals(nombre)) {
				jugadorAeliminar = jugador;
				break;
			}
		}
		
		jugadores.remove(jugadorAeliminar);
	}
	

	
	public void buscarJugador(LinkedList<Jugador> jugadores) {
		
		
		String nombre = JOptionPane.showInputDialog("Ingrese nombre del jugador");
		Jugador jugadorBuscado = null;
		
		for (Jugador jugador : jugadores) {
			if (jugador.getNombre().equals(nombre)) {
				jugadorBuscado = jugador;
				JOptionPane.showMessageDialog(null, "Se encontro un resultado" + jugadorBuscado);
				break;
			}else if (jugadorBuscado == null) {
				JOptionPane.showMessageDialog(null, "No se encontro ningun jugador con ese nombre" + jugadorBuscado);
			}
		}
		
	
	}
	public String[] generarListaJugadores(LinkedList<Jugador>jugadores) {
		
		String[] listaJugadores = new String[jugadores.size()];
		
		for (int i = 0; i < jugadores.size(); i++) {
			
			listaJugadores[i] = jugadores.get(i).getNombre();
			
			
		}
		
		return listaJugadores;
		
	}
	
	public void mostrarListaEquipos(String[] listaDeEquipos) {
		
	
		JOptionPane.showMessageDialog(null,  listaDeEquipos);
		
		
	}

	
	public int cantidadJugadores(LinkedList<Jugador> jugadores) {
		
		return jugadores.size();
	}
	
	
//		for (Jugador jugador: jugadores) {
//			JOptionPane.showMessageDialog(null, "Jugador: " + jugador);
//		}
	}
	
	
