package com.spt.test.repository;

import com.spt.test.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder, Long> {
}
