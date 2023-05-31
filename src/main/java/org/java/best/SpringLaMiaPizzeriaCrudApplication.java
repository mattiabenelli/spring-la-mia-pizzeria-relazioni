package org.java.best;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.java.best.pojo.Offerta;
import org.java.best.pojo.Pizza;
import org.java.best.service.ServiceOfferta;
import org.java.best.service.ServicePizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private ServicePizza servicePizza;
	
	@Autowired
	private ServiceOfferta serviceOfferta;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		Pizza p1 = new Pizza("margherita1", "descrizione margherita", "https://staticfanpage.akamaized.net/wp-content/uploads/sites/9/2019/08/LP_8611563.jpg", 1);
		Pizza p2 = new Pizza("margherita2", "descrizione margherita", "https://staticfanpage.akamaized.net/wp-content/uploads/sites/9/2019/08/LP_8611563.jpg", 1);
		Pizza p3 = new Pizza("margherita3", "descrizione margherita", "https://staticfanpage.akamaized.net/wp-content/uploads/sites/9/2019/08/LP_8611563.jpg", 1);
		
		servicePizza.save(p1);
		servicePizza.save(p2);
		servicePizza.save(p3);
		
		Offerta o1 = new Offerta(LocalDate.of(2023, 12, 12), LocalDate.of(2023, 12, 12), "ciao", 20, p1);
		
		serviceOfferta.save(o1);
		
		List<Pizza> pizzas = servicePizza.findAll();
		System.out.println(pizzas);
		
		Optional<Pizza> optPizza = servicePizza.findByIdWithOfferte(1);
		Pizza firstPizza = optPizza.get();
		
		System.out.println(firstPizza);
		System.out.println(firstPizza.getOfferte());
		
		if (optPizza.isPresent()) {
			
			Pizza dbPizza = optPizza.get();
			
			System.out.println("Pizza con id 1");
			System.out.println("--------------");
			System.out.println(dbPizza);
		} else 
			System.out.println("Pizza con id 1 non trovato :-(");
	}
		
		
	

}
