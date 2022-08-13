package ar.edu.ort.tp1.u5.tda.interfaces;

public interface Cola<T> extends Tda {
	void add(T element);

	T remove();

	T get();
}
