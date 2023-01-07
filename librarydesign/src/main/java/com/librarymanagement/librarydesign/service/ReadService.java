package com.librarymanagement.librarydesign.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.librarymanagement.librarydesign.entity.Library;

public interface ReadService {

	//CREATING READ SERVICE IMPL CLASS
	List<Library> getAllLibrary();

	List<Library> getAllLibrariesWithNoBooks();

	Page<Library> getAllLibrariesPaged();

	Page<Library> getAllLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnPage);

	// Get LIBRARIES WITH LATEST ADDED ORDER METHOD
	List<Library> getLibrariesWithLatestAddedOrder();

	// Get LIBRARIES Custom Sorted By Id METHOD
	List<Library> getLibrariesCustomSortedById(Direction direction);

	// Get LIBRARIES Custom Sorted By NAME METHOD
	List<Library> getLibrariesCustomSortedByName(Direction direction);

	Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBooknames);

	Page<Library> getLibrariesPagedAndSortedByName();

	// get Libraries Custom Paged And Sorted With Default Order By Name And With
	// These Books
	Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeparatedBooknames, int pageNumber, int numberOfRecordsOnPage);

	// get Sorted By Name And With These Books Method
	List<Library> getSortedByNameAndWithTheseBooks(String commaSeparatedBooknames);

	List<Library> getLibrariesByIds(List<Long> ids);

	Optional<Library> getAllLibrariesByIds(Long ids);

	// get  A Library With These Books Method
	Optional<Library> getALibraryWithTheseBooks(String commaSeparatedBooknames);

}