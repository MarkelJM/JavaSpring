package com.example.app1;

import com.example.app1.entities.Client;
import com.example.app1.services.Service1;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App1Application {
	/*
	@Autowired
	@Qualifier( "name")
	private  String name;
	*/


	public static void main(String[] args) {
		var context = SpringApplication.run(App1Application.class, args);
		//final var c1 = new Client();
		//c1.getId();

		//USANDO @Beans EN DISTINTOS SITUACIONES
		//var app = context.getBean(App1Application.class);
		//final var name = context.getBean("nombre");
		//System.out.println(name);
		//final var s1 = context.getBean(Service1.class);
		//System.out.println(s1.algo());
		//final var s2 = context.getBean(Service1.class);
		//System.out.println(s2.algo());

		//ejemplo de consultas basicas


	}

	//EJEMPLO BEANS
	/* los @Bean y @Autowired se conectan con nombre y/o tipo de dato(si solo hay uno de ese tipo de dato)*/
	@Bean("nombre")
	//@Qualifier("nombre") -> con @Bean es suficiente para la creacion de la relacion
	public String name(){
		return "Markel";
	}



}
