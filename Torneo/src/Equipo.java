import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {

	private String pais;
	private LinkedList<Jugador> jugadores;

	public Equipo() {

		this.pais = "";
		this.jugadores = new LinkedList<>();
		;
	}

	public Equipo(String pais) {

		this.pais = pais;
		this.jugadores = new LinkedList<>();
		;
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

	public void agregarJugador() {

		String nombre;
		int numeroCamiseta;
		int edad;
		int posicion;

		do {

			nombre = JOptionPane.showInputDialog("Ingrese nombre del jugador");
			numeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de camiseta"));
			edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
			posicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese posicion"));

			this.jugadores.add(new Jugador(nombre, numeroCamiseta, posicion, edad));
		} while (!nombre.isEmpty() || numeroCamiseta <= 0 || numeroCamiseta > 99 || posicion >= 0 && posicion < 11);
	}

	public void eliminarJugador() {

		String nombre;
		do {
			nombre = JOptionPane.showInputDialog("Ingrese nombre del jugador");
			Jugador jugadorAeliminar = null;

			for (Jugador jugador : this.jugadores) {
				if (jugador.getNombre().equals(nombre)) {
					jugadorAeliminar = jugador;
					break;
				}

			}

			this.jugadores.remove(jugadorAeliminar);
		} while (nombre == "");
	}

	public void buscarJugador() {
		String nombre;

		do {

			nombre = JOptionPane.showInputDialog("Ingrese nombre del jugador");
			Jugador jugadorBuscado = null;

			for (Jugador jugador : this.jugadores) {
				if (jugador.getNombre().equalsIgnoreCase(nombre)) {
					jugadorBuscado = jugador;
					JOptionPane.showMessageDialog(null,
							"El jugador " + jugadorBuscado.getNombre() + "está en la lista");
					break;
				} else if (jugadorBuscado == null) {
					JOptionPane.showMessageDialog(null, "No se encontro ningun jugador con ese nombre");
					break;
				} else if (nombre.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Vuelva a realizar la busqueda, ingrese un nombre valido.");

				}

			}
		} while (nombre.isEmpty());

	}

	public String[] generarListaJugadoras() {

		String[] listaJugadores = new String[jugadores.size()];

		for (int i = 0; i < this.jugadores.size(); i++) {

			listaJugadores[i] = this.jugadores.get(i).getNombre();

		}

		return listaJugadores;

	}

	public void mostrarListaJugadoras(String[] listaDeJugadoras) {

		JOptionPane.showMessageDialog(null, listaDeJugadoras);

	}

	public void cantidadJugadoras() {

		JOptionPane.showMessageDialog(null, this.jugadores.size());
	}

}
