package model;

public class Casa {
	private int id;
	private int tipo;
	
	
	public Casa(int id,int tipo) {
		this.id = id;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}
