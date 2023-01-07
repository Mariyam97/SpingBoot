package com.librarymanagement.librarydesign.service;

import java.util.List;

import com.librarymanagement.librarydesign.entity.Library;

public interface LibraryDeleteService {

	String deleteSingleLibrary(Library library);

	String pruneTable();

	String deleteAllThese(List<Library> libraries);

	String deleteAllInBatch();

	String deleteLibraryById(Long id);

	String deleteAllTheseInBatch(List<Library> libraries);

}