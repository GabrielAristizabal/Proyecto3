package model;

public class CaracteristicasAdicionales {
	private String caracteristica;
	private boolean disponible;
	
	public CaracteristicasAdicionales(String caracteristica, boolean disponibilidad) {
		this.caracteristica = caracteristica;
		this.disponible = disponibilidad;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public boolean isDisponibilidad() {
		return disponible;
	}
	
}
