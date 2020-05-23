package com.qintess.ingresso.rest.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.ingresso.entity.CasaDeShow;
import com.qintess.ingresso.repository.CasaDeShowRepository;

@RestController
@RequestMapping("/api")
public class CasaController {
	
	@Autowired
	private CasaDeShowRepository casaRepos;
	
	
	@GetMapping("/casa")
	public List<CasaDeShow> getClientes(){
	   return casaRepos.findAll();
	}
	
	@GetMapping("/casa/{id}")
	public ResponseEntity<CasaDeShow> getCasaId(@PathVariable(name = "id") int id) throws Exception {
		
		
		try {
			CasaDeShow casa = casaRepos.findById(id);
			
			if (casa == null) {
				throw new Exception("Nao existe essa Casa de Show com id: " + id);
			} else {
				return ResponseEntity.ok(casa);
			}
		} catch (NoSuchElementException e) {
			throw new Exception("Nao existe essa Casa de Show com id: " + id);

		}

	}
	
	
	@PostMapping("/casa")
	public CasaDeShow postCasa(@RequestBody CasaDeShow casa) {
		
		return casaRepos.save(casa);
	}
	
	@DeleteMapping("/casa/{id}")
	public ResponseEntity<String> deleteCasa(@PathVariable(name = "id") int id) {
		
		casaRepos.deleteById(id);
		
		return ResponseEntity.ok("Deletado Casa de Show com sucesso");
	}	
	
	@PutMapping("/casa/{id}")	
	public ResponseEntity<String> putCasa(@PathVariable(name = "id") int id,
								@RequestBody CasaDeShow casa) {
		
		casaRepos.findById(id);
		casaRepos.save(casa);
		
		return ResponseEntity.ok("Atualizado Casa de Show com sucesso");
	
	}

}
