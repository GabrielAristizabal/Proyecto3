package pasarela;

import java.io.File;

public class clientePayPal {
	private String numeroCuenta;
    private String nombrePropietario;
    private int saldo;
    private File historial;

    public clientePayPal(String numeroCuenta, String nombrePropietario, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombrePropietario = nombrePropietario;
        this.saldo = saldo;
        this.historial = new File(numeroCuenta+".log");
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
    
    public File getHistorial() {
    	return historial;
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
