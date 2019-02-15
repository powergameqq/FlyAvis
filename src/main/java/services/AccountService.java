package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Member;
import model.dao.MemberDAO;

@Transactional
@Service
public class AccountService {
	@Autowired
	MemberDAO md;

	public Member checkAccount(Member mem) {
		List<Member> memList = md.selectByHQL(mem.getUserToken());
		if (memList.size() == 1) {
			mem.setUserId(memList.get(0).getUserId());
			if (mem.getUserName() != memList.get(0).getUserName()
					|| mem.getUserPhoto() != memList.get(0).getUserPhoto()) {
				md.update(mem);
			}
			return mem;
		} else if (memList.size() > 1) {
			throw new RuntimeException("Error,more than one account have a same token");
		} else {
			return null;
		}
	}

	public int createAccount(Member mem) {
		return md.save(mem);
	}

	public Member getAccount(int pk) {
		return md.get(pk);
	}

	public Member checkUserToken(Member mem) {
		Member mb = null;
		List<Member> memList = md.selectByHQL(mem.getUserToken());
		mb = memList.get(0);
		return mb;
	}
}
