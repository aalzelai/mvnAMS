package domain.model;

public class Airplane {
	
	int id_Tipo_Avion;
	int id;
	int id_Airline;
	int id_Estatus;
	int terminal;
	float posX;
	float posY;
	
	public Airplane(int id, int id_Tipo_Avion, int id_Airline,
					int id_Estatus, float posX, float posY,
					int terminal){
		this.id = id;
		this.id_Tipo_Avion = id_Tipo_Avion;
		this.id_Airline = id_Airline;
		this.id_Estatus = id_Estatus;
		this.posX = posX;
		this.posY = posY;
		this.terminal = terminal;
	}

	public int getId_Tipo_Avion() {
		return id_Tipo_Avion;
	}

	public void setId_Tipo_Avion(int id_Tipo_Avion) {
		this.id_Tipo_Avion = id_Tipo_Avion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_Airline() {
		return id_Airline;
	}

	public void setId_Airline(int id_Airline) {
		this.id_Airline = id_Airline;
	}

	public int getId_Estatus() {
		return id_Estatus;
	}

	public void setId_Estatus(int id_Estatus) {
		this.id_Estatus = id_Estatus;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getTerminal() {
		return terminal;
	}

	public void setTerminal(int terminal) {
		this.terminal = terminal;
	}

}
