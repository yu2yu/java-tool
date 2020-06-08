package com.yy.generator.util;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yy.generator.annoation.Query;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: yy
 * @date: 2020/6/4 13:55
 */
@Slf4j
public class QueryParse<T> {

    public <C> QueryWrapper<T> parseCriteria(C criteria) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
         List<Field> fields = getAllFields(criteria.getClass(), new ArrayList<>());
        for (Field field : fields) {
            boolean accessible = field.isAccessible();
            // 设置对象的访问权限，保证对private的属性的访问
            field.setAccessible(true);
            Query q = field.getAnnotation(Query.class);
            if(q!=null){
                String column = q.tableColumn();
                if(StrUtil.hasBlank(column)){
                    column = field.getName();
                }
                Object val = null;
                try {
                    val = field.get(criteria);
                } catch (IllegalAccessException e) {
                    log.info("{}反射解析filed出错",criteria.toString());
                }
                if(StrUtil.hasBlank(String.valueOf(val))){
                    continue;
                }
                switch (q.type()) {
                    case EQ:
                        queryWrapper.eq(column,val);
                        break;
                    case NE:
                        queryWrapper.ne(column,val);
                        break;
                    case LE:
                        queryWrapper.le(column,val);
                        break;
                    case LT:
                        queryWrapper.lt(column,val);
                        break;
                    case GE:
                        queryWrapper.ge(column,val);
                        break;
                    case GT:
                        queryWrapper.gt(column,val);
                        break;
                    case LIKE:
                        queryWrapper.like(column,val);
                        break;
                    case LIKELEFT:
                        queryWrapper.likeLeft(column,val);
                        break;
                    case LIKERIGHT:
                        queryWrapper.likeRight(column,val);
                        break;
                    case IN:
                        queryWrapper.in(column,val);
                        break;
                    case ISNOTNULL:
                        queryWrapper.isNotNull(column);
                        break;
                    case ISNULL:
                        queryWrapper.isNull(column);
                        break;
                    case BETWEEN:
                        List<Object> between = new ArrayList<>((List<Object>)val);
                        queryWrapper.between(column,between.get(0),between.get(1));
                        break;
                    default: break;
                }
            }
        }
        return queryWrapper;
    }

    private List<Field> getAllFields(Class clazz, List<Field> fields) {
        if (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            getAllFields(clazz.getSuperclass(), fields);
        }
        return fields;
    }
}
