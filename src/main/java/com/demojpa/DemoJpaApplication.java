package com.demojpa;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demojpa.models.Categoria;
import com.demojpa.repository.ICategoriaRepository;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner{

	@Autowired
	private ICategoriaRepository repoCategoria;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
		
	
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	//	testConexion();
	//	guardar();
	//buscarPorId();
		Modificar();
	}
	
	private void testConexion() {
		
		if(repoCategoria !=null)
		System.out.println("Conexion Exitosa "+repoCategoria);
		else
			System.out.println("Error en Conexion");
	}
	
	private void guardar() {
		Categoria categoria=new Categoria();
		categoria.setNombre("Trips en la playa");
		categoria.setDescripcion("Todo tipo de paseos en la playa");
		repoCategoria.save(categoria);
	}

	private void buscarPorId() {
		Optional<Categoria> optional =repoCategoria.findById(1);
		if (optional.isPresent())
		System.out.println(optional.get().getNombre());
		else
			System.out.println("Categoria no encontrada");
	}
	
	private void Modificar(){
		Optional<Categoria> optional = repoCategoria.findById(1);
		if (optional.isPresent()) {
			Categoria catTemp = new Categoria();
			catTemp=optional.get();
			catTemp.setNombre("Caminatas en el volcan");
			catTemp.setDescripcion("Exigentes caminatas para......");
			repoCategoria.save(catTemp);
			System.out.println(optional.get());
		}
		else 
			System.out.println("Categoria no encontrada");
		
	}
	
}
