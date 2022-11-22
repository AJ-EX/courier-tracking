/*
package com.ajex.couriertracking.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.ajex.couriertracking.controller.CallHistoryController;
import com.ajex.couriertracking.controller.CustomUtils;
import com.ajex.couriertracking.dao.CallHistory;
import com.ajex.couriertracking.dto.CallHistoryDto;
import com.ajex.couriertracking.mapper.CallHistoryMapper;
import com.ajex.couriertracking.mapper.EntityMapper;
import com.ajex.couriertracking.service.CallHistoryService;
import com.google.gson.Gson;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;

@Transactional
public class CallHistoryControllerTest {
    private static final String ENDPOINT_URL = "/api/call-history";
    @InjectMocks
    private CallHistoryController callhistoryController;
    @Mock
    private CallHistoryService callhistoryService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(callhistoryController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<CallHistoryDto> page = new PageImpl<>(Collections.singletonList(CallHistoryBuilder.getDto()));

        Mockito.when(callhistoryService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(callhistoryService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(callhistoryService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(callhistoryService.findById(ArgumentMatchers.anyLong())).thenReturn(CallHistoryBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(callhistoryService, Mockito.times(1)).findById(1);
        Mockito.verifyNoMoreInteractions(callhistoryService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(callhistoryService.save(ArgumentMatchers.any(CallHistoryDto.class))).thenReturn(CallHistoryBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(CallHistoryBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(callhistoryService, Mockito.times(1)).save(ArgumentMatchers.any(CallHistoryDto.class));
        Mockito.verifyNoMoreInteractions(callhistoryService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(callhistoryService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(CallHistoryBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(CallHistoryBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(callhistoryService, Mockito.times(1)).update(ArgumentMatchers.any(CallHistoryDto.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(callhistoryService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(callhistoryService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(CallHistoryBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(callhistoryService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(callhistoryService);
    }
}*/
