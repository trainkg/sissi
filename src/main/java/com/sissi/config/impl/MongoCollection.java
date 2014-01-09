package com.sissi.config.impl;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.sissi.config.MongoConfig;

/**
 * @author kim 2013-11-15
 */
public class MongoCollection implements MongoConfig {
	
	public static final String FIELD_JID = "jid";

	public static final String FIELD_INDEX = "index";

	public static final String FIELD_CURRENT = "current";

	public static final String FIELD_PRIORITY = "priority";

	public static final String FIELD_RESOURCE = "resource";
	
	public static final DBObject DEFAULT_FILTER = BasicDBObjectBuilder.start(MongoCollection.FIELD_INDEX, 1).get();

	public static final DBObject DEFAULT_SORTER = BasicDBObjectBuilder.start().add(MongoCollection.FIELD_PRIORITY, -1).add(MongoCollection.FIELD_CURRENT, -1).get();
	
	private final DBObject REMOVE = BasicDBObjectBuilder.start().get();

	private final Map<String, String> configs = new HashMap<String, String>();

	private final DBCollection collection;

	private final MongoClient client;

	public MongoCollection(MongoClient client, String db, String collection) {
		super();
		this.client = client;
		this.configs.put(MongoCollection.D_NAME, db);
		this.configs.put(MongoCollection.C_NAME, collection);
		this.collection = this.client.getDB(db).getCollection(collection);
	}

	@Override
	public String get(String key) {
		return this.configs.get(key);
	}

	public MongoConfig clear() {
		this.collection().remove(REMOVE);
		return this;
	}

	public DBCollection collection() {
		return this.collection;
	}

	private Object as(DBObject db, String key) {
		return db != null ? db.get(key) : null;
	}

	public String asString(DBObject db, String key) {
		Object value = this.as(db, key);
		return value != null ? value.toString() : null;
	}

	public Boolean asBoolean(DBObject db, String key) {
		Object value = this.as(db, key);
		return value != null ? Boolean.class.cast(value) : Boolean.FALSE;
	}
}
