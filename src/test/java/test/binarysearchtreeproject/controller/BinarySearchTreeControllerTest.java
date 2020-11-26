package test.binarysearchtreeproject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BinarySearchTreeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAll() throws Exception {
        mockMvc.perform(post("/api/key/5")).andDo(print()).
                andExpect(status().isOk());
        mockMvc.perform(get("/api/key/5")).andDo(print()).
                andExpect(status().isOk()).andExpect(content().string("0"));

        mockMvc.perform(post("/api/key/8")).andDo(print()).
                andExpect(status().isOk());
        mockMvc.perform(get("/api/key/8")).andDo(print()).
                andExpect(status().isOk()).andExpect(content().string("1"));

        mockMvc.perform(delete("/api/key/8")).andDo(print()).
                andExpect(status().isOk());
        mockMvc.perform(get("/api/key/8")).andDo(print()).
                andExpect(status().isOk()).andExpect(content().string("-1"));

        mockMvc.perform(post("/api/key/8")).andDo(print()).
                andExpect(status().isOk());

        mockMvc.perform(get("/api/key")).andDo(print()).
                andExpect(status().isOk()).andExpect(content().string("<Tree><root><key>5</key><left/><right><key>8</key><left/><right/></right></root></Tree>"));


    }


}