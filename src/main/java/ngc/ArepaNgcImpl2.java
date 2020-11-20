package ngc;

import org.springframework.stereotype.Component;

@Component("arepaUser")
public class ArepaNgcImpl2 implements IArepaNgc {

	@Override
	public void almacenarArepa() {
		System.out.println("Almaceno la arepa en DB Mongo");
		

	}

}
