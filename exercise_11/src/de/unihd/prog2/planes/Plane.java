package de.unihd.prog2.planes;

public class Plane {
	protected void prepareForTakeoff() {
	}
	public void takeoff() {
		prepareForTakeoff();
		System.out.println("Flying away!");
	}
}
