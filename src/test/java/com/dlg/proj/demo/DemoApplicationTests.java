package com.dlg.proj.demo;

import com.dlg.proj.demo.entity.*;
import com.dlg.proj.demo.mapper.*;
import com.dlg.proj.demo.service.GetorderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.dlg.proj.demo.mapper")
public class DemoApplicationTests {
	public static void main(String[] args) {

	}
	@Autowired
	FunctionMapper functionMapper;
	@Autowired
	RoleFunctionMapper roleFunctionMapper;
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	GetorderMapper getorderMapper;
	@Autowired
	GetorderService getorderService;
	@Autowired
	UserMapper userMapper;
	@Test
	public void getall() {


		List<RoleFunction> selbyid = roleFunctionMapper.selbyid(1);
		System.out.println(selbyid);
	}

	@Test
	public void selectAll(){
        long l = System.currentTimeMillis();
         int i = (int)(Math.random()*900 + 100);
        String myStr = Integer.toString(i)+l;
        System.out.println(myStr);

	}

	@Test
	public void selectOrderLoadByState(){
		List<Order> list = orderMapper.selectOrderLoadByState(14);
		System.out.println(list);
	}


}
