package jpabook.jpashop.domain.item;

import javax.persistence.Entity;

@Entity
public class Book extends Item{
    private String author;
    private String isbm;
}
