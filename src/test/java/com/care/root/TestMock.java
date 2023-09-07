package com.care.root;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import com.care.root.member.Controller.MemberController;

@RunWith(SpringRunner.class) //test ������̼� ���� �޼ҵ� �ڵ� ����
@ContextConfiguration(locations = {"classpath:testMember.xml", 
								"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) //Ư�� ������ �ҷ����� ���
public class TestMock {
	@Autowired MemberController mc;
	MockMvc mock;
	
	@Before
	public void setUp() {
		System.out.println("test ���� �� ����");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	//@Test
	public void testIndex() throws Exception {
		System.out.println("--- test ���� ---");
		
		mock.perform( get("/list"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/list"));
		
		Assert.assertNull(null);
	}
	@Test
	@Transactional( transactionManager = "txMgr")
	public void testInsert() throws Exception {
		mock.perform( post("/insert").param("id", "4").param("name", "��"))
		.andDo(print())
		.andExpect(status().is3xxRedirection() ); //redirect ���� ���
	}
}
