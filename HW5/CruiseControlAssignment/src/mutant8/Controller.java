package mutant8;

class Controller {
  public final static int INACTIVE = 0; // cruise controller states
  public final static int ACTIVE   = 1;
  public final static int CRUISING = 2;
  public final static int STANDBY  = 3;

  private int controlState;
  private SpeedControl sc;

  public Controller(){
    controlState  = INACTIVE;
    sc=new SpeedControl();
  }

  public void brake(){
    if (controlState==CRUISING) {
       sc.disableControl();
       controlState=STANDBY;
    }
  }

  public void accelerator(){
    if (controlState==CRUISING ){
      sc.disableControl();
      controlState=STANDBY;
    }
  }

  public void engineOff(){
    if(controlState!=INACTIVE) {
      if (controlState==CRUISING)	
          sc.disableControl();
      controlState=INACTIVE;
    }
  }

  public void engineOn(){
    if(controlState==INACTIVE){
      controlState=ACTIVE;
    }
  }

  public void on(){
    if(controlState!=INACTIVE){
//      sc.enableControl();		// Injected fault
      controlState=CRUISING;
    }
  }

  public void off(){
    if(controlState==CRUISING){
      sc.disableControl();
      controlState=STANDBY;
    }
  }

  public void resume(){
    if(controlState==STANDBY){
       sc.enableControl();		
       controlState=CRUISING;
    }
  }

  public int getControlState() {
	return controlState;
  }

  public SpeedControl getSpeedControl(){
	return sc;
  }
}

