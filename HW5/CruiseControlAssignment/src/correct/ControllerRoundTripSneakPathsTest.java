package correct;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControllerRoundTripSneakPathsTest {
    @Test
    void controllerTest1() {
        Controller c = new Controller();
        assertEquals(c.getControlState(), Controller.INACTIVE);
    }

    @Test
    void controllerTest1_1() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
    }

    @Test
    void controllerTest1_1_1() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.engineOff();
        assertEquals(c.getControlState(), Controller.INACTIVE);
    }

    @Test
    void controllerTest1_1_1_1() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.engineOff();
        assertEquals(c.getControlState(), Controller.INACTIVE);
        c.resume();
        assertEquals(c.getControlState(), Controller.INACTIVE);
    }

    @Test
    void controllerTest1_1_1_2() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.engineOff();
        assertEquals(c.getControlState(), Controller.INACTIVE);
        c.resume();
        assertEquals(c.getControlState(), Controller.INACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.INACTIVE);
    }

    @Test
    void controllerTest1_1_1_3() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.engineOff();
        assertEquals(c.getControlState(), Controller.INACTIVE);
        c.resume();
        assertEquals(c.getControlState(), Controller.INACTIVE);
        c.off();
        assertEquals(c.getControlState(), Controller.INACTIVE);
    }

    @Test
    void controllerTest1_1_1_4() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.engineOff();
        assertEquals(c.getControlState(), Controller.INACTIVE);
        c.resume();
        assertEquals(c.getControlState(), Controller.INACTIVE);
        c.accelerator();
        assertEquals(c.getControlState(), Controller.INACTIVE);
    }

    @Test
    void controllerTest1_1_1_5() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.engineOff();
        assertEquals(c.getControlState(), Controller.INACTIVE);
        c.resume();
        assertEquals(c.getControlState(), Controller.INACTIVE);
        c.brake();
        assertEquals(c.getControlState(), Controller.INACTIVE);
    }

    @Test
    void controllerTest1_1_2() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.brake();
        assertEquals(c.getControlState(), Controller.ACTIVE);
    }

    @Test
    void controllerTest1_1_2_1() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.brake();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.off();
        assertEquals(c.getControlState(), Controller.ACTIVE);
    }

    @Test
    void controllerTest1_1_2_2() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.brake();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.resume();
        assertEquals(c.getControlState(), Controller.ACTIVE);
    }

    @Test
    void controllerTest1_1_2_3() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.brake();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
    }

    @Test
    void controllerTest1_1_3() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.accelerator();
        assertEquals(c.getControlState(), Controller.ACTIVE);
    }

    @Test
    void controllerTest1_1_4() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
    }

    @Test
    void controllerTest1_1_4_1() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.brake();
        assertEquals(c.getControlState(), Controller.STANDBY);
    }

    @Test
    void controllerTest1_1_4_2() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.accelerator();
        assertEquals(c.getControlState(), Controller.STANDBY);
    }

    @Test
    void controllerTest1_1_4_3() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.off();
        assertEquals(c.getControlState(), Controller.STANDBY);
    }

    @Test
    void controllerTest1_1_4_3_1() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.off();
        assertEquals(c.getControlState(), Controller.STANDBY);
        c.resume();
        assertEquals(c.getControlState(), Controller.CRUISING);
    }

    @Test
    void controllerTest1_1_4_3_2() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.off();
        assertEquals(c.getControlState(), Controller.STANDBY);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
    }

    @Test
    void controllerTest1_1_4_3_3() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.off();
        assertEquals(c.getControlState(), Controller.STANDBY);
        c.engineOff();
        assertEquals(c.getControlState(), Controller.INACTIVE);
    }

    @Test
    void controllerTest1_1_4_3_4() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.off();
        assertEquals(c.getControlState(), Controller.STANDBY);
        c.engineOn();
        assertEquals(c.getControlState(), Controller.STANDBY);
    }

    @Test
    void controllerTest1_1_4_3_5() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.off();
        assertEquals(c.getControlState(), Controller.STANDBY);
        c.brake();
        assertEquals(c.getControlState(), Controller.STANDBY);
    }

    @Test
    void controllerTest1_1_4_3_6() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.off();
        assertEquals(c.getControlState(), Controller.STANDBY);
        c.accelerator();
        assertEquals(c.getControlState(), Controller.STANDBY);
    }

    @Test
    void controllerTest1_1_4_3_7() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.off();
        assertEquals(c.getControlState(), Controller.STANDBY);
        c.off();
        assertEquals(c.getControlState(), Controller.STANDBY);
    }

    @Test
    void controllerTest1_1_4_4() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.engineOn();
        assertEquals(c.getControlState(), Controller.CRUISING);
    }

    @Test
    void controllerTest1_1_4_5() {
        Controller c = new Controller();
        c.engineOn();
        assertEquals(c.getControlState(), Controller.ACTIVE);
        c.on();
        assertEquals(c.getControlState(), Controller.CRUISING);
        c.resume();
        assertEquals(c.getControlState(), Controller.CRUISING);
    }

}