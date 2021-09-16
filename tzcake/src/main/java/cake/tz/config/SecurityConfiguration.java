package cake.tz.config;

import cake.tz.constant.SecurityConstant;
import cake.tz.filter.JWTAuthorizationFilter;
import cake.tz.filter.JwtAccessDeniedHandler;
import cake.tz.filter.JwtAuthenticationEntryPoint;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private JWTAuthorizationFilter jwtAuthorizationFilter;
	private JwtAccessDeniedHandler jwtAccessDeniedHandler;
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public SecurityConfiguration(JWTAuthorizationFilter jwtAuthorizationFilter,
								 JwtAccessDeniedHandler jwtAccessDeniedHandler,
								 JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
								 @Qualifier("userDetailsService") UserDetailsService userDetailsService,
								 BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
		this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().authorizeRequests().antMatchers(SecurityConstant.PUBLIC_URLS).permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling().accessDeniedHandler(jwtAccessDeniedHandler)
			.authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.and()
			.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Value(value = "${auth0.apiAudience}")
//	private String apiAudience;
//	@Value(value = "${auth0.issuer}")
//	private String issuer;

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			csrf().disable().cors();
//
//		JwtWebSecurityConfigurer
//        .forRS256(apiAudience, issuer)
//        .configure(http)
//        .authorizeRequests()
//        .antMatchers(HttpMethod.POST, "/api/v1/cakes/create").hasAuthority("view:registration").antMatchers(HttpMethod.POST, "/api/v1/cakes/update").hasAuthority("view:registrations")
//        .antMatchers(HttpMethod.GET, "/api/v1/cakes").permitAll()
//        .antMatchers(HttpMethod.GET, "/api/v1/cakes/**").permitAll()
//        .anyRequest().authenticated();
//	}
}