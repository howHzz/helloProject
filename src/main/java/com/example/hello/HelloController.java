package com.example.hello;

import com.example.domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass().toString());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String sayHello(){
        List<ServiceInstance> instances = client.getInstances("hello-service");
        for(int i =0;i<instances.size();i++){
            logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
        }
        return "hello world";
    }
    @RequestMapping(value="/hero/{id}",method = RequestMethod.GET)
    public Hero showHero(@PathVariable int id){
        System.out.println("------------------------hero method----------");
        if(id==1)return new Hero(1,"奥巴马","死亡在敲门，错，敲门的人是我");
        else if(id==2)return new Hero(2,"艾克","时间不在于你拥有多少，而在于怎么使用");
        return  new Hero(3,"瑞兹","灾难总是慢我一步");
    }

    @RequestMapping(value="/hero",method = RequestMethod.GET)
    public List<Hero> showAllHero(String ids){
        System.out.println("------------------------get all hero method----------");
        System.out.println("------------------ids :"+ids);
        List<Hero> res = new ArrayList<>();
        res.add(new Hero(1,"奥巴马","死亡在敲门，错，敲门的人是我"));
        res.add(new Hero(2,"艾克","时间不在于你拥有多少，而在于怎么使用"));
        res.add(new Hero(3,"瑞兹","灾难总是慢我一步"));
        return res;
        //hello world
    }
}
