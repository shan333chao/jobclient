package com.tutorchat.repository.message;

import com.tutorchat.core.BaseMongoRepository;
import com.tutorchat.domain.HelloWorld;

/**
 * Created by yankun on 2017/6/16.
 */
public interface SlaveRepository extends BaseMongoRepository<HelloWorld, String> {
}
