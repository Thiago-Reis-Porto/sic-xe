public class SIC {
  Register register;
  Memory memory;
  Loader loader;
  Instruction instruction;

  public SIC() {
    register = new Register();
    memory = new Memory();
    loader = new Loader(memory);
    instruction = new Instruction(register, memory);

    startSIC();
  }

  protected void startSIC() {
    loader.readInputFile();
  }
}