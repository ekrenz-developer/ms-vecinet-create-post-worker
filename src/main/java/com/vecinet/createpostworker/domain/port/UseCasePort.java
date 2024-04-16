package com.vecinet.createpostworker.domain.port;

public interface UseCasePort<I, O> {
    O execute(I input);
}
