package com.librarymanagement.librarydesign.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.librarymanagement.librarydesign.entity.Library;
import com.librarymanagement.librarydesign.repository.LibraryRepository;
import com.librarymanagement.librarydesign.service.ReadService;

@Service
public class ReadServiceImpl implements ReadService {

	@Autowired
	LibraryRepository readRepository;

//CREATING READ SERVICE IMPL CLASS
	@Override
	public List<Library> getAllLibrary() {

		return readRepository.findAll();
	}

	// GET ALL LIBRARIES WITH NO BOOKS

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeparatedBooknames("");

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);

		return readRepository.findAll(example);
	}

	// GET LIBRARIES PAGED METHOD

	@Override
	public Page<Library> getAllLibrariesPaged() {

		Pageable first4records = PageRequest.of(0, 4);
		return readRepository.findAll(first4records);
	}

	// GET LIBRARIES CUSTOM PAGED METHOD

	@Override
	public Page<Library> getAllLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnPage) {

		Pageable first4records = PageRequest.of(pageNumber, numberOfRecordsOnPage);
		return readRepository.findAll(first4records);
	}

	// Get LIBRARIES WITH LATEST ADDED ORDER METHOD
	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {

		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	// Get LIBRARIES Custom Sorted By Id METHOD
	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direction) {

		return readRepository.findAll(Sort.by(direction, "id"));
	}

	// Get LIBRARIES Custom Sorted By NAME METHOD
	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {

		return readRepository.findAll(Sort.by(direction, "name"));
	}

	// GET LIBRARIES PAGED AND SORTED BY NAME AND WITH THESE BOOKS METHOD

	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBooknames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBooknames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable first4records = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(example, first4records);
	}

	// GET LIBRARIES PAGED AND SORTED BY NAME METHOD

	@Override
	public Page<Library> getLibrariesPagedAndSortedByName() {
		Pageable pagable = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(pagable);

	}

	// get Libraries Custom Paged And Sorted With Default Order By Name And With
	// These Books
	@Override
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeparatedBooknames, int pageNumber, int numberOfRecordsOnPage) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBooknames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable customPage = PageRequest.of(pageNumber, numberOfRecordsOnPage, Sort.by("name"));
		return readRepository.findAll(example, customPage);

	}

	// get Sorted By Name And With These Books Method
	@Override
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeparatedBooknames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBooknames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findAll(example, Sort.by("name"));
	}

	// get Libraries By Ids Method

	@Override
	public List<Library> getLibrariesByIds(List<Long> ids) {
		return readRepository.findAllById(ids);
	}
	
	// get  A Libraries By Ids Method

		@Override
		public Optional<Library> getAllLibrariesByIds(Long ids) {
			return readRepository.findById(ids);
		}
		
		// get  A Library With These Books Method
		@Override
		public Optional<Library>getALibraryWithTheseBooks(String commaSeparatedBooknames) {
			Library libraryWithTheseBooks = new Library();
			libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBooknames);

			ExampleMatcher exampleMatcher = ExampleMatcher.matching()
					.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
					.withIgnorePaths("id", "name");
			Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
			return readRepository.findOne(example);
		}
			
		
		
}
