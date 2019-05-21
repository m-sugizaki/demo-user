package com.example.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort ;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class UserRestControllerIntegrationTest{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void 一覧取得() throws Exception {
        URI uri = new URI("http://localhost:" + port + "/users/");
        String responseBody = template.getForObject(uri, String.class);
        assertThat(responseBody).isEqualTo("[{\"id\":1,\"name\":\"杉崎　睦\",\"pass\":\"sugisugi\"},{\"id\":2,\"name\":\"中森健\",\"pass\":\"01234567\"},{\"id\":3,\"name\":\"Sato\",\"pass\":\"satosato\"},{\"id\":4,\"name\":\"Suzuki\",\"pass\":\"suzukima\"},{\"id\":5,\"name\":\"鈴木太郎\",\"pass\":\"tarotaro\"}]");
    }
}
