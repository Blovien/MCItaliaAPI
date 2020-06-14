package it.andrearossi.mcitaliaapi.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class RunnableVal<T, V> implements Runnable, Supplier<V>, Consumer<T> {

	public T value;
	public V returnable;

	public RunnableVal() {
	}

	public RunnableVal(T value, V returnable) {
		this.value = value;
		this.returnable = returnable;
	}

	@Override
	public final void run() {
		run(this.value);
	}

	public final V runAndGet() {
		run();
		return returnable;
	}

	public abstract void run(T value);

	@Override
	public V get() {
		return runAndGet();
	}

	@Override
	public void accept(T t) {
		run(value);
	}

	public void setReturnable(V returnable) {
		this.returnable = returnable;
	}
}
