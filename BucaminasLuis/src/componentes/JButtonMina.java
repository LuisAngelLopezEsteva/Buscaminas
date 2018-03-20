package componentes;

import javax.swing.JButton;

public class JButtonMina extends JButton{
	// ESTADOS
	private String icono;
	private boolean contieneMina;
	private Integer fila;
	private Integer columna;

	public JButtonMina(String text) {
		super(text);
	}
	public JButtonMina() {
		
	}
	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public boolean isContieneMina() {
		return contieneMina;
	}

	public void setContieneMina(boolean contieneMina) {
		this.contieneMina = contieneMina;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public Integer getColumna() {
		return columna;
	}

	public void setColumna(Integer columna) {
		this.columna = columna;
	}

}
