package SIC;

public class SIC {
  private Register register;
  private Memory memory;
  private Loader loader;
  private Instruction instruction;
  private int instructionCounter;

  public SIC() {
    register = new Register();
    memory = new Memory();
    loader = new Loader();
    instruction = new Instruction();
  }

  public void start(String filePath) {
    loader.start(memory, filePath);
    instructionCounter = 0;
    memory.setNewData(69, 1024);
  }

  public void step() {
    byte opcode = memory.getDataByte(instructionCounter);
    byte nixbpe = 0x0;
    String r1 = "", r2 = "";
    int memoryAddress = 0;

    if (opcode == 0x0F) {
      System.out.println("end");
      return;
    }

    if (instruction.getType(opcode) == 2) {
      byte registersInByte = memory.getDataByte(++instructionCounter);
      String registers = Integer.toHexString(registersInByte);
      r1 = register.getName(Character.getNumericValue(registers.charAt(0)));
      r2 = register.getName(Character.getNumericValue(registers.charAt(1)));
    }

    if (instruction.getType(opcode) == 3) {
      nixbpe = memory.getDataByte(++instructionCounter);
      memoryAddress = memory.getDataByte(++instructionCounter);
    }

    // nao é usado de fato
    if (instruction.getType(opcode) == 4) {
      nixbpe = memory.getDataByte(++instructionCounter);
      memoryAddress = memory.getDataByte(++instructionCounter);
      instructionCounter += 1;
    }

    instruction.initInstruction(opcode, nixbpe, r1, r2, memoryAddress);
    instruction.execInstruction(register, memory);
    instructionCounter += 1;
  }

  public Memory getMemory() {
    return memory;
  }

  public Register getRegister() {
    return register;
  }
}