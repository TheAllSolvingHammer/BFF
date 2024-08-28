package com.tinqinacademy.bff.api.base;

import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import io.vavr.control.Either;

public interface OperationProcessorBFF<T extends OperationOutputBFF,E extends OperationInputBFF> {
    Either<ErrorsProcessorBFF,T> process(E input);
}
