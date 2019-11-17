package com.udemy.pontointeligente.api.security.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
	
	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_ROLE = "role";
	static final String CLAIM_KEY_CREATED = "created";

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	/**
	 * Obtem o username (email) contido no token JWT
	 * 
	 * @param token
	 * @return String
	 */
	public String getUserNameFromToken(String token) {

		String userName;

		try {

			Claims claims = this.getClaimsFromToken(token);
			userName = claims.getSubject();

		}catch (Exception e) {
			userName = null;
		}

		return userName;
	}
	
	/**
	 * Retorna a data de expiração de um token JWT
	 * 
	 * @param token
	 * @return Date
	 */
	public Date getExpirationDateFromToken(String token) {
		
		Date expiration;
		
		try {
			
			Claims claims = this.getClaimsFromToken(token);
			expiration = claims.getExpiration(); 
		}catch (Exception e) {
			expiration = null;
		}
		
		return expiration;
	}
	
	/**
	 * Cria um novo token (refresh)
	 * 
	 * @param token
	 * @return String
	 */
	public String refreshToken(String token) {

		String refreshedToken;

		try {
			
			Claims claims = this.getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = this.gerarToken(claims);

		}catch (Exception e) {
			refreshedToken = null;
		}
		
		return refreshedToken;
	}
	
	/**
	 * Verifica e retorna se um token JWT é válido
	 * @param token
	 * @return boolean
	 */
	public boolean tokenValido(String token) {
		
		return !this.tokenExpirado(token);
		
	}
	
	/**
	 * Retorna um novo token JWT com base nos dados do usuário
	 * 
	 * @param userDetails
	 * @return String
	 */
	public String obterToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		
		userDetails.getAuthorities().forEach(
				authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority())
		);
		
		claims.put(CLAIM_KEY_CREATED, new Date());
		
		return this.gerarToken(claims);
	}		

	private Claims getClaimsFromToken(String token) {

		Claims claims;

		try {

			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

		} catch(Exception e) {
			claims = null;
		}

		return claims;		
	}

	/**
	 * Retorna a data de expiração com base na data atual
	 * 
	 * @return Date
	 */
	private Date gerarDataExpiracao() {		
		return new Date(System.currentTimeMillis() + expiration * 1000);		
	}

	/**
	 * Verifica se um token JTW está expirado
	 * @param token
	 * @return boolean
	 */
	private boolean tokenExpirado(String token) {
		
		Date dataExpiracao = this.getExpirationDateFromToken(token);
		if (dataExpiracao == null) {
			return false;
		}
		
		return dataExpiracao.before(new Date());
	}
	
	/**
	 * Gera um novo token JWT contendo os dados (claims) fornecidos.
	 * 
	 * @param claims
	 * @return String
	 */
	private String gerarToken(Map<String, Object> claims) {		
		return Jwts.builder().setClaims(claims).setExpiration(this.gerarDataExpiracao())
				.signWith(SignatureAlgorithm.HS512, secret).compact();		
	}
}