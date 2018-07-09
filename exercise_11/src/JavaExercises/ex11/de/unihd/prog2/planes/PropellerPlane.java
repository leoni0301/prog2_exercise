package de.unihd.prog2.planes;

public class PropellerPlane extends Plane {
	@Override
	protected void prepareForTakeoff() {
		System.out.println("Spinning up propeller...");
	}
}
