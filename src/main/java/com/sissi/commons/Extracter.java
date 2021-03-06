package com.sissi.commons;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

/**
 * @author kim 2014年2月23日
 */
public class Extracter {

	public static String asString(DBObject db, String key) {
		Object value = Extracter.as(db, key);
		return value != null ? value.toString() : null;
	}

	@SuppressWarnings("unchecked")
	public static String[] asStrings(DBObject db, String key) {
		List<String> value = List.class.cast(db.get(key));
		return value != null ? value.toArray(new String[] {}) : null;
	}

	public static int asInt(DBObject db, String key) {
		Object value = Extracter.as(db, key);
		return value != null ? Integer.parseInt(value.toString()) : null;
	}

	public static int[] asInts(DBObject db, String key) {
		Object value = Extracter.as(db, key);
		return value != null ? ArrayUtils.toPrimitive(BasicDBList.class.cast(value).toArray(new Integer[] {})) : null;
	}

	public static long asLong(DBObject db, String key) {
		Object value = Extracter.as(db, key);
		return value != null ? Long.parseLong(value.toString()) : null;
	}

	public static boolean asBoolean(DBObject db, String key) {
		Object value = Extracter.as(db, key);
		return value != null ? Boolean.class.cast(value) : Boolean.FALSE;
	}

	private static Object as(DBObject db, String key) {
		return db != null ? db.get(key) : null;
	}
}
