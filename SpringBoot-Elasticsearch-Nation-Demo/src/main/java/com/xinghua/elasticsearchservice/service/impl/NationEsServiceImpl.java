package com.xinghua.elasticsearchservice.service.impl;

import com.xinghua.elasticsearchservice.common.service.impl.BaseServiceImpl;
import com.xinghua.elasticsearchservice.model.NationEsModel;
import com.xinghua.elasticsearchservice.service.INationEsService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NationEsServiceImpl extends BaseServiceImpl<NationEsModel> implements INationEsService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private INationEsService nationService;

    public List<NationEsModel> search(String question) {
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(
                QueryBuilders.multiMatchQuery(question, "title","questionContext").minimumShouldMatch("70%").field("title", 10)
        );
        return nationService.searchList(nativeSearchQueryBuilder);
    }
}
