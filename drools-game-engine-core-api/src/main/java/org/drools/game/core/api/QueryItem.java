package org.drools.game.core.api;

public class QueryItem<T> {

	private String identifier;
	private T value;

	public QueryItem(String identifier, T value) {
		this.identifier = identifier;
		this.value = value;
	}

	public String getIdentifier() {
		return identifier;
	}

	public T getValue() {
		return value;
	}
}
