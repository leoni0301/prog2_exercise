package de.unihd.prog2.planes;

public class PassengerJetplane extends Jetplane {
	private int passengerCount;
	
	@Override
	protected void prepareForTakeoff() {
		System.out.println("Loading " + Integer.toString(passengerCount) + " passengers");
		super.prepareForTakeoff();
	}


	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
}
