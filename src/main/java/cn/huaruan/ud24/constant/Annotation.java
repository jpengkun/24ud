package cn.huaruan.ud24.constant;

public enum Annotation {
    /**
     * 实体类需要用到的注解
     */
    DATA("@Data", "lombok.Data"),
    REPOSITORY("@Repository", "org.springframework.stereotype.Repository"),
    PARAM("@Param", "org.apache.ibatis.annotations.Param"),
    API_MODEL("@ApiModel", "io.swagger.annotations.ApiModel"),
    API_MODEL_PROPERTY("@ApiModelProperty", "io.swagger.annotations.ApiModelProperty"),
    JSON_FORMAT("@JsonFormat", "com.fasterxml.jackson.annotation.JsonFormat");

    private String annotation;

    private String clazz;
    Annotation(String annotation, String clazz) {
        this.annotation = annotation;
        this.clazz = clazz;
    }

    public String getAnnotation() {
        return annotation;
    }

    public String getClazz() {
        return clazz;
    }
}
