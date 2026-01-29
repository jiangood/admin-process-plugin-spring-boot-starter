package io.github.jiangood.as.modules.flowable.dao.impl;

import cn.hutool.core.io.resource.ResourceUtil;
import io.github.jiangood.as.common.tools.YmlTool;
import io.github.jiangood.as.modules.flowable.config.ProcessMetaConfiguration;
import io.github.jiangood.as.modules.flowable.config.meta.ProcessMeta;
import io.github.jiangood.as.modules.flowable.dao.IProcessMetaDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class ProcessMetaDaoYmlImpl implements IProcessMetaDao {

    public static final String PROCESS_YML = "config/application-process.yml";

    @Override
    public List<ProcessMeta> findProcessMetaList() {
        try {
            InputStream is = ResourceUtil.getStream(PROCESS_YML);
            ProcessMetaConfiguration cfg = YmlTool.parseYml(is, ProcessMetaConfiguration.class, "process");
            return cfg.getList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
