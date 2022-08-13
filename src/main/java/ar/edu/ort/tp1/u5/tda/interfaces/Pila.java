package ar.edu.ort.tp1.u5.tda.interfaces;

public interface Pila<T> extends Tda {
	void push(T element);

	T pop();

	T peek();

}
