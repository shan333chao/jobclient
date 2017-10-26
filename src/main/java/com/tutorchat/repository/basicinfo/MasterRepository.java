package com.tutorchat.repository.basicinfo;

import com.tutorchat.core.BaseMongoRepository;
import com.tutorchat.domain.HelloWorld;

/**
 * Created by yankun on 2017/6/16.
 */
public interface MasterRepository extends BaseMongoRepository<HelloWorld, String> {
}
