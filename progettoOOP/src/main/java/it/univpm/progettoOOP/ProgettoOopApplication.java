package it.univpm.progettoOOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Classe per l'avvio della API
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 * @version 1.0
 */
@SpringBootApplication
public class ProgettoOopApplication {
	
	/**
	 * Metodo che avvia l'esecuzione del programma
	 * @param args Argomenti del main
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProgettoOopApplication.class, args);
	}
}
