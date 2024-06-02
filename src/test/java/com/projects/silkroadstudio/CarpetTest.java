package com.projects.silkroadstudio;

import com.projects.silkroadstudio.Product.*;
import com.projects.silkroadstudio.Product.Carpet.Carpet;
import com.projects.silkroadstudio.Product.Carpet.CarpetRepository;
import com.projects.silkroadstudio.Product.Carpet.CarpetService;
import com.projects.silkroadstudio.Product.Size.Size;
import com.projects.silkroadstudio.Product.Size.SizeRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CarpetTest {

    @Autowired
    private CarpetRepository carpetRepository;
    @Autowired
    private CarpetService carpetService;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @AfterEach
    void tearDown() {
        carpetRepository.deleteAll();
        sizeRepository.deleteAll();
    }

    @SneakyThrows
    @Test
    void testCreateCarpet() {
        Size size1 = new Size(100, 50);
        sizeRepository.save(size1);
        Carpet carpet1 = new Carpet(Material.LEATHER, new BigDecimal(1000), Colour.WHITE, size1);
        Carpet carpet_result = carpetService.save(carpet1);
        assertEquals(carpet_result.getMaterial().name(), "LEATHER");
        assertEquals(carpet_result.getColour().name(), "WHITE");
        assertEquals(carpet_result.getPrice(), new BigDecimal(1000));
        assertEquals(carpet_result.getSize(), size1);
    }

    @SneakyThrows
    @Test
    void testCreateCarpetWeb() {
        Size size1 = new Size(100, 50);
        sizeRepository.save(size1);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/carpet")
                        .content(objectMapper.writeValueAsString(new Carpet(Material.LEATHER, new BigDecimal(1000), Colour.WHITE, size1)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.material").value("LEATHER"));
    }

}
