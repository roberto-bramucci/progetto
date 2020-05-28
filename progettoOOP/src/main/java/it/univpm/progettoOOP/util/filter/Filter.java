package it.univpm.progettoOOP.util.filter;

import java.util.Collection;

public interface Filter<E,T> {
	abstract Collection<E> chooseFilter(String operator, Double... value);
}
