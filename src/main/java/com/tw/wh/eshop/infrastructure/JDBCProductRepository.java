package com.tw.wh.eshop.infrastructure;

import com.tw.wh.eshop.domain.product.Product;
import com.tw.wh.eshop.domain.product.ProductRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@Component
public class JDBCProductRepository implements ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JDBCProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Product product) {
        String sql = "INSERT INTO PRODUCT (ID, NAME, PRICE, description, CREATE_AT) VALUES (:id, :name, :price, :description, :createAt) ";
        Map<String, Object> paramMap = of("id", product.getId(),
                "name", product.getName(),
                "price", product.getPrice(),
                "description", product.getDescription(),
                "createAt", product.getCreatedAt());
        jdbcTemplate.update(sql, paramMap);
    }

    public Product byId(String id) {
        try {
            String sql = "SELECT * FROM PRODUCT WHERE ID=:id;";
            return jdbcTemplate.queryForObject(sql, of("id", id.toString()), mapper());
        } catch (EmptyResultDataAccessException e) {
            //TODO
            return null;
        }
    }


    private RowMapper<Product> mapper() {
        return (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getString("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setDescription(rs.getString("description"));
            product.setCreatedAt(rs.getTimestamp("createAt").toInstant());
            return product;
        };
    }

}
