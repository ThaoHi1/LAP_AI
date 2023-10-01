package task2;

import java.util.Random;

import task2.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		
		if(p.getLocationState()==LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}else if((p.getAgentLocation()==Environment.LOCATION_A)||
				(p.getAgentLocation()==Environment.LOCATION_B)||
				(p.getAgentLocation()==Environment.LOCATION_C)||
				(p.getAgentLocation()==Environment.LOCATION_D)){
			Random a = new Random();
			int random = a.nextInt(4);
			switch(random) {
			case 1:
				return Environment.MOVE_DOWN;
			case 2:
				return Environment.MOVE_UP;
			case 3:
				return Environment.MOVE_LEFT;
			default:
				return Environment.MOVE_RIGHT;
			}
			
		}
		return NoOpAction.NO_OP;
	}
	
}