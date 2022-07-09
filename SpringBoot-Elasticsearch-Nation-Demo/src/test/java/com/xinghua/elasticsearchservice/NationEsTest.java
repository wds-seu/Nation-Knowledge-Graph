package com.xinghua.elasticsearchservice;


import com.xinghua.elasticsearchservice.model.NationEsModel;
import com.xinghua.elasticsearchservice.service.INationEsService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 基础功能测试类
 * @Author
 * @Date
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class NationEsTest {

    @Autowired
    private INationEsService nationEsService;


    @BeforeEach
    void setUp() {
        //System.out.println("执行初始化");
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * 获取索引名称
     */
    @Test
    void getIndexName() {
        System.out.println(nationEsService.getIndexName());
    }

    /**
     * 获取类型
     */
    @Test
    void getIndexType() {
        System.out.println(nationEsService.getIndexType());
    }

    /**
     * 删除索引
     */
    @Test
    void deleteIndex() {
        Boolean aBoolean = nationEsService.deleteIndex();
        System.out.println("aBoolean = " + aBoolean);
    }

    /**
     * 返回泛型上的Class对象
     */
    @Test
    void getEntityClass() {
        System.out.println(nationEsService.getEntityClass());
    }

    /**
     * 创建索引和映射(若原有索引存在则删除重新创建)
     */
    @Test
    void createEntityEsIndex() {
        System.out.println(nationEsService.createEntityEsIndex());
    }

    /**
     * 初始化数据
     * 1: 删除原有的索引
     * 2: 创建索引并且初始化映射
     * 3: bulk 批量初始化数据
     */
    @Test
    void init() {

    }

    /**
     * 新增或修改
     */
    @Test
    void saveOrUpdate() {

    }

    /**
     * 删除
     */
    @Test
    void delete() {
        System.out.println(nationEsService.delete("5"));
    }

    /**
     * 获取PageRequest对象
     */
    @Test
    void getPageRequest() {
        System.out.println(nationEsService.getPageRequest(1, 10));
    }

    /**
     * 批量新增Entry
     */
    @Test
    void batchInsertOrUpdate() {

        FileInputStream fis = null;
        Sheet sheet = null;
        List<NationEsModel> nationEsModels = new ArrayList<>();
        try {
            //获取一个绝对地址的流
            fis = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\SpringBoot-Elasticsearch-Demo-master\\testNation.xls");
            Workbook workbook = new HSSFWorkbook(fis);
            // 获取每个Sheet表
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheet = workbook.getSheetAt(i);
                // getLastRowNum，获取最后一行的行标
                for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
                    Row row = sheet.getRow(j);
                    if (row != null) {
                        //赋值
                        row.getCell(0).setCellType(CellType.STRING);
                        String nationName = row.getCell(0).getStringCellValue().trim();
                        row.getCell(1).setCellType(CellType.STRING);
                        String clothes = row.getCell(1).getStringCellValue().trim();
                        row.getCell(2).setCellType(CellType.STRING);
                        String food = row.getCell(2).getStringCellValue().trim();
                        row.getCell(3).setCellType(CellType.STRING);
                        String live = row.getCell(3).getStringCellValue().trim();
                        row.getCell(4).setCellType(CellType.STRING);
                        String traffic = row.getCell(4).getStringCellValue().trim();
                        row.getCell(5).setCellType(CellType.STRING);
                        String technic = row.getCell(5).getStringCellValue().trim();
                        row.getCell(6).setCellType(CellType.STRING);
                        String weapon = row.getCell(6).getStringCellValue().trim();
                        row.getCell(7).setCellType(CellType.STRING);
                        String protocol = row.getCell(7).getStringCellValue().trim();
                        row.getCell(8).setCellType(CellType.STRING);
                        String environment = row.getCell(8).getStringCellValue().trim();
                        row.getCell(9).setCellType(CellType.STRING);
                        String totem = row.getCell(9).getStringCellValue().trim();
                        NationEsModel p = new NationEsModel(String.valueOf(j), nationName,
                                clothes, food, live, traffic, technic, weapon, protocol, environment, totem);
                        nationEsModels.add(p);
                    }
                }
            }
            nationEsService.batchInsertOrUpdate(nationEsModels);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
