package model;

import java.util.Date;

public class Flight {
	private int idVoo;
	private String data_hr_decolagem;
	private String precoPassagem;
	private String aero_origem;
	private String aero_destino;

	public Flight() {
		super();
	}

	public Flight(int idVoo, String data_hr_decolagem, String precoPassagem, String aero_origem,
			String aero_destino) {
		super();
		this.idVoo = idVoo;
		this.data_hr_decolagem = data_hr_decolagem;
		this.precoPassagem = precoPassagem;
		this.aero_origem = aero_origem;
		this.aero_destino = aero_destino;
	}

	public int getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}

	public String getData_hr_decolagem() {
		return data_hr_decolagem;
	}

	public void setData_hr_decolagem(String data_hr_decolagem) {
		this.data_hr_decolagem = data_hr_decolagem;
	}

	public String getPrecoPassagem() {
		return precoPassagem;
	}

	public void setPrecoPassagem(String precoPassagem) {
		this.precoPassagem = precoPassagem;
	}

	public String getAero_origem() {
		return aero_origem;
	}

	public void setAero_origem(String aero_origem) {
		this.aero_origem = aero_origem;
	}

	public String getAero_destino() {
		return aero_destino;
	}

	public void setAero_destino(String aero_destino) {
		this.aero_destino = aero_destino;
	}

}
