//Classe responsavel por executar uma instrução
import java.util.Map;

public class Instruction {
	
	byte opcode;
	byte nixbpe;
	String r1;
	String r2;
	int adress;
	
	public Instruction() {
		opcode = 0;
		nixbpe = 0;
		r1 = "";
		r2 = "";
	}
	
	//Inicializa uma nova Instrução
	protected void initInstruction(byte opcode,	byte nixbpe, String r1, String r2, int adress) {
		this.opcode = opcode;
		this.nixbpe = nixbpe;
		this.r1 = r1;
		this.r2 = r2;
		this.adress = adress;
	}
	
	//Executa Instrução
	protected void execInstruction(Map<String, Integer> r, Memory m) {
		
		adressCalc(r);
		
		if(opcode == 0x18) add(r, m);
		
		else if(opcode == 0x90) addR(r);
		
		else if(opcode == 0x40) and(r, m);
		
		else if(opcode == 0x4) clear(r);
		
		else if(opcode == 0x28) comp(r, m);
		
		else if(opcode == 0xA0) compR(r);
		
		else if(opcode == 0x24) div(r, m);
		
		else if(opcode == 0x9C) divR(r);
		
		else if(opcode == 0x3C) j(r);
		
		else if(opcode == 0x30) jeq(r);
		
		else if(opcode == 0x34) jgt(r);
		
		else if(opcode == 0x38) jlt(r);
		
		else if(opcode == 0x48) jsub(r);
		
		else if(opcode == 0x00) lda(r, m);
		
		else if(opcode == 0x68) ldb(r, m);
		
		else if(opcode == 0x50) ldch(r, m);
		
		else if(opcode == 0x08) ldl(r, m);
		
		else if(opcode == 0x6C) lds(r, m);
		
		else if(opcode == 0x74) ldt(r, m);
		
		else if(opcode == 0x04) ldx(r, m);
		
		else if(opcode == 0x20) mul(r, m);
		
		else if(opcode == 0x98) mulr(r);
		
		else if(opcode == 0x44) or(r, m);
		
		else if(opcode == 0xAC) rmo(r);
		
		else if(opcode == 0x4C) rsub(r);
		
		else if(opcode == 0xA4) shiftl(r);
		
		else if(opcode == 0xA8) shiftr(r);
		
		else if(opcode == 0x0C) sta(r, m);
		
		else if(opcode == 0x78) stb(r, m);
		
		else if(opcode == 0x54) stch(r, m);
		
		else if(opcode == 0x14) stl(r, m);
		
		else if(opcode == 0x7C) sts(r, m);
		
		else if(opcode == 0x84) stt(r, m);
		
		else if(opcode == 0x10) stx(r, m);
		
		else if(opcode == 0x1C) sub(r, m);
		
		else if(opcode == 0x94) subr(r);
		
		else if(opcode == 0x2C) tix(r, m);
		
		else if(opcode == 0xB8) tixr(r);
		
	}
	
	//------------------------------------------------------------------------------------------------------
	//-----------------------------------Utilitarios--------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	
	private void adressCalc(Map<String, Integer> r) {
		
		//Endereçamento Direto
		if(nixbpe == 50) // 110010
			adress = r.get("PC") + (~adress + 1);
		
		if(nixbpe == 52) // 110100
			adress = r.get("B") + adress;
		
		if((nixbpe == 56) || (nixbpe == 57)) // 111000 e //111001 
			adress = r.get("X") + adress;
		
		if(nixbpe == 58) // 111010
			adress = r.get("X") + r.get("PC");
		
		if(nixbpe == 60) // 111100 
			adress = r.get("X") + r.get("B");
		
		if(nixbpe == 8) // 001000 
			adress = r.get("X") + adress;
		
	}
	
	
	//------------------------------------------------------------------------------------------------------
	//---------------------------------METODOS DAS INSTRUÇÕES-----------------------------------------------
	//------------------------------------------------------------------------------------------------------
		
	//ADD - Soma um valor de memoria com o valor do reg A e armazena em A
	private void add(Map<String, Integer> r, Memory m){
		int data = m.getData(adress);	
		r.replace("A", r.get("A") + data);
	}
	
