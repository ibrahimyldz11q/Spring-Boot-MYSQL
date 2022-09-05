package com.mysqlRecap.springMysql.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mysqlRecap.springMysql.Business.IActorService;
import com.mysqlRecap.springMysql.Entites.Actor;

@RestController
@RequestMapping("/test")
public class actorController {

	private IActorService actorService;

	@Autowired
	public actorController(IActorService actorService) {
		this.actorService = actorService;
	}
	
	
	@GetMapping("/actor")
	public List<Actor> getAll(){
	return this.actorService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Actor actor) {
		this.actorService.add(actor);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Actor actor) {
		this.actorService.update(actor);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody Actor actor) {
		this.actorService.delete(actor);
	}
	

	
}
