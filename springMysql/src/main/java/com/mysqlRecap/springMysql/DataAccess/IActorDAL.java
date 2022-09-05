package com.mysqlRecap.springMysql.DataAccess;

import java.util.List;

import com.mysqlRecap.springMysql.Entites.Actor;

public interface IActorDAL {
	List<Actor> getAll();
	void add(Actor actor);
	void delete(Actor actor);
	void update(Actor actor);
	Actor getByid(Actor actor);

	
}
