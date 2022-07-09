package com.xinghua.elasticsearchservice.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @Description 基础实体类
 * @Author
 * @Date
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityEsModel {
    @Id
    private String id;
}
