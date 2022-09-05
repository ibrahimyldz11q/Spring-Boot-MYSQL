package com.mysqlRecap.springMysql.DataAccess;
import java.util.List;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysqlRecap.springMysql.Entites.Actor;
@Repository
public class HibernateDAL implements IActorDAL {
	
	
	private EntityManager entityManager;
	
	@Autowired // Constructer Injection Yapıyoruz Bağımlılıklarını Getiriyor 
	public HibernateDAL(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	@Transactional // Hibernate Session Açıp Kapatmaya Yaran Anotasyon
	public List<Actor> getAll() {
		
		Session session = entityManager.unwrap(Session.class); // Session Yarattık
		List<Actor> actors= session.createQuery("from Actor",Actor.class).getResultList(); // Yarattığımız Sessiondan List İçersine veri Gönderdik
		return actors;
		
	}

	@Override
	public void add(Actor actor) {
		Session session = entityManager.unwrap(Session.class); // Session Yarattık
		session.saveOrUpdate(actor); // Hem Kaydetme Hem de Updatmeye Yarar
		
	}

	@Override
	public void delete(Actor actor) {
		Session session = entityManager.unwrap(Session.class); 
		Actor silme = session.get(Actor.class, actor.getActor_id());
		session.saveOrUpdate(silme);

	}

	@Override
	public void update(Actor actor) {
		Session session = entityManager.unwrap(Session.class); 
		session.saveOrUpdate(actor);

	}

	@Override
	public Actor getByid(Actor actor) {
		Session session = entityManager.unwrap(Session.class);
		
		Actor getIds = session.get(Actor.class, actor.getActor_id());
		return getIds;
		
	}

	
}
