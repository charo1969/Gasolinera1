package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RepostajeTest {

	@Test
	void getPrecioLitroDescuentoTest() {
		
		Repostaje r = new Repostaje("","","",new Combustible("Gasolina", 1.794),
				30,false,false,false);
				
		assertEquals(1.794,r.getPrecioLitroDescuento());
		
		r.setAgrario(true);
		assertEquals(1.794-0.45,r.getPrecioLitroDescuento());
		
		r.setbGobierno(true);
		assertEquals(1.794-0.45,r.getPrecioLitroDescuento());
		
		r.setSiVuelves(true);
		assertEquals(1.794-0.45,r.getPrecioLitroDescuento());
		
		r.setAgrario(false);
		assertEquals(1.794-0.2-0.05,r.getPrecioLitroDescuento());
		
		r.setSiVuelves(false);
		assertEquals(1.794-0.20,r.getPrecioLitroDescuento());
		r.setSiVuelves(true);
		r.setbGobierno(false);
		assertEquals(1.794-0.05,r.getPrecioLitroDescuento());
		
		
	}
	@Test
	void setTotalTest() {
		Repostaje r = new Repostaje("","","",new Combustible("Gasolina", 1.794),
				30,true,false,false);
		
		r.setTotal(50);
		assertAll(
				()-> assertEquals(50, r.getTotal(),
						"El importe total debe seguir siendo 50"),
				()-> assertEquals(50/r.getPrecioLitroDescuento(),
						r.getLitros(),
						"El número de litros no corresponde a 50 € con descuento")
			
		);
			
	
	}

}
