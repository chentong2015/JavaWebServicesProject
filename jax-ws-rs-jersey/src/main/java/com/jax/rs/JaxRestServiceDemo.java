package com.jax.rs;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.InboundSseEvent;
import javax.ws.rs.sse.SseEventSource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JaxRestServiceDemo {

    // Jax.Rs Client 发送请求，获取到指定类型的返回数据
    public void testJaxRsClient() throws InterruptedException {
        Client client = ClientBuilder.newClient();
        WebTarget endpoint = client.target("http://www.server.net/person");
        // Person person = target.request().get(Person.class);

        CountDownLatch countDownLatch = new CountDownLatch(1);
        SseEventSource sseEventSource = SseEventSource
                .target(endpoint)
                .reconnectingEvery(100, TimeUnit.MILLISECONDS)
                .build();

        // 使用sseEventSource来注册，在error发生和完成的时候执行相应的逻辑 !!
        sseEventSource.register(inboundSseEvent -> onMessage(inboundSseEvent), // onMessage
                throwable -> onError(throwable),   // onError
                () -> countDownLatch.countDown()); // onComplete 完成之后，恢复CountDown

        // Open the connection to the supplied SSE and start processing incoming Sse Events
        sseEventSource.open();
        // Wait for all the messages to be received
        countDownLatch.await();
        sseEventSource.close();
    }

    private void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    public void onMessage(InboundSseEvent inboundSseEvent) {
        String data = inboundSseEvent.readData();
    }
}
