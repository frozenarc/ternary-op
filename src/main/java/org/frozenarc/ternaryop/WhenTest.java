package org.frozenarc.ternaryop;

import java.util.function.Supplier;

public interface WhenTest<T> {

    ThenDo<T> whn(Supplier<Boolean> supplier);
}
