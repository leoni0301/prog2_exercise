package de.unihd.prog2.planes;

public class Jetplane extends Plane {
	@Override
	protected void prepareForTakeoff() {
		System.out.println("Starting engines...");
	}
}
