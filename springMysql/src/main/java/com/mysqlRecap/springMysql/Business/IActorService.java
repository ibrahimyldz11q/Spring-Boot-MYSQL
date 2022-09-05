package com.mysqlRecap.springMysql.Business;

import java.util.List;

import com.mysqlRecap.springMysql.Entites.Actor;

public interface IActorService {

	List<Actor> getAll();
	void add(Actor actor);
	void delete(Actor actor);
	void update(Actor actor);
	
}
