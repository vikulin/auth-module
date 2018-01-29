package authentication;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		String hashed = BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(12));
		return hashed;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}
	
	public static void main(String[] args){
		CustomPasswordEncoder customPasswordEncoder = new CustomPasswordEncoder();
        String encoded = customPasswordEncoder.encode("");
        System.out.println("Custom encoded "+encoded);
	}

}
