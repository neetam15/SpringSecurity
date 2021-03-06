package demo.learn.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class JDBCAuthSecurityConfig extends WebSecurityConfigurerAdapter{

	  @Autowired
	  private DataSource dataSource;
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception{
		  http.authorizeRequests()
			.antMatchers("/hello").permitAll()
			.antMatchers("/home").hasRole("USER")
			.antMatchers("/adminPg").hasRole("ADMIN")
			.and()
			//.httpBasic();
			.formLogin();
	  }
	  
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception
	  {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, enabled"
	            + " from users where username=?")
		.authoritiesByUsernameQuery("select username, authority "
	            + "from authorities where username=?")
		.passwordEncoder(new BCryptPasswordEncoder());
		
		
	  }
}
