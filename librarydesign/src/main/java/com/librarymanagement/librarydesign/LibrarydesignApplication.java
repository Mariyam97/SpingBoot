package com.librarymanagement.librarydesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.librarymanagement.librarydesign.entity.Library;
import com.librarymanagement.librarydesign.serviceImpl.LibraryCreateServiceImpl;
import com.librarymanagement.librarydesign.serviceImpl.ReadServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LibrarydesignApplication implements CommandLineRunner {

	@Autowired
	ReadServiceImpl readServiceImpl;

	@Autowired
	LibraryCreateServiceImpl libraryCreateServiceImpl;

	public static void main(String[] args) {

		SpringApplication.run(LibrarydesignApplication.class, args);
		System.out.println("WELCOME TO LIBRARY DESIGN MANAGEMENT");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		readServiceImplMethod();

		log.info("Persist a single Library -> {} ", libraryCreateServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("M_Library").commaSeparatedBooknames("MAC BOOK").build()));
		List<Library>libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(12l).name("L_Library").commaSeparatedBooknames("APPLE BOOK").build());
		libraries.add(Library.builder().id(13l).name("P_Library").commaSeparatedBooknames("LAPTOP BOOK").build());
		log.info("Persist a single Library -> {} ", libraryCreateServiceImpl.addAllLibraries(libraries));

	}

	private void readServiceImplMethod() {
		log.info("Fetch all libraries -> {} ", readServiceImpl.getAllLibrary());
		log.info("Fetch all libraries with NO BOOKS -> {} ", readServiceImpl.getAllLibrariesWithNoBooks());
		log.info("Fetch libraries in Page Format -> {} ",
				readServiceImpl.getAllLibrariesPaged().get().collect(Collectors.toList()));
		log.info("Fetch libraries in Custom Page Format -> {} ",
				readServiceImpl.getAllLibrariesCustomPaged(0, 7).get().collect(Collectors.toList()));
		log.info("Fetch  libraries with Latest Added Order -> {} ", readServiceImpl.getLibrariesWithLatestAddedOrder());
		log.info("Fetch  libraries custom sorted by id -> {} ",
				readServiceImpl.getLibrariesCustomSortedById(Direction.ASC));
		log.info("Fetch  libraries custom sorted by id -> {} ",
				readServiceImpl.getLibrariesCustomSortedById(Direction.DESC));
		log.info("Fetch  libraries custom sorted by Name -> {} ",
				readServiceImpl.getLibrariesCustomSortedByName(Direction.ASC));
		log.info("Fetch  libraries custom sorted by Name -> {} ",
				readServiceImpl.getLibrariesCustomSortedByName(Direction.DESC));
		log.info("Fetch  libraries default paged, sorted and with these books -> {} ", readServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("xyz,abc,efg").get().collect(Collectors.toList()));
		log.info("Fetch  libraries default paged and default sorted by name ->{}",
				readServiceImpl.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));
		log.info("Fetch  libraries custom paged and default sorted by name ->{}",
				readServiceImpl
						.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks("xyz,abc,efg", 1, 2)
						.get().collect(Collectors.toList()));
		log.info("Fetch  libraries Sorted by Names -> {} ",
				readServiceImpl.getSortedByNameAndWithTheseBooks("xyz,abc,efg"));

		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);

		log.info("Fetch libraries by ids -> {} ", readServiceImpl.getLibrariesByIds(ids));

		Long id = 12l;
		Optional<Library> optionalLibrary = readServiceImpl.getAllLibrariesByIds(id);
		if (optionalLibrary.isPresent()) {
			log.info("Fetch library by ids -> {} ", optionalLibrary.get());
		} else {
			log.info("No Matching library with this id " + id + " was found in the DB");
		}

		Optional<Library> optionalSingleLibrary = readServiceImpl.getALibraryWithTheseBooks("LEARN MARS");
		if (optionalSingleLibrary.isPresent()) {
			log.info("Fetch  library with these BOOKS -> {} ", optionalSingleLibrary.get());
		} else {
			log.info("No Matching library with this id " + id + " was found in the DB");
		}
	}

}
