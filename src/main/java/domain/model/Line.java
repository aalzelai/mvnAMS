package domain.model;

public class Line {

	int id;
	int tipo_Pista;
	int order;
	String airport;
	Boolean taken;
	
	public Line(int id, int tipo_Pista, int order,
				String airport, Boolean taken){
		this.id = id;
		this.tipo_Pista = tipo_Pista;
		this.order = order;
		this.airport = airport;
		this.taken = taken;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo_Pista() {
		return tipo_Pista;
	}

	public void setTipo_Pista(int tipo_Pista) {
		this.tipo_Pista = tipo_Pista;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

	public Boolean getTaken() {
		return taken;
	}

	public void setTaken(Boolean taken) {
		this.taken = taken;
	}
	
}
