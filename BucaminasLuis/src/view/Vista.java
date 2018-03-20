package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import componentes.JButtonMina;
import logica.Minas;

public class Vista extends JFrame {

	private Integer rows;
	private Integer cols;
	private Integer numeroMinas;
	List<Coordenada> coordenadas = new ArrayList<>();
	private boolean bombaDescubierta = false;

	private void obtenerNivel() {
		this.rows = 8;// fila
		this.cols = 8;// columnas
		this.numeroMinas = 10;
		Minas minas = new Minas();// objeto
		coordenadas = minas.asignarMinas(this.rows, this.cols, this.numeroMinas);// Asignando lista de minas
	}

	public Vista() {
		setTitle("Buscaminas chingon");

		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image miIcono = miPantalla.getImage("/home/luis/eclipse-workspace/BucaminasLuis/src/imagenes/never.jpeg");
		setIconImage(miIcono);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 300);
		setLocationRelativeTo(null);
		obtenerNivel();
		configurarVista();
	}

	private boolean asignarMina(int i, int j) {
		boolean existencia = false;
		for (int x = 0; x < coordenadas.size(); x++) {
			if (coordenadas.get(x).getX() == i && coordenadas.get(x).getY() == j) {
				existencia = true;
				break;
			}
		}
		return existencia;

	}

	private void configurarVista() {// para los cuadros
		GridLayout cuadrosLayaout = new GridLayout(rows, cols);
		setLayout(cuadrosLayaout);
		// Integer minasAsignadas = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				JButtonMina bottonMina = new JButtonMina();
				// metodo para asignar minas
				bottonMina.setContieneMina(asignarMina(i, j));
				///////////////////////////////////////////////

				bottonMina.setFila(i);
				bottonMina.setColumna(j);

				bottonMina.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						JButtonMina tmp = (JButtonMina) e.getSource();
						if(!bombaDescubierta) {
							if (e.getButton() == 1) {
								if (tmp.isContieneMina()) {
									tmp.setIcon(new javax.swing.ImageIcon(
											getClass().getResource("/imagenes/if_Bomb_128399.png")));
									bombaDescubierta = true;
								}
								if (tmp.isContieneMina() == false) {
									tmp.setEnabled(false);
									
								}
							}
							if (e.getButton() == 3) {
								// if (tmp.isContieneMina()) {
								tmp.setIcon(new javax.swing.ImageIcon(getClass()
										.getResource("/imagenes/if_apocolypse_nuclear_explosion_atomic_bomb_339852.png")));
								// }
							}
							if (bombaDescubierta) {

								System.out.println("Juego Finalizado");
							}
	
						}
											}
				});
				add(bottonMina);

			}
		}
	}

	public static void main(String[] args) {
		// existencia == false

		new Vista();

		
	}
}
