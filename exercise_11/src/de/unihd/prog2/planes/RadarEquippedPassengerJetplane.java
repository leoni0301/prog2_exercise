package de.unihd.prog2.planes;

public class RadarEquippedPassengerJetplane extends PassengerJetplane {
	@Override
	protected void prepareForTakeoff() {
		super.prepareForTakeoff();
		System.out.println("Turning on radar...");
	}
}
