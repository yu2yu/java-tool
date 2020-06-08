package com.yy.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yy.generator.criteria.ColumnInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: yy
 * @date: 2020/6/1 16:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GereratorTest {


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testPageController() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        /*
         * 1、mockMvc.perform执行一个请求。
         * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
         * 3、ResultActions.param添加请求传值
         * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
         * 5、ResultActions.andExpect添加执行完成后的断言。
         * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
         *   比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
         * 7、ResultActions.andReturn表示执行完成后返回相应的结果。
         */
//        MarketerQueryCriteria marketerQueryCriteria = new MarketerQueryCriteria();
//        marketerQueryCriteria.setMarketerId("214");
//        marketerQueryCriteria.setName("郭淑芳");
        mockMvc.perform(MockMvcRequestBuilders
                .get("/demo/marketer/list?pageNo=2&pageSize=20")
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content("{ \"marketerId\": \"214\",\"name\": \"\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

//    @Test
//    public void testAddController() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        Marketer marketer = new Marketer();
//        marketer.setMarketerId("SDDWDWD");
//        marketer.setIdNum("d12131313131");
//        marketer.setName("号段和杜瓦");
//        marketer.setBranchId("00000000000124");
//        marketer.setIsWhite("0");
//        marketer.setPhone("15312346543");
//        marketer.setAuthLevel("1");
//        marketer.setStatus("1");
//        marketer.setCreateAt("20200605");
//        marketer.setUpdateAt("20200605");
//
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/demo/marketer/add")
//                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
//                .content(mapper.writeValueAsString(marketer)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }

//    @Test
//    public void testEditController() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        Marketer marketer = new Marketer();
//        marketer.setMarketerId("SDDWDWD");
//        marketer.setIdNum("444444444");
//        marketer.setName("号段");
//        marketer.setBranchId("00000000000124");
//        marketer.setPhone("15312346553");
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .put("/demo/marketer/edit")
//                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
//                .content(mapper.writeValueAsString(marketer)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }

    @Test
    public void testDeleteBatchController() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/demo/marketer/deleteBatch")
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .param("ids","SDDWDWD,213")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testDeleteController() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/demo/marketer/delete")
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .param("id","SDDWDWD")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testQueryController() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/demo/marketer/queryById")
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .param("id","SDDWDWD")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testGson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new ClassPathResource("a.json").getFile()));
        Gson gson = new GsonBuilder().create();
        List<ColumnInfo> columnInfos = Arrays.asList(gson.fromJson(reader, ColumnInfo[].class));
        columnInfos.forEach(k-> System.out.println(k.getColumnName()));
    }
}
