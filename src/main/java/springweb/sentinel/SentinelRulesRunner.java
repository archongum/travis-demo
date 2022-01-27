package springweb.sentinel;

import java.net.URLDecoder;
import java.util.List;
import java.util.Objects;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.FileRefreshableDataSource;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.system.SystemRule;
import com.alibaba.csp.sentinel.slots.system.SystemRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * Comment here.
 *
 * @author  Archon  2022-01-27
 * @version 0.0.1
 * @since   0.0.1
 */

@Component
public class SentinelRulesRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String flowRulePath = URLDecoder.decode(Objects.requireNonNull(classLoader.getResource("sentinel_rules/FlowRule.json")).getFile(), "UTF-8");
        String degradeRulePath = URLDecoder.decode(Objects.requireNonNull(classLoader.getResource("sentinel_rules/DegradeRule.json")).getFile(), "UTF-8");
        String systemRulePath = URLDecoder.decode(Objects.requireNonNull(classLoader.getResource("sentinel_rules/SystemRule.json")).getFile(), "UTF-8");

        // Data source for FlowRule
        FileRefreshableDataSource<List<FlowRule>> flowRuleDataSource = new FileRefreshableDataSource<>(flowRulePath, flowRuleListParser);
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());

        // Data source for DegradeRule
        FileRefreshableDataSource<List<DegradeRule>> degradeRuleDataSource = new FileRefreshableDataSource<>(degradeRulePath, degradeRuleListParser);
        DegradeRuleManager.register2Property(degradeRuleDataSource.getProperty());

        // Data source for SystemRule
        FileRefreshableDataSource<List<SystemRule>> systemRuleDataSource = new FileRefreshableDataSource<>(systemRulePath, systemRuleListParser);
        SystemRuleManager.register2Property(systemRuleDataSource.getProperty());
    }

    private Converter<String, List<FlowRule>> flowRuleListParser = source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {});

    private Converter<String, List<DegradeRule>> degradeRuleListParser = source -> JSON.parseObject(source, new TypeReference<List<DegradeRule>>() {});

    private Converter<String, List<SystemRule>> systemRuleListParser = source -> JSON.parseObject(source, new TypeReference<List<SystemRule>>() {});
}
