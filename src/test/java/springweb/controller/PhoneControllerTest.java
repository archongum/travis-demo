package springweb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import springweb.domain.Phone;
import springweb.service.PhoneService;


@RunWith(SpringRunner.class)
@WebMvcTest(PhoneController.class)
public class PhoneControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PhoneService phoneService;

    @Test
    public void getPhone_ShouldReturnPhone() throws Exception {
        BDDMockito.given(phoneService.getPhone(ArgumentMatchers.anyString())).willReturn(new Phone("iPhone", "Apple"));

        mockMvc.perform(MockMvcRequestBuilders.get("/getPhone/iPhone"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("name").value("iPhone"))
            .andExpect(MockMvcResultMatchers.jsonPath("type").value("Apple"));
    }
}
