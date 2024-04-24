package com.example.aoms.api.nbp;

import com.example.aoms.api.controller.NbpApiController;
import com.example.aoms.api.data.nbpApi.NbpApiExchangeRateResponse;
import com.example.aoms.api.enums.NbpExchangeRateTable;
import com.example.aoms.api.jwt_token.service.JwtService;
import com.example.aoms.api.service.NbpApiService;
import com.example.aoms.api.utils.NbpApiEndpoints;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(NbpApiController.class)
public class NbpApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NbpApiService nbpApiService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private UserDetailsService userDetailsService;

    //FIXME Think how to test integrating with nbp api, because depending the day that request is made, the result may differ
    // so createNbpApiResponse() may not work properly.
    @Test
    public void should_properly_map_response_from_nbp_api_exchange_rates_to_application_response() throws Exception {
        //TODO
//        // when
//        when(nbpApiService.getExchangeRatesFromTodayForTable(NbpExchangeRateTable.A))
//                .thenReturn(getExampleOfNbpApiResponse());
//
//        //then
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get(getExchangeRateUrl(NbpExchangeRateTable.A.getTable()))
//                        .param("format", "json")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
    }

    private static String getExchangeRateUrl(String table) {
        return NbpApiEndpoints.NBP_API_BASE_URL + NbpApiEndpoints.CURRENTLY_VALID_EXCHANGE_RATE_TABLE_ENDPOINT + "/" + table;
    }

    private List<NbpApiExchangeRateResponse> getExampleOfNbpApiResponse() {
        return List.of(
                NbpApiExchangeRateResponse.builder()

                        .build()
        );
    }
}
