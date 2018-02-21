package com.sipa;

import com.sipa.domain.EntityValue;
import com.sipa.domain.UserValue;
import com.sipa.repository.EntityRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Main.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class EntityResourceTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EntityRepository entityRepository;

    @Test
    public void whenValidInput_thenCreateEntity () throws Exception {

        EntityValue entityValue = new EntityValue();
        entityValue.setParentId(1L);
        entityValue.setName("testEntity");
        entityValue.setDescription("description entity");


        mvc.perform(post("/entity")
                .content(JsonUtil.toJson(entityValue))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        Iterable<EntityValue> found = entityRepository.findAll();
        assertThat(found).extracting(EntityValue::getName).contains("testEntity");
    }
}
