package pasarela;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PayU {
	private clientePayU clienteActivo;
  	private HashMap<String, clientePayU> clientes;

    public PayU() throws IOException {
    	File archivoClientes = new File("/DataServicio/infoPayU.txt");
    	BufferedReader br = new BufferedReader(new FileReader(archivoClientes));
		String linea = br.readLine();
		while (linea != null) {
			String[] informacion = linea.split(";");
			String cuenta = informacion[0];
			String nombre = informacion[1];
			int saldo = Integer.parseInt(informacion[2]);
			clientePayU cliente = new clientePayU(cuenta, nombre, saldo);
			clientes.put(cuenta, cliente);
			linea = br.readLine();
		}
		br.close();
    }

    public String getNumeroCuenta() {
        return clienteActivo.getNumeroCuenta();
    }

    public String getNombrePropietario() {
        return clienteActivo.getNombrePropietario();
    }

    public double getSaldo() {
        return clienteActivo.getSaldo();
    }
    

    public boolean pagar(int monto) {
        return clienteActivo.pagar(monto);
    }
}
