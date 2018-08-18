package demo.learn.config;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/hello").permitAll()
		.antMatchers("/home").hasRole("USER")
		.and().formLogin(); /*upto this, the security is set up, but it asks for passwordencryptor, thus we specify something encryptor" */
	
	/* What is the difference?
	 * http
                .csrf()
                    .disable()
                .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                    .httpBasic()
                .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 */
/*
	}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*BCryptPasswordEncoder encoder = passwordEncoder(); This far gives bad creds error, says provided password doesn't look like bcrypt */
		/* refer for solution:- https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-storage-updated/ 
		
		PasswordEncoder passwordEncoder =
			    PasswordEncoderFactories.createDelegatingPasswordEncoder();
		/* There is no PasswordEncoder mapped for the id "null":-
		 * https://stackoverflow.com/questions/46999940/spring-boot-passwordencoder-error
		 * We need to create user instead
		  auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user").password("pass").roles("USER");
		  OR encode pass as below	  		
		  
		  auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user").password(passwordEncoder.encode("pass")).roles("USER");
		  
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
*/