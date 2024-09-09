package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {

        System.out.println("===== 제품 목록 =====");
        for(ProductDTO productDTO : allProductList) {
            System.out.println(productDTO);
        }

    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        System.out.println("====== 조회 된 제품 ======");
        System.out.println("Option : " + searchCondition.getOption());
        productList.forEach(System.out::println);

    }

    public void printSuccessMessage(String successCode) {

        System.out.println("===== Success =====");
        String successMessage = "";
        switch (successCode) {
            case "insert":
                successMessage = "신규 제품 등록이 완료 되었습니다."; break;
            case "update" :
                successMessage = "제품 수정이 완료 되었습니다."; break;
            case "delete" :
                successMessage = "제품 삭제가 완료 되었습니다."; break;
        }
        System.out.println(successMessage);

    }

    public void printErrorMessage(String errorCode) {

        System.out.println("===== Error =====");
        String errorMessage = "";
        switch (errorCode) {
            case "selectList":
                errorMessage = "제품 목록 조회에 실패했습니다."; break;
            case "selectOne":
                errorMessage = "제품 코드로 제품 조회에 실패했습니다."; break;
            case "insert":
                errorMessage = "신규 제품 등록에 실패했습니다."; break;
            case "update" :
                errorMessage = "제품 수정에 실패했습니다."; break;
            case "delete" :
                errorMessage = "제품 삭제에 실패했습니다."; break;
        }

        System.out.println(errorMessage);

    }

}