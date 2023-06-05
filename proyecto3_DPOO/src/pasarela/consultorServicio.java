package pasarela;

public class consultorServicio {
	PayPal paypal;
	PayU payU;
	Sire sire;
	
	public consultorServicio() {
		paypal = new PayPal();
		payU = new PayU();
		sire = new Sire();
	}
	
	public boolean pagar() {
		boolean pago = false;
		
		return pago;
	}
}
