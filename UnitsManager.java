import java.util.HashMap;

public class UnitsManager {
	private HashMap<String, String> unitToSwitch;
	private HashMap<String, String> unitToPort;
	
	public UnitsManager() {
		unitToSwitch = new HashMap<String, String>();
		unitToPort = new HashMap<String, String>();
		
		//This means that DPI unit is connected to switch 2, port 1
		unitToSwitch.put("DPI", "2");
		unitToPort.put("DPI", "1");
		
		//This means that DPI unit is connected to switch 1, port 2
		unitToSwitch.put("IDS", "1");
		unitToPort.put("IDS", "2");	
	}
	
	public String getSwitch(String unit) {
		return unitToSwitch.get(unit);
	}
	
	public String getPort(String unit) {
		return unitToPort.get(unit);
	}
}
