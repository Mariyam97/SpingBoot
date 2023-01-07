package com.librarymanagement.librarydesign.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.librarymanagement.librarydesign.entity.Library;
import com.librarymanagement.librarydesign.repository.LibraryRepository;
import com.librarymanagement.librarydesign.service.LibraryCountService;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {

	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public Long countLibraries() {
		return libraryRepository.count();
	}
	
	
	@Override
	public long countLibrariesWithZeroBooks() {
		Library libraryWithZeroBooks = new Library();
		libraryWithZeroBooks.setCommaSeparatedBooknames("");

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithZeroBooks, exampleMatcher);

		return libraryRepository.count(example);
	}
}
