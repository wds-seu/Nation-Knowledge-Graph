package com.xinghua.elasticsearchservice.service;

import com.xinghua.elasticsearchservice.common.service.IBaseService;
import com.xinghua.elasticsearchservice.model.NationEsModel;

import java.util.List;

public interface INationEsService extends IBaseService<NationEsModel> {
    List<NationEsModel> search(String question) throws Exception;
}
