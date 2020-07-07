package work.ccpw.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 16:57
 **/
public class DateTypeHandler extends BaseTypeHandler<Date> {
    /**
     * 将java类型转换成数据库需要的类型
     *
     * @param preparedStatement
     * @param i
     * @param date
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i, time);
    }

    /**
     * 将数据库中的类型 转换成java类型
     *
     * @param resultSet 查询出的结果集
     * @param s   数据库表中要转换的名称
     * @return 获得结果集中需要的数据类型(Long)转换成Date类型 返回
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        long aLong = resultSet.getLong(s);
        return new Date(aLong);
    }

    /**
     * 将数据库中的类型 转换成java类型
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        return new Date(aLong);
    }

    /**
     * 将数据库中的类型 转换成java类型
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        return new Date(aLong);
    }
}
