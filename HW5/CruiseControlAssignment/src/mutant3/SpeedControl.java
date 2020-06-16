package mutant3;

class SpeedControl {
	public final static int DISABLED = 0; // speed control states
	public final static int ENABLED = 1;
	private int state;

	public SpeedControl() {
		state = DISABLED;
	}

	public void enableControl() {
		state = ENABLED;
	}

	public void disableControl() {
		state = DISABLED;
	}

	public int getSpeedControlState() {
		return state;
	}

}
