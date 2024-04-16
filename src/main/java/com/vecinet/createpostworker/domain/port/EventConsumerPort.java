package com.vecinet.createpostworker.domain.port;

public interface EventConsumerPort<E> {
    //    EventPort handleReceivedSyncEvent(EventPort event);
    void handleReceivedAsyncEvent(E event);
}
