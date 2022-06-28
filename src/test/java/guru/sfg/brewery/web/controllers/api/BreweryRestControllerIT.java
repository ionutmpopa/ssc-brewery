package guru.sfg.brewery.web.controllers.api;

import guru.sfg.brewery.web.controllers.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BreweryRestControllerIT extends BaseIT {

    @Test
    void getBreweryHttpBasicUserRole() throws Exception{
        mockMvc.perform(get("/brewery/api/v1/breweries")
                .with(httpBasic("user", "password")))
            .andExpect(status().isForbidden());
    }

    @Test
    void getBreweryHttpBasicCustomerRole() throws Exception{
        mockMvc.perform(get("/brewery/api/v1/breweries")
                .with(httpBasic("scott", "tiger")))
            .andExpect(status().isOk());
    }

    @Test
    void getBreweriesHttpBasicUserRole() throws Exception{
        mockMvc.perform(get("/brewery/breweries/index")
                .with(httpBasic("user", "password")))
            .andExpect(status().isForbidden());
    }

    @Test
    void getBreweriesHttpBasicCustomerRole() throws Exception{
        mockMvc.perform(get("/brewery/breweries/index")
                .with(httpBasic("scott", "tiger")))
            .andExpect(status().isOk());
    }

    @Test
    void getBreweriesHttpBasicAdminRole() throws Exception{
        mockMvc.perform(get("/brewery/breweries/index")
                .with(httpBasic("spring", "guru")))
            .andExpect(status().isOk());
    }

    @Test
    void getBreweryHttpBasicAdminRole() throws Exception{
        mockMvc.perform(get("/brewery/api/v1/breweries")
                .with(httpBasic("spring", "guru")))
            .andExpect(status().isOk());
    }

}
