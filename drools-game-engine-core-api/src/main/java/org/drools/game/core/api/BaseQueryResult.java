package org.drools.game.core.api;

import java.util.List;

public class BaseQueryResult<T> implements QueryResult<T>{

	private List<Row<T>> result;
	
	public BaseQueryResult(){
	}
	
	public BaseQueryResult(List<Row<T>> result) {
		this.result = result;
	}

	@Override
	public List<Row<T>> getResult() {
		return result;
	}
	



	

}
