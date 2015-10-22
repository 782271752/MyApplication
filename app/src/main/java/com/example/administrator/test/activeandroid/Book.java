package com.example.administrator.test.activeandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Administrator on 2015/10/21 0021.
 */
@Table(name="Book")
public class Book extends Model{

    public Book(){

    }

    public Book(int bookId,String name,String author){
        this.bookId=bookId;
        bookName=name;
        bookAuthor=author;
    }

    @Column(name="BookId")
    public int bookId;

    @Column(name="BookName")
    public String bookName;

    @Column(name="BookAuthor")
    public String bookAuthor;

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }
}
