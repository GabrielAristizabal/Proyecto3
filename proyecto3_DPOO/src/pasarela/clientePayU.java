package pasarela;

import java.io.File;

public class clientePayU {
	private String numeroCuenta;
    private String nombrePropietario;
    private int saldo;
    private File historial;

    public clientePayU(String numeroCuenta, String nombrePropietario, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombrePropietario = nombrePropietario;
        this.saldo = saldo;
        this.historial = new File(numeroCuenta+".log");
    }

    public File getHistorial() {
		return historial;
	}

	public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean pagar(int monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        } else {
        	return false;
        }
    }
}
