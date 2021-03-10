package org.example.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author XingKe
 * @date 2021-03-08 21:23
 */
public class MyTypeHandler extends BaseTypeHandler<Boolean> {

    // java-DB
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        if (parameter) {
            ps.setInt(i, 1);
        } else {
            ps.setInt(i, 0);
        }
    }

    // DB-java
    @Override
    public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getInt(columnName) == 1 ? true : false;
    }

    //  DB-java
    @Override
    public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getInt(columnIndex) == 1 ? true : false;
    }

    //  java-Db
    @Override
    public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getInt(columnIndex) == 1 ? true : false;
    }
}
