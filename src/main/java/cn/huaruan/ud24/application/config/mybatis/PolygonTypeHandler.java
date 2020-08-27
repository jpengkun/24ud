package cn.huaruan.ud24.application.config.mybatis;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@MappedTypes(Polygon.class)
public class PolygonTypeHandler extends BaseTypeHandler<Polygon> {

    private static final Pattern POLYGON = Pattern.compile("[(](\\d+)(.*?)(\\d+)[)]");
    private static final Pattern POINT = Pattern.compile("([\\d]\\d*)(\\.\\d+)? ([\\d]\\d*)(\\.\\d+)?");

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Polygon points, JdbcType jdbcType) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("POLYGON((");
        points.getPoints().forEach(point -> sb.append(point.getX()).append(" ").append(point.getY()).append(","));
        sb.deleteCharAt(sb.length() - 1);
        sb.append("))");
        preparedStatement.setString(1, sb.toString());
    }

    @Override
    public Polygon getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String sPolygon = resultSet.getString(s);
        return convert2Polygon(sPolygon);

    }

    @Override
    public Polygon getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String sPolygon = resultSet.getString(i);
        return convert2Polygon(sPolygon);
    }

    @Override
    public Polygon getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String sPolygon = callableStatement.getString(i);
        return convert2Polygon(sPolygon);
    }

    /**
     * 将数据库中的polygon字符串格式化为polygon
     *
     * @param text 要格式化的字符串
     * @return polygon
     */
    private Polygon convert2Polygon(String text) {
        if (StringUtils.isBlank(text) || !StringUtils.startsWith(text, "POLYGON")) {
            return null;
        }
        Matcher polygonMatcher = POLYGON.matcher(text);
        List<Point> points = new ArrayList<>();
        while (polygonMatcher.find()) {
            Matcher pointMatch = POINT.matcher(polygonMatcher.group());
            while (pointMatch.find()){
                String[] split = pointMatch.group().split(" ");
                Point point = new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                points.add(point);
            }
        }
        return new Polygon(points);
    }
}
