package com.librarymanagement.librarydesign.service;

public interface LibraryExistService {

	boolean checkLibraryExistsById(Long Id);

	boolean checkLibraryExistsByExample(String commaSeparatedBooknames);

}