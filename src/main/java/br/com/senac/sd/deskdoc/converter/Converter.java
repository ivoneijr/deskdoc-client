package br.com.senac.sd.deskdoc.converter;

import java.util.List;

public interface Converter <S,T>{
	
	public S toS(T target);

	public T toT(S source);
	
	public List<S> toS(List<T> targetList) throws Exception;
	
	public List<T> toT(List<S> targetList) throws Exception;
	
}