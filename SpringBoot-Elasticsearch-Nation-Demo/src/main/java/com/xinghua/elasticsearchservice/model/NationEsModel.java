package com.xinghua.elasticsearchservice.model;


import com.xinghua.elasticsearchservice.common.model.EntityEsModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Description ES 实体类
 * Document：配置操作哪个索引下的哪个类型
 * Id：标记文档ID字段
 * Field：配置映射信息，如：分词器
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "案例ES对象")
@Document(indexName = "case", type = "case")
public class NationEsModel extends EntityEsModel {

    /**
     * 民族
     */
    @ApiModelProperty(value = "民族")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String nationName;

    /**
     * 1：衣
     */
    @ApiModelProperty(value = "衣")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String clothes;

    /**
     * 2：食
     */
    @ApiModelProperty(value = "食")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String food;

    /**
     * 3：住
     */
    @ApiModelProperty(value = "住")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String live;

    /**
     * 4：行
     */
    @ApiModelProperty(value = "行")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String traffic;

    /**
     * 5：工
     */
    @ApiModelProperty(value = "工")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String technic;

    /**
     * 6：兵
     */
    @ApiModelProperty(value = "兵")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String weapon;

    /**
     * 7：礼
     */
    @ApiModelProperty(value = "礼")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String protocol;

    /**
     * 8：境
     */
    @ApiModelProperty(value = "境")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String environment;

    /**
     * 9：象
     */
    @ApiModelProperty(value = "象")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String totem;

    public NationEsModel(String id, String nationName, String clothes, String food, String live, String traffic, String technic,
                         String weapon, String protocol, String environment, String totem) {
        super(id);
        this.nationName = nationName;
        this.clothes = clothes;
        this.food = food;
        this.live = live;
        this.traffic = traffic;
        this.technic = technic;
        this.weapon = weapon;
        this.protocol = protocol;
        this.environment = environment;
        this.totem = totem;
    }

    @Override
    public String toString() {
        return "CaseEsModel{" +
                "id=" + super.getId() + '\'' +
                "nationName='" + nationName + '\'' +
                "clothes='" + clothes + '\'' +
                ", food='" + food + '\'' +
                ", live='" + live + '\'' +
                ", traffic='" + traffic + '\'' +
                ", technic='" + technic + '\'' +
                ", weapon='" + weapon + '\'' +
                ", protocol='" + protocol + '\'' +
                ", environment='" + environment + '\'' +
                ", totem='" + totem + '\'' +
                '}';
    }

}
