package com.librarymanagement.librarydesign.service;

public interface LibraryCountService {

	Long countLibraries();

	long countLibrariesWithZeroBooks();

}