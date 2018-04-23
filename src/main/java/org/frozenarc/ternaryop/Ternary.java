package org.frozenarc.ternaryop;

import java.util.function.Supplier;

public class Ternary<T> implements WhenTest<T>, ThenDo<T>, ElseDo<T> {

    private Supplier<Boolean> whnSupplier;
    private Supplier<T> thnSupplier;

    private Ternary() {

    }

    /*
    Seq forcing, and making sure that method will be used only once
     */
    public static <T> WhenTest<T> optr() {
        return new Ternary<>();
    }

    public ThenDo<T> whn(Supplier<Boolean> supplier) {
        this.whnSupplier = supplier;
        return this;
    }

    public ElseDo<T> thn(Supplier<T> supplier) {
        this.thnSupplier = supplier;
        return this;
    }

    public T els(Supplier<T> supplier) {
        return whnSupplier.get()
                ? thnSupplier.get()
                : supplier.get();
    }
}
