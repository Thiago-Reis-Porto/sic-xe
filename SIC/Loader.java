package SIC;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.ByteBuffer;

public class Loader {
  protected void start(Memory memory) {
    readInputFile(memory);
  }

  protected void readInputFile(Memory memory) {
    String inputFileName = "./SIC/input";

    try {
      File inputFile = new File(inputFileName);
      Scanner reader = new Scanner(inputFile);

      while (reader.hasNextLine()) {
        addToMemory(memory, reader.nextLine());
      }

      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error reading file");
      e.printStackTrace();
    }
  }

  protected void addToMemory(Memory memory, String instruction) {
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