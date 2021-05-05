// É a classe principal do simulador
import java.util.HashMap;
import java.util.Map;

public class SIC {
  Map<String, Integer> register = new HashMap<String, Integer>();
  Memory memory;
  Loader loader;

  public SIC() {
    memory = new Memory();
    loader = new Loader(memory);
    setAllRegisters();
    System.out.println(memory.getData(0));
  }

  protected void setAllRegisters() {
    register.put("A", 1);
    register.put("X", 0);
    register.put("L", 0);
    register.put("B", 0);
    register.put("S", 0);
    register.put("T", 0);
    register.put("PC", 0);
    register.put("SW", 0);
  }
}