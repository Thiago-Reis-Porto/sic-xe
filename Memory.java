import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// Memoria é um array de bytes de 2 kb, com 1 kb para instruções e 1kb para dados
public class Memory {
	
	byte[] memory; // array da memoria
	ByteBuffer buffer; // buffer para facilitar o controle da memoria
	int dataPointer; // Ponteiro para dados
	int instPointer; // Ponteiro para instruções
	
	
	public Memory() {
		memory = new byte[2048]; //Memoria com 2 kb
		buffer = ByteBuffer.wrap(memory);
		buffer.order(ByteOrder.LITTLE_ENDIAN); // Ordena em little Endian
		dataPointer = 1024; // Inicio da memoria para dados
		instPointer = 0;  
	}

	protected void newInstF1(byte inst) { //Coloca instrução de formato 1 na mamoria
		if(instPointer == 1023)
			throw new ArithmeticException("Instruction Memory Full");
		buffer.put(instPointer, inst);
		instPointer ++;
	}
	
	protected void newInstF2F3F4(byte[] inst) { //Coloca instrução de formato 2,3,4 na mamoria
		for (byte b : inst) {
			buffer.put(instPointer, b);
			instPointer ++;
			if(instPointer == 1023)
				throw new ArithmeticException("Instruction Memory Full");
		}
	}
	
	protected void setNewData(int data) { // Coloca dado na memoria no proxima posição livre
		buffer.putInt(dataPointer, data);
		dataPointer += 4;
		if(dataPointer == 2048)
			throw new ArithmeticException("Data Memory Full");
	}
	
	protected void setNewData(int data, int adress) { // Coloca dado na memoria no endereço
		if ((adress > 2048) | (adress < 1024))
			throw new ArithmeticException("Invalid Adress");
		buffer.putInt(adress, data);
	}
	
	protected int getData(int adress) { // retorna dado da memoria
		return buffer.getInt(adress);
	}
	
	protected byte getDataByte(int adress) { // retorna dado(byte)da memoria
		return buffer.get(adress);
	}
	//Limpa memoria
	protected void clear() {
		buffer.clear();
	}
}
