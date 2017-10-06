package rugby;
public class Persona {

	public String Nombre;
	private int Edad;
	private float Estatura;
	private int Peso;

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public int getEdad() {
		return this.Edad;
	}

	public void setEdad(int Edad) {
		this.Edad = Edad;
	}

	public float getEstatura() {
		return this.Estatura;
	}

	public void setEstatura(float Estatura) {
		this.Estatura = Estatura;
	}

	public int getPeso() {
		return this.Peso;
	}

	public void setPeso(int Peso) {
		this.Peso = Peso;
	}

	private void Descansar() {
		// TODO - implement Persona.Descansar
		throw new UnsupportedOperationException();
	}

}