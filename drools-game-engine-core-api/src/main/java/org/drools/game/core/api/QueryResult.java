package org.drools.game.core.api;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_OBJECT;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = CLASS, include = WRAPPER_OBJECT)
public interface QueryResult<T> {

	List<Row<T>> getResult();

}
