package com.demo.bar;

import com.demo.bar.adapter.model.CocktailDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableAutoConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {BarComponentConfiguration.class},
        properties = "spring.main.allow-bean-definition-overriding=true")
@AutoConfigureMockMvc
class BarComponentConfigurationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void contextLoads() {
    }


    @Test
    void shouldReturnValidCocktail() throws Exception {
        var response = this.mockMvc.perform(post("/order").content("beer"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        CocktailDTO cocktailDTO = mapper.readValue(response, CocktailDTO.class);

        assertThat(cocktailDTO.name()).isEqualTo("beer");
        assertThat(cocktailDTO.ingredients()).containsExactly("heineken");
    }

    @Test
    void shouldReturnValidCocktailWithFewIngridients() throws Exception {
        var response = this.mockMvc.perform(post("/order").content("beer"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        CocktailDTO cocktailDTO = mapper.readValue(response, CocktailDTO.class);

        assertThat(cocktailDTO.name()).isEqualTo("beer");
        assertThat(cocktailDTO.ingredients()).containsExactly("heineken");
    }

    @Test
    void shouldReturnNothing() throws Exception {
        this.mockMvc.perform(post("/order").content("mojito")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
