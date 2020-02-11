package com.kodilla.ecommercee.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface OrderListDao extends CrudRepository<OrderList, Integer> {
    List<OrderList> findByListName(String listName);

}
