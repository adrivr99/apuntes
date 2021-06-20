package dominolista;

import java.util.Random;

public class FichaDomino {
	private int superior, inferior;
        
	static Random aleatorio = new Random();
        
        
        public static FichaDomino copiar(FichaDomino origen){
            FichaDomino destino = new FichaDomino(origen.superior, origen.inferior);
            
            return destino;
        }
        
        // Constructor copia
        
        public FichaDomino (FichaDomino objeto){
       
            // Llamada al constructor de la propia clase usando
            // this()
            // Si se usa este constructor siempre debe llamarse
            // en la primera línea del constructor copia
            this(objeto.superior, objeto.inferior);
//            this.superior = objeto.superior;
//            this.inferior = objeto.inferior;
        }

	public FichaDomino(int superior, int inferior) {
		
		
		//Hacemos un método para simplificar esta parte del código.
//		if(superior < 0 || superior > 6) {
//			if((superior % 2) == 0) {
//				this.superior = 6;
//			}else {
//				this.superior = 5;
//			}
//		}
//		
//		if(inferior < 0 || inferior > 6) {
//			if((inferior % 2) == 0) {
//				this.inferior = 6;
//			}else {
//				this.inferior = 5;
//			}
//		}
		
		this.superior = pasoLimites(superior);
		this.inferior = pasoLimites(inferior);
	}
	
	//Método para simplificar código y evitar repeticiones (Se encarga de comprobar los valores límites y poner las
	//restricciones que pone el enunciado
	private int pasoLimites(int posible) {
		if(posible < 0 || posible > 6) {
			if((posible % 2) == 0) {
				return 6;
			}else {
				return 5;
			}
			
		}
		return posible;
	}

	//Constructor por defecto
	public FichaDomino() {
		//super();
		//Al no poner nada dentro del constructor, se asume que pone valores por defectos, en este caso el valor
		//por defecto para los enteros es 0, lo que equivale a la ficha blanca
	}

	//Getters y Setters
	public int getSuperior() {
		return superior;
	}

	public void setSuperior(int superior) {
            this.superior = superior;
            if(superior < 0 || superior > 6) {
			if((superior % 2) == 0) {
                                this.superior = 6;
			}else {
				this.superior = 5;
			}
		}
		//this.superior = pasoLimites(superior);
	}

	public int getInferior() {
		return inferior;
	}

	public void setInferior(int inferior) {
		this.inferior = pasoLimites(inferior);
	}

	//Método toString
	@Override
	public String toString() {
//		if(inferior == 0 && superior == 0) {
//			return "[ | ]";
//		}else if(inferior == 0) {
//			return "[" + superior + "| ]";
//		}else if(superior == 0) {
//			return "[ |" + inferior + "]";
//		}
//		return "[" + superior + "|" + inferior + "]";
                
                String cadena="";
                switch (this.superior){
                    case 0:
                        cadena = "[  | ";
                        break;
                    default:
                        cadena = "[" + this.superior +" | ";
                        break;
                }
                
                
                switch (this.inferior){
                    case 0:
                        cadena += " ]";
                        break;
                    default:
                        cadena += this.inferior + "]";
                        break;
                }
                
                return cadena;
                
	}
	
	//Método que devuelve el valor de la suma de ambos números representados
	public byte getValorTotal() {
		return (byte) (superior + inferior);
	}
	
	//Método que genera fichas aleatorias
	public static FichaDomino generaFichaAleatoria() {
		//No hace falta que limitemos valores ya que el constructor lo hace solo
		int sup = aleatorio.nextInt(7);
		int inf = aleatorio.nextInt(7);
		
		FichaDomino ficha = new FichaDomino(sup, inf);
		return ficha;
	}
	
}
