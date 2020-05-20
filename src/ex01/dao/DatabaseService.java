package ex01.dao;

import ex01.Member;

public interface DatabaseService {
	public boolean insert(Member member);
	public Member select(String id);
}
