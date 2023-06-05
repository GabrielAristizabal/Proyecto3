package pasarela;

public class PayPal {
  	private String numeroCuenta;
    private String nombrePropietario;
    private double saldo;

    public PayPal() {
        this.numeroCuenta = numeroCuenta;
        this.nombrePropietario = nombrePropietario;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void pagar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Pago exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("No hay suficiente saldo en la cuenta. Saldo actual: " + saldo);
        }
    }
}

