package ${cfg.criteria};

<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
<#if chainModel>
import lombok.experimental.Accessors;
</#if>
</#if>
<#if cfg.queryColumns??>
import com.yy.generator.annoation.Query;
</#if>

/**
* @author ${author}
* @date ${date}
**/
<#if entityLombokModel>
@Data
<#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
<#else>
@EqualsAndHashCode(callSuper = false)
</#if>
<#if chainModel>
@Accessors(chain = true)
</#if>
</#if>
public class ${entity}QueryCriteria{
<#if cfg.queryColumns??>
    <#list cfg.queryColumns as column>

    @Query(type = Query.Type.${column.queryType},tableColumn="${column.columnName}")
    private ${column.propertyType} ${column.propertyName};
</#list>
</#if>
<#--<#if betweens??>-->
<#--    <#list betweens as column>-->
<#--    /** BETWEEN */-->
<#--    @Query(type = Query.Type.BETWEEN)-->
<#--    private List<${column.columnType}> createTime;-->
<#--    </#list>-->
<#--</#if>-->
}