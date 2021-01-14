package com.myapp.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	 @Id
	 @Column(name = "bookID")
	 private int bookID;
	 @Column(name = "publisher")
	 private String publisher;
	 @Column(name = "author")
	 private String author;
	 @Column(name = "price")
	 private int price;
	 @Column(name = "bookName")
	 private String bookName;
	 @Column(name = "bookCategory")
	 private String bookCategory;
	 
	 public Book() {
		 
	 }
	 
	public Book(int bookID, String bookName, String bookcategory, String publisher, String author, int price) {
		super();
		this.bookID = bookID;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.bookName = bookName;
	}
	
	public String getBookName() {
		return bookName;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookCategory == null) ? 0 : bookCategory.hashCode());
		result = prime * result + bookID;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + price;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookCategory == null) {
			if (other.bookCategory != null)
				return false;
		} else if (!bookCategory.equals(other.bookCategory))
			return false;
		if (bookID != other.bookID)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (price != other.price)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}
	
	public Book updateBook(Book newBook) {
		if (newBook.getAuthor() != null && !newBook.getAuthor().trim().isEmpty())
            this.author = newBook.getAuthor();

        if (newBook.getBookCategory() != null && !newBook.getBookCategory().trim().isEmpty())
            this.bookCategory = newBook.getBookCategory();

        if (newBook.getPublisher() != null && !newBook.getPublisher().trim().isEmpty())
            this.publisher = newBook.getPublisher();

        if (newBook.getBookName() != null && !newBook.getBookName().trim().isEmpty())
            this.bookName = newBook.getBookName();
        
        if (newBook.getPrice() != 0 )
            this.price = newBook.getPrice();
		return this;
	}

	 
}
