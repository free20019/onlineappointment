package com.twkf.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/2/26 - 12:28
 */
@Service
public class JobService{

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<URI> serviceUrl(String serviceName) {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(serviceName);
        List<URI> urlList = new ArrayList<URI>();
        if (CollectionUtils.isNotEmpty(serviceInstanceList)) {
            serviceInstanceList.forEach(si -> {
                urlList.add(si.getUri());
            });
        }
        return urlList;
    }
}
