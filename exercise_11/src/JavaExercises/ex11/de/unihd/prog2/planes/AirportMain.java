package de.unihd.prog2.planes;

public class AirportMain {
	public static void main(String[] args) {
		CargoAndPassengerPropellerPlane p1 = new CargoAndPassengerPropellerPlane();
		PassengerJetplane p2 = new RadarEquippedPassengerJetplane();
		p1.setCargoWeightInTons(1.2);
		p1.setPassengerCount(22);
		p2.setPassengerCount(100);
		p1.takeoff();
		System.out.println();
		p2.takeoff();
	}

}
