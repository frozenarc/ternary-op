package org.frozenarc.ternaryop;

import java.util.function.Supplier;

public interface ThenDo<T> {

    ElseDo<T> thn(Supplier<T> supplier);
}
