package cn.huaruan.ud24.application.config.mybatis;

import cn.huaruan.ud24.application.common.StringDateParser;
import cn.huaruan.ud24.constant.Annotation;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.Date;
import java.util.List;

/**
 * 扩展 Mybatis-Generator 插件，使其生成的类带有注释、使用lombok、swagger
 * 注意：本类并没有直接被调用，必须将本类以及用到的相关自定义的类一同打包
 * 然后在pom中的 Mybatis-Generator 插件中声明依赖
 * 最后在 mybatis-generator.xml 中添加 <plugin type="xxx" />
 * @author outas
 */
public class MyGeneratorPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 生成类的注释
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* Created by Mybatis Generator ");
        topLevelClass.addJavaDocLine("* Table: " + introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine("* @author outas");
        topLevelClass.addJavaDocLine("* @date " + StringDateParser.dateToString(new Date()));
        topLevelClass.addJavaDocLine("*/");

        // 导入注解包
        topLevelClass.addImportedType(Annotation.DATA.getClazz());
        topLevelClass.addImportedType(Annotation.API_MODEL.getClazz());
        // 生成类使用的注解
        topLevelClass.addAnnotation(Annotation.DATA.getAnnotation());
        topLevelClass.addAnnotation(Annotation.API_MODEL.getAnnotation() + "(\"" + introspectedTable.getRemarks() + "\")");
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean clientGenerated(Interface interfaze,  IntrospectedTable introspectedTable) {
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine("* Created by Mybatis Generator ");
        interfaze.addJavaDocLine("* @author outas");
        interfaze.addJavaDocLine("* @date " + StringDateParser.dateToString(new Date()));
        interfaze.addJavaDocLine("*/");

        interfaze.addImportedType(new FullyQualifiedJavaType(Annotation.REPOSITORY.getClazz()));
        interfaze.addAnnotation(Annotation.REPOSITORY.getAnnotation());
        return super.clientGenerated(interfaze, introspectedTable);
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 追加ApiModelProperty注解
        topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.API_MODEL_PROPERTY.getClazz()));
        field.addAnnotation(Annotation.API_MODEL_PROPERTY.getAnnotation() + "(\"" + introspectedColumn.getRemarks() + "\")");
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }


    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 禁止生成set方法
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 禁止生成get方法
        return false;
    }
}
