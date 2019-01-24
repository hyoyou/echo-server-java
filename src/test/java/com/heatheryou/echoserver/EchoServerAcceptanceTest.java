package com.heatheryou.echoserver;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

class EchoServerAcceptanceTest {
    ServerProcess serverProcess;

    @BeforeEach
    void setUp() throws IOException {
        serverProcess = ServerProcess.start();
    }

    @AfterEach
    void tearDown() throws Exception {
        serverProcess.stop();
    }

    @Test
    void whenClientEchoes_thenItGetsIdenticalResponse() throws Exception {
        try (EchoClient client = EchoClient.forLocalServer()) {
            client.connect();

            String echoInput = "foo";
            String response = client.echo(echoInput);

            assertEquals(echoInput, response);
        }
    }
}