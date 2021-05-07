// Responsável por ler o código objeto (linha a linha), armazenar a instrucao na memoria e chamar a funcao que executa a operacao.
// TODO: executar todo o codigo objeto se der tempo

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Loader {
  Memory memory;

  public Loader(Memory memory) {
    this.memory = memory;
  }

  protected void readInputFile() {
    String inputFileName = "input";

    try {
      File inputFile = new File(inputFileName);
      Scanner reader = new Scanner(inputFile);

      while (reader.hasNextLine()) {
        addToMemory(reader.nextLine());
      }

      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error reading file");
      e.printStackTrace();
    }
  }

  protected void addToMemory(String instruction) {
    String[] splitInstruction = instruction.split("(?<=\\G..)"); // split nth character

    // ['14', '01', '00'] -> [20, 1, 0]
    byte[] splitInstructionBytes;
    ByteBuffer buffer;

    splitInstructionBytes = new byte[splitInstruction.length * 4];
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