package com.care.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.care.root.member.Controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

/*
junit : test �����ϱ� ���� �����ӿ�ũ (��ɵ��� ����)
test �ֵ� ����
	���� �׽�Ʈ, ���� �׽�Ʈ
 */

@RunWith(SpringRunner.class) //test ������̼� ���� �޼ҵ� �ڵ� ����
@ContextConfiguration(locations = {"classpath:testMember.xml", 
								"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) //Ư�� ������ �ҷ����� ���
public class TestMember {
	@Autowired MemberController mc;
	@Test
	public void testMc() {
		//�ش� bean�� null�� �ƴϸ� ����, null�̸� ����
		assertNotNull(mc);
	}
	
	@Autowired MemberService ms;
	@Test
	public void testMs() {
		assertNotNull(ms);
		MemberDTO dto = new MemberDTO();
		dto.setId(2);
		dto.setName("��");
		int result = ms.insertMember(dto);
		System.out.println("result : "+result);
		assertEquals(result, 1);
	}
	
	@Autowired MemberDAO dao;
	@Test
	public void testDao() {
		assertNotNull(dao);
		MemberDTO dto = new MemberDTO();
		dto.setId(1);
		dto.setName("��");
		int result = dao.insertMember(dto);
		System.out.println("result : "+result);
		assertEquals(result, 1);
	}
}
