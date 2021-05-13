package SIC;
public class SIC {
  private Register register;
  private Memory memory;
  private Loader loader;
  private Instruction instruction;

  public SIC(Register register, Memory memory, Loader loader, Instruction instruction) {
    this.register = register;
    this.memory = memory;
    this.loader = loader;
    this.instruction = instruction;
  }

  public void start() {
    loader.start(memory);

    memory.setNewData(69, 1024);

    int i = 0;

    while (true) {
      byte opcode = memory.getDataByte(i);
      byte nixbpe = 0x0;
      String r1 = "", r2 = "";
      int memoryAddress = 0;

      if (opcode == 0x0F) {
        return;
      }

      if (checkInstructionType(opcode) == 2) {
        byte registersInByte = memory.getDataByte(++i);
        String registers = Integer.toHexString(registersInByte);
        r1 = getRegisterName(Character.getNumericValue(registers.charAt(0)));
        r2 = getRegisterName(Character.getNumericValue(registers.charAt(1)));
      }

      if (checkInstructionType(opcode) == 3) {
        nixbpe = memory.getDataByte(++i);
        memoryAddress = memory.getDataByte(++i);
      }

      if (checkInstructionType(opcode) == 4) {
        nixbpe = memory.getDataByte(++i);
        memoryAddress = memory.getDataByte(++i);
        i += 1;
      }

      instruction.initInstruction(opcode, nixbpe, r1, r2, memoryAddress);
      instruction.execInstruction(register, memory);
      i += 1;
    }
  }

  private int checkInstructionType(byte opcode) {
    if(opcode == 0x18) return 3;
		else if(opcode == 0x90) return 2;
		else if(opcode == 0x40) return 3;
		else if(opcode == 0x4) return 2;
		else if(opcode == 0x28) return 3;
		else if(opcode == 0xA0) return 2;
		else if(opcode == 0x24) return 3;
		else if(opcode == 0x9C) return 2;
		else if(opcode == 0x3C) return 3;
		else if(opcode == 0x30) return 3;
		else if(opcode == 0x34) return 3;
		else if(opcode == 0x38) return 3;
		else if(opcode == 0x48) return 3;
		else if(opcode == 0x00) return 3;
		else if(opcode == 0x68) return 3;
		else if(opcode == 0x50) return 3;
		else if(opcode == 0x08) return 3;
		else if(opcode == 0x6C) return 3;
		else if(opcode == 0x74) return 3;
		else if(opcode == 0x04) return 3;
		else if(opcode == 0x20) return 3;
		else if(opcode == 0x98) return 2;
		else if(opcode == 0x44) return 3;
		else if(opcode == 0xAC) return 2;
		else if(opcode == 0x4C) return 3;
		else if(opcode == 0xA4) return 2;
		else if(opcode == 0xA8) return 2;
		else if(opcode == 0x0C) return 3;
		else if(opcode == 0x78) return 3;
		else if(opcode == 0x54) return 3;
		else if(opcode == 0x14) return 3;
		else if(opcode == 0x7C) return 3;
		else if(opcode == 0x84) return 3;
		else if(opcode == 0x10) return 3;
		else if(opcode == 0x1C) return 3;
		else if(opcode == 0x94) return 2;
		else if(opcode == 0x2C) return 3;
		else if(opcode == 0xB8) return 2;

    return 1;
  }

  private String getRegisterName(int register) {
    if (register == 0) return "A";
    else if (register == 1) return "X";
    else if (register == 2) return "L";
    else if (register == 3) return "B";
    else if (register == 4) return "S";
    else if (register == 5) return "T";
    else if (register == 6) return "F";
    else if (register == 7) return "PC";
    else if (register == 8) return "SW";

    return "";
  }

  public int getMemory(int index) {
    return memory.getData(index);
  }
}