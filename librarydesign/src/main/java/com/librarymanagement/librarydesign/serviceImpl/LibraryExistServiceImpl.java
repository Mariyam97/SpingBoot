package com.librarymanagement.librarydesign.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.librarymanagement.librarydesign.entity.Library;
import com.librarymanagement.librarydesign.repository.LibraryRepository;
import com.librarymanagement.librarydesign.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public boolean checkLibraryExistsById(Long Id) {
		return libraryRepository.existsById(Id);
	}

	@Override
	public boolean checkLibraryExistsByExample(String commaSeparatedBooknames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBooknames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return libraryRepository.exists(example);
	}
}
