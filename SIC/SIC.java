package SIC;

public class SIC {
  private Register register;
  private Memory memory;
  private Loader loader;
  private Instruction instruction;

  public SIC() {
    register = new Register();
    memory = new Memory();
    loader = new Loader();
    instruction = new Instruction();
  }

  public void start() {
    loader.start(memory);

    int i = 0;

    while (true) {
      byte opcode = memory.getDataByte(i);
      byte nixbpe = 0x0;
      String r1 = "", r2 = "";
      int memoryAddress = 0;

      if (opcode == 0x0F) {
        return;
      }

      if (instruction.getType(opcode) == 2) {
        byte registersInByte = memory.getDataByte(++i);
        String registers = Integer.toHexString(registersInByte);
        r1 = register.getName(Character.getNumericValue(registers.charAt(0)));
        r2 = register.getName(Character.getNumericValue(registers.charAt(1)));
      }

      if (instruction.getType(opcode) == 3) {
        nixbpe = memory.getDataByte(++i);
        memoryAddress = memory.getDataByte(++i);
      }

      // nao é usado de fato
      if (instruction.getType(opcode) == 4) {
        nixbpe = memory.getDataByte(++i);
        memoryAddress = memory.getDataByte(++i);
        i += 1;
      }

      instruction.initInstruction(opcode, nixbpe, r1, r2, memoryAddress);
      instruction.execInstruction(register, memory);
      i += 1;
    }
  }

  public Memory getMemory() {
    return memory;
  }

  public Register getRegister() {
    return register;
  }
}