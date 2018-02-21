package com.sipa;

import com.sipa.domain.EntityValue;
import com.sipa.domain.UserValue;
import com.sipa.domain.WorkspaceValue;
import com.sipa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Main.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class UserResourceTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUsers_whenGetUsers_thenStatus200 () throws Exception {

        String testLogin = "nmachut";

        mvc.perform(get("/user/" + testLogin)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.login", is(testLogin)));
    }

    @Test
    public void whenValidInput_thenCreateEmployee () throws Exception {
        UserValue bob = new UserValue();
        bob.setLogin("bob");
        bob.setPassword("password");
        EntityValue entityValue = new EntityValue();
        entityValue.setId(2L);
        bob.setEntity(entityValue);
        bob.setMail("bob@bob.fr");
        WorkspaceValue workspaceValue = new WorkspaceValue();
        workspaceValue.setId(1L);
        bob.setWorkspace(workspaceValue);

        mvc.perform(post("/user").content(JsonUtil.toJson(bob))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        Iterable<UserValue> found = userRepository.findAll();
        assertThat(found).extracting(UserValue::getLogin).containsOnly("nmachut", "bob");
    }
}
