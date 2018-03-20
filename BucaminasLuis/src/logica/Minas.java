package logica;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import view.Coordenada;

public class Minas {
	
	public List<Coordenada> asignarMinas(Integer rows, Integer cols, Integer numeroMinas) {
		SecureRandom x = new SecureRandom();
		Integer a = null;
		Integer b = null;
		List<Coordenada> lstCordenadas = new ArrayList<Coordenada>();
		for (int i = 0; i < numeroMinas;) {
			boolean existe = false;
			a = x.nextInt(rows);
			b = x.nextInt(cols);

			for (int j = 0; j < lstCordenadas.size(); j++) {

				if (lstCordenadas.get(j).getX() == a && lstCordenadas.get(j).getY() == b) {
					existe = true;
					System.out.println("Repetido[" + a + ", " + b + "]");
					break;
				}
			}
			if (!existe) {
				Coordenada tmp = new Coordenada(a, b);
				lstCordenadas.add(tmp);
				System.out.println(i + "[" + a + ", " + b + "]");
				i++;
			}
		}
		return lstCordenadas;

	}
}
