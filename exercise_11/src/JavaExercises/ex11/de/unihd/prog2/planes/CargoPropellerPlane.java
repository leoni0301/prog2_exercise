package de.unihd.prog2.planes;

public class CargoPropellerPlane extends PropellerPlane {
	private double cargoWeightInTons;
	
	@Override
	protected void prepareForTakeoff() {
		System.out.println("Loading " + Double.toString(cargoWeightInTons) + " tons of cargo...");
		super.prepareForTakeoff();
	}

	public double getCargoWeightInTons() {
		return cargoWeightInTons;
	}

	public void setCargoWeightInTons(double cargoWeightInTons) {
		this.cargoWeightInTons = cargoWeightInTons;
	}
}
