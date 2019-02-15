package retired;

import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.dao.Dao;
import model.dao.MemberDAO;

public class DaoTest {

	public static void main(String[] args) {
		Integer pk = null;
		Member mem = new Member(null,"ddd","aaa","ccccc","asda",null);
		Member getMem;
		Dao <Member>dao = new MemberDAO();
		pk = dao.save(mem);
		if(pk != null) System.out.println("新增成功---------------PK="+pk);
		
		getMem = dao.get(pk);
		System.out.println("查詢成功------------------------gmail=" +getMem.getUserGoogleMail());
		getMem.setUserName("hahaha");
		dao.update(getMem);
		System.out.println("修改成功-----------------------------------------------------------------------");
		
		
		List<Member> memList = new ArrayList<>();
		memList = dao.selectByHQL("aaa");
		System.out.println(memList);
		System.out.println("HQL查詢成功-----------------------------------------------------------------------");
		
//		dao.delete(pk);
//		System.out.println("刪除成功-----------------------------------------------------------------------");
	}

}
