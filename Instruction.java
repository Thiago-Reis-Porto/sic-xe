//TODO resto das instruções
import java.util.Map;

public class Instruction {
	static Map<String, Integer> r;
	static Memory m;

	public Instruction(Register r, Memory m) {
		this.r = r.getRegister();
		this.m = m;
	}

	//ADD - Soma um valor de memoria com o valor do reg A e armazena em A
	static void add(int address){
		int data = m.getData(address);
		r.replace("A", r.get("A") + data);
	}
	//ADDR - Soma dois registradores e armazena em r2
	static void addR(String r1, String r2){
		r.replace(r2, r.get(r1) +  r.get(r2));
	}
	//AND - And um valor de memoria com o valor do reg A e armazena em A
	static void and(int address) {
		int data = m.getData(address);
		r.replace("A", r.get("A") & data);
	}
	// CLEAR - Limpa um registrador
	static void clear(String r1) {
		r.replace(r1, 0);
	}

	// COMP - Compara um valor de memoria com o valor do reg A
	static int comp( int address) {
		int data = m.getData(address);
		return Integer.compare(r.get("A"), data);
	}

	// COMPR - Compara um valor de reg1 com o valor do reg 2
	static int compR(String r1, String r2) {
		return Integer.compare(r.get(r1), r.get(r2));
	}

	// DIV - Divide o valor do reg A por um valor de memoria e armazena no reg A
	static void div(int address) {
		int data = m.getData(address);
		r.replace("A", r.get("A") / data);
	}

	// DIVR - Divide o valor do reg 2 pelo do reg 2 e armazena no reg 2
	static void divR(String r1, String r2) {
		r.replace(r2, r.get(r2) / r.get(r1));
	}

	// J - Jump carrega um endereço de memoria no reg PC
	static void j(int address) {
		r.replace("PC", address);
	}

	// JEQ - Se dois valores forem Iguais carrega um endereço no PC
	static void jeq(int address, int v1, int v2) {
		if(v1 == v2)
			r.replace("PC", address);
	}

	// JGT - Se v1 for maior que v2 carrega um enderaço no PC
	static void jgt(int address, int v1, int v2) {
		if(v1 > v2)
			r.replace("PC", address);
	}

	// JLT - Se v1 for menor que v2 carrega um enderaço no PC
	static void jlt(int address, int v1, int v2) {
		if(v1 < v2)
			r.replace("PC", address);
	}

	// JSUB - armazena o valor de PC em L e passo um endereço de subrotina para PC
	static void jsub(int address) {
		r.replace("L", r.get("PC"));
		r.replace("PC", address);
	}

	//LDA - Carrega em A
	static void lda(int address) {
		int data = m.getData(address);
		r.replace("A", data);
	}

	//LDB - Carrega em B
	static void ldb(int address) {
		int data = m.getData(address);
		r.replace("B", data);
	}
	//LDCH - Carrega no byte mais signidicativo de A
	static void lch(int address) {
		byte data = m.getDataByte(address);
		r.replace("A", r.get("A")&((int)data));
	}
	//LDS - Carrega em S
	static void lds(int address) {
		int data = m.getData(address);
		r.replace("S", data);
	}

	//LDT - Carrega em T
	static void ldt(int address) {
		int data = m.getData(address);
		r.replace("T", data);
	}

	//LDX - Carrega em X
	static void ldx(int address) {
		int data = m.getData(address);
		r.replace("X", data);
	}

	//MUL - Multiplica um valor de memoria pelo reg A e armazena em A
	static void mul(int address) {
		int data = m.getData(address);
		r.replace("A", r.get("A")*data);
	}

	//MULR - Multiplica dois reg e armazena em r2
	static void mulr(String r1, String r2) {
		r.replace(r2, r.get(r1)*r.get(r2));
	}

	// OR - bitwise ou entre um valor de memoria e reg A, armazena em A
	static void or(int address) {
		int data = m.getData(address);
		r.replace("A", r.get("A") | data);
	}

	// RMO - copia conteudo do reg1 para o reg2
	static void rmo(String r1, String r2) {
		r.replace(r2, r.get(r1));
	}

	// RSUB - Carrega o conteudo de L para PC - (fim de subrotina)
	static void rsub(Register register) {
		r.replace("PC", r.get("L"));
	}

	//SHIFTL - desloca n bit a esquerda o conteudo do reg
	static void shiftl(String r1, int n) {
		r.replace(r1, r.get(r1)<<n);
	}

	//SHIFTR - desloca n bit a direita o conteudo do reg
	static void shiftr(String r1, int n) {
		r.replace(r1, r.get(r1)>>n);
	}

	// STA - armazena o valor de A em um endereço de memoria
	static void sta(int address) {
		m.setNewData(r.get("A"), address);
	}
	// STB - armazena o valor de B em um endereço de memoria
	static void stb(int address) {
		m.setNewData(r.get("B"), address);
	}
	// STCH - armazena o valor de byte de A em um endereço de memoria
	static void stch(int address) {
		m.setNewData(r.get("A")&0xFF, address);
	}
	// STL - armazena o valor de L em um endereço de memoria
	static void stl(int address) {
		m.setNewData(r.get("L"), address);
	}
	// STS - armazena o valor de S em um endereço de memoria
	static void sts(int address) {
		m.setNewData(r.get("S"), address);
	}
	// STT - armazena o valor de T em um endereço de memoria
	static void stt(int address) {
		m.setNewData(r.get("T"), address);
	}
	// STX - armazena o valor de X em um endereço de memoria
	static void stx(int address) {
		m.setNewData(r.get("X"), address);
	}
	// SUB -  armazena em A a subtração de um valor de memoria com reg A
	static void sub(int address) {
		int data = m.getData(address);
		r.replace("A", data);
	}
	// SUBR - armazena em r2 a subtação r2-r1
	static void subr(String r1, String r2) {
		r.replace(r2, r.get(r2) - r.get(r1));
	}
	// TIX - Incrementa X e compara com valor de mem
	static int tix(int address) {
		int data = m.getData(address);
		r.replace("X", r.get("X") + 1);
		return Integer.compare(r.get("X"), data);
	}

	// TIXR - Incrementa X e compara com valor de r1
	static int tix(String r1) {
		r.replace("X", r.get("X") + 1);
		return Integer.compare(r.get("X"), r.get(r1));
	}
}