	//------------------------------------------------------------------------------------------------------
	
	//ADDR - Soma dois registradores e armazena em r2
	private void addR(Map<String, Integer> r){
		r.replace(r2, r.get(r1) +  r.get(r2));
	}

	//------------------------------------------------------------------------------------------------------
	
	//AND - And um valor de memoria com o valor do reg A e armazena em A
	private void and(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("A", r.get("A") & data);
	}
	
	//------------------------------------------------------------------------------------------------------	

	// CLEAR - Limpa um registrador
	private void clear(Map<String, Integer> r) {
		r.replace(r1, 0);
	}
	
	//------------------------------------------------------------------------------------------------------

	// COMP - Compara um valor de memoria com o valor do reg A
	private int comp(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		return Integer.compare(r.get("A"), data);
	}

	//------------------------------------------------------------------------------------------------------

	// COMPR - Compara um valor de reg1 com o valor do reg 2
	private int compR(Map<String, Integer> r) {
		return Integer.compare(r.get(r1), r.get(r2));
	}
	
	//------------------------------------------------------------------------------------------------------

	// DIV - Divide o valor do reg A por um valor de memoria e armazena no reg A
	private void div(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("A", r.get("A") / data);
	}
	
	//------------------------------------------------------------------------------------------------------

	// DIVR - Divide o valor do reg 2 pelo do reg 2 e armazena no reg 2
	private void divR(Map<String, Integer> r) {
		r.replace(r2, r.get(r2) / r.get(r1));
	}
	
	//------------------------------------------------------------------------------------------------------

	// J - Jump carrega um endereço de memoria no reg PC
	private void j(Map<String, Integer> r) {
		r.replace("PC", adress);
	}
	
	//------------------------------------------------------------------------------------------------------

	// JEQ - Se dois valores forem Iguais carrega um endereço no PC
	private void jeq(Map<String, Integer> r) {
		if(r.get(r1) == r.get(r2))
			r.replace("PC", adress);
	}
	
	//------------------------------------------------------------------------------------------------------

	// JGT - Se v1 for maior que v2 carrega um enderaço no PC
	private void jgt(Map<String, Integer> r) {
		if(r.get(r1) > r.get(r2))
			r.replace("PC", adress);
	}
	
	//------------------------------------------------------------------------------------------------------

	// JLT - Se v1 for menor que v2 carrega um enderaço no PC
	private void jlt(Map<String, Integer> r) {
		if(r.get(r1) < r.get(r2))
			r.replace("PC", adress);
	}
	
	//------------------------------------------------------------------------------------------------------

	// JSUB - armazena o valor de PC em L e passo um endereço de subrotina para PC
	private void jsub(Map<String, Integer> r) {
		r.replace("L", r.get("PC"));
		r.replace("PC", adress);
	}
	
	//------------------------------------------------------------------------------------------------------	

	//LDA - Carrega em A
	private void lda(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("A", data);
	}
	
	//------------------------------------------------------------------------------------------------------	

	//LDB - Carrega em B
	private void ldb(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("B", data);
	}
	//------------------------------------------------------------------------------------------------------

	//LDCH - Carrega no byte mais signidicativo de A
	private void ldch(Map<String, Integer> r, Memory m) {
		byte data = m.getDataByte(adress);
		r.replace("A", r.get("A")&((int)data));
	}
	
	//------------------------------------------------------------------------------------------------------	

	//LDL - Carrega em L
	private void ldl(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("L", data);
	}	
	
	//------------------------------------------------------------------------------------------------------
	
	//LDS - Carrega em S
	private void lds(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("S", data);
	}	
	
	//------------------------------------------------------------------------------------------------------

	//LDT - Carrega em T
	private void ldt(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("T", data);
	}
	
	//------------------------------------------------------------------------------------------------------

	//LDX - Carrega em X
	private void ldx(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("X", data);
	}
	
	//------------------------------------------------------------------------------------------------------

	//MUL - Multiplica um valor de memoria pelo reg A e armazena em A
	private void mul(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("A", r.get("A")*data);
	}
	
