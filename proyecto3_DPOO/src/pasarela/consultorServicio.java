package pasarela;

import java.io.IOException;

public class consultorServicio {
	PayPal paypal;
	PayU payU;
	Sire sire;
	
	public consultorServicio() throws IOException {
		paypal = new PayPal();
		payU = new PayU();
		sire = new Sire();
	}
	
	public boolean pagar(String cuenta, int monto, String pasarela) {
		boolean pago = false;
		if(pasarela.equals("PayPal")) {
			pago = paypal.pagar(monto);
		}else if(pasarela.equals("PayU")) {
			pago = payU.pagar(monto);
		}else if(pasarela.equals("Sire")) {
			pago = sire.pagar(monto);
		}
		return pago;
	}
}
