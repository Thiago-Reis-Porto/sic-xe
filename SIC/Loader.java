package SIC;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.ByteBuffer;

public class Loader {
  Memory memory;
  protected void start(Memory memory, String filePath) {
    this.memory = memory;
    readInputFile(filePath);
  }

  protected void readInputFile(String filePath) {
    try {
      File inputFile = new File(filePath);
      Scanner reader = new Scanner(inputFile);

      while (reader.hasNextLine()) {
        addToMemory(reader.nextLine());
      }

      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  protected void addToMemory(String instruction) {
    String[] splitInstruction = instruction.split("(?<=\\G..)"); // split nth character

    byte[] splitInstructionBytes;
    ByteBuffer buffer;

    splitInstructionBytes = new byte[splitInstruction.length];
    buffer = ByteBuffer.wrap(splitInstructionBytes);

    for (String s : splitInstruction) {
      buffer.put((byte) Integer.parseInt(s, 16));
    }

    if (splitInstruction.length == 1) {
      memory.newInstF1(splitInstructionBytes[0]);

      return;
    }

    memory.newInstF2F3F4(splitInstructionBytes);
  };
}