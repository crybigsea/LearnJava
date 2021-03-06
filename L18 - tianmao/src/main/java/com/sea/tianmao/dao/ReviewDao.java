package com.sea.tianmao.dao;

import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDao extends JpaRepository<Review, Integer> {
    List<Review> findByProductOrderByIdDesc(Product product);

    int countByProduct(Product product);
}
