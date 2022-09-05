package com.mysqlRecap.springMysql.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysqlRecap.springMysql.DataAccess.IActorDAL;
import com.mysqlRecap.springMysql.Entites.Actor;

@Service
public class ActorManager  implements IActorService{
	
	private IActorDAL actorDAL;

	@Autowired
	public ActorManager(IActorDAL actorDAL) {
		this.actorDAL = actorDAL;
	}

	@Override
	@Transactional
	public List<Actor> getAll() {
	
		return this.actorDAL.getAll();
	}

	@Override
	@Transactional
	public void add(Actor actor) {
		this.actorDAL.add(actor);
	}

	@Override
	@Transactional
	public void delete(Actor actor) {
		this.actorDAL.delete(actor);
	}

	@Override
	@Transactional
	public void update(Actor actor) {
		this.actorDAL.update(actor);
	}
	

}
