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
import com.librarymanagement.librarydesign.service.LibraryCountService;
import com.librarymanagement.librarydesign.service.LibraryCreateService;
import com.librarymanagement.librarydesign.service.LibraryDeleteService;
import com.librarymanagement.librarydesign.service.LibraryExistService;
import com.librarymanagement.librarydesign.service.ReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LibrarydesignApplication implements CommandLineRunner {

	@Autowired
	ReadService readServiceImpl;

	@Autowired
	
	LibraryCreateService libraryCreateServiceImpl;
	
	
	@Autowired
	LibraryCountService  libraryCountServiceImp;
	
	
	@Autowired
	LibraryExistService  libraryExistServiceImpl;
	
	@Autowired
	LibraryDeleteService libraryDeleteServiceImpl;

	public static void main(String[] args) {

		SpringApplication.run(LibrarydesignApplication.class, args);
		System.out.println("WELCOME TO LIBRARY DESIGN MANAGEMENT");
	}

	@Override
	public void run(String... args) throws Exception {
	
	//	readServiceImplMethod();

	//	libraryCreateServiceImpl();
		
	//	libraryCountServiceImp();
		
	//libraryExistServiceImpl();
		
	//	log.info("Delete one library  -> {} ",libraryDeleteServiceImpl.deleteSingleLibrary(Library.builder().id(11l).commaSeparatedBooknames("xyz,abc,efg").name("Z_Space").build()));
		
	//	log.info("Prune Library table -> {} ",libraryDeleteServiceImpl.pruneTable());
		
	/*	List<Library> libraries=new ArrayList<>();
		libraries.add(Library.builder().id(3l).name("C_Space Library").commaSeparatedBooknames("").build());
		libraries.add(Library.builder().id(4l).name("D_Space Library").commaSeparatedBooknames("").build());
		libraries.add(Library.builder().id(5l).name("E_Space Library").commaSeparatedBooknames("").build());
		
		log.info("Delete all this Libraries ->{} ",libraryDeleteServiceImpl.deleteAllThese(libraries) );
		*/
		
	//	log.info("Delete one library  -> {} ",libraryDeleteServiceImpl.deleteAllInBatch());
	//	log.info("Delete  library by id  -> {} ",libraryDeleteServiceImpl.deleteLibraryById(7l));
		
		List<Library> libraries=new ArrayList<>();
		libraries.add(Library.builder().id(3l).name("C_Space Library").commaSeparatedBooknames("").build());
		libraries.add(Library.builder().id(4l).name("D_Space Library").commaSeparatedBooknames("").build());
		libraries.add(Library.builder().id(5l).name("E_Space Library").commaSeparatedBooknames("").build());
		
		log.info("Delete all this Libraries in batch ->{} ",libraryDeleteServiceImpl.deleteAllTheseInBatch(libraries));
		
	}

	private void libraryExistServiceImpl() {
		log.info("Check if library exist by id  -> {} ", libraryExistServiceImpl.checkLibraryExistsById(1l));
		log.info("Check if library exist by id  -> {} ", libraryExistServiceImpl.checkLibraryExistsById(16l));
		
		log.info("Check if library exist by example  -> {} ",libraryExistServiceImpl.checkLibraryExistsByExample("LEARN Python"));
		log.info("Check if library exist by example  -> {} ",libraryExistServiceImpl.checkLibraryExistsByExample("LEARNPython"));
	}

	private void libraryCountServiceImp() {
		log.info("Count the number of Libraries -> {} ",libraryCountServiceImp.countLibraries());
		log.info("Count the number of Libraries with Zero Books -> {} ",libraryCountServiceImp.countLibrariesWithZeroBooks());
	}

	private void libraryCreateServiceImpl() {
		log.info("Persist a single Library -> {} ", libraryCreateServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("M_Library").commaSeparatedBooknames("MAC BOOK").build()));
		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(12l).name("L_Library").commaSeparatedBooknames("APPLE BOOK").build());
		libraries.add(Library.builder().id(13l).name("P_Library").commaSeparatedBooknames("LAPTOP BOOK").build());
		log.info("Persist a single Library -> {} ", libraryCreateServiceImpl.addAllLibraries(libraries));

		log.info("Persist a Library with save And Flush -> {} ", libraryCreateServiceImpl.addLibrarywithSavedAndFlush(
				Library.builder().id(14l).name("P_Library").commaSeparatedBooknames("EYE BOOK").build()));
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
