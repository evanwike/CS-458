package correct;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerStateCoverageTest {
	
	private Controller controller = new Controller();

	@Test
	public void test() {
		controller.engineOn();
		assertTrue(controller.getControlState()==Controller.ACTIVE);
		controller.on();
		assertEquals(controller.getControlState(), Controller.CRUISING);
		controller.brake();
		assertEquals(controller.getControlState(), Controller.STANDBY);
	}

}
