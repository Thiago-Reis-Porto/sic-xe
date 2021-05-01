//TODO resto das instruções
import java.util.Map;

public class Instructions {
	
	public Instructions() {
		
	}
	//ADD - Soma um valor de memoria com o valor do reg A e armazena em A
	static void add(Map<String, Integer> r, int memValue){
			r.replace("A", r.get("A") + memValue);
	}
	//ADDR - Soma dois registradores e armazena em r2
	static void addR(Map<String, Integer> r, String r1, String r2){
		r.replace(r2, r.get(r1) +  r.get(r2));
	}
	//AND - And um valor de memoria com o valor do reg A e armazena em A
	static void and(Map<String, Integer> r, int memValue) {
		r.replace("A", r.get("A") & memValue);
	}
	// Clear - Limpa um registrador
	static void clear(Map<String, Integer> r, String r1) {
		r.replace(r1, 0);
	}
	
	// Comp - Compara um valor de memoria com o valor do reg A
	static int comp(Map<String, Integer> r,  int memValue) {
		return Integer.compare(r.get("A"), memValue);
	}
	
}
