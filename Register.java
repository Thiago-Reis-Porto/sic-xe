import java.util.HashMap;
import java.util.Map;

public class Register {
  private Map<String, Integer> register;

  public Register() {
	
	register = new HashMap<String, Integer>();
	init();
  };

  private void init() {
		register.put("A", 1);
	    register.put("X", 0);
	    register.put("L", 0);
	    register.put("B", 0);
	    register.put("S", 0);
	    register.put("T", 0);
	    register.put("PC", 0);
	    register.put("SW", 0);
  }
  
  protected Map<String, Integer> getRegister() {
    return this.register;
  }
}
