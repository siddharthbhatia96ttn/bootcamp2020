package com.jpa3.Jpa.Assignment3;

import com.jpa3.Jpa.Assignment3.entities.Address;
import com.jpa3.Jpa.Assignment3.entities.Author;
import com.jpa3.Jpa.Assignment3.entities.Books;
import com.jpa3.Jpa.Assignment3.entities.Subjects;
import com.jpa3.Jpa.Assignment3.oneTOmany.entities.Address1toM;
import com.jpa3.Jpa.Assignment3.oneTOmany.entities.Author1toM;
import com.jpa3.Jpa.Assignment3.oneTOmany.entities.Books1toM;
import com.jpa3.Jpa.Assignment3.oneTOmany.entities.Subjects1toM;
import com.jpa3.Jpa.Assignment3.repos.Author1tom;
import com.jpa3.Jpa.Assignment3.repos.AuthorRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class JpaAssignment3ApplicationTests {
	@Autowired
	AuthorRepo repository;

	@Autowired
	Author1tom repoitory2;
	@Test
	void contextLoads() {
	}
	//(iv)
	@Test
	void testInsertionOneToOne()
	{

		Author author1=new Author();
		author1.setAuthorname("Siddharth");
		HashSet<Subjects> addsubjects=new HashSet<>();
		Subjects sub=new Subjects();
		sub.setSub_name("English");
		Subjects sub2=new Subjects();
		sub2.setSub_name("Maths");
		Subjects sub3=new Subjects();
		sub3.setSub_name("Hindi");
		addsubjects.add(sub);
		addsubjects.add(sub2);
		addsubjects.add(sub3);
		sub.setAuthor(author1);
		sub2.setAuthor(author1);
		sub3.setAuthor(author1);
		author1.setSubjects(addsubjects);

		Address address1=new Address();
		address1.setStreetnumber(12);
		address1.setLocation("Shahdara");
		address1.setState("Delhi");
		author1.setAddress(address1);
		author1.setAddress(address1);

		Books book=new Books();
		book.setBook_name("ULike");
		book.setAuthor(author1);
		author1.setBooks(book);
		repository.save(author1);
	}
	@Test
	void testInsertionOneToMany()
	{
		Author1toM author1=new Author1toM();
		author1.setAuthorname("Siddharth");
		HashSet<Subjects1toM> addsubjects=new HashSet<>();
		Subjects1toM sub=new Subjects1toM();
		sub.setSub_name("English");
		Subjects1toM sub2=new Subjects1toM();
		sub2.setSub_name("Maths");
		Subjects1toM sub3=new Subjects1toM();
		sub3.setSub_name("Hindi");
		addsubjects.add(sub);
		addsubjects.add(sub2);
		addsubjects.add(sub3);
		sub.setAuthor(author1);
		sub2.setAuthor(author1);
		sub3.setAuthor(author1);
		author1.setSubjects(addsubjects);

		Address1toM address1=new Address1toM();
		address1.setStreetnumber(12);
		address1.setLocation("Shahdara");
		address1.setState("Delhi");
		author1.setAddress(address1);
		author1.setAddress(address1);
		HashSet<Books1toM>addbooks =new HashSet<>();
		Books1toM book=new Books1toM();
		book.setBook_name("ULike");
		Books1toM book2=new Books1toM();
		book2.setBook_name("Together");
		addbooks.add(book);
		addbooks.add(book2);
		book.setAuthor(author1);
		book2.setAuthor(author1);
		author1.setBooks(addbooks);
		repoitory2.save(author1);
	}
}
