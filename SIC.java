// É a classe principal do simulador
import java.util.HashMap;
import java.util.Map;

public class SIC {
  Map<String, Integer> register = new HashMap<String, Integer>();

  public SIC() {
    register.put("A", new Integer(99));
    register.put("X", new Integer(0));
    register.put("L", new Integer(0));
    register.put("B", new Integer(0));
    register.put("S", new Integer(0));
    register.put("T", new Integer(0));
    register.put("PC", new Integer(0));
    register.put("SW", new Integer(0));
  }

  public void teste() {
    System.out.println(register.get("A"));
  }
}