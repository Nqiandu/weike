/*
package com.dlg.proj.demo.cloopen;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Userinfos;
import com.taobao.api.request.OpenimUsersAddRequest;
import com.taobao.api.request.OpenimUsersGetRequest;
import com.taobao.api.response.OpenimUsersAddResponse;
import com.taobao.api.response.OpenimUsersGetResponse;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

public class BaichuanTest1 {
    @Test
    public void add() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23325817", "8dfa7bca4a1f1d6cf78d85c1c850327e");
        OpenimUsersAddRequest req = new OpenimUsersAddRequest();
        List<Userinfos> list2 = new ArrayList<Userinfos>();
        Userinfos obj3 = new Userinfos();
        list2.add(obj3);
        obj3.setUserid("qy94_1");
        obj3.setPassword("123456");

        Userinfos obj1 = new Userinfos();
        list2.add(obj1);
        obj1.setUserid("qy94_2");
        obj1.setPassword("123456");

        req.setUserinfos(list2);
        OpenimUsersAddResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());

    }
    @Test
    public void test1() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23325817", "8dfa7bca4a1f1d6cf78d85c1c850327e");
        OpenimUsersGetRequest req = new OpenimUsersGetRequest();
        req.setUserids("qy94_1");
        OpenimUsersGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }

}
*/
