package ngc;

import org.springframework.stereotype.Component;

@Component("")
public class ArepaNgcImpl implements IArepaNgc{

	@Override
	public void almacenarArepa() {
		System.out.println("Almaceno la arepa en DB Oracle");
		
	}

}
