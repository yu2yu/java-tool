package ${package.Controller};

import com.yy.generator.api.CommonResult;
import com.yy.generator.util.QueryParse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import ${cfg.criteria}.${entity}QueryCriteria;

/**
 * @description ${table.comment!} 前端控制器
 * @author ${author}
 * @Date ${date}
 */
@Slf4j
@Api(tags="${table.comment!}")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @ApiOperation(value="${entity}-分页列表查询", notes="${entity}-分页列表查询")
    @GetMapping(value = "/list")
    public CommonResult<?> add(@RequestBody ${entity}QueryCriteria ${entity?uncap_first}QueryCriteria,
                                @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                @RequestParam(name="pageSize", defaultValue="10") Integer pageSize) {
        QueryWrapper<${entity}> queryWrapper =  new QueryParse<${entity}>().parseCriteria(${entity?uncap_first}QueryCriteria);
        Page<${entity}> page = new Page<>(pageNo,pageSize);
        ${table.serviceName?uncap_first}.page(page,queryWrapper);
        return CommonResult.success(page);
    }

    @ApiOperation(value="${entity}-添加", notes="${entity}-添加")
    @PostMapping(value = "/add")
    public CommonResult<?> add(@RequestBody ${entity} ${entity?uncap_first}) {
        ${table.serviceName?uncap_first}.save(${entity?uncap_first});
        return CommonResult.success("添加成功！");
    }

    @ApiOperation(value="${entity}-编辑", notes="${entity}-编辑")
    @PutMapping(value = "/edit")
    public CommonResult<?> edit(@RequestBody ${entity} ${entity?uncap_first}) {
        ${table.serviceName?uncap_first}.updateById(${entity?uncap_first});
        return CommonResult.success("编辑成功!");
    }

    @ApiOperation(value="${entity}-通过id删除", notes="${entity}-通过id删除")
    @DeleteMapping(value = "/delete")
    public CommonResult<?> delete(@RequestParam(name="id",required=true) String id) {
        ${table.serviceName?uncap_first}.removeById(id);
        return CommonResult.success("删除成功!");
    }

    @ApiOperation(value="${entity}-批量删除", notes="${entity}-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public CommonResult<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
        ${table.serviceName?uncap_first}.removeByIds(Arrays.asList(ids.split(",")));
        return CommonResult.success("批量删除成功！");
    }

    @ApiOperation(value="${entity}-通过id查询", notes="${entity}-通过id查询")
    @GetMapping(value = "/queryById")
    public CommonResult<?> queryById(@RequestParam(name="id",required=true) String id) {
        ${entity} ${entity?uncap_first} = ${table.serviceName?uncap_first}.getById(id);
        return CommonResult.success(${entity?uncap_first});
    }
}
</#if>
