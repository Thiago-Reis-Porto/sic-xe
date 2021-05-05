//TODO resto das instruções
import java.util.Map;

public class Instruction {
	
	public Instruction() {
		
	}
	//ADD - Soma um valor de memoria com o valor do reg A e armazena em A
	static void add(Map<String, Integer> r, Memory m, int adress){
		int data = m.getData(adress);	
		r.replace("A", r.get("A") + data);
	}
	//ADDR - Soma dois registradores e armazena em r2
	static void addR(Map<String, Integer> r, String r1, String r2){
		r.replace(r2, r.get(r1) +  r.get(r2));
	}
	//AND - And um valor de memoria com o valor do reg A e armazena em A
	static void and(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("A", r.get("A") & data);
	}
	// CLEAR - Limpa um registrador
	static void clear(Map<String, Integer> r, String r1) {
		r.replace(r1, 0);
	}
	
	// COMP - Compara um valor de memoria com o valor do reg A
	static int comp(Map<String, Integer> r, Memory m,  int adress) {
		int data = m.getData(adress);
		return Integer.compare(r.get("A"), data);
	}
	
	// COMPR - Compara um valor de reg1 com o valor do reg 2
	static int compR(Map<String, Integer> r, String r1, String r2) {
		return Integer.compare(r.get(r1), r.get(r2));
	}
	
	// DIV - Divide o valor do reg A por um valor de memoria e armazena no reg A
	static void div(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("A", r.get("A") / data);
	}
	
	// DIVR - Divide o valor do reg 2 pelo do reg 2 e armazena no reg 2
	static void divR(Map<String, Integer> r, String r1, String r2) {
		r.replace(r2, r.get(r2) / r.get(r1));
	}
	
	// J - Jump carrega um endereço de memoria no reg PC
	static void j(Map<String, Integer> r, int adress) {
		r.replace("PC", adress);
	}
	
	// JEQ - Se dois valores forem Iguais carrega um endereço no PC
	static void jeq(Map<String, Integer> r, int adress, int v1, int v2) {
		if(v1 == v2)
			r.replace("PC", adress);
	}
	
	// JGT - Se v1 for maior que v2 carrega um enderaço no PC
	static void jgt(Map<String, Integer> r, int adress, int v1, int v2) {
		if(v1 > v2)
			r.replace("PC", adress);
	}
	
	// JLT - Se v1 for menor que v2 carrega um enderaço no PC
	static void jlt(Map<String, Integer> r, int adress, int v1, int v2) {
		if(v1 < v2)
			r.replace("PC", adress);
	}
	
	// JSUB - armazena o valor de PC em L e passo um endereço de subrotina para PC
	static void jsub(Map<String, Integer> r, int adress) {
		r.replace("L", r.get("PC"));
		r.replace("PC", adress);
	}
	
	//LDA - Carrega em A
	static void lda(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("A", data);
	}
	
	//LDB - Carrega em B
	static void ldb(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("B", data);
	}
	//LDCH - Carrega no byte mais signidicativo de A
	static void lch(Map<String, Integer> r, Memory m, int adress) {
		byte data = m.getDataByte(adress);
		r.replace("A", r.get("A")&((int)data));
	}	
	//LDS - Carrega em S
	static void lds(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("S", data);
	}	
	
	//LDT - Carrega em T
	static void ldt(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("T", data);
	}	
	
	//LDX - Carrega em X
	static void ldx(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("X", data);
	}	

	//MUL - Multiplica um valor de memoria pelo reg A e armazena em A
	static void mul(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("A", r.get("A")*data);
	}
	
	//MULR - Multiplica dois reg e armazena em r2
	static void mulr(Map<String, Integer> r, String r1, String r2) {
		r.replace(r2, r.get(r1)*r.get(r2));
	}
	
	// OR - bitwise ou entre um valor de memoria e reg A, armazena em A
	static void or(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("A", r.get("A") | data);
	}	
	
	// RMO - copia conteudo do reg1 para o reg2
	static void rmo(Map<String, Integer> r, String r1, String r2) {
		r.replace(r2, r.get(r1));
	}
	
	// RSUB - Carrega o conteudo de L para PC - (fim de subrotina)
	static void rsub(Map<String, Integer> r) {
		r.replace("PC", r.get("L"));
	}
	
	//SHIFTL - desloca n bit a esquerda o conteudo do reg
	static void shiftl(Map<String, Integer> r, String r1, int n) {
		r.replace(r1, r.get(r1)<<n);
	}
	
	//SHIFTR - desloca n bit a direita o conteudo do reg
	static void shiftr(Map<String, Integer> r, String r1, int n) {
		r.replace(r1, r.get(r1)>>n);
	}
	
	// STA - armazena o valor de A em um endereço de memoria
	static void sta(Map<String, Integer> r, Memory m, int adress) {
		m.setNewData(r.get("A"), adress);
	}
	// STB - armazena o valor de B em um endereço de memoria
	static void stb(Map<String, Integer> r, Memory m, int adress) {
		m.setNewData(r.get("B"), adress);
	}
	// STCH - armazena o valor de byte de A em um endereço de memoria
	static void stch(Map<String, Integer> r, Memory m, int adress) {
		m.setNewData(r.get("A")&0xFF, adress);
	}
	// STL - armazena o valor de L em um endereço de memoria
	static void stl(Map<String, Integer> r, Memory m, int adress) {
		m.setNewData(r.get("L"), adress);
	}	
	// STS - armazena o valor de S em um endereço de memoria
	static void sts(Map<String, Integer> r, Memory m, int adress) {
		m.setNewData(r.get("S"), adress);
	}	
	// STT - armazena o valor de T em um endereço de memoria
	static void stt(Map<String, Integer> r, Memory m, int adress) {
		m.setNewData(r.get("T"), adress);
	}
	// STX - armazena o valor de X em um endereço de memoria
	static void stx(Map<String, Integer> r, Memory m, int adress) {
		m.setNewData(r.get("X"), adress);
	}
	// SUB -  armazena em A a subtração de um valor de memoria com reg A
	static void sub(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("A", data);
	}
	// SUBR - armazena em r2 a subtação r2-r1
	static void subr(Map<String, Integer> r, String r1, String r2) {
		r.replace(r2, r.get(r2) - r.get(r1));
	}
	// TIX - Incrementa X e compara com valor de mem
	static int tix(Map<String, Integer> r, Memory m, int adress) {
		int data = m.getData(adress);
		r.replace("X", r.get("X") + 1);
		return Integer.compare(r.get("X"), data);
	}
	
	// TIXR - Incrementa X e compara com valor de r1
	static int tix(Map<String, Integer> r, String r1) {
		r.replace("X", r.get("X") + 1);
		return Integer.compare(r.get("X"), r.get(r1));
	}
}
