import java.util.HashMap;
import java.util.Map;

public class Register {
  private Map<String, Integer> register;

  public Register() {
		init();
  };

  private void init() {
		register = new HashMap<String, Integer>();
		register.put("A", -1);
		register.put("X", -1);
		register.put("L", -1);
		register.put("B", -1);
		register.put("S", -1);
		register.put("T", -1);
		register.put("PC", -1);
		register.put("SW", -1);
  }

	public int get(String key) {
		return register.get(key);
	}

	public void replace(String key, int value) {
		register.replace(key, value);
	}
}
