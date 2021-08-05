package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired ItemRepository itemRepository;

    @Test
    public void 책저장() throws Exception{
        //given
        Book book = new Book();
        book.setAuthor("kim");
        book.setIsbn("1234");
        book.setPrice(10000);

        //when
        itemRepository.save(book);

        //then
        assertEquals(10000,itemRepository.findOne(book.getId()).getPrice());
    }
}