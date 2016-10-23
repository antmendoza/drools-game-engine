package org.drools.game.core.api;

public class BaseQueryResult<T> implements QueryResult<T>{

	private T result;
	
	public BaseQueryResult(T result) {
		this.result = result;
	}
	
	
	@Override
	public T getResult() {
		return result;
	}

}