	//------------------------------------------------------------------------------------------------------

	//MULR - Multiplica dois reg e armazena em r2
	private void mulr(Map<String, Integer> r) {
		r.replace(r2, r.get(r1)*r.get(r2));
	}
	
	//------------------------------------------------------------------------------------------------------

	// OR - bitwise ou entre um valor de memoria e reg A, armazena em A
	private void or(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("A", r.get("A") | data);
	}
	
	//------------------------------------------------------------------------------------------------------

	// RMO - copia conteudo do reg1 para o reg2
	private void rmo(Map<String, Integer> r) {
		r.replace(r2, r.get(r1));
	}
	
	//------------------------------------------------------------------------------------------------------

	// RSUB - Carrega o conteudo de L para PC - (fim de subrotina)
	private void rsub(Map<String, Integer> r) {
		r.replace("PC", r.get("L"));
	}
	
	//------------------------------------------------------------------------------------------------------

	//SHIFTL - desloca n bit a esquerda o conteudo do reg
	private void shiftl(Map<String, Integer> r) {
		r.replace(r1, r.get(r1)<<r.get(r2));
	}
	
	//------------------------------------------------------------------------------------------------------

	//SHIFTR - desloca n bit a direita o conteudo do reg
	private void shiftr(Map<String, Integer> r) {
		r.replace(r1, r.get(r1)>>r.get(r2));
	}
	
	//------------------------------------------------------------------------------------------------------	

	// STA - armazena o valor de A em um endereço de memoria
	private void sta(Map<String, Integer> r, Memory m) {
		m.setNewData(r.get("A"), adress);
	}

	//------------------------------------------------------------------------------------------------------	
	
	// STB - armazena o valor de B em um endereço de memoria
	private void stb(Map<String, Integer> r, Memory m) {
		m.setNewData(r.get("B"), adress);
	}
	
	//------------------------------------------------------------------------------------------------------

	// STCH - armazena o valor de byte de A em um endereço de memoria
	private void stch(Map<String, Integer> r, Memory m) {
		m.setNewData(r.get("A")&0xFF, adress);
	}
	
	//------------------------------------------------------------------------------------------------------
	
	// STL - armazena o valor de L em um endereço de memoria
	private void stl(Map<String, Integer> r, Memory m) {
		m.setNewData(r.get("L"), adress);
	}	

	//------------------------------------------------------------------------------------------------------

	// STS - armazena o valor de S em um endereço de memoria
	private void sts(Map<String, Integer> r, Memory m) {
		m.setNewData(r.get("S"), adress);
	}	

	//------------------------------------------------------------------------------------------------------	
	
	// STT - armazena o valor de T em um endereço de memoria
	private void stt(Map<String, Integer> r, Memory m) {
		m.setNewData(r.get("T"), adress);
	}

	//------------------------------------------------------------------------------------------------------

	// STX - armazena o valor de X em um endereço de memoria
	private void stx(Map<String, Integer> r, Memory m) {
		m.setNewData(r.get("X"), adress);
	}

	//------------------------------------------------------------------------------------------------------
	
	// SUB -  armazena em A a subtração de um valor de memoria com reg A
	private void sub(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("A", data);
	}

	//------------------------------------------------------------------------------------------------------	
	
	// SUBR - armazena em r2 a subtação r2-r1
	private void subr(Map<String, Integer> r) {
		r.replace(r2, r.get(r2) - r.get(r1));
	}
	
	//------------------------------------------------------------------------------------------------------
	
	// TIX - Incrementa X e compara com valor de mem
	private int tix(Map<String, Integer> r, Memory m) {
		int data = m.getData(adress);
		r.replace("X", r.get("X") + 1);
		return Integer.compare(r.get("X"), data);
	}
	
	//------------------------------------------------------------------------------------------------------

	// TIXR - Incrementa X e compara com valor de r1
	private int tixr(Map<String, Integer> r) {
		r.replace("X", r.get("X") + 1);
		return Integer.compare(r.get("X"), r.get(r1));
	}
	
	//------------------------------------------------------------------------------------------------------
}
