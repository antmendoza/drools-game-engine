package org.drools.game.core.api;

import java.util.List;

public class Row<T> {

	private List<QueryItem<T>> items;

	public Row(List<QueryItem<T>> items) {
		this.items = items;
	}

	public List<QueryItem<T>> getItems() {
		return items;
	}

}
