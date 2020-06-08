package com.yy.generator.util;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.OracleQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yy.generator.criteria.ColumnInfo;
import org.springframework.core.io.ClassPathResource;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: yy
 * @date: 2020/6/1 16:17
 */
public class CodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        String projectPath = System.getProperty("user.dir");
        mpg.setGlobalConfig(new GlobalConfig()
                .setOutputDir(projectPath + "/generator/src/main/java").setAuthor("yy")
                .setOpen(false).setSwagger2(true).setServiceName("%sService")
                .setFileOverride(true));
        // 数据源配置
        mpg.setDataSource(new DataSourceConfig()
                .setUrl("xxxx")
                .setDriverName("xxxxx")
                .setUsername("xxxxx").setPassword("xxxxxx")
                .setDbQuery(new OracleQuery()).setTypeConvert(new OracleTypeConvert()));

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.yy").setModuleName(scanner("包ModuleName"));
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                List<ColumnInfo> columnInfos = new ArrayList<>();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(new ClassPathResource("tableQueryCritera/test.json").getFile()));
                    Gson gson = new GsonBuilder().create();
                    columnInfos = Arrays.asList(gson.fromJson(reader, ColumnInfo[].class));
                }catch (Exception e){
                    System.out.println("解析json出错");
                }
                map.put("queryColumns", columnInfos);
                map.put("criteria",pc.getParent() + ".criteria");
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();
        String criteriaPath = "/template/QueryCriteria.ftl";
        focList.add(new FileOutConfig(criteriaPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/generator/src/main/java/com/yy/" + pc.getModuleName() + "/"+"criteria"
                        + "/" + tableInfo.getEntityName() + "QueryCriteria" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController("/template/controller-my.java");
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("请输入需要生成的表,多表以,分隔").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("RKJ_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
