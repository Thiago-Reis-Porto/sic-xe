import SIC.SIC;
import SIC.Register;
import SIC.Memory;
import SIC.Loader;
import SIC.Instruction;

class GUI {
  private static SIC sic;
  private static Register register;
  private static Memory memory;
  private static Loader loader;
  private static Instruction instruction;

  public static void main(String[] args) {
    register = new Register();
    memory = new Memory();
    loader = new Loader();
    instruction = new Instruction();

    sic = new SIC(register, memory, loader, instruction);
    sic.start();
  }
}