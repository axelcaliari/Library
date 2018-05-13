package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Library implements Cloneable, Iterable<Book> {

	private List<Book> books;

	public Library() {
		this.books = new ArrayList<Book>();
	}

	public Library(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book getBook(String id) {
		for (Book book : this) {
			if (book.getId().equals(id)) {
				return book;
			}
		}
		return null;
	}

	public boolean add(Book book) {
		if (book != null && !this.books.contains(book)) {
			return this.books.add(book);
		}
		return false;
	}

	/**
	 *
	 */
	public boolean remove(String id) {
		return this.books.remove(getBook(id));
	}

	/**
	 *
	 */
	public boolean remove(Book book) {
		return this.books.remove(book);
	}

	/**
	 * supprimer une liste de documents
	 */
	public boolean removeAll(List<Book> books) {
		return this.books.removeAll(books);
	}

	/**
	 * recherche de documents par titre
	 * 
	 * @param title
	 */
	public List<Book> findByTitle(String title) {
		List<Book> res = new ArrayList<Book>();
		for (Book book : this) {
			if (book.getTitle().equals(title)) {
				res.add(book);
			}
		}
		return res;
	}

	/**
	 * recherche de documents par titre
	 * 
	 * @param author
	 */
	public List<Book> findByAuthor(String author) {
		List<Book> res = new ArrayList<Book>();
		for (Book book : this) {
			if (book.getAuthor().equals(author)) {
				res.add(book);
			}
		}
		return res;
	}

	/**
	 * Opérer un tri lexicographique des documents de la bibliothèque
	 */
	public void sort() {
		Collections.sort(this.books);
	}

	/**
	 * Réaliser un clonage profond de votre bibliothèque
	 */
	@Override
	public Library clone() {
		Library clone = new Library();
		for (Book book : books) {
			clone.books.add(book.clone());
		}
		return clone;
	}

	@Override
	public Iterator<Book> iterator() {
		return this.books.iterator();
	}
}