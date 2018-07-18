package io.smallrye.reactive.messaging;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReactiveMessagingExtensionTest extends WeldTestBase {


  @Test
  public void test() {
    weld.addBeanClass(MyBean.class);
    weld.initialize();
    assertThat(MyBean.COLLECTOR).containsExactly("FOO", "FOO", "BAR", "BAR");
  }

}
