package model;

public class Reservation {
	private int idReserva;
	private int idUsuario;
	private int idVoo;

	public Reservation() {

	}

	public Reservation(int idReserva, int idUsuario, int idVoo) {
		super();
		this.idReserva = idReserva;
		this.idUsuario = idUsuario;
		this.idVoo = idVoo;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}

}
