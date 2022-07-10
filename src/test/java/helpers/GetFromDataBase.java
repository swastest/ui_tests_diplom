package helpers;

import connectBD.DataSourceProvider;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetFromDataBase {
    private DataSource ds = DataSourceProvider.INSTANCE.getDataSource();
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);

    public String findPrice (String city){
        String sqlPrice = "SELECT price_for_hour FROM city WHERE name = :cityName AND removed = false;";
        Map<String, Object> map = new HashMap<>();
        map.put("cityName", city);
        List<String> priceForHour = namedParameterJdbcTemplate.query(sqlPrice, map,
                (rs,i)->rs.getString("price_for_hour"));
        return priceForHour.get(0);
    }

}
