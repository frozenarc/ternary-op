package org.frozenarc.ternaryop;

import java.util.function.Supplier;

public interface ElseDo<T> {

    T els(Supplier<T> supplier);
}
