package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductService {

    private ProductDAO productDAO;

    public List<ProductDTO> selectAllProductList() {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> prodcutList = productDAO.selectAllProductList();
        sqlSession.close();
        return prodcutList;

    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = productDAO.selectProductByCondition(searchCondition);
        sqlSession.close();
        return productList;

    }

    public boolean registNewProduct(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.insertProduct(product);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0;

    }

    public boolean modifyProductInfo(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.updateProduct(product);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0;


    }

    public boolean deleteProduct(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.deleteProduct(parameter);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0;

    }
}