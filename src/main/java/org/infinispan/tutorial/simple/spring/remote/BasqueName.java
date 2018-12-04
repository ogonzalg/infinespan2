package org.infinispan.tutorial.simple.spring.remote;

import java.io.Serializable;
import java.util.Objects;

public class BasqueName implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 857544594663330231L;
	private final int id;
	private final String name;

	public BasqueName(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		return Objects.deepEquals(o, this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

}
