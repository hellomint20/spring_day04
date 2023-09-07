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
junit : test 진행하기 위한 프레임워크 (기능들의 집합)
test 주도 개발
	단위 테스트, 통합 테스트
 */

@RunWith(SpringRunner.class) //test 어노테이션 붙은 메소드 자동 실행
@ContextConfiguration(locations = {"classpath:testMember.xml", 
								"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) //특정 파일을 불러오는 기능
public class TestMember {
	@Autowired MemberController mc;
	@Test
	public void testMc() {
		//해당 bean이 null이 아니면 성공, null이면 실패
		assertNotNull(mc);
	}
	
	@Autowired MemberService ms;
	@Test
	public void testMs() {
		assertNotNull(ms);
		MemberDTO dto = new MemberDTO();
		dto.setId(2);
		dto.setName("이");
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
		dto.setName("일");
		int result = dao.insertMember(dto);
		System.out.println("result : "+result);
		assertEquals(result, 1);
	}
}
