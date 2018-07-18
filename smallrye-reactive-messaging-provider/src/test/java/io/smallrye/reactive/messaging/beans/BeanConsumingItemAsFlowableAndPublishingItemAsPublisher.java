package io.smallrye.reactive.messaging.beans;

import io.reactivex.Flowable;
import io.smallrye.reactive.messaging.DefaultMessage;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.reactivestreams.Publisher;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeanConsumingItemAsFlowableAndPublishingItemAsPublisher {

  @Incoming(topic = "count")
  @Outgoing(topic = "sink")
  public Publisher<String> process(Flowable<Integer> source) {
    return source
      .map(i -> i + 1)
      .flatMap(i -> Flowable.just(i, i))
      .map(i -> Integer.toString(i));
  }

}
