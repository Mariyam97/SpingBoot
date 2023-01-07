package com.librarymanagement.librarydesign.service;

import java.util.List;

import com.librarymanagement.librarydesign.entity.Library;

public interface LibraryCreateService {

	String addSingleLibrary(Library library);

	String addAllLibraries(List<Library> libraries);

	Library addLibrarywithSavedAndFlush(Library library);

}