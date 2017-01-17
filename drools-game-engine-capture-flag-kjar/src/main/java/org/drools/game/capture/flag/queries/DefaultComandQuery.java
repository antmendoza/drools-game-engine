package org.drools.game.capture.flag.queries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.drools.game.core.api.Context;
import org.drools.game.core.api.QueryCommand;
import org.drools.game.core.api.QueryItem;
import org.drools.game.core.api.Row;
import org.drools.game.model.api.Player;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

public class DefaultComandQuery<T> implements QueryCommand<T> {

	private Player player;
	private String query;
	private Object[] arguments;

	public DefaultComandQuery() {
	}

	public DefaultComandQuery(Player player, String query, Object... arguments) {
		this.player = player;
		this.query = query;
		this.arguments = arguments;
	}

	@Override
	public String getQuery() {
		return query;
	}

	@Override
	public Object[] getArguments() {
		return arguments;
	}

	@Override
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public T execute(Context ctx) {
		KieSession session = (KieSession) ctx.getData().get("session");

		System.out.println("query " + query);
		System.out.println("arguments " + arguments);
		System.out.println("player " + player);

		QueryResults queryResults = session.getQueryResults(query, arguments);
		final List<Row<T>> result = new ArrayList<Row<T>>();

		List<String> identifiers = Arrays.asList(queryResults.getIdentifiers());

		Iterator<QueryResultsRow> iterator = queryResults.iterator();
		System.out.println("queryResults.size() " + queryResults.size());

		while (iterator.hasNext()) {
			QueryResultsRow queryResultsRow = iterator.next();
			List<QueryItem<T>> items = new ArrayList<QueryItem<T>>();

			System.out.println("identifiers " + identifiers);

			for (String identifier : identifiers) {
				items.add(new QueryItem<T>(identifier, (T) queryResultsRow.get(identifier)));
				System.out.println("items " + items);

			}
			Row<T> row = new Row<T>(items);
			result.add(row);
		}

		return (result.isEmpty()) ? null : result.get(0).getItems().get(0).getValue();

	}

}
