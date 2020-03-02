package uk.co.nbrown.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource; // find the data source from the database
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	  auth.jdbcAuthentication().dataSource(dataSource)
	  	.passwordEncoder(NoOpPasswordEncoder.getInstance())
	  	.usersByUsernameQuery( "select username, password, enabled from USERS where username=?" )
		.authoritiesByUsernameQuery( "select username, role from USER_ROLES where username=?" );
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http	
        		.csrf()
        		 	.and()
                .authorizeRequests()
                    .antMatchers("/", "/home", "/basket", "/productPage/**", "/addProductToBasket/**",
                    		"/removeProductFromBasket", "/login", "/loggedout")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                	.loginPage("/login")
          		  	.failureUrl("/login?error")
          		  	.defaultSuccessUrl("/loggedin", true)
          		  	.usernameParameter("username").passwordParameter("password")
          		  	.and()
      		  	.logout()
      		  		.logoutUrl("/logout")
      		  		.logoutSuccessUrl("/loggedout")
	      		  	.deleteCookies("remove")
	                .invalidateHttpSession(true)
      		  		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**", "/templates/**", "/css/**", "/img/**", "/js/**");
    }
}